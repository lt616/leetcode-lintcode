class Node {
    char key;
    int val;
    
    public Node(char key, int val) {
        this.key = key;
        this.val = val;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) 
            return 0;
        
        int count = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
                public int compare(Node n1, Node n2) { 
                    return n2.val - n1.val; 
                }
        });
        
        Map<Character, Integer> dict = new HashMap<>();
        for (char task : tasks)
            dict.put(task, dict.getOrDefault(task, 0) + 1);
        
        for (Map.Entry<Character, Integer> entry : dict.entrySet())
            queue.add(new Node(entry.getKey(), entry.getValue()));
        
        n ++;
        while (! queue.isEmpty()) {
            List<Node> cache = new ArrayList<Node>();
            int i = 0;
            while (i < n && !queue.isEmpty()) {
                Node current = queue.poll();
                if (-- current.val >= 1)
                    cache.add(current);
                i ++;
            }
            
            if (queue.isEmpty() && cache.size() == 0) {
                count += i;
                break;
            }
            
            for (i = 0; i < cache.size(); i++)
                queue.add(cache.get(i));
            count += n;
        }
        
        return count;
    }
}