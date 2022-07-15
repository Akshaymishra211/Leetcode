class Solution {
    public static boolean isValid(int i,int j,int n,int m){
        return i>=0 && i<n && j>=0 && j<m;
    }
    public int maxAreaOfIsland(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length,m=grid[0].length;
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int cnt=1;
                    q.add(new Pair(i,j));
                    grid[i][j]=0;
                    while(!q.isEmpty()){
                        Pair p=q.poll();
                        if(isValid(p.i,p.j-1,n,m) && grid[p.i][p.j-1]==1){
                            q.add(new Pair(p.i,p.j-1));
                            grid[p.i][p.j-1]=0;
                            cnt++;
                        }
                        if(isValid(p.i,p.j+1,n,m) && grid[p.i][p.j+1]==1){
                            q.add(new Pair(p.i,p.j+1));
                            grid[p.i][p.j+1]=0;
                            cnt++;
                        }
                        if(isValid(p.i-1,p.j,n,m) && grid[p.i-1][p.j]==1){
                            q.add(new Pair(p.i-1,p.j));
                            grid[p.i-1][p.j]=0;
                            cnt++;
                        }
                        if(isValid(p.i+1,p.j,n,m) && grid[p.i+1][p.j]==1){
                            q.add(new Pair(p.i+1,p.j));
                            grid[p.i+1][p.j]=0;
                            cnt++;
                        }
                    }
                    res=Math.max(res,cnt);
                }
            }
        }
        return res;
    }
    static class Pair{
        int i,j;
        public Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
}
