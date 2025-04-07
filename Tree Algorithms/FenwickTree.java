public class FenwickTree {
    static class Fenwick{
        int bit[];
        int n;
        Fenwick(int n){
            this.n = n;
            this.bit = new int[n+1];
        }

        public void update(int idx ,int val){
            while(idx<=n){
                bit[idx] +=val;
                idx += (idx & -idx);
            }
        }

        public int query(int i){
            int sum = 0;
            while(i>0){
                sum += bit[i];
                i -= (i &-i);
            }
            return sum;
        }

        public void build(int arr[]){
            for(int i = 1;i<=n;i++){
                update(i,arr[i]);
            }
        }
    }
}
