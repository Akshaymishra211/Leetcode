class Solution {
    public static Map<Integer,Boolean> mp;
    public static boolean vis[];
    public int openLock(String[] deadends, String target) {
        mp=new HashMap<>();
        vis=new boolean[10000];
        vis[0]=true;
        for(int i=0;i<deadends.length;i++){
            mp.put(Integer.parseInt(deadends[i]),true);
        }
        int final_val=Integer.parseInt(target),a,b,c,d,val;
        Queue<Pairs> q=new LinkedList<>();
        if(!mp.containsKey(0)){
            q.add(new Pairs(0,0));
        }
        while(!q.isEmpty()){
            Pairs p=q.poll();
            if(p.curr_val==final_val){
                return p.cnt;
            }
            d=p.curr_val%10;
            p.curr_val/=10;
            c=p.curr_val%10;
            p.curr_val/=10;
            b=p.curr_val%10;
            p.curr_val/=10;
            a=p.curr_val%10;
            p.curr_val/=10;
            val=a*1000+b*100+c*10+(d-1>=0 ? d-1 : 9);
            if(!mp.containsKey(val) && !vis[val]){
                vis[val]=true;
                q.add(new Pairs(val,p.cnt+1));
            }
            val=a*1000+b*100+c*10+(d+1<=9 ? d+1 : 0);
            if(!mp.containsKey(val) && !vis[val]){
                vis[val]=true;
                q.add(new Pairs(val,p.cnt+1));
            }
            val=a*1000+b*100+(c-1>=0 ? c-1 : 9)*10+d;
            if(!mp.containsKey(val) && !vis[val]){
                vis[val]=true;
                q.add(new Pairs(val,p.cnt+1));
            }
            val=a*1000+b*100+(c+1<=9 ? c+1 : 0)*10+d;
            if(!mp.containsKey(val) && !vis[val]){
                vis[val]=true;
                q.add(new Pairs(val,p.cnt+1));
            }
            val=a*1000+(b-1>=0 ? b-1 : 9)*100+c*10+d;
            if(!mp.containsKey(val) && !vis[val]){
                vis[val]=true;
                q.add(new Pairs(val,p.cnt+1));
            }
            val=a*1000+(b+1<=9 ? b+1 : 0)*100+c*10+d;
            if(!mp.containsKey(val) && !vis[val]){
                vis[val]=true;
                q.add(new Pairs(val,p.cnt+1));
            }
            val=(a-1>=0 ? a-1 : 9)*1000+b*100+c*10+d;
            if(!mp.containsKey(val) && !vis[val]){
                vis[val]=true;
                q.add(new Pairs(val,p.cnt+1));
            }
            val=(a+1<=9 ? a+1 : 0)*1000+b*100+c*10+d;
            if(!mp.containsKey(val) && !vis[val]){
                vis[val]=true;
                q.add(new Pairs(val,p.cnt+1));
            }
        }
        return -1;
    }
    static class Pairs{
        int curr_val,cnt;
        public Pairs(int curr_val,int cnt){
            this.curr_val=curr_val;
            this.cnt=cnt;
        }
    }
}
