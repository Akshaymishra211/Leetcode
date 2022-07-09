class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Pair> dq=new ArrayDeque<>();
        int n=nums.length;
        dq.add(new Pair(0,nums[0]));
        for(int i=1;i<Math.min(n,k);i++){
            int curr=nums[i]+dq.peek().sum;
            while(!dq.isEmpty() && dq.getLast().sum<=curr){
                dq.removeLast();
            }
            dq.addLast(new Pair(i,curr));
        }
        int i=0,j=k;
        while(j<n){
            int curr=nums[j]+dq.peek().sum;
            while(!dq.isEmpty() && dq.getLast().sum<=curr){
                dq.removeLast();
            }
            dq.addLast(new Pair(j,curr));
            if(dq.getFirst().idx==i){
                dq.removeFirst();
            }
            i++;
            j++;
        }
        int ans=0;
        while(!dq.isEmpty()){
            if(dq.peek().idx==n-1){
                ans=dq.poll().sum;
                break;
            }
            dq.poll();
        }
        return ans;
    }
    static class Pair{
        int idx,sum;
        public Pair(int idx,int sum){
            this.idx=idx;
            this.sum=sum;
        }
    }
}