class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long curr=mass*1l;
        for(int val:asteroids){
            if(val>curr){
                return false;
            }
            curr+=val;
        }
        return true;
    }
}