public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int min = Integer.MAX_VALUE, result = -1;
        for (int i = 0; i < num.length; ++i) {
            for (int j = i + 1, k = num.length - 1; j < k;) {
                int sum = num[i] + num[j] + num[k];
                int diff = Math.abs(sum - target);
                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum > target) {
                    while (k > j + 1 && num[k] == num[k - 1]) {
                        --k;
                    }
                    --k;
                }
                else {
                    while (j < k - 1 && num[j] == num[j + 1]) {
                        ++j;
                    }
                    ++j;
                }
                
            }
            while (i < num.length - 1 && num[i] == num[i + 1]) {
                ++i;
            }
        }
        return result;
    }
}