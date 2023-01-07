

public class SubsetSumEqualToK{

    public static boolean subsetSumToK(int n, int k, int arr[]){
        // int dp[][]=new int[n][k+1];
        // for(int i=0;i<dp.length;i++){
        //     Arrays.fill(dp[i], -1);
        // }
        boolean dp[][]= new boolean[n][k+1];
    
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        
        if(arr[0]<=k)
            dp[0][arr[0]] = true;
        
        for(int ind = 1; ind<n; ind++){
            for(int target= 1; target<=k; target++){
                
                boolean notTaken = dp[ind-1][target];
        
                boolean taken = false;
                    if(arr[ind]<=target)
                        taken = dp[ind-1][target-arr[ind]];
            
                dp[ind][target]= notTaken||taken;
            }
        }
        
        return dp[n-1][k];
    }

    static boolean solution(int ind,int target, int arr[],int dp[][]){
        if(target==0) return true;
        if(ind==0) return arr[0]==target;

        if(dp[ind][target]!=-1) return dp[ind][target]==0?false:true;

        boolean not_take=solution(ind-1, target, arr,dp);
        boolean take=false;
        if(target>=arr[ind]) take=solution(ind-1, target-arr[ind], arr,dp);

         dp[ind][target]= not_take||take ?1:0;
         return not_take||take;
    }
    public static void main(String[] args) {
        int arr[]=new int[]{6 ,1 ,2 ,1};
        System.out.println(subsetSumToK(4, 4, arr));
    }
}