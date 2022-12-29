public class MinimumPathSum {

    /*  MEMOIZATION 

    public static int minSumPath(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
    	return solution(m-1,n-1,grid,dp);
    }

    static int solution(int i,int j,int[][] arr,int dp[][]){
        if(i==0 && j==0) return arr[0][0];

        if(i<0 || j<0)  return (int)Math.pow(10,9);

        if(dp[i][j]!=-1) return dp[i][j];

        int up=arr[i][j]+solution(i-1, j, arr,dp);
        int left=arr[i][j]+solution(i, j-1, arr,dp);

        return dp[i][j]=Math.max(up, left);
    } */

    public static int minSumPath(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
       
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(i==0 && j==0) dp[i][j]=arr[i][j];
               else{
                   int down=arr[i][j];
                   int right=arr[i][j];
                   if(i>0) down+=dp[i-1][j];
                   else down += (int)Math.pow(10,9);
                   
                   if(j>0) right+=dp[i][j-1];
                   else right += (int)Math.pow(10,9);
                   
                   dp[i][j]=Math.min(down,right);
               }
           }
       }
       
       return dp[m-1][n-1];
       // return solution(m-1,n-1,grid,dp);
    }
    public static void main(String[] args) {

        int matrix[][] = {{5,9,6},{11,5,2}};
        System.out.println(minSumPath(matrix));
        
    }
}
