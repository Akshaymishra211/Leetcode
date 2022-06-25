class Solution {
    public boolean isPossible(int[] target) {
        if(target.length==1){
            return target[0]==1;
        }
        Queue<Long> q=new PriorityQueue<>(Collections.reverseOrder());
        long sum=0l;
        for(int val:target){
            sum+=(val*1l);
            q.add(val*1l);
        }
        while(q.peek()!=1){
            long val=q.poll(),next=q.peek();
            long diff=sum-val,qut=(val-next)/diff+((val-next)%diff>0?1:0);
            sum-=val;
            val-=diff*qut;
            if(val<=0 || qut==0){
                return false;
            }
            sum+=val;
            q.add(val);
        }
        return true;
    }
}