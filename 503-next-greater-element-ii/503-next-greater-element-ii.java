class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int arr[]=new int[2*n];
        for(int i=0;i<2*n;i++){
            arr[i]=nums[i%n];
        }
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[2*n];
        for(int i=2*n-1;i>-1;i--){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i]=-1;
            }
            else{
                res[i]=arr[stack.peek()];
            }
            stack.push(i);
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=res[i];
        }
        return ans;
    }
}
