class TrieNode {
    TrieNode[] children;
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}
public class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 97;
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word.length() == 0) {
            return true;
        }
        return search(word, root);
    }
    
    private boolean search(String word, TrieNode node) {
        char c = word.charAt(0);
        if (c == '.') {
            for (int i = 0; i < 26; ++i) {
                TrieNode cur = node.children[i];
                if (cur != null) {
                    if (word.length() == 1 && cur.isWord) {
                        return true;
                    } else if (word.length() > 1 && search(word.substring(1), cur)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            TrieNode cur = node.children[c - 97];
            if (cur == null) {
                return false;
            }
            return word.length() == 1 ? cur.isWord : search(word.substring(1), cur);
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
