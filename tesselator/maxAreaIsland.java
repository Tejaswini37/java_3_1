import java.util.*;
public class maxAreaIsland {
    public static int solve(int[][] grid,int m,int n){
        if(grid==null || grid.length==0) return 0;
        int res=0,curr=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    curr=bfs(grid,i,j);
                    res=Math.max(res,curr);
                }
            }
        }
        return res;
    }
    public static int bfs(int[][] grid,int i,int j){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        int res=0;
        while(!q.isEmpty()){
            int curr[]=q.poll();
            res++;
            final int[][] neighbours=new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,1},{1,1},{1,-1},{-1,-1}};
            for(int neigh[] : neighbours){
                int k=curr[0]+neigh[0];
                int l=curr[1]+neigh[1];
                if(k>=0 && k<grid.length && l>=0 && l<grid[0].length && grid[k][l]==1){
                    grid[k][l]=0;
                    q.add(new int[]{k,l});
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int board[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]=sc.nextInt();
            }
        }
        System.out.println(solve(board,m,n));
    }
}
