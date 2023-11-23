package Reccursion;

public class FibonacciNums {

    public static int fibonaci(int f1,int f2,int n,int max){
        if(n==max){
            int fn=f1+f2;
            return(fn);
        }
        int fn=f1+f2;
        n=n+1;
        System.out.println(fn);
        return(fibonaci(f2, fn, n, max));
    }
    public static void main(String[] args) {
        int f1=0;
        System.out.println(f1);
        int f2=1;
        System.out.println(f2);
        int turns=2;
        int numberOfTurnsMax=9;
        int fibo=fibonaci(f1,f2,turns,numberOfTurnsMax);
        System.out.println(fibo);
    }
}
