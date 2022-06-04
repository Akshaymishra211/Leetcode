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
    public static void func(int row,char [][]arr,int n,List<List<String>> list){
        if(row>=n){
            List<String> res=new ArrayList<>();
            for(int i=0;i<n;i++){
                res.add(String.valueOf(arr[i]));
            }
            list.add(res);
        }
        else{
            for(int col=0;col<n;col++){
                if(isValidMove(row,col,n,arr)){
                    arr[row][col]='Q';
                    func(row+1,arr,n,list);
                    arr[row][col]='.';
                }
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList();
        char [][]grid=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]='.';
            }
        }
        func(0,grid,n,res);
        return res;
    }
}
