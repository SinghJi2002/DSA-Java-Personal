public class L_Pattern1 {
    public static void pattern(int row,int col){
        //Base Case
        if(row<0){
            return;
        }
        //Printint stars
        System.out.print('*');
        //Change Line Code
        if(row==col){
            System.out.println();
            pattern(row-1,0);
        }
        else{
            //Normal Recursive Call
            pattern(row,col+1);
        }
    }

    public static void main(String[] args) {
        int rows=4;
        int col=0;
        pattern(rows, col);
    }
}
