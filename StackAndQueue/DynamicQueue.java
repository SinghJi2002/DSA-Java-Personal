package StackAndQueue;

public class DynamicQueue {
    //Basic Properties
    private int dynamicArray[];
    private int front=0;
    private int end=0;
    private int size=0;
    int Default_Length=5;

    //Neccessary Constructors
    public DynamicQueue(){
        this.dynamicArray=new int[Default_Length];
    }

    public DynamicQueue(int len){
        this.dynamicArray=new int[len];
    }

    //Few important process
    public void enqueue(int value){
        if(isFull()){
            int temp[]=new int[dynamicArray.length*2];
            for(int i=0;i<dynamicArray.length;i++){
                temp[i]=dynamicArray[i];
            }
            end=dynamicArray.length;
            front=0;
            dynamicArray=temp;
        }
        dynamicArray[end]=value;
        end++;
        end=end%dynamicArray.length;
        size++;
    }
    public boolean isFull(){
        if(size==dynamicArray.length){
            return(true);
        }
        return(false);
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Not element to remove");
            return;
        }
        front++;
        front=front%dynamicArray.length;
        size--;
    }
    public boolean isEmpty(){
        if(size==0){
            return(true);
        }
        return(false);
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Nothing to print");
            return;
        }
        int i=front;
        do{
            System.out.print(dynamicArray[i]+"<-");
            i++;
            i=i%dynamicArray.length;
        }while(i!=end);
        System.out.println("End");
    }

    public void front(){
        if(isEmpty()){
            System.out.println("Nothing to print");
            return;
        }
        System.out.println(dynamicArray[front]);
    }

    public static void main(String[] args) {
        DynamicQueue queue=new DynamicQueue();
        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(0);

        queue.dequeue();

        queue.front();
        

        queue.display();

    }
}
