package OOPJPractical;

import java.util.Scanner;

public class Q2 {
    static String text;

    class process extends Thread{
        public void run(){
            try{
                for(int i=text.length()-1;i>=0;i--){
                    System.out.println(text.charAt(i));
                    Thread.sleep(500);
                }
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
        text=sc.next();
        process t1=new process();
        t1.start();
    }
}
