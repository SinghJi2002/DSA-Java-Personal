import java.util.Scanner;
public class D_One_to_n {

    public static void PrintOneTon(int s,int l){
        if(s>l){
            return;
        }
        System.out.println(s);
        PrintOneTon(s+1, l);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int n=sc.nextInt();
        int s=1;
        PrintOneTon(s,n); 
        sc.close();
    }
}
