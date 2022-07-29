class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2;
        while(i>-1 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>-1){
            int justGre=i+1;
            for(int j=i+1;j<n;j++){
                if(nums[j]>nums[i] && nums[j]<nums[justGre]){
                    justGre=j;
                }
            }
            int temp=nums[i];
            nums[i]=nums[justGre];
            nums[justGre]=temp;
        }
        Arrays.sort(nums,i+1,n);
    }
}