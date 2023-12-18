public class replaceNodeWithDepth {
    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
        changeToDepthTree(root, 0);
    }

    private static void changeToDepthTree(BinaryTreeNode<Integer> root, int depth) {
        if (root == null) return;
        root.data = depth;
        changeToDepthTree(root.left, depth + 1);
        changeToDepthTree(root.right, depth + 1);
    }
}