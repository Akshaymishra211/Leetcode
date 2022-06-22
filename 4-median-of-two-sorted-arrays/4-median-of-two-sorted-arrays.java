class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        if(n>m){
            return findMedianSortedArrays(nums2,nums1);
        }
        int l=0,r=Math.min(n,m);
        while(l<=r){
            int posx=(l+r)/2;
            int posy=(n+m+1)/2-posx;
            int maxx=posx==0?Integer.MIN_VALUE:nums1[posx-1];
            int minx=posx==n?Integer.MAX_VALUE:nums1[posx];
            int maxy=posy==0?Integer.MIN_VALUE:nums2[posy-1];
            int miny=posy==m?Integer.MAX_VALUE:nums2[posy];
            if(maxx<=miny && maxy<=minx){
                if((n+m)%2==0){
                    return (Math.max(maxx,maxy)*1.0+Math.min(minx,miny)*1.0)/2;
                }
                else{
                    return Math.max(maxx,maxy)*1.0;
                }
            }
            else if(maxx>miny){
                r=posx-1;
            }
            else{
                l=posx+1;
            }
        }
        return -1.0;
    }
}