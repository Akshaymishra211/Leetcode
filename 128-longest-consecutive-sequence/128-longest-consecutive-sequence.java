class Solution {
    public static int findOptimal(Set<Integer> set,int num){
        int cnt=0;
        while(set.contains(num)){
            cnt++;
            num++;
        }
        return cnt;
    }
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int val:nums){
            set.add(val);
        }
        int res=0;
        for(int val:nums){
            if(!set.contains(val-1)){
                res=Math.max(res,findOptimal(set,val));
            }
        }
        return res;
    }
}