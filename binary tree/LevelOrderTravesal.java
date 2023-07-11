import java.util.Scanner;
import java.util.Stack;

public class LevelOrderTravesal {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        preorder(root);
        System.out.println("\nthe level order traversal of the tree is ");
        levelOrder(root);
        
    }

    private static Node createTree() {
        Node root = null;
        System.out.println("enter data: ");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        root = new Node(data);
        System.out.println("enter the left child for " + data);
        root.left = createTree();
        System.out.println("enter the right child for " + data);
        root.right = createTree();
        return root;
    }
    private static void preorder(Node root)
    {
        if(root==null)
        {
            return ;
        }
        System.out.print(root.data + "  ");
        preorder(root.left);
        preorder(root.right);
    }
    private static void zigZag(Node root)
    {
        if(root==null)
        {
            return ;
        }
        Stack<Integer> currLevel = new Stack<>();
        Stack<Integer> nextLevel =  new Stack<>();
    }
    private static void levelOrder(Node root)
    {
        if(root==null)
        {
            return ;
        }
        int ht  =  height(root);
        for(int i=0;i<=ht;i++)
        {
            printLevelOrder(root,i);
        }
    }
    private static void printLevelOrder(Node root , int i)
    {
        if(root==null)
        {
            return ;
        }
        if(i==0)
        {
            System.out.print(root.data+ "   ");
        }
        else if(i>0)
        {
            printLevelOrder(root.left, i-1);
            printLevelOrder(root.right, i-1);
        }
    }
    private static int height(Node root)
    {
        if(root==null)
        {
            return -1;
        }
        int lh  = height(root.left);
        int rh =  height(root.right);
        if(lh<rh)
        {
            return rh+1;
        }
        else
        {
            return lh+1;
        }
    }
}

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}