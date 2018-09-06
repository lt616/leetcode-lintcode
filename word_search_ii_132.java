/* 
132. Word Search II

Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. One character only be used once in one word.
Example

Given matrix:

doaf
agai
dcan

and dictionary:

{"dog", "dad", "dgdg", "can", "again"}


return {"dog", "dad", "can", "again"} 
*/ 

class TrieNode {
    TrieNode[] children; 
    boolean is_word; 
    int index; 
    
    public TrieNode() {
        this.children = new TrieNode[26]; 
        this.is_word = false; 
        this.index = -1; 
    } 
} 


class Trie {
    TrieNode root; 
    
    public Trie() {
        root = new TrieNode(); 
    } 
    
    public void insert(String word, TrieNode node, int index, int word_index) { 
        if (index == word.length()) { 
            node.is_word = true; 
            node.index = word_index; 
            return; 
        } 
        
        int new_index = word.charAt(index) - 'a'; 
        
        if (node.children[new_index] == null) {
            node.children[new_index] = new TrieNode(); 
        } 
        
        insert(word, node.children[new_index], index + 1, word_index); 
    } 
}


public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */ 
    
    int[] direction_x; 
    int[] direction_y; 
    
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here 
        
        List<String> res = new ArrayList(); 
        
        if (words == null || words.size() == 0) {
            return res; 
        }
        
        if (board == null || board.length == 0 || board[0].length == 0) { 
            return res; 
        } 
        
        direction_x = new int[4]; 
        direction_y = new int[4]; 
        
        direction_x[0] = -1; 
        direction_x[1] = 1; 
        direction_x[2] = 0; 
        direction_x[3] = 0; 
        
        direction_y[0] = 0; 
        direction_y[1] = 0; 
        direction_y[2] = -1; 
        direction_y[3] = 1; 
        
        Trie tree = new Trie(); 
        for (int i = 0;i < words.size();i ++) {
            tree.insert(words.get(i), tree.root, 0, i); 
        } 
        
        Set<String> set = new HashSet(); 
        
        boolean[][] is_visited; 
        for (int i = 0;i < board.length;i ++) { 
            is_visited = new boolean[board.length][board[0].length]; 
            
            for (int j = 0;j < board[0].length;j ++) { 
                List<Integer> buffer = new ArrayList(); 
                search(board, i, j, tree.root, is_visited, buffer); 
                if (buffer.size() != 0) { 
                    for (Integer word_index : buffer) { 
                        if (! set.contains(words.get(word_index))) {
                            res.add(words.get(word_index)); 
                            set.add(words.get(word_index)); 
                        } 
                    } 
                } 
            } 
        } 
        
        return res; 
    } 
    
    private void search(char[][] board, int pos_x, int pos_y, TrieNode root, boolean[][] is_visited, List<Integer> buffer) { 
        if (root.is_word) { 
            buffer.add(root.index); 
        } 
        
        for (int i = 0;i < 4;i ++) {
            int x = pos_x + direction_x[i]; 
            int y = pos_y + direction_y[i]; 
            
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || is_visited[x][y]) {
                continue; 
            } 
            
            char current =  board[x][y]; 
            int new_index = current - 'a'; 
            if (root.children[new_index] == null) {
                continue; 
            } 
            
            is_visited[x][y] = true; 
            
            search(board, x, y, root.children[new_index], is_visited, buffer); 
            
            is_visited[x][y] = false; 
        } 
    } 
} 
