//O(N), N is the largest length of a and b
public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Math.max(a.length(), b.length()); ++i) {
            int x = 0, y = 0;
            if (i < a.length()) {
                x = Character.getNumericValue(a.charAt(a.length() - i - 1));
            }
            if (i < b.length()) {
                y = Character.getNumericValue(b.charAt(b.length() - i - 1));
            }
            int sum = x + y + carry;
            int digit = sum % 2;
            result.append(digit);
            carry = sum / 2;
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
