class Node {
    int key;
    int val;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        
        Map<Integer, Integer> dict = new HashMap<>();
        for (int num : nums)
            dict.put(num, dict.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n2.val - n1.val;
            }
        });
        
        for (Map.Entry<Integer, Integer> entry : dict.entrySet())
            queue.add(new Node(entry.getKey(), entry.getValue()));
        
        for (int i = 0; i < k; i++)
            res.add(queue.poll().key);
        
        return res;
    }
}