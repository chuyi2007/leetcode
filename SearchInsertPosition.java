public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int min = 0, max = A.length - 1;
        int index = 0;
        if(target < A[0])   return index;
        while(max >= min){
            int mid = (max + min) / 2;
            if(A[mid] > target)
                max = mid - 1;
            else if(A[mid] < target){
                index = mid + 1;
                min = mid + 1;
            }
            else
                return mid;
        }
        return index;
    }
}