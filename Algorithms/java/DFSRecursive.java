import java.util.*;

public class DFSRecursive {
    public void dfsRecursive(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        if (visited == null) {
            visited = new HashSet<>();
        }
        
        if (!visited.contains(node)) {
            System.out.print(node + " ");
            visited.add(node);
            
            List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
            for (int neighbor : neighbors) {
                dfsRecursive(graph, neighbor, visited);
            }
        }
    }
}
