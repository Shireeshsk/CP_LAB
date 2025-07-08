import java.util.*;
public class Program6 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int arr[][] = new int[e][2];
        for(int i = 0;i<e;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        helper(arr,v);
        sc.close();
    }

    public static void helper(int arr[][],int v){
        List<List<Integer>> adj = new ArrayList<>();
        int indeg[] = new int[v];
        Arrays.fill(indeg,0);
        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<arr.length;i++){
            adj.get(arr[i][0]).add(arr[i][1]);
            indeg[arr[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int sk = q.remove();
            res.add(sk);
            for(int temp : adj.get(sk)){
                indeg[temp]--;
                if(indeg[temp]==0){
                    q.add(temp);
                }
            }
        }
        if (res.size() != v) {
            System.out.println("Graph contains a cycle!");
        } else {
            System.out.println("Topological Order: " + res);
        }
    }
}
