public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int min = 0, max = A.length - 1;
        int index = -1;
        while(max >= min){
            int mid = (max + min) / 2;
            if(A[mid] < A[max])
                if(A[mid] > target || target > A[max]) 
                    max = mid - 1;
                else if(A[mid] < target)    
                    min = mid + 1;
                else    
                    return mid;
            else if(A[mid] > A[min])
                if(A[mid] < target || target < A[min])  
                    min = mid + 1;
                else if(A[mid] > target)    
                    max = mid - 1;
                else    
                    return mid;
            else if(A[mid] > target)
                if(A[max] >= target)
                    min = mid + 1;
                else
                    max = mid - 1;
            else if(A[mid] < target)
                if(A[min] <= target)
                    max = mid - 1;
                else
                    min = mid + 1;
            else
                return mid;
        }
        return index;
    }
}