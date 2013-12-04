public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Set<String> visited = new HashSet<String>();
        Queue<String> path = new LinkedList<String>();
        path.offer(start);
        visited.add(start);
        int level = 1;
        int thisLevel = 1, nextLevel = 0;
        while(!path.isEmpty()) {
            String word = path.poll();
            --thisLevel;
            for (int i = 0; i < word.length(); ++i) {
                for (int j = 0; j < 26; ++j) {
                    char[] chars = word.toCharArray();
                    chars[i] = (char)(97 + j);
                    String repl = new String(chars);
                    if (repl.equals(end)) {
                        return level + 1;    
                    }
                    if (dict.contains(repl) && !visited.contains(repl)) {
                        visited.add(repl);
                        path.offer(repl);
                        ++nextLevel;
                    }
                }
            }
            if (thisLevel == 0) {
                ++level;
                thisLevel = nextLevel;
                nextLevel = 0;
            }
        }
        
        return 0;
    }
}