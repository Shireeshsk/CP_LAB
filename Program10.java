import java.util.*;
public class Program10 {

    static class Node{
        Node left;
        Node right;
        int data;

        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
        Node(){}
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        int arr[] = new int[str.length];
        int i = 0;
        for(String sk : str) {
            arr[i++] = sk.equals("null") ? -1 : Integer.valueOf(sk);
        }
        int p = sc.nextInt();
        int q = sc.nextInt();
        helper(arr,p,q);
        sc.close();
    }

    public static Node buildtree(int arr[]){
        if (arr.length == 0 || arr[0] == -1) return null;
        int i = 0;
        Node root = new Node(arr[i++]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(i < arr.length){
            Node sk = q.remove();
            if(i < arr.length && arr[i]!=-1){
                sk.left = new Node(arr[i]);
                q.add(sk.left);
            }
            i++;
            if(i < arr.length && arr[i]!=-1){
                sk.right = new Node(arr[i]);
                q.add(sk.right);
            }
            i++;
        }
        return root;
    }

    public static Node LCA(Node root , int p ,int q){
        if(root==null) return null;
        if(root.data == p || root.data == q) return root;
        Node left = LCA(root.left,p,q);
        Node right = LCA(root.right,p,q);
        if(left!=null && right!=null) return root;
        return left!=null ? left:right;
    }

    public static void helper(int arr[],int p,int q){
        Node root = buildtree(arr);
        Node res = LCA(root, p, q);
        if(res==null){
            System.out.println("Does not have least common ancestor");
        }
        else{
            System.out.println("Ancestor : "+res.data);
        }
    }
}
