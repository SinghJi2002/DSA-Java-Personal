public class E_CircularQueue {
    private int circularArray[];
    private int front=0;
    private int end=0;
    private int size=0;
    int default_size=5;

    //Constructors for making queue
    public E_CircularQueue(){
        this.circularArray=new int[default_size];
    }

    public E_CircularQueue(int len){
        this.circularArray=new int[len];
    }

    //Add element to the queue
    public void enqueue(int value){
        if(isFull()){
            System.out.println("The queue is at full capacity, cannot add another element");
            return;
        }
        circularArray[end]=value;
        end++;
        end=end%circularArray.length;
        size++; 
    }
    public boolean isFull(){
        if(size==circularArray.length){
            return(true);
        }
        return(false);
    }

    //Removing element from the queue
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty, nothing to remove");
            return;
        }
        front=front+1;
        front=front%circularArray.length;
        size--;
    }
    public boolean isEmpty(){
        if(size==0){
            return(true);
        }
        return(false);
    }

    //Displaying element
    public void display(){
        int i=front;
        do{
            System.out.print(circularArray[i]+"<-");
            i++;
            i=i%circularArray.length;
        }
        while(i!=end);
        System.out.println("End");
    }

    //Printing the top element of the queue
    public void front(){
        if(isEmpty()){
            System.out.println("Nothing to print here");
            return;
        }
        System.out.println(circularArray[front]);
    }

    public static void main(String[] args) {
        E_CircularQueue queue=new E_CircularQueue();
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
