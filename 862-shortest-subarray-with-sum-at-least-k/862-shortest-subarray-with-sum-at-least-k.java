class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Pair> dq=new ArrayDeque<>();
        long sum=0;
        int ans=Integer.MAX_VALUE;
        dq.add(new Pair(0,-1));
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            Pair p=new Pair(sum,i);
            while(!dq.isEmpty() && dq.getLast().sum>=sum){
                dq.pollLast();
            }
            dq.addLast(p);
            while(!dq.isEmpty() && dq.getFirst().sum<=sum-k){
                ans=Math.min(ans,i-dq.pollFirst().idx);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    static class Pair{
        long sum;
        int idx;
        public Pair(long sum,int idx){
            this.sum=sum;
            this.idx=idx;
        }
    }
}
