//width of the tree = last_index-first_index+1;
//we cannot use the 0 based indexing concept because then the memory wil run out because of 10^5.
import java.util.*;

public class MaxWidth {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        preorder(root);
        System.out.println();
        int result = maxWidth(root);
        System.out.println("the maximum width of the tree is "  + result);
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
    private static int maxWidth(Node root)
    {
        if(root==null)
        return 0;
        int ans=0;
        Queue<Pair> q=  new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty())
        {
            int size = q.size();
            int min  = q.peek().width;
            int first =0, last = 0;
            for(int i=0;i<size;i++)
            {
                int currId = q.peek().width-min;
                Node node = q.peek().temp;
                q.poll();
                if(i==0)
                {
                    first=currId;
                }
                if(i==size-1)
                {
                    last=i;
                }
                if(node.left!=null)
                {
                    q.offer(new Pair(node.left,2*currId+1));
                }
                if(node.right!=null)
                {
                    q.offer(new Pair(node.right,2*currId+2));
                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;

    }
}
class Pair
{
    Node temp;
    int width;
    Pair(Node temp , int width)
    {
        this.temp=temp;
        this.width=width;
    }
}
class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}
