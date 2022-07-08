class Solution {
    public static int inf=1000001;
    public static int func(int idx,int prevColor,int neighbours,int []houses,int [][]cost,int m,int n,int target,int [][][]dp){
        if(idx>=m){
            if(target==neighbours){
                return 0;
            }
            return inf;
        }
        else if(dp[idx][prevColor][neighbours]!=-1){
            return dp[idx][prevColor][neighbours];
        }
        else{
            int mincost=inf;
            if(houses[idx]==0){
                for(int i=0;i<n;i++){
                    if(i+1==prevColor){
                        mincost=Math.min(mincost,cost[idx][i]+func(idx+1,i+1,neighbours,houses,cost,m,n,target,dp));
                    }
                    else{
                        mincost=Math.min(mincost,cost[idx][i]+func(idx+1,i+1,1+neighbours,houses,cost,m,n,target,dp));
                    }
                }
            }
            else{
                if(houses[idx]==prevColor){
                    mincost=Math.min(mincost,func(idx+1,houses[idx],neighbours,houses,cost,m,n,target,dp));
                }
                else{
                    mincost=Math.min(mincost,func(idx+1,houses[idx],1+neighbours,houses,cost,m,n,target,dp));
                }
            }
            return dp[idx][prevColor][neighbours]=mincost;
        }
    }
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int mincost=inf;
        int dp[][][]=new int[m+1][n+1][m+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                for(int k=0;k<m+1;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        if(houses[0]==0){
            for(int i=0;i<n;i++){
                mincost=Math.min(mincost,cost[0][i]+func(1,i+1,1,houses,cost,m,n,target,dp));
            }
        }
        else{
            mincost=Math.min(mincost,func(1,houses[0],1,houses,cost,m,n,target,dp));
        }
        return mincost>=inf?-1:mincost;
    }
}