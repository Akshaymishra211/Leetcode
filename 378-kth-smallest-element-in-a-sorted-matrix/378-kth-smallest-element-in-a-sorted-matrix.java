class Solution {
    public static boolean isValid(int x,int y,int n,int m){
        return x>=0 && x<n && y>=0 && y<m;
    }
    public static int countLessThan(int mid,int arr[][],int m,int n){
        int cnt=0,r=0,c=n-1;
        while(isValid(r,c,n,m)){
            if(arr[r][c]>mid){
                c--;
            }
            else{
                cnt+=(c+1);
                r++;
            }
        }
        return cnt;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length,m=matrix[0].length,l=matrix[0][0],r=matrix[n-1][m-1],ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(countLessThan(mid,matrix,m,n)>=k){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}