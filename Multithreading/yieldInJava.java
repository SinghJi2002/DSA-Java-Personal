//Yield stops the current executing thread and executes the other threads of similar priority or higher priority.
//Yield generally signal the OS that it wants to stop and let other process to have the proccessor. Note that its on the processor whether it want to accept the request and allow the context switch, hence yeild can be both successful and unsuccessful at times.

// class test extends Thread{

//     public void run(){
//         System.out.println("Process 1 running");
//     }
//     public static void main(String[] args) {
//         test t1=new test();
//         t1.start(); 
//         for(int i=0;i<5;i++){
//             Thread.yield();
//             //Two thread are being created here, the main thread and t1 thread. When yeild is being called here, the main thread signals the JVM to stop it and allow t1 thread to execute. Hence if accepted you will see that Process 1 Running is printed 5 times and then thread running is printed. Though output can vary.
//             System.out.println("Thread running");
//         }
//     }
// }

class test extends Thread{
    public void run(){
        System.out.println("Process n Running");
    }
    public static void main(String[] args) {
        test t1=new test();
        test t2=new test();
        test t3=new test();
        //Here we have multiple threads in main thread. The thing here is, when yeild is called on main, any of the threads above can be assigned the processor. And when those end, its no gaureentee that, thread next to be executed will be main thread, it can be any thread.
        t1.start();
        t2.start();
        t3.start();
        for(int i=0;i<5;i++){
            Thread.yield();
            System.out.println("Main thread running");
        }        
    }
}