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
    public boolean isSymmetric(TreeNode root) {
        Queue <TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        q1.add(root);
        while(!q1.isEmpty()){
            TreeNode node1 = q1.poll();
            TreeNode node2 = q1.poll();
            if(node1 == null && node2 == null){
                continue;
            }
            if(node1!=null && node2==null){
                return false;
            }
            if(node2!=null && node1==null){
                return false;
            }
            if(node1.val != node2.val){
                return false;
            }
            
            q1.add(node1.left);
            q1.add(node2.right);
            q1.add(node1.right);
            q1.add(node2.left);

        }
        if(q1.isEmpty()){
            return true;
        }
        return false;
    }
}