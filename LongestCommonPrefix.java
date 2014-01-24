public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (strs.length < 1) {
            return "";
        }
        String commonFix = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            while (!strs[i].startsWith(commonFix)) {
                commonFix = commonFix.substring(0, commonFix.length() - 1);
            }
        }
        return commonFix;
    }
}