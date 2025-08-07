import java.util.*;
public class phonenumber{
    static ArrayList<String> bt(String p,String up){
        if(up.length()==0) {
            ArrayList<String> l=new ArrayList<>();
            l.add(p);
            return l;
        }
        ArrayList<String> l=new ArrayList<>();
        int r=up.charAt(0)-'0';
        int start=(r-2)*3+97;
        for(int i=0;i<3;i++){
            char ch=(char)(start+i);
            l.addAll(bt(p+ch,up.substring(1)));
        }
        return l;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        ArrayList<String> l=bt("",s);
        
        System.out.println(l);

    }
}