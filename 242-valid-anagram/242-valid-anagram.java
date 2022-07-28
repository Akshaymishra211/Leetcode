class Solution {
    public boolean isAnagram(String s, String t) {
        int cnt[]=new int[26];
        for(int i=0;i<s.length();i++){
            cnt[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            if(cnt[t.charAt(i)-'a']==0){
                return false;
            }
            cnt[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(cnt[i]>0){
                return false;
            }
        }
        return true;
    }
}
