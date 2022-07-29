class Solution {
    public static void func(int rem,boolean []cnt,List<List<Integer>> l,List<Integer> res){
        if(rem==0){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<res.size();i++){
                list.add(res.get(i));
            }
            l.add(list);
        }
        else{
            for(int i=0;i<21;i++){
                if(cnt[i]){
                    cnt[i]=false;
                    res.add(i-10);
                    func(rem-1,cnt,l,res);
                    cnt[i]=true;
                    res.remove(res.size()-1);
                }
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean cnt[]=new boolean[21];
        for(int val:nums){
            cnt[val+10]=true;
        }
        List<List<Integer>> res=new ArrayList<>();
        func(nums.length,cnt,res,new ArrayList<>());
        return res;
    }
}
