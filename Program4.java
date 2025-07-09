public class Program4 {
    static class SegmentTree{
        int size;
        int Tree[];

        SegmentTree(int arr[]){
            this.size = arr.length;
            this.Tree= new int[4*size];
            build(arr,0,0,arr.length-1);
        }

        public void build(int arr[],int node,int l,int r){
            if(l==r){
                Tree[node] = arr[l];
            }
            else{
                int mid = (l+r)/2;
                build(arr,2*node+1,l,mid);
                build(arr,2*node+2,mid+1,r);
                Tree[node] = Tree[2*node+1] + Tree[2*node+2];
            }
        }

        public int query(int l ,int r){
            return query(0,0,size-1,l,r);
        }

        public int query(int node,int s,int e,int l,int r){
            if(r<s || l>e){
                return 0;
            }
            if(l<=s && e<=r){
                return Tree[node];
            }
            else{
                int mid = (s+e)/2;
                int left = query(2*node+1,s,mid,l,r);
                int right = query(2*node+2,mid+1,e,l,r);
                return left+right;
            }
        }

        public void update(int idx,int val){
            update(0,0,size-1,idx,val);
        }

        public void update(int node,int s,int e,int idx,int val){
            if(s==e){
                Tree[node] = val;
            }
            else{
                int mid = (s+e)/2;
                if(idx<=mid){
                    update(2*node+1,s,mid,idx,val);
                }
                else{
                    update(2*node+2,mid+1,e,idx,val);
                }
                Tree[node] = Tree[2*node+1]+Tree[2*node+2];
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);

        System.out.println("Sum of values in range [1, 3]: " + st.query(1, 3)); // Output: 15

        st.update(1, 10); // arr[1] = 10
        System.out.println("After update, sum of values in range [1, 3]: " + st.query(1, 3)); // Output: 22
    }
}
