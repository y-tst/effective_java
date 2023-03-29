package edu.yanchuk;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.*;

public class CacheService {

    public static final int MAX_SIZE = 100000;
    private static final int EVICTION_INTERVAL_SEC = 5;
    private static final Logger LOGGER = Logger.getLogger(CacheService.class.getName());

    private final ConcurrentHashMap<String, CacheEntry> cache;
    private final ScheduledExecutorService evictionScheduler;
    private final AtomicInteger evictions;
    private final AtomicLong totalPutTime;
    private final ConcurrentHashMap<String, Runnable> removalListeners;

    public CacheService() {
        this.cache = new ConcurrentHashMap<>();
        this.evictionScheduler = Executors.newScheduledThreadPool(1);
        this.evictions = new AtomicInteger(0);
        this.totalPutTime = new AtomicLong(0);
        this.removalListeners = new ConcurrentHashMap<>();
        scheduleEviction();
    }

    private void scheduleEviction() {
        evictionScheduler.schedule(() -> {
            try {
                evictExpiredEntries();
            } finally {
                scheduleEviction();
            }
        }, EVICTION_INTERVAL_SEC, TimeUnit.SECONDS);
    }

    private void evictExpiredEntries() {
        long now = System.currentTimeMillis();
        for (String key : cache.keySet()) {
            CacheEntry entry = cache.get(key);
            if (entry != null && now - entry.getLastAccessTime() >= EVICTION_INTERVAL_SEC * 1000) {
                removeEntry(key);
            }
        }
    }

    public CacheEntry get(String key) {
        CacheEntry entry = cache.get(key);
        if (entry != null) {
            entry.updateLastAccessTime();
            LOGGER.log(Level.INFO, "Cache hit for key " + key);
        } else {
            LOGGER.log(Level.INFO, "Cache miss for key " + key);
        }
        return entry;
    }

    public void put(String key, String value) {
        long startTime = System.nanoTime();
        CacheEntry entry = new CacheEntry(value);
        CacheEntry prevEntry = cache.put(key, entry);
        if (prevEntry != null) {
            removeEntry(key);
        }
        totalPutTime.addAndGet(System.nanoTime() - startTime);
        if (cache.size() > MAX_SIZE) {
            evictOneEntry();
        }
        LOGGER.log(Level.INFO, "Put value for key " + key);
    }

    public void removeEntry(String key) {
        CacheEntry entry = cache.remove(key);
        if (entry != null) {
            evictionListener(key, entry);
        }
    }

    private void evictionListener(String key, CacheEntry entry) {
        evictions.incrementAndGet();
        LOGGER.log(Level.INFO, "Evicted value for key " + key);
        removalListeners.values().forEach(listener -> listener.run());
    }

    private void evictOneEntry() {
        Optional<Map.Entry<String, CacheEntry>> min = cache.entrySet().stream()
                .min(Comparator.comparingLong(entry -> entry.getValue().getLastAccessTime()));
        if (min.isPresent()) {
            removeEntry(min.get().getKey());
        }
    }

    public int getCacheSize() {
        return cache.size();
    }

    public int getEvictions() {
        return evictions.get();
    }

    public double getAveragePutTime() {
        long count = cache.size();
        if (count == 0) {
            return 0.0;
        }
        return totalPutTime.get() / (double) count;
    }

    public void addRemovalListener(String id, Runnable listener) {
        removalListeners.put(id, listener);
    }

    public void removeRemovalListener(String id) {
        removalListeners.remove(id);
    }

    public static class CacheEntry {
        private final String value;
        private long lastAccessTime;

        public CacheEntry(String value) {
            this.value = value;
            this.lastAccessTime = System.currentTimeMillis();
        }

        public String getValue() {
            return value;
        }

        public long getLastAccessTime() {
            return lastAccessTime;
        }

        public void updateLastAccessTime() {
            lastAccessTime = System.currentTimeMillis();
        }
    }
}
