import java.util.Scanner;

public class C_n_To_one {

    public static void PrintTilln(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        PrintTilln(n-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int n=sc.nextInt();
        PrintTilln(n);   
        sc.close();  
    }
}