import java.util.Arrays;

public class ChocolatePickup {
    /*MEMOIZATION 
    public static int maximumChocolates(int r, int c, int[][] grid) {
		int dp[][][]=new int[r][c][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                // for(int jk=0;j<c;jk++){
                //     Arrays.fill(dp[i][j], -1);
                // }
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solution(0,0,c-1,r-1,c-1,grid,dp);
	}

    static int solution(int i, int j1, int j2, int m, int n, int grid[][], int dp[][][]){

        if(j1<0 || j2<0 || j1>n || j2>n) return (int)Math.pow(-10, 8);

        if(i==m){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }

        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];

        int maxi=0;
        for(int dj1=-1;dj1<=+1;dj1++){
            int val=0;
            for(int dj2=-1;dj2<=+1;dj2++){
                if(j1==j2) val=grid[i][j1];
                else val=grid[i][j1]+grid[i][j2];

                val+=solution(i+1, j1+dj1, j2+dj2, m, n, grid, dp);

                maxi=Math.max(maxi, val);
            }
        }

        return maxi;
    }

    */

    public static int maximumChocolates(int m, int n, int[][] grid) {
		int dp[][][]=new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                Arrays.fill(dp[i][j], -1);
            }
        }

        for(int j1=0;j1<n;j1++){
            for(int j2=0;j2<n;j2++){
                if(j1==j2) dp[m-1][j1][j2]=grid[m-1][j2];
                else dp[m-1][j1][j2]=grid[m-1][j1]+grid[m-1][j2];
            }
        }

        for(int i=m-2;i>=0;i--){
            for(int j1=0;j1<n;j1++){
                for(int j2=0;j2<n;j2++){
                    int maxi=0;

                    for(int dj1=-1;dj1<=+1;dj1++){
                        int val=0;
                        for(int dj2=-1;dj2<=+1;dj2++){
                            if(j1==j2) val=grid[i][j1];
                            else val=grid[i][j1]+grid[i][j2];

                            if(j1+dj1>=0 && j1+dj1<n && j2+dj2>=0 && j2+dj2<n){
                                val+=dp[i+1][j1+dj1][j2+dj2];
                            }else{
                                val+=(int)Math.pow(-10, 9);
                                maxi=Math.max(maxi, val);
                            }
                        }
                    }
                }
            }
        }
        return dp[0][0][n-1];
	}
    public static void main(String[] args) {
        int matrix[][] = {{2,3,1,2},
        {3,4,2,2},
        {5,6,3,5}};
int n = matrix.length;
int m = matrix[0].length;

System.out.println(maximumChocolates(n, m, matrix));
    }
}
