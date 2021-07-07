import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * author: create by Keith
 * version: v1.0
 * description: PACKAGE_NAME
 * date: 2021/5/18
 **/
public class MapTest {

    @Test
    void queueTest() {
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put("test", "abc");

        if (concurrentHashMap.get("aaa") == null) {
            System.out.println("aaa is null");
        }

        System.out.println(concurrentHashMap.get("abc"));
    }



}
