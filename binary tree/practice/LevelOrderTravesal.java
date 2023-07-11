
import java.util.*;

public class LevelOrderTravesal {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        int ht = height(root);
        System.out.println("the height of the tree is " + ht);
        System.out.println("the level order traversal of the tree is  ");
        levelOrder(root);
    }

    private static Node createTree() {
        Node root = null;
        int data;
        System.out.println("enter the data(enter -1 for no child)");
        data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        root = new Node(data);
        System.out.println("for left child  " + data);
        root.left = createTree();
        System.out.println("for right child  " + data);
        root.right = createTree();
        return root;
    }

    private static int height(Node root) {
        if (root == null)
            return -1;
        int lh = height(root.left);
        int rh = height(root.right);
        if (lh > rh) {
            return (lh + 1);
        } else {
            return (rh + 1);
        }
    }

    private static void levelOrder(Node root) {
        if (root == null) {
            System.out.println("the tree is empty");
        }
        int ht = height(root);
        for (int i = 0; i <= ht; i++) {
            printLevelOrder(root, i);
        }
    }

    private static void printLevelOrder(Node root, int level) {
        if (root == null) {
            return;
        } else if (level == 0) {
            System.out.print(root.data + " ");
        } else {
            printLevelOrder(root.left, level - 1);
            printLevelOrder(root.right, level - 1);
        }
    }
}

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}
