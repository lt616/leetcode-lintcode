/* Solution 01: BFS */
class Solution {
    Map<Character, List<String>> map;
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        
        initialLetterMapping();
        
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        for (int i = 0; i < digits.length(); i++) {
            int queueSize = queue.size();
            for (int j = 0; j < queueSize; j++) {
                String current = queue.poll();
                for (String letter : map.get(digits.charAt(i))) {
                    queue.offer(current + letter);
                }
            }
        }
        
        while (!queue.isEmpty()) {
            combinations.add(queue.poll());
        }
        
        return combinations;
    }
    
    private void initialLetterMapping() {
        map = new HashMap<>();
        appendLetterMapping('2', Arrays.asList("a", "b", "c"));
        appendLetterMapping('3', Arrays.asList("d", "e", "f"));
        appendLetterMapping('4', Arrays.asList("g", "h", "i"));
        appendLetterMapping('5', Arrays.asList("j", "k", "l"));
        appendLetterMapping('6', Arrays.asList("m", "n", "o"));
        appendLetterMapping('7', Arrays.asList("p", "q", "r", "s"));
        appendLetterMapping('8', Arrays.asList("t", "u", "v"));
        appendLetterMapping('9', Arrays.asList("w", "x", "y", "z"));
    }
    
    private void appendLetterMapping(char num, List<String> list) {
        map.put(num, new ArrayList<String>());
        for (String letter : list) {
            map.get(num).add(letter);
        }
    }
}


/* Solution 02: DFS */
class Solution {
    Map<Character, List<String>> map;
    List<String> combinations;
    public List<String> letterCombinations(String digits) {
        combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        
        initialLetterMapping();

        StringBuilder buffer = new StringBuilder();
        permutateCombinations(digits, 0, buffer);
        
        return combinations;
    }
    
    private void permutateCombinations(String digits, int index, StringBuilder buffer) {
        if (index == digits.length()) {
            combinations.add(buffer.toString());
            return;
        }
        
        for (String letter : map.get(digits.charAt(index))) {
            buffer.append(letter);
            permutateCombinations(digits, index + 1, buffer);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }
    
    private void initialLetterMapping() {
        map = new HashMap<>();
        appendLetterMapping('2', Arrays.asList("a", "b", "c"));
        appendLetterMapping('3', Arrays.asList("d", "e", "f"));
        appendLetterMapping('4', Arrays.asList("g", "h", "i"));
        appendLetterMapping('5', Arrays.asList("j", "k", "l"));
        appendLetterMapping('6', Arrays.asList("m", "n", "o"));
        appendLetterMapping('7', Arrays.asList("p", "q", "r", "s"));
        appendLetterMapping('8', Arrays.asList("t", "u", "v"));
        appendLetterMapping('9', Arrays.asList("w", "x", "y", "z"));
    }
    
    private void appendLetterMapping(char num, List<String> list) {
        map.put(num, new ArrayList<String>());
        for (String letter : list) {
            map.get(num).add(letter);
        }
    }
}
