//If use startWith, it's easy
public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (needle.length() == 0) {
            return haystack;
        }
        for (int i = 0; i < haystack.length(); ++i) {
            if (haystack.substring(i).startsWith(needle)) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}

//without using startsWith()
public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (needle.length() == 0) {
	       return haystack;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
            for (int j = 0; j < needle.length(); ++j) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {  
                    break;
                }
                if (j == needle.length() - 1) {
                    return haystack.substring(i);
                }
            }
        }
        return null;
    }
}