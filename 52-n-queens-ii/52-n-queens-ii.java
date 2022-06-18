class Solution {
    public static boolean isValid(int x,int y,int n){
        return x>=0 && x<n && y>=0 && y<n;
    }
    public static boolean isValidMove(int x,int y,int n,char [][]arr){
        for(int i=0;i<n;i++){
            if(arr[x][i]=='Q'){
                return false;
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i][y]=='Q'){
                return false;
            }
        }
        int t1=x-1,t2=y-1;
        while(isValid(t1,t2,n)){
            if(arr[t1][t2]=='Q'){
                return false;
            }
            t1--;
            t2--;
        }
        t1=x-1;
        t2=y+1;
        while(isValid(t1,t2,n)){
            if(arr[t1][t2]=='Q'){
                return false;
            }
            t1--;
            t2++;
        }
        t1=x+1;
        t2=y-1;
        while(isValid(t1,t2,n)){
            if(arr[t1][t2]=='Q'){
                return false;
            }
            t1++;
            t2--;
        }
        t1=x+1;
        t2=y+1;
        while(isValid(t1,t2,n)){
            if(arr[t1][t2]=='Q'){
                return false;
            }
            t1++;
            t2++;
        }
        return true;
    }
    public static int func(int row,char [][]arr,int n){
        if(row>=n){
            return 1;
        }
        else{
            int ans=0;
            for(int col=0;col<n;col++){
                if(isValidMove(row,col,n,arr)){
                    arr[row][col]='Q';
                    ans+=func(row+1,arr,n);
                    arr[row][col]='.';
                }
            }
            return ans;
        }
    }
    public int totalNQueens(int n) {
        char [][]grid=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]='.';
            }
        }
        return func(0,grid,n);
    }
}