class Solution {
    public int minimumOperations(int[] nums) {
        int cnt[]=new int[101];
        for(int val:nums){
            cnt[val]++;
        }
        int res=0;
        for(int i=1;i<101;i++){
            if(cnt[i]>0){
                res++;
            }
        }
        return res;
    }
}