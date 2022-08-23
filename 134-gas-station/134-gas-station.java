class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length,gassum=0,costsum=0,i=0,j=0;
        while(i<n && j<2*n){
            if(costsum>gassum){
                gassum-=gas[i];
                costsum-=cost[i];
                i++;
                continue;
            }
            gassum+=gas[j%n];
            costsum+=cost[j%n];
            if(i+n==j){
                return i;
            }
            j++;
        }
        return -1;
    }
}
