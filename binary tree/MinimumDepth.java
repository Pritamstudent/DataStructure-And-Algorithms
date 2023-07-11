import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public /**
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
    static class QueueNode{
        TreeNode node;
        int depth;
        QueueNode(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public int minDepth(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        Queue<QueueNode>q = new LinkedList<>();
        q.add(new QueueNode(root, 1));
        int count =  0;
        while(!q.isEmpty()){
            QueueNode temp = q.poll();
            count = temp.depth;
            if(temp.node.left == null && temp.node.right== null){
                return count;
            }
            else{
                if(temp.node.left!=null){
                q.add(new QueueNode(temp.node.left, count+1));
                
            }
            if(temp.node.right!=null){
               q.add(new QueueNode(temp.node.right, count+1));
                
            }
            }
            
        }
        return count;
    }
} {
    
}


/// DFS

import java.util.* ;
import java.io.*; 
/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/

public class Solution {
    public static int minDepth(BinaryTreeNode<Integer> root) {
        // Write your code here.
		return helper(root);
 
    }
	static int helper(BinaryTreeNode<Integer> root){
		if(root == null){
			return 0;
		}
		if(root.left == null){
			return 1+helper(root.right);
		}
		if(root.right== null){
			return 1+helper(root.left);
		}
		int left = helper(root.left);
		int right = helper(root.right);
		return 1+Math.min(left, right);
	}
}