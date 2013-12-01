public class LRUCache {
    Map<Integer, Integer> pairs;
    LinkedList<Integer> orders;
    int capacity;
    int count;
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
            return;
        }
        if (count >= capacity) {
            pairs.remove(orders.getFirst());
            orders.remove();
            --count;
        }
        orders.addLast(key);
        pairs.put(key, value);
        ++count;
    }
}