public class Solution {
    public String countAndSay(int n) {
        String lastLine = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder curLineBuilder = new StringBuilder();
            int count = 1;
            for (int j = 0; j < lastLine.length(); ++j) {
                char c = lastLine.charAt(j);
                if (j == lastLine.length() - 1 || lastLine.charAt(j + 1) != c) {
                    curLineBuilder.append(count);
                    curLineBuilder.append(c);
                    count = 1;
                } else {
                    count++;
                }
            }
            lastLine = curLineBuilder.toString();
        }
        return lastLine;
    }
}
