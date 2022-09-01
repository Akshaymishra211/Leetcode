class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0,n=nums.length;
        while(i<n){
            if(nums[i]>0 && nums[i]<n && nums[nums[i]-1]!=nums[i]){
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
            else{
                i++;
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