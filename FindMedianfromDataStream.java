class MedianFinder {
    Queue<Integer> minQueue = new PriorityQueue<>();
    Queue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxQueue.offer(num);
        minQueue.offer(maxQueue.poll());
        if (minQueue.size() > maxQueue.size()) {
            maxQueue.offer(minQueue.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxQueue.size() == minQueue.size()) {
            return (maxQueue.peek() + minQueue.peek()) / 2.0;
        } else {
            return maxQueue.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
