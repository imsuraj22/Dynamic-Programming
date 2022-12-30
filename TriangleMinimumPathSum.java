import java.util.Arrays;

public class TriangleMinimumPathSum {
    /* MEMOIZATION
    public static int minimumPathSum(int[][] triangle, int n) {
        int dp[][]=new int[n][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        return solution(0,0,triangle,n,dp);
    }

    static int solution(int i,int j,int arr[][],int n,int [][]dp){

        if(i==n-1)  return arr[i][j];
        
        if(dp[i][j]!=-1) return dp[i][j];
        int low1=arr[i][j]+solution(i+1, j, arr, n,dp);
        int low2=arr[i][j]+solution(i+1, j+1, arr, n,dp);

        return dp[i][j]=Math.min(low1, low2);
    }
     */ 

    //TABULATION    
    public static int minimumPathSum(int[][] triangle, int n) {
        int dp[][]=new int[n][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        for(int j=0;j<n;j++) dp[n-1][j]=triangle[n-1][j];

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int d=triangle[i][j]+dp[i+1][j];
                int dg=triangle[i][j]+dp[i+1][j+1];
                dp[i][j]=Math.min(d, dg);
            }
        }

        return dp[0][0];

        
    }
    public static void main(String[] args) {
        int arr[][]=new int[][]{
            {1},{2,3},{3,6,7},{8,9,6,10}
        };
        int n=arr.length;
        System.out.println(minimumPathSum(arr, n));
    }
}
