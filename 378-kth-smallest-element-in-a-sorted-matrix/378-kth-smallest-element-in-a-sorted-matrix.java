class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int size=0,n=matrix.length,m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(size==k){
                    if(pq.peek()>matrix[i][j]){
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
                else{
                    pq.add(matrix[i][j]);
                    size++;
                }
            }
        }
        return pq.peek();
    }
}