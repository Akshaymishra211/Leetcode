class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        boolean vis[]=new boolean[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(edges[i]!=-1){
                adj.get(i).add(edges[i]);
            }
        }
        int dis1[]=new int[n];
        Arrays.fill(dis1,-1);
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(node1,0));
        vis[node1]=true;
        dis1[node1]=0;
        while(!q.isEmpty()){
            Pair p=q.poll();
            for(int child:adj.get(p.node)){
                if(!vis[child]){
                    vis[child]=true;
                    dis1[child]=p.dis+1;
                    q.add(new Pair(child,dis1[child]));
                }
            }
        }
        Arrays.fill(vis,false);
        int dis2[]=new int[n];
        Arrays.fill(dis2,-1);
        q.add(new Pair(node2,0));
        dis2[node2]=0;
        vis[node2]=true;
        while(!q.isEmpty()){
            Pair p=q.poll();
            for(int child:adj.get(p.node)){
                if(!vis[child]){
                    vis[child]=true;
                    dis2[child]=p.dis+1;
                    q.add(new Pair(child,dis2[child]));
                }
            }
        }
        int res=-1,dis=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(dis1[i]!=-1 && dis2[i]!=-1){
                if(Math.max(dis1[i],dis2[i])<dis){
                    dis=Math.max(dis1[i],dis2[i]);
                    res=i;
                }
            }
        }
        return res;
    }
    static class Pair{
        int node,dis;
        public Pair(int node,int dis){
            this.node=node;
            this.dis=dis;
        }
    }
}
