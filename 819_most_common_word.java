/* 
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:
Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
*/ 

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split(" "); 
        
        Set<String> banned_hash = new HashSet<String>(); 
        for (String ban_word : banned) {
            banned_hash.add(ban_word); 
        }
        
        int max_freq = Integer.MIN_VALUE; 
        String max_freq_word = ""; 
        Map<String, Integer> map = new HashMap<String, Integer>(); 
        StringBuilder sb = new StringBuilder(); 
        for (char c : (paragraph + ".").toCharArray()) { 
            if (Character.isLetter(c)) {
                sb.append(c); 
            } else if (sb.length() > 0) { 
                String word = sb.toString().toLowerCase(); 

                if (! banned_hash.contains(word)) {
                    int freq = map.getOrDefault(word, 0) + 1; 
                    map.put(word, freq); 

                    if (freq > max_freq) {
                        max_freq = freq; 
                        max_freq_word = word; 
                    }
                } 
                
                sb = new StringBuilder(); 
            } 
        } 
        
        return max_freq_word; 
    }
} 
