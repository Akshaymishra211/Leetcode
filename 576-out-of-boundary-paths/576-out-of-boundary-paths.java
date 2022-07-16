class Solution {
    public static int dx[]={0,-1,0,1};
    public static int dy[]={-1,0,1,0};
    public static int mod=1000000007;
    public int func(int r,int c,int moves,int m,int n,int [][][]dp){
        if(r<0 || c<0 || r>=m || c>=n){
            return 1;
        }    
        else if(dp[r][c][moves]!=-1){
            return dp[r][c][moves];
        }
        else{
            int ans=0;
            for(int i=0;i<4;i++){
                if(moves>0){
                    ans+=func(r+dx[i],c+dy[i],moves-1,m,n,dp);
                    ans%=mod;
                }
            }
            return dp[r][c][moves]=ans;
        }
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int dp[][][]=new int[m][n][maxMove+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(startRow,startColumn,maxMove,m,n,dp);
    }
}