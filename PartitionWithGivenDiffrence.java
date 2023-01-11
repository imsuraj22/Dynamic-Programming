import java.util.Arrays;

public class PartitionWithGivenDiffrence {
    static int mod=(int)Math.pow(10, 9)+7;
    public static int countPartitions(int n, int d, int[] arr) {
		int total=0;
        for(int i=0;i<arr.length;i++){
            total+=arr[i];
        }

        if(total-d<0 || (total-d)%2!=0) return 0;
        return findWays(arr, (total-d)/2);
	}
    public static int findWays(int num[], int tar) {
        
        int n=num.length;
        int dp[][]=new int[n][tar+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return solution(n-1,num,tar,dp);
    }

    static int solution(int ind, int arr[], int target, int dp[][]){
        if(ind ==0){
            if(target==0 && arr[0]==0) return 2;
            if(target==0 || arr[0]==target) return 1;
            return 0;
        }
        if(dp[ind][target]!=-1) return dp[ind][target];
        int nonTake=solution(ind-1, arr, target, dp);
        int take=0;
        if(arr[ind]<=target) take=solution(ind-1, arr, target-arr[ind], dp);

        return dp[ind][target]=nonTake+take%mod;
    }
    public static void main(String[] args) {
        
    }
}
