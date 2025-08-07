package dp;
import java.util.*;
public class climbing_stairs {
    static int r(int n){
        if(n<=2) return n;
        return r(n-1)+r(n-2);
    }
    static int t(int n){
        int dp[]=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    static int m(int n){
        if(n<=2) return n;
        int dp[]=new int[n+1];
        return solve(n,dp);
    }
    static int solve(int n,int dp[]){
        if(n<=2) return n;
        if(dp[n]==0){
            dp[n]=solve(n-1,dp)+solve(n-2,dp);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(r(n));
        System.out.println(m(n));
        System.out.println(t(n));
    }
}
