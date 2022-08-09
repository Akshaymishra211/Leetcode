class Solution {
    public static int upperBound(List<Integer> list,int n,int ele){
        int l=0,r=n,mid;
        while(l<r){
            mid=(l+r)/2;
            if(list.get(mid)<=ele){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }
    public static int func(int idx,String str,List<Integer>[] arr,int []size,int k,int n,int []dp){
        if(idx>=n){
            return 0;
        }
        else if(dp[idx]!=-1){
            return dp[idx];
        }
        else{
            int t=str.charAt(idx)-'a';
            int ans=0;
            for(int i=Math.max(0,t-k);i<=Math.min(25,t+k);i++){
                int next=upperBound(arr[i],size[i],idx);
                next=(next==size[i])?n:arr[i].get(next);
                ans=Math.max(ans,1+func(next,str,arr,size,k,n,dp));
            }
            return dp[idx]=ans;
        }
    }
    public int longestIdealString(String s, int k) {
        List<Integer>[] cnt=new ArrayList[26];
        for(int i=0;i<26;i++){
            cnt[i]=new ArrayList<>();
        }
        int size[]=new int[26];
        int n=s.length();
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            cnt[s.charAt(i)-'a'].add(i);
            size[s.charAt(i)-'a']++;
            dp[i]=-1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,func(i,s,cnt,size,k,n,dp));
        }
        return ans;
    }
}