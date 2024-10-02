import java.util.*;

public class ComeAndGoEM {
    
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
                //BEGIN STUDENT CODE
                //add corresponding edges to the graph and reverse graph
                //END STUDENT CODE
                
                if (P == 2) {
                    //BEGIN STUDENT CODE
                    //add corresponding edges to the graph and reverse graph
                    //END STUDENT CODE
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
        //BEGIN STUDENT CODE
        //implement the isConnected function
        //input: number of nodes
        //output: true if the graph is connected, false otherwise
        //END STUDENT CODE
        return false;
    }

    static void dfs(int node, List<List<Integer>> graph) {
        //BEGIN STUDENT CODE
        //implement the dfs function
        //input: node and graph
        //output: none (the function should update the visited array)
        //END STUDENT CODE
    }
}
