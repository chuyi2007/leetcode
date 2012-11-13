public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i = num.length - 1; i >= 1; --i)
            if(num[i] > num[i - 1]){
                //find the smallest number from i to end which is bigger than i - 1
                for(int j = num.length - 1; j >= i; --j)
                    if(num[j] > num[i - 1]){
                        swap(num, j, i - 1);
                        break;
                    }
                        
                for(int j = num.length - 1, k = i; k < j; ++k, --j)
                    swap(num, j, k);
                break;
            }
            //not found, means descending order of the array
            else if(i == 1)
                for(int j = num.length - 1, k = 0; k < j; ++k, --j)
                    swap(num, j, k);
    }
    
    public void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}