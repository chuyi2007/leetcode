public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> grayCodes = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; ++i) {
            grayCodes.add(i ^ i >> 1);
        }
        return grayCodes;
    }
}
