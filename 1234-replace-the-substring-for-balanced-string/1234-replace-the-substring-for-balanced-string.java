class Solution {
    public static boolean isOptimalSubString(Map<Character,Integer> curr,Map<Character,Integer> deleted){
        for(char ch:deleted.keySet()){
            if(curr.get(ch)<deleted.get(ch)){
                return false;
            }
        }
        return true;
    }
    public int balancedString(String s) {
        Map<Character,Integer> mp=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        Map<Character,Integer> toBeDeleted=new HashMap<>();
        for(char ch:mp.keySet()){
            if(mp.get(ch)>n/4){
                toBeDeleted.put(ch,mp.get(ch)-n/4);
            }
        }
        Map<Character,Integer> cur=new HashMap<>();
        cur.put('Q',0);
        cur.put('W',0);
        cur.put('E',0);
        cur.put('R',0);
        if(toBeDeleted.size()==0){
            return 0;
        }
        int l=0,res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            cur.put(s.charAt(i),cur.get(s.charAt(i))+1);
            while(l<=i && isOptimalSubString(cur,toBeDeleted)){
                res=Math.min(res,i-l+1);
                cur.put(s.charAt(l),cur.get(s.charAt(l))-1);
                l++;
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}