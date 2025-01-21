import java.io.*;
import java.util.*;

public class Main {
    //Edmonds-Karp algorithm to find the max flow using BFS
    public static int maxFlow(int[][] capacity, int s, int t) {
        int n = capacity.length;
        int[][] residual = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(capacity[i], 0, residual[i], 0, n);
        }

        int[] parent = new int[n];
        int maxFlow = 0;

        while (bfs(residual, s, t, parent)) {
            //minimum capacity in augmenting path
            int flow = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                flow = Math.min(flow, residual[u][v]);
            }

            //Update the residual capacities
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                residual[u][v] -= flow;
                residual[v][u] += flow;
            }
            maxFlow += flow;
        }

        return maxFlow;
    }

    //check if there is a path from source to sink in the residual graph using bfs (making it edmonds karp algo)
    private static boolean bfs(int[][] residual, int s, int t, int[] parent) {
        int n = residual.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < n; v++) {
                if (!visited[v] && residual[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                    if (v == t) return true; //Stop search once sink is reached
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        File inputFile = new File("input.txt"); //Uses a file called input.txt which is in the same directory as Main.java <--- for marker

        try (Scanner scanner = new Scanner(inputFile)) {
            int networkNumber = 1;

            while (true) {
                int n = scanner.nextInt(); 
                if (n == 0) break; 

                int s = scanner.nextInt() - 1; //Source node 
                int t = scanner.nextInt() - 1; //Destination node 
                int c = scanner.nextInt(); //Number of connections

                //capacity matrix
                int[][] capacity = new int[n][n];
                for (int i = 0; i < c; i++) {
                    int u = scanner.nextInt() - 1; 
                    int v = scanner.nextInt() - 1; 
                    int bandwidth = scanner.nextInt();
                    capacity[u][v] += bandwidth; 
                    capacity[v][u] += bandwidth; 
                }

                //compute the maximum flow (bandwidth)
                int maxBandwidth = maxFlow(capacity, s, t);

                System.out.println("Network " + networkNumber);
                System.out.println("The bandwidth is " + maxBandwidth + ".");
                System.out.println(); //Give space for formatting

                networkNumber++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: input.txt file not found in the current directory (check message on line 61).");
        }
    }
}
