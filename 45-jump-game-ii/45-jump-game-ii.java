class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n<=1){
            return 0;
        }
        for(int i=0;i<n;i++){
            nums[i]+=i;
        }
        int max_reachable_point=nums[0],cnt=1,i=0;
        while(max_reachable_point<n-1){
            int temp=max_reachable_point;
            while(i<n && i<=max_reachable_point){
                temp=Math.max(temp,nums[i]);
                i++;
            }
            max_reachable_point=Math.max(max_reachable_point,temp);
            cnt++;
        }
        return cnt;
    }
}
