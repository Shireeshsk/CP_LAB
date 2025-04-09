import java.util.*;
public class Program1a {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]= new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(helper(arr,k)-helper(arr,k-1));
        sc.close();
    }

    public static int helper(int arr[] ,int k){
        int ans = 0;
        int l = 0;
        int r = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(r<arr.length){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            while(map.size()>k){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0){
                    map.remove(arr[l]);
                }
                l++;
            }
            ans += (r-l+1);
            r++;
        }
        return ans;
    }
}
