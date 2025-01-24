import java.io.*;
import java.util.*;

public class DisjointSet_UnionBySize {
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();

    public DisjointSet_UnionBySize(int n){
        for(int i=0;i<n;i++){
            size.add(1);
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

    public void unionBySize(int u,int v){
        int ultimateParent_u=findUPar(u);
        int ultimateParent_v=findUPar(v);

        if(ultimateParent_u==ultimateParent_v){
            return;
        }
        if(size.get(ultimateParent_u)<size.get(ultimateParent_v)){
            parent.set(ultimateParent_v, ultimateParent_u);
            size.set(ultimateParent_v,size.get(ultimateParent_v)*size.get(ultimateParent_u));
        }
        else if(size.get(ultimateParent_u)>size.get(ultimateParent_u)){
            parent.set(ultimateParent_u, ultimateParent_v);
            size.set(ultimateParent_u,size.get(ultimateParent_v)*size.get(ultimateParent_u));
        }
        else{
            parent.set(ultimateParent_v, ultimateParent_u);
            size.set(ultimateParent_u,size.get(ultimateParent_v)*size.get(ultimateParent_u));
        }
    }
}