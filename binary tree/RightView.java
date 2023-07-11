import java.util.Scanner;
import java.util.*;

public class RightView {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        ArrayList<Integer> adj = new ArrayList<>();
        System.out.println("the preorder traversal of the tree is ");
        preorder(root);
        System.out.println("\nthe right view of the tree is ");
        rightView(root, 0, adj);
        for(int i=0;i<adj.size();i++)
        {
            System.out.print(adj.get(i) + "  ");
        }
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

    private static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "  ");
        preorder(root.left);
        preorder(root.right);
    }

    private static void rightView(Node root, int level, ArrayList<Integer> adj) {
        if (root == null) {
            return;
        }
        if (level == adj.size()) {
            adj.add(root.data);
        }
        rightView(root.right, level + 1, adj);
        rightView(root.left, level + 1, adj);
    }
}

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}
