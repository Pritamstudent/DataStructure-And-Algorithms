
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
    static ArrayList <Integer> a;
    public boolean isValidBST(TreeNode root) {
        a = new ArrayList<>();
        inorder(root);
        for(int i = 0 ; i < a.size()-1 ; i++){
            if(a.get(i)>=a.get(i+1)){
                return false;
            }
        }
        return true;
    }
    static void inorder(TreeNode root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        a.add(root.val);
        inorder(root.right);
    }
}