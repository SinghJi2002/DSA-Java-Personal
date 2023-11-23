package Reccursion;
import java.util.Scanner;
public class One_to_n {

    public static int PrintOneTon(int s,int l){
        if(s>l){
            return(-1);
        }
        System.out.println(s);
        return(PrintOneTon(s+1, l));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int n=sc.nextInt();
        int s=1;
        int functionHolder=PrintOneTon(s,n); 
    }
}
