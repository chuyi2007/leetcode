public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        Queue<String> startQueue = new LinkedList<String>();
        startQueue.offer(start);
        Set<String> startVisited = new HashSet<String>();
        startVisited.add(start);
        Set<String> startSub = new HashSet<String>();
        
        ArrayList<String> first = new ArrayList<String>();
        first.add(start);
        Queue<ArrayList<String>> children = new LinkedList<ArrayList<String>>();
        children.add(first);
        
        int thisLevel = 1, nextLevel = 0;
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        boolean found = false;
        while (!startQueue.isEmpty()) {
            String word = startQueue.poll();
            ArrayList<String> child = children.poll();
            --thisLevel;
            
            if (end.equals(word)) {
                result.add(child);
                found = true;
            }
            else {
                List<String> replList = getNextLadders(dict, startVisited, startSub, word);
                for (String repl: replList) {
                    startQueue.offer(repl);
                    startVisited.add(repl);
                    startSub.add(repl);
                    
                    //add paths / many duplicates
                    ArrayList<String> newChild = new ArrayList<String>(child);
                    newChild.add(repl);
                    children.offer(newChild);
                        
                    ++nextLevel;
                }
            }
            
            if (thisLevel == 0) {
                thisLevel = nextLevel;
                nextLevel = 0;
                startSub.clear();
                if (found) {
                    break;
                }
            }
        }
        return result;
    }
    
    public List<String> getNextLadders(HashSet<String> dict, 
                                        Set<String> visited, 
                                        Set<String> sub, String word) {
        List<String> replList = new ArrayList<String>();
        for (int i = 0; i < word.length(); ++i) {
            for (int j = 0; j < 26; ++j) {
                char[] chars = word.toCharArray();
                chars[i] = (char) (97 + j);
                String repl = new String(chars);
                if (dict.contains(repl) 
                    && (!visited.contains(repl) || sub.contains(repl))) {
                    replList.add(repl);
                }
            }
        }
        return replList;
    }
}