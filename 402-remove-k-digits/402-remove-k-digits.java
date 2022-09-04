class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        Stack<Integer> stack=new Stack<>();
        int nextSmaller[]=new int[n];
        for(int i=n-1;i>-1;i--){
            while(!stack.isEmpty() && num.charAt(stack.peek())>=num.charAt(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextSmaller[i]=n;
            }
            else{
                nextSmaller[i]=stack.peek();
            }
            stack.push(i);
        }
        StringBuilder str=new StringBuilder();
        k=n-k;
        for(int i=0;i<n && k>0;i++){
            if(n-nextSmaller[i]<k){
                str.append(num.charAt(i));
                k--;
            }
        }
        String res=str.toString();
        int i=0;
        while(i<res.length() && str.charAt(i)=='0'){
            i++;
        }
        res=res.substring(i);
        if(res.length()==0){
            return "0";
        }
        return res;
    }
}
