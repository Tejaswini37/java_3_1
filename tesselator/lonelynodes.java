

import java.util.*;
import java.util.Scanner;

class Node{
    int data;
    Node left,right;

    public Node(int d) {
        this.data=d;
        left=null;
        right=null;
    }
    
}
class Solution{
    public ArrayList<Integer> getPersonIds(Node root){
        ArrayList<Integer> nodes=new ArrayList<>();
        getPersonIds(root,false,nodes);
        return nodes;
    }
    private void getPersonIds(Node root,boolean isLonely,ArrayList<Integer> nodes){
        if(root==null) return;
        if(isLonely&& root.data!=-1){
            nodes.add(root.data);
        }
        getPersonIds(root.left,root.right==null || root.right.data==-1,nodes);
        getPersonIds(root.right,root.left==null || root.left.data==-1,nodes);
    }

}
public class lonelynodes {
    public static void insert(Node root,int key){
        
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            root=q.peek();
            q.remove();
            if(root.left==null){
                root.left=new Node(key);
                break;
            }
            else q.add(root.left);
            if(root.right==null){
                root.right=new Node(key);
                break;
            }
            else{
                q.add(root.right);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Solution s=new Solution();
        String s1[]=sc.nextLine().split(" ");
        Node root=new Node(Integer.parseInt(s1[0]));
        for(int i=1;i<s1.length;i++){
            insert(root,Integer.parseInt(s1[i]));
        }
        System.out.println(s.getPersonIds(root));
    }
    
}
