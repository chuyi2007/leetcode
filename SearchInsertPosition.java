public class Solution {
    public int searchInsert(int[] A, int target) {
        int max = A.length - 1, min = 0;
        int insert = 0;
        while (max >= min) {
            int mid = min + (max - min) / 2;
            if (A[mid] > target) {
                --max;
            }
            else if (A[mid] < target) {
                insert = ++min;
            }
            else {
                return mid;
            }
        }
        return insert;
    }
}