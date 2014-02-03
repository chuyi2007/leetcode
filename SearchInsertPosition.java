public class Solution {
    public int searchInsert(int[] A, int target) {
        int max = A.length - 1, min = 0;
        int pos = 0;
        if (A[0] > target) {
            return 0;
        }
        while (max >= min) {
            int mid = (max + min) / 2;
            if (A[mid] > target) {
                max = mid - 1;
            }
            else if (A[mid] < target) {
                pos = mid + 1;
                min = mid + 1;
            }
            else {
                return mid;
            }
        }
        return pos;
    }
}