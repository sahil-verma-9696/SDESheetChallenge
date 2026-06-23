class Solution {
	
	class NumAndIdx {
		int num;
		int row;
		int col;
		
		NumAndIdx(int num, int row, int col) {
			this.num = num;
			this.row = row;
			this.col = col;
		}
	}
	
	public ArrayList<Integer> mergeArrays(int[][] mat) {
		// Code here
		PriorityQueue<NumAndIdx> minHeap = new PriorityQueue<>((a, b)->a.num - b.num);
		ArrayList<Integer> ans = new ArrayList<>();
		
		int n = mat.length;
		int m = mat[0].length;
		
		for (int i = 0; i<n; i++) {
			minHeap.offer(new NumAndIdx(mat[i][0], i, 0));
		}
		
		while(!minHeap.isEmpty()){
		    
		    NumAndIdx cur = minHeap.poll();
		    
		    ans.add(cur.num);
		    
		    int row = cur.row;
		    int col = cur.col + 1;
		    
		    if(col < m){
    		    minHeap.offer(new NumAndIdx(mat[row][col], row, col));
		    } 
		    
		}
		
		return ans;
		
	}
}
