class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        boolean flag1=false,flag2=false;
        for(int i=1;i<m;i++){
            if(matrix[0][i]==0){
                flag1=true;
            }
        }
        for(int i=1;i<n;i++){
            if(matrix[i][0]==0){
                flag2=true;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            if(matrix[0][i]==0){
                for(int j=0;j<n;j++){
                    matrix[j][i]=0;
                }
            }
        }
        for(int i=1;i<n;i++){
            if(matrix[i][0]==0){
                for(int j=0;j<m;j++){
                    matrix[i][j]=0;
                }
            }
        }
        if(flag1){
            for(int i=1;i<m;i++){
                matrix[0][i]=0;
            }
        }
        if(flag2){
            for(int i=1;i<n;i++){
                matrix[i][0]=0;
            }
        }
        if(matrix[0][0]==0){
            for(int i=0;i<m;i++){
                matrix[0][i]=0;
            }
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
        if(matrix[0][0]!=0 && (flag1 || flag2)){
            matrix[0][0]=0;
        }
    }
}