import java.util.List;

// A balanced binary search tree if all values added are sorted lexicographically with no duplicates
// A balanced binary tree if duplicate values are added because duplicates can be added to the right of its root
public class BinarySearchTree {
    private static class Node {
        // Attributes of Node class
        String data;
        Node left;
        Node right;

        // constructs a leaf node with given data
        public Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Attribute of BinarySearchTree class
    Node overallRoot;
    // Constructor, for clarity to show that at the start we create an empty tree in the client program
    public BinarySearchTree() {
        overallRoot = null;
    }

    // adds data to the tree, and the tree will be balanced if a sorted list is given to the method
    public void add(List<String> arr) {
        overallRoot = add(arr, 0, arr.size()-1);
    }
    private Node add(List<String> arr, int start, int end) {
        Node root; //= null;
        if (start > end) return null;

        int mid = (start + end) / 2;

        root = new Node(arr.get(mid));
        root.left = add(arr, start, mid-1);
        root.right = add(arr, mid+1, end);

        return root;
    }

    // checks whether a given value is in the dataset or not, returns true if it is else false
    public boolean contains(String value) {
        return contains(overallRoot, value);
    }
    private boolean contains(Node root, String value) {
        if (root == null) {
            return false;
        } else if (value.compareTo(root.data) == 0) {
            return true;
        } else if (value.compareTo(root.data) < 0) {
            return contains(root.left, value);
        } else { // value.compareTo(root.data) > 0
            return contains(root.right, value);
        }
    }

    // DEPTH FIRST: preorder
    public void printPreorder() {
        System.out.println("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }
    private void printPreorder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }
    // DEPTH FIRST: inorder
    public void printInorder() {
        System.out.println("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }
    private void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println("" + root.data);
            printInorder(root.right);
        }
    }
    // DEPTH FIRST: postorder
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }
    private void printPostorder(Node root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }
    // print tree structure sideways
    public void printSideways() {
        printSideways(overallRoot, 0);
    }
    private void printSideways(Node root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }

}