import java.util.*;

class LFUCache {

    class Node {
        int key, val, freq = 1;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            val = v;
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
            if (size == 0) return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    int cap, minFreq = 0;
    Map<Integer, Node> cache = new HashMap<>();
    Map<Integer, DLL> freqMap = new HashMap<>();

    public LFUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cap == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            update(node);
            return;
        }

        if (cache.size() == cap) {
            Node node = freqMap.get(minFreq).removeLast();
            cache.remove(node.key);
        }

        Node node = new Node(key, value);
        minFreq = 1;
        freqMap.computeIfAbsent(1, k -> new DLL()).add(node);
        cache.put(key, node);
    }

    private void update(Node node) {
        DLL list = freqMap.get(node.freq);
        list.remove(node);

        if (node.freq == minFreq && list.size == 0)
            minFreq++;

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DLL()).add(node);
    }
}