public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (!validInput(str)) {
            return 0;
        }
        int result = 0;
        boolean isNegative = str.charAt(0) == '-' ? true : false;
        for (int i = Character.isDigit(str.charAt(0)) ? 0 : 1; i < str.length(); ++i) {
            if (!Character.isDigit(str.charAt(i))) {
                return isNegative ? -result : result;
            }
            int digit = Character.getNumericValue(str.charAt(i));
            if (!isNegative && (Integer.MAX_VALUE - digit) / 10 < result ) {
                return Integer.MAX_VALUE;
            } else if (isNegative && (Integer.MIN_VALUE + digit) / 10 > -result) {
                return Integer.MIN_VALUE;
            } else {
                result = result * 10 + digit;
            }
        }
        return isNegative ? -result : result;
    }
    
    public boolean validInput(String str) {
        if (str.length() == 0) {
            return false;
        } else if (str.length() == 1) {
            return Character.isDigit(str.charAt(0));
        } else {
            return Character.isDigit(str.charAt(0)) || (str.charAt(0) == '+' || str.charAt(0) == '-' && Character.isDigit(str.charAt(1)));
        }
    }
}
