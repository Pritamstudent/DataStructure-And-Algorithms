import java.util.*;
import java.util.Scanner;

public class breadth_first_search {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int node = 5;
        for (int i = 0; i < node; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addList(adj, node);
        display(adj, node);
        ArrayList<Integer> list = new ArrayList<>();
        list = bfsTravesal(adj, node);
        System.out.println();
        for (Integer val : list) {
            System.out.print(val + " ");
        }
    }

    private static void addList(ArrayList<ArrayList<Integer>> adj, int node) {
        int n, m;
        Scanner s = new Scanner(System.in);
        boolean choice = true;
        while (choice) {
            System.out.println("enter the nodes between which the nodes is present (press enter to enter next node)");
            n = s.nextInt();
            m = s.nextInt();
            addEdge(adj, n, m);
            System.out.println("enter true to enter new add new nodes and false to exit");
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
                System.out.print(" ---> " + adj.get(i).get(j));
            }
        }
    }

    private static ArrayList<Integer> bfsTravesal(ArrayList<ArrayList<Integer>> adj, int n) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    bfs.add(node);
                    for (Integer it : adj.get(node)) {
                        if (vis[it] == false) {
                            vis[it] = true;
                            q.add(it);
                        }
                    }
                }
            }
        }
        return bfs;
    }
}
