// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    int[] constructLowerArray(int[] arr, int n) {
        // code here
        int res[]=new int[n];
        Node root=null;
        for(int i=n-1;i>-1;i--){
            root=Utils.insert(root,arr[i]);
            res[i]=Utils.findSmaller(root,arr[i]);
        }
        return res;
    }
    static class Node{
        int val,tL,tR,height,cnt;
        Node left,right;
        public Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
            this.height=1;
            this.cnt=1;
        }
    }
    static class Utils{
        static int getHeight(Node node){
            if(node==null){
                return 0;
            }
            return node.height;
        }
        static int getBalanceFactor(Node node){
            if(node==null){
                return 0;
            }
            return getHeight(node.left)-getHeight(node.right);
        }
        static int getChild(Node node){
            if(node==null){
                return 0;
            }
            return node.tR+node.tL+node.cnt;
        }
        static Node updateChild(Node node){
            node.tL=getChild(node.left);
            node.tR=getChild(node.right);
            return node;
        }
        static Node leftRotate(Node x){
            Node y=x.right;
            Node t2=y.left;
            y.left=x;
            x.right=t2;
            x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;
            y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
            updateChild(x);
            updateChild(y);
            return y;
        }
        static Node rightRotate(Node x){
            Node y=x.left;
            Node t2=y.right;
            y.right=x;
            x.left=t2;
            x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;
            y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
            updateChild(x);
            updateChild(y);
            return y;
        }
        static Node insert(Node node,int val){
            if(node==null){
                return new Node(val);
            }
            else if(node.val==val){
                node.cnt++;
                return node;
            }
            else if(node.val>val){
                node.left=insert(node.left,val);
            }
            else{
                node.right=insert(node.right,val);
            }
            node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
            int bf=getBalanceFactor(node);
            if(bf>1){
                if(getBalanceFactor(node.left)<0){
                    node.left=leftRotate(node.left);
                }
                return rightRotate(node);
            }
            if(bf<-1){
                if(getBalanceFactor(node.right)>0){
                    node.right=rightRotate(node.right);
                }
                return leftRotate(node);
            }
            updateChild(node);
            return node;
        }
        static int findSmaller(Node node,int val){
            if(node.val==val){
                return node.tL;
            }
            else if(node.val<val){
                return node.cnt+node.tL+findSmaller(node.right,val);
            }
            else{
                return findSmaller(node.left,val);
            }
        }
        static boolean find(Node node,int val){
            if(node==null){
                return false;
            }
            else if(node.val==val){
                return true;
            }
            else if(node.val<val){
                return find(node.right,val);
            }
            else{
                return find(node.left,val);
            }
        }
    }
}
