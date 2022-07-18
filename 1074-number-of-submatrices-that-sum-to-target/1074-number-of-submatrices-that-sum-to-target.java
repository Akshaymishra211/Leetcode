class Solution {
    public static boolean isValid(int x,int y,int n,int m){
        return x>=0 && x<n && y>=0 && y<m;
    }
    public static int solveByCol(int[][] matrix,int target,int n,int m){
        int cnt=0;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=i;j<m;j++){
                int curr_sum=0;
                mp.clear();
                mp.put(0,1);
                for(int k=0;k<n;k++){
                    curr_sum+=matrix[k][j]-(i-1>=0?matrix[k][i-1]:0);
                    cnt+=mp.getOrDefault(curr_sum-target,0);
                    mp.put(curr_sum,mp.getOrDefault(curr_sum,0)+1);
                }
            }
        }
        return cnt;
    }
    public static int solveByRow(int[][] matrix,int target,int n,int m){
        int cnt=0;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                matrix[j][i]+=matrix[j-1][i];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int curr_sum=0;
                mp.clear();
                mp.put(0,1);
                for(int k=0;k<m;k++){
                    curr_sum+=matrix[j][k]-(i-1>=0?matrix[i-1][k]:0);
                    cnt+=mp.getOrDefault(curr_sum-target,0);
                    mp.put(curr_sum,mp.getOrDefault(curr_sum,0)+1);
                }
            }
        }
        return cnt;
    }
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n=matrix.length,m=matrix[0].length;
        if(n>=m){
            return solveByCol(matrix,target,n,m);
        }
        else{
            return solveByRow(matrix,target,n,m);
        }
    }
}