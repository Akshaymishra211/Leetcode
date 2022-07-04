class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int res=0,curr=1;
        int arr[]=new int[n];
        arr[0]=1;arr[n-1]=1;
        for(int i=1;i<n;i++){
            if(ratings[i]==ratings[i-1]){
                arr[i]=1;
            }
            else if(ratings[i]>ratings[i-1]){
                arr[i]=1+arr[i-1];
            }
            else{
                arr[i]=1;
            }
        }
        for(int i=n-2;i>-1;i--){
            if(ratings[i]>ratings[i+1] && arr[i]<1+arr[i+1]){
                arr[i]=1+arr[i+1];
            }
            else if(arr[i]==0){
                arr[i]=1;
            }
        }
        for(int val:arr){
            res+=val;
        }
        return res;
    }
}
