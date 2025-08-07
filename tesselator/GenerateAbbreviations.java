import java.util.*;
public class GenerateAbbreviations{
    // public static ArrayList<String> backtrack(String p,String up){
    //     if(up.isEmpty()){
    //         ArrayList<String> l=new ArrayList<>();
    //         l.add(p);
    //         return l;
    //     }
    //     ArrayList<String> l=new ArrayList<>();
    //     char ch=up.charAt(0);
    //     l.addAll(backtrack(p+ch,up.substring(1)));
    //     if(!p.isEmpty() && Character.isDigit(p.charAt(p.length()-1))){
    //         int last=Character.getNumericValue(p.charAt(p.length()-1));
    //         // int last = Integer.parseInt(String.valueOf(p.charAt(p.length() - 1)));
    
        
    //         String s1=p.substring(0,p.length()-1)+(last+1);
    //         l.addAll(backtrack(s1, up.substring(1)));
    //     }
    //     else{
    //         l.addAll(backtrack(p+'1', up.substring(1)));
    //     }
    //     return l;
    // }
    static void backtrack(StringBuilder sb,String s,int i,int k,ArrayList<String> ans){
        int len=sb.length();
        if(i==s.length()){
            if(k!=0) sb.append(k);
            ans.add(sb.toString());
            sb.setLength(len);
            return;
        }
        backtrack(sb, s, i+1, k+1, ans);
        if(k!=0) sb.append(k);
        backtrack(sb.append(s.charAt(i)), s, i+1, 0, ans);
        sb.setLength(len);
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine().toLowerCase();

        ArrayList<String> ans=new ArrayList<>();
        backtrack(new StringBuilder(),s,0,0,ans);
        Collections.sort(ans);
        System.out.println(ans);
    }
}
