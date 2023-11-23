package Reccursion;

public class D_Subsequence {

    public static void subsequence(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        //Element to add or remove
        char ch=unprocessed.charAt(0);

        //Two reccursion call to be made.1 with including ch in unprocessed and one without it.
        
        //Included
        subsequence(ch+processed, unprocessed.substring(1));

        //Not included
        subsequence(processed, unprocessed.substring(1));
    }

    public static void main(String[] args) {
        String a="abc";
        String processed="";
        String unProcessed=a;
        subsequence(processed,unProcessed);
    }
}
