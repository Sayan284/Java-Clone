/* Printing tree level-wise */

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeLevelWise {
    // Print Binary Tree Iteratively
    public static void printTreeLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> frontNode = queue.poll();
            System.out.print(frontNode.data + ":");
            if (frontNode.left != null) {
                System.out.print("L:" + frontNode.left.data + ",");
                queue.add(frontNode.left);
            } else {
                System.out.print("L:" + -1 + ",");
            }
            if (frontNode.right != null) {
                System.out.print("R:" + frontNode.right.data);
                queue.add(frontNode.right);
            } else {
                System.out.print("R:" + -1);
            }
            System.out.println();
        }
    }
}