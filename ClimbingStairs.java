import java.util.Arrays;

public class ClimbingStairs {
    static int climbing(int n,int[] dp){
        if(n==0) return 1;
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        int left=climbing(n-1, dp);
        int right=climbing(n=2, dp);
        return dp[n]=left+right;
    }
    public static void main(String[] args) {
        int n=3;
        int dp[]=new int[n+1];
        Arrays.fill(dp, -1);
        climbing(n,dp);
    }
}
