class Solution {
    public static boolean isValid(int i,int j,int n,int m){
        return i>=0 && i<n && j>=0 && j<m;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<Pair> q=new LinkedList<>();
        int n=heights.length,m=heights[0].length;
        boolean atlvis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            q.add(new Pair(i,0));
            atlvis[i][0]=true;
        }
        for(int i=0;i<m;i++){
            q.add(new Pair(0,i));
            atlvis[0][i]=true;
        }
        while(!q.isEmpty()){
            Pair p=q.poll();
            if(isValid(p.x-1,p.y,n,m) && !atlvis[p.x-1][p.y] && heights[p.x][p.y]<=heights[p.x-1][p.y]){
                atlvis[p.x-1][p.y]=true;
                q.add(new Pair(p.x-1,p.y));
            }
            if(isValid(p.x+1,p.y,n,m) && !atlvis[p.x+1][p.y] && heights[p.x][p.y]<=heights[p.x+1][p.y]){
                atlvis[p.x+1][p.y]=true;
                q.add(new Pair(p.x+1,p.y));
            }
            if(isValid(p.x,p.y-1,n,m) && !atlvis[p.x][p.y-1] && heights[p.x][p.y]<=heights[p.x][p.y-1]){
                atlvis[p.x][p.y-1]=true;
                q.add(new Pair(p.x,p.y-1));
            }
            if(isValid(p.x,p.y+1,n,m) && !atlvis[p.x][p.y+1] && heights[p.x][p.y]<=heights[p.x][p.y+1]){
                atlvis[p.x][p.y+1]=true;
                q.add(new Pair(p.x,p.y+1));
            }
        }
        boolean pacvis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            q.add(new Pair(i,m-1));
            pacvis[i][m-1]=true;
        }
        for(int i=0;i<m;i++){
            q.add(new Pair(n-1,i));
            pacvis[n-1][i]=true;
        }
        while(!q.isEmpty()){
            Pair p=q.poll();
            if(isValid(p.x-1,p.y,n,m) && !pacvis[p.x-1][p.y] && heights[p.x][p.y]<=heights[p.x-1][p.y]){
                pacvis[p.x-1][p.y]=true;
                q.add(new Pair(p.x-1,p.y));
            }
            if(isValid(p.x+1,p.y,n,m) && !pacvis[p.x+1][p.y] && heights[p.x][p.y]<=heights[p.x+1][p.y]){
                pacvis[p.x+1][p.y]=true;
                q.add(new Pair(p.x+1,p.y));
            }
            if(isValid(p.x,p.y-1,n,m) && !pacvis[p.x][p.y-1] && heights[p.x][p.y]<=heights[p.x][p.y-1]){
                pacvis[p.x][p.y-1]=true;
                q.add(new Pair(p.x,p.y-1));
            }
            if(isValid(p.x,p.y+1,n,m) && !pacvis[p.x][p.y+1] && heights[p.x][p.y]<=heights[p.x][p.y+1]){
                pacvis[p.x][p.y+1]=true;
                q.add(new Pair(p.x,p.y+1));
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(atlvis[i][j] && pacvis[i][j]){
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }
    static class Pair{
        int x,y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
