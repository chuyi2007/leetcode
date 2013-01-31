public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; --i){
            int sum = carry + digits[i];
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if(carry == 0)
            return digits;
        else{
            int[] num = new int[digits.length + 1];
            num[0] = carry;
            for(int i = 0; i < digits.length; ++i)
                num[i + 1] = digits[i];
            return num;
        }
    }
}