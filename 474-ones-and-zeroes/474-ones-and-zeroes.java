class Solution {
    public int func(int idx,int cm,int cn,int [][]arr,int m,int n,int len,int [][][]dp){
        if(idx>=len){
            return 0;
        }
        else if(dp[idx][cm][cn]!=-1){
            return dp[idx][cm][cn];
        }
        else{
            int ans=0;
            if(cm+arr[idx][0]<=m && cn+arr[idx][1]<=n){
                ans=1+func(idx+1,cm+arr[idx][0],cn+arr[idx][1],arr,m,n,len,dp);
            }
            return dp[idx][cm][cn]=Math.max(ans,func(idx+1,cm,cn,arr,m,n,len,dp));
        }
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int [][]arr=new int[strs.length][2];
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j)=='0'){
                    arr[i][0]++;
                }
                else{
                    arr[i][1]++;
                }
            }
        }
        int dp[][][]=new int[arr.length][m+1][n+1];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<m+1;j++){
                for(int k=0;k<n+1;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return func(0,0,0,arr,m,n,arr.length,dp);
    }
}

