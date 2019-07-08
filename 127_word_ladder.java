/* Solution 01: BFS */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(beginWord);
        visited.add(beginWord);
        
        int level = 0;
        while (! queue.isEmpty()) {
            int levelSize = queue.size();
            level ++;
            System.out.println(level);
            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return level;
                }
                for (int j = 0; j < wordList.size(); j++) {
                    if (! visited.contains(wordList.get(j)) && wordDistance(currentWord, wordList.get(j)) == 1) {
                        queue.add(wordList.get(j));
                        visited.add(wordList.get(j));
                    }
                }
            }
        }
        
        return 0;
    }
    
    private int wordDistance(String word, String target) {
        int diff = 0;
        for (int i = 0;i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i))
                diff ++;
        }
        return diff;
    }
}