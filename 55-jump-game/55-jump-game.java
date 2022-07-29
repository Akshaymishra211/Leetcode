class Solution {
    public boolean canJump(int[] nums) {
        int max_reachable_point=nums[0],i=0,n=nums.length;
        while(max_reachable_point<n-1){
            int temp=max_reachable_point;
            while(i<n && i<=max_reachable_point){
                max_reachable_point=Math.max(max_reachable_point,nums[i]+i);
                i++;
            }
            if(temp==max_reachable_point){
                return false;
            }
        }
        return true;
    }
}
