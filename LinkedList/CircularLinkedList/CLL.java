package CircularLinkedList;

public class CLL{
    Node head;
    Node tail;

    public CLL(){
        this.head=null;
        this.tail=null;
    }

    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value=value;
        }

        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }

    //Display

    public void Display(){
        Node temp=head;
        if(head==null){
            return;
        }
        do{
            System.out.print(temp.value+"->");
            temp=temp.next;
        }while(temp!=head && temp!=null);
        System.out.println("End");
    }

    

    //Insert Element

    public void Insert(int value){
        Node newNode=new Node(value);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.next=head;
        tail=newNode;
    }

    //Delete Element

    public void delete(int value){
        if(head==null){
            System.out.println("No element found");
            return;
        }
        if(head.value==value){
            head=head.next;
            tail.next=head;
            return;
        }
        Node temp=head;
        Node ahead=temp.next;
        do{
            if(ahead.value==value){
                ahead=ahead.next;
                temp.next=ahead;
            }
        }while(ahead!=head);
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

    public static void main(String[] args) {
        CLL newCll=new CLL();
        newCll.Insert(8);
        newCll.Insert(9);
        newCll.Insert(10);
        newCll.Insert(11);
        newCll.Insert(6);
        newCll.cyclicLenght();
        if(newCll.isCyclic()){
            System.out.println("Cyclic");
        }
        else{
            System.out.println("Not cyclic");
        }
    }
}
