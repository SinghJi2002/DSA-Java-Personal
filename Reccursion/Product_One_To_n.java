package Reccursion;
import java.util.Scanner;
public class Product_One_To_n {

    public static int ProductReccur(int n,int count,int product){
        if(count>n){
            return(product);
        }
        product=product*count;
        return(ProductReccur(n,count+1,product));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int n=sc.nextInt();
        int product=1;
        int count=1;
        int funcHolder=ProductReccur(n,count,product);
        System.out.println("Product Of Number is "+funcHolder); 
    }
    
}
