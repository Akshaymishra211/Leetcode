class Solution {
    public static boolean isPossible(int []arr,int i){
        if(i-2<0){
            arr[i-1]=arr[i];
            return true;
        }
        else{
            if(arr[i-2]<=arr[i]){
                arr[i-1]=arr[i];
                return true;
            }
            else if(arr[i+1]>=arr[i-1]){
                arr[i]=arr[i-1];
                return true;
            }
            return false;
        }
    }
    public boolean checkPossibility(int[] nums) {
        boolean isUsed=false;
        int n=nums.length;
        for(int i=1;i<n-1;i++){
            if(nums[i]<nums[i-1]){
                if(isUsed){
                    return false;
                }
                else if(isPossible(nums,i)){
                    isUsed=true;
                }
                else{
                    return false;
                }
            }
        }
        if(n>1 && nums[n-1]<nums[n-2] && isUsed){
            return false;
        }
        return true;
    }
}
