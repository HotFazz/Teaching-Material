import java.util.*;

public class DFSIterative {
    public void dfsIterative(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                System.out.print(node + " ");
                visited.add(node);
                List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
                // Add neighbors in reverse order to maintain similar ordering as Python version
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    stack.push(neighbors.get(i));
                }
            }
        }
    }
}
