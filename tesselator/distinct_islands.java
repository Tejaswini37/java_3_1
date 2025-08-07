import java.util.*;
public class distinct_islands {
    static void dfs(int a[][],int vis[][],int i,int j,int n,int m,StringBuilder s){
        vis[i][j]=1;
        char dir[]={'l','r','u','d'};
        int[][] d={{0,-1},{0,1},{-1,0},{1,0}};
        for(int k=0;k<4;k++){
            int r=i+d[k][0];
            int c=j+d[k][1];
            if(r>=0 && r<n && c>=0 && c<m && a[r][c]==1 && vis[r][c]==0){
                dfs(a,vis,r,c,n,m,s.append(dir[k]));
            }
        }
        s.append('b');
        //1 1    1 1
        //  1    1     this are not same but 'srd' for both so 'b' is added
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[][]=new int[n][m];
        for(int i=0;i<n;i++){ 
            for(int j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        HashSet<String> ls=new HashSet<String>();
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++){ 
            for(int j=0;j<m;j++){
                if(a[i][j]==1 && vis[i][j]==0){
                    StringBuilder s=new StringBuilder();
                    dfs(a,vis,i,j,n,m,s.append('s'));
                    // HashSet doesn’t look at the content of StringBuilder objects by default—it only checks the object references.
                    ls.add(s.toString());
                    
                   
                }
            }
        }
        System.out.println(ls.size());
        System.out.println(ls);
    }
}
