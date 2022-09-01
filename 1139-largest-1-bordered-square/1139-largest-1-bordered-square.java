class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int hor[][]=new int[n][m];
        int ver[][]=new int[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            hor[i][0]=grid[i][0];
            ans=Math.max(ans,grid[i][0]);
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                hor[i][j]+=hor[i][j-1]+grid[i][j];
                ans=Math.max(ans,grid[i][j]);
            }
        }
        for(int i=0;i<m;i++){
            ver[0][i]=grid[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                ver[i][j]+=ver[i-1][j]+grid[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=j;k<m;k++){
                    if(grid[i][k]==0){
                        break;
                    }
                    int side=k-j;
                    if(i+side<n && ver[i+side][j]==ver[i][j]+side && ver[i+side][k]==ver[i][k]+side && hor[i+side][k]==hor[i+side][j]+side){
                        ans=Math.max(ans,side+1);
                    }
                }
            }
        }
        return ans*ans;
    }
}
