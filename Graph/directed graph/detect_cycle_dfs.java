import java.util.*;

public class detect_cycle_dfs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int node = 7;
        for (int i = 0; i < node; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addList(adj);
        display(adj, node);
        boolean val = checkDfs(adj, node);
        if (val == true) {
            System.out.println("\nthe cycle is present in the graph");
        } else {
            System.out.println("\nthe cycle is not present in the graph");
        }

    }

    private static void addList(ArrayList<ArrayList<Integer>> adj) {
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

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int n, int m) {
        adj.get(n).add(m);
    }

    private static void display(ArrayList<ArrayList<Integer>> adj, int n) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("\nVertex " + i + ": ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" --> " + adj.get(i).get(j));
            }
        }
    }

    private static boolean checkDfs(ArrayList<ArrayList<Integer>> adj, int n) {
        int[] vis = new int[n];
        int[] dfsvis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                if (check_cycle(adj, vis, dfsvis, i) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean check_cycle(ArrayList<ArrayList<Integer>> adj, int[] vis, int[] dfsvis, int n) {
        vis[n] = 1;
        dfsvis[n] = 1;
        for (Integer it : adj.get(n)) {
            if (vis[it] == 0) {
                if (check_cycle(adj, vis, dfsvis, it) == true) {
                    return true;
                }
            } else if (dfsvis[it] == 1) {
                return true;
            }
        }
        dfsvis[n]=0;
        return false;
    }
}
