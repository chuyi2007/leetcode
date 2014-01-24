public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        int n = s.length();
        if (n < 4 || n > 12) {
            return result;
        }
        for (int i = 1; i <= 3 && i < n; ++i) {
            for (int j = i + 1; j <= i + 3 && j < n; ++j) {
                for (int k = j + 1; k <= j + 3 && k < n; ++k) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, n);
                    int x1 = Integer.parseInt(s1);
                    int x2 = Integer.parseInt(s2);
                    int x3 = Integer.parseInt(s3);
                    int x4 = Integer.parseInt(s4);
                    if (x1 <= 255 && x2 <= 255 && x3 <= 255 && x4 <= 255
                    && !(s1.charAt(0) == '0' && i > 1 || s2.charAt(0) == '0' && j - i > 1 
                    || s3.charAt(0) == '0' && k - j > 1 || s4.charAt(0) == '0' && n - k > 1)) {
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return result;
    }
}