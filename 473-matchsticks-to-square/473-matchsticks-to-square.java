class Solution {
    public static int arr[];
    public static int n;
    public static long cnt;
    public static boolean func(int idx,long sum1,long sum2,long sum3,long sum4){
        if(sum1>cnt || sum2>cnt || sum3>cnt || sum4>cnt){
            return false;
        }
        else if(idx<0){
            if(sum1==sum2 && sum2==sum3 && sum3==sum4 && sum1==sum4){
                return true;
            }
            else{
                return false;
            }
        }
        return func(idx-1, sum1+arr[idx], sum2, sum3, sum4) ||
               func(idx-1, sum1, sum2+arr[idx], sum3, sum4) || 
               func(idx-1, sum1, sum2, sum3+arr[idx], sum4) || 
               func(idx-1, sum1, sum2, sum3, sum4+arr[idx]);
    }
    public boolean makesquare(int[] matchsticks) {
        arr=matchsticks;
        n=matchsticks.length;
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=matchsticks[i];
        }
        if(sum%4!=0){
            return false;
        }
        cnt=sum/4;
        Arrays.sort(arr);
        return func(n-1,0L,0L,0L,0L);
    }
}