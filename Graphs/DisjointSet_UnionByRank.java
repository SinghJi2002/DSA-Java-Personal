import java.io.*;
import java.util.*;

public class DisjointSet_UnionByRank {
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();

    public DisjointSet_UnionByRank(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ultimateParent=findUPar(parent.get(node));
        parent.set(node,ultimateParent);
        return(parent.get(node));
    }

    public void unionByRank(int u,int v){
        int ultimateParent_u=findUPar(u);
        int ultimateParent_v=findUPar(v);

        if(ultimateParent_u==ultimateParent_v){
            return;
        }
        if(rank.get(ultimateParent_u)<rank.get(ultimateParent_v)){
            parent.set(ultimateParent_v, ultimateParent_u);
        }
        else if(rank.get(ultimateParent_u)>rank.get(ultimateParent_u)){
            parent.set(ultimateParent_u, ultimateParent_v);
        }
        else{
            parent.set(ultimateParent_v, ultimateParent_u);
            int rank_u=rank.get(ultimateParent_u);
            rank.set(ultimateParent_u,rank_u+1);
        }
    }
}