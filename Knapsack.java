import java.util.Arrays;

public class Knapsack {

    /*MEMOIZATION 
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int dp[][]=new int[n][maxWeight+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
      //  for(int w=weight[0];w<=maxWeight;w++) dp[0][w]=value[0];
        return solution(n-1,maxWeight,weight,value,dp);
    }

    static int solution(int ind, int w, int wt[], int val[],int dp[][]){
        if(ind==0){

           if( wt[ind]<=w) return val[ind];
           else return 0;
        }
        if(dp[ind][w]!=-1) return dp[ind][w];
        int nonTake=0+solution(ind-1, w, wt, val,dp);
        int take=(int)Math.pow(-10, 9);
        if(wt[ind]<=w) take=val[ind]+solution(ind-1, w-wt[ind], wt, val,dp);

        return dp[ind][w]=Math.max(nonTake, take);
    }
    */

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int dp[][]=new int[n][maxWeight+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        for(int w=weight[0];w<=maxWeight;w++) dp[0][w]=value[0];
        for(int i=1;i<n;i++){
            for(int w=0;w<=maxWeight;w++){
                int nontake=0+dp[i-1][w];
                int take=(int)Math.pow(-10, 9);
                if(weight[i]<=w) take=value[i]+dp[i-1][w-weight[i]];

                dp[i][w]=Math.max(nontake, take);
            }

        }
        return dp[n-1][maxWeight];
        }

    
    public static void main(String[] args) {
        int weight[]=new int[]{1 ,2, 4, 5};
        int val[]=new int[]{5, 4, 8, 6};

        System.out.println(knapsack(weight, val, 4, 5));
    }
}
