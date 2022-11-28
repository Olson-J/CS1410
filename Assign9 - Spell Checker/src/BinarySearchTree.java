import java.util.Objects;

/**
 * create and manage a binary sort tree
 * @author JulieOlson a02363064
 * @since march 28 2022
 */
 public class BinarySearchTree<E extends Comparable<E>> {
    private TreeNode root;

    /**
     * print a banner followed by data stored in the tree
     */
    public void display(String message) {
        System.out.println(message);
        this.displayInOrder(root);
    }

    /**
     * helper method to display
     */
    private void displayInOrder(TreeNode node) {
        if (node == null) return;
        displayInOrder(node.left);
        System.out.println(node.value);
        displayInOrder(node.right);
    }

    /**
     * searches the binary tree for a given value, returns true if
     * found and false if not
     */
    public boolean search(E value) {
        TreeNode node = root;
        boolean found = false;
        while (!found && node != null) {
            if (Objects.equals(node.value, value)) {
                found = true;
            } else if (node.value.compareTo(value) < 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return found;
    }

    /**
     * add a node and value to the correct place in the tree
     */
    public boolean insert(E value) {
        TreeNode parent = null;
        if (root == null) {
            root = new TreeNode(value);
        } else {
            // Search/find the insert location
            TreeNode node = root;
            while (node != null) {
                parent = node;
                // no repeats
                if (value == node.value) {return false;}
                else if (value.compareTo(node.value) > 0) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
            // Add the node to the tree
            TreeNode newNode = new TreeNode(value);
            if (parent.value.compareTo(value) < 0) {
                parent.right = newNode;

            } else {
                parent.left = newNode;
            }
        }
        return true;
    }

    /**
     * Remove a node and value from the tree
     */
    public boolean remove(E value) {
        // Step 1: find the node to remove
        TreeNode parent = null;
        TreeNode node = root;
        boolean done = false;
        while (!done) {
            if (node.value.compareTo(value) > 0) {
                parent = node;
                node = node.left;
            }
            else if (node.value.compareTo(value) < 0) {
                parent = node;
                node = node.right;
            }
            else {
                done = true;
            }
            if (node == null) {
                return false;
            }
        }
        // Step 2a: case for no left child
        if (node.left == null) {
            if (parent == null) {
                root = node.right;
            }
            else {

                if (parent.value.compareTo(value) > 0) {
                    parent.left = node.right;
                }
                else {
                    parent.right = node.right;
                }
            }
        }
        else { // Step 2b: case for left child
            TreeNode parentOfRight = node;
            TreeNode rightMost = node.left;
            while (rightMost.right != null) {
                parentOfRight = rightMost;
                rightMost = rightMost.right;
            }
            // Copy the largest value into the node being removed
            node.value = rightMost.value;
            if (parentOfRight.right == rightMost) {
                parentOfRight.right = rightMost.left;
            }
            else {
                parentOfRight.left = rightMost.left;
            }
        }
        return true;
    }

    /**
     * count and return the total number of nodes in the tree
     */
    public int numberNodes(){
        return numberHelper(root);
    }
    /**
     * recursive helper method to numberNodes
     */
    public int numberHelper(TreeNode node){
        int count = 0;
        if (node == null) {return 0;}
        else {
            count += 1;
            count += numberHelper(node.left);
            count += numberHelper(node.right);
        }
        return count;
    }

    /**
     * count and return the total number of leaves in the tree
     */
    public int numberLeafNodes(){
        return leafHelper(root);
    }
    /**
     * recursive helper method to numberLeafNodes
     */
    public int leafHelper(TreeNode node){
        int count = 0;
        if (node == null) {return 0;}
        else {
            if (node.left == null && node.right == null) {
                count += 1;
            }
            else {
                count += leafHelper(node.left);
                count += leafHelper(node.right);
            }
        }
        return count;
    }

    /**
     * count and return the total number of 'levels' in the tree
     */
    public int height(){
        return heightHelper(root, -1);
    }
    /**
     * recursive helper method to height
     */
    public int heightHelper(TreeNode node, int level){
        int leftLevel;
        int rightLevel;
        if (node == null) {return level;}
        else {
            leftLevel = heightHelper(node.left, level + 1);
            rightLevel = heightHelper(node.right, level + 1);
        }
        return Math.max(leftLevel, rightLevel);
    }

    /**
     * create a node
     */
     private class TreeNode {
        public E value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(E value) {
            this.value = value;
        }
    }
}