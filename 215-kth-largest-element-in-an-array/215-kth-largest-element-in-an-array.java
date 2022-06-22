class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq=new PriorityQueue<>();
        int size=0;
        for(int val:nums){
            if(size<k){
                pq.add(val);
                size++;
            }
            else{
                if(pq.peek()<val){
                    pq.poll();
                    pq.add(val);
                }
            }
        }
        return pq.peek();
    }
}