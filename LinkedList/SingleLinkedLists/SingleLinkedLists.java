package SingleLinkedLists;

import Reccursion.n_To_one;

public class SingleLinkedLists{

    //Here we are declaring objects that define the structure of the linked list.
    public Node head;
    public Node tail;
    public int size;

    //This constructor constructs linked linked object whenever called. 
    public SingleLinkedLists(){
        this.size=0;
    }

    //We know that linked list is made of nodes. This class creates a node.
    public class Node{
        //Every node have 2 things thing in single linked list. Value it stores. Next is the node next to it.
        private int value;
        private Node next;

        //The following are two constructors that function on the basis of arguments they recieve.
        public Node(int value){
            this.value=value;
        }

        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }
    //This completes the class and object function of the linked list. Now we see methods/functions that we use to 
    //carry different function.
    
    
    //Insertion
    //We pretty much have the logic figured out.
    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;

        if(tail==null){
            tail=head;
        }
        size+=1;
    }

    //Using recursion
    public void insertUsingRecursion(int value,int index){
        Node temp=head;
        insertUsingRecursion(3, temp, 9);
    }
    public void insertUsingRecursion(int indexCounter,Node temp,int val){
        if(indexCounter==1){
            Node NextNode=temp.next;
            Node indexNode=new Node(val);
            temp.next=indexNode;
            indexNode.next=NextNode;
            return;
        }
        temp=temp.next;
        indexCounter--;
        insertUsingRecursion(indexCounter,temp,val);
    }

    public void insert(int val,int index){
        if(index==0){
            insertFirst(val);
        }
        if(index==size-1){
            insertLast(val);
        }
        //If either are not the case we use the following case.
        Node temp=head;

        for(int i=1;i<index;i++){
            temp=temp.next;
        }

        Node node=new Node(val,temp.next);
        temp.next=node;
        size++;
    }

    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        size++;
    }

    //Deleting Elements
    public void deleteFirst(){
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
    }
    
    public void deleteLast(){
        if(size<=1){
            deleteFirst();
        }
        Node temp=head;
        for(int i=1;i<size-1;i++){
            temp=temp.next;
        }
        tail=temp;
        tail.next=null;
        size--;
    }

    public void delete(int index){
        if(index==0){
            deleteFirst();
        }
        if(index==size-1){
            deleteLast();
        }
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node after=temp.next.next;
        temp.next=after;
        size--;
    }

    //Finding element
    public int find(int value){
        Node node=head;
        int index=0;
        while(node!=null){
            if(node.value==value){
                return(index);
            }
            index++;
            node=node.next;
        }
        return(-1);
    }

    //Display
    public void Display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+" ->");
            temp=temp.next;
        }
        System.out.println("End");
    }

    //Duplicate
    public void duplicate(){
        int len=0;
        if(head==null){
            System.out.println("No element to delete");
            return;
        }
        Node currNode=head;
        Node temp=head;
        len++;
        while(currNode.next!=null){
            if((currNode.next).value==temp.value){
                currNode=currNode.next;
            }
            if(len==1){
                temp=currNode.next;
                head.next=temp;
                len++;
            }
            else{
                temp.next=currNode.next;
                temp=currNode.next;
                len++;
            }
        }
    }

    //Merge two sorted linked list in a new list
    public SingleLinkedLists merge(SingleLinkedLists L1,SingleLinkedLists L2){
        Node head1=L1.head;
        Node head2=L2.head;
        //Create a new linked list to merge our elements
        SingleLinkedLists merged=new SingleLinkedLists();
        while(head1!=null && head2!=null){
            if(head1.value<head2.value){
                merged.insertLast(head1.value);
                head1=head1.next;
            }
            else{
                merged.insertLast(head2.value);
                head2=head2.next;
            }
        }
        while(head1!=null){
            merged.insertLast(head1.value);
            head1=head1.next;
        }
        while(head2!=null){
            merged.insertLast(head2.value);
            head2=head2.next;
        }
        return(merged);
    }

    //Cyclic List-Checking whether a list is cyclic or not. The general logic is simple. We use the
    //slow fast pointer approach. One of them transverses 2 nodes at a time(fast) and the other, one 
    //node a time. If cyclic, they are going to meet at some point or other. When they do, the list 
    //is cyclic. Lets code this.

    public boolean isCyclic(){
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return(true);
            }
        }
        return(false);
        //Before we exit I would like to tell you why did we apply the condition we did apply, in while
        //loop(fast!=null and fast.next!=null). This is because, 1)Its the pointer that runs ahead.
        //2)Since it traverses two steps at a time,we need to also check whether the immediate next is
        //null or not.
    }

    //Next we find the lenght of the cycled component in a cyclic List. Note that the first component 
    //of this will be to check whether the linked list is cyclic or not. After that we execute this.
    //Again the slow fast pointer approach to be used. U already know the basics. What we do here is,as
    //soon as we find slow and fast pointers merging into one another, we stop fast and make slow traverse
    //until it meets fast again. While doing this we keep incrementing out length variable, and then
    //return the length.

    public void cyclicLenght(){
        Boolean condition=false;
        int len=0;
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                condition=true;
            }
        }
        if(condition){
            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(fast==slow){
                    do{
                        slow=slow.next;
                        len++;
                    }while(slow!=fast);
                }
            }
            System.out.println("Lenght of cyclic component is "+len);
        }
        else{
            System.out.println("Not possible");
        }
    }

    //Now the next level in this is to find the node at which the cyclic component starts. Process is
    //1)Find the length of cyclic component.
    //2)Make pointer1 from and mke it traverse for lengths number of times.
    //3)Now take pointer2 from head. Make the pointer2 and pointer1(from its position after traversing
    //L times) traverse until they meet. At this point create index variable,valued 0, keep it incrementing
    //and return it at the end.

    public void cyclicStartNode(){
        Boolean condition=false;
        int len=0;
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                condition=true;
            }
        }
        if(condition){
            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(fast==slow){
                    do{
                        slow=slow.next;
                        len++;
                    }while(slow!=fast);
                }
            }
            System.out.println("Lenght of cyclic component is "+len);
        }
        else{
            System.out.println("Not possible");
        }
        if(condition){
            //Traverse the length
            slow=head;
            fast=head;
            int index=0;
            while(len>0){
                slow=slow.next;
                len--;
            }
            //Now the next pointer
            while(fast!=slow){
                fast=fast.next;
                slow=slow.next;
                index++;
            }
            System.out.println("The index at which circular componenet starts is "+index);
        }
    }

    //Middle of the linked list. Here also we will use the fast slow pointer appproach. The general logic to be applied is that
    //if we have two runners(pointers) running on a track(linked list) with runner 2 pace twice of runner 1, we see that
    //by the time runner 2(fast pointer) completes the track, slow runner(slow pointer) only completes half of the track.
    //Then we return value of slow pointer

    public void middleElement(){
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        System.out.println("The middle value is "+slow.value);
    }

    //Sorting using merge sort
    public Node mergeSort(Node head){
        //Base condition. As soon as head is the only element in linked list.
        if(head==null || head.next==null){
            return(head);
        }
        //Lets divide our LL into two halfs.
        //First lets get the mid element
        Node mid=getMid(head);

        //Now lets get the left and right elements. Also while in the process we define end of left LL as null
        Node left=head;
        Node temp=head;
        Node right=mid;

        while(temp.next!=mid){
            temp=temp.next;
        }
        temp.next=null;

        //Sorting left and right part

        left=mergeSort(left);
        right=mergeSort(right);

        //Merge Sorted Components;
        Node result=mergeMergeSort(left,right);

        return(result);
    }

    //The get mid function
    public Node getMid(Node head){
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return(slow);
    }

    //Merging for merge sort

    public Node mergeMergeSort(Node L1,Node L2){
        Node newNode=new Node(-1);
        Node temp=newNode;
        if(L1==null){
            return(L2);
        }
        if(L2==null){
            return(L1);
        }
        while(L1!=null && L2!=null){
            if(L1.value<L2.value){
                temp.next=L1;
                temp=L1;
                L1=L1.next;
            }
            else{
                temp.next=L2;
                temp=L2;
                L2=L2.next;
            }
        }

        while(L1!=null){
            temp.next=L1;
            temp=L1;
            L1=L1.next;
        }
        while(L2!=null){
            temp.next=L2;
            temp=L2;
            L2=L2.next;
        }
        newNode=newNode.next;
        return(newNode);
    }

    //Reversal of linked list
    //This will be a 3 pointer appraoch. 
    public Node Reversal(Node node){
        Node previous=null;
        Node present=head;
        Node ahead=present.next;
        if(size<2){
            System.out.println("Cannot reverse it");
            return(head);
        }
        while(present!=null){
            present.next=previous;
            previous=present;
            present=ahead;
            if(ahead!=null){
                ahead=ahead.next;
            }
        }
        head=previous;
        return(head);
    }

    //Reverse a part of linked list
    public void reverseBetween(Node head, int left, int right) {
        if (left == right) {
            return;
        }

        // skip the first left-1 nodes
        Node current = head;
        Node prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        Node last = prev;
        Node newEnd = current;

        // reverse between left and right
        Node next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
    }
    
    //Reverse k element wise
    public void kElementWise(int k){
        if(head==null||k==1){
            return;
        }
        int numIterations=size/2;
        Node prev=null;
        Node present=head;
        for(int currIteration=0;currIteration<numIterations;currIteration++){
            Node last=prev;
            Node newEnd=present;
            Node ahead=present.next;
            for(int i=0;present!=null && i<k;i++){
                present.next=prev;
                prev=present;
                present=ahead;
                if(ahead!=null){
                    ahead=ahead.next;
                }
            }
            if(last!=null){
                last.next=prev;
            }
            else{
                head=prev;
            }
            
            newEnd.next=present;
            prev=newEnd;
        }
        

    }
    //The logic is, move to size-k element of the linked list, make it the first by appointing it to head.
    //Also make the size-k-1 element's next element as null. And also make the orignal first  element next of
    //the last element of the orignal linked list.
    public void rotate(int k){
        int requiredIndex=size-k;
        int index=0;
        Node node=head;
        while(node.next!=null){
            node=node.next;
        }
        node.next=head;
        Node temp=head;
        while(index<size && temp.next!=null){
            temp=temp.next;
            index++;
            if(index==requiredIndex-1){
                head=temp.next;
                temp.next=null;
            }
        }

    }

    public void reorder(){
        Node middle=getMid(head);
        Node hs=Reversal(middle);
        Node hf=head;
        while(hf!=null && hs!=null){
            Node temp=hf.next;
            hf.next=hs;
            hf=temp;
            temp=hs.next;
            

        }
    }

    public static void main(String[] args){
        SingleLinkedLists newLinkedList=new SingleLinkedLists();
        SingleLinkedLists newLinkdList=new SingleLinkedLists();
        newLinkedList.insertLast(1);
        newLinkedList.insertLast(4);
        newLinkedList.insertLast(2);
        newLinkedList.insertLast(9);
        newLinkedList.insertLast(8);
        newLinkedList.insertLast(3);
        newLinkedList.insertLast(6);
        newLinkedList.insertLast(5);
        newLinkedList.insertLast(7);
        newLinkdList.insertLast(3);
        newLinkdList.insertLast(5);
        newLinkdList.insertLast(7);
        newLinkdList.insertLast(8);
    
        /*
        SingleLinkedLists merged=new SingleLinkedLists();
        merged=merged.merge(newLinkdList, newLinkedList);

        
        if(newLinkdList.isCyclic()){
            System.out.println("Cyclic Linked List");
        }
        else{
            System.out.println("Not a cyclic linked list");
        }
        
        newLinkedList.cyclicLenght();
        
        newLinkdList.cyclicStartNode();
        

        newLinkedList.middleElement();
        

        newLinkedList.mergeSort(newLinkedList.head);
        */
        newLinkedList.Display();
        newLinkedList.kElementWise(3);
        newLinkedList.Display();

    }
    
}
