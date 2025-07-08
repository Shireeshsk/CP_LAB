import java.util.*;
public class Program12 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String target = sc.next();
        System.out.println(helper(s1, s2, target));
        sc.close();
    }

    static class FindUnion{
        int parent[];
        FindUnion(){
            this.parent = new int[26];
            for(int i = 0;i<parent.length;i++){
                parent[i] = i;
            }
        }

        public int find(int n){
            if(parent[n]!=n){
                parent[n] = find(parent[n]);
            }
            return parent[n];
        }

        public void union(int x,int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx==rooty) return;
            if(rootx>rooty){
                parent[rootx] = rooty;
            }
            else{
                parent[rooty] = rootx;
            }
        }
    }

    public static String helper(String s1 ,String s2 ,String target){
        StringBuilder sb = new StringBuilder();
        FindUnion fu = new FindUnion();
        for(int i = 0;i<s1.length();i++){
            fu.union(s1.charAt(i)-'a', s2.charAt(i)-'a');
        }
        for(int i = 0;i<target.length();i++){
            char ch = (char)(fu.find(target.charAt(i)-'a')+'a');
            sb.append(ch);
        }
        return sb.toString();
    }
}
