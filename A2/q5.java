import java.util.*;

public class q5 {
    
    static List<List<Integer>> graph;
    static List<List<Integer>> reverseGraph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            if (N == 0 && M == 0) break; // End of input

            graph = new ArrayList<>();
            reverseGraph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
                reverseGraph.add(new ArrayList<>());
            }

            // Read the edges and construct the graph
            for (int i = 0; i < M; i++) {
                int V = scanner.nextInt();
                int W = scanner.nextInt();
                int P = scanner.nextInt();
                
                // One-way street: Add edge from V to W in graph, and reverse edge W to V in reverseGraph
                graph.get(V).add(W);
                reverseGraph.get(W).add(V);

                // Two-way street: Add edges in both directions in both graphs
                if (P == 2) {
                    graph.get(W).add(V);
                    reverseGraph.get(V).add(W);
                }
            }

            // Check connectedness using two DFS
            if (isConnected(N)) {
                System.out.println(1); // Connected
            } else {
                System.out.println(0); // Not connected
            }
        }
        scanner.close();
    }

    static boolean isConnected(int N) {
        visited = new boolean[N + 1];
        
        // Run DFS on the original graph from node 1
        dfs(1, graph);
        
        // Check if all nodes were visited
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                return false; // Not connected in original graph
            }
        }
        
        // Reset visited array for reverse graph
        visited = new boolean[N + 1];
        
        // Run DFS on the reverse graph from node 1
        dfs(1, reverseGraph);
        
        // Check if all nodes were visited in reverse graph
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                return false; // Not connected in reverse graph
            }
        }
        
        return true; // Graph is strongly connected
    }

    static void dfs(int node, List<List<Integer>> graph) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph);
            }
        }
    }
}

