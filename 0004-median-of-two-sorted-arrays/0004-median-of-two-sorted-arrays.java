class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = -1;
        int last = 0;
        int prev = 0;
        int median = (nums1.length+nums2.length)/2;
        while(i<nums1.length && j<nums2.length){
            prev = last;
            if(nums1[i]<=nums2[j]){
                last = nums1[i];
                i++;
                k++;
            }
            else {
                last = nums2[j];
                j++;
                k++;
            }
            if(k == median)
            {
                break;
            }
        }
        if(k != median){
            while(i<nums1.length){
                prev = last;
                last = nums1[i];
                i++;
                k++;
                if(k == median)
                {
                    break;
                }
            }
            while(j<nums2.length){
                prev = last;
                last = nums2[j];
                j++;
                k++;
                if(k == median)
                {
                    break;
                }
            }
        }
        if((nums1.length+nums2.length)%2 == 0)
            return (prev+last)/2.0;
        return (double)last;
    }
}