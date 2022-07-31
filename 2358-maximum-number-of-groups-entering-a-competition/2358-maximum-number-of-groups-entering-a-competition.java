class Solution {
    public int maximumGroups(int[] grades) {
        return (int)(Math.sqrt(8*grades.length+1)-1)/2;
    }
}