import java.util.Arrays;

public class UniquePaths {

    /*TABULATION
    public static int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solution(0,0,m,n,dp);
        
    }

    static int solution(int i,int j,int m,int n,int dp[][]){
        if(i==(m-1) && j==(n-1)){
            return 1;
        }
        if(i>=m || j>=n) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int up=solution(i+1,j,m,n,dp);
        int left=solution(i,j+1,m,n,dp);
        
        return dp[i][j]= up+left;
    }
     */

     //SPACE OPTIMIZATION 
    public static int uniquePaths(int m, int n) {
        int dp[]=new int[n];
    Arrays.fill(dp,0);
        for(int i=0;i<m;i++){
            int temp[]=new int[n];
             Arrays.fill(temp,0);
            for(int j=0;j<n;j++){
                if(i==0 && j==0) temp[j]=1;
                else{
                   int up=0,left=0;
                    if(i>0) up=dp[j];
                    if(j>0) left=temp[j-1];
                    temp[j]=up+left;
                }
                
            }
            dp=temp;
        }
        return dp[n-1];

}

    
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }
}
