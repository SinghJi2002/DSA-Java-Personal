package Reccursion;

public class J_ObstackleRightLeft {

    public static void paths(String processed,int row,int column, boolean[][] maze){
        if(row==maze.length-1 && column==maze[0].length-1){
            System.out.println(processed);
            return;
        }
        if(!maze[row][column]){
            return;
        }
        if(row<maze.length-1){
            paths(processed+'D',row+1,column,maze);
        }
        if(column<maze[0].length-1){
            paths(processed+'R',row,column+1,maze);
        }
    }

    public static void main(String[] args) {
        int row=0;
        int column=0;
        String processed="";
        boolean[][] maze={{true,true,true},
                    {true,false,true},
                    {true,true,true}};
        paths(processed,row,column,maze);
    }
    
}
