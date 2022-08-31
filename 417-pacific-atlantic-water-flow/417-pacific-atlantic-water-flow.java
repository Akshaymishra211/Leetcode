class Solution {
    public static boolean isValid(int i,int j,int n,int m){
        return i>=0 && i<n && j>=0 && j<m;
    }
    public static void bfs(Queue<Pair> q,boolean[][] vis,int n,int m,int [][]heights){
        while(!q.isEmpty()){
            Pair p=q.poll();
            int i=p.i,j=p.j;
            if(isValid(i-1,j,n,m) && !vis[i-1][j] && heights[i-1][j]>=heights[i][j]){
                q.add(new Pair(i-1,j));
                vis[i-1][j]=true;
            }
            if(isValid(i+1,j,n,m) && !vis[i+1][j] && heights[i+1][j]>=heights[i][j]){
                q.add(new Pair(i+1,j));
                vis[i+1][j]=true;
            }
            if(isValid(i,j-1,n,m) && !vis[i][j-1] && heights[i][j-1]>=heights[i][j]){
                q.add(new Pair(i,j-1));
                vis[i][j-1]=true;
            }
            if(isValid(i,j+1,n,m) && !vis[i][j+1] && heights[i][j+1]>=heights[i][j]){
                q.add(new Pair(i,j+1));
                vis[i][j+1]=true;
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length,m=heights[0].length;
        Queue<Pair> q=new LinkedList<>();
        boolean vis1[][]=new boolean[n][m];
        for(int i=0;i<m;i++){
            q.add(new Pair(0,i));
            vis1[0][i]=true;
        }
        for(int i=1;i<n;i++){
            q.add(new Pair(i,0));
            vis1[i][0]=true;
        }
        bfs(q,vis1,n,m,heights);
        q.clear();
        boolean vis2[][]=new boolean[n][m];
        for(int i=0;i<m-1;i++){
            q.add(new Pair(n-1,i));
            vis2[n-1][i]=true;
        }
        for(int i=0;i<n;i++){
            q.add(new Pair(i,m-1));
            vis2[i][m-1]=true;
        }
        bfs(q,vis2,n,m,heights);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis1[i][j] && vis2[i][j]){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
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