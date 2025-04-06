import java.util.*;
public class DietPlanner{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int low = sc.nextInt();
        int high = sc.nextInt();
        System.out.println(Points(arr, k, low, high));
        sc.close();
    }

    public static int Points(int arr[],int k,int low,int high){
        int res = 0;
        int sum = 0;
        for(int i = 0;i<k;i++){
            sum += arr[i];
        }
        res += (sum<low)?-1:(sum>high)?1:0;
        int idx = 0;
        for(int i = k;i<arr.length;i++){
            sum -= arr[idx++];
            sum += arr[i];
            res += (sum<low)?-1:(sum>high)?1:0;
        }
        return res;
    }
}