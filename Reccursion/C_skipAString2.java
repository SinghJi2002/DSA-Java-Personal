package Reccursion;

public class C_skipAString2 {

    public static String skipStrings(String a){
        if(a.length()==0){
            return("");
        }
        char ch=a.charAt(0);
        if(a.startsWith("apple") && !a.startsWith("app")){
            return(skipStrings(a.substring(5)));
        }
        else{
            return(ch+skipStrings(a.substring(1)));
        }
    }

    public static void main(String[] args) {
        String a="ilikeapples";
        String solution=skipStrings(a);
        System.out.println(solution);
    }
}


