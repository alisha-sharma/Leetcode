package binary_tree;

public class CreateTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);

        System.out.println("Print data from left node: " + tree.root.left.data);
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTree{
    Node root;

    public BinaryTree(){
        this.root = null;
    }

    public BinaryTree(Node root){
        this.root = root;
    }
}
