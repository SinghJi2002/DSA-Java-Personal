package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import SingleLinkedLists.SingleLinkedLists.Node;

public class BFS {
    class Node{
        Node left;
        Node right;
        int value;
    }
    //Complexity:O(N)
    public static List<List<Integer>> BFS(Node root){
    //The return result will be array of list with each list containing values of one level
        List<List<Integer>>result=new ArrayList<>();
        if(root==null){
            return result;
        }
        //The Queue 'queue' will maintain record of the nodes that are to be traversed next.
        Queue<Node>queue=new LinkedList<>();
        //Since the first node to be transversed is root. We add the root node to the queue
        queue.add(root);
        //Next is tranversing the tree bredthwise
        while(!queue.isEmpty()){
            //Now pick the number of time you want to traverse the queue. For level 0 its 1, level 1 2,
            //level 2 its 4 nd so on.
            int numberOfNodeOnCurrLevel=queue.size();
            //New array list will be created to store values present on current level. This will be then
            //merged with result array.
            List<Integer>currentLevelValues=new ArrayList<>();
            //Lets traverse the current level. To do that we need to traverse the queue that keep record
            //of untraversed nodes.
            for(int i=0;i<numberOfNodeOnCurrLevel;i++){
                //Now pick the current elements to be transversed on the current level. Since in 1st trail
                //we are on level one, one root node. Next trail, level 2, so two node and so on.
                Node removedNodeFromQueue=queue.remove();
                int valueOfNodeRemovedFromQueue=removedNodeFromQueue.value;
                //Now add this current level node to list
                currentLevelValues.add(valueOfNodeRemovedFromQueue);
                //Now the child of this node will the nodes of the next level. These need to be added
                //into the queue.
                if(removedNodeFromQueue.left!=null){
                    queue.add(removedNodeFromQueue.left);
                }
                if(removedNodeFromQueue.right!=null){
                    queue.add(removedNodeFromQueue.right);
                }
            }
            //Now since the current level nodes are added, add them in result.
            result.add(currentLevelValues);
        }
        return(result);
    }
}
