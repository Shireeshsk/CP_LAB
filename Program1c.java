import java.util.*;
public class Program1c {
    static class FenwickTree{
        int n;
        int bit[];
        FenwickTree(int n){
            this.n = n;
            this.bit = new int[n+1];
        }

        public void build(int arr[]){
            for(int i = 0;i<arr.length;i++){
                update(i+1,arr[i]);
            }
        }

        public void update(int i,int val){
            while(i<=n){
                bit[i] +=val;
                i += (i & -i);
            }
        }

        public int query(int idx){
            int sum = 0;
            while(idx>0){
                sum += bit[idx];
                idx -= (idx & -idx);
            }
            return sum;
        }

        public int RangeQuery(int s,int e){
            return query(e) - query(s-1);
        }
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        FenwickTree tree = new FenwickTree(n);
        tree.build(arr);
        tree.RangeQuery(0, 4);
        sc.close();
    }
}
