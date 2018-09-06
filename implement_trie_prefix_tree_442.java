/* 
442. Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.
Example

insert("lintcode")
search("code")
>>> false
startsWith("lint")
>>> true
startsWith("linterror")
>>> false
insert("linterror")
search("lintcode)
>>> true
startsWith("linterror")
>>> true

Notice

You may assume that all inputs are consist of lowercase letters a-z.
*/ 

class TrieNode {
    TrieNode[] children; 
    boolean is_word; 
    
    public TrieNode() {
        this.children = new TrieNode[26]; 
        this.is_word = false; 
    } 
    
    public void insert(String word, TrieNode node, int index) {
        int new_index = word.charAt(index) - 'a'; 
        
        if (node.children[new_index] == null) { 
            node.children[new_index] = new TrieNode(); 
        } 
        
        if (index == word.length() - 1) {
            node.children[new_index].is_word = true; 
        } else {
            node.children[new_index].insert(word, node.children[new_index], index + 1); 
        } 
    } 
    
    public boolean search(String word, TrieNode node, int index, boolean is_search) { 
        int new_index = word.charAt(index) - 'a'; 
        
        if (node.children[new_index] == null) { 
            return false; 
        } 
        
        
        if (index == word.length() - 1) { 
            return (is_search) ? node.children[new_index].is_word : true; 
        } 
        
        return search(word, node.children[new_index], index + 1, is_search); 
    } 
} 

public class Trie { 
    TrieNode root; 
    
    public Trie() {
        // do intialization if necessary 
        
        root = new TrieNode(); 
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here 
        
        root.insert(word, root, 0); 
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here 
        
        return root.search(word, root, 0, true); 
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here 
        
        return root.search(prefix, root, 0, false); 
    }
} 
