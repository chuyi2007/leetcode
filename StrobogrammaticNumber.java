public class Solution {
    public boolean isStrobogrammatic(String num) {
        int n = num.length();
        for (int i = 0; i < n; ++i) {
            if (num.charAt(i) == '2' ||
                num.charAt(i) == '3' ||
                num.charAt(i) == '4' ||
                num.charAt(i) == '5' ||
                num.charAt(i) == '7') {
                return false;
            } else if (num.charAt(i) == '6') {
                if (num.charAt(n - i - 1) != '9') {
                    return false;
                }
            } else if (num.charAt(i) == '9') {
                if (num.charAt(n - i - 1) != '6') {
                    return false;
                }
            } else {
                if (num.charAt(n - i - 1) != num.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
