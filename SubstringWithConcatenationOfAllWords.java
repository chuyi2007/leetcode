//O(N * k * l) N is length of S, k is length of L, l is word length in L
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        boolean[] map = new boolean[L.length];
        int len = L[0].length();
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (j + len <= S.length()) {
            String word = S.substring(j, j + len);
            boolean found = false;
            for (int k = 0; k < L.length; ++k) {
                if (!map[k] && word.equals(L[k])) {
                    map[k] = true;
                    found = true;
                }
            }
            if (found && checkMap(map)) {
                result.add(i);
                i += 1;
                j = i;
                Arrays.fill(map, false);
            }
            else if (found) {
                j += len;
            }
            else {
                i += 1;
                j = i;
                Arrays.fill(map, false);
            }
        }
        return result;
    }
    
    public boolean checkMap(boolean[] map) {
        for (boolean f : map) {
            if (!f) {
                return false;
            }
        }
        return true;
    }
}