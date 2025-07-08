import java.util.*;
public class Program1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(helper(arr,k)-helper(arr,k-1));
        sc.close();
    }

    public static int helper(int arr[],int k){
        int res = 0;
        int j = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            while(map.size()>k){
                map.put(arr[j],map.get(arr[j])-1);
                if(map.get(arr[j])==0){
                    map.remove(arr[j]);
                }
                j++;
            }
            res += (i-j+1);
        }
        return res;
    }
}