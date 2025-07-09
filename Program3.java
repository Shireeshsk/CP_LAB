import java.util.*;
public class Program3 {
    static class FenwickTree{
        int T[];
        int size;

        FenwickTree(int n){
            this.size = n;
            this.T = new int[n+1];
        }

        public void update(int idx,int val){
            while(idx<=size){
                T[idx] += val;
                idx += (idx & -idx); 
            }
        }

        public int query(int i){
            int sum = 0;
            while(i>0){
                sum += T[i];
                i -= (i & -i);
            }
            return sum;
        }

        public int rangeQuery(int l,int r){
            return query(r)-query(l-1);
        }

        public void build(int arr[]){
            for(int i = 0;i<arr.length;i++){
                update(i+1,arr[i]);
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        FenwickTree ft = new FenwickTree(n);
        ft.build(arr);
        System.out.println(ft.query(5));
        System.out.println(ft.rangeQuery(3,6));
        sc.close();
    }
}
