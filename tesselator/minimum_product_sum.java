import java.util.*;

public class minimum_product_sum {
    public static int minps(int a[],int n)
    {   if(n==1) return a[0];
        int p=1;
        int c_0=0;
        int min_pos=Integer.MAX_VALUE;
        int max_neg=Integer.MIN_VALUE;
        int c_n=0;
        for(int i=0;i<n;i++){
            if(a[i]!=0) p=p*a[i];
            if(a[i]==0) c_0++;
            else if(a[i]<0) c_n++;
            if(a[i]<min_pos && a[i]>0) min_pos=a[i];
            else if(a[i]>max_neg && a[i]<0) max_neg=a[i];
            
        }
        if(c_n==0 && c_0>0) return 0;
       
        if(c_n==0 && c_0==0) return min_pos;
        if(c_n%2==0) return p/max_neg;
        return p;

        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        minps(a,n);
    }
}
