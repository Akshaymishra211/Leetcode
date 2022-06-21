class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        long totalBricks=0;
        Queue<Integer> pq=new PriorityQueue<>();
        int lenq=0,n=heights.length;
        for(int i=1;i<n;i++){
            int diff=heights[i]-heights[i-1];
            if(diff>0){
                if(lenq<ladders){
                    pq.add(diff);
                    lenq++;
                }
                else{
                    if(lenq>0){
                        if(pq.peek()>diff){
                            if(totalBricks+diff>bricks){
                                return i-1;
                            }
                            totalBricks+=diff;
                        }
                        else{
                            int small=pq.poll();
                            pq.add(diff);
                            if(totalBricks+small>bricks){
                                return i-1;
                            }
                            totalBricks+=small;
                        }
                    }
                    else if(totalBricks+diff<=bricks){
                        totalBricks+=diff;
                    }
                    else{
                        return i-1;
                    }
                }
            }
        }
        return n-1;
    }
}