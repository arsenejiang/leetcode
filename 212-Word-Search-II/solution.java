public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                helper(board, i, j, "", root, res);
            }
        }
        
        return res;
    }
    
    private void helper(char[][] board, int i, int j, TrieNode node, List<String> res) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }
        node = node.children[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // de-dup
        }
        
        board[i][j] = '#';
        if (i > 0) {
            helper(board, i - 1, j, node, res);
        }
        if (i < board.length - 1) {
            helper(board, i + 1, j, node, res);
        }
        if (j > 0) {
            helper(board, i, j - 1, node, res);
        }
        if (j < board[0].length - 1) {
            helper(board, i, j + 1, node, res);
        }
        board[i][j] = c;
    }
    
    private void buildTrie(TrieNode root, String[] words) {
        for(String w : words) {
            insertWord(root, w);
        }
    }
    
    private void insertWord(TrieNode root, String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        
        cur.word = word;
    }
    
    class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
}