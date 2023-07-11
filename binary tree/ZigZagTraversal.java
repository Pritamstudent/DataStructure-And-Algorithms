import java.util.*;

public class ZigZagTraversal {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        preorder(root);
        System.out.println();
        zigZag(root);
    }

    private static Node createTree() {
        Node root = null;
        System.out.println("enter data: ");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        root = new Node(data);
        System.out.println("enetr left for " + data);
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

    private static void zigZag(Node root) {
        Stack<Node> currLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        currLevel.push(root);
        boolean LtoR = true;
        while (!currLevel.isEmpty()) {
            Node curr = currLevel.pop();
            System.out.print(curr.data + "  ");
            if (LtoR) {
                if (curr.left != null) {
                    nextLevel.push(curr.left);
                }
                if (curr.right != null) {
                    nextLevel.push(curr.right);
                }
            } else {
                if (curr.right != null) {
                    nextLevel.push(curr.right);
                }
                if (curr.left != null) {
                    nextLevel.push(curr.left);
                }

            }
            if (currLevel.isEmpty()) {
                LtoR = !LtoR;
                Stack<Node> stk = nextLevel;
                nextLevel = currLevel;
                currLevel = stk;
            }

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
