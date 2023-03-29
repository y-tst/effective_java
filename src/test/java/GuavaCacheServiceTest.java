import com.google.common.cache.RemovalNotification;
import edu.yanchuk.GuavaCacheService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuavaCacheServiceTest {

    private GuavaCacheService cacheService;

    @BeforeEach
    void setUp() {
        cacheService = new GuavaCacheService(10, (RemovalNotification<String, GuavaCacheService.CacheEntry> notification) -> {
        });
    }

    @Test
    void testPutAndGet() {
        cacheService.put("key", "value");
        assertEquals("value", cacheService.get("key"));
    }

    @Test
    void testGetNonExistentKey() {
        assertNull(cacheService.get("nonexistent-key"));
    }

    @Test
    void testPutUpdatesExistingValue() {
        cacheService.put("key", "value1");
        assertEquals("value1", cacheService.get("key"));
        cacheService.put("key", "value2");
        assertEquals("value2", cacheService.get("key"));
    }

    @Test
    void testCacheEviction() throws InterruptedException {
        cacheService.put("key1", "value1");
        cacheService.put("key2", "value2");

        // Wait for cache to expire the entries
        Thread.sleep(11000);

        assertNull(cacheService.get("key1"));
        assertNull(cacheService.get("key2"));
    }

//    @Test
//    void testCacheStatistics() {
//        cacheService.put("key1", "value1");
//        cacheService.put("key2", "value2");
//        cacheService.get("key1");
//
//        assertEquals(2, cacheService.getStatistics().loadCount());
//        assertTrue(cacheService.getStatistics().totalLoadTime() > 0);
//    }
}
