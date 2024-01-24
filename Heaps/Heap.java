//The general time complexity of running a query in heap is O(n). The general time complexity
    //of adding or deleting items into already existing heap will be O(log n). Heap is internally stored  
    //as an array. But diagrammatically it is represented as tree. Heaps are represented as complete binary 
    //trees.
    //For reminder, complete binary tree is a tree which is full at all levels except the leafs.
    //Also the feeling of leaves start from left and ends at right.

    //When heaps are represented as trees, note that the parent node's value will always be greater than
    //the values in all the nodes below it. Refer Kunal's Notes for visual inference.

    /*One genuine question to ask is that when the internal representation is array, how does the 
     tree representation works? Like how are the tree and array connected?
     Lets assume the given heap is as follows,
     {16,14,10,9,7,4,2,0}
     Then assuming that its a maximum heap, we place 16 at root.
     Assuming we are following 1 based indexing. Then, on the left of 16, element at (2*Index Of 16) will
     be placed. 
     Index of 16 is 1.
     2*1=2
     Element at index 2 is 14. Then element on the left of 16 will be 14.

     Similarly, at right, element at index value=(2*Index Of Parent)+1 will be place.
     For 16 whose index is 1, element at 2*1+1, index 3 will be placed on the right.
     Hence on right of 16, 10 will be placed.

     Hence,

     Left Node=Element at index 2*IndexOfParent
     Right Node=Element at index 2*IndexOfParent+1

     Hence the parent node of any node is IndexOfNode/2 approximately.
     */

    //Since general representation is that of tree, height=Log n, where n is number of nodes.

    /*Suppose this is our heap.
                                16
                               /  \
                             14    10
                            /  \   / \
                           8   7   9  3
                          / \
                         2   4
    Now suppose, I insert, 37 in the heap. Now 37 cannot be inserted like this.
                                16
                               /  \
                             14    10
                            /  \   / \
                           8   7   9  3
                          / \     /
                         2   4   37
    Since its an maximum heap, in place of 16, 37 will be placed. Something like this,
                                37
                               /  \
                             14    10
                            /  \   / \
                           8   7   9  3
                          / \
                         2   4
    But note that 16 is not deleted, its has to be adjusted somewhere. So how does a number is added into
    heap and how are the adjustments made.


    Now suppose this is a Max heap that we already have. 
    {16,14,10,9,7,4,2,0}
    {16,14,10,9,7,4,2,0,15}
    Now we add a random element, say 15.
    Since its a complete binary tree representation, left most void will be filled first. Like this,
                                 16
                               /  \
                             14    10
                            /  \   / \
                           8   7   9  3
                          / \     /
                         2   4   15
    Now, since its a max tree, the common condition that need to be followed, is Value of parent must 
    be greater than the node. So lets see the situation here.
    The parent of 15 is 9. Since 15 is greater than 9, we replace them.
                                 16
                                /  \
                              14     10
                             /   \   / \
                            8    7  15  3
                           /  \    /
                          2    4  9
    On the array level, we replace element at i/2 index with that of 15.(i is index of 15 in array)
    The new array will be,
    {16,14,10,15,7,4,2,0,9}
    Now 15's new parent is 10. Again child is greater than parent. So we swap them. See the tree and
    array changes below.
                                16
                               /  \
                             14    15
                            /  \   / \
                           8   7  10  3
                          / \     /
                         2   4   9
    {16,14,15,10,7,4,2,0,9}
    Now since the parent of 15 now is 16 and 15<16, no swaping is required hence the addition has taken
    place successfully.

    Now next task is deletion. When deletion is enacted, always the max element in max heap and min element
    in min heap.
    So how to delete? Whats the algorithm?
    First this is the tree and array of our max heap.
                                16
                               /  \
                             14    15
                            /  \   / \
                           8   7  10  3
                          / \     /
                         2   4   9
    {16,14,15,10,7,4,2,0,9}
    Now when delete is executed, tree and array looks like this,
                                
                               /  \
                             14    15
                            /  \   / \
                           8   7  10  3
                          / \     /
                         2   4   9
    {,14,15,10,7,4,2,0,9}
    Now this first step is, pick the right most leaf, place it at the top.
                                09
                               /  \
                             14    15
                            /  \   / \
                           8   7  10  3
                          / \     
                         2   4   
    {9,14,15,10,7,4,2,0}
    Now perform the swapping part. Remember, its a max heap hence, parent will be always greater than the
    parent.
    Now the general algo is,
    If the parent is less than, its child,
    1)Compare the left and right node. Now replace the parent with child whose value is the greatest.
    Hence, for 9 child is 14 and 15 and 15 is greater than 14, hence we replace 15 with 9.
    The array and tree is,
                                15
                               /  \
                             14    09
                            /  \   / \
                           8   7  10  3
                          / \     
                         2   4   
    {15,14,9,10,7,4,2,0}
    Now again the child of 9 are 10 and 3 where child is greater than the parent, and 10 is greater among
    the children hence 9 and 10 are swapped.
                                15
                               /  \
                             14    10
                            /  \   / \
                           8   7  09  3
                          / \     
                         2   4   
    {15,14,10,9,7,4,2,0}
    Now everything is set.

    All the execution that we have discussed is based around Max Heap. Min heap is same with a few changes.
    */


    //Heaps are of    types.
    //1)Maximum Heap
    //2)Minimum Heap

import java.util.ArrayList;
//Note that we are building a Minimum Heap
public class Heap {
    //Internal sturcture and property of heap.
    public ArrayList<Integer> heapArrayList;
    //Initialising initial structure.
    public Heap(){
        heapArrayList=new ArrayList<>();
    }
    //First writing the program that gets the parent of any node.
    public int parent(int index){
        return((index-1)/2);
    }
    //Function to return the left child
    public int left(int index){
        return(2*index+1);
    }
    //Function to return the right child
    public int right(int index){
        return(2*index+2);
    }
    //Function to swap values.
    public void swap(int firstIndex,int secondIndex){
        int temp=heapArrayList.get(firstIndex);
        heapArrayList.set(firstIndex,heapArrayList.get(secondIndex));
        heapArrayList.set(secondIndex, temp);
    }
    //Inserting a number into Min heap.
    public void insert(int value){
        heapArrayList.add(value);
        //Remember how we add element at leaf and then check for the condtion that child must be 
        //smaller than the parent? Then swap if not. That we move from bottom to above, while
        //checking for required condtion.
        //This is called upheap. Below is the code of us performing upheap.
        upheap(heapArrayList.size()-1); 
    }
    //Upheap function.
    public void upheap(int lastIndex){
        if(lastIndex==0){
            return;
        }
        int parentVal=heapArrayList.get(parent(lastIndex));
        int currNodeVal=heapArrayList.get(lastIndex);
        if(currNodeVal<parentVal){
            swap(parent(lastIndex),lastIndex);
            //Continue with upheap.
            upheap(parent(lastIndex));
        }
    }
    //Deleting the element from heap
    //Since its a min head, the root with has the min element will be deleted.And last element will become
    //root.
    public void delete(){
        if(heapArrayList.isEmpty()){
            System.out.println("Not possible");
            return;
        }
        int root=heapArrayList.get(0);
        int last=heapArrayList.get(heapArrayList.size()-1);
        if(!heapArrayList.isEmpty()){
            heapArrayList.set(0, last);
            //Now that change has taken place we start from root compare the children and decend downwards
            //implementing parent<child
            downheap(0);
        }
    }
    //Downheap function
    public void downheap(int currIndex){  
        int leftChild=heapArrayList.get(left(currIndex));
        int rightChild=heapArrayList.get(right(currIndex));
        //First find the min among the children
        int minIndex;
        int minindexVal;
        if(heapArrayList.get(leftChild)<heapArrayList.get(rightChild)){
            minindexVal=heapArrayList.get(leftChild);
            minIndex=leftChild;
        }
        else{
            minindexVal=heapArrayList.get(rightChild);
            minIndex=rightChild;
        }
        //Swapping
        int parentVal=heapArrayList.get(currIndex);
        if(parentVal>minindexVal){
            swap(currIndex, minIndex);
            downheap(minIndex);
        }
    }
    //Heap Sort:Nothing just empty the whole heap and store it in a array.Thats heap sort for you
    public ArrayList<Integer> heapSort(){
        ArrayList<Integer> data = new ArrayList<>();
        while(!heapArrayList.isEmpty()) {
          data.add(heapArrayList.remove(0));
        }
        return data;
      }
}
    //Priority queue is nothing but min or max heap depending on what the priority is.
    