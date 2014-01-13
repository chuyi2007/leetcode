public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < num.length; ++i) {
            for (int j = i + 1; j < num.length; ++j) {
                for (int k = j + 1, l = num.length - 1; l > k;) {
                    int sum = num[i] + num[j] + num[k] + num[l];
                    if (target > sum) {
                        ++k;
                    }
                    else if (target < sum) {
                        --l;
                    }
                    else {
                        ArrayList<Integer> result = new ArrayList<Integer>();
                        result.add(num[i]);
                        result.add(num[j]);
                        result.add(num[k]);
                        result.add(num[l]);
                        results.add(result);
                        while (k < num.length - 1 && num[k] == num[k + 1]) {
                            ++k;
                        }
                        while (l > 0 && num[l] == num[l - 1]) {
                            --l;
                        }
                        ++k;
                        --l;
                    }
                }
                while (j < num.length - 1 && num[j] == num[j + 1]) {
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