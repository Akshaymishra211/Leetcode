class Solution {
    public static boolean checkSingleton(String str1,String str2){
        int dep[]=new int [26];
        Arrays.fill(dep,-1);
        for(int i=0;i<str1.length();i++){
            if(dep[str1.charAt(i)-'a']==-1){
                dep[str1.charAt(i)-'a']=str2.charAt(i)-'a';
            }
            else if(dep[str1.charAt(i)-'a']!=str2.charAt(i)-'a'){
                return false;
            }
        }
        return true;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list=new ArrayList<>();
        for(String str:words){
            if(checkSingleton(str,pattern) && checkSingleton(pattern,str)){
                list.add(str);
            }
        }
        return list;
    }
}
