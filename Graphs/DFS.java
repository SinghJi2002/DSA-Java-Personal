import java.util.ArrayList;
class DFS {
    
    public static void dfs(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
        
        vis[node]=true;
        ls.add(node);
        
        for(Integer it : adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,adj,ls);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[V+1];
        vis[0]=true;//One indexing
        ArrayList<Integer>ls=new ArrayList<>();
        dfs(0,vis,adj,ls);
        return ls;
    }
}