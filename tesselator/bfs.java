import java.util.*;
class Graph{
    int n;
    LinkedList<Integer> adj[];
    public Graph(int n){
        this.n=n;
        adj=new LinkedList[n];
        for(int i=0;i<n;i++){ 
            adj[i]=new LinkedList<>();
        }
    }
    public void addEdge(int source,int dest){
        adj[source].add(dest);
    }
    public void bfsfunction(int start){
        boolean visited[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        visited[start]=true;
        q.add(start);
        while(!q.isEmpty()){
            int curr=q.poll();
            System.out.print(curr+" ");
            for(int i:adj[curr]){
                if(!visited[i]){
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }
}
class bfs{
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0,4);
        g.addEdge(1,0);
        g.addEdge(1,2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(2, 1);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 1);
        g.addEdge(4, 0);
        g.addEdge(4, 3);
        g.bfsfunction(0);


    }
}