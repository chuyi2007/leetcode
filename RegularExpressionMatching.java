public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return naiveRecursion(s,p,0,0);
    }
    public boolean naiveRecursion(String s, String p, int i, int j){
        //Two edge cases
        if(j == p.length()) return s.length() == i;
        if(j == p.length() - 1)
            return s.length() - 1 == i && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i));
        if(p.charAt(j + 1) != '*'){
            if(i < s.length() && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)))
                return naiveRecursion(s, p, i + 1, j + 1);
            else return false;
        }
        while(i < s.length()&& (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))){
            if(naiveRecursion(s, p, i, j + 2))  return true;
            ++i;
        }
        return naiveRecursion(s, p, i, j + 2);
    }
}