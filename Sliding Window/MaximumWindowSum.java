import java.util.*;
public class MaximumWindowSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
        sc.close();
    }

    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || k <= 0) return new int[0];
        int n = arr.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0;i<arr.length;i++){
            while(!dq.isEmpty() && dq.peekFirst() < i-k+1){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                res[i-k+1]=arr[dq.peekFirst()];
            }
        }
        return res;
    }
}
