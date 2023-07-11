import java.util.*;
public class adjacency_matrix {
    public static void main(String  []args)
    {
        ArrayList<ArrayList<Integer>> adj =  new ArrayList<ArrayList<Integer>>();
        int n =  6 ;
        for(int i = 0;i<6;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        addList(adj);
        display(adj);
    }
    private static void addList(ArrayList<ArrayList<Integer>> adj)
    {
        int n , m;
        Scanner s  =  new Scanner(System.in);
        boolean choice =  true;
        while(choice)
        {
            System.out.println("enter the vertices between 0 and 6 between which you want to add the edges");
            n =  s.nextInt();
            m =  s.nextInt();
            addEdge(adj , n , m);
            System.out.println("enter true to add more edges and false to exit");
            choice= s.nextBoolean();
        }
    }
    private static void addEdge(ArrayList<ArrayList<Integer>> adj , int n , int m)
    {
        adj.get(n).add(m);
        adj.get(m).add(n);
    }
    private static void display(ArrayList<ArrayList<Integer>> adj)
    {
        for (int i =0 ;i<adj.size();i++)
        {
            System.out.print("\n Vertex " + i +": " );
            for(int j=0;j<adj.get(i).size();j++)
            {
                System.out.print("--->" + adj.get(i).get(j));
            }
        }
    }
}
