class Solution {
    public static int func(int curr,int []arr,int target,int n,int []dp){
        if(curr>target){
            return 0;
        }
        else if(curr==target){
            return 1;
        }
        else if(dp[curr]!=-1){
            return dp[curr];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=func(curr+arr[i],arr,target,n,dp);
        }
        return dp[curr]=ans;
    }
    public int combinationSum4(int[] nums, int target) {
        int dp[]=new int[2001];
        Arrays.fill(dp,-1);
        return func(0,nums,target,nums.length,dp);
    }
}