public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if(len3 != len1 + len2)
	    return false;
        if(len1 == 0 || len2 == 0)
	    return s1.equals(s3) || s2.equals(s3);
        if(s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0))
            return isInterleave(s1.substring(1), s2, s3.substring(1))
            || isInterleave(s1, s2.substring(1), s3.substring(1));
        else if(s2.charAt(0) == s3.charAt(0))
            return isInterleave(s1, s2.substring(1), s3.substring(1));
        else if(s1.charAt(0) == s3.charAt(0))
            return isInterleave(s1.substring(1), s2, s3.substring(1));
        else
	    return false;
    }
}