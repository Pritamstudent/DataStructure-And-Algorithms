import java.util.*;

public class topological_sort_dfs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int node = 6;
        for (int i = 0; i < node; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addList(adj);
        display(adj, node);
        int[] arr = new int[node];
        arr = topoSort(adj, node);
        System.out.println("\nthe order for topological sorting is DAG is");
        for (int data : arr) {
            System.out.print(data + " ");
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

    private static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int n) {
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                doTopoSort(adj, vis, i, st);
            }
        }
        int index = 0;
        int[] arr = new int[n];
        while (!st.isEmpty()) {
            arr[index] = st.pop();
            index++;
        }
        return arr;
    }

    private static void doTopoSort(ArrayList<ArrayList<Integer>> adj, int[] vis, int n, Stack<Integer> st) {
        vis[n] = 1;
        for (Integer it : adj.get(n)) {
            if (vis[it] == 0) {
                doTopoSort(adj, vis, it, st);
            }
        }
        st.push(n);
    }
}
