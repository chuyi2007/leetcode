public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] tokens = str.split(" ");
        if (tokens.length != pattern.length()) {
            return false;
        }
        Map map = new HashMap();
        // put will return the previous value associate with key
        for (int i = 0; i < pattern.length(); ++i) {
            if (!Objects.equals(map.put(pattern.charAt(i), i),
                                map.put(tokens[i], i))) {
                return false;
            }
        }
        return true;
        
    }
}
