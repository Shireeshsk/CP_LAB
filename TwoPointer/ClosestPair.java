public class ClosestPair {
    public static int[] helper(int arr1[],int arr2[],int target){
        int l = 0;
        int r = arr2.length-1;
        int s1 = 0;
        int s2 = 0;
        int min = Integer.MAX_VALUE;
        while(l<arr1.length && r>=0){
            int csum = arr1[l] + arr2[r];
            int diff = Math.abs(csum-target);
            if(diff<min){
                min = diff;
                s1 = arr1[l];
                s2 = arr2[r];
            }
            if(csum>target){
                r--;
            }
            else{
                l++;
            }
        }
        return new int[]{s1,s2};
    }   
}
