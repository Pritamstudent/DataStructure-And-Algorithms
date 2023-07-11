/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        return helper(root,p,q);
    }
    static TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return root;
        }
        
        if(root.val == p.val ){
            return root;
        }
        if( root.val == q.val){
            return root;
        }
        if(root.left == null && root.right == null){
            return null;
        }
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if(left!=null && right != null){
            return root;
        }
        return left==null?right:left;
    }
}