import java.util.*;
public class GrayCode{
    public static List<Integer> gray(int n){
        List<Integer> res=new ArrayList<>();
        res.add(0);
        helper(res,n);
        return res;
    }
    public static boolean helper(List<Integer> res,int n){
        if(res.size()==(1<<n)) return true;
        int curr=res.get(res.size()-1);
        for(int i=0;i<n;i++){
            int next=curr^(1<<i);
            if(!res.contains(next)){
                res.add(next);
                if(helper(res,n)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(gray(n));
    }
}