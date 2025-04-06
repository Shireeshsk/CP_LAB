import java.util.*;
public class DistinctNumbers{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(Arrays.toString(helper(arr,k)));
        sc.close();
    }

    public static int[] helper(int arr[],int k){
        int res[] = new int[arr.length-k+1];
        int idx = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<k;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        res[idx++] = map.size();
        int s = 0;
        for(int i = k;i<arr.length;i++){
            map.put(arr[s],map.get(arr[s])-1);
            if(map.get(arr[s])==0){
                map.remove(arr[s]);
            }
            s++;
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            res[idx++] = map.size();
        }
        return res;
    }
}