//O(N^3)
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 1; i < len; ++i){
            for(int j = i + 1; j < len; ++j){
                for(int k = j + 1; k < len; ++k){
                    if(i <= 3 && j - i <= 3 && k - j <=3 && len - k <=3
                    && (i < 2 || s.charAt(0) != '0') && (j - i < 2 || s.charAt(i) != '0')
                    && (k - j < 2 || s.charAt(j) != '0') && (len - k < 2 || s.charAt(k) != '0')){
                        String a = s.substring(0, i);
                        String b = s.substring(i, j);
                        String c = s.substring(j, k);
                        String d = s.substring(k, len);
                        if(Integer.parseInt(a) < 256 && Integer.parseInt(b) < 256
                        && Integer.parseInt(c) < 256 && Integer.parseInt(d) < 256)
                            result.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }
        return result;
    }
}