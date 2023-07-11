import java.util.*;

public class VerticalOrderTravesal {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        System.out.println("the preorder travesal of the tree is ");
        preorder(root);
        System.out.println("\nthe vertical order travesal of the tree is ");
        printVerticalOrder(root);
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

    private static void printVerticalOrder(Node root) {
        if (root == null) {
            return;
        }
        TreeMap<Integer, ArrayList<Integer>> verOrder = new TreeMap<>();
        int horDis = 0;
        Queue<QueObj> q = new LinkedList<QueObj>();
        q.add(new QueObj(0, root));
        while (!q.isEmpty()) {
            QueObj t = q.poll();
            horDis = t.horDis;
            Node temp = t.temp;
            if (verOrder.containsKey(horDis)) {
                verOrder.get(horDis).add(temp.data);
            } else {
                ArrayList<Integer> alist = new ArrayList<>();
                alist.add(temp.data);
                verOrder.put(horDis, alist);

            }
            if (temp.left != null) {
                q.add(new QueObj(horDis - 1, temp.left));
            }
            if (temp.right != null) {
                q.add(new QueObj(horDis + 1, temp.right));
            }
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry : verOrder.entrySet()) {
            ArrayList<Integer> alist = entry.getValue();
            for (Integer in : alist) {
                System.out.print(in + " ");
            }
            System.out.println();
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

class QueObj {
    int horDis;
    Node temp;

    QueObj(int horDis, Node temp) {
        this.horDis = horDis;
        this.temp = temp;
    }
}
