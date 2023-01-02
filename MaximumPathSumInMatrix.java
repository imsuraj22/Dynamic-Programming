import java.util.Arrays;

public class MaximumPathSumInMatrix {
    /* MEMOIZATION
    public static int getMaxPathSum(int[][] matrix) {
		int maxi=Integer.MIN_VALUE;
        int n=matrix[0].length;
        int m=matrix.length;

        int dp[][]=new int[m][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }


        for(int i=0;i<n;i++){
            int ans=solution(m-1,i,n,matrix,dp);
            maxi=Math.max(ans, maxi);
        }
        return maxi;
	}

   

    static int solution(int i,int j,int n,int [][] matrix,int dp[][]){
        if(j<0 || j>=n) return (int)Math.pow(-10,9);

        if(i==0) return matrix[i][j];

        if(dp[i][j]!=-1) return dp[i][j];

        int up=matrix[i][j]+solution(i-1, j, n, matrix,dp);
        int left=matrix[i][j]+solution(i-1, j-1, n, matrix,dp);
        int right=matrix[i][j]+solution(i-1, j+1, n, matrix,dp);

        return dp[i][j]=Math.max(up, Math.max(left, right));
    }

      */

      public static int getMaxPathSum(int[][] matrix) {
        int maxi=Integer.MIN_VALUE;
        int n=matrix[0].length;
        int m=matrix.length;

        int dp[][]=new int[m][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
        }


        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++ ){
                int up=matrix[i][j]+dp[i-1][j];

                int left=matrix[i][j];
                if(j-1>=0) left+=dp[i-1][j-1];
                else left+=(int)Math.pow(-10, 9);

                int right=matrix[i][j];
                if(j+1<n) right+=dp[i-1][j+1];
                else right+=(int)Math.pow(-10, 9);

                dp[i][j]=Math.max(up, Math.max(left, right));
            }
        }

        for(int i=0;i<n;i++){
            maxi=Math.max(maxi, dp[m-1][i]);
        }

        return maxi;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,10,4},
                    {100,3,2,1},
                    {1,1,20,2},
                    {1,2,2,1}};
  
  System.out.println(getMaxPathSum(matrix));
    }
}
