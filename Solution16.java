import java.io.*;
import java.util.*;

class Node {
      int data;
      Node left, right;
       
      Node(int key) 
      {
           data  = key;
           left = right = null;
      }
}
class GFG {
      static int evenOddLevelDifference(Node root)
      {
             if (root == null)
                 return 0;
             Queue<Node> q = new LinkedList<>();
             q.add(root);

             int level = 0; 
             int evenSum = 0, oddSum = 0;
             while (q.size() != 0) {
                   int size = q.size();
                   level++;
                   while (size > 0) {
                          Node temp = q.remove();
                          if (level % 2 == 0)
                              evenSum += temp.data;
                          else
                              oddSum += temp.data;

                          if (temp.left != null)
                              q.add(temp.left);
                        
                          if (temp.right != null)
                              q.add(temp.right);
                          size--;
                   }
             }
             return (oddSum - evenSum);  
      }
    public static void main(String args[])
      {
             Node root = new Node(5);
             root.left = new Node(2);
             root.right = new Node(6);
             root.left.left = new Node(1);
             root.left.right = new Node(4);
             root.left.right.left = new Node(3);
             root.right.right = new Node(8);
             root.right.right.right = new Node(9);
             root.right.right.left = new Node(7);

             System.out.println("difference between sums is " + evenOddLevelDifference(root));
      }
}
