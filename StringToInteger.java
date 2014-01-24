//careful about overflow
public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean flag = true;
        str = str.trim();
        if (str.length() < 1) {
           return 0;
        }
        if (str.charAt(0) == '-') {
            flag = false;
            str = str.substring(1);
        }
        else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }

        int result = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                int val = str.charAt(i) - 48;
                if (result > (Integer.MAX_VALUE - val) / 10 && flag) {
                    return Integer.MAX_VALUE;
                }
                else if (-result < (Integer.MIN_VALUE + val) / 10 && !flag) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + val;
            }
            else {
                break;
            }
        }
        return flag ? result : -result;
    }
}