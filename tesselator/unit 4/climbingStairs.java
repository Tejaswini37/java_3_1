import java.util.Scanner;

class climbingStairs{
    public static int r(int n){
        if(n<=2) return n;
        return r(n-1)+r(n-2);
    }
    public static int m(int n){
        if(n<=2) return n;
        int dp[]=new int[n+1];
        return solve(dp,n);

    }
    public static int solve(int dp[],int n){
        if(n<=2) return n;
        if(dp[n]!=0) return dp[n];
        return dp[n]=solve(dp,n-1)+solve(dp,n-2);
    }
    public static int t(int n){
        if(n<=2) return n;
        int dp[]=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(r(n));
        System.out.println(t(n));
        System.out.println(m(n));
    }
}