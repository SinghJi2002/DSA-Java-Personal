package DoubleLinkedLists;

class doublyLinkedList{
    private Node head;

    public void doublyLinkedList(){
        this.head=null;
    }

    public class Node{
        int val;
        Node next;
        Node prev;
        public Node(int value){
            this.val=value;
        }
        public Node(int value,Node next,Node prev){
            this.val=value;
            this.next=next;
            this.prev=prev;
        }
    }

    //Insert Element in the first Row.
    public void insertFirst(int value){
        Node newNode=new Node(value);
        newNode.next=head;
        newNode.prev=null;
        if(head!=null){
            head.prev=newNode;
        }
        head=newNode;
    }

    //Insert Element at the last index
    public void insertLast(int value){
        if(head==null){
            insertFirst(value);
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node newNode=new Node(value);
        temp.next=newNode;
        newNode.prev=temp;
        newNode.next=null;
    }
    //Insert At Any Index
    public void insert(int value,int index){
        if(index==0){
            insertFirst(value);
            return;
        }
        Node newNode=new Node(value);
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node reserve=temp.next;
        temp.next=newNode;
        newNode.prev=temp;
        newNode.next=reserve;
        reserve.prev=newNode;
    }

    //Deleting Elements 
    //Deleting First Element
    public void deleteFirst(){
        if(head==null){
            System.out.println("No element to delete");
            return;
        }
        head=head.next;
        head.prev=null;
    }

    //Delete Last Element
    public void deleteLast(){
        if(head==null){
            System.out.println("Nothing to delete");
            return;
        }
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }

    //Delete from any index
    public void delete(int value){
        if(head==null){
            System.out.println("Nothing to delete");
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            if(temp.val==value){
                Node behind=temp.prev;
                temp=temp.next;
                behind.next=temp;;
                temp.prev=behind;
                return;
            }
            temp=temp.next;
        }
        
    }

    //Displaying the nodes of a linked list
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("END");
    }

    //Find any given numbers index in DLL
    public int find(int value){
        int index=0;
        Node temp=head;
        while(temp!=null){
            if(temp.val==value){
                return(index);
            }
            temp=temp.next;
            index++;
        }
        return(-1);
    }
}
public class DLL {

    public static void main(String[] args) {
        doublyLinkedList dll=new doublyLinkedList();
        dll.insertFirst(9);
        dll.insertFirst(3);
        dll.insertFirst(5);
        dll.insertFirst(6);
        dll.insertFirst(10);
        dll.insertFirst(1);

        dll.insert(15, 3);

        dll.insertLast(90);

        dll.deleteFirst();

        dll.deleteLast();

        dll.delete(5);
        
        System.out.println(dll.find(3));

        dll.display();

        
    }
    
}
