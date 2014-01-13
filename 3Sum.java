//Do not use extra space, O(N^2), o(N)
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length; ++i) {
            for (int j = i + 1, k = num.length - 1; j < k;) {
                int sum = num[i] + num[j] + num[k];
                if (sum > 0) {
                    --k;
                }
                else if (sum < 0) {
                    ++j;
                }
                else {
                    ArrayList<Integer> result = new ArrayList<Integer>();
                    result.add(num[i]);
                    result.add(num[j]);
                    result.add(num[k]);
                    results.add(result);
                    while (j < k - 1 && num[j] == num[j + 1]) {
                        ++j;
                    }
                    while (k > j + 1 && num[k] == num[k - 1]) {
                        --k;
                    }
                    --k;
                    ++j;
                }
            }
            while (i < num.length - 1 && num[i] == num[i + 1]) {
                ++i;
            }
        }
        return results;
    }
}

//Use Extra Space (HashSet), O(N^2)
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < num.length; i++){
            for(int j = i + 1, k = num.length - 1; j < k;){
                int sum = num[i] + num[j] + num[k];
                if(sum > 0) {
                    --k;
                }
                else if(sum < 0) {
                    ++j;
                }
                else{
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[j]);
                    tmp.add(num[k]);
                    if(!set.contains(tmp)){
                        set.add(tmp);
                        result.add(tmp);
                    }
                    ++j;
                    --k;
                }
            }
        }
        return result;
    }
}