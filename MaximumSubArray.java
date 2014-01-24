public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return divideAndConquer(A, 0, A.length - 1);
    }
    //O(N)
    public int ONmethod(int[] A) {
       int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < A.length; ++i) {
            sum += A[i];
            if (max < sum) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
    //O(N^2)
    public int divideAndConquer(int[] A, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return A[left];
        }
        
        int mid = (left + right) / 2;
        
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = mid; i >= left; --i) {
            sum += A[i];
            max = Math.max(sum, max);
        }
        
        sum = max;
        for (int i = mid + 1;i <= right; ++i) {
            sum += A[i];
            max = Math.max(sum, max);
        }
        
        int maxInLeft = divideAndConquer(A, left, mid);
        int maxInRight = divideAndConquer(A, mid + 1, right);
        
        return Math.max(max, Math.max(maxInLeft, maxInRight));
    }
}