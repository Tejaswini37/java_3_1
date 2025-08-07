import java.util.*;
public class max_gold {
    public static int maxgold(int g[][]){
        int max=0;
        for(int i=0;i<g.length;i++){
            for(int j=0;j<g[0].length;j++){
                max=Math.max(max,backtrack(g,i,j,0));
            }
        }
        return max;
    }
    public static int backtrack(int[][] g,int i,int j,int cur){
        if(i<0 || i>=g.length || j<0 || j>=g[0].length || g[i][j]==0) return cur;
        cur+=g[i][j];
        int t=g[i][j];
        int max=cur;
        g[i][j]=0;
        max=Math.max(max,backtrack(g,i+1,j,cur));
        max=Math.max(max,backtrack(g,i-1,j,cur));
        max=Math.max(max,backtrack(g,i,j+1,cur));
        max=Math.max(max,backtrack(g,i,j-1,cur));
        g[i][j]=t;
        return max;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int grid[][]=new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                grid[i][j]=sc.nextInt();
        System.out.println(maxgold(grid));
    }

}
