class Solution {
    public static boolean isValid(int i,int j,int n,int m){
        return i>=0 && i<n && j>=0 && j<m;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length,m=matrix[0].length,i=0,j=m-1;
        while(isValid(i,j,n,m)){
            if(matrix[i][j]==target){
                return true;
            }
            else if(matrix[i][j]>target){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
}
