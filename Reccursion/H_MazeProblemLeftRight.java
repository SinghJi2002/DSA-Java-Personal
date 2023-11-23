package Reccursion;

public class H_MazeProblemLeftRight {

    public static int limitedMovement(int row,int column){
        if(row==1 || column==1){
            return 1;
        }
        int down=limitedMovement(row-1, column);
        int right=limitedMovement(row, column-1);
        return(down+right);
    }

    public static void main(String[] args) {
        int row=3;
        int column=3;
        System.out.println(limitedMovement(row,column));
    }
    
}
