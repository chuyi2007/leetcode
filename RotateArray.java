public class Solution {
    public void rotate(int[] nums, int k) {
        //rotateWithBruteForce(nums, k);
        //rotateWithAnotherArray(nums, k);
        rotateInSpace(nums, k);
    }
    
    public void rotateInSpace(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        swapInRange(nums, n - k, n - 1);
        swapInRange(nums, 0, n - k - 1);
        swapInRange(nums, 0, n - 1);
    }
    
    public void swapInRange(int[] nums, int start, int end) {
        for (int i = start; i <= (start + end) / 2; ++i) {
            swap(nums, i, end - i + start);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public void rotateWithAnotherArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] copy = new int[n];
        for (int i = n - k; i < n; ++i) {
            copy[i - n + k] = nums[i];
        }
        for (int i = 0; i < n - k; ++i) {
            copy[i + k] = nums[i];
        }
        for (int i = 0; i < n; ++i) {
            nums[i] = copy[i];
        }
    }
    
    public void rotateWithBruteForce(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        for (int i = n - k; i < n; ++i) {
            int startIndex = i - n + k;
            int tmp = nums[startIndex];
            nums[startIndex] = nums[i];
            for (int j = startIndex + 1; j <= i; ++j) {
                int tmp2 = nums[j];
                nums[j] = tmp;
                tmp = tmp2;
            }
        }
    }
}
