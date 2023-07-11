import java.util.Scanner;
import java.util.Stack;

public class IsTreeSymmetrical {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        System.out.println("the preorder traveal of the tree is ");
        preorder(root);
        System.out.println();
        treeSymmetrical(root);
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
    private static void treeSymmetrical (Node root)
    {
        if(root==null)
        {
            return ;
        }
        boolean temp =  checkSymmetrical(root.left,root.right);
        if(temp==true)
        {
            System.out.println("the tree is symmetrical");
        }
        else
        {
            System.out.println("the tree is not symmetrical");
        }
    }
    private static boolean checkSymmetrical(Node root1 , Node root2)
    {
        if(root1==null||root2==null)
        {
            return root1==root2;
        }
        return (root1.data==root2.data)&&checkSymmetrical(root1.left, root2.right)&&checkSymmetrical(root1.right, root2.left);
    }
}

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}
