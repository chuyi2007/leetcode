public class Solution {
    public int findKthLargest(int[] nums, int k) {
        //return minHeap(nums, k);
        return smartQuickSort(nums, k);
    }
    
    public int smartQuickSort(int[] nums, int k) {
        k = nums.length - k;
        int min = 0, max = nums.length - 1;
        while (true) {
            int j = sort(nums, min, max);
            if (j < k) {
                min = j + 1;
            } else if (j > k) {
                max = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    
    public int sort(int[] nums, int min, int max) {
        int i = min, j = max;
        while (true) {
            while (i < max && nums[i] <= nums[min]) {
                ++i;
            }
            while (j > min && nums[j] >= nums[min]) {
                --j;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, min, j);
        return j;
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public int minHeap(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i : nums) {
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
