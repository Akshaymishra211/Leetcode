class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxver=verticalCuts[0];
        for(int i=1;i<verticalCuts.length;i++){
            maxver=Math.max(maxver,verticalCuts[i]*1l-verticalCuts[i-1]);
        }
        maxver=Math.max(maxver,w*1l-verticalCuts[verticalCuts.length-1]);
        long res=horizontalCuts[0]*maxver;
        for(int i=1;i<horizontalCuts.length;i++){
            res=Math.max(res,(horizontalCuts[i]*1l-horizontalCuts[i-1])*maxver);
        }
        res=Math.max(res,(h*1l-horizontalCuts[horizontalCuts.length-1])*maxver);
        return (int)(res%(1000000007*1l));
    }
}