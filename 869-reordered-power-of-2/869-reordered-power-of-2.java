class Solution {
    public static void explode(int val,int [][]arr,int idx){
        while(val>0){
            arr[idx][val%10]++;
            val/=10;
        }
    }
    public static boolean compare(int []arr1,int []arr2){
        for(int i=0;i<10;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean reorderedPowerOf2(int n) {
        int [][]cnt=new int[30][10];
        int val=1;
        for(int i=0;i<30;i++){
            explode(val,cnt,i);
            val*=2;
        }
        int arr[]=new int[10];
        while(n>0){
            arr[n%10]++;
            n/=10;
        }
        for(int i=0;i<30;i++){
            if(compare(arr,cnt[i])){
                return true;
            }
        }
        return false;
    }
}