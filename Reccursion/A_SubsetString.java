package Reccursion;

public class A_SubsetString {

    public static String skipAlphabet(String a){
        if(a.length()==0){
            return("");
        }

        char ch=a.charAt(0);

        if(ch=='a'){
            return(skipAlphabet(a.substring(1)));
        }
        else{
            return(ch + skipAlphabet(a.substring(1)));
        }
    }
    
    public static void main(String[] args) {
        String a="ashatosh";
        int lenght=a.length();
        int currElement=0;
        String sol=skipAlphabet(a);
        System.out.println(sol);
    }
    /*Another nethod could have been simply creating a new string, and storing non 'a' elements recursively.*/
}
