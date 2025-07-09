import java.util.*;
public class Program2 {
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
        long psum[] = new long[arr.length+1];
        int res = arr.length+1;
        for(int i = 0;i<arr.length;i++){
            psum[i+1] = psum[i] + arr[i];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0;i<=arr.length;i++){
            while(!dq.isEmpty() && psum[i]-psum[dq.peekFirst()]>=k){
                res = Math.min(res,i-dq.pollFirst());
            }
            while(!dq.isEmpty() && psum[i]<=psum[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        return res>arr.length?-1:res;
    }
}

