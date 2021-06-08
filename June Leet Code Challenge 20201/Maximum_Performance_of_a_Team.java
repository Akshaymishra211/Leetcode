class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Pairs arr[]=new Pairs[n];
        for(int i=0;i<n;i++){
            arr[i]=new Pairs(speed[i],efficiency[i]);
        }
        Arrays.sort(arr,Collections.reverseOrder());
        Queue<Integer> q=new PriorityQueue<>();
        long sum=0;
        long res=0;
        for(int i=0;i<n;i++){
            if(q.size()<k){
                sum+=arr[i].speed;
                q.add(arr[i].speed);
                res=Math.max(res,sum*arr[i].efficiency);
            }
            else{
                if(q.peek()<=arr[i].speed){
                    sum-=q.poll();
                    q.add(arr[i].speed);
                    sum+=arr[i].speed;
                    res=Math.max(res,sum*arr[i].efficiency);
                }
            }
        }
        return Math.toIntExact(res%1000000007);
    }
    static class Pairs implements Comparable<Pairs>{
        int speed,efficiency;
        public Pairs(int speed,int efficiency){
            this.speed=speed;
            this.efficiency=efficiency;
        }
        public int compareTo(Pairs o){
            return this.efficiency-o.efficiency;
        }
    }
}
