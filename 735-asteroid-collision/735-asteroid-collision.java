class Solution {
    public static boolean opposite(int val1,int val2){
        return val1>0 && val2<0;
    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int ast:asteroids){
            while(!stack.isEmpty() && Math.abs(stack.peek())<Math.abs(ast) && opposite(stack.peek(),ast)){
                stack.pop();
            }
            if(!stack.isEmpty() && opposite(stack.peek(),ast) && Math.abs(stack.peek())==Math.abs(ast)){
                stack.pop();
            }
            else if(stack.isEmpty() || !opposite(stack.peek(),ast)){
                stack.push(ast);
            }
        }
        int res[]=new int[stack.size()];
        for(int i=res.length-1;i>-1;i--){
            res[i]=stack.pop();
        }
        return res;
    }
}
