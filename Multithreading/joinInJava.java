//join is used when we want a particular thread to complete its work first and then proceed further.
//The thread class has 3 join methods in it(overloading) and each of these throw InterruptedException and its compulsory that when we use join, we either use throw or the try-catch block.

// class test extends Thread{
//     public void run(){
//         for(int i=0;i<5;i++){
//             try{
//                 Thread.sleep(2000);
//                 System.out.println(Thread.currentThread().getName());
//             }catch(InterruptedException e){
//                 System.out.println(e);
//             }
//         }
//     }

//     public static void main(String[] args) {
//         test t1=new test();
//         t1.start();

//         try{
//             t1.join();
//             //Note if incase join would have not been used we would have seen that both the thread are being executed together with thier outputs comming parallely.
//             for(int i=0;i<5;i++){
//                 System.out.println(Thread.currentThread().getName());
//             }
//         }
//         catch(InterruptedException e){
//             System.out.println(e);
//         }
//     }
// }

//Here we are using the join on child thread.
// class test extends Thread{
//     static Thread mainThread;
//     public void run(){
//         try{
//             mainThread.join();
//             Thread.sleep(2000);
//             for(int i=0;i<5;i++){
//                 System.out.println(Thread.currentThread());
//             }
//         }catch(InterruptedException e){
//             System.out.println(e);
//         }
//     }

//     public static void main(String[] args) {
//         mainThread=Thread.currentThread();
//         test t1=new test();
//         t1.start();
//         for(int i=0;i<5;i++){
//             try{
//                 Thread.sleep(1000);
//                 System.out.println(Thread.currentThread());
//             }catch(InterruptedException e){
//                 System.out.println(e);
//             }
//         }
//     }
// }

//Use case

//In lisence making process we require candidate to clear medical, written and driving test that he/she will give indiisually. We will do this using thread and join


class medical extends Thread{
    public void run(){
        System.out.println("Appearing for medical");
        System.out.println("Medical clear");
    }
}

class written extends Thread{
    public void run(){
        System.out.println("Appearing for written exam");
        System.out.println("Exam clear");
    }
}

class testDrive extends Thread{
    public void run(){
        System.out.println("Appearing for test drive");
        System.out.println("Driving test clear");
    }
}

public class joinInJava{
    public static void main(String[] args) {
        try{
            medical t1=new medical();
            t1.start();
            t1.join();
            written t2=new written();
            t2.start();
            t2.join();
            testDrive t3=new testDrive();
            t3.start();
            t3.join();
            System.out.println("Lisence Granted");
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}