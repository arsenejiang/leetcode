public class MedianFinder {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        int maxSize = maxHeap.size();
        int minSize = minHeap.size();
        if (maxSize == minSize) {
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
        int maxSize = maxHeap.size();
        int minSize = minHeap.size();
        if (maxSize == minSize) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        else {
            return maxHeap.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();