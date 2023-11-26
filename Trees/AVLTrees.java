package Trees;

public class AVLTrees {
//Basically to implement AVL tree we need to first implement BST. Lets first implement BST then implement 
//AVL treee
    class Node{
        public Node left;
        public Node right;
        public int value;
        public int height;
        public Node(int value){
            this.value=value;
        }
    }
    
    public Node root;

    public int getHeight(Node node){
        if(node==null){
            return(-1);
        }
        return(node.height);
    }
    //Insertion of element
    public void insert(int value){
        root=insert(root,value);
    }
    public Node insert(Node node,int value){
        if(node==null){
            node.value=value;
            return(node);
        }
        if(value<node.value){
            node.left=insert(node.left,value);
        }
        if(value>node.value){
            node.right=insert(node.right,value);
        }
        //Once insertion is done. We need to update the heigt
        node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
        //In BST
        //return(node);
        //In AVL
        return(rotate(node));
        //Rotate function is applied so that the new root node that may be created upon rotation is 
        //recieved.
    }
    //Check for balanced tree.
    public boolean balanced(){
        boolean bal=balanced(root);
        return(bal);
    }
    public boolean balanced(Node node){
        if(node==null){
            return(true);
        }
        return(Math.abs(getHeight(node.left)-getHeight(node.right))<=1 && balanced(node.left) && balanced(node.right));
    }
    //Till this point the basic implementation of the BST is done. Now the next thing to do is to 
    //implement AVL tree.
    //ACL is a layer over BST. Its a self balancing tree. Remember that a tree is said to be balanced 
    //Only if nodes at the same level are at the same height. Though if in case it isnt balanced, the 
    //AVL tree algorithm auto balances it. Now there are mainly 4 cases where four different algo are 
    //applied, to perform balancing.
    //1)Left left
    //2)Right Right
    //3)Left Right
    //4)Right Left
    //This is done on the basis of the positioning of the Parent,child and grandchild positioning. Please
    //refer to kunal's notes for visualisation.

    //Now the first thing that we need to change in basic BST is insertion method. Note the change above.
    //Next thing is the Rotate function.
    public Node rotate(Node node){
        //There are two main types and under them lies the 4 sub types. We first segregate them. The into
        //the subtypes.
        //The first main type is left heavy. Under this there are two subclass. Left-left and left-right.
        //Now next question is that how do we identify the left heavy variation? Refer to the diagrams.
        //In that we observe when height of left subtree of parent>right one. We have left heavy tree.
        if(getHeight(node.left)-getHeight(node.right)>1){
            //Above is check for unbalance and what kind of unbalance.

            //Next is differentiating between left-left and left-right. Again observe the diagram.
            //Here observe that the height of right of the child node is less than than the left one 
            //then we have the left-left case.
            if(getHeight(node.left.left)>getHeight(node.left.right)){
                //Left Left-Incase of left left, both the child and grandchild node are on left side.
                //The simple way to solve it is right rotation about parent node.
                node=rotateRight(node);
                return(node);
            }
            if(getHeight(node.left.left)<getHeight(node.left.right)){
                //Left right. In this case, the child node is on the left and the grandchild node is on
                //the right. So left rotation is done along the along the child node first. This makes
                //this the left left case. This is followed via the right rotation along the parent 
                node.left=rotateLeft(node.left);
                node=rotateRight(node);
                return(node);
                //Just carefully watch the diagrams and how which node is being rotated to achive the 
                //task.
            }
        }
        //Second case is right heavy. Simple condition to satisfy is below. Under that lies the sub cat
        //right right and right left. For further simplification and understanding refer above.
        if(getHeight(node.right)-getHeight(node.left)>1){
            //Next is differentiating between right-right and right-left. Again observe the diagram.
            //Here observe that the height of right of the child node is greater than than the left one 
            //then we have the right-right case.
            if(getHeight(node.right)>getHeight(node.left)){
                //Left Left-Incase of right-right, both the child and grandchild node are on right side.
                //The simple way to solve it is left rotation about parent node.
                node=rotateLeft(node);
                return(node);
            }
            if(getHeight(node.left.left)<getHeight(node.left.right)){
                //Right-left. In this case, the child node is on the right and the grandchild node is on
                //the left. So right rotation is done along the along the child node first. This makes
                //this the right right case. This is followed via the left rotation along the parent 
                node.left=rotateRight(node.left);
                node=rotateLeft(node);
                return(node);
                //Just carefully watch the diagrams and how which node is being rotated to achive the 
                //task.
            }
        }
        return(node);
    }
    //Lets write the left rotate and write rotate function.
    public Node rotateRight(Node node){
        //Refer to the diagram where we are rotating the left-left case using the right rotate. Child 
        //is on the left of the parent where as the extra tree is on the right.
        Node child=node.left;
        Node extra=node.right;
        //When rotation takes place, child becomes central. Parent lies on the right, where as the
        //extra tree lies on the left of the parent tree.
        child.right=node;
        node.left=extra;
        //After the rotation is done, the next important thing to do is update the heights of the parent
        //and child.
        child.height=Math.max(getHeight(child.left),getHeight(child.right));
        node.height=Math.max(getHeight(node.right),getHeight(node.left));
        //The node is the parent node.
        return(child); 
    }
    
    public Node rotateLeft(Node node){
        //Refer to the diagram where we are rotating the left-left already right rotated case 
        //using the left rotate. Parent is on the right of the child where as the extra tree is 
        //on the left of the parent.
        Node parent=node.right;
        Node extra=parent.left;
        //On left rotate, child becomes left node of the parent and the extra node re-attaches to the
        //right of the child.
        parent.left=node;
        node.right=extra;
        //Note that the node is the child node.
        //Now that rotation is done, left update the heights.
        node.height=Math.max(getHeight(node.left),getHeight(node.right));
        parent.height=Math.max(getHeight(parent.left),getHeight(parent.right));
        return(parent); 
    }
}
