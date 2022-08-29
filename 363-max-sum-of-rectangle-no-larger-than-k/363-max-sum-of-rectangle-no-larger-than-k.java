class Solution {
    public static int solve(int []arr,int n,int k){
        TreeMap<Integer,Integer> mp=new TreeMap<>();
        int sum=0;
        int ans=Integer.MIN_VALUE;
        mp.put(0,1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            Integer keyGreaterThanEqualToSum=mp.ceilingKey(sum-k);
            if(keyGreaterThanEqualToSum!=null){
                ans=Math.max(ans,sum-keyGreaterThanEqualToSum);
            }
            mp.put(sum,1);
        }
        return ans;
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n=matrix.length,m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }
        int arr[]=new int[n];
        int cnt=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=i;j<m;j++){
                for(int l=0;l<n;l++){
                    arr[l]=matrix[l][j]-(i-1>=0?matrix[l][i-1]:0);
                }
                cnt=Math.max(cnt,solve(arr,n,k));
            }
        }
        return cnt;
    }
}