public class Solution {
    public String convertToTitle(int n) {
        int scale = 26;
        char base = 'A';
        String result = "";
        while (n > 0) {
            char digit = (char) (base + (n - 1) % scale);
            result = String.valueOf(digit) + result;
            n = (n - 1) / 26;
        }
        return result;
    }
}
