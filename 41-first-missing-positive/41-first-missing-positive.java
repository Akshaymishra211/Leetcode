class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length,i=0;
        while(i<n){
            if(nums[i]<=0 || nums[i]>n || nums[i]==i+1 || nums[nums[i]-1]==nums[i]){
                i++;
            }
            else{
                int temp=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[temp-1]=temp;
            }
        }
        for(int idx=0;idx<n;idx++){
            if(nums[idx]!=idx+1){
                return idx+1;
            }
        }
        return n+1;
    }
}