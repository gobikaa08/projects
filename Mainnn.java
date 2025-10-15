//name:Gobikaa.E
//Reg no:2117240020106
package mynewproject;

import java.util.*;

//1. Define a generic TreeNode<T> class
class TreeNode<T extends Comparable<T>> {
 T data;
 TreeNode<T> left, right;

 TreeNode(T data) {
     this.data = data;
     left = right = null;
 }
}

//2. Generic BinaryTree class with insert and traversal methods
class BinaryTree<T extends Comparable<T>> {
 private TreeNode<T> root;

 // Insert method
 public void insert(T value) {
     root = insertRec(root, value);
 }

 private TreeNode<T> insertRec(TreeNode<T> node, T value) {
     if (node == null) return new TreeNode<>(value);
     if (value.compareTo(node.data) < 0)
         node.left = insertRec(node.left, value);
     else
         node.right = insertRec(node.right, value);
     return node;
 }

 // 3. DFS Traversals
 public void inOrder() {
     inOrderRec(root);
     System.out.println();
 }

 private void inOrderRec(TreeNode<T> node) {
     if (node != null) {
         inOrderRec(node.left);
         System.out.print(node.data + " ");
         inOrderRec(node.right);
     }
 }

 public void preOrder() {
     preOrderRec(root);
     System.out.println();
 }

 private void preOrderRec(TreeNode<T> node) {
     if (node != null) {
         System.out.print(node.data + " ");
         preOrderRec(node.left);
         preOrderRec(node.right);
     }
 }

 public void postOrder() {
     postOrderRec(root);
     System.out.println();
 }

 private void postOrderRec(TreeNode<T> node) {
     if (node != null) {
         postOrderRec(node.left);
         postOrderRec(node.right);
         System.out.print(node.data + " ");
     }
 }

 // 4. BFS Traversal
 public void levelOrder() {
     if (root == null) return;
     Queue<TreeNode<T>> queue = new LinkedList<>();
     queue.add(root);
     while (!queue.isEmpty()) {
         TreeNode<T> current = queue.poll();
         System.out.print(current.data + " ");
         if (current.left != null) queue.add(current.left);
         if (current.right != null) queue.add(current.right);
     }
     System.out.println();
 }
}

public class Mainnn {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        // TC1: Insert 10, 5, 20
        tree.insert(10);
        tree.insert(5);
        tree.insert(20);
        // TC2: Level order → Output: 10 5 20
        System.out.print("Level Order: ");
        tree.levelOrder();

        // TC3: In-order → Output: 5 10 20
        System.out.print("In-Order: ");
        tree.inOrder();

        // TC4: Pre-order → Output: 10 5 20
        System.out.print("Pre-Order: ");
        tree.preOrder();

        // TC5: Post-order → Output: 5 20 10
        System.out.print("Post-Order: ");
        tree.postOrder();
        
        
        
        System.out.println();
        System.out.println("Name: Gobikaa.E");
        System.out.println("reg no:2117240020106");
       
        
    }
}





