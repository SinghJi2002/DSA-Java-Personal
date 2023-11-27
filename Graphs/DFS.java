package Graphs;
/**
 * DFS
 */
public class DFS {
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
    
        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
          int adj = ite.next();
          if (!visited[adj])
            DFS(adj);
        }
      }
    
}