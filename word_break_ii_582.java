/* 
582. Word Break II

Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.
Example

Gieve s = lintcode,
dict = ["de", "ding", "co", "code", "lint"].

A solution is ["lint code", "lint co de"].
*/ 

/* Solution 01: map, memory limited exceed */ 
public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */ 
    List<String> res; 
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here 
        
        res = new ArrayList(); 
        
        if (s == null || wordDict == null) {
            return res; 
        }
        
        Map<Character, List<String>> dict = new HashMap(); 
        
        for (String word : wordDict) { 
            if (word.length() < 1) {
                continue; 
            } 
            
            if (! dict.containsKey(word.charAt(0))) {
                dict.put(word.charAt(0), new ArrayList()); 
            } 
            dict.get(word.charAt(0)).add(word); 
        } 
        
        StringBuilder buffer = new StringBuilder(); 
        searchStringDFS(s, dict, 0, buffer); 
        
        return res;  
    } 
    
    private void searchStringDFS(String s, Map<Character, List<String>> dict, int index, StringBuilder buffer) {
        if (index == s.length()) { 
            res.add(buffer.toString()); 
            return; 
        } 
        
        int i = index; 
        if (! dict.containsKey(s.charAt(i))) {
            return; 
        } 
            
        for (String str : dict.get(s.charAt(i))) { 
            if (str.length() > s.length() - i) { 
                continue; 
            } 
                
            if (! str.equals(s.substring(i, i + str.length()))) {
                continue; 
            } 
                
            int ori_size = buffer.length(); 
            if (ori_size != 0) {
                buffer.append(" "); 
            } 
            buffer.append(str); 
            searchStringDFS(s, dict, i + str.length(), buffer); 
            buffer.delete(ori_size, ori_size + str.length() + 1); 
        } 
    }
} 


/* Solution 02: trie, time limited exceed */ 
class TrieNode {
    TrieNode[] children; 
    String word; 
    
    public TrieNode() {
        this.children = new TrieNode[26]; 
        this.word = null; 
    } 
} 

class Trie {
    TrieNode root; 
    
    public Trie() {
        root = new TrieNode(); 
    } 
    
    public void insert(String word, TrieNode node, int index) {
        if (index == word.length()) {
            node.word = word; 
            return; 
        } 
        
        int tree_index = word.charAt(index) - 'a'; 
        if (node.children[tree_index] == null) {
            node.children[tree_index] = new TrieNode(); 
        } 
        
        insert(word, node.children[tree_index], index + 1); 
    } 
    
    public List<String> startsWith(char c) {
        List<String> buffer = new ArrayList(); 
        
        if (root.children[c - 'a'] == null) {
            return buffer; 
        } 
        
        findAllStrings(root.children[c - 'a'], buffer); 
        
        return buffer; 
    } 
    
    private void findAllStrings(TrieNode node, List<String> buffer) { 
        if (node.word != null) { 
            buffer.add(node.word); 
        } 
        
        for (int i = 0;i < 26;i ++) {
            if (node.children[i] != null) {
                findAllStrings(node.children[i], buffer); 
            }
        }
    }
}

public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */ 
    List<String> res; 
    Trie trie; 
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here 
        
        res = new ArrayList(); 
        
        if (s == null || wordDict == null) {
            return res; 
        } 
        
        /* Map<Character, List<String>> dict = new HashMap(); 
        
        for (String word : wordDict) { 
            if (word.length() < 1) {
                continue; 
            } 
            
            if (! dict.containsKey(word.charAt(0))) {
                dict.put(word.charAt(0), new ArrayList()); 
            } 
            dict.get(word.charAt(0)).add(word); 
        } */ 
        
        trie = new Trie(); 
        for (String word : wordDict) {
            trie.insert(word, trie.root, 0); 
        }
        
        StringBuilder buffer = new StringBuilder(); 
        searchStringDFS(s, 0, buffer); 
        
        return res;  
    } 
    
    private void searchStringDFS(String s, int index, StringBuilder buffer) {
        if (index == s.length()) { 
            res.add(buffer.toString()); 
            return; 
        } 
        
        int i = index; 
        /*if (! dict.containsKey(s.charAt(i))) {
            return; 
        } */
            
        for (String str : trie.startsWith(s.charAt(i))) { 
            if (str.length() > s.length() - i) { 
                continue; 
            } 
                
            if (! str.equals(s.substring(i, i + str.length()))) {
                continue; 
            } 
                
            int ori_size = buffer.length(); 
            if (ori_size != 0) {
                buffer.append(" "); 
            } 
            buffer.append(str); 
            searchStringDFS(s, i + str.length(), buffer); 
            buffer.delete(ori_size, ori_size + str.length() + 1); 
        } 
    }
} 


/* Solution 03: combination-based DFS + memo */ 
class TrieNode {
    TrieNode[] children; 
    String word; 
    
    public TrieNode() {
        this.children = new TrieNode[26]; 
        this.word = null; 
    } 
} 

class Trie {
    TrieNode root; 
    
    public Trie() {
        root = new TrieNode(); 
    } 
    
    public void insert(String word, TrieNode node, int index) {
        if (index == word.length()) {
            node.word = word; 
            return; 
        } 
        
        int tree_index = word.charAt(index) - 'a'; 
        if (node.children[tree_index] == null) {
            node.children[tree_index] = new TrieNode(); 
        } 
        
        insert(word, node.children[tree_index], index + 1); 
    } 
    
    public List<String> startsWith(char c) {
        List<String> buffer = new ArrayList(); 
        
        if (root.children[c - 'a'] == null) {
            return buffer; 
        } 
        
        findAllStrings(root.children[c - 'a'], buffer); 
        
        return buffer; 
    } 
    
    private void findAllStrings(TrieNode node, List<String> buffer) { 
        if (node.word != null) { 
            buffer.add(node.word); 
        } 
        
        for (int i = 0;i < 26;i ++) {
            if (node.children[i] != null) {
                findAllStrings(node.children[i], buffer); 
            }
        }
    }
}

public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */ 
    
    List<String> res_string; 
    
    boolean[] possible; 
    boolean[][] memo; 
    

    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here 
        
        res_string = new ArrayList(); 
        
        if (s == null || wordDict == null) {
            return res_string; 
        } 
        
        memo = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String word = s.substring(i, j + 1);
                memo[i][j] = wordDict.contains(word);
            }
        }
        
        possible = new boolean[s.length() + 1];
        possible[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (memo[i][j] && possible[j + 1]) {
                    possible[i] = true;
                    break;
                }
            }
        }
    
        
        List<Integer> buffer = new ArrayList(); 
        searchStringDFS(s, wordDict, 0, buffer); 

        return res_string;  
    } 
    
    private void searchStringDFS(String s, Set<String> dict, int index, List<Integer> buffer) {
        if (! possible[index]) {
            return;
        } 

        if (index == s.length()) {
            StringBuilder sb = new StringBuilder();
            int lastIndex = 0;
            for (int i = 0; i < buffer.size(); i++) {
                sb.append(s.substring(lastIndex, buffer.get(i)));
                if (i != buffer.size() - 1) sb.append(" ");
                lastIndex = buffer.get(i);
            } 
            System.out.println(sb.toString());
            res_string.add(sb.toString());
            return; 
        }
        
        for (int i = index;i < s.length();i ++) { 
            if (! memo[index][i]) {
                continue; 
            } 

            buffer.add(i + 1); 
            searchStringDFS(s, dict, i + 1, buffer); 
            buffer.remove(buffer.size() - 1); 
        }
    } 
} 
