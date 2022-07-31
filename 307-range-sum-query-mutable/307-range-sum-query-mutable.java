class NumArray {
    public static int tree[];
    public static int n;
    public static int arr[];
    public NumArray(int[] nums) {
        n=nums.length;
        arr=nums;
        tree=new int[4*n];
        construct_tree(0,n-1,0);
    }
    
    public void update(int index, int val) {
        rangeupdate(0,n-1,index,val,0);
    }
    
    public int sumRange(int left, int right) {
        return rangeSum(0,n-1,left,right,0);
    }
    
    public static int construct_tree(int l,int r,int i){
        if(l==r){
            return tree[i]=arr[l];
        }
        else{
            int mid=(l+r)/2;
            return tree[i]=construct_tree(l, mid, 2*i+1)+construct_tree(mid+1, r, 2*i+2);
        }
    }
    
    public static int rangeSum(int l,int r,int x,int y,int i){
        if(l>=x && r<=y){
            return tree[i];
        }
        else if(r<x || l>y){
            return 0;
        }
        else{
            int mid=(l+r)/2;
            return rangeSum(l, mid, x, y, 2*i+1)+rangeSum(mid+1, r, x, y, 2*i+2);
        }
    }
    
    public static int rangeupdate(int l,int r,int idx,int value,int i){
        if(l>=idx && r<=idx){
            return tree[i]=value;
        }
        else if(r<idx || l>idx){
            return tree[i];
        }
        else{
            int mid=(l+r)/2;
            return tree[i]=rangeupdate(l, mid, idx, value, 2*i+1)+rangeupdate(mid+1, r, idx, value, 2*i+2);
        }
    }
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */