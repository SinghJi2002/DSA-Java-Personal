# Graphs

In this notes, we are going to discuss about graphs.

## Types Of Graphs

The graphs are of two types. `Undirected Graphs` and `Directed Graphs`. Image-wise we can differentiate them as follows,

__Undirected Graphs__
![alt text](image-2.png)

__Directed Graphs__
![alt text](image-1.png)

## Nodes and Edges

The circular thing in the pictures above are known as nodes or vertex.

The lines that we see above are known as edges. The first diagram has what we call `undirected edge` and the second diagram has `directed edge`.
Note a undirected graph has edges extented in both directions hence also called `bidirectional`. That is a egde between node 1 and 2 can be represented as 1->2 or 2->1 and both representations would be correct. Though in case of directed graphs, since a egde between nodes 2 and 1 can be of a specific direction, there could only exist a single representation. For instance, in the image that we have used above for directed graph, the edge between node 1 and 2(the first two notes on the top) can be written as 1->2 only. Hence, this is `single directional`. 

## Cyclic and Acyclic

Now there is a term here called `Cyclic Graph`. As the name suggest, a closed graph structure is a cyclic graph. The above diagram of undirected graph is cyclic and consists of 3 cycles. The Square cycle, the triangle cycle and the cycle formed via combination of the two. Though note in case of directed graph, we have the square component as cyclic, but triangle component is not cyclic as when we start from one point, we do not get back at it. As a result, the structure as a whole is not cyclic, hence is called a `Acyclic Graph` or in this case, `Directed Acyclic Graph`.

## Path

Defination wise a path consists of lot of nodes and edges which are reachable, such that no node appears twice.

For instance, look at this picture,

![alt text](image.png)

In this picture, 1->2->3->5 and 1->2->3->4 and thier reverse are paths.

## Degree Of Nodes

In essence degree of any node in a undirected graph is the sum all the edges connected to it.

![alt text](image-3.png)

Also note for a undirected graphs,

    Total Degree of a Graph= 2 x Egdes in it

Now lets talk about the directed graph. For any node in a directed graph, there are two types of degree associated to it. `Indegree` and `Outdegree`. `Indegree` represents the total incoming edges, while `Outdegree` represent total number of outgoing edges.

![alt text](image-5.png)

For context look at node 3 of this graph. Outdegree here will be $1$, while in degree here will be $2$. 

## Egde Weight

Every edge in a graph is assigned some weight. For instance, look at the following graphs edges and the weights assigned to them.

![alt text](image-4.png)

If in case no weights are assigned, then we assume that all edges have the weight $1$.

# Representation or Creation Of Graph in Java

Here we are going to discuss how can we create a graph with information given to us.

## Undirected Graph

__Adjacency Matrix__

The information that will be given to us to aid in development of the graph are as follows:

* Number of nodes(n)
* Number of edges(e)
* Pairs of nodes connected to one another

For instance lets say we have been given,

__Number of nodes(N)__=5

__Number of edges(E)__=6

And the node egde pairs are as follows,

* 1->2
* 1->3
* 3->4
* 2->4
* 2->5
* 4->5

Then the resulting graph will be as follows,

![alt text](image-6.png)

But the question is how do we create this kind of graph. Well there are two ways to do it, they are

* Adjacency Matrix
* Adjacency List 

Now here are the steps we have to follow in case of Adjacency Matrix

* First check the type of indexing. Whether its 1-based indexing or 0-based indexing.

* Next we need to construct a matrix of the dimension [N+1]x[N+1]. Something like this,

![alt text](image-7.png)

* Now take a look at the edge-nodes pairs available to us. And start filling the matrix. For instance, for the egde-node pair 1->2 we will fill the boxes (1,2) and (2,1) since the graph is undirected. For instance,

![alt text](image-8.png)

Similar thing will be done for the other pairs.

![alt text](image-9.png)

Remaining can be filled by 0. The space complexity of the process is $O(n^2)$. Hence we not use this method but we use adjacency list.

## Directed Graph

__Adjacency List__

See the simple concept here is we create a nested ArrayList. The number of child arraylist in the main array list will be [N+1]. 

Now note that each child list will represent a node. For instance, child arraylist  1 will be for node 1 and so on. What we will do is fill these lists with neighbours of the concerned node. For the example mentioned above, the list structure will look something like this,

![alt text](image-10.png)

The space complexity here will be $O(2E)$. Note this adjacency list is for a directed graph.

Though its important to note that adjacency matrix and list are not exclusives to Directed and undirected graphs. Both can be used for both of them. Only marking criteria will be different.

## Weighted Graph

Suppose we have the following graph,

![alt text](image-11.png)

Then the pair 1->2 will be represented as,

![alt text](image-12.png)

As observable, the only changes made here was that in place of 1, we fill the matrix with edge weights.

The adjacency list elements will be filled something like this. Here we are presenting only one example of node 4. The entry in the child arraylist will be `(Node Number,Edge weight)`.

![alt text](image-13.png)

Please see the file,

    Graph.java

For code of adjacency matrix and list.  

# Connected Components

![alt text](image-14.png)

In the picture above we may see things in two ways.

* There 4 different graphs
* This whole thing is a graph

Both of the statements are true but we assume that for this case we move on with case $2$. Here the graph has been broken down into 4 different `Components` and connected together.

Now the next question that we need to answer here is how do we traverse the graph its in this manner. Well follow these steps.

* First create a array of lenght [N+1]. This array will be the visited non-visited array, which keeps the record of nodes have been visited and which have not been visited.

* Design a traversal algorithm that can traverse all the notes from a particular node if they are reachable.

* Run code of the structure,

        for(int i=0,len(visited_array),1):
            if(visited_array(i)){
                continue;
            }
            else{
                traversal_algo(Node[i])
            }
Now how will this work?

See the above example. This algo will start at node 1, check if its visited, since no is the answer, traversal algo will be runned, and the node 2, 3 and 4 will be marked visited. The loop will then go to i=2,3,4 but no actions to be taken since they are already visited. Then it will go to 5, check, since not visited, the traversal algorithm will be called. Then, 6 and 7 will be visited. Loop will then go to i=6,7 but no action will be performed since both these nodes have been visited. Similar 8, checked, since unvisited, will call traversal algorithm and then 9 will be visited.Loop will then go to i=9 but no action will be performed since this node have been visited. Then 10 will be visited, barring intervals where the node is already visited and no action is taken.

# Traversal Algorithms

## Breadth First Search Algorithm

See the picture below,

![alt text](image-15.png)

When following BFS, we traverse the graph level by level. For now we assume the starting node is $1$.

![alt text](image-16.png)


We will first traverse level 0, that has 1.
Then we will traverse level 1, that 2 and 6.
Then we will traverse level 2, that has 3,4,7,8.
Then we will traverse level 3, that has 5.

The net path via BFS will be,

    1-> 2-> 6-> 3-> 4-> 7-> 8-> 5

Now lets re-image this. Lets assume the first node in place of 1 is 6. Then, level 0 will have 6. Level 1 will have 1,7,8. The criteria of level 1 is the node are at 1 edge distance from root node.

![alt text](image-17.png)

Now level 2 will have the nodes, at a 2 edge distance from root node. This consists of 2 and 5.

![alt text](image-18.png)

Now level 3 will have the nodes, at a 3 edge distance from node. This consists of 3 and 4.

![alt text](image-19.png)

Hence, the traversel as per BFS is as follows,

    6-> 1-> 7-> 8-> 2-> 5-> 3-> 4

Now lets understand in depth the algorithm of BFS.

* We have been given 5 nodes and 6 edges and Adjacency ArrayList for the graph. 
* We then build a queue and visited/non-visited list.
* Then we see the root node. We turn it to be visited. We then add it to queue.

![alt text](image-20.png)

* Now we remove the first element of the queue. This in this case is 1. When doing so we refer to adjacency list and add the connected nodes in the queue. In this case they will be 2 and 6.

![alt text](image-21.png)

* Now we will repeat the process. We will select the first node on top of queue. In this case it will be 2. We will mark it visited and remove it from queue. We will then add the neighbours of the 2 node to queue. In this case it will be 3 and 4. This process will be continued untill all the nodes have been marked visited. 

To see the code, refer to the file,

    BFS.java

or you can see the code below,

```java 
class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean vis[]=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        
        q.add(0);
        vis[0]=true;
        
        while(!q.isEmpty()){
            Integer node=q.poll();
            bfs.add(node);
            
            for(Integer it: adj.get(node)){
                if(vis[it]==false){
                    vis[it]=true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
}
```

## Depth First Search(DFS)

![alt text](image-22.png)

Here we assume that we are starting at the node 1. In that case we will start from 1 and go to its absolute depth until we reach the leaf node. In that case the traversal will look like as follows,

![alt text](image-25.png)

The DFS traversal till this particular stage will be,

    1->2->5

Now after we have reach the depth we will track back and discover the other depths. Here from 5 we will track back to 2, and then we will go to the other depth which is 6. The traversal will look something like this,

![alt text](image-26.png)

Then traversal till this stage is,

    1->2->5->6

Now that we have discovered all the depth on the left side of 1, we will now move to the right of 1. The next traversals will look like the following,

![alt text](image-27.png)

In above diagram we see DFS traversal backtracking from 6 to 1. This is followed by DFS on the right side of 1, where DFS of 1 will be 3, DFS of 3 will be 7, DFS of 7 will be 8 and DFS of 8 will be 4.

The resultant DFS traversal hence would be,

    1->2->5->6->3->7->8->4

The code for DFS can be observed at the file,

    DFS.java

Or we can view the code here as the following

```java
class DFS {
    
    public static void dfs(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
        
        vis[node]=true;
        ls.add(node);
        
        for(Integer it : adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,adj,ls);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[V+1];
        vis[0]=true;//One indexing
        ArrayList<Integer>ls=new ArrayList<>();
        dfs(0,vis,adj,ls);
        return ls;
    }
}
```

# Question on BFS and DFS

## Number Of Provinces

### Code

```java
class Solution {

    //This is a normal DFS traversal code, so not much to think about here.
    public static void dfs(int node,int[][] isConnected, int countProvinces,boolean[] visitedArray){
        visitedArray[node]=true;
        for(int j=0;j<isConnected[node-1].length;j++){
            if(isConnected[node-1][j]==1 && !visitedArray[j+1]){
                dfs(j+1,isConnected,countProvinces,visitedArray);  
            }
        }
    }
    
    //The whole logic to solving the question lies here.
    public int findCircleNum(int[][] isConnected) {

        //This variable will store the number of provinces that is to be returned at the end of the code.
        int countProvinces=0;

        //This is condition checks whether a graph exists or not.
        if(isConnected.length>0){

            //We have created a visited array. Initially all the nodes are declared false(not visited)
            //except 0 since we are using 1 based index(0 doesnt matter)
            boolean visitedArray[]=new boolean[isConnected[0].length + 1];
            visitedArray[0]=true; //1-based indexing

            //All the logic of solving this question lies here. Here we are looping n number of times,
            //where n represents number of distinct nodes in the graph. If there was a case where there 
            //was only one province, then number of times dfs would have been called from this block of
            //code would have been one. If thats not the case and there exits m provinces, dfs will be 
            //called m times from this code block making the solution to be m.
            for(int i=1;i<isConnected.length+1;i++){
                if(!visitedArray[i]){
                    countProvinces++;
                    dfs(i,isConnected,countProvinces,visitedArray);   
                }
            }
            return(countProvinces);
        }
        return(0);
    }
}
```

### Explanation

I'll provide you with a detailed breakdown of the **"Number of Provinces"** solution so you can use it for revision later. The explanation will cover:

1. **Intuition Behind the Approach**
2. **Concept and Working of the Code**
3. **Line-by-Line Explanation**
4. **Example Execution with Iteration Table**
5. **Complexity Analysis**

---

## **1. Intuition Behind the Approach**
The problem is about finding **the number of connected components in an undirected graph**, where the graph is represented as an **adjacency matrix**.

- Each **city is a node**, and if two cities are directly connected, an edge exists between them.
- A **province** is a connected component, meaning all cities that are directly or indirectly connected belong to the same province.
- We need to **count the number of provinces** (i.e., the number of connected components).

The **Depth First Search (DFS) traversal** is a great way to **visit all nodes of a connected component** before moving to the next. Each DFS call explores a single province completely. The number of times DFS is called from the main function gives the **number of provinces**.

---

## **2. Concept and How the Code Works**
### **Key Observations:**
1. **The given matrix `isConnected` is an adjacency matrix**:
   - `isConnected[i][j] = 1` means **there is a direct connection** between city `i+1` and city `j+1`.
   - `isConnected[i][j] = 0` means **there is no direct connection** between these cities.
   - The matrix is **always symmetric**, meaning if city `A` is connected to city `B`, then city `B` is also connected to city `A`.

2. **The approach involves:** 
   - Keeping a **visited array** to track which cities have been explored.
   - Iterating through each city, and if it's **not visited**, we **start a DFS traversal** from it to mark all reachable cities as visited.
   - Every DFS call represents a **new province**.

---

## **3. Line-by-Line Explanation**
```java
class Solution {
```
- Defines the class `Solution` which contains the methods to solve the problem.

---

### **DFS Function**
```java
public static void dfs(int node, int[][] isConnected, int countProvinces, boolean[] visitedArray) {
```
- This function **performs Depth First Search (DFS)** from the current `node` to visit all connected cities.

```java
visitedArray[node] = true;
```
- Marks the current node as **visited** to avoid re-processing.

```java
for (int j = 0; j < isConnected[node - 1].length; j++) {
```
- Iterates over all cities **to check which ones are directly connected** to the current city (`node`).

```java
if (isConnected[node - 1][j] == 1 && !visitedArray[j + 1]) {
```
- If `node` is connected to city `j+1` **and** that city hasn’t been visited, **call DFS recursively**.

```java
dfs(j + 1, isConnected, countProvinces, visitedArray);
```
- Recursively visit all connected cities.

---

### **Main Function: `findCircleNum`**
```java
public int findCircleNum(int[][] isConnected) {
```
- **Entry point** for solving the problem.

```java
int countProvinces = 0;
```
- This variable **stores the number of provinces**.

```java
if (isConnected.length > 0) {
```
- **Edge case check**: If there are no cities, return `0`.

```java
boolean visitedArray[] = new boolean[isConnected[0].length + 1];
visitedArray[0] = true;
```
- **Create a `visitedArray`** to track visited cities.
- **1-based indexing** is used, so index `0` is ignored.

```java
for (int i = 1; i < isConnected.length + 1; i++) {
```
- **Iterate through all cities** to check if they have been visited.

```java
if (!visitedArray[i]) {
```
- If a city hasn’t been visited, it means it **belongs to a new province**.

```java
countProvinces++;
```
- **Increment the province count**.

```java
dfs(i, isConnected, countProvinces, visitedArray);
```
- **Start DFS traversal** from this city to mark all reachable cities.

```java
return countProvinces;
```
- **Return the total number of provinces**.

---

## **4. Example Execution with Iteration Table**

### **Example Input:**
```plaintext
isConnected = [
    [1, 1, 0],
    [1, 1, 0],
    [0, 0, 1]
]
```

### **Graph Representation**
```
   (1) --- (2)     (3)
```
- Cities `1` and `2` form one province.
- City `3` is isolated and forms another province.

### **Execution Steps**
| Step | City (`i`) | `visitedArray` | `countProvinces` | DFS Call |
|------|-----------|----------------|------------------|----------|
| 1    | `1`       | `[true, false, false, false]` | `1` | Start DFS from `1` |
| 2    | `2` (connected to `1`) | `[true, true, false, false]` | `1` | Continue DFS |
| 3    | `3`       | `[true, true, false, true]` | `2` | Start DFS from `3` |

### **Final Output:** `2` (Number of Provinces)

---

## **5. Complexity Analysis**
### **Time Complexity**
- **DFS runs once per province.**
- Each node is **visited once**.
- **Looping through the matrix** takes \( O(n) \) for each node.

Total complexity: **\( O(n^2) \)** (since we traverse the `isConnected` matrix).

### **Space Complexity**
- **Visited array** takes \( O(n) \).
- **Recursive DFS calls** take at most \( O(n) \) space in the call stack.

Total space complexity: **\( O(n) \)**.

---

## **6. Summary**
- **Problem Type**: Finding **connected components** in a graph.
- **Approach**: DFS traversal with a **visited array**.
- **Key Concept**: Every DFS call **explores one province** completely.
- **Time Complexity**: **\( O(n^2) \)** (for adjacency matrix).
- **Space Complexity**: **\( O(n) \)** (visited array and recursion stack).
- **Edge Cases**:
  - **Single City** → Only one province.
  - **All Cities Connected** → One province.
  - **No Connections** → Each city is its own province.

---

## **Final Thoughts**
This DFS-based approach efficiently finds the number of provinces by treating it as a **graph traversal problem**. The key idea is **each DFS call represents one province**, and the `visitedArray` ensures that we don’t reprocess nodes. The **time complexity is \( O(n^2) \)** due to the adjacency matrix, but it's optimal for small graphs.

This structured breakdown should help you **revisit and revise** the logic of this solution quickly! 🚀

## Rotting Oranges

### Code

```java
class Solution {

    //Helper class
    public class Node{
        int row;
        int col;
        int time;
        public Node(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    
    //Manually finding rotten oranges(traversing to each box).
    public Queue<Node> findRotten(int[][] grid){
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    Node newNode=new Node(i,j,0);
                    q.add(newNode);
                }
            }
        }
        return(q);
    }
    
    public int bfs(int[][] grid,boolean[][] visitedMatrix, Queue<Node> q){

        //This is the variable that is to be returned that tracks number of minutes taken for all the 
        //oranges to rot in a grid if even one rotten one is present
        int currentTime=0;

        //Since the rotten orange rots the good oranges in 4 direction, we have stored all possible
        //direction movement here.
        int[][] possibleDirections={{0,1},{1,0},{-1,0},{0,-1}};
        
        //Now starts the main BFS.
        while(!q.isEmpty()){
            Node outNode=q.poll(); //We have just extracted a rotten orange.
            int r=outNode.row; //We have extracted the row of the rotten orange.
            int c=outNode.col; //We have extracted the column of the rotten orange.

            //Now using the coordinates of the rotten orange, we will move in all 4 adjacent direction of
            //this rotten orange while checking the new coordinate is not visited and the new coordinate
            //contains a 1 or fresh orange. If so, we will make it rotten by changing its value to 2,
            //increase current time by 1 to mark this freshoranges time or decay and update the currentTime
            //variable with the time of this new rotten orange to return later if no further updates are 
            //found. This is continued untill queue finishes out.
            for(int[] iter:possibleDirections){
                int row=r+iter[0];
                int column=c+iter[1];
                if(row>=0 && row<grid.length && column>=0 && column<grid[0].length && !visitedMatrix[row][column] && grid[row][column]==1){
                    Node newNode=new Node(row,column,outNode.time+1);
                    q.add(newNode);
                    visitedMatrix[row][column] = true;
                    grid[row][column] = 2;
                    currentTime=newNode.time;
                }
            }
        }
        return(currentTime);
    }
    
    
    
    public int orangesRotting(int[][] grid) {
        //Making a boolean matrix of grid matrix's dimension to mark the visited and non-visited nodes.
        int r=grid.length;
        int c=grid[0].length;
        boolean[][] visitedMatrix=new boolean[r][c];

        //Call a function findRotten which return a queue with all the rotten oranges and related info as
        //described in the Node class.
        Queue<Node> q=findRotten(grid);

        //Run a BFS via the obtained queue to find adjacent rotten oranges.
        int timeTaken=bfs(grid,visitedMatrix,q);

        // Check if there are any fresh oranges left
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        //Else return the updated current time.
        return(timeTaken);
    }
}
```

### Explanation

I'll provide a **detailed breakdown** of the solution for **Rotting Oranges**, covering:  

1. **Intuition Behind the Approach**  
2. **Concept and Working of the Code**  
3. **Line-by-Line Explanation**  
4. **Example Execution with Iteration Table**  
5. **Complexity Analysis**  

---

# **1. Intuition Behind the Approach**
The problem requires us to find the **minimum time** for all fresh oranges to rot if they can.  

- A **rotting orange (2)** infects adjacent **fresh oranges (1)** in **4 directions (up, down, left, right)**.  
- **Rotting spreads like waves in BFS fashion**—all oranges infected at time `t` will infect their adjacent fresh oranges at `t+1`.  
- If, after processing all rotten oranges, there are still fresh oranges left, return `-1`.  

Since we must **process levels of infection step-by-step**, **Breadth-First Search (BFS)** is the best approach.  

---

# **2. Concept and Working of the Code**
### **Key Observations**
1. **Use BFS with a Queue**  
   - BFS is ideal for finding the **shortest time** required for all fresh oranges to rot.  
   - We store **initial rotten oranges** in a queue and process them **level by level** (minute by minute).  

2. **Processing in Levels (Time Simulation)**  
   - A rotten orange at `(i, j)` rots adjacent fresh oranges in the **next time unit**.  
   - We track time using a `time` variable in the queue.  

3. **Checking for Remaining Fresh Oranges**  
   - If, after BFS, there are still fresh oranges (`1`), **return `-1`** (impossible to rot all oranges).  
   - Otherwise, return the **total time taken**.  

---

# **3. Line-by-Line Explanation**
```java
class Solution {
```
- **Defines the `Solution` class** where our logic resides.  

---

## **Node Class (Helper)**
```java
public class Node {
    int row;
    int col;
    int time;
    public Node(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
```
- **A helper class** to store:  
  - `row`: Row index of the orange.  
  - `col`: Column index of the orange.  
  - `time`: The time at which this orange became rotten.  
- We will use this to **track infected oranges in BFS**.  

---

## **Finding Initially Rotten Oranges**
```java
public Queue<Node> findRotten(int[][] grid) {
    Queue<Node> q = new LinkedList<>();
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 2) {
                Node newNode = new Node(i, j, 0);
                q.add(newNode);
            }
        }
    }
    return q;
}
```
- **This method scans the grid** to find all **initially rotten oranges** (`2`).  
- **Each rotten orange is added to a queue** with its `time = 0`.  
- **Returns a queue** containing all initially rotten oranges.  

---

## **BFS to Rot Fresh Oranges**
```java
public int bfs(int[][] grid, boolean[][] visitedMatrix, Queue<Node> q) {
```
- **BFS traversal to rot fresh oranges** using a queue.  

```java
int currentTime = 0;
```
- Tracks **maximum time taken** to rot all oranges.  

```java
int[][] possibleDirections = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
```
- Stores **4 possible movement directions** (right, down, left, up).  

```java
while (!q.isEmpty()) {
```
- **Start BFS traversal** until all rotten oranges are processed.  

```java
Node outNode = q.poll();
int r = outNode.row;
int c = outNode.col;
```
- **Extract a rotten orange** from the queue and process its adjacent cells.  

```java
for (int[] iter : possibleDirections) {
    int row = r + iter[0];
    int column = c + iter[1];
```
- **Move in 4 directions** from the current rotten orange.  

```java
if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length &&
    !visitedMatrix[row][column] && grid[row][column] == 1) {
```
- **Check if the new position is valid** (within grid limits).  
- **Check if the orange is fresh (`1`)** and has **not been visited** before.  

```java
Node newNode = new Node(row, column, outNode.time + 1);
q.add(newNode);
visitedMatrix[row][column] = true;
grid[row][column] = 2;
currentTime = newNode.time;
```
- **Convert the fresh orange to rotten (`2`)**, mark it as **visited**, and add it to the queue.  
- **Update `currentTime`** to track the maximum time taken.  

```java
return currentTime;
```
- **Return total time taken** after BFS finishes.  

---

## **Main Function**
```java
public int orangesRotting(int[][] grid) {
```
- **Entry point** to solve the problem.  

```java
int r = grid.length;
int c = grid[0].length;
boolean[][] visitedMatrix = new boolean[r][c];
```
- Creates a **visited matrix** to track processed oranges.  

```java
Queue<Node> q = findRotten(grid);
```
- **Finds all initially rotten oranges** and stores them in a queue.  

```java
int timeTaken = bfs(grid, visitedMatrix, q);
```
- **Runs BFS** to spread rot and find the total time taken.  

```java
for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
        if (grid[i][j] == 1) {
            return -1;
        }
    }
}
```
- **Final check**: If any fresh orange (`1`) remains, return **`-1`**.  

```java
return timeTaken;
```
- Otherwise, **return the total time**.  

---

# **4. Example Execution with Iteration Table**
### **Input**
```java
grid = [
    [2, 1, 1],
    [1, 1, 0],
    [0, 1, 1]
]
```
### **Initial State**
```
2  1  1
1  1  0
0  1  1
```
### **BFS Iterations**
| Minute | Rotten Orange Coordinates | Grid After Infection |
|--------|---------------------------|----------------------|
| `0` | `(0,0)` | **(Start BFS)** |
| `1` | `(0,1)`, `(1,0)` | `2  2  1` <br> `2  1  0` <br> `0  1  1` |
| `2` | `(0,2)`, `(1,1)`, `(2,1)` | `2  2  2` <br> `2  2  0` <br> `0  2  1` |
| `3` | `(2,2)` | `2  2  2` <br> `2  2  0` <br> `0  2  2` |
- **Final Answer:** `4`  

---

# **5. Complexity Analysis**
### **Time Complexity**: **O(N × M)**  
- **Finding rotten oranges** takes **O(N × M)**.  
- **BFS visits each cell once**, so it runs in **O(N × M)**.  
- **Final check** takes **O(N × M)**.  
- Overall: **O(N × M)**.  

### **Space Complexity**: **O(N × M)**  
- **Queue stores at most all cells** → O(N × M).  
- **Visited matrix** → O(N × M).  

---

# **Summary**
- **Problem Type**: BFS Traversal (Shortest Path in a Grid).  
- **Approach**:  
  - Use BFS to simulate the **spread of rot** in waves.  
  - Track time taken for **all oranges to rot**.  
  - Return `-1` if any fresh orange remains.  
- **Time Complexity**: **O(N × M)**.  
- **Space Complexity**: **O(N × M)**.

## Flood Fill

### Code

```java
class Solution {
    
    //Helper class.
    public class pair{
        public int first;
        public int second;
        public pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    
    public void bfs(int initialColor,pair node, int newColor, int[][] image, boolean[][] visitedArray){
        //Source point marked as visited.
        visitedArray[node.first][node.second]=true;
        //Color of souce point changed to newColor
        image[node.first][node.second] = newColor;

        //All permissible direction to move from the current node.North, south, east, west.
        int[][] possibleDirections={{0,1},{1,0},{-1,0},{0,-1}};

        //Queue to track the initial color boxes and change them.
        Queue<pair> q=new LinkedList<>();
        q.add(node);

        //This is a basic BFS implementation. What is being done here is simple, we pop out a node from the
        //queue, access its row and column, check for all the element in adjacent direction that have the
        //same color as this node's previous color and have not been already visited. We access each of such 
        //node one by one, convert them into pairs storing thier rows and cols, adding them into the queue
        //marking them visited and changing their original color to new color. This continues untill the 
        //queue is empty.
        while(!q.isEmpty()){
            pair exitedQueue=q.poll();
            for(int[] it:possibleDirections){
                int row=exitedQueue.first+it[0];
                int column=exitedQueue.second+it[1];
                if(row>=0 && row<image.length && column>=0 && column<image[0].length && !visitedArray[row][column] && image[row][column]==initialColor){
                    pair newNode=new pair(row,column);
                    q.add(newNode);
                    visitedArray[row][column] = true;
                    image[row][column]=newColor;
                }
            }
        }
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //Finding total number of rows and columns.
        int r=image.length;
        int c=image[0].length;

        //Building a boolean matrix of same dimensions as of image, to mark visited non-visited.
        boolean[][] visitedMatrix=new boolean[r][c];

        //Accessing the color or source and creating a new Pair.
        int initialColor=image[sr][sc];
        pair node=new pair(sr,sc);

        int newColor=color;

        //Calling the BFS algo
        bfs(initialColor,node,newColor,image, visitedMatrix);

        //Returning the newly formed image.
        return(image);
    }
}
```

### Explanation

I'll provide a **detailed breakdown** of the solution for **Flood Fill**, covering:

1. **Intuition Behind the Approach**  
2. **Concept and Working of the Code**  
3. **Line-by-Line Explanation**  
4. **Example Execution with Iteration Table**  
5. **Complexity Analysis**  

---

# **1. Intuition Behind the Approach**
### **Understanding the Problem Statement**
- You are given a **2D grid (image) of colors**, where each pixel has a specific color.
- You start at a given pixel `(sr, sc)` and need to **change its color** along with all connected pixels of the **same initial color**.
- The connected pixels are those **adjacent in four directions** (up, down, left, right).
- The process stops when there are **no more adjacent pixels** of the **initial color**.

### **Key Observations**
1. **Graph Traversal Problem**  
   - The problem is similar to **finding all reachable nodes in a graph**, where each pixel is a **node** and an edge exists if the adjacent pixel has the **same initial color**.
   - We can use **Breadth-First Search (BFS)** or **Depth-First Search (DFS)**.

2. **Why BFS?**  
   - BFS explores layer by layer, ensuring **all pixels of the same color** get changed in the shortest number of steps.
   - BFS uses a **queue** to process pixels level by level.

3. **What Needs to be Done?**  
   - Start from `(sr, sc)`, and **change its color**.
   - Traverse in **4 directions** (left, right, up, down) **only if**:
     - The adjacent pixel has the **same initial color**.
     - The adjacent pixel **has not been visited yet**.
   - Repeat the process **until no more adjacent pixels can be changed**.

---

# **2. Concept and Working of the Code**
### **Step-by-Step Execution**
1. **Store the Initial Color**  
   - Before we start, store the **color of the starting pixel**.  

2. **Use a Queue for BFS Traversal**  
   - The queue helps to explore **each pixel level by level**.  
   - Start with the given pixel `(sr, sc)` and process its **adjacent** pixels.  

3. **Keep Track of Visited Pixels**  
   - We use a **boolean matrix (`visitedMatrix`)** to **avoid revisiting** already processed pixels.  

4. **Change Colors Until BFS Queue is Empty**  
   - While there are pixels left in the queue:
     - **Extract the front pixel**.
     - **Move in four possible directions** (up, down, left, right).
     - **Change its color if conditions are met**.
     - **Push the newly colored pixel into the queue**.
   - The process stops when the **queue is empty**.

---

# **3. Line-by-Line Explanation**
```java
class Solution {
```
- **Defines the `Solution` class** that contains the implementation.

---

## **Helper Class (Pair)**
```java
public class pair {
    public int first;
    public int second;
    public pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
```
- **Defines a helper class** `pair` to store:
  - `first`: Row index of a pixel.
  - `second`: Column index of a pixel.
- **This is used in the BFS queue** to store pixel coordinates.

---

## **BFS Implementation**
```java
public void bfs(int initialColor, pair node, int newColor, int[][] image, boolean[][] visitedArray) {
```
- **Implements the BFS function** to perform the flood fill.

```java
visitedArray[node.first][node.second] = true;
image[node.first][node.second] = newColor;
```
- **Marks the starting pixel as visited** and **changes its color**.

```java
int[][] possibleDirections = {{0,1}, {1,0}, {-1,0}, {0,-1}};
```
- **Defines the 4 possible movement directions**:
  - `{0,1}` → **Right**
  - `{1,0}` → **Down**
  - `{-1,0}` → **Up**
  - `{0,-1}` → **Left**

```java
Queue<pair> q = new LinkedList<>();
q.add(node);
```
- **Creates a queue** and **adds the starting pixel** to process.

---

## **BFS Traversal**
```java
while (!q.isEmpty()) {
```
- **Starts BFS traversal** while there are pixels left in the queue.

```java
pair exitedQueue = q.poll();
```
- **Extracts the front pixel from the queue**.

```java
for (int[] it : possibleDirections) {
```
- **Iterates over the 4 possible movement directions**.

```java
int row = exitedQueue.first + it[0];
int column = exitedQueue.second + it[1];
```
- **Computes new pixel coordinates**.

```java
if (row >= 0 && row < image.length && column >= 0 && column < image[0].length 
    && !visitedArray[row][column] && image[row][column] == initialColor) {
```
- **Checks if the new pixel**:
  - Is **within bounds** of the grid.
  - Has **not been visited**.
  - Has the **same initial color**.

```java
pair newNode = new pair(row, column);
q.add(newNode);
visitedArray[row][column] = true;
image[row][column] = newColor;
```
- **Marks it as visited, changes color, and adds to queue**.

---

## **Main Function**
```java
public int[][] floodFill(int[][] image, int sr, int sc, int color) {
```
- **Entry point of the solution**.

```java
int r = image.length;
int c = image[0].length;
boolean[][] visitedMatrix = new boolean[r][c];
```
- **Creates a `visitedMatrix`** of the same size as `image`.

```java
int initialColor = image[sr][sc];
pair node = new pair(sr, sc);
int newColor = color;
```
- **Stores the initial color and creates the starting pixel pair**.

```java
bfs(initialColor, node, newColor, image, visitedMatrix);
```
- **Calls the BFS function**.

```java
return image;
```
- **Returns the modified image**.

---

# **4. Example Execution with Iteration Table**
### **Input**
```java
image = [
    [1,1,1],
    [1,1,0],
    [1,0,1]
]
sr = 1, sc = 1, newColor = 2
```
### **Initial State**
```
1  1  1
1  1  0
1  0  1
```
### **BFS Iterations**
| Step | Queue | Pixel Processed | Grid After Change |
|------|--------|----------------|----------------------|
| `0`  | `(1,1)` | `(1,1) → 2` | `1  1  1`<br> `1  2  0`<br> `1  0  1` |
| `1`  | `(0,1), (1,0)` | `(0,1) → 2` | `1  2  1`<br> `1  2  0`<br> `1  0  1` |
| `2`  | `(1,0), (0,0)` | `(1,0) → 2` | `1  2  1`<br> `2  2  0`<br> `1  0  1` |
| `3`  | `(0,0), (2,0)` | `(0,0) → 2` | `2  2  1`<br> `2  2  0`<br> `1  0  1` |
| `4`  | `(2,0)` | `(2,0) → 2` | `2  2  1`<br> `2  2  0`<br> `2  0  1` |
- **Final Output:**  
```
2  2  1
2  2  0
2  0  1
```

---

# **5. Complexity Analysis**
### **Time Complexity**: **O(N × M)**
- Each cell is **visited once**.

### **Space Complexity**: **O(N × M)**
- **Queue and visited matrix** take **O(N × M)**.

---

# **Summary**
- **Algorithm**: BFS Traversal.
- **Time Complexity**: O(N × M).
- **Space Complexity**: O(N × M).

## Surrounded Regions

### Code

```java
class Solution {
    
    public class Node{
        int row;
        int col;
        public Node(int r,int c){
            this.row=r;
            this.col=c;
        }
    }
    
    //The first step is simple, we do a normal N^2 traversal of the matrix and check for the presence of 
    // 'O' on the boundaries of the matrix. If found, we capture thier row and column, create a Node and 
    //then add them into queue, while marking them visited and changing thier value to 'Z'.
    public Queue<Node> traversal(char[][] board,boolean[][] visitedMatrix){
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if (board[i][j] == 'O' && (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)){
                    Node newNode=new Node(i,j);
                    q.add(newNode);
                    visitedMatrix[i][j]=true;
                    board[i][j]='Z';
                }
            }
        }
        return(q);
    }
    
    //We now do a BFS traversal using the element we got in the queue in previous 'traversal' function. The
    //goal will be simple, to find all the 'O' connected to the 'O's at the boundary of the matrix.
    //Execution is simple, pop the node, traverse in all its adjacent direction to find the 'O', take its
    //row and column data, turn it into node, add it into queue, while marking it visited and chaning its
    //value to 'Z'. Do this until queue is empty/all 'O's connected to boundary 'O' are identified as 'Z'. 
    public void bfs(char[][] board,boolean[][] visitedMatrix, Queue<Node> q){
        int[][] possibleDirections={{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            Node outNode=q.poll();
            int r=outNode.row;
            int c=outNode.col;
            for(int[] iter:possibleDirections){
                int row=r+iter[0];
                int col=c+iter[1];
                if(row>=0 && row<board.length && col>=0 && col<board[0].length && !visitedMatrix[row][col] && board[row][col]=='O'){
                    visitedMatrix[row][col]=true;
                    Node newNode=new Node(row,col);
                    q.add(newNode);
                    board[row][col]='Z';
                }
            }
        }
    }
    
    
    //Now the question stated, all the 'O' enclosed by 'X', are to be converted to 'X'. The 'O' written as
    //'Z' cannot come into this category as they have atleast one end touching the boundary of matrix
    //preventing enclosure by 'X'. Rest of the 'O' however will be converted to 'X'. This function does 
    //exactly that.
    public void traversalFinal(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if (board[i][j] == 'Z'){
                    board[i][j]='O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j]='X';
                }
            }
        }
    }
    
    
    
    public void solve(char[][] board) {
        int r=board.length;
        int c=board[0].length;
        boolean[][] visitedMatrix=new boolean[r][c];
        Queue<Node> q=traversal(board,visitedMatrix);
        bfs(board,visitedMatrix,q);
        traversalFinal(board);
    }
}
```

### Explanation

I'll provide a **detailed breakdown** of the solution for **Surrounded Regions**, covering:

1. **Intuition Behind the Approach**  
2. **Concept and Working of the Code**  
3. **Line-by-Line Explanation**  
4. **Example Execution with Iteration Table**  
5. **Complexity Analysis**  

---

# **1. Intuition Behind the Approach**
### **Understanding the Problem Statement**
- You are given a **2D grid (board)** containing `'X'` and `'O'`.
- Any `'O'` **completely surrounded** by `'X'` should be flipped to `'X'`.
- Any `'O'` that **touches the boundary** should remain unchanged.
- The goal is to **find all enclosed regions of `'O'` and convert them to `'X'`**.

### **Key Observations**
1. **Finding Enclosed Regions**  
   - Any `'O'` that is **not connected** to the boundary `'O'` is an **enclosed region**.
   - A BFS (or DFS) can be used to **explore all 'O's** connected to boundary `'O'`.

2. **Marking Non-Enclosed Regions First**  
   - Instead of checking every `'O'` to see if it’s enclosed, **first identify 'O's connected to the boundary**.
   - We temporarily mark these `'O'`s (e.g., as `'Z'`).

3. **Final Conversion Step**  
   - Convert all `'O'`s (which are enclosed) to `'X'`.
   - Convert all `'Z'`s (which were connected to the boundary) back to `'O'`.

### **Strategy**
1. **Identify 'O' on Boundaries** → Use BFS to mark connected 'O' as `'Z'`.
2. **Traverse the Grid Again** → Convert enclosed `'O'` to `'X'` and `'Z'` back to `'O'`.

---

# **2. Concept and Working of the Code**
### **Step-by-Step Execution**
1. **Identify Boundary `'O'`**  
   - Traverse the entire grid to find **'O' on boundaries**.
   - Store their **coordinates** in a queue and mark them as visited.
   - Change them temporarily to `'Z'`.

2. **BFS to Mark Connected Regions**  
   - Perform **BFS from each boundary `'O'`**, marking all **reachable** `'O'`s as `'Z'`.

3. **Final Traversal to Convert Values**  
   - Convert all **remaining** `'O'` to `'X'` (since they are enclosed).
   - Convert `'Z'` back to `'O'` (since they were touching the boundary).

---

# **3. Line-by-Line Explanation**
```java
class Solution {
```
- **Defines the `Solution` class** that contains the solution.

---

## **Helper Class (Node)**
```java
public class Node {
    int row;
    int col;
    public Node(int r, int c) {
        this.row = r;
        this.col = c;
    }
}
```
- **Defines a helper class** `Node` to store:
  - `row`: Row index of a cell.
  - `col`: Column index of a cell.
- **Used for BFS traversal**.

---

## **Step 1: Identify Boundary 'O'**
```java
public Queue<Node> traversal(char[][] board, boolean[][] visitedMatrix) {
    Queue<Node> q = new LinkedList<>();
```
- **Creates a queue** for BFS traversal.
- `visitedMatrix` is used to track visited cells.

```java
for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[0].length; j++) {
```
- **Iterates through the entire board**.

```java
if (board[i][j] == 'O' && (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)) {
```
- **Finds all `'O'` cells on the boundary**.

```java
Node newNode = new Node(i, j);
q.add(newNode);
visitedMatrix[i][j] = true;
board[i][j] = 'Z';
```
- **Marks boundary 'O' as visited and temporarily changes them to 'Z'**.
- **Adds the node to the queue** for BFS traversal.

---

## **Step 2: BFS to Mark Connected 'O'**
```java
public void bfs(char[][] board, boolean[][] visitedMatrix, Queue<Node> q) {
    int[][] possibleDirections = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
```
- **Defines four possible movement directions** (right, down, left, up).

```java
while (!q.isEmpty()) {
    Node outNode = q.poll();
    int r = outNode.row;
    int c = outNode.col;
```
- **Processes each node in the queue**.

```java
for (int[] iter : possibleDirections) {
    int row = r + iter[0];
    int col = c + iter[1];
```
- **Calculates new row and column**.

```java
if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && !visitedMatrix[row][col] && board[row][col] == 'O') {
```
- **Checks if the new cell is within bounds, unvisited, and is 'O'**.

```java
visitedMatrix[row][col] = true;
Node newNode = new Node(row, col);
q.add(newNode);
board[row][col] = 'Z';
```
- **Marks it as visited, adds to queue, and changes 'O' to 'Z'**.

---

## **Step 3: Convert Enclosed 'O' to 'X'**
```java
public void traversalFinal(char[][] board) {
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
```
- **Iterates over the entire board**.

```java
if (board[i][j] == 'Z') {
    board[i][j] = 'O';
} else if (board[i][j] == 'O') {
    board[i][j] = 'X';
}
```
- **Converts all remaining 'O' to 'X'** (enclosed regions).
- **Converts 'Z' back to 'O'** (boundary-connected regions).

---

## **Main Function**
```java
public void solve(char[][] board) {
    int r = board.length;
    int c = board[0].length;
    boolean[][] visitedMatrix = new boolean[r][c];
    Queue<Node> q = traversal(board, visitedMatrix);
    bfs(board, visitedMatrix, q);
    traversalFinal(board);
}
```
- **Calls all three steps in sequence**.

---

# **4. Example Execution with Iteration Table**
### **Input**
```java
board = [
    ['X', 'X', 'X', 'X'],
    ['X', 'O', 'O', 'X'],
    ['X', 'X', 'O', 'X'],
    ['X', 'O', 'X', 'X']
]
```
### **Initial State**
```
X  X  X  X
X  O  O  X
X  X  O  X
X  O  X  X
```

### **Step 1: Mark Boundary 'O' as 'Z'**
```
X  X  X  X
X  O  O  X
X  X  O  X
X  Z  X  X
```

### **Step 2: BFS Marks Connected 'O'**
```
X  X  X  X
X  O  O  X
X  X  O  X
X  Z  X  X
```

### **Step 3: Convert 'O' to 'X', 'Z' back to 'O'**
```
X  X  X  X
X  X  X  X
X  X  X  X
X  O  X  X
```

---

# **5. Complexity Analysis**
### **Time Complexity**: **O(N × M)**
- Each cell is visited **at most twice**.

### **Space Complexity**: **O(N × M)**
- **Queue and visited matrix** take **O(N × M)**.

---

# **Summary**
- **Algorithm**: BFS Traversal.
- **Time Complexity**: O(N × M).
- **Space Complexity**: O(N × M).

## Number of Enclaves

### Code

```java
class Solution {
    
    public class Node{
        int row;
        int col;
        public Node(int r,int c){
            this.row=r;
            this.col=c;
        }
    }

    //The first step is simple, we do a normal N^2 traversal of the matrix and check for the presence of 
    // '1' or land on the boundaries of the matrix. If found, we capture thier row and column, create a Node and 
    //then add them into queue, while marking them visited and changing thier value to '0' or land from 
    //which I can walk off.
    public Queue<Node> traversal(int[][] arr,boolean[][] visitedMatrix){
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1 && (i == 0 || i == arr.length - 1 || j == 0 || j == arr[0].length - 1)){
                    Node newNode=new Node(i,j);
                    q.add(newNode);
                    arr[i][j]=0;
                    visitedMatrix[i][j]=true;
                }
            }
        }
        return(q);
    }
    
    //We now do a BFS traversal using the element we got in the queue in previous 'traversal' function. The
    //goal will be simple, to find all the '1' connected to the '1's at the boundary of the matrix.
    //Execution is simple, pop the node, traverse in all its adjacent direction to find the '1', take its
    //row and column data, turn it into node, add it into queue, while marking it visited and chaning its
    //value to '0'. Do this until queue is empty/all '1's connected to boundary '1' are identified as '0'.
    public void bfs(int[][] grid,boolean[][] visitedMatrix,Queue<Node> q){
        int[][] possibleDirections={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            Node outNode=q.poll();
            int r=outNode.row;
            int c=outNode.col;
            for(int[] iter:possibleDirections){
                int row=r+iter[0];
                int col=c+iter[1];
                if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1 && !visitedMatrix[row][col]){
                    Node newNode=new Node(row,col);
                    q.add(newNode);
                    grid[row][col]=0;
                    visitedMatrix[row][col]=true;
                }
            }
        }
    }
    
    //Now the question stated, all the '1's not adjoining the boundary from any end can be considered as land
    //from which we cannot walk off. In previous traversals, we have already marked the boundary '1's and
    //the '1's connected to the boundary '1's are 0. Hence the remaining '1's will be the answer and 
    //that is what we are counting here.
    public int finalTraverse(int[][] grid){
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return(count);
    }
    
    public int numEnclaves(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        boolean[][] visitedMatrix=new boolean[r][c];
        Queue<Node> q=traversal(grid,visitedMatrix);
        bfs(grid,visitedMatrix,q);
        int sol=finalTraverse(grid);
        return(sol);
    }
}
```

### Explanation

**Intuition Behind the Approach:**
The problem requires us to count the number of land cells ('1's) that are completely enclosed within the grid and cannot reach the boundary. This means that if a '1' is connected to another '1' that eventually leads to the boundary, it is not enclosed and should not be counted.

A natural way to approach this problem is to first identify all '1's that are on the boundary or connected to a boundary '1'. We can eliminate these from consideration and then simply count the remaining '1's.

We can achieve this by:
1. Performing a traversal of the boundary cells to identify '1's.
2. Using BFS (or DFS) to mark all reachable '1's from these boundary points as visited.
3. Counting the remaining '1's in the grid that were not visited.

---

**Concept of How the Code Works:**
1. **Identify Boundary '1's:** Traverse the grid and find all '1's located on the boundaries. These '1's are converted into '0's and stored in a queue for BFS traversal.
2. **BFS Traversal:** Using the queue, process each node, visiting its adjacent '1's, converting them into '0's, and marking them as visited.
3. **Count Remaining '1's:** Any '1' that remains in the grid after BFS must be an enclave, as it is not connected to any boundary. The final step is to count these '1's.

---

**Detailed Explanation of the Code:**

```java
class Solution {
    
    public class Node{
        int row;
        int col;
        public Node(int r,int c){
            this.row=r;
            this.col=c;
        }
    }
```
- Defines a `Node` class to store row and column indices.
- Helps in BFS traversal by representing grid coordinates.

```java
    public Queue<Node> traversal(int[][] arr,boolean[][] visitedMatrix){
        Queue<Node> q=new LinkedList<>();
```
- Initializes a queue for BFS traversal.

```java
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1 && (i == 0 || i == arr.length - 1 || j == 0 || j == arr[0].length - 1)){
                    Node newNode=new Node(i,j);
                    q.add(newNode);
                    arr[i][j]=0;
                    visitedMatrix[i][j]=true;
                }
            }
        }
```
- Iterates over all elements in the grid.
- If a '1' is found on a boundary, it:
  - Converts it to '0' (indicating it's not an enclave).
  - Marks it as visited.
  - Adds it to the queue for BFS processing.

```java
        return(q);
    }
```
- Returns the queue containing all boundary '1's for BFS traversal.

```java
    public void bfs(int[][] grid,boolean[][] visitedMatrix,Queue<Node> q){
        int[][] possibleDirections={{0,1},{1,0},{-1,0},{0,-1}};
```
- Defines directions for BFS traversal: right, down, up, left.

```java
        while(!q.isEmpty()){
            Node outNode=q.poll();
            int r=outNode.row;
            int c=outNode.col;
```
- Extracts a node from the queue and retrieves its row and column indices.

```java
            for(int[] iter:possibleDirections){
                int row=r+iter[0];
                int col=c+iter[1];
                if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1 && !visitedMatrix[row][col]){
                    Node newNode=new Node(row,col);
                    q.add(newNode);
                    grid[row][col]=0;
                    visitedMatrix[row][col]=true;
                }
            }
        }
```
- Checks all four directions from the current node.
- If a connected '1' is found:
  - Converts it to '0'.
  - Marks it as visited.
  - Adds it to the queue.
- Continues until all reachable '1's from the boundary are processed.

```java
    public int finalTraverse(int[][] grid){
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return(count);
    }
```
- Iterates through the grid and counts remaining '1's (enclaves).

```java
    public int numEnclaves(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        boolean[][] visitedMatrix=new boolean[r][c];
        Queue<Node> q=traversal(grid,visitedMatrix);
        bfs(grid,visitedMatrix,q);
        int sol=finalTraverse(grid);
        return(sol);
    }
}
```
- Calls the three main functions in sequence.
- Returns the count of enclave '1's.

---

**Example Execution:**

| Iteration | Queue | Grid (partial) | Visited | Notes |
|-----------|-------|---------------|---------|-------|
| Initial   | [(0,1), (1,0)] | 1 0 1 0 \n 0 1 0 1 | 1 1 0 0 \n 0 0 0 0 | Identify boundary '1's |
| BFS 1     | [(1,0)] | 0 0 1 0 \n 0 1 0 1 | 1 1 0 0 \n 0 0 0 0 | Mark (0,1) as '0' |
| BFS 2     | [] | 0 0 1 0 \n 0 1 0 1 | 1 1 0 0 \n 0 0 0 0 | Mark (1,0) as '0' |
| Counting  | - | - | - | Count remaining '1's |

---

**Complexity Analysis:**

1. **Boundary Traversal:** O(N * M)
2. **BFS Traversal:** O(N * M)
3. **Final Counting:** O(N * M)

**Overall Complexity:** **O(N * M)**, where **N** is the number of rows and **M** is the number of columns.

---

This detailed explanation provides a comprehensive breakdown of the logic and execution of the problem.



# Topographical Sort DFS

![alt text](image-23.png)

Lets assume this is image we are going to use to understand topo sort. Now what is topo sort?
    
    Topological sort is a linear ordering of vertices/nodes such that if there is a edge between u & v, u appears before v in that ordering.

Note that topological sort can only be applied on `Directed Acyclic Graph`.

Hence for this case topo sort will be,

    5 4 2 3 1 0

The code is as follows,

```
class Solution
{
    
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stk,boolean[] visitedArray){
        visitedArray[node]=true;
        for(Integer iter:adj.get(node)){
            if(!visitedArray[iter]){
                dfs(iter,adj,stk,visitedArray);
            }
        }
        stk.push(node);
    }
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean[] visitedArray=new boolean[V];
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<V;i++){
            if(!visitedArray[i]){
                dfs(i,adj,stk,visitedArray);
            }
        }
        int[] sol=new int[V];
        int index=0;
        while(!stk.isEmpty()){
            sol[index++]=stk.pop();
        }
        return(sol);
    }
}
```

Now lets understanding how is this happening. 

The process is simple, run a simple loop from node 0 to node n-1. We will call normal DFS algorithm, and reach to the terminal nodes on each call, while maintaining visitedNode array. Terminal node are nodes that have 0 out degree. On each DFS call whenever we encounter terminal nodes , we will add the terminal nodes to a stack. Once done, we will then add the previous nodes to terminal nodes to stack too. Once all the nodes are visited, we will the pull out elements from stack and add to topo sort array. The array obtained after this operation is topo sort array.

## Topographical Sort BFS- Kahn Algorithm

![alt text](image-23.png)

Lets assume this is image we are going to use to understand topo sort. Now what is topo sort?
    
    Topological sort is a linear ordering of vertices/nodes such that if there is a edge between u & v, u appears before v in that ordering.

Note that topological sort can only be applied on `Directed Acyclic Graph`.

Hence for this case topo sort will be,

    5 4 2 3 1 0

The code is as follows,
```
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Queue<Integer> q=new LinkedList<>();
        int[] inDegree=new int[V];
        int[] sol=new int[V];
        for(int i=0;i<V;i++){
            for(Integer iter:adj.get(i)){
                inDegree[iter]++;
            }   
        }
        for(int j=0;j<V;j++){
            if(inDegree[j]==0){
                q.add(j);
            }
        }
        int index=0;
        while(!q.isEmpty()){
            int outNode=q.poll();
            sol[index++]=outNode;
            for(Integer it:adj.get(outNode)){
                inDegree[it]--;
                if(inDegree[it]==0){
                    q.add(it);
                }
            }
        }
        return(sol);
    }
}
```

Now lets understanding how is this happening. 

We create a few elements. A queue, a inDegree array, and sol array that will store the topo sort. We will analyse the adjacency list or matrix, and we then calculate inDegree of each node. Initially we will check inDegree of each node, if found 0, we will add those nodes into queue. Now after that we will start a loop until the queue is not empty.

Inside the loop, we will pull elements from the queue, and after than all the nodes to which this node was connected, thier inDegree is reduced. Checks are run whether any node's inDegree has turned 0 and then that elements is added to queue. After that, again element are removed from queue and this loop continues.

## Cycle Detection in Directed Graphs Using Topo Sort

Concept is simple, Topo sort only acts on DAG. If cyclic graph comes, topo sort won't work perfectly. When topo sort is run of such graphs length of the topo sort array will be less than actual number of node. On comparison of length we can hence conclude whether graph is cyclic or not.


## Shortest Path Distance

### Directed Acyclic Graph

The algorithm is quite simple.

1) If given a adjacency matrix, first convert it to adjacency list. Store elements here in the form of pairs, containing the node and the distance values.

2) Apply topo sort to find the order of integers and last and first elements but do not throw them out of the queue just yet.

3) Create a distanceArray(initialise it with max_value) which will be returned as solution. Turn the distance for the first node(found via peek in queue).

4) Now run a simple algorithm, pop one element out of queue, check for its adjacent nodes, see the distance of currentNode+distance of adjacent node is less than the value already saved, and if yes update. Repeat this step until the queue is empty.

5) Mark all the unvisited elements distances as -1.

The solution code is as follows,

```
class Solution {
    
    public class Pair {
        int node;
        int distance;
        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    
    public void dfs(ArrayList<ArrayList<Pair>> adj, boolean[] visitedArray, Stack<Integer> stk, int node) {
        visitedArray[node] = true;
        for (Pair iter : adj.get(node)) {
            if (!visitedArray[iter.node]) {
                dfs(adj, visitedArray, stk, iter.node);
            }
        }
        stk.push(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        // Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            adj.add(new ArrayList<>());
        }
       
        // Add elements to adjacency list
        for (int k = 0; k < M; k++) {
            Pair element = new Pair(edges[k][1], edges[k][2]);
            adj.get(edges[k][0]).add(element);
        }
        
        // Create DFS elements
        boolean[] visitedArray = new boolean[N];
        Stack<Integer> stk = new Stack<>();
        
        // Run DFS Topo Sort
        for (int i = 0; i < N; i++) {
            if (!visitedArray[i]) {
                dfs(adj, visitedArray, stk, i);
            }
        }
        
        // Initialize distance array
        int[] distanceArray = new int[N];
        Arrays.fill(distanceArray, Integer.MAX_VALUE);
        distanceArray[0] = 0; // Assuming 0 as the starting node
        
        // Process the nodes in topological order
        while (!stk.isEmpty()) {
            int outNode = stk.pop();
            if (distanceArray[outNode] != Integer.MAX_VALUE) {
                for (Pair iter : adj.get(outNode)) {
                    int vertex = iter.node;
                    int dist = iter.distance;
                    if (distanceArray[outNode] + dist < distanceArray[vertex]) {
                        distanceArray[vertex] = distanceArray[outNode] + dist;
                    }
                }
            }
        }
        
        // Replace unreachable nodes with -1
        for (int i = 0; i < N; i++) {
            if (distanceArray[i] == Integer.MAX_VALUE) {
                distanceArray[i] = -1;
            }
        }
        
        return distanceArray;
    }
}

```

### Undirected Graph
The algorithm is quite simple and listed below.

1) Convert adjacency matrix into list or any other matrix in adjacency list and add elements.

2) Create a distance array. Note the source will be given hence, turn the distance of the source as zero and let all other distance be set to MAX_VALUE.

3) Create a queue. Add source to it initially. Run a loop with condition until queue is empty. Pop out the element present, add its connected element. Add distance 1 to the distance of connected element. This one is to be added to distance of parent element.

4) Turn the distance of unreachable nodes to -1.

The code is as follows,

```
class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        //Creating adjacency array skeleton
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        //Entering values
        for(int j=0;j<m;j++){
            adj.get(edges[j][0]).add(edges[j][1]);
            adj.get(edges[j][1]).add(edges[j][0]);
        }
        
        //Creating distance array and turning src position dist as 0
        int[] distanceArray=new int[n];
        Arrays.fill(distanceArray,Integer.MAX_VALUE);
        distanceArray[src]=0;
        
        //Creating new stack and adding source element
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        
        
        while(!q.isEmpty()){
            int outNode=q.poll();
            for(Integer iter:adj.get(outNode)){
                if(distanceArray[outNode]+1<distanceArray[iter]){
                    distanceArray[iter]=distanceArray[outNode]+1;
                    q.add(iter);
                }
            }
        }
        
        for(int k=0;k<n;k++){
            if(distanceArray[k]==Integer.MAX_VALUE){
                distanceArray[k]=-1;
            }
        }
        
        return(distanceArray);
    }
}
```

## Dijkstra Algorithm (Shortest Path Difference)

Dijkstra's algorithm is used to find the shortest path from a single source node to all other nodes in a weighted graph. It works efficiently for graphs with non-negative edge weights.

__Algorithm__

1. __Initialization:__

    __Inputs:__    

        V: Number of vertices in the graph.

        adj: Adjacency list where each node contains a list of pairs [neighbor, weight] representing the neighboring node and the edge weight.

        S: The source vertex from which to calculate the shortest paths.

    Distance Array: Create an array distanceArray of size V and initialize all elements to ∞ (or Integer.MAX_VALUE in Java), representing the initial distance to each node. Set the distance to the source node S to 0.

    Priority Queue: Use a min-heap priority queue to keep track of the minimum distance discovered so far. The queue stores pairs of (distance, node), where distance is the current shortest distance to node.

2. __Start from the Source Node:__

        Insert the source node into the priority queue with a distance of 0.

3. __Processing Nodes:__

* While the priority queue is not empty, do the following:
    
        Extract the Node: Extract the node u with the smallest distance from the priority queue.

        Relaxation: For each neighbor v of u, check if the path from u to v through the current edge offers a shorter path than previously known:

        If distanceArray[u] + weight(u, v) < distanceArray[v], update distanceArray[v] with the new shorter distance.

        Insert v with the updated distance into the priority queue.

4. __Repeat Until All Nodes Are Processed:__

        Continue extracting nodes and relaxing edges until the priority queue is empty.

5. __Output:__

        The distanceArray now contains the shortest distance from the source node S to every other node in the graph.


The code is as follows,

```
class Solution {

    public static class Pair {
        int distance;
        int node;

        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Min-heap priority queue. The last condition states, minimum distance to be stored at the top.
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        // Distance array AND filling it with max integer
        int[] distanceArray = new int[V];
        Arrays.fill(distanceArray, Integer.MAX_VALUE);

        // Changing the distance for source array to 0
        distanceArray[S] = 0;

        // Adding start node to priority queue
        Pair startNode = new Pair(0, S);
        pq.add(startNode);

        // Running modified BFS
        while (!pq.isEmpty()) {
            // Pulling element out from queue
            Pair outNode = pq.poll();

            // Iterating to each of its connected Nodes
            for (ArrayList<Integer> iter : adj.get(outNode.node)) {
                int node = iter.get(0);
                int distance = iter.get(1);
                if (distanceArray[outNode.node] + distance < distanceArray[node]) {
                    distanceArray[node] = distanceArray[outNode.node] + distance;
                    Pair newNode = new Pair(distanceArray[node], node);
                    pq.add(newNode);  // Add the updated distance and node to the priority queue
                }
            }
        }
        return distanceArray;
    }
}
```

## Floyd Warshall Algorithm

The Floyd-Warshall algorithm is an all-pairs shortest path algorithm, which computes the shortest paths between all pairs of nodes in a graph. This algorithm is particularly useful for dense graphs and can handle both positive and negative edge weights (but no negative cycles).

__Algorithm__

1. __Initialization:__

    Input:

        matrix: A 2D matrix (adjacency matrix) where matrix[i][j] represents the weight of the edge from node i to node j.

    If there's no direct edge between nodes i and j, matrix[i][j] should initially be set to -1.

2. __Preprocessing:__
    
    Traverse the entire matrix:
            
            Convert all -1 values to a very large value (representing infinity), as -1 indicates no direct path. In this algorithm, a large value will signify an unreachable path.

            Set matrix[i][i] to 0 for all i, because the shortest distance from a node to itself is 0.

3. __Main Algorithm:__

    Triple Loop Structure:
        
        Iterate over each possible intermediate node k (referred to as via in the code):

        For each pair of nodes (i, j), check if the path from i to j through k is shorter than the currently known shortest path:

        Update matrix[i][j] to min(matrix[i][j], matrix[i][k] + matrix[k][j]).
        
        This step essentially checks if the shortest path from i to j can be improved by going through node k.

4. __Postprocessing:__

        After running the main algorithm, convert any values that are still set to the large "infinity" value back to -1 to maintain the integrity of the output (as -1 is used to denote no path exists).
5. __Output:__

        The matrix now contains the shortest paths between all pairs of nodes. If matrix[i][j] is still a large value (infinity), it means there's no path between i and j.

The code is as follows,

```
class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        int INF = (int)(1e8);

        // Preprocessing
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = INF;  // Treat -1 as infinity
                }
                if(i == j){
                    matrix[i][j] = 0;  // Distance from a node to itself is 0
                }
            }
        }
        
        // Main Floyd-Warshall algorithm
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        
        // Postprocessing: Convert infinity back to -1 for unreachable nodes
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == INF){
                    matrix[i][j] = -1;  // Restore -1 for no path
                }
            }
        }
    }
}
```

## Bellman-Ford Algorithm

The Bellman-Ford algorithm is used to find the shortest paths from a single source vertex to all other vertices in a weighted graph. It can handle graphs with negative weight edges, but it will detect and report if there is a negative weight cycle reachable from the source vertex.

__Algorithm__

1. __Initialization:__

    Input:

        V: Number of vertices in the graph.

        edges: A list of edges where each edge is represented by a triplet (u, v, wt) indicating there is an edge from vertex u to vertex v with weight wt.

        S: The source vertex from which the shortest paths are calculated.

    Distance Array:
    Create a distanceArray of size V to store the shortest distance from the source to each vertex.
    Initialize the distanceArray with a large value (infinity) for all vertices except the source vertex S, which is initialized to 0.

2. __Relaxation Step:__


    Iteration:

        Repeat the relaxation process V-1 times (where V is the number of vertices).

    Relaxation:

        For each edge (u, v, wt), check if the current known distance to v can be shortened by taking the edge from u to v.

        If distanceArray[u] + wt < distanceArray[v], update distanceArray[v] to distanceArray[u] + wt.

3. __Negative Cycle Detection:__

        After V-1 iterations, perform one more iteration over all edges to check for any negative weight cycles.
        
        If any edge (u, v, wt) still satisfies distanceArray[u] + wt < distanceArray[v], then a negative weight cycle exists, and the algorithm should return an array with a single element -1 indicating the presence of a negative cycle.

4. __Output:__

        If no negative weight cycle is detected, return the distanceArray, which contains the shortest distances from the source vertex S to all other vertices.

The code is as follows,

```
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Distance array to store the shortest distance from source to each vertex
        int[] distanceArray = new int[V];
        
        // Initialize the distance array with a large value (infinity)
        Arrays.fill(distanceArray, (int)(1e8));
        distanceArray[S] = 0;  // Distance from the source to itself is 0
        
        // Relaxation step
        for (int i = 0; i < V - 1; i++) {  // Perform V-1 iterations
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                // Relax the edge
                if (distanceArray[u] + wt < distanceArray[v] && distanceArray[u] != (int)(1e8)) {
                    distanceArray[v] = distanceArray[u] + wt;
                }
            }
        }
        
        // Check for negative weight cycles
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            // If a shorter path is found, a negative cycle exists
            if (distanceArray[u] + wt < distanceArray[v] && distanceArray[u] != (int)(1e8)) {
                return new int[] {-1};  // Return -1 indicating a negative cycle
            }
        }
        
        return distanceArray;  // Return the shortest distance array
    }
}

```

# Minimum Spanning Tree

Spanning tree is a tree with n nodes and n-1 edges. Minimum spanning tree is a one of the many spanning tree for a n node configration that has the least sum of edge weight. 

One of the algo used to find the edges of spaning tree from a given tree and calculate weight sum is Prim's algorithm. Lets study that.

## Prim's Algorithm

Prim's Algorithm is used to find the minimum spanning tree (MST) of a connected, undirected graph. The MST is a subset of the graph's edges that connects all vertices together without any cycles and with the minimum possible total edge weight.

Here is the step-by-step algorithm:

1. **Initialize Structures**:
   - Create a priority queue (min-heap) to store nodes based on the minimum weight edge connecting them.
   - Create a `visitedArray` to keep track of the vertices that have already been added to the MST.
   - Create a `mstArray` to store the edges that are part of the MST.
   - Initialize the `sum` variable to zero, which will hold the total weight of the MST.

2. **Start with an Arbitrary Node**:
   - Begin with an arbitrary starting node (typically node 0). Push it onto the priority queue with an initial weight of 0 and a parent of -1 (indicating no parent).

3. **Main Algorithm Loop**:
   - While the priority queue is not empty:
     1. **Extract the Node with the Minimum Edge Weight**:
        - Pop the node with the minimum weight edge from the priority queue.
     2. **Check if the Node is Already in MST**:
        - If the node is not already visited, mark it as visited.
     3. **Include the Node in MST**:
        - Add the weight of the edge to the `sum`.
        - Add the corresponding edge (between the node and its parent) to the `mstArray`.
     4. **Update Neighboring Nodes**:
        - For each unvisited neighbor of the current node:
          - Push the neighbor onto the priority queue with the weight of the connecting edge.
          - Track the edge connecting the node to the neighbor for possible inclusion in the MST.

4. **Result**:
   - The algorithm continues until all nodes are included in the MST. The final `sum` represents the total weight of the minimum spanning tree, and `mstArray` contains all the edges of the MST.

5. **Return**:
   - Return the total weight of the MST (`sum`).

### Example Reference Code:

```java
class Solution {

    public static class Edge {
        int x;
        int y;
        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Triplet {
        int weight;
        int node;
        int parent;
        public Triplet(int wt, int n, int p) {
            this.weight = wt;
            this.node = n;
            this.parent = p;
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Creating priority queue, visited array, and MST array
        PriorityQueue<Triplet> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        boolean[] visitedArray = new boolean[V];
        ArrayList<Edge> mstArray = new ArrayList<>();

        // Initializing starting node
        Triplet startNode = new Triplet(0, 0, -1);
        pq.add(startNode);

        int sum = 0;

        // Main loop of Prim's algorithm
        while (!pq.isEmpty()) {
            Triplet outNode = pq.poll();
            int weight = outNode.weight;
            int node = outNode.node;
            int parent = outNode.parent;

            if (!visitedArray[node]) {
                visitedArray[node] = true; 
                sum += weight;
                if (parent != -1) {
                    Edge newMST = new Edge(parent, node);
                    mstArray.add(newMST);
                }

                for (int[] iter : adj.get(node)) {
                    int destNode = iter[0];
                    int wt = iter[1];
                    if (!visitedArray[destNode]) {
                        Triplet newNode = new Triplet(wt, destNode, node);
                        pq.add(newNode);
                    }
                }
            }
        }
        return sum;
    }
}
```

### Key Points:
- **Priority Queue** ensures that the edge with the smallest weight is selected first.
- **Visited Array** prevents cycles and ensures that each vertex is included only once in the MST.
- **Sum** keeps track of the total weight of the edges included in the MST.
- The algorithm efficiently finds the MST by always choosing the smallest possible edge that expands the MST without forming a cycle.

# Disjoint Set 

Disjoint set is a component that could tell whether two nodes belong to the same component in constant time unlike BFS and DFS that have the complexity O(N+E). These are generally used in case of Dynamic graphs.

Disjoint set provides 2 major functionalities,

1) FindParent
2) Find Union either via size or rank

What do we mean by Dynamic Graph? When we discuss graph in context of Disjoint set we see that initially all the nodes are isolated(not connected to one another) and later we supply them with edges. These edges are added one after the another, hence at every point in time, the configration of graph will be different as there will be few edges that are still being added, hence we refer to this kind of graph as dynamic graph. 

At any point during the formation of DG, one could ask wheather two nodes are connected to each other. Disjoint set happens to be a algo/structure that answers this question in constant time.

## Union By Rank

To perform this operation we need two thing initially,

1) Rank Array with rank of each node initialised to 0.
2) Parent array with i initialised to each index, that is 0 for 0, 1 for 1 and so on.

The pseudocode to perform Union(u,v) is as follows,

1) Find the ultimate parent of u and v. Lets say them as pu and pv.
2) Find the rank of pu and pv.
3) Connect smaller rank parent to larger rank parent.

![alt text](image-24.png)