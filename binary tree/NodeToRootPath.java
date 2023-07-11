import java.util.Scanner;
import java.util.*;

public class NodeToRootPath {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        System.out.println("the preorder travesal of the tree is ");
        preorder(root);
        ArrayList<Integer> arr=  new ArrayList<>();
        int search;
        Scanner sc =  new Scanner(System.in);
        System.out.println("enter the node you want to search");
        search=sc.nextInt();
        path(root,search, arr);
        System.out.println("\nthe node to the root path is ");
        for(int i=0;i<arr.size();i++)
        {
            System.out.print(arr.get(i)+"  ");
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
    private static boolean nodeToRoot(Node root,int search, ArrayList<Integer> arr)
    {
        if(root==null)
        {
            return false;
        }
        arr.add(root.data);
        if(root.data==search)
        {
            return true;
        }
        if(nodeToRoot(root.left, search,arr)||nodeToRoot(root.right, search,arr))
        {
            return true;
        }
        arr.remove(arr.size()-1);
        return false;
        
    }
    private static void path(Node root,int search,  ArrayList<Integer> arr)
    {
        if(root==null)
        return ;
        boolean temp = checkSearch(root,search);
        if(temp==true)
        {
            nodeToRoot(root, search, arr);
        }
        else
        {
            System.out.println(search+ " is not present in the given tree");
        }
    }
    private static boolean checkSearch(Node root,int search)
    {
        if(root==null)
        {
            return false;
        }
        if(root.data==search)
        {
            return true;
        }
        boolean res1 = checkSearch(root.left,search);
        if(res1==true)
        {
            return true;
        }
        boolean res2 =  checkSearch(root.right, search);
        return res2;
    }
}

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}
