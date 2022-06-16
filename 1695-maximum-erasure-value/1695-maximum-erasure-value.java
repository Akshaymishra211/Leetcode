class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int cnt[]=new int[10001];
        int i=0,j=0,n=nums.length;
        int res=0,curr=0;
        while(j<n){
            if(cnt[nums[j]]==0){
                curr+=nums[j];
                res=Math.max(res,curr);
                cnt[nums[j]]++;
                j++;
            }
            else{
                while(cnt[nums[j]]!=0){
                    cnt[nums[i]]--;
                    curr-=nums[i];
                    i++;
                }
            }
        }
        return res;
    }
}