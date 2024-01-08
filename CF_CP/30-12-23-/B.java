import java.util.Scanner;

public class B {
    public static void GCF(int a, int b){
        if(a==1){
            System.out.println((int)(Math.pow(b, 2)));
            return;
        }
        int gcd=1;
        for(int i = 1; i <= a && i <= b; ++i) {
            if(a % i == 0 && b % i == 0)
              gcd = i;
          }
      
        int lcm = (a * b) / gcd;
        if(lcm==b){
            lcm=lcm*2;
        }
        System.out.println(lcm);
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            GCF(a,b);
        }
    }
}
