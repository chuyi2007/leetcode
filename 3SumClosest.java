import java.util.HashSet;
public class Solution {
    public Integer threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return didNotUseSet(num, target);
    }
    
    public Integer didNotUseSet(int[] num, int target){
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i < num.length; i++){
            for(int j = i + 1, k = num.length - 1; j < k;){
                int sum = num[i] + num[j] + num[k];
                int sub = sum - target;
                if(sub > 0) k--;
                else if(sub < 0)    j++;
                else{
                    return sum;
                }
                sub = Math.abs(sub);
                if(min > sub){ 
                    min = sub;
                    result = sum;
                }
                //while(j < k - 1 && num[j] == num[j+1])
                //    j++;
                //while(k > j + 1&& num[k] == num[k-1])
                //    k--;
                    
            }
            while(i < num.length -1 && num[i] == num[i+1])
                i++;
        }
        return result;
    }
}