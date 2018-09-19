/* 
 Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 

The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction. 
*/ 

/* Beat 100% submission! */ 

class Solution { 
    
    Map<String, Double> multiple_effs; 
    Map<String, String> roots; 
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int size = equations.length; 
        
        multiple_effs = new HashMap<String, Double>(); 
        roots = new HashMap<String, String>(); 
        
        for (int i = 0;i < size;i ++) { 
            String A = equations[i][0]; 
            String B = equations[i][1]; 
            if (! roots.containsKey(B)) {
                roots.put(B, B); 
                multiple_effs.put(B, 1.0); 
            } 
            
            if (! roots.containsKey(A)) {
                roots.put(A, B); 
                multiple_effs.put(A, values[i]); 
            } else {
                union(A, B, values[i]); 
            } 
        }     
        
        double[] res = new double[queries.length]; 

        for (int i = 0;i < queries.length;i ++) { 
            String A = queries[i][0]; 
            String B = queries[i][1]; 
            
            if (! roots.containsKey(A) || ! roots.containsKey(B)) { 
                res[i] = -1; 
                continue; 
            } 
            
            if (! find(A).equals(find(B))) {
                res[i] = -1; 
                continue;  
            }
            
            double eff_A = multiple_effs.get(A);  
            double eff_B = multiple_effs.get(B); 
            
            res[i] = eff_A / eff_B; 
         } 
        
        return res; 
    } 
    
    private void union(String a, String b, double eff) {
        String root_a = find(a); 
        String root_b = find(b); 
        
        if (root_a.equals(root_b)) {
            return; 
        } 
        
        double eff_a = multiple_effs.get(a); 
        double eff_b = multiple_effs.get(b); 
        
        roots.put(root_a, root_b); 
        multiple_effs.put(root_a, (eff_b * eff / eff_a)); 
    } 
    
    private String find(String a) { 
        
        String b = roots.get(a);         
        if (b.equals(a)) { 
            return b; 
        } 
        String root = find(roots.get(a));  
        roots.put(a, root); 
        multiple_effs.put(a, multiple_effs.get(a) * multiple_effs.get(b)); 
        
        return root; 
    }
} 
