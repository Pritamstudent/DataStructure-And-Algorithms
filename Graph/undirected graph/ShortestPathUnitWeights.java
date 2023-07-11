import java.util.*;

public class ShortestPathUnitWeights {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int node = 9;
        for (int i = 0; i < 9; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addList(adj, node);
        display(adj);
        int src;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the vetex from which you want to find the shorstest path to the other vextex");
        src = sc.nextInt();
        shortestPath(adj, node, src);
    }

    private static void addList(ArrayList<ArrayList<Integer>> adj, int node) {
        int n;
        int m;
        boolean choice = true;
        Scanner sc = new Scanner(System.in);
        while (choice) {
            System.out.println("enter the two vertices between which the edges are present ");
            n = sc.nextInt();
            m = sc.nextInt();
            addEdge(adj, n, m);
            System.out.println("enter the true to add more vertices and false to exit");
            choice = sc.nextBoolean();
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int n, int m) {
        adj.get(n).add(m);
        adj.get(m).add(n);
    }

    private static void display(ArrayList<ArrayList<Integer>> adj) {
        System.out.println("the adjcency list of the given graph is ");
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("Vertex " + i + ":");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" --> " + adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static void shortestPath(ArrayList<ArrayList<Integer>> adj, int node, int src) {
        int[] dis = new int[node];
        for (int i = 0; i < node; i++) {
            dis[i] = 1000;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dis[src] = 0;
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (Integer it : adj.get(temp)) {
                if (dis[temp] + 1 < dis[it]) {
                    dis[it] = dis[temp] + 1;
                    q.add(it);
                }
            }
        }
        System.out.println("the distance of each vetex from  " + src + " is ");
        for (int i = 0; i < node; i++) {
            System.out.print(dis[i] + "  ");
        }
    }
}
