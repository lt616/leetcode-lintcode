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

/* Solution 02: Bidirectional BFS */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /* If endWord is not in the list */
        int num = 0;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord)) {
                num ++;
            }
        }
        
        if (num != 1) {
            System.out.println("match");
            return 0;
        }
        
        Queue<String> queueForward = new LinkedList<>();
        Queue<String> queueBackward = new LinkedList<>();
        
        int level= 0;
        
        Set<String> setForward = new HashSet<>();
        Set<String> setBackward = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        queueForward.add(beginWord);
        setForward.add(beginWord);
        queueBackward.add(endWord);
        setBackward.add(endWord);
        
        while (!queueForward.isEmpty() || !queueBackward.isEmpty()) {
            int levelSizeForward = queueForward.size();
            if (levelSizeForward != 0) level ++;
            for (int i = 0; i < levelSizeForward; i++) {
                String currentWord = queueForward.poll();
                if (visited.contains(currentWord)) {
                    return (visited.contains(currentWord)) ? level - 1 : level;
                }
                visited.add(currentWord);
                for (int j = 0; j < wordList.size(); j++) {
                    if (!setForward.contains(wordList.get(j)) 
                        && !visited.contains(wordList.get(j))
                        && wordDistance(wordList.get(j), currentWord) == 1) {                        
                        queueForward.add(wordList.get(j));
                        setForward.add(wordList.get(j));
                    }
                }
            }
            
            int levelSizeBackward = queueBackward.size();
            if (levelSizeBackward != 0) level ++;
            for (int i = 0; i < levelSizeBackward; i++) {
                String currentWord = queueBackward.poll();
                if (visited.contains(currentWord)) {
                    return (visited.contains(currentWord)) ? level - 1 : level;
                }
                visited.add(currentWord);
                
                for (int j = 0; j < wordList.size(); j++) {
                    if (!setBackward.contains(wordList.get(j))
                        && !visited.contains(wordList.get(j))
                        && wordDistance(wordList.get(j), currentWord) == 1) {
                        queueBackward.add(wordList.get(j));
                        setBackward.add(wordList.get(j));
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