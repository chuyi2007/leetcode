public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] num = new int[m + n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                num[i + j + 1] += (num1.charAt(i) - 48) * (num2.charAt(j) - 48);
            }
        }
        
        int carry = 0;
        String result = ""; 
        for (int i = num.length - 1; i > 0; --i) {
            int sum = carry + num[i];
            num[i] = sum % 10;
            carry = sum / 10;
            result = String.valueOf(num[i]) + result;
        }
        if (carry != 0) {
            result = String.valueOf(carry) + result;
        }
        return result;
    }
}