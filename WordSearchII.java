public class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    class Trie {
        TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode node = root;
            for (char c: word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isWord =true;
        }
        
        public boolean search(String word) {
            TrieNode node = root;
            for (char c: word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return node.isWord;
        }
        
        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return true;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }
        
        int m = board.length, n = board[0].length;
        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                DFS(res, board, visited, trie, "", i, j);
            }
        }
        return new ArrayList<>(res);
    }
    
    public void DFS(Set<String> res, char[][] board, boolean[][] visited, Trie trie, String word, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        word += board[i][j];
        if (!trie.startsWith(word)) {
            return;
        }
        if (trie.search(word)) {
            res.add(word);
        }
        visited[i][j] = true;
        DFS(res, board, visited, trie, word, i + 1, j);
        DFS(res, board, visited, trie, word, i - 1, j);
        DFS(res, board, visited, trie, word, i, j - 1);
        DFS(res, board, visited, trie, word, i, j + 1);
        visited[i][j] = false;
    }
}
