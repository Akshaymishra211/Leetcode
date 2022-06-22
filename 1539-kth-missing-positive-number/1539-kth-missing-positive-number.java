class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int prev=0;
        int missingLessThanEqualToN=0;
        int extra=0;
        for(int i=0;i<n;i++){
            if(arr[i]==n){
                extra=1;
                break;
            }
        }
        for(int i=0;i<n && arr[i]<=n;i++){
            if(missingLessThanEqualToN+(arr[i]-prev-1)>=k){
                return prev+(k-missingLessThanEqualToN);
            }
            missingLessThanEqualToN+=(arr[i]-prev-1);
            prev=arr[i];
        }
        if(missingLessThanEqualToN+(n-prev-extra)>=k){
            return prev+(k-missingLessThanEqualToN);
        }
        if(prev!=n){
            missingLessThanEqualToN+=(n-prev-extra);
        }
        int mayBeAns=n+(k-missingLessThanEqualToN);
        for(int i=0;i<n;i++){
            if(arr[i]>n && arr[i]<=mayBeAns){
                mayBeAns++;
            }
        }
        return mayBeAns;
    }
}