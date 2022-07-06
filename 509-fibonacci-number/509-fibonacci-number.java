class Solution {
    public static int func(int n,int arr[]){
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else if(arr[n]!=-1){
            return arr[n];
        }
        else{
            return arr[n]=func(n-1,arr)+func(n-2,arr);
        }
    }
    public int fib(int n) {
        int dp[]=new int[31];
        Arrays.fill(dp,-1);
        return func(n,dp);
    }
}