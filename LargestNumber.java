public class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Comparator<String> reversed = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String a = s1 + s2;
                String b = s2 + s1;
                return b.compareTo(a);
            }
        };
        Arrays.sort(strNums, reversed);
        if (strNums[0].equals("0")) {
            return "0";
        }
        String res = "";
        for (String part: strNums) {
            res += part;
        }
        return res;
    }
}
