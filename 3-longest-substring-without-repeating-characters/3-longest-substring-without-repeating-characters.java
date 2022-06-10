class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,n=s.length();
        Map<Character,Boolean> mp=new HashMap<>();
        int ans=0;
        while(j<n){
            if(!mp.containsKey(s.charAt(j))){
                mp.put(s.charAt(j),true);
                ans=Math.max(ans,j-i+1);
                j++;
            }
            else{
                while(s.charAt(i)!=s.charAt(j)){
                    mp.remove(s.charAt(i));
                    i++;
                }
                mp.remove(s.charAt(i));
                i++;
            }
        }
        ans=Math.max(ans,j-i);
        return ans;
    }
}
