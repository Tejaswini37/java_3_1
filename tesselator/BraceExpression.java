import java.util.*;
public class BraceExpression {
    
    public static String[] expand(String s){
        if(s.length()==0) return new String[]{""};
        TreeSet<String> set=new TreeSet<>();
        if(s.charAt(0)=='['){
            int i=1;
            while(s.charAt(i)!=']') i++;
            String s1=s.substring(1,i);
            String subs[]=s1.split(",");
            String strs[]=expand(s.substring(i+1));
            for(String x:subs){
                for(String y:strs){
                    set.add(x+y);
                }
            }
        }
        else{
            String strs[]=expand(s.substring(1));
            for(String x:strs){ 
                set.add(s.charAt(0)+x);
            }
        }
        return set.toArray(new String[0]);
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s=sc.nextLine();
        String[] s1=expand(s);
        System.out.println(Arrays.toString(s1));
    }
}
