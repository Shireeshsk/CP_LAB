import java.util.*;
public class Program8 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(helper(str));
        sc.close();
    }

    public static boolean helper(String str){
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int odd = 0;
        for(int sk : map.values()){
            if(sk%2!=0) odd++;
            if(odd>1) return false;
        }
        return true;
    }
}
