import java.util.*;
public class Program7
{
   
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        boolean visited[]=new boolean[V];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
              adj.add(i,new ArrayList<Integer>());
        }
        for(int i=0;i<E;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
       
        util(visited,adj,V);
        sc.close(); 
        
    }
    public static void util(boolean visited[],ArrayList<ArrayList<Integer>> adj,int N){
       int disc[]=new int[N];
       int low[]=new int[N];
       int parent[]=new int[N];
       boolean isAP[]=new boolean[N];
       Arrays.fill(parent,-1);
       for(int i=0;i<N;i++){
           if(!visited[i]){
               fun(visited,disc,low,parent,i,0,adj,isAP);
           }
       }
       for(int i=0;i<N;i++){
           if(isAP[i]){
               System.out.println(i);;
           }
       }
       
    }
    public static void fun(boolean visited[],int disc[],int low[],int parent[],int i,int time,ArrayList<ArrayList<Integer>> adj,boolean isAP[]){
        visited[i]=true;
        disc[i]=low[i]=++time;
        int children=0;
        for(int k:adj.get(i)){
            if(!visited[k]){
                children++;
                parent[k]=i;
                fun(visited,disc,low,parent,k,time,adj,isAP);
                low[i]=Math.min(low[i],low[k]);
                if(parent[i]!=-1 && low[k]>=disc[i]){
                    isAP[i]=true;
                }
                if(parent[i]==-1 && children>1){
                    isAP[i]=true;
                }
            }
            else if(parent[i]!=k){
                low[i]=Math.min(low[i],disc[k]);
            }
        }
    }   
}