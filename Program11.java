import java.util.*;
public class Program11 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(helper(arr));
        sc.close();
    }

    public static int helper(int arr[][]){
        int res = 0;
        int memo[][] = new int[arr.length][arr[0].length];
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                res = Math.max(res,dfs(i,j,arr,memo));
            }
        }
        return res;
    }

    public static int dfs(int i ,int j,int mat[][],int memo[][]){
        if(memo[i][j]!=0) return memo[i][j];
        int maxlen = 1; 
        int rowdir[] = {0,1,0,-1};
        int coldir[] = {1,0,-1,0};
        for(int sk = 0;sk<4;sk++){
            int nrow = i + rowdir[sk];
            int ncol = j + coldir[sk];
            if(nrow>=0 && nrow<mat.length && ncol>=0 && ncol < mat[0].length && mat[nrow][ncol]>mat[i][j]){
                maxlen = Math.max(maxlen,1+dfs(nrow,ncol,mat,memo));
            }
        }
        memo[i][j] = maxlen;
        return maxlen;
    }
}