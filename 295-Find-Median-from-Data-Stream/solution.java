public class MedianFinder {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.size() <= minHeap.size()) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        else {
            return minHeap.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();