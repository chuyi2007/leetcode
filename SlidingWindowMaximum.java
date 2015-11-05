public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        // double ended queue to store indices
        Deque<Integer> q = new LinkedList<>();
        int[] maxes = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            // We don't need to add stuff before i < k
            if (i + 1 >= k) {
                maxes[index++] = nums[q.peek()];
            }
        }
        return maxes;
    }
}
