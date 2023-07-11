import java.util.*;
public class adjacent_list_implement {
    public static void main(String []args)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int node  = 7;
        for(int i=0;i<node;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        addList(adj);
        display(adj,node);

    }
    private static void addList(ArrayList<ArrayList<Integer>> adj)
    {
        int n;
        int m;
        Scanner s = new Scanner(System.in);
        boolean choice = true;
        while (choice) {
            System.out.println("enter the nodes between which edges are present (between 0 and 6 , both inclusive) ");
            System.out.println("enter the node from where the edge direction originates");
            n = s.nextInt();
            System.out.println("enter the node to the edge direction ends");
            m = s.nextInt();
            addEdge(adj, n, m);
            System.out.println("enter true to add more edges and false to exit");
            choice = s.nextBoolean();
        }
    }
    private static void addEdge(ArrayList<ArrayList<Integer>> adj , int n , int m)
    {
        adj.get(n).add(m);
    }
    private static void display(ArrayList<ArrayList<Integer>> adj, int n)
    {
        for(int i = 0;i<adj.size();i++)
        {
            System.out.print("\nVertex " + i + ": ");
            for(int j = 0;j<adj.get(i).size();j++)
            {
                System.out.print(" --> " + adj.get(i).get(j) );
            }
        }
    }
}
