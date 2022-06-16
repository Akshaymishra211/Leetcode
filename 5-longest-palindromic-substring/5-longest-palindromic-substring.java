class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int size=0,start=-1;
        for(int i=0;i<n;i++){
            int a[]=longestPallindromWithMiddle(i,i,s,n);
            if(size<a[1]){
                size=a[1];
                start=a[0];
            }
            int b[]=longestPallindromWithMiddle(i,i+1,s,n);
            if(size<b[1]){
                size=b[1];
                start=b[0];
            }
        }
        StringBuilder str=new StringBuilder();
        for(int i=start;i<start+size;i++){
            str.append(s.charAt(i));
        }
        return str.toString();
    }
    public static int[] longestPallindromWithMiddle(int i,int j,String str,int n){
        while(i>=0 && j<n && str.charAt(i)==str.charAt(j)){
            i--;
            j++;
        }
        return new int[]{i+1,j-i-1};
    }
}