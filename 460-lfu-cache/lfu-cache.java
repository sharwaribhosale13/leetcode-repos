import java.util.*;

class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLL {
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        int size = 0;

        DLL() {
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0)
                return null;

            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    int capacity, minFreq = 0;

    Map<Integer, Node> cache = new HashMap<>();
    Map<Integer, DLL> freqMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        Node node = cache.get(key);

        if (node == null)
            return -1;

        update(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0)
            return;

        Node node = cache.get(key);

        if (node != null) {
            node.value = value;
            update(node);
            return;
        }

        if (cache.size() == capacity) {
            DLL list = freqMap.get(minFreq);
            Node removed = list.removeLast();
            cache.remove(removed.key);

            if (list.size == 0)
                freqMap.remove(minFreq);
        }

        Node newNode = new Node(key, value);

        minFreq = 1;

        freqMap.computeIfAbsent(1, k -> new DLL()).add(newNode);

        cache.put(key, newNode);
    }

    private void update(Node node) {

        int oldFreq = node.freq;

        DLL oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        if (oldList.size == 0) {
            freqMap.remove(oldFreq);

            if (oldFreq == minFreq)
                minFreq++;
        }

        node.freq++;

        freqMap.computeIfAbsent(node.freq, k -> new DLL()).add(node);
    }
}