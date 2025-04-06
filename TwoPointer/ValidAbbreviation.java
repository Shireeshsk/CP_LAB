public class ValidAbbreviation {
    public static boolean helper(String word,String abv){
        int i = 0;
        int j = 0;
        while(i<word.length() && j<abv.length()){
            char ch = abv.charAt(j);
            if(Character.isDigit(ch)){
                if(ch=='0'){
                    return false;
                }
                int num = 0;
                while(j<abv.length() && Character.isDigit(abv.charAt(j))){
                    num = num*10+(ch-'0');
                    j++;
                }
                i += num;
            }
            else{
                if(i>=word.length() || abv.charAt(j)!=word.charAt(i)) return false;
                j++;
                i++;
            }
        }
        return i==word.length() && j==abv.length();
    }
}
