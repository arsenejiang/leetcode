public class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            insert(n);
            return n.value;
        }
        else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            remove(n);
            insert(n);
        }
        else {
            Node n = new Node(key, value);
            if (map.size() == capacity) {
                Node remove = head.next;
                map.remove(remove.key);
                remove(remove);
            }
            
            insert(n);
            map.put(key, n);
        }
    }
    
    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    private void insert(Node n) {
        tail.prev.next = n;
        n.prev = tail.prev;
        n.next = tail;
        tail.prev = n;
    }
    
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}