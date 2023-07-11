import java.util.Scanner;

public class adjacent_matrix_represent {
    public static void main(String []args)
    {
        {
            int n=6;
            int [][]adj = new int[n+1][n+1];
            adj_matrix(adj);
            printMatrix(adj , n);
        }
    }
        private static void adj_matrix(int [][]adj )
        {
            int n  ,m;
            Scanner s = new Scanner(System.in);
            boolean choice = true;
            while(choice)
            {System.out.println("enter the nodes between which edges are present (between 1 and 6 , both inclusive) ");
            System.out.println("enter the node from where the edge direction originates");
            n = s.nextInt();
            System.out.println("enter the node to the edge direction ends");
            m = s.nextInt();
            addEdge(adj,n,m);
            System.out.println("enter true to add more edges and false to exit");
            choice = s.nextBoolean();
        }
        }
        private static void addEdge(int [][]adj , int n, int m)
        {
            adj[n][m]=1;
        }
        private static void printMatrix(int [][]adj , int n)
        {
            for(int i=1;i<=n;i++)
            {
                System.out.print("\n" + i + ": ");
                for(int j=1;j<=n;j++)
                {
                    System.out.print(adj[i][j]+" ");
                }
            }
    
}
}
