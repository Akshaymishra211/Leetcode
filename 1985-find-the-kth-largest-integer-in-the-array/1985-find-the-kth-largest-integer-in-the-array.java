class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq=new PriorityQueue<>(new sort());
        int size=0;
        for(int i=0;i<nums.length;i++){
            if(size<k){
                pq.add(nums[i]);
                size++;
            }
            else{
                if(sort.compareString(nums[i],pq.peek(),nums[i].length(),pq.peek().length())>0){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
    static class sort implements Comparator<String>{
        public int compare(String str1,String str2){
            return compareString(str1,str2,str1.length(),str2.length());
        }
        static int compareString(String str1,String str2,int len1,int len2){
            if(len1==len2){
                for(int i=0;i<len1;i++){
                    if(str1.charAt(i)>str2.charAt(i)){
                        return 1;
                    }
                    else if(str1.charAt(i)<str2.charAt(i)){
                        return -1;
                    }
                }
                return 0;
            }
            return len1-len2;
        }
    }
}