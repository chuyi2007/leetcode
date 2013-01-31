public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < num.length; i++){
            for(int j = i + 1; j < num.length; j++){
                for(int k = j + 1, l = num.length - 1; k < l;){
                    int sum = num[i] + num[j] + num[k] + num[l];
                    int diff = sum - target;
                    if(diff > 0)    l--;
                    else if(diff < 0)   k++;
                    else{
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[k]);
                        tmp.add(num[l]);
                        result.add(tmp);
                        k++;
                        l--;
                    }
                    while(k < l - 1 && num[k] == num[k + 1])
                        k++;
                    while(l > k + 1 && num[l] == num[l - 1])
                        l--;
                }
                while(j < num.length - 1 && num[j] == num[j + 1])
                    j++;
            }
            while(i < num.length - 1 && num[i] == num[i + 1])
                i++;
        }
        return result;
    }
}