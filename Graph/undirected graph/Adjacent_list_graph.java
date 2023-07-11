import java.util.*;

public class Adjacent_list_graph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int node = 6;
        for (int i = 0; i < node; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addList(adj);
        display(adj, node);

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

}
