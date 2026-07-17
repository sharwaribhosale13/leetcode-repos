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

    int capacity;
    int minFreq = 0;

    HashMap<Integer, Node> cache = new HashMap<>();
    HashMap<Integer, DLL> freqMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        if (!cache.containsKey(key))
            return -1;

        Node node = cache.get(key);
        update(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0)
            return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            update(node);
            return;
        }

        if (cache.size() == capacity) {
            DLL list = freqMap.get(minFreq);
            Node remove = list.removeLast();
            cache.remove(remove.key);
        }

        Node node = new Node(key, value);

        minFreq = 1;

        DLL list = freqMap.getOrDefault(1, new DLL());
        list.add(node);

        freqMap.put(1, list);

        cache.put(key, node);
    }

    private void update(Node node) {

        int freq = node.freq;

        DLL list = freqMap.get(freq);

        list.remove(node);

        if (freq == minFreq && list.size == 0)
            minFreq++;

        node.freq++;

        DLL newList = freqMap.getOrDefault(node.freq, new DLL());

        newList.add(node);

        freqMap.put(node.freq, newList);
    }
}