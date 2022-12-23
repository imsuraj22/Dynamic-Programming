public class FibonacciTabulation {
    static int fibonacci(int n,int[] dp){
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];

        }
        return dp[n+1];
    }
    public static void main(String[] args) {
        int n=5;
        int dp[]=new int[n+1];
        System.out.println(fibonacci(n, dp));
    }
}
