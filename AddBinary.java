public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < Math.max(a.length(), b.length()); ++i){
            int m = 0, n = 0;
            if(i < a.length())
                m = a.charAt(a.length() - i - 1) - 48;
            if(i < b.length())
                n = b.charAt(b.length() - i - 1) - 48;
            int sum = m + n + carry;
            sb.append(sum%2);
            carry = sum / 2;
        }
        if(carry == 1)
            sb.append(carry);
        return sb.reverse().toString();
    }
}