import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class LevelOrderSuccessor {

    public int levelOrderSuccessor(TreeNode root,int key){
        Queue<TreeNode>next=new LinkedList<>();
        List<TreeNode>result=new LinkedList<>();
        if(root!=null){ 
            next.add(root);
        }
        while(!next.isEmpty()){
            int currLevLen=next.size();
            for(int i=0;i<currLevLen;i++){
                int current=next.remove();
                if(current.left!=null){
                    next.add(current.left);
                }
                if(current.right!=null){
                    next.add(current.right);
                }
            }
            if(current==key){
                return(next.peek());
                break;
            }
        }
    }
    public static void main(String[] args) {
        
    }    
}
