public class JumpGame {

    static public boolean canJump(int[] nums) {
        int reach=0;
        
        for(int i=0;i<nums.length;i++){
            if(i>reach){
                return false;
                
            }
            if(i+nums[i]>reach){
                reach=i+nums[i];
            }
            
        }
        return true;
    }
    
    public static void main(String[] args) {
        int arr[]=new int[]{2,3,1,1,4};
        System.out.println(canJump(arr));
    }
}
