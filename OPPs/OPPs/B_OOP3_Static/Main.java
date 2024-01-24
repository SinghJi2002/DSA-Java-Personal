package OPPs.B_OOP3_Static;

public class Main {
    public static void main(String[] args) {
        Static_Demo_Human ashutosh=new Static_Demo_Human("Ashutosh", 21, 181, 85);
        Static_Demo_Human divyansh=new Static_Demo_Human("Divyansh", 21, 181, 75);
        System.out.println(ashutosh.name);
        System.out.println(divyansh.name);
        System.out.println(ashutosh.population);
        System.out.println(divyansh.population);
        //When you run this code you will see how the output of population variable is same for both
    }
}
