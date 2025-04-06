import java.util.*;
public class KthSmallestSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(BinarySearch(arr, k));
        sc.close();
    }

    public static int BinarySearch(int arr[],int k){
        int left = 0;
        int right = 0;
        for(int i : arr){
            right+=i;
        }
        while(left<right){
            int mid = left+(right-left)/2;
            if(Sum(arr,mid)<k){
                left = mid +1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    public static int Sum(int arr[],int target){
        int count = 0;
        int sum = 0;
        int left = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            while(sum>target){
                sum -= arr[left++];
            }
            count += (i-left+1);
        }
        return count;
    }
}
