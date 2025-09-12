// Last updated: 13/09/2025, 01:50:38
class Solution {
    public int findKthLargest(int[] nums, int k) {
          PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
        }
        return minHeap.peek();
    }
}