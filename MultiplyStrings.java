public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] digits = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; --i) {
            for (int j = num2.length() - 1; j >= 0; --j) {
                digits[i + j + 1] += (num1.charAt(i) - 48) * (num2.charAt(j) - 48);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = digits.length - 1; i > 0; --i) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
            sb.append(digits[i]);
        }
        
        if (carry > 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}
