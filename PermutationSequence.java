public class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            factorial[i] = i * factorial[i - 1];
            digits.add(i);
        }
        StringBuilder sb = new StringBuilder();
        --k;
        for (int i = 1; i <= n; ++i) {
            int index = k / factorial[n - i];
            sb.append(digits.get(index));
            digits.remove(index);
            k -= factorial[n - i] * index;
        }
        return sb.toString();
    }
}
