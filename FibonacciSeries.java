import java.util.Arrays;

public class FibonacciSeries{

    static int fibonacci(int n,int[] dp){
        if(n<=1) return n;

        if(dp[n]!=-1) return dp[n];
        return dp[n]=fibonacci(n-1, dp)+fibonacci(n-2, dp);
    }
    public static void main(String[] args) {
        int n=5;
        int dp[]=new int[n+1];
        Arrays.fill(dp, -1);
        
        System.out.println(fibonacci(n, dp));

    }
}
