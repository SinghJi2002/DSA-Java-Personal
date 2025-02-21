class A_FibonacciNums{
    public static int fib(int n){
        //Base Cases
        if(n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }
        //Recurrence Relation
        int sol=fib(n-1)+fib(n-2);
        //Termination Case 
        return(sol);
    }

    public static void main(String[] args) {
        int n=4;
        int answer=fib(n);
        System.out.println(answer);
    }
}