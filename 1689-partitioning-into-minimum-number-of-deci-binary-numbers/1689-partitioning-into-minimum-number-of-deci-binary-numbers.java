class Solution {
    public int minPartitions(String n) {
        int maxDigit=0;
        for(int i=0;i<n.length();i++){
            maxDigit=Math.max(maxDigit,n.charAt(i)-'0');
        }
        return maxDigit;
    }
}