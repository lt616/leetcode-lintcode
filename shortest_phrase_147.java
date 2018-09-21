/* 
1474. Shortest Phrase

We stipulate that in an article, a phrase should consists of at least k consecutive words, and its total length should not less than lim. Given an article in form of a string array str, and you should output the length of the shortest phrase in this article.
Example

Givenk=2,lim=7,str=["i","love","lintcode","so","much"],return10

Explanation：
The shortest phrase is"lintcode""so".Note that although "lintcode" is longer than `lim`,however it only contains one word, so it is not a phrase.

Givenk = 2,lim = 10,str = ["she","was","bad","in","singing"],return11

Explanation：
The shortest phrase is "she""was""bad""in",and the length of it is 11. Note that "she""singing" satisfies that the number of words it contains >=`k` and its length>=`lim`, but these two words are not continuous in the text.

Notice

    It is guaranteed that all words contain only lowercase English letters.
    It is guaranteed that the sum of words' length does not exceed 3e5.
    It is guaranteed that the number of words does not exceed 3e5.
    It is guaranteed there will be at least one phrase in the article.
    The length of the phrase is the sum of the lengths of the words it contains
*/ 

public class Solution {
    /**
     * @param k: The number of words in the article
     * @param lim: TThe minimum number of words a phrase should contain 
     * @param str: The article
     * @return: Return the length of shortest phrase
     */ 
    
    int min_len; 
    
    public int getLength(int k, int lim, String[] str) {
        // Write your code here 
        
        List<Integer> str_lens = new ArrayList(); 
        for (String one_str : str) {
            str_lens.add(one_str.length()); 
        } 
        
        min_len = Integer.MAX_VALUE; 
        
        int j = -1; 
        int sum = 0; 
        for (int i = 0;i < str.length;i ++) {
            while (j + 1 < str.length && (j - i + 1 < k || sum < lim)) {
                j ++; 
                sum += str_lens.get(j); 
            } 
            if (sum >= lim && j - i + 1 >= k) {
                min_len = (sum < min_len) ? sum : min_len; 
            } 
            
            sum -= str_lens.get(i); 
        }
        
        return min_len; 
    } 
} 
