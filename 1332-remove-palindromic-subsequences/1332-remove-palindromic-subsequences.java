class Solution {
    public static boolean isPalindrome(String str){
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int removePalindromeSub(String s) {
        return isPalindrome(s)?1:2;
    }
}