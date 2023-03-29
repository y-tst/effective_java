package edu.yanchuk;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;

public class GuavaCacheService {

    private final Cache<String, CacheEntry> cache;
    private final CacheStats statistics;
    private final RemovalListener<String, CacheEntry> removalListener;

    public GuavaCacheService(long maxIdleTime, RemovalListener<String, CacheEntry> removalListener) {
        this.cache = CacheBuilder.newBuilder()
                .maximumSize(100000)
                .expireAfterAccess(maxIdleTime, TimeUnit.SECONDS)
                .removalListener(removalListener)
                .build();
        this.statistics = new CacheStats();
        this.removalListener = removalListener;
    }

    public void put(String key, String value) {
        long start = System.currentTimeMillis();

        CacheEntry entry = new CacheEntry(value);
        cache.put(key, entry);

        statistics.recordLoadSuccess(System.currentTimeMillis() - start);
    }

    public String get(String key) {
        long start = System.currentTimeMillis();

        CacheEntry entry = cache.getIfPresent(key);
        if (entry == null) {
            statistics.recordMisses(1);
            return null;
        }

        statistics.recordHits(1);
        statistics.recordLoadSuccess(System.currentTimeMillis() - start);
        return entry.getValue();
    }

    public CacheStats getStatistics() {
        return statistics;
    }

    public static class CacheEntry {
        private final String value;
        private final long lastAccessTime;

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
    }

    public static class CacheStats {
        private long hits;
        private long misses;
        private long totalLoadTime;
        public long loadCount;

        public CacheStats() {
            this.hits = 0;
            this.misses = 0;
            this.totalLoadTime = 0;
            this.loadCount = 0;
        }

        public void recordHits(int count) {
            this.hits += count;
        }

        public void recordMisses(int count) {
            this.misses += count;
        }

        public void recordLoadSuccess(long loadTime) {
            this.totalLoadTime += loadTime;
            this.loadCount++;
        }

        public long requestCount() {
            return this.hits + this.misses;
        }

        public long hitCount() {
            return this.hits;
        }

        public long missCount() {
            return this.misses;
        }

        public long totalLoadTime() {
            return this.totalLoadTime;
        }

        public double averageLoadPenalty() {
            return this.loadCount == 0 ? 0.0 : (double) this.totalLoadTime / this.loadCount;
        }

        public long loadCount() {
            return 0;
        }
    }
}


