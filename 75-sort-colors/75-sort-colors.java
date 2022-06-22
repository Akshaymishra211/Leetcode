class Solution {
    public void sortColors(int[] nums) {
        int cnt0=0,cnt1=0;
        for(int val:nums){
            if(val==0){
                cnt0++;
            }
            else if(val==1){
                cnt1++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(cnt0>0){
                nums[i]=0;
                cnt0--;
            }
            else if(cnt1>0){
                nums[i]=1;
                cnt1--;
            }
            else{
                nums[i]=2;
            }
        }
    }
}
