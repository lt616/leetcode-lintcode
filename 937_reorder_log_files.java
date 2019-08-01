/* Solution 01: Priority Queue */
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) {
            return new String[0];
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                char cLast1 = s1.charAt(s1.length() - 1);
                char cLast2 = s2.charAt(s2.length() - 1);
                if ('0' <= cLast1 && '9' >= cLast1) {
                    return 1;
                } else if ('0' <= cLast2 && '9' >= cLast2) {
                    return -1;
                }
                
                String id1 = s1.split(" ")[0];
                String id2 = s2.split(" ")[0];
                String word1 = s1.substring(id1.length(), s1.length());
                String word2 = s2.substring(id2.length(), s2.length());
                if (word1.compareTo(word2) == 0) {
                    return id1.compareTo(id2);
                }
                return word1.compareTo(word2);
            }
        });
        
        
        for (String log : logs) {
            pq.offer(log);
        }
        
        String[] results = new String[logs.length];
        int index = 0;
        while (!pq.isEmpty()) {
            System.out.println(index + " " + pq.peek());
            
            results[index ++] = pq.poll();
        }
 
        
        return results;
    }
}