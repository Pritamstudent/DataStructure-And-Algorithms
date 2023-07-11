import java.util.*;

public class ZigZag {
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

    private static void zigZag(Node root) {
        Stack<Node> currLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        currLevel.push(root);
        boolean LtoR = true;
        while (!currLevel.isEmpty()) {
            Node curr = currLevel.pop();
            System.out.println(curr.data + "  ");
            if (LtoR) {
                if (curr.left != null) {
                    nextLevel.push(root.left);
                }
                if (curr.right != null) {
                    nextLevel.push(root.right);

                }

            } else {
                if (curr.right != null) {
                    nextLevel.push(root.right);
                }
                if (curr.left != null) {
                    nextLevel.push(root.left);
                }
            }
            if (currLevel.isEmpty()) {
                LtoR = !LtoR;
                Stack<Node> st = nextLevel;
                nextLevel = currLevel;
                currLevel = st;
            }
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
