package Reccursion;

public class K_UpDownLeftRight {

    public static void paths(String processed,int row,int column,boolean[][] maze){
        if(row==maze.length-1 && column==maze.length-1){
            System.out.println(processed);
            return;
        }
        if (!maze[row][column]) {
            return;
        }

        maze[row][column]=false;
        //Right Side Movement
        if(row<maze.length-1){
            paths(processed+'R', row+1, column, maze);
        }
        //Down Side Movement
        if(column<maze.length-1){
            paths(processed+'D',row,column+1,maze);
        }
        //Left Side Movement
        if(row>0){
            paths(processed+'L', row-1, column, maze);
        }
        //Up Side Movement
        if(column>0){
            paths(processed+'U',row,column-1,maze);
        }
        maze[row][column]=true;
    }

    public static void main(String[] args) {
        int row=0;
        int column=0;
        String processed="";
        boolean[][] maze={{true,true,true},
                          {true,true,true},
                          {true,true,true}};
        paths(processed,row,column,maze);
    }
    
}
