import java.util.Arrays;

public class NumberOfSubset {
    /*MEMOIZATION 
    public static int findWays(int num[], int tar) {
        // Write your code here..
        int n=num.length;
        int dp[][]=new int[n][tar+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return solution(n-1,num,tar,dp);
    }

    static int solution(int ind,int arr[],int target,int dp[][]){
        if(target==0) return 1;
        if(ind==0){
            if(arr[0]==target) return 1;
            else return 0;
        }

        if(dp[ind][target]!=-1) return dp[ind][target];

        int notPick=solution(ind-1, arr, target,dp);
        int pick=0;
        if(arr[ind]<=target) pick=solution(ind-1, arr, target-arr[ind],dp);

        return dp[ind][target]=pick+notPick;


    }
    */
    public static int findWays(int arr[], int k) {
        // Write your code here..
       
       int n = arr.length;
    int dp[][]=new int[n][k+1];
    for(int row[]: dp)
    Arrays.fill(row,0);
    
    for(int i=0;i<n-1;i++){
        dp[i][0]=1;
    }

    if(arr[0]<=k) dp[0][arr[0]]=1;

    for(int i=1;i<n;i++){
        for(int target=1;target<=k;target++){
            int notTake=dp[i-1][target];
            int take=0;
            if(arr[i]<=target) take=dp[i-1][target-arr[i]];

            dp[i][target]=notTake+take;
        }
    }

    return dp[n-1][k];

    }

    
    public static void main(String[] args) {
        int arr[]=new int[]{16,8,2,4,2};
        System.out.println(findWays(arr, 8 ));
    }
}
