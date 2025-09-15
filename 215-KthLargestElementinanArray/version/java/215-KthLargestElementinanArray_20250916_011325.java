// Last updated: 16/09/2025, 01:13:25
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