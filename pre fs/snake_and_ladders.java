import java.util.*;
class snake_and_ladders{
    public static int mindicerolls(int a[][],int n){
        int moves[]=new int[n*n+1];
        Arrays.fill(moves,-1);
        boolean lefttoright=true;
        int index= 1;
        for(int i=n-1;i>=0;i++){
            if(lefttoright){
                for(int j=0;j<n;j++){
                    moves[index++]=a[i][j];
                }
            }
            else{
                for(int j=n-1;j>=0;j++){
                    moves[index++]=a[i][j];
                }
            }
            lefttoright=!lefttoright;
        }
        Queue<int[]> q=new LinkedList<>();
        boolean vis[]=new boolean[n*n+1];
        q.add(new int[]{1,0});
        vis[1]=true;
        while(!q.isEmpty()){
            int[] b=q.poll();
            int square=b[0];
            int rolls=b[1];
            if(square==n*n) return rolls;
            for(int dice=1;dice<=6;dice++){
                int nextsquare=square+dice;
                if(nextsquare>n*n) break;
                if(moves[nextsquare]!=-1){
                    //if snake or ladder exists
                    nextsquare=moves[nextsquare];
                }
                if(!vis[nextsquare]){
                    vis[nextsquare]=true;
                    q.add(new int[]{nextsquare,rolls+1});

                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] a=new int[n][n];
        for(int i=0;i<n;i++){ 
            for(int j=0;j<n;j++){ 
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println(mindicerolls(a, n));
    }
}
// Sample Input-1:
// ---------------
// 6
// -1 -1 -1 -1 -1 -1
// -1 -1 -1 -1 -1 -1
// -1 -1 -1 -1 -1 -1
// -1 35 -1 -1 13 -1
// -1 -1 -1 -1 -1 -1
// -1 15 -1 -1 -1 -1

// Sample Output-1:
// ----------------
// 4

// Explanation: 
// ------------
// At the beginning, you start at square 1.
// Roll the dice to land at square 2, and must take the ladder to square 15.
// Roll the dice to land at square 17, and must take the snake to square 13.
// Roll the dice to land at square 14, and must take the ladder to square 35.
// Roll the dice to land at square 36, Shakuni Won.
// Total number of rolls are 4.
// import java.util.*;
// class Solution{
//     public static int map(int n,int i,int j){
//         if(i%2==1){
//             return ((n-i-1)*n+(j+1));
//         }
//         return (n-i-1)*n+(n-j);
//     }
//     public static int getcount(int[][] arr,int n){
       
//         Queue<int[]> q=new LinkedList<>();
       
//         boolean[] visited=new boolean[n*n+1];
//         q.add(new int[]{1,0});
//         visited[1]=true;
//         while(!q.isEmpty()){
//             int[] cur=q.poll();
//             int num=cur[0];
//             int count=cur[1];
//             if(num==n*n){
//                 return count;
//             }
//             for(int i=1;i<=6;i++){
//                 int last;
//                 int[] cords;
//                 if((num+i)<=n*n){
//                     cords=getpos(n,num+i);
//                 }
//                 else break;
//                 if(arr[cords[0]][cords[1]]==-1){
//                     last=num+i;
//                 }
//                 else{
//                     last=arr[cords[0]][cords[1]];
//                 }
//                 if(!visited[last]) 
//                 {
//                     visited[last]=true;
//                     q.add(new int[]{last,count+1});
//                 }
                
//             }
//         }
//         return -1;
//     } 
//     public static int[] getpos(int n,int pos){
//         int row=(pos-1)/n;
//         int col=(pos-1)%n;
//         if(row % 2!=0){
//             col=n-col-1;
//         }
//         row=n-1-row;
//         return new int[]{row,col};
//     }
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         int[][] arr=new int[n][n];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 arr[i][j]=sc.nextInt();
//             }
//         }
//         System.out.println(getcount(arr,n));
//     }
// }