package org.jasmine;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        System.out.println(23 % 24);
    }

    @Test
    public void candies() {
        int[] ret = distributeCandies(10, 3);
        System.out.println(JSONObject.toJSONString(ret));
    }

    @Test
    public void linkedHashMap() {
        LinkedHashMap ret = new LinkedHashMap();
        ret.put("a", "1");
    }

    @Test
    public void lruCache() {
        JLinkedList<Integer> cache = new JLinkedList<>(2);
        cache.add(1);
        System.out.println(cache);
        cache.add(2);
        System.out.println(cache);

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        System.out.println(list.toString());
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0;
        while (candies != 0) {
            ans[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
            i += 1;
        }
        return ans;
    }

    private boolean goNext(int costed, int candies) {
        return costed < candies;
    }
}
