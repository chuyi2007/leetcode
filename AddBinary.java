public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = Math.max(a.length(), b.length());
        int min = Math.min(a.length(), b.length());
        int carry = 0;
        String result = "";
        for(int i = len - 1; i >= 0; i--){
            int c1 = 0, c2 = 0;
            if(i >= len - a.length())
                c1 = a.charAt(i - (len - a.length())) - 48;
            if(i >= len - b.length())
                c2 = b.charAt(i - (len - b.length())) - 48;
            int sum = c1 + c2 + carry;
            result = String.valueOf(sum%2) + result;
            if(sum >= 2)
                carry = 1;
            else
                carry = 0;
        }
        if(carry == 1)
            result = "1" + result;
        return result;
    }
}