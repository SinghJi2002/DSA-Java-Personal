package OOPs.B_OOP3_Static;

public class Main {
    String Name;
    public static void main(String[] args) {
        //Everything inside an static entity is static.
        Static_Demo_Human ashutosh=new Static_Demo_Human("Ashutosh", 21, 181, 85);
        Static_Demo_Human divyansh=new Static_Demo_Human("Divyansh", 21, 181, 75);
        System.out.println(ashutosh.name);
        System.out.println(divyansh.name);
        System.out.println(ashutosh.population);
        System.out.println(divyansh.population);
        //greeting();
        //divyansh.greeting();
        //When you run this code you will see how the output of population variable is same for both.
    }
    //One very important thing to note here is that we cannot call a variable or an function that is non-static from a static function. For instance, main is a static function and we cannot call a non-static function from main. It will only produce an error.Though if that non-static variable or function is referenced alongside an object, the problem of accessing non-static content from a static element gets solved.
    
    //For instance see the non-static class below. If we reference it from the main, error is shown.

    public void greeting(){
        System.out.println("Hello "+ Name);
    }
        
    //Though if this same non-static function is called from static function with an object associated to it, no error is seen.

    //Note that keyword such as "this" cannot be used in static functions or variables since this are object independent and "this" represents an object.

}
