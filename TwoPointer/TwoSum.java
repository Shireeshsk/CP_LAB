import java.util.*;
public class TwoSum {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(Arrays.toString(helper(arr, k)));
        sc.close();
    }

    public static int[] helper(int arr[],int k){
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            if(arr[l]+arr[r]==k){
                return new int[]{l,r};
            }
            else if(arr[l]+arr[r]>k){
                r--;
            }
            else{
                l++;
            }
        }
        return new int[0];
    }
}
