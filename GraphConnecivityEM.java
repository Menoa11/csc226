import java.util.*;
import java.io.*;

public class GraphConnecivityEM {
    public static void dfs(char node, HashMap<Character, ArrayList<Character>> adjList, boolean[] visited) {
        //BEGIN STUDENT CODE
        // Input: node, adjacency list, visited array
        // Output: none (the function should update the visited array)
        //END STUDENT CODE
    }
    public static int solve(char maxNode, List<String> edges)
    {
        HashMap<Character, ArrayList<Character>> adjList = new HashMap<>();
        for (char i = 'A'; i <= maxNode; i++) {
            //BEGIN STUDENT CODE
            // Add an empty ArrayList for each node
            //END STUDENT CODE
        }
        for (String edge : edges) {
            char u = edge.charAt(0);
            char v = edge.charAt(1);
            //BEGIN STUDENT CODE
            // Add the edge to the adjacency list (don't forget to add both directions)
            //END STUDENT CODE
        }
        boolean[] visited = new boolean[maxNode - 'A' + 1];
        int count = 0;
        for (char node : adjList.keySet()) {
            //BEGIN STUDENT CODE
            // perform a depth-first search on each unvisited node and increment the count
            //END STUDENT CODE
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCases = Integer.parseInt(br.readLine().trim());
        
        // Loop over each test case
        for (int t = 0; t < testCases; t++) {
            String line = "";
            while (true) {
                 line = br.readLine().trim();
                if (line.isEmpty()) {
                    continue;
                } else {
                    break;
                }
            }
            String largestNode = line;
            char maxNode = largestNode.charAt(0);
            
            List<String> edges = new ArrayList<>();
            
            while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
                edges.add(line.trim());
            }
            int result = solve(maxNode, edges);
            
            System.out.println(result);
            
            // Print blank line after each test case except the last one
            if (t < testCases - 1) {
                System.out.println();
            }
        }
    }
}
