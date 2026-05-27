class SmallestInfiniteSet {
    private PriorityQueue<Integer> minHeap;
    private Set<Integer> set;
    private int nextSmallest;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        set = new HashSet<>();
        nextSmallest = 1;
    }
    
    public int popSmallest() {
        int next;
        if (!minHeap.isEmpty() && minHeap.peek() < nextSmallest) {
            next = minHeap.poll();
            set.remove(next);
        } else {
            next = nextSmallest;
            nextSmallest++;
        }
        return next;
    }
    
    public void addBack(int num) {
        if (num < nextSmallest && !set.contains(num)) {
            minHeap.offer(num);
            set.add(num);
        }
    }
}
