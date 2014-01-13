//O(N^2), o(N)
public class Solution {
    public Integer threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < num.length; ++i) {
            for (int j = i + 1, k = num.length - 1; j < k;) {
                int sum = num[i] + num[j] + num[k];
                int sub = sum - target;
                if(sub > 0) {
                    --k;
                }
                else if(sub < 0) {
                    ++j;
                }
                else{
                    return sum;
                }
                sub = Math.abs(sub);
                if (min > sub) { 
                    min = sub;
                    result = sum;
                }   
            }
            while (i < num.length -1 && num[i] == num[i+1]) {
                ++i;
            }
        }
        return result;
    }
}