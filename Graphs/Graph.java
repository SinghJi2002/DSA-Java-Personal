import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
//This code is generally around implenting graphs in java. The main notes of this chap is provided in
//the notepad.
//There are two major ways.
//Adjacency Matrix
//Adjacency List
//Lets first implement adjacency matrix.
//Lets assume that we have N number of node. Then first we need to implement a matrix of dimensions
//[n+1][n+1]. Note that the numbering system implemented here is 1 based indexing.
//Assuming n is 6
    public int[][] adjancyMatrix(int n,int m){
    //The next thing given to us is m. m is the number of edges connecting the nodes of the graph. Along
    //with M, we will have list on transition edges.
    /*Lets assume the transition edges are as follows
    5 6
    1 2
    1 3
    2 4
    3 4 
    3 5 
    4 5
    */
    //Above the numbers that you are seeing are node. 5 6 means that there is a edge between node 5 and 6
    //Next important thing to discuss is that how to we make entries in a adjacency matrix. Let say we 
    //take the 5 6 input. Simple thing we need to do is add 1 to adjancyMatrix[5][6] and also to 
    //adjacency matrix[6][5] if it is undirected in nature.

    //Note that we are implementing for undirected graphs.
    /*Manual way
    int[][] graphsdirected=new int[n+1][n+1];
    //For entry 5-->6
    graphsdirected[5][6]=1;
    graphsdirected[6][5]=1;

    //For entry 1-->2
    graphsdirected[1][2]=1;
    graphsdirected[2][1]=1;

    //For entry 1-->3
    graphsdirected[1][3]=1;
    graphsdirected[3][1]=1;

    //For entry 1-->3
    graphsdirected[1][3]=1;
    graphsdirected[3][1]=1;

    //For entry 2-->4
    graphsdirected[2][4]=1;
    graphsdirected[4][2]=1;

    //For entry 3-->4
    graphsdirected[3][4]=1;
    graphsdirected[4][3]=1;
    
    //For entry 3-->5
    graphsdirected[3][5]=1;
    graphsdirected[5][3]=1;

    //For entry 4-->5
    graphsdirected[4][5]=1;
    graphsdirected[5][4]=1;
    */
    //Create the matrix
    int[][] adjMatrix=new int[n+1][n+1];
    //Now we just need to enter the edges
    for(int i=0;i<m;i++){
        System.out.println("Enter the start and end node of the edge");
        Scanner sc=new Scanner(System.in);
        int u=sc.nextInt();
        int v=sc.nextInt();
        //Now add the 1 value in the matrix.
        adjMatrix[u][v]=1;
        //If its a non-directed graph, reverse addition of 1 is also neccessary.
        adjMatrix[v][u]=1;   
    }
    //Since job is done, return.
    return(adjMatrix);
    }

    public ArrayList<ArrayList<Integer>> adjacencyList(int n,int m){
        //Lets say entered value is 6. So 6 sepererate arraylists will be constructed with assumed 
        //dimension of n+1. Will follow 1-based numbering system. Suppose the entries are 
        /*    
        5 6
        1 2
        1 3
        2 4
        3 4 
        3 5 
        4 5 
        */
        //Then the corresponding array list will look something like this. For non-directed
        /*
        0->{}
        1->{2,3}
        2->{1,4}
        3->{1,4,5}
        4->{2,3,5}
        5->{6,3,4}
        6->{5} 
        */
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        //First we will add empty lists in all the preffered indexes.
        for(int i=0;i<n+1;i++){
            //Create an empty arraylist.
            ArrayList<Integer> emptyArrayList=new ArrayList<>();
            //Add this empty array list in main arraylist
            adjList.add(emptyArrayList);
        }
        //Now lets add the edges of the graph
        for(int i=0;i<m;i++){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the start and the end node of the edges");
            int u=sc.nextInt();
            int v=sc.nextInt();
            //Lets say the edge was 1 2. Then, u=1 and v=2. Now we add the values
            //So to add values, get array at index 1 of adjList, add 2.
            adjList.get(u).add(v);
            //Since its an undirected graph, we need to add in reverse too.
            adjList.get(v).add(u); 
        }
        //Once the job is done return the adjList
        return(adjList);
    }
    
}
