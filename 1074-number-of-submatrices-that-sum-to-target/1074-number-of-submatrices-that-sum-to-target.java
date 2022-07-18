class Solution {
    public static boolean isValid(int x,int y,int n,int m){
        return x>=0 && x<n && y>=0 && y<m;
    }
    public static int getSum(int i,int j,int n,int m,int [][]mat){
        if(isValid(i,j,n,m)){
            return mat[i][j];
        }
        return 0;
    }
    public static int solve(int x,int y,int n,int m,int [][]arr,int target){
        int res=0;
        for(int i=x;i<n;i++){
            for(int j=y;j<m;j++){
                if(arr[i][j]-getSum(i,y-1,n,m,arr)-getSum(x-1,j,n,m,arr)+getSum(x-1,y-1,n,m,arr)==target){
                    res++;
                }
            }
        }
        return res;
    }
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n=matrix.length,m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isValid(i,j-1,n,m)){
                    matrix[i][j]+=matrix[i][j-1];
                }
                if(isValid(i-1,j,n,m)){
                    matrix[i][j]+=matrix[i-1][j];
                }
                if(isValid(i-1,j-1,n,m)){
                    matrix[i][j]-=matrix[i-1][j-1];
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cnt+=solve(i,j,n,m,matrix,target);
            }
        }
        return cnt;
    }
}