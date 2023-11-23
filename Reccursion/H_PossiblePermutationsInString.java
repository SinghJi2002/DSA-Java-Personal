package Reccursion;

public class H_PossiblePermutationsInString {

    public static void Permutations(String processed,String unProcessed){
        if(unProcessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch=unProcessed.charAt(0);
        for(int i=0;i<=processed.length();i++){
            String first=processed.substring(0, i);
            String second=processed.substring(i,processed.length());
            Permutations(first + ch + second,unProcessed.substring(1));
        }
    }
    
    public static void main(String[] args) {
        //First we create the array
        String str="abc";
        String processed="";
        String unProcessed=str;
        Permutations(processed,unProcessed);

    }
}
