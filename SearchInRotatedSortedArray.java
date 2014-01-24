public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int min = 0, max = A.length - 1;
        while (max >= min) {
            int mid = (max + min) / 2;
            if (A[mid] < target) {
                if (A[mid] < A[min] && A[min] <= target) {
                    max = mid - 1;
                }
                else {
                    min = mid + 1;
                }
            }
            else if (A[mid] > target) {
                if (A[mid] > A[max] && A[max] >= target) {
                    min = mid + 1;
                }
                else {
                    max = mid - 1;
                }
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}