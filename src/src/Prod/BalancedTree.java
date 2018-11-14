package Prod;

public class BalancedTree {

    public class NodeTree {
        int key, height;
        public NodeTree left, right;

        NodeTree(int key) {
            this.key = key;
            height = 1; //default height
        }
    }
   public NodeTree root;


    public int height(NodeTree N) {
        if(N == null)
            return 0;
        return  N.height;
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    private NodeTree rightRotation(NodeTree rTree) {
        NodeTree lTree = rTree.left;
        NodeTree Tree2 = lTree.right;
        
        lTree.right = rTree;
        rTree.left = Tree2;

        //updating heights
        rTree.height = max(height(rTree.left), height(rTree.right)) + 1;
        lTree.height = max(height(lTree.left), height(lTree.right)) + 1;
        return lTree;
    }
    
    private NodeTree leftRotation(NodeTree lTree) {
        NodeTree rTree = lTree.right;
        NodeTree Tree2 = rTree.left;
        
        rTree.left = lTree;
        lTree.right = Tree2;
        
        lTree.height = max(height(lTree.left), height(lTree.right)) + 1;
        rTree.height = max(height(rTree.left), height(rTree.right)) + 1;
        
        return rTree;
    }

    public int getBalance(NodeTree N) {
        if(N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    public NodeTree insert(NodeTree node, int key) {

        if (node == null)
            return (new NodeTree(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else //cutting duplicate keys
            return node;

        //upd height
        node.height = 1 + max(height(node.left), height(node.right));

        // Get the balance factor of this ancestor
        // node to check whether this node became
        // unbalanced
        int balance = getBalance(node);

        //if balance != 1 then we're rotating the tree to get it balanced
        // L-L case
        if (balance > 1 && key < node.left.key)
            return rightRotation(node);

        // R-R case
        if (balance < -1 && key > node.right.key)
            return leftRotation(node);

        // L-R case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }

        // R-L case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }

        return node;    //if it was balanced from start
    }


   public void preOrderBypassing(NodeTree node) {      // standart pre-order bypass
        if (node != null) {
            System.out.print(node.key + " ");
            preOrderBypassing(node.left);
            preOrderBypassing(node.right);
        }
    }

    public static void main(String[] args) {
        BalancedTree tree = new BalancedTree();


        tree.root = tree.insert(tree.root, 10);


        System.out.println("Your tree is: ");
        tree.preOrderBypassing(tree.root);
    }
}
