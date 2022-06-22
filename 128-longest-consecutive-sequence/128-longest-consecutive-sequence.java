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
        Set<Integer> vis=new HashSet<>();
        for(int val:nums){
            set.add(val);
        }
        int res=0;
        for(int val:nums){
            if(!set.contains(val-1) && !vis.contains(val)){
                res=Math.max(res,findOptimal(set,val));
                vis.add(val);
            }
        }
        return res;
    }
}