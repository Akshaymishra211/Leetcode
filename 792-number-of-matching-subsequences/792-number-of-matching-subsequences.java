class Solution {
    public static int upper_bound(ArrayList<Integer> sortedarr, int size, int ele) {
        int l=0,r=size,mid;
        while(l<r) {
            mid=l+(r-l)/2;
            if(sortedarr.get(mid)<=ele) {
                l=mid+1;
            }
            else {
                r=mid;
            }
        }
        return l;
    }
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character,ArrayList<Integer>> map=new TreeMap<>();
        Map<Character,Integer> size=new TreeMap<>();
        for(int i=0;i<26;i++){
            char c=(char)(i+97);
            map.put(c, new ArrayList<>());
            size.put(c, 0);
        }
        for(int i=0;i<s.length();i++){
            map.get(s.charAt(i)).add(i);
            size.put(s.charAt(i),size.get(s.charAt(i))+1);
        }
        int cnt=0;
        for(int i=0;i<words.length;i++){
            String str=words[i];
            int prev=-1,temp;
            boolean is=true;
            for(int j=0;j<str.length();j++){
                temp=upper_bound(map.get(str.charAt(j)), size.get(str.charAt(j)), prev);
                if(temp>=size.get(str.charAt(j))){
                    is=false;
                    break;
                }
                prev=map.get(str.charAt(j)).get(temp);
            }
            if(is){
                cnt++;
            }
        }
        return cnt;
    }
}
