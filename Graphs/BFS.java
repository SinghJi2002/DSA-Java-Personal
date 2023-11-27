package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class BFS {
    public void BFS(int root,int size,LinkedList<Integer> adj){
        //We will first write the visited array.
        boolean visited[]=new boolean[size+1];
        //Since we are following 1 based indexing, mark 0 true.
        visited[0]=true;
        //Queue will store current level nodes
        LinkedList<Integer> queue=new LinkedList<>();
        //Now since root node is already fed into the system, we will mark it visited.
        visited[root]=true;
        queue.add(root);
        while(!queue.isEmpty()){
            int valueDel=queue.remove();
            System.out.println(valueDel);
            Iterator<Integer> iterate=adj[2].listIterator();
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
