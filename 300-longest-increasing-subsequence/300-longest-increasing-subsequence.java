class Solution {
    public static int bS(int res[],int ele,int n){
        int l=0,r=n;
        while(l<r){
            int mid=(l+r)/2;
            if(res[mid]<ele){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            res[bS(res,nums[i],n)]=nums[i];
        }
        int cnt=0;
        for(int i=0;i<n && res[i]<Integer.MAX_VALUE;i++){
            cnt++;
        }
        return cnt;
    }
}
