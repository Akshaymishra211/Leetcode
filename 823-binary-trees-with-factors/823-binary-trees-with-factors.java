class Solution {
    public static long MOD=1000000007;
    public static long func(int idx,Map<Integer,Integer> mp,int []arr,int n,long []dp){
        if(dp[idx]!=-1){
            return dp[idx];
        }
        long ans=1;
        for(int i=0;i<n;i++){
            if(arr[idx]%arr[i]==0 && mp.containsKey(arr[idx]/arr[i])){
                ans+=func(i,mp,arr,n,dp)*func(mp.get(arr[idx]/arr[i]),mp,arr,n,dp);
                ans%=MOD;
            }
        }
        return dp[idx]=ans;
    }
    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer,Integer> mp=new HashMap<>();
        int n=arr.length;
        long dp[]=new long[n];
        for(int i=0;i<n;i++){
            mp.put(arr[i],i);
            dp[i]=-1;
        }
        for(int i=0;i<n;i++){
            dp[i]=func(i,mp,arr,n,dp);
        }
        long res=0;
        for(long val:dp){
            res+=val;
            res%=MOD;
        }
        return (int)res;
    }
}