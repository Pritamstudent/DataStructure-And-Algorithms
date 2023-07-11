/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue <TreeNode> q = new LinkedList<>();
		
        List<List<Integer>>res = new ArrayList<>();
		if(root==null){
			return res;
		}
		q.add(root);
		while(!q.isEmpty()){
            List<Integer> ans = new ArrayList<>();
			int size = q.size();
		    while ( size  > 0){
		    TreeNode temp = q.poll();
			if(temp!=null ){
				ans.add(temp.val);
			}
			if(temp.left!=null){
				q.add(temp.left);
			}
			if(temp.right != null){
				q.add(temp.right);
			}
			size--;
		    }
            res.add(ans);
		    
		}
        Collections.reverse(res);
		return res;
    }
}