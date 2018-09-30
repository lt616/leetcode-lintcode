/* 
637. Valid Word Abbreviation

Given a non-empty string word and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Example

Example 1:

Given s = "internationalization", abbr = "i12iz4n":
Return true.

Example 2:

Given s = "apple", abbr = "a2e":
Return false.

Notice

Notice that only the above abbreviations are valid abbreviations of the string word. Any other string is not a valid abbreviation of word.
*/ 

public class Solution {
    /**
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        // write your code here 
        
        if (word == null || abbr == null || abbr.length() > word.length()) {
            return false; 
        } 
        
        int index = 0, skip_value = 0, i = 0; 
        for (i = 0;i < abbr.length();i ++) {
            char abbr_c = abbr.charAt(i); 
            if (abbr_c >= '0' && abbr_c <= '9') {
                skip_value *= 10; 
                skip_value += abbr_c - '0'; 
            } else { 
                index += skip_value; 
                skip_value = 0; 
                if (index == word.length()) { 
                    break; 
                }
                if (index > word.length() || abbr_c != word.charAt(index)) { 
                    System.out.println(index); 
                    return false; 
                } 
                index ++; 
            } 
        } 
        
        if (skip_value != 0) {
            index += skip_value; 
        }
        
        return (index == word.length() && i == abbr.length()); 
    }
} 
