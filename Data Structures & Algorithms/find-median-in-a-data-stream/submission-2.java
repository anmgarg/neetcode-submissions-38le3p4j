class MedianFinder {

    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;

    public MedianFinder() {
        pq1 = new PriorityQueue<>((a,b) -> b-a);
        pq2 = new PriorityQueue<>((a,b) -> a-b);
    }
    
    public void addNum(int num) {
        Integer temp1 = pq1.peek();

        if (temp1 != null && num < temp1) {
            pq1.add(num);
        } else {
            pq2.add(num);
        }
        rebalance();
    }


    private void rebalance() {
        if (Math.abs(pq1.size() - pq2.size()) < 2) {
            return; 
        }
        if (pq1.size() > pq2.size()) {
            pq2.add(pq1.poll());
        } else {
            pq1.add(pq2.poll());
        }
    }
    
    public double findMedian() {
        if (pq1.size() == pq2.size()) {
            return ((double) pq1.peek() + (double) pq2.peek())/2;
        } else if (pq1.size() > pq2.size()) {
            return (double) pq1.peek();
        } else {
            return (double) pq2.peek();
        }
    }
}
