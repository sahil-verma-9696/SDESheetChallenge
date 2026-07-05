import  java.util.*;

class Node
{
	int data;
	Node left;
	Node right;
	
	Node(int val)
	{
		this.data = val;
		left = null;
		right = null;
	}
}


class Solution {
	public ArrayList<ArrayList<Integer>> Paths(Node root) {
		// code here
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
		dfs(root, ans, new ArrayList<>());
		
		return ans;
	}
	
	public void dfs(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp) {
		if (root == null) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		
		temp.add(root.data);
		
		if(root.left != null)
		dfs(root.left, ans, temp);
		
		if(root.right != null)
		dfs(root.right, ans, temp);
		
		if(root.left == null && root.right == null)
		ans.add(new ArrayList<>(temp));
		
		if (!temp.isEmpty())
			temp.remove(temp.size() - 1);
		
	}
}
