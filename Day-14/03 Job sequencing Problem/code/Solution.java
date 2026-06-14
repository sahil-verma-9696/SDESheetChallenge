class Solution {
    
    record Pair(int pro, int d) {}
    
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = profit.length;
        
        Pair[] p = new Pair[n];
        
        for (int i = 0; i < n; i++) {
            p[i] = new Pair(profit[i], deadline[i]);
        }
        
        Arrays.sort(p, (a, b) -> a.d - b.d);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.pro - b.pro);
        
        for (Pair pr : p) {
            int currProfit = pr.pro;
            int currDeadline = pr.d;
            pq.add(pr);
            
            while (pq.size() > currDeadline) {
                pq.poll();
            }
            
            
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(pq.size());
        
        int finalProfit = 0;
        
        while (!pq.isEmpty()) {
            finalProfit += pq.poll().pro;
        }
        
        ans.add(finalProfit);
        
        return ans;
        
        
    }
}