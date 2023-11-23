package Reccursion;

import java.util.ArrayList;

public class M_PhoneDialPad {

    public static void combo(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        int numeric=unprocessed.charAt(0)-'0';
        for(int i=(numeric-1)*3;i<numeric*3;i++){
            char requiredChar=(char)('a'+i);
            combo(processed+requiredChar,unprocessed.substring(1));
        }
    }
    

    public static void main(String[] args) {
        String processed="";
        String unprocessed="12";
        combo(processed,unprocessed);
    }
    
}
