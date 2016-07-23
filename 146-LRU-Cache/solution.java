public class LRUCache {
    int capacity, size;
    Map<Integer, Node> map;
    Node dummyHead, dummyTail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        map = new HashMap<Integer, Node>();
        dummyHead = new Node(0, 0);
        dummyTail = new Node(0, 0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            addToEnd(n);
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
            addToEnd(n);
        }
        else {
            if (size < capacity) {
                Node n = new Node(key, value);
                addToEnd(n);
                map.put(key, n);
                size++;
            }
            else {
                Node removeCandidate = dummyHead.next;
                remove(removeCandidate);
                map.remove(removeCandidate.key);
                Node n = new Node(key, value);
                addToEnd(n);
                map.put(key, n);
            }
        }
    }
    
    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    private void addToEnd(Node n) {
        dummyTail.prev.next = n;
        n.prev = dummyTail.prev;
        n.next = dummyTail;
        dummyTail.prev = n;
    }
    
    public class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}