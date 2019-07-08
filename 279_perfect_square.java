/* Solution 01: BFS */
class Solution {
    public int numSquares(int n) {
        if (n < 0)
            return 0;
        
        List<Integer> dict = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) 
            dict.add(i * i);
        
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
            
        int level = -1;
        while (! queue.isEmpty()) {
            int levelSize = queue.size();
            level ++;
            for (int i = 0;i < levelSize;i ++) {
                int current = queue.poll();
                if (current == n) {
                    return level;
                }
                for (int j = 0; j < dict.size(); j++) {
                    int newNum = current + dict.get(j); 
                    if (newNum > n || visited[newNum])
                        continue;
                    visited[newNum] = true;
                    queue.add(current + dict.get(j));
                }
            }
        }
        
        return 0;
    }
}