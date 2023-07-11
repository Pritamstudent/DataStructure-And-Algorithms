import java.util.*;

import javax.lang.model.util.ElementScanner14;

public class BoundaryTraversal {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        preorder(root);
        System.out.println();
        ArrayList<Integer> result =  new ArrayList<>();
        result =  boundaryTravesal(root);
        System.out.println("the boundary order travesal in the anticlockwise order  is ");
        for(int i = 0; i<result.size()-1;i++)
        {
            System.out.println(result.get(i)+"  ");
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
    private static ArrayList<Integer> boundaryTravesal(Node root) {
        if (root == null) {
            System.out.println("the tree is empty");
            System.exit(0);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        if(isLeaf(root)==false)
        arr.add(root.data);
        leftBoundary(arr, root);
        addLeafNodes(arr, root);
        rightBoundary(arr, root);
        return arr;
    }

    private static boolean isLeaf(Node root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

    private static void leftBoundary(ArrayList<Integer> arr, Node root) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                arr.add(curr.data);
            } else if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private static void rightBoundary(ArrayList<Integer> arr, Node root) {
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            } else if (curr.right != null) {
                curr = curr.right;
            } else

            {
                curr = curr.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            arr.add(temp.get(i));
        }
    }

    private static void addLeafNodes(ArrayList<Integer> arr, Node root) {
        if (isLeaf(root)) {
            arr.add(root.data);

        }
        if (root.left != null) {
            addLeafNodes(arr, root.left);
        }
        if (root.right != null) {
            addLeafNodes(arr, root.right);
        }
    }
}

class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}
