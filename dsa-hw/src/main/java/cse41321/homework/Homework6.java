package cse41321.homework;

import cse41321.algorithms.TreeAlgorithms;
import cse41321.containers.BinaryTree;
import cse41321.containers.SinglyLinkedList;
import cse41321.interfaces.Visitor;

public class Homework6 {

    // This is the implementation of the Visitor interface used for storing data from BSTs
    private static class TraversalVisitor implements Visitor<Integer> {
        private SinglyLinkedList<Integer> visitedData = new SinglyLinkedList<Integer>();
        // Adds BST node to a list so we can refrence the nodes in the specific order later
        public void visit(Integer data) {
            visitedData.insertTail(data);
        }
        // Prints the linked list of nodes in the order which the nodes were put into it
        public void printTraversal() {
            SinglyLinkedList<Integer>.Element element = visitedData.getHead();
            while(element != null) {
                if(element.getNext() != null) System.out.print("(" + element.getData() + ") ----> ");
                else System.out.print("(" + element.getData() + ")");
                element = element.getNext();
            }
            System.out.print("\n");
        }
    }

    // Visitor used for traversing BSTs
    private static TraversalVisitor traversalVisitor;
    // Method which creates tree one from the homework worksheet
    public static BinaryTree<Integer> createTreeOne() {
        BinaryTree<Integer> treeOne = new BinaryTree<>();
        treeOne.insertRoot(1);
        treeOne.getRoot().insertLeft(2);
        treeOne.getRoot().insertRight(3);
        treeOne.getRoot().getLeft().insertLeft(4);
        treeOne.getRoot().getRight().insertLeft(5);
        treeOne.getRoot().getRight().insertRight(6);
        treeOne.getRoot().getLeft().getLeft().insertRight(7);
        treeOne.getRoot().getRight().getRight().insertRight(8);
        treeOne.getRoot().getRight().getRight().getRight().insertRight(9);
        return treeOne;
    }
    // Method which creates tree two from the homework worksheet
    public static BinaryTree<Integer> createTreeTwo() {
        BinaryTree<Integer> treeTwo = new BinaryTree<>();
        treeTwo.insertRoot(6);
        treeTwo.getRoot().insertLeft(4);
        treeTwo.getRoot().insertRight(8);
        treeTwo.getRoot().getLeft().insertLeft(2);
        treeTwo.getRoot().getLeft().insertRight(5);
        treeTwo.getRoot().getRight().insertLeft(7);
        treeTwo.getRoot().getRight().insertRight(9);
        treeTwo.getRoot().getLeft().getLeft().insertLeft(1);
        treeTwo.getRoot().getLeft().getLeft().insertRight(3);
        return treeTwo;
    }

    // Calls the count leaves helper which counts the leaves of the input BST recursively
    public static int countLeaves(BinaryTree tree) {
        return countLeavesHelper(tree.getRoot());
    }
    private static int countLeavesHelper(BinaryTree<Integer>.Node node) {
        // If current node doesn't exist, return 0 and stop recursion
        if(node == null) return 0;
        // If the current node is a leaf, we return a 1 so that we can add that to the total num of leaves
        if(node.isLeaf()) return 1;
        // If node exists and has children, we recurse to find the number of leaves in the next subtree
        return countLeavesHelper(node.getLeft()) + countLeavesHelper(node.getRight());
    }

    // Calls the count non-leaves helper which counts the non-leaves of the input BST recursively
    public static int countNonLeaves(BinaryTree tree) {
        return countNonLeavesHelper(tree.getRoot());
    }
    private static int countNonLeavesHelper(BinaryTree<Integer>.Node node) {
        // If current node doesn't exist, return 0 and stop recursion
        if(node == null) return 0;
        // If the current node is not a leaf, return 1 to add to the total of non leaves and recurse through subtrees
        if(!node.isLeaf()) return 1 + countNonLeavesHelper(node.getLeft()) + countNonLeavesHelper(node.getRight());
        // If node is a leaf we do not add to our total of non-leaves
        return 0;
    }

    // Calls the get height helper which returns the height of the BST
    public static int getHeight(BinaryTree tree) {
        // If tree doesn't have any elements, the height of the tree is 0
        if (tree.getRoot() == null) return 0;
        // Calls the method which gets the height of the tree recursively and adds one to it because the method does not include the root
        return 1 + getHeightHelper(tree.getRoot());
    }
    private static int getHeightHelper(BinaryTree<Integer>.Node node) {
        // If the node does not exist we return 0 and stop recursion
        if(node == null) return 0;
        // If node has a left or right child
        if(node.hasLeft() || node.hasRight()) {
            // Adds one to the height and calls this same method recursively so we can get the height of this node's subtrees
            return 1 + Math.max(getHeightHelper(node.getLeft()), getHeightHelper(node.getRight()));
        }
        // If node is a leaf we return 0 and stop recursion
        return 0;
    }

    // Prints BST in pre-order traversal form
    public static void printPreOrder(BinaryTree tree) {
        // Initializes traversal visitor
        traversalVisitor = new TraversalVisitor();
        // Uses the provided pre-order traversal and passes the traversal visitor to it
        TreeAlgorithms.traversePreOrder(tree, traversalVisitor);
        // Prints the nodes in the respective order
        System.out.println("PRE-ORDER TRAVERSAL:");
        traversalVisitor.printTraversal();
    }

    // Prints BST in in-order traversal form
    public static void printInOrder(BinaryTree tree) {
        // Initializes traversal visitor
        traversalVisitor = new TraversalVisitor();
        // Uses the provided pre-order traversal and passes the traversal visitor to it
        TreeAlgorithms.traverseInOrder(tree, traversalVisitor);
        // Prints the nodes in the respective order
        System.out.println("IN-ORDER TRAVERSAL:");
        traversalVisitor.printTraversal();
    }

    // Prints BST in post-order traversal form
    public static void printPostOrder (BinaryTree tree) {
        // Initializes traversal visitor
        traversalVisitor = new TraversalVisitor();
        // Uses the provided pre-order traversal and passes the traversal visitor to it
        TreeAlgorithms.traversePostOrder(tree, traversalVisitor);
        // Prints the nodes in the respective order
        System.out.println("POST-ORDER TRAVERSAL:");
        traversalVisitor.printTraversal();
    }

    // Removes all leaf nodes from BST
    public static void removeLeaves(BinaryTree tree) {
        // Initializes traversal visitor
        traversalVisitor = new TraversalVisitor();
        // Calls the recursive method which removes leaf nodes from the BST
        doRemoveLeaves(tree.getRoot(), traversalVisitor);
    }

    // Modified pre-order traversal which checks if a node is a leaf and if so removes it
    private static void doRemoveLeaves(BinaryTree<Integer>.Node node, TraversalVisitor visitor) {
        // If node does not exist we stop recursion
        if (node == null) {
            return;
        }
        // If node has a left child node
        if(node.hasLeft()) {
            // If the left child is a leaf, we remove it
            if(!(node.getLeft().hasLeft()) && !(node.getLeft().hasRight()) ) node.removeLeft();
        }
        // If node has a right child node
        if(node.hasRight()) {
            // If the right child is a leaf, we remove it
            if(!(node.getRight().hasLeft()) && !(node.getRight().hasRight()) ) node.removeRight();
        }
        // Recurse for both left and right subtrees
        doRemoveLeaves(node.getLeft(), visitor);
        doRemoveLeaves(node.getRight(), visitor);
    }

    public static void main(String[] args) {
        // Create both trees for testing
        BinaryTree<Integer> treeOne = createTreeOne();
        BinaryTree<Integer> treeTwo = createTreeTwo();

        System.out.println("Number of leaves for tree one: " + countLeaves(treeOne));
        System.out.println("Number of leaves for tree two: " + countLeaves(treeTwo));

        System.out.print("\n");

        System.out.println("Number of non-leaves for tree one: " + countNonLeaves(treeOne));
        System.out.println("Number of non-leaves for tree two: " + countNonLeaves(treeTwo));

        System.out.print("\n");

        System.out.println("Height of tree one: " + getHeight(treeOne));
        System.out.println("Height of tree two: " + getHeight(treeTwo));

        System.out.print("\n");

        System.out.println("Tree one:");
        printPreOrder(treeOne);
        System.out.println("Tree two:");
        printPreOrder(treeTwo);

        System.out.print("\n");

        System.out.println("Tree one:");
        printInOrder(treeOne);
        System.out.println("Tree two:");
        printInOrder(treeTwo);

        System.out.print("\n");

        System.out.println("Tree one:");
        printPostOrder(treeOne);
        System.out.println("Tree two:");
        printPostOrder(treeTwo);

        System.out.print("\n");

        System.out.println("Remove leaves for tree one:");
        printPreOrder(treeOne);
        removeLeaves(treeOne);
        printPreOrder(treeOne);
        System.out.println("Remove leaves for tree two:");
        printPreOrder(treeTwo);
        removeLeaves(treeTwo);
        printPreOrder(treeTwo);

    }
}