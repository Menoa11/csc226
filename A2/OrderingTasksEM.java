import java.util.*;

public class OrderingTasksEM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if (n == 0 && m == 0) {
                break;
            }

            HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
            int[] inDegree = new int[n];

            // Initialize adjacency list and in-degree array
            for (int i = 0; i < n; i++) {
                adjList.put(i, new ArrayList<>());
            }

            // Read precedence relations and populate adjacency list and in-degree array
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                adjList.get(u).add(v);
                inDegree[v]++;
            }

            // Perform topological sorting using Kahn's algorithm
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            ArrayList<Integer> topoOrder = new ArrayList<>();
            while (!queue.isEmpty()) {
                int node = queue.poll();
                topoOrder.add(node + 1); // Adding node to topo order (1-based index)

                for (int neighbor : adjList.get(node)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }

            // Print the topological order
            for (int i = 0; i < topoOrder.size(); i++) {
                System.out.print(topoOrder.get(i));
                if (i < topoOrder.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}