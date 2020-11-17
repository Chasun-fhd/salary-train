package examples;

import java.util.*;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/2
 * @description:
 **/
public class LRUCache {

    private int capacity;
    private HashMap<Integer, Integer> dictionary;
    private LinkedList<Integer> elements;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dictionary = new HashMap<>();
        elements = new LinkedList<>();
    }

    public int get(int key) {
        if (dictionary.containsKey(key)) {
            elements.remove((Integer) key);
            elements.addFirst(key);
            return dictionary.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (dictionary.containsKey(key)) {
            elements.remove((Integer) key);
            elements.addFirst(key);
            dictionary.put(key, value);
            return;
        }
        if (elements.size() == capacity) {
            dictionary.remove(elements.removeLast());
        }
        dictionary.put(key, value);
        elements.addFirst(key);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */); //null
        System.out.println("null");
        System.out.println(cache.get(2)); //-1

        cache.put(2, 6); //null
        System.out.println("null");

        System.out.println(cache.get(1)); //-1

        cache.put(1, 5);  //null
        System.out.println("null");

        cache.put(1, 2);    //null
        System.out.println("null");

        System.out.println(cache.get(1)); //2
        System.out.println(cache.get(2)); //6
    }
}
