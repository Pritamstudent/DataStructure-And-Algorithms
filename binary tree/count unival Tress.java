/*******************************************************
	Following is the BinaryTreeNode class structure
	
	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
*******************************************************/

public class Solution {
    static int max ;
	public static int countUnivalTrees(BinaryTreeNode<Integer> root) {
		// Write your code here.
		max = 0;
		boolean test = helper(root);
		return max;
		
	}
	static boolean helper(BinaryTreeNode<Integer> root){
		if(root == null){
			return true;
		}
		boolean left = helper(root.left);
		boolean right = helper(root.right);
		if((left == true && right == true) && (root.left == null || root.left.data == root.data) &&
		(root.right == null || root.right.data == root.data) ){
			max++;
			return true;
		}
		return false;
	}

}