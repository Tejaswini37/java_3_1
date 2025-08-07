import java.util.*;
import java.util.Scanner;

class adjacency_list{
    public static void addEdge(List<List<Integer>> a,int x,int y){
        a.get(x).add(y);
        a.get(y).add(x);
    }
    public static void display(List<List<Integer>> a){
        for(int i=0;i<a.size();i++){
            System.out.print(i+": ");
            for(int j:a.get(i)){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        List<List<Integer>> a=new ArrayList<>(v);
        for(int i=0;i<v;i++){ 
            
            a.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){ 
            int x=sc.nextInt();
            int y=sc.nextInt();
            addEdge(a,x,y);
        }
        display(a);
    }
}