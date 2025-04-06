import java.util.*;
public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int idx = sc.nextInt();
        reverse(arr,idx);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }

    public static void reverse(int arr[],int idx){
        idx %= arr.length;
        helper(arr,0,arr.length-1);
        helper(arr,0,idx-1);
        helper(arr,idx,arr.length-1);
    }

    public static void helper(int arr[],int s,int e){
        while(s<=e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}
