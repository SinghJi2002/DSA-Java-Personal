//The java threads class has 2 sleep methods(already overidden). One of the function is native(that is it can be executed on other languages) and the other is normal sleep function which takes two arguments, millisec and nanosec. Note that either of the function throws the InteruptedException hence when executed sleep, we need to implement it along try-catch block. Below you will find few instances of us using multithreading in java.

// class test extends Thread{
//     public void run(){
//         System.out.println("Process is running");
//     }

//     public static void main(String[] args) {
//         for(int i=0;i<5;i++){
//             try{
//                 Thread.currentThread().sleep(10000);
//                 test t1=new test();
//                 t1.start();
//             }catch(InterruptedException e){
//                 System.out.println(e);
//             }            
//         }
//     }
// }

// class test extends Thread{
//     public void run(){
//         System.out.println("Process Runing");
//     }

//     public static void main(String[] args) {
//         for(int i=0;i<5;i++){
//             try{
//                 Thread.currentThread().sleep(3000);
//                 System.out.println(i);
//             }catch(InterruptedException e){
//                 System.out.println(e);
//             }
//         }
//         test t1=new test();
//         t1.start();
//     }
// }
// class test extends Thread{
//     public void run(){
//         for(int i=0;i<=5;i++){
//             try{
//                 Thread.sleep(2000);
//                 System.out.println(i);
//             }catch(InterruptedException e){
//                 System.out.println(e);
//             }
//         }
//     }
//     public static void main(String[] args) {
//         test t1=new test();
//         t1.start();
//     }
// }


//Multi-threading single process. multiple thread executed together.
class test extends Thread{
    public void run(){
        try{
            for(int i=0;i<=5;i++){
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(2000);
            }
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        test t1=new test();
        t1.start();
        
        test t2=new test();
        t2.start();
    }
}


//Replaceing start with run. No new thread is created, main thread remains. One process is executed at once
// class test extends Thread{
//     public void run(){
//         try{
//             for(int i=0;i<=5;i++){
//                 System.out.println(Thread.currentThread().getName());
//                 Thread.sleep(2000);
//             }
//         }catch(InterruptedException e){
//             System.out.println(e);
//         }
//     }

//     public static void main(String[] args) {
//         test t1=new test();
//         t1.run();
        
//         test t2=new test();
//         t2.run();
//     }
// }