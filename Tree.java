//  Name: Josue Gonzalez-Silva
//  Date: 8/8/24
//  Class CS 145
//  Assignment: Printing Trees
//  Purpose: Code defines a generic binary tree class

public class Tree<T extends Comparable<T>> {
    private TreeNode root;

    public Tree() {
        root = null;
    }

    public void insertNode(T insertValue) {
        if (root == null) {
            root = new TreeNode(insertValue);
        } else {
            root.insert(insertValue);
        }
    }

    public void preorderTraversal() {
        preorderHelper(root);
    }

    private void preorderHelper(TreeNode node) {
        if (node == null) return;
        System.out.printf("%s ", node.data);
        preorderHelper(node.leftNode);
        preorderHelper(node.rightNode);
    }

    public void inorderTraversal() {
        inorderHelper(root);
    }

    private void inorderHelper(TreeNode node) {
        if (node == null) return;
        inorderHelper(node.leftNode);
        System.out.printf("%s ", node.data);
        inorderHelper(node.rightNode);
    }

    public void postorderTraversal() {
        postorderHelper(root);
    }

    private void postorderHelper(TreeNode node) {
        if (node == null) return;
        postorderHelper(node.leftNode);
        postorderHelper(node.rightNode);
        System.out.printf("%s ", node.data);
    }

    public void outputTree() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        int height = getHeight(root);
        for (int i = 0; i < height; i++) {
            printLevel(root, i, height);
            System.out.println();
        }
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = getHeight(node.leftNode);
        int rightHeight = getHeight(node.rightNode);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private void printLevel(TreeNode node, int level, int height) {
        if (node == null) {
            printSpaces(height - level - 1);
            System.out.print(" ");
            return;
        }
        if (level == 0) {
            printSpaces(height - level - 1);
            System.out.print(node.data);
        } else {
            printLevel(node.leftNode, level - 1, height);
            printLevel(node.rightNode, level - 1, height);
        }
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private class TreeNode {
        TreeNode leftNode;
        T data;
        TreeNode rightNode;

        public TreeNode(T nodeData) {
            data = nodeData;
            leftNode = rightNode = null;
        }

        public void insert(T insertValue) {
            if (insertValue.compareTo(data) < 0) {
                if (leftNode == null) {
                    leftNode = new TreeNode(insertValue);
                } else {
                    leftNode.insert(insertValue);
                }
            } else if (insertValue.compareTo(data) > 0) {
                if (rightNode == null) {
                    rightNode = new TreeNode(insertValue);
                } else {
                    rightNode.insert(insertValue);
                }
            }
        }
    }
}
