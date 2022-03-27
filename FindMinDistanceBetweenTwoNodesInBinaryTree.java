package problemsolving.binarytrees;

import problemsolving.binarytrees.models.TreeNode;

public class FindDistanceBetweenTwoNodesInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = CreateTreeFromArray.createTree(new int[]{1, 2, 3, 4, 5, 6, 7});

        int dist = findDist(root, 2, 3);

        System.out.println(dist);

    }

    static int findDist(TreeNode root, int a, int b) {

        TreeNode lca = findLCA(root, a, b);

        int distanceA = findDistance(lca, a);
        int distanceB = findDistance(lca, b);

        if (lca.getVal() == a) {
            return distanceB;
        }

        if (lca.getVal() == b) {
            return distanceA;
        }

        return distanceA + distanceB;
    }

    private static int findDistance(TreeNode lca, int b) {

        return findLevel(lca, b, 0);

    }

    private static int findLevel(TreeNode lca, int b, int level) {
        if (lca == null) {
            return 0;
        }

        if (lca.getVal() == b) {
            return level;
        }

        level = level + 1;

        int leftLevel = findLevel(lca.getLeft(), b, level);
        int rightLevel = findLevel(lca.getRight(), b, level);

        if (leftLevel != 0) {
            return leftLevel;
        } else {
            return rightLevel;
        }

    }

    private static TreeNode findLCA(TreeNode root, int a, int b) {

        if (root == null) {
            return null;
        }

        if (root.getVal() == a || root.getVal() == b) {
            return root;
        }

        TreeNode left = findLCA(root.getLeft(), a, b);
        TreeNode right = findLCA(root.getRight(), a, b);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }

    }
}
