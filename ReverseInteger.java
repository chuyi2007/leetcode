public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean flag = x >= 0?true:false;
        x = Math.abs(x);
        int result = 0;
        while(x > 0){
            result = result * 10 + x % 10;
            x = x/10;
        }
        return flag?result:-result;
        //Use extra space to save as a string
        /*
        boolean flag = x < 0?false:true;
        String s = String.valueOf(Math.abs(x));
        String r = "";
        for(int i = s.length() - 1; i >= 0; --i)
            r += String.valueOf(s.charAt(i));
        int result = Integer.parseInt(r);
        return flag?result:-result;
        */
    }
}