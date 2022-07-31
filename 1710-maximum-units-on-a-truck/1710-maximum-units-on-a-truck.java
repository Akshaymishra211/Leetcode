class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->b[1]-a[1]);
        int cnt=0,i=0;
        while(i<boxTypes.length && truckSize>0){
            cnt+=Math.min(boxTypes[i][0],truckSize)*boxTypes[i][1];
            truckSize-=Math.min(boxTypes[i][0],truckSize);
            i++;
        }
        return cnt;
    }
}
