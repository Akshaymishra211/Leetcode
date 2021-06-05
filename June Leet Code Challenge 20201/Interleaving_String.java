class Solution {
    public static char arr1[];
    public static char arr2[];
    public static char arr3[];
    public static int n,m,o;
    public static int dp[][][];
    public static boolean func(int i,int j,int k){
        if(i==n && j==m && k==o){
            return true;
        }
        else if(i<n && j<m && k<o && dp[i][j][k]!=0){
            return dp[i][j][k]==2;
            //1 represent false and 2 represent true;
        }
        else{
            boolean a=false,b=false;
            if(i<n && k<o && arr1[i]==arr3[k]){
                a=func(i+1, j, k+1);
            }
            if(j<m && k<o && arr2[j]==arr3[k]){
                b=func(i, j+1, k+1);
            }
            if(i<n && j<m && k<o){
                if(a || b){
                    dp[i][j][k]=2;
                }
                else{
                    dp[i][j][k]=1;
                }
            }
            return a || b;
        }
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        arr1=s1.toCharArray();
        arr2=s2.toCharArray();
        arr3=s3.toCharArray();
        n=s1.length();
        m=s2.length();
        o=s3.length();
        dp=new int[n][m][o];
        if(n+m!=o){
            return false;
        }
        return func(0, 0, 0);
    }
}
