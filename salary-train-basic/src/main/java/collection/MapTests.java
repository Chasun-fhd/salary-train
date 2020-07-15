package collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: haidong.feng
 * @createdAt: 2020/7/15
 * @description:
 **/
public class MapTests {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(1);
        System.out.println(map.size());
        map.put(1,1);
        System.out.println(map.size());
    }
}
