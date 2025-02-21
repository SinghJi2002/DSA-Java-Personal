import java.util.Scanner;

public class I_CheckNumberOfZeros {
    public static int countZeros(int number,int count){
        //Base Case
        if(number%10==number){
            if(number==0){
                count++;
            }
            return count;
        }

        //Counting part
        if(number%10==0){
            count++;
        }

        //Recurrence Relation
        return countZeros(number/10,count);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number");
        int number=sc.nextInt();
        int zerosCount=countZeros(number, 0);
        System.out.println("Number Of Zeros "+zerosCount);
        sc.close();
    }
}
