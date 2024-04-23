import java.util.Scanner;

class NegetiveNumberException extends Exception{
    public NegetiveNumberException(String message){
        super(message);
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number");
        int num=sc.nextInt();
        try{
            if(num<0){
                throw new NegetiveNumberException("Error Found");
            }
            else{
                System.out.println(num*2);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
