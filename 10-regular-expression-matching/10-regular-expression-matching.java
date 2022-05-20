class Solution {
    public static int compulsory[];
    public static char arr1[],arr2[];
    public static int n,m;
    public static int dp[][];
    public static boolean func(int i,int j){
        if(i>=n && j>=m){
            return true;
        }
        else if(i>=n && j<m){
            return false;
        }
        else if(j>=m && i<n){
            if(compulsory[i]>0){
                return false;
            }
            else{
                return true;
            }
        }
        else if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }
        else{
            boolean ans=false;
            if(i+1<n && arr1[i+1]=='*'){
                if(arr1[i]=='.' || arr1[i]==arr2[j]){
                    ans=func(i,j+1) || func(i+2,j+1) || func(i+2,j);
                }
                else{
                    ans=func(i+2,j);
                }
            }
            else{
                if(arr1[i]=='.' || arr1[i]==arr2[j]){
                    ans=func(i+1,j+1);
                }
            }
            if(!ans){
                dp[i][j]=0;
            }
            else{
                dp[i][j]=1;
            }
            return ans;
        }
    }
    public boolean isMatch(String s, String p) {
        arr2=s.toCharArray();
        arr1=p.toCharArray();
        n=arr1.length;
        m=arr2.length;
        dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j]=-1;
            }
        }
        compulsory=new int[n];
        int temp=0;
        for(int i=n-1;i>-1;i--){
            if(i==n-1 && arr1[i]!='*'){
                temp++;
            }
            else if(arr1[i]!='*' && arr1[i+1]!='*'){
                temp++;
            }
            compulsory[i]=temp;
        }
        return func(0,0);
    }
}