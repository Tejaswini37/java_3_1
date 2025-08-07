import java.util.*;
public class maze {
    public static boolean solve(int a[][],int n){
        if(a[0][0]==0 || a[n-1][n-1]==0) return false; 
        Queue<int []> q=new LinkedList<>();
        q.add(new int[]{0,0});
        a[0][0]=0;
        while(!q.isEmpty()){
            int b[]=q.poll();
            int x=b[0];
            int y=b[1];
            if(x==n-1 && y==n-1) return true;
            if(x+1<n && a[x+1][y]==1){
                 q.add(new int[]{x+1,y});
                 a[x+1][y]=0;}
            if(y+1<n && a[x][y+1]==1){
                 q.add(new int[]{x,y+1});
                 a[x][y+1]=0;}

        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[][]=new int[n][n];
        for(int i=0;i<n;i++){ 
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println(solve(a,n));
    }
}
