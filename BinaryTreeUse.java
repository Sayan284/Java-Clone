import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {
    // Printing Binary Tree Recursively
    public static void printTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        String toBePrinted = root.data + "";
        if (root.left != null) {
            toBePrinted += "L:" + root.left.data + ",";
        }
        if (root.right != null) {
            toBePrinted += "R:" + root.right.data;
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }

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

    // Taking input of Binary Tree Recursively
    public static BinaryTreeNode<Integer> takeInput(Scanner s) {
        int rootData;
        System.out.println("Enter root data: ");
        rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        root.left = takeInput(s);
        root.right = takeInput(s);
        return root;
    }

    // Taking Binary Input Iteratively
    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner s = new Scanner(System.in);
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        System.out.println("Enter root data: ");
        int rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> front;
            try {
                front = pendingNodes.dequeue();
            } catch (QueueEmptyException2 e) {
                return null;
            }
            System.out.println("Enter left child of " + front.data);
            int leftChild = s.nextInt();
            if (leftChild != -1) {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
                pendingNodes.enqueue(child);
                front.left = child;
            }
            System.out.println("Enter right child of " + front.data);
            int rightChild = s.nextInt();
            if (rightChild != -1) {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
                pendingNodes.enqueue(child);
                front.right = child;
            }
        }
        return root;
    }

    // Counting Binary Tree Nodes
    public static int countNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int ans = 1;
        ans += countNodes(root.left);
        ans += countNodes(root.right);
        return ans;
    }

    // sum of the nodes
    public static int getSum(BinaryTreeNode<Integer> root) {
        // base case
        if (root == null) {
            return 0;
        }
        int sum = 0;
        int smallAns = getSum(root.left) + getSum(root.right);
        return root.data + smallAns;
    }

    // finding a node in a binary tree
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        } else {
            return (isNodePresent(root.left, x) || isNodePresent(root.right, x));
        }
    }

    // Node with the largest data
    public static int largestNodeData(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }
        int largestLeft = largestNodeData(root.left);
        int largestRight = largestNodeData(root.right);
        return Math.max(root.data, Math.max(largestLeft, largestRight));
    }

    // counting the nodes greater than X in a binary tree
    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return 0;
        }
        int smallOutput = countNodesGreaterThanX(root.left, x) + countNodesGreaterThanX(root.right, x);
        if (root.data > x) {
            return smallOutput + 1;
        } else {
            return smallOutput;
        }
    }

    // height of a binary tree
    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }

    // number of leaves in a binary tree
    public static int numberOfLeaves(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return numberOfLeaves(root.left) + numberOfLeaves(root.right);
    }

    public static void main(String[] args) {
        //Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printTreeLevelWise(root);
        System.out.println("Sum of the root is: " + getSum(root));
        System.out.println("Largest is: " + largestNodeData(root));
        System.out.println("Number of leaves: " + numberOfLeaves(root));
        //s.close();
        /* BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
        root.left = node1;
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
        root.right = node2; */
    }
}