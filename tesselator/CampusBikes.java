import java.util.Scanner;

public class CampusBikes {
    static int min=Integer.MAX_VALUE;
    public static int assignbikes(int[][] w,int b[][]){
        helper(new boolean[b.length],0,b,w,0);
        return min;
    }
    public static void helper(boolean vis[],int i,int b[][],int w[][],int dis){
        if(i==w.length && dis<min) min=dis;
        if(i>=w.length) return;
        if(dis>min) return;
        for(int j=0;j<b.length;j++){
            if(!vis[j]){
                vis[j]=true;
                helper(vis,i+1,b,w,dis+caldist(i,j,w,b));
                vis[j]=false;
            }
        }
    }
    public static int caldist(int i,int j,int w[][],int b[][]){
        return Math.abs(w[i][0]-b[j][0])+Math.abs(w[i][1]-b[j][1]);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int w=sc.nextInt();
        int b=sc.nextInt();
        int workers[][]=new int[w][2];
        int bikes[][]=new int[b][2];
        for(int i=0;i<w;i++){
            workers[i][0]=sc.nextInt();
            workers[i][1]=sc.nextInt();
        }
        for(int i=0;i<b;i++){
            bikes[i][0]=sc.nextInt();
            bikes[i][1]=sc.nextInt();
        }
        System.out.println(assignbikes(workers,bikes));
    }
}
