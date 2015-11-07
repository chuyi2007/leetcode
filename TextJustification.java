public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0, nextLineIndex = 0; i < words.length; i = nextLineIndex) {
            int curLen;
            for (curLen = 0; nextLineIndex < words.length && curLen + words[nextLineIndex].length() <= maxWidth;) {
                curLen += words[nextLineIndex++].length() + 1;
            }
            --curLen;
            int numOfWords = nextLineIndex - i;
            int numOfSpace = 1, extra = 0;
            // not a single word line or last line
            if (numOfWords != 1 && nextLineIndex < words.length) {
                numOfSpace += (maxWidth - curLen) / (numOfWords - 1);
                extra = (maxWidth - curLen) % (numOfWords - 1);
            }
            
            StringBuilder curLine = new StringBuilder();
            for (int j = i; j < nextLineIndex - 1; ++j) {
                curLine.append(words[j]);
                for (int s = numOfSpace; s > 0; --s) {
                    curLine.append(' ');
                }
                if (extra-- > 0) {
                    curLine.append(' ');
                }
            }
            curLine.append(words[nextLineIndex - 1]);
            while (maxWidth > curLine.length()) {
                curLine.append(' ');
            }
            res.add(curLine.toString());
        }
        return res;
    }
}
