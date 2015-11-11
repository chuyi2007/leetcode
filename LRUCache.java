import java.util.LinkedHashMap;
public class LRUCache {
    class DListNode {
        DListNode pre;
        DListNode next;
        int key;
        int val;
        public DListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }
    
    private void remove(DListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
    }
    
    private void update(DListNode node) {
        this.remove(node);
        this.addFirst(node);
    }
    
    private DListNode removeFromTail() {
        DListNode pre = tail.pre;
        tail.pre = pre.pre;
        pre.pre.next = tail;
        pre.next = null;
        pre.pre = null;
        return pre;
    }
    
    private void addFirst(DListNode node) {
        DListNode next = head.next;
        next.pre = node;
        node.pre = head;
        head.next = node;
        node.next = next;
    }
    
    private DListNode head;
    private DListNode tail;
    Map<Integer, DListNode> map;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DListNode(0, 0);
        tail = new DListNode(0, 0);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DListNode node = map.get(key);
        update(node);
        return node.val;
    }
    
    public void set(int key, int value) {
        if (!map.containsKey(key)) {
            DListNode node = new DListNode(key, value);
            addFirst(node);
            map.put(key, node);
            if (map.size() > capacity) {
                DListNode removed = removeFromTail();
                map.remove(removed.key);
            }
        } else {
            DListNode node = map.get(key);
            node.val = value;
            update(node);
        }
    }
}
import java.util.LinkedHashMap;
public class LRUCache {
    Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>() {
            @Override
            public boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key);
        map.remove(key);
        map.put(key, val);
        return val;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
        map.put(key, value);
    }
}
