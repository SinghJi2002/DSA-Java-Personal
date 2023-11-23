package Reccursion;

import java.util.ArrayList;

public class E_addSubsequencesToArrayList {

    public static void subSequencesToArrayList(String processed,String unprocessed,ArrayList<String> stringArray){
        if(unprocessed.isEmpty()){
            stringArray.add(processed);
            return;
        }
        char ch=unprocessed.charAt(0);

        subSequencesToArrayList(ch+processed, unprocessed.substring(1), stringArray);
        subSequencesToArrayList(processed, unprocessed.substring(1), stringArray);
    }

    public static void main(String[] args) {
        String a="abc";
        String processed="";
        String unprocessed=a;
        ArrayList<String> stringArray=new ArrayList<String>();
        subSequencesToArrayList(processed,unprocessed,stringArray);
        System.out.println(stringArray);
    }
    
}
