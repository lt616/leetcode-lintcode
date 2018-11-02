/* 
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

    All inputs will be in lowercase.
    The order of your output does not matter.
*/ 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>(); 
        if (strs == null || strs.length == 0) {
            return res; 
        } 
        
        Map<String, List<String>> map = new HashMap<String, List<String>>(); 
        for (String str : strs) { 
            String current = sortString(str); 
            if (! map.containsKey(current)) {
                map.put(current, new ArrayList<String>()); 
            } 
            map.get(current).add(str); 
        } 
        
        for (String key : map.keySet()) {
            res.add(map.get(key)); 
        } 
        
        return res; 
    } 
    
    private String sortString(String str) {
        char tempArray[] = str.toCharArray(); 
        Arrays.sort(tempArray); 
        return new String(tempArray); 
    }
} 
