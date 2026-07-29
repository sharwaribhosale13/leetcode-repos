import java.util.*;

class LFUCache {

    class Node {
        int key, value, cnt;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.cnt = 1;
        }
    }

    class DLL {
        int size;
        Node head, tail;

        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void addFront(Node node) {
            Node temp = head.next;
            node.next = temp;
            node.prev = head;
            head.next = node;
            temp.prev = node;
            size++;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    Map<Integer, Node> keyNode;
    Map<Integer, DLL> freqMap;

    int capacity;
    int minFreq;
    int curSize;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        curSize = 0;
        keyNode = new HashMap<>();
        freqMap = new HashMap<>();
    }

    private void update(Node node) {

       

        DLL list = freqMap.get(node.cnt);
        list.removeNode(node);

        if (node.cnt == minFreq && list.size == 0)
            minFreq++;

        node.cnt++;

        DLL newList = freqMap.getOrDefault(node.cnt, new DLL());
        newList.addFront(node);

        freqMap.put(node.cnt, newList);
        keyNode.put(node.key, node);
    }

    public int get(int key) {

        if (!keyNode.containsKey(key))
            return -1;

        Node node = keyNode.get(key);
        update(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0)
            return;

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            update(node);
            return;
        }

        if (curSize == capacity) {
            DLL list = freqMap.get(minFreq);
            keyNode.remove(list.tail.prev.key);
            list.removeNode(list.tail.prev);
            curSize--;
        }

        curSize++;
        minFreq = 1;

        DLL list = freqMap.getOrDefault(1, new DLL());

        Node node = new Node(key, value);
        list.addFront(node);

        keyNode.put(key, node);
        freqMap.put(1, list);
    }
}