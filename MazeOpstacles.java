import java.util.ArrayList;

public class MazeOpstacles {

    static long M = 1000000007;

    /*MEMOIZATION 
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat)
     {
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return solution(n-1,m-1,mat,dp);
    }

    static int solution(int i,int j,ArrayList<ArrayList<Integer>> mat,int dp[][]){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0 ) return 0;

        if(i>=0 && j>=0 && mat.get(i).get(j)==-1) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int up=solution(i-1, j, mat, dp);
        int left=solution(i, j-1, mat, dp);

        return dp[i][j]=(up+left) %(int)M;
    }

    */

    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat.get(i).get(j)==-1) dp[i][j]=0;
                else if(i==0 && j==0) dp[i][j]=1;
                else{
                   int up=0,left=0;
                   if(i>0) up=dp[i-1][j];
                   if(j>0) left=dp[i][j-1];

                   dp[i][j]=(up+left)%(int)M;
                } 
                
            }
        }

        return dp[n-1][m-1]%(int)M;
    }

    public static void main(String[] args) {
        
    }
}
