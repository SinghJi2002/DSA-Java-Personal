package Reccursion;
import java.util.Scanner;

public class n_To_one {

    public static int PrintTilln(int n){
        if(n==0){
            return(-1);
        }
        System.out.println(n);
        return(PrintTilln(n-1));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int n=sc.nextInt();
        int print=PrintTilln(n);     
    }
}