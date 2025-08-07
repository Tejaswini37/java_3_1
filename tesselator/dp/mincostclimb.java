package dp;

import java.util.*;

class mincostclimb {

    // Recursive approach
    public int minCostClimbingStairsRecur(int n, int[] cost) {
        if (n == 0) return cost[0];
        if (n == 1) return cost[1];
        return Math.min(
            minCostClimbingStairsRecur(n - 1, cost),
            minCostClimbingStairsRecur(n - 2, cost)
        ) + cost[n];
    }

    // Memoization approach
    public int minCostClimbingStairsMemoized(int n, int[] cost, int[] dp) {
        if (n == 0) return dp[0] = cost[0];
        if (n == 1) return dp[1] = cost[1];
        if (dp[n] != -1) return dp[n];
        return dp[n] = Math.min(
            minCostClimbingStairsMemoized(n - 1, cost, dp),
            minCostClimbingStairsMemoized(n - 2, cost, dp)
        ) + cost[n];
    }

    // Tabulation approach
    public int minCostClimbingStairsTab(int[] cost) {
        int n = cost.length;
        if (n == 1) return cost[0];
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of steps
        int n = sc.nextInt();
        int[] cost = new int[n];
        
        // Input the cost array
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        // Object of the class
        mincostclimb obj = new mincostclimb();

        // Recursive call
        System.out.println("Recursion: " + obj.minCostClimbingStairsRecur(n - 1, cost));

        // Memoization call
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println("Memoization: " + obj.minCostClimbingStairsMemoized(n - 1, cost, dp));

        // Tabulation call
        System.out.println("Tabulation: " + obj.minCostClimbingStairsTab(cost));
    }
}
