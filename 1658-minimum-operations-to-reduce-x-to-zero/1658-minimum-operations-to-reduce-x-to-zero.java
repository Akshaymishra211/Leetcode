class Solution {
    public static void reverse(int arr[],int n){
        int l=0,r=n-1;
        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
    public static int binarySearch(int l,int r,int[] arr,int ele){
        int mid;
        while(l<=r){
            mid=(l+r)/2;
            if(arr[mid]==ele){
                return mid;
            }
            else if(arr[mid]>ele){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int pref[]=new int[n];
        int suff[]=new int[n];
        pref[0]=nums[0];
        for(int i=1;i<n;i++){
            pref[i]=pref[i-1]+nums[i];
        }
        suff[n-1]=nums[n-1];
        for(int i=n-2;i>-1;i--){
            suff[i]=suff[i+1]+nums[i];
        }
        int res=Integer.MAX_VALUE;
        for(int i=n-1;i>-1;i--){
            int idx=binarySearch(0,i-1,pref,x-suff[i]);
            if(idx!=-1){
                res=Math.min(res,n-i+idx+1);
            }
        }
        int temp=binarySearch(0,n-1,pref,x);
        if(temp!=-1){
            res=Math.min(res,temp+1);
        }
        reverse(suff,n);
        temp=binarySearch(0,n-1,suff,x);
        if(temp!=-1){
            res=Math.min(res,temp+1);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}