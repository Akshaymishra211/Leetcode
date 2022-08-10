class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        int arr[]=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=n-1;i>-1;i--){
            while(!stack.isEmpty() && nums2[stack.peek()]<=nums2[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                arr[i]=-1;
            }
            else{
                arr[i]=nums2[stack.peek()];
            }
            stack.push(i);
        }
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(nums2[i],i);
        }
        int res[]=new int[nums1.length];
        for(int i=0;i<res.length;i++){
            res[i]=arr[mp.get(nums1[i])];
        }
        return res;
    }
}
