package Reccursion;

public class I_PathWhenDiagonalRightDown {

    public static void path(String processed,int row,int column){
        if(row==1 && column==1){
            System.out.println(processed);
            return;
        }
        if(row>1 && column>1){
            path(processed+'D',row-1,column-1);
        }
        if(row>1){
            path(processed+'V',row-1,column);
        }
        if(column>1){
            path(processed+'H',row,column-1);
        }
    }

    public static void main(String[] args) {
        int row=3;
        int column=3;
        String processed="";
        path(processed,row,column);
    }
    
}
