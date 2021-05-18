import indi.eiriksgata.cache.Cache;
import org.junit.jupiter.api.Test;

/**
 * author: create by Keith
 * version: v1.0
 * description: PACKAGE_NAME
 * date: 2021/5/18
 **/
public class CacheTest {


    @Test
    void test1() throws Exception {
        Cache<String> cache = new Cache<>();

        cache.set("abc", "111", 2000);

        cache.set("test1", "abc");

        System.out.println(cache.get("abc"));

        Thread.sleep(3000);

        System.out.println(cache.get("abc"));

        System.out.println(cache.getData());

        Thread.sleep(3000);

        System.out.println(cache.getData());


    }
}
