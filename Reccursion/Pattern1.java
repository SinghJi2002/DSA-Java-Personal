/*

****
***
**
*

*/
package Reccursion;

import java.util.Scanner;

public class Pattern1 {

    public static int printStars(int rows,int starCountRow){
        if(starCountRow>0){
            System.out.print('*');
            return(printStars(rows, --starCountRow));
        }
        if(starCountRow==0){
            System.out.println();
            rows=rows-1;
            return(printStars(rows, rows));
        }
        if(rows==0){
            return(-1);
        }
        return(-1);

    }
    
    public static void main(String[] args) {
        System.out.println("Enter the number of rows you want");
        Scanner sc=new Scanner(System.in);
        int rows=sc.nextInt();
        int starCountRow=rows;
        int funcholder=printStars(rows,starCountRow);    
    }    
}
