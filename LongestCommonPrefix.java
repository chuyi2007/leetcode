public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); ++i) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}

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
