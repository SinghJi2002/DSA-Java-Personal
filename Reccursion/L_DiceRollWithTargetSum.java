package Reccursion;

public class L_DiceRollWithTargetSum {

    public static void rolls(String processed,int target){
        if(target==0){
            System.out.println(processed);
        }
        for(int i=1;i<=6 && i<=target;i++){
            rolls(processed+i, target-i);
        }
    }
    public static void main(String[] args) {
        int target=4;
        String processed="";
        rolls(processed,target);
    }
    
}
