class Solution {
    public static int LCS(int i,int j,String str1,String str2,int [][]dp){
        if(i<0 || j<0){
            return 0;
        }
        else if(dp[i][j]!=-1){
            return dp[i][j];
        }
        else{
            if(str1.charAt(i)==str2.charAt(j)){
                return dp[i][j]=1+LCS(i-1,j-1,str1,str2,dp);
            }
            return dp[i][j]=Math.max(LCS(i-1,j,str1,str2,dp),LCS(i,j-1,str1,str2,dp));
        }
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length(),m=word2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int lcs=LCS(n-1,m-1,word1,word2,dp);
        return n+m-2*lcs;
    }
}