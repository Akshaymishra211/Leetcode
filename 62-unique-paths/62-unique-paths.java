class Solution {
    public static int dp[][];
    public static boolean isValid(int x,int y,int m,int n){
        return x>=0 && x<m && y>=0 && y<n;
    }
    public static int dfs(int i,int j,int m,int n){
        if(!isValid(i,j,m,n)){
            return 0;
        }
        else if(i==m-1 && j==n-1){
            return 1;
        }
        else if(dp[i][j]!=0){
            return dp[i][j];
        }
        else{
            return dp[i][j]=dfs(i+1,j,m,n)+dfs(i,j+1,m,n);
        }
    }
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        return dfs(0,0,m,n);
    }
}
