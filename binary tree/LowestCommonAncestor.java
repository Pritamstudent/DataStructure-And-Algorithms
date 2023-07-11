import java.util.Scanner;
import java.util.*;

public class LowestCommonAncestor {
    static Scanner sc = null;
    static boolean v1, v2;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        System.out.println("the preorder travesal of the tree is ");
        preorder(root);
        System.out.println();
        int node1, node2;
        System.out.println("enter the first node");
        // Scanner sc = new Scanner(System.in);
        node1 = sc.nextInt();
        System.out.println("enter the second node");
        node2 = sc.nextInt();
        Node lowCom = lowCommon(root, node1, node2);
        if (lowCom == null) {
            System.out.println("the keys are not present in the given tree");
        } else {
            System.out.println("the lowest common ancestor of " + node1 + " and " + node2 + " is " + lowCom.data);
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

    private static Node lowCommonAncestor(Node root, int node1, int node2) {
        if (root == null) {
            return null;
        }
        Node temp = null;
        if (root.data == node1) {
            v1 = true;
            temp = root;
        }
        if (root.data == node2) {
            v2 = true;
            temp = root;
        }
        Node leftLCA = lowCommonAncestor(root.left, node1, node2);
        Node rightLCA = lowCommonAncestor(root.right, node1, node2);
        if (temp != null) {
            return temp;
        }
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    private static Node lowCommon(Node root, int node1, int node2) {
        v1 = false;
        v2 = false;
        Node temp = lowCommonAncestor(root, node1, node2);
        if (v1 && v2) {
            return temp;
        }
        return null;
    }
}

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}
