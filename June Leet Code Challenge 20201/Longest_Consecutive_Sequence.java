class Solution {
    public static Map<Integer,Boolean> mp;
    public static int n;
    public static Map<Integer,Integer> dp1;
    public static Map<Integer,Integer> dp2;
    public static int func1(int val){
        if(dp1.containsKey(val)){
            return dp1.get(val);
        }
        int a=0;
        if(mp.containsKey(val-1)){
            a=1+func1(val-1);
        }
        dp1.put(val, a);
        return a;
    }
    public static int func2(int val){
        if(dp2.containsKey(val)){
            return dp2.get(val);
        }
        int a=0;
        if(mp.containsKey(val+1)){
            a=1+func2(val+1);
        }
        dp2.put(val, a);
        return a;
    }
    public int longestConsecutive(int[] nums) {
        mp=new HashMap<>();
        dp1=new HashMap<>();
        dp2=new HashMap<>();
        n=nums.length;
        int maxi=0;
        for(int i=0;i<n;i++){
            mp.put(nums[i],true);
        }
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,func1(nums[i])+func2(nums[i])+1);
        }
        return maxi;
    }
}
