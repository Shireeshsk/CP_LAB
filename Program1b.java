import java.util.*;
public class Program1b {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(helper(arr,k));
        sc.close();
    }

    public static int helper(int arr[],int k){
        int pre[] = new int[arr.length+1];
        for(int i = 0;i<arr.length;i++){
            pre[i+1] = pre[i] + arr[i];
        }
        int ans = arr.length+1;
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0;i<arr.length;i++){
            while(!dq.isEmpty() && pre[i]-pre[dq.peekFirst()]>=k){
                ans = Math.min(ans,i-dq.pollFirst());
            }
            while(!dq.isEmpty() && pre[i]<=pre[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return ans<=arr.length ? ans : -1;
    }
}
