//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

//kind of cheating
import java.util.LinkedHashMap;
public class LRUCache {
    private Map<Integer, Integer> pairs;
    private int capacity;
    
    public LRUCache(int c) {
        this.capacity = c;
        this.pairs = new LinkedHashMap<Integer, Integer>() {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        if (pairs.containsKey(key)) {
            int value = pairs.get(key);
            pairs.remove(key);
            pairs.put(key, value);
            return pairs.get(key);
        }
        else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (pairs.containsKey(key)) {
            pairs.remove(key);
        }
        pairs.put(key, value);
    }
}

//can not pass large test
//each operation is O(n)
public class LRUCache {
    Map<Integer, Integer> pairs;
    LinkedList<Integer> orders;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.pairs = new HashMap<Integer, Integer>();
        this.orders = new LinkedList<Integer>();
    }
    
    public int get(int key) {
        if (pairs.containsKey(key)) {
            orders.remove(new Integer(key));
            orders.addLast(key);
            return pairs.get(key);
        }
        else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (pairs.containsKey(key)) {
            pairs.put(key, value);
            orders.remove(new Integer(key));
            orders.addLast(key);
            return;
        }
        if (pairs.size() >= capacity) {
            pairs.remove(orders.removeFirst());
        }
        orders.addLast(key);
        pairs.put(key, value);
    }
}