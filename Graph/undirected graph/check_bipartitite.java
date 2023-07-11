import java.util.*;
public class check_bipartitite {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int node = 9;
        for (int i = 0; i < node; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addList(adj);
        display(adj, node);
        boolean val = bipartite(adj, node);
        if(val==true)
        {
            System.out.println("\nthe graph is a bipartite");
        }
        else
        {
            System.out.println("\nthe graph is not a bipartite");
        }
    }

    private static void addList(ArrayList<ArrayList<Integer>> adj) {
        int n;
        int m;
        Scanner s = new Scanner(System.in);
        boolean choice = true;
        while (choice) {
            System.out.println("enter the nodes between which edges are present (between 0 and 5 , both inclusive) ");
            n = s.nextInt();
            m = s.nextInt();
            addEdge(adj, n, m);
            System.out.println("enter true to add more edges and false to exit");
            choice = s.nextBoolean();
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int n, int m) {
        adj.get(n).add(m);
        adj.get(m).add(n);
    }

    private static void display(ArrayList<ArrayList<Integer>> adj, int n) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("\nVertex " + i + ": ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" --> " + adj.get(i).get(j));
            }
        }
    }
    private static boolean bipartite(ArrayList<ArrayList<Integer>> adj, int n)
    {
        int[]color = new int [n];
        for(int i=0;i<n;i++)
        {
            color[i]=-1;
        }
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                if(check_bipartite(adj,color,i)==false)
                return false;
            }
        }
        return true;

    }
    private static boolean check_bipartite(ArrayList<ArrayList<Integer>> adj, int []color, int n)
    {
        color[n]=1;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while(!q.isEmpty())
        {
            Integer node = q.poll();
            for(Integer it : adj.get(node))
        {
            if(color[it]==-1)
            {
                color[it]=1-color[node];
                q.add(it);
            }
            else if(color[it]==color[node])
            {
                return false;
            }
        }
        }
        return true;
    }
    
}
