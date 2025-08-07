import java.util.Scanner;

public class constructword {
    static boolean f(char[][] a,boolean[][] vis,int i,int j,String s){
        if(s.isEmpty()) return true;
        int d[][]={{-1,0},{1,0},{0,1},{0,-1}};
        for(int[] k:d){
            int x=i+k[0];
            int y=j+k[1];
            if(x>=0 && x<a.length && y>=0 && y<a[0].length && a[x][y]==s.charAt(0)){
                if(!vis[x][y]){
                    vis[x][y]=true;
                    if(f(a,vis,x,y,s.substring(1))) return true;
                    vis[x][y]=false;

                }
            }
        }
        return false;
    }
    static void word(char[][] a,String s,int n,int m){
        for(int i=0;i<n;i++){ 
            for(int j=0;j<m;j++){
                if(a[i][j]==s.charAt(0)){
                    boolean vis[][]=new boolean[n][m];
                    vis[i][j]=true;
                    if(f(a,vis,i,j,s.substring(1))){
                        System.out.println("true");
                        return;
                        
                    }
                }
            }
        }
        System.out.println("false");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        sc.nextLine();
        char a[][]=new char[n][m];
        for(int i=0;i<n;i++){ 
            String[] s1=sc.nextLine().split(" ");
            for(int j=0;j<m;j++){
                a[i][j]=s1[j].charAt(0);
            }
        }
        String s=sc.next();
        word(a,s,n,m);

    }
}
