package Reccursion;

public class H_LeftRightWithPath {

    public static void paths(String processed,int row,int column){
        if(row==1 && column==1){
            System.out.println(processed);
            return;
        }
        if(row>1){
            paths(processed+'D',row-1,column);
        }
        if(column>1){
            paths(processed+'R',row,column-1);
        }

    }

    public static void main(String[] args) {
        int row=3;
        int column=3;
        String processed="";
        paths(processed,row,column);
    }
    
}
