import java.util.*;
public class adjacency_list {
    public static void main(String []args)
    {
        int n;
        Scanner s =  new Scanner(System.in);
        System.out.println("enter max value of vertex in the graph");
        n =  s.nextInt();
        int [][]adj =  new int[n+1][n+1];
        adj_matrix(adj,n);
        print(adj, n);
    }
    private static void adj_matrix(int [][]adj, int num)
    {
        Scanner s =  new Scanner(System.in);
        int n , m;
        boolean choice =  true;
        while(choice)
        {
            System.out.println("enter the nodes between which edges are present (between 0 and " + num +", both inclusive) ");
            n = s.nextInt();
            m = s.nextInt();
            addEdge(adj,n,m);
            System.out.println("enter true to add more edges and false to exit ");
            choice =  s.nextBoolean();
        }
    }
    private static void addEdge(int [][]adj , int row , int col)
    {
        adj[row][col]=1;
        adj[col][row]=1;
    }
    private static void print(int [][]adj , int num)
    {
        System.out.println("the adjacency matrix for the graph is ");
        for(int i=0;i<num;i++)
        {
            System.out.print("\n" + i + ": ");
            for(int j  = 0 ;j<num;j++)
            {
                System.out.print(adj[i][j]+" ");
            }
        }
    }
}
