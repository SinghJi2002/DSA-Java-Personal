import java.util.Scanner;

class hrsException extends Exception{
    public hrsException(String message){
        super(message);
    }
}
class minsException extends Exception{
    public minsException(String message){
        super(message);
    }

}
class secException extends Exception{
    public secException(String message){
        super(message);
    }
}


class Time{
    int hours;
    int mins;
    int sec;
    public Time(int hours,int mins,int sec){
        this.hours=hours;
        this.mins=mins;
        this.sec=sec;
    }
}


public class Q4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Hour");
        int hrs=sc.nextInt();
        System.out.println("Enter minutes");
        int mns=sc.nextInt();
        System.out.println("Enter seconds");
        int secs=sc.nextInt();
        try{
            if(hrs>24 && hrs<0){
                throw new hrsException("Hours out of limit");
            }
            if(mns>60 && mns<0){
                throw new minsException("Mins out of limit");
            }
            if(secs>60 && secs<0){
                throw new secException("Seconds out of limit");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
