// Given a directed graph represented by an adjacency matrix, where each entry graph[i][j] represents the weight of the edge from vertex i to vertex j. If graph[i][j] is 0, it means there is no direct edge between i and j.

// Your task is to determine the shortest paths from a given source vertex to all other vertices using Dijkstra’s algorithm.

// Input Format:
// -------------
// Line-1: An integer N, representing the number of vertices in the graph.
// Next-N lines: Each line contains N space-separated integers representing the adjacency matrix graph.
// Last-line: An integer src, representing the source vertex.

// Output Format:
// --------------
// A line that says: "Vertex 		Distance from Source".
// Followed by N lines, each containing the vertex number and its shortest distance from the source.

// Constraints:
// ------------
// *1 <= N <= 100
// *0 <= graph[i][j] <= 1000
// *0 <= src < N
// *All weights are non-negative integers.

// Sample Input-1:
// ---------------
// 5
// 0 6 5 0 13
// 6 0 12 9 5
// 5 12 0 0 0
// 0 9 0 0 7
// 13 5 0 7 0
// 2

// Sample Output-1:
// ----------------
// Vertex           Distance from Source
// 0                5
// 1                11
// 2                0
// 3                20
// 4                16

// Sample Input-2:
// ---------------
// 9
// 0 4 0 0 0 0 0 8 0
// 4 0 8 0 0 0 0 11 0
// 0 8 0 7 0 4 0 0 2
// 0 0 7 0 9 14 0 0 0
// 0 0 0 9 0 10 0 0 0
// 0 0 4 14 10 0 2 0 0
// 0 0 0 0 0 2 0 1 6
// 8 11 0 0 0 0 1 0 7
// 0 0 2 0 0 0 6 7 0
// 5

// Sample Output-2:
// ----------------
// Vertex           Distance from Source
// 0                11
// 1                12
// 2                4
// 3                11
// 4                10
// 5                0
// 6                2
// 7                3
// 8                6

import java.util.*;

public class single_source_shortest_ {
    static int minDistance(int[] dist,Boolean sptSet[]){
        int min=Integer.MAX_VALUE,min_index=-1;
        for(int i=0;i<dist.length;i++){
            if(!sptSet[i] && dist[i]<=min){
                min=dist[i];
                min_index=i;
            }
        }
        return min_index;
    }
    public static void print(int[] dist,int src){
        System.out.println("Vertex           Distance from Source");
        for(int i=0;i<dist.length;i++){
            System.out.println(i+"                "+dist[i]);
        }
    }
    public static void shortest_path(int[][] a,int src){
        int v=a.length;
        int dist[]=new int[v];
        Boolean sptSet[]=new Boolean[v];
        for(int i=0;i<v;i++){
            dist[i]=Integer.MAX_VALUE;
            sptSet[i]=false;
        }
        dist[src]=0;
        for(int i=0;i<v-1;i++){
            int u=minDistance(dist, sptSet);
            sptSet[u]=true;
            for(int ver=0;ver<v;ver++){
                if(!sptSet[ver] && a[u][ver]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+a[u][ver]<dist[ver]){
                    // System.out.println(dist[u]+a[u][ver]);
                    dist[ver]=dist[u]+a[u][ver];
                }
            }
        }
        print(dist,src);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int[][] a=new int[v][v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                a[i][j]=sc.nextInt();
            }
        }
        int src=sc.nextInt();
        shortest_path(a,src);
    }
}
