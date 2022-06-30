class Solution {
    public static long getDiff(int []arr,int val,int n){
        long diff=0;
        for(int i=0;i<n;i++){
            diff+=Math.abs(val-arr[i]);
        }
        return diff;
    }
    public int minMoves2(int[] nums) {
        int min=nums[0],max=nums[0],n=nums.length;
        for(int i=0;i<n;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int mid;
        long prevdiff=Long.MAX_VALUE;
        while(min<=max){
            mid=(min+max)/2;
            long diff1=getDiff(nums,mid,n);
            long diff2=getDiff(nums,mid-1,n);
            long diff3=getDiff(nums,mid+1,n);
            if(prevdiff>diff1){
                prevdiff=diff1;
            }
            if(diff2<=diff1){
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        return (int)prevdiff;
    }
}