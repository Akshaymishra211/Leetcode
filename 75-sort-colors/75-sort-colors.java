class Solution {
    public void sortColors(int[] nums) {
        int l=0,r=nums.length-1,i=0;
        while(i<=r){
            if(nums[i]==0){
                nums[i]=nums[l];
                nums[l]=0;
                l++;
                i++;
            }
            else if(nums[i]==1){
                i++;
            }
            else{
                nums[i]=nums[r];
                nums[r]=2;
                r--;
            }
        }
    }
}