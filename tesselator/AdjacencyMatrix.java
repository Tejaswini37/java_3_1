import java.util.*;
class Adjacency_matrix
{
    public static void addEdge(int[][] a,int x,int y){
        a[x][y]=1;
        a[y][x]=1;
    }
    public static void display(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int[][] a=new int[v][v];
        for(int i=0;i<e;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            addEdge(a,x,y);
        }
        display(a);
    }
}