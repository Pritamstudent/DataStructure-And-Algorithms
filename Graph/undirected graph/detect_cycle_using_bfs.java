import java.util.*;

public class detect_cycle_using_bfs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int node = 6;
        for (int i = 0; i < node; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addList(adj);
        display(adj, node);
        boolean temp = bfs(adj, node);
        if (temp == true) {
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

    private static boolean bfs(ArrayList<ArrayList<Integer>> adj, int n) {
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                if (check_cycle(adj, i, vis) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean check_cycle(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis) {
        Queue<Node> q = new LinkedList<>();
        vis[node] = true;
        q.add(new Node(node, -1));
        while (!q.isEmpty()) {
            int n = q.peek().first;
            int s = q.peek().second;
            q.poll();
            for (Integer it : adj.get(n)) {

                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(new Node(it, n));
                } else if (it != s) {
                    return true;
                }
            }
        }
        return false;

    }
}

class Node {
    int first;
    int second;

    Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
