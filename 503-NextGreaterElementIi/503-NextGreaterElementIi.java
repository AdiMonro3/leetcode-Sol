// Last updated: 13/09/2025, 01:49:16
class Solution {
    public int[] nextGreaterElements(int[] nums) {
       
        int n = nums.length;
    int[] res = new int[n];
    Arrays.fill(res, -1);
    Stack<Integer> stack = new Stack<>(); // store indices

    for (int i = 0; i < 2 * n; i++) {
        int curr = nums[i % n];
        while (!stack.isEmpty() && nums[stack.peek()] < curr) {
            res[stack.pop()] = curr;
        }
        if (i < n) stack.push(i);
    }
    return res;
    }
}