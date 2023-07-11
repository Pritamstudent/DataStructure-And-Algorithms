import java.util.*;

public class ShortestPathWeighted {
    public static void main(String[] args) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        int node = 6;
        for (int i = 0; i < node; i++) {
            adj.add(new ArrayList<Pair>());
        }
        addList(adj, node);
        display(adj);
        int src;
        System.out.println("enter the vertex from which you want the distance of the other vertices");
        Scanner sc = new Scanner(System.in);
        src = sc.nextInt();
        shortestPathUsingDfs(adj, node, src);
    }

    private static void addList(ArrayList<ArrayList<Pair>> adj, int node) {
        boolean choice = true;
        int node1, node2, weight;
        Scanner sc = new Scanner(System.in);
        while (choice) {
            System.out.println("enter the vertex from where the edge starts ");
            node1 = sc.nextInt();
            System.out.println("enter the vertex at which the edge ends ");
            node2 = sc.nextInt();
            System.out.println("enter the weight of the edge between " + node1 + " and " + node2);
            weight = sc.nextInt();
            addEdge(node1, node2, weight, adj);
            System.out.println("enter true to add more vertex and false to exit");
            choice = sc.nextBoolean();
        }

    }

    private static void addEdge(int node1, int node2, int weight, ArrayList<ArrayList<Pair>> adj) {
        adj.get(node1).add(new Pair(node2, weight));
    }

    private static void display(ArrayList<ArrayList<Pair>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("Vertex " + i + ":");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" ---> " + "( " + adj.get(i).get(j).node + "," + adj.get(i).get(j).weight + " )");
            }
            System.out.println();
        }
    }

    private static void shortestPathUsingDfs(ArrayList<ArrayList<Pair>> adj, int node, int src) {
        int[] vis = new int[node];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < node; i++) {
            if (vis[i] == 0) {
                shortestPath(adj, st, vis, i);
            }
        }
        int[] dis = new int[node];
        for (int i = 0; i < node; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;
        while (!st.isEmpty()) {
            Integer temp = st.pop();
            if (dis[temp] != Integer.MAX_VALUE) {
                for (Pair it : adj.get(temp)) {
                    if (dis[temp] + it.getweight() < dis[it.node]) {
                        dis[it.node] = dis[temp] + it.getweight();
                    }
                }
            }

        }
        System.out.println("the shortest path of distance from " + src + " is ");
        for (int i = 0; i < node; i++) {
            System.out.print(dis[i] + "  ");
        }
    }

    private static void shortestPath(ArrayList<ArrayList<Pair>> adj, Stack<Integer> st, int[] vis, int node) {
        vis[node] = 1;
        for (Pair it : adj.get(node)) {
            if (vis[it.node] == 0) {
                shortestPath(adj, st, vis, it.node);
            }
        }
        st.push(node);
    }
}

class Pair {
    int weight;
    int node;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    int getNode() {
        return node;
    }

    int getweight() {
        return weight;
    }
}
