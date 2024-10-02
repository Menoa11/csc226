import java.util.*;
public class SpreadingTheNewsEM {


    public static void main(String[] args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int numFriends = sc.nextInt();
            for (int j = 0; j < numFriends; j++) {
                int friend = sc.nextInt();
                graph.get(i).add(friend);
            }
        }
        int t;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int start = sc.nextInt();
            int[] distance = bfs(start, graph);
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < distance.length; j++) {
                if (j == start) {
                    continue;
                }
                if (distance[j] != -1) {
                    if (map.containsKey(distance[j])) {
                        map.put(distance[j], map.get(distance[j]) + 1);
                    } else {
                        map.put(distance[j], 1);
                    }
                }
            }
            if (map.size() == 0) {
                System.out.println(0);
            } else {
                int max = 0;
                int day = 0;
                for (int key : map.keySet()) {
                    if (map.get(key) > max) {
                        max = map.get(key);
                        day = key;
                    }
                }
                System.out.println(max + " " + day);
            }

        }
    }
    public static int[] bfs(int start, List<List<Integer>> graph) {
        //BEGIN STUDENT CODE
        //implement the bfs function
        //input: start node and graph
        //output: an array of distances from the start node to all other nodes
        //END STUDENT CODE
        return null;
    }
    
}
