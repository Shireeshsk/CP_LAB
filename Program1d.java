public class Program1d {
    static class SegmentTree{
        int n;
        int tree[];
        SegmentTree(int n){
            this.n = n;
            this.tree = new int [4*n];
        }

        public void build(int arr[],int node, int start,int end){
            if(start==end){
                tree[node] = arr[start];
                return;
            }
            int mid = start+(end-start)/2;
            build(arr,2*node+1,start,mid);
            build(arr,2*node+2,mid+1,end);
            tree[node] = tree[2*node+1] + tree[2*node+2];
        }

        public int query(int l,int r){
            return queryUtil(0,0,n-1,l,r);
        }

        public int queryUtil(int node,int start,int end,int l,int r){
            if(r<start || end<l){
                return 0;
            }
            if(l<=start && end<=r){
                return tree[node];
            }
            int mid = (start+end)/2;
            int lsum = queryUtil(2*node+1,0,mid,l,r);
            int rsum = queryUtil(2*node+2,mid+1, end, l, r);
            return lsum + rsum;
        }

        public void update(int idx,int val){
            updateUtil(0,0,n-1,idx,val);
        }

        public void updateUtil(int node,int start,int end,int idx,int val){
            if(start == end){
                tree[node] = val;
            }
            else{
                int mid = (start+end)/2;
                if(idx<=mid){
                    updateUtil(2*node+1, start,mid, idx, val);
                }
                else{
                    updateUtil(2*node+2,mid+1, end, idx, val);
                }
                tree[node] = tree[2*node+1] + tree[2*node+2];
            }
        }
    }
}
