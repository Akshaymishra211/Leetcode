class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int gases[]=new int[2*n];
        int costs[]=new int[2*n];
        for(int i=0;i<2*n;i++){
            gases[i]=gas[i%n];
            costs[i]=cost[i%n];
        }
        int gassum=0,costsum=0,i=0,j=0;
        while(i<n && j<2*n){
            if(costsum>gassum){
                gassum-=gases[i];
                costsum-=costs[i];
                i++;
                continue;
            }
            gassum+=gases[j];
            costsum+=costs[j];
            if(i+n==j){
                return i;
            }
            j++;
        }
        return -1;
    }
}