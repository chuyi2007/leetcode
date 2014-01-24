//Dynamic Programming, O(N)
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<String> code = new HashSet<String>();
        for(int i = 1; i <=26; ++i)
            code.add(String.valueOf(i));
        if(s.length() < 1)
            return 0;
        int f1 = code.contains(s.substring(0, 1)) ? 1 : 0;
        if(s.length() < 2)
            return f1;
        int f2 = (code.contains(s.substring(0, 2)) ? 1 : 0) 
                + (code.contains(s.substring(1, 2)) ? f1 : 0);
        int f3 = f2;
        for (int i = 2; i < s.length(); ++i) {
            f3 = (code.contains(s.substring(i, i + 1)) ? f2 : 0)
                + (code.contains(s.substring(i - 1, i + 1)) ? f1 : 0);
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
//Recursive, O(N^2)
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<String> code = new HashSet<String>();
        for (int i = 1; i <=26; ++i) {
            code.add(String.valueOf(i));
        }
        return numDecoding(s, 0, code);
    }
    
    public int numDecoding(String s, int index, HashSet<String> code) {
        if (index == s.length()) {
            return index == 0 ? 0 : 1;
        }
        int result = 0;
        if (code.contains(s.substring(index, index + 1))) {
            result += numDecoding(s, index + 1, code);
        }
        if (index < s.length() - 1 
            && code.contains(s.substring(index, index + 2))) {
            result += numDecoding(s, index + 2, code);
        }
        return result;
    }
}