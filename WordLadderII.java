public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        // Store the minimum steps required to a specific word
        Map<String, Integer> wordToStep = new HashMap<>();
        for (String w: wordList) {
            wordToStep.put(w, Integer.MAX_VALUE);
        }
        wordToStep.put(beginWord, 0);
        wordToStep.put(endWord, Integer.MAX_VALUE);
        
        // The queue for BFS
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        // Store the neigbors for a given word, backward
        Map<String, List<String>> neighbors = new HashMap<>();
        
        // The step for each level (BFS level)
        int step = 0;
        
        // Minimum step required to reach the end point (endWord)
        int minimumStep = Integer.MAX_VALUE;
        
        while (!q.isEmpty()) {
            String word = q.poll();
            step = wordToStep.get(word) + 1;
            if (step > minimumStep) {
                break;
            }
            
            for (int i = 0; i < word.length(); ++i) {
                StringBuilder tmp = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; ++c) {
                    tmp.setCharAt(i, c);
                    String tmpW = tmp.toString();
                    if (!wordToStep.containsKey(tmpW) || word.equals(tmpW)) {
                        continue;
                    }
                    // This means we do not have to add the word since it will take more steps to reach word then the previous stored steps
                    if (step > wordToStep.get(tmpW)) {
                        continue;
                    } else if (step < wordToStep.get(tmpW)) { // find a shorter path for this word
                        wordToStep.put(tmpW, step + 1);
                        q.offer(tmpW);
                    } // if equal, we don't need to put it again, but we still need it to build the graph
                    
                    if (!neighbors.containsKey(tmpW)) {
                        neighbors.put(tmpW, new ArrayList<>());
                    }
                    neighbors.get(tmpW).add(word);
                    if (tmpW.equals(endWord)) {
                        minimumStep = step;
                    }
                }
            }
        }
        
        // Start with the end of the map to build the List of words
        List<List<String>> res = new ArrayList<>();
        List<String> path = new LinkedList<>();
        backTrack(res, path, beginWord, endWord, neighbors);
        return res;
    }
    
    public void backTrack(
        List<List<String>> res,
        List<String> path,
        String beginWord,
        String curWord,
        Map<String, List<String>> neighbors
    ) {
        if (beginWord.equals(curWord)) {
            path.add(0, beginWord);
            res.add(new ArrayList<>(path));
            path.remove(0);
        } else if (neighbors.containsKey(curWord)) {
            for (String neighbor: neighbors.get(curWord)) {
                path.add(0, curWord);
                backTrack(res, path, beginWord, neighbor, neighbors);
                path.remove(0);
            }
        }
    }
}
