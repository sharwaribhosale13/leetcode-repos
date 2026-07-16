import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
    PriorityQueue<Integer> large = new PriorityQueue<>();                           // Min Heap

    public MedianFinder() {}

    public void addNum(int num) {

        if (small.isEmpty() || num <= small.peek())
            small.offer(num);
        else
            large.offer(num);

        // Balance heaps
        if (small.size() > large.size() + 1)
            large.offer(small.poll());

        if (large.size() > small.size())
            small.offer(large.poll());
    }

    public double findMedian() {

        if (small.size() == large.size())
            return (small.peek() + large.peek()) / 2.0;

        return small.peek();
    }
}