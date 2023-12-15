import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void BFS(int root,int size,ArrayList<ArrayList<Integer>> adj){
        //We will first write the visited array.
        boolean visited[]=new boolean[size+1];
        //Since we are following 1 based indexing, mark 0 true.
        visited[0]=true;
        //Queue will store exploration nodes.
        Queue<Integer> queue=new LinkedList<>();
        //We create a solution array
        ArrayList<Integer> solList=new ArrayList<>();
        //Now since root node is already fed into the system, we will mark it visited.
        visited[root]=true;
        queue.add(root);
        while(!queue.isEmpty()){
            int node=queue.remove();
            solList.add(node);
            Iterator<Integer> i=adj[node].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                  visited[n] = true;
                  queue.add(n);
                }
            }
        }
    }
}
