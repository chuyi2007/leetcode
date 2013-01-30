public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] index = {-1, -1};
        int first = binarySearch(A, target - 1);
        int second = binarySearch(A, target);
        if(second == -1 || A[second] != target)
            return index;
        index[0] = first + 1;
        index[1] = second;
        return index;
    }
    
    public int binarySearch(int[] A, int target){
       int min = 0, max = A.length - 1;
        int index = -1;
        while(max >= min){
            int mid = (max + min) / 2;
            if(A[mid] > target) max = mid - 1;
            else{
                index = mid;
                min = mid + 1;
            }
        }
        return index;
    }
}