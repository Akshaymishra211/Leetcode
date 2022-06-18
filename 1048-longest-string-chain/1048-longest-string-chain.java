class Solution {
    public static boolean isPredecessor(String str1,String str2,int n,int m){
        if(n==m-1){
            boolean skipped=false;
            int i=0,j=0;
            while(i<n && j<m){
                if(str1.charAt(i)!=str2.charAt(j)){
                    if(skipped){
                        return false;
                    }
                    skipped=true;
                }
                else{
                    i++;
                }
                j++;
            }
            return true;
        }
        return false;
    }
    public static int func(int curr,int prev,String []arr,int []len,int max,int [][]dp){
        if(curr>=max){
            return 1;
        }
        else if(prev!=-1 && dp[curr][prev]!=-1){
            return dp[curr][prev];
        }
        else{
            if(prev==-1){
                return Math.max(func(curr+1,curr,arr,len,max,dp),func(curr+1,prev,arr,len,max,dp));
            }
            else{
                dp[curr][prev]=Integer.MIN_VALUE;
                if(isPredecessor(arr[prev],arr[curr],len[prev],len[curr])){
                    dp[curr][prev]=1+func(curr+1,curr,arr,len,max,dp);
                }
                return dp[curr][prev]=Math.max(dp[curr][prev],func(curr+1,prev,arr,len,max,dp));
            }
        }
    }
    public int longestStrChain(String[] words) {
        int n=words.length;
        int size[]=new int[n];
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        Arrays.sort(words,new SortByLength());
        for(int i=0;i<n;i++){
            size[i]=words[i].length();
        }
        return func(0,-1,words,size,n,dp);
    }
    static class SortByLength implements Comparator<String>{
        public int compare(String str1,String str2){
            return str1.length()-str2.length();
        }
    }
}
