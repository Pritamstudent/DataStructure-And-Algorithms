import java.util.*;
public class LeftView {
    static Scanner sc = null;
        public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        System.out.println("\nthe preorder travesal of the tree is ");
        preorder(root);
        ArrayList<Integer> adj = new ArrayList<>();
        leftView(root, 0, adj);
        System.out.println("\nthe left view of the tree is ");
        for(int i  =  0 ;i<=adj.size()-1;i++)
        {
            System.out.print(adj.get(i)+" ");
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
    private static void leftView(Node root , int level,ArrayList<Integer> adj)
    {
        if(root==null)
        {
            return ;
        }
        if(level==adj.size())
        {
            adj.add(root.data);
        }
        leftView(root.left,level+1,adj);
        leftView(root.right,level+1,adj);
    }
}

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

