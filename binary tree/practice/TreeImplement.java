import java.util.*;

public class TreeImplement {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        preorder(root);
    }

    private static Node createTree() {
        Node root = null;
        int data;
        System.out.println("enter the data(enter -1 for entering no child)");
        data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        root = new Node(data);
        System.out.println("for left child for " + data);
        root.left = createTree();
        System.out.println("for right child for " + data);
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
}

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}
