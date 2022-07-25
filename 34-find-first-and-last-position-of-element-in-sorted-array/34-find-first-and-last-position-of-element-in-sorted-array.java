class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[]={-1,-1};
        int n=nums.length;
        int l=0,r=n-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]>=target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        if(r+1<n && nums[r+1]==target){
            res[0]=r+1;
        }
        l=0;
        r=n-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]<=target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        if(l-1>=0 && nums[l-1]==target){
            res[1]=l-1;
        }
        return res;
    }
}