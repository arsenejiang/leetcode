public class MedianFinder {
    PriorityQueue<Integer> small = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> large = new PriorityQueue<Integer>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (small.size() > large.size()) {
            small.offer(num);
            large.offer(small.poll());
        }
        else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (small.size() == large.size()) {
            int s = small.peek();
            int l = large.peek();
            return s + (double)(l - s) / 2;
        }
        else {
            return small.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();