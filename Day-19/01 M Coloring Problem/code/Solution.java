import java.util.*;

class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        
        int[] colorMap = new int[v];
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<v; i++)
        adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int U = edge[0];
            int V = edge[1];
            
            adj.get(U).add(V);
            //adj.get(V).add(U);
        }
        
        
        //System.out.println(adj);
        
        return recur(0, v, m, colorMap, adj);
        
    }
    
    boolean recur(int node, int v, int m, int[] colorMap, List<List<Integer>> adj){
        
        if(node == v)
        return true;
        
        for(int c = 1; c<=m; c++){
            
            if(isAllowed(node, c, colorMap, adj)){
                colorMap[node] = c;
                
               boolean possible = recur(node+1, v, m, colorMap, adj);
            
               if(possible) return true;
               
               colorMap[node] = 0;
            }
            
        }
        
        return false;
        
    }
    
    boolean isAllowed(int node, int color, int[] colorMap, List<List<Integer>> adj){
        List<Integer> adjs = adj.get(node);
        
        for(Integer n : adjs){
            if(colorMap[n] == color){
                return false;
            }
        }
        
        return true;
    }
    
    
}