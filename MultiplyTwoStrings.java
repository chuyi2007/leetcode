public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] product = new int[num1.length() + num2.length()];
        //in case overflow
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        for(int i = num1.length() - 1; i >= 0; --i){
            for(int j = num2.length() - 1; j >= 0; --j){
                int a = num1.charAt(i) - 48, b = num2.charAt(j) - 48;
                product[i + j + 1] += a * b;
            }
        }

        int carry = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = product.length - 1; i >= 1; --i){
            int sum = product[i] + carry;
            product[i] = sum % 10;
            carry = sum / 10;
            sb.append(product[i]);
        }
        if(carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}