//Single Process and Single Thread
class singleProcessSingleThread extends Thread {
    public void run(){
        System.out.println("Process One");
    }
    public static void main(String[] args) {
        singleProcessSingleThread t=new singleProcessSingleThread();
        t.start();
    }
}


//Single Process Multiple Thread
class singleProcessMultipleThread extends Thread{
    public void run(){
        System.out.println("Process One");
    }
    public static void main(String[] args) {
        singleProcessMultipleThread t1=new singleProcessMultipleThread();
        singleProcessMultipleThread t2=new singleProcessMultipleThread();
        t1.start();
        t2.start();
    }
}


//Multiple Process Single thread: Not possible

//Multiple process multiple thread
class multipleProcessMultipleThread1 extends Thread{
    public void run(){
        System.out.println("Process 1");
    }
}

class multipleProcessMultipleThread2 extends Thread{
    public void run(){
        System.out.println("Process 2");
    }
}

class multipleProcessMultipleThread3 extends Thread{
    public void run(){
        System.out.println("Process 3");
    }
}

class Main{
    public static void main(String[] args) {
        multipleProcessMultipleThread1 t1=new multipleProcessMultipleThread1();
        multipleProcessMultipleThread2 t2=new multipleProcessMultipleThread2();
        multipleProcessMultipleThread3 t3=new multipleProcessMultipleThread3();
        t1.start();
        t2.start();
        t3.start();
    }
}