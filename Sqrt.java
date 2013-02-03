public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int min = 1, max = x;
        int minVal = Integer.MAX_VALUE;
        int root = 0;
        while(max >= min){
            int mid = min + (max - min) / 2;
            int val = mid - x / mid;
            if(val < 0 && -val < minVal){
                minVal = x / mid - mid;
                root = mid;
            }
            if(val > 0) max = mid - 1;
            else if (val < 0)   min = mid + 1;
            else    return mid;
        }
        return root;
    } 
}

public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = x, min = 1;
        int minValue = Integer.MAX_VALUE;
        int root = 0;
        while(min <= max){
            int mid = (max + min)/2;
            int diff = mid * mid - x;
            if(diff <= 0 && -diff < minValue){
                minValue = -diff;
                root = mid;
            }
            if(diff < 0) min = mid + 1;
            else if(diff > 0)    max = mid - 1;
            else    break;
        }
        return root;
    }
}