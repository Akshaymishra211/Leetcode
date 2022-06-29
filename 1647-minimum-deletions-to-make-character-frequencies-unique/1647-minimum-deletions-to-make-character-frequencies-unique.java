class Solution {
    public int minDeletions(String s) {
        int cnt[]=new int[26];
        for(int i=0;i<s.length();i++){
            cnt[s.charAt(i)-'a']++;
        }
        Arrays.sort(cnt);
        int mustBe[]=new int[26];
        int temp=cnt[25];
        for(int i=25;i>-1;i--){
            temp=Math.min(temp,cnt[i]);
            mustBe[i]=temp;
            temp--;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            ans+=cnt[i]-Math.max(0,mustBe[i]);
        }
        return ans;
    }
}