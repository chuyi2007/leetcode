public class Solution {
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> ips = new ArrayList<>();
        for (int i = 1; i <= 3 && i < n; ++i) {
            for (int j = i + 1; j <= i + 3 && j < n; ++j) {
                for (int k = j + 1; k <= j + 3 && k < n; ++k) {
                    if (n - k > 3) {
                        continue;
                    }
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);
                    int int1 = Integer.parseInt(s1);
                    int int2 = Integer.parseInt(s2);
                    int int3 = Integer.parseInt(s3);
                    int int4 = Integer.parseInt(s4);
                    if (int1 <= 255 && int2 <= 255 && int3 <= 255 && int4 <= 255 &&
                        !(s1.charAt(0) == '0' && i > 1) &&
                        !(s2.charAt(0) == '0' && j - i > 1) &&
                        !(s3.charAt(0) == '0' && k - j > 1) &&
                        !(s4.charAt(0) == '0' && n - k > 1)) {
                            ips.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return ips;
    }
}
