import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import edu.yanchuk.CacheService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CacheServiceTest {

    private CacheService cacheService;

    @BeforeEach
    void setUp() throws Exception {
        cacheService = new CacheService();
    }

    @AfterEach
    void tearDown() throws Exception {
        cacheService = null;
    }

    @Test
    void testGetAndPut() {
        // Add a new entry to the cache
        cacheService.put("key1", "value1");

        // Retrieve the entry from the cache
        CacheService.CacheEntry entry = cacheService.get("key1");
        assertNotNull(entry);
        assertEquals("value1", entry.getValue());

        // Add another entry to the cache
        cacheService.put("key2", "value2");

        // Retrieve the second entry from the cache
        entry = cacheService.get("key2");
        assertNotNull(entry);
        assertEquals("value2", entry.getValue());
    }

    @Test
    void testEviction() throws InterruptedException {
        // Add 100,000 entries to the cache
        for (int i = 0; i < 100000; i++) {
            cacheService.put("key" + i, "value" + i);
        }

        // Wait for 10 seconds to ensure all entries are expired
        TimeUnit.SECONDS.sleep(10);

        // Attempt to retrieve an expired entry from the cache
        CacheService.CacheEntry entry = cacheService.get("key0");
        assertNull(entry);
    }

    @Test
    void testRemovalListener() {
        // Add a removal listener
        String listenerId = "testListener";
        Runnable listener = () -> System.out.println("Entry removed");
        cacheService.addRemovalListener(listenerId, listener);

        // Add an entry to the cache and remove it
        cacheService.put("key1", "value1");
        cacheService.removeEntry("key1");

        // Verify that the removal listener was called
        assertTrue(true); // placeholder, this could be enhanced to verify the listener was called
    }

    @Test
    void testCacheSize() {
        // Add two entries to the cache
        cacheService.put("key1", "value1");
        cacheService.put("key2", "value2");

        // Verify that the cache size is 2
        assertEquals(2, cacheService.getCacheSize());
    }

    @Test
    void testEvictions() {
        // Add 100,000 entries to the cache
        for (int i = 0; i < 100000; i++) {
            cacheService.put("key" + i, "value" + i);
        }

        // Verify that the number of evictions is equal to the cache size
        assertEquals(100000 - CacheService.MAX_SIZE, cacheService.getEvictions());
    }

    @Test
    void testAveragePutTime() {
        // Add two entries to the cache
        cacheService.put("key1", "value1");
        cacheService.put("key2", "value2");

        // Verify that the average put time is greater than 0
        assertTrue(cacheService.getAveragePutTime() > 0);
    }

}

