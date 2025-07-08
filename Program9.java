import java.util.*;
public class Program9 {
    static class Node{
        Node links[];
        boolean flag;

        Node(){
            this.links = new Node[26];
            this.flag = false;
        }

        public boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }

        public void put(char ch ,Node node){
            links[ch-'a'] = node;
        }

        public Node get(char ch){
            return links[ch-'a'];
        }

        public void setEnd(){
            this.flag = true;
        }

        public boolean isEnd(){
            return this.flag;
        }
    }

    static class Trie{
        Node root;
        Trie(){
            this.root = new Node();
        }

        public void insert(String str){
            Node temp = root;
            for(char ch : str.toCharArray()){
                if(!temp.containsKey(ch)){
                    temp.put(ch,new Node());
                }
                temp = temp.get(ch);
            }
            temp.setEnd();
        }

        public boolean find(String str){
            Node temp = root;
            for(char ch : str.toCharArray()){
                if(!temp.containsKey(ch)){
                    return false;
                }
                temp = temp.get(ch);
            }
            return temp.isEnd();
        }

        public List<List<Integer>> helper(String word){
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0;i<word.length();i++){
                if(root.containsKey(word.charAt(i))){
                    for(int j = i+1;j<word.length();j++){
                        String temp = word.substring(i,j+1);
                        if(find(temp)){
                            List<Integer> list = new ArrayList<>();
                            list.add(i);
                            list.add(j);
                            res.add(list);
                        }
                    }
                }
            }
            return res;
        }
    }

    public static void helper(String words[],String word){
        Trie trie = new Trie();
        for(String sk : words){
            trie.insert(sk);
        }
        System.out.println(trie.helper(word));
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String words[] = sc.nextLine().split(" ");
        String word = sc.next();
        helper(words, word);
        sc.close();
    }
}
