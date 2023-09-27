import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

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
