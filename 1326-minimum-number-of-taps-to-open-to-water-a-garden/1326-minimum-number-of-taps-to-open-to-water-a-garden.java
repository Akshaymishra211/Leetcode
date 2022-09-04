class Solution {
    public int minTaps(int n, int[] ranges) {
        int taps[][]=new int[n+1][2];
        for(int i=0;i<n+1;i++){
            taps[i][0]=i-ranges[i];
            taps[i][1]=i+ranges[i];
        }
        Arrays.sort(taps,new SortByTaps());
        int i=0,maxReach=0;
        int cnt=0;
        while(maxReach<n){
            int temp=maxReach;
            while(i<n+1 && maxReach>=taps[i][0]){
                temp=Math.max(temp,taps[i][1]);
                i++;
            }
            if(temp==maxReach){
                return -1;
            }
            cnt++;
            maxReach=temp;
        }
        return cnt;
    }
    static class SortByTaps implements Comparator<int[]>{
        public int compare(int[] a,int[] b){
            return a[0]-b[0];
        }
    }
}