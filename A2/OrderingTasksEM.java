import java.lang.reflect.Array;
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
                for (int i = 0; i < n; i++) {
                    adjList.put(i, new ArrayList<>());
                }
                for (int i = 0; i < m; i++) {
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    u--;
                    v--;
                    adjList.get(u).add(v);
                }
                boolean[] visited = new boolean[n];
                Stack<Integer> stack = new Stack<>();
                //BEGIN STUDENT CODE
                //iterate through the nodes and perform a depth-first search on each unvisited node
                //END STUDENT CODE
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop()+1 + " ");
                }
                System.out.println();
                


        }
        sc.close();

    }

        // DFS function to perform topological sorting using reverse post-order
        public static void dfs(int node, HashMap<Integer, ArrayList<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
            //BEGIN STUDENT CODE
            //implement the dfs function
            //input: node, adjacency list, visited array, stack
            //output: none (the function should update the visited array and stack)
            //END STUDENT CODE
        }

}
