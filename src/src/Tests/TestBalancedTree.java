package Tests;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import Prod.*;
import java.util.Random;

public class TestBalancedTree {
    
    private static final int SEED = 1;
    private static final int SIZE = 1000;
    
    private BalancedTree generateBalancedTree() {
        BalancedTree balTree = new BalancedTree();
        Random rnd = new Random(SEED);
        for(int i = 0; i < SIZE; ++i) {
            int randEL = rnd.nextInt();
            balTree.root = balTree.insert(balTree.root, randEL);
        }
        return balTree;
    }
    
    @Test
    public void testHeight(){
        BalancedTree balTr = new BalancedTree();
        balTr = generateBalancedTree();

        assertTrue("AVL tree constructed not right, height of left subtree >= height of right subtree" ,
                balTr.height(balTr.root.left) - balTr.height(balTr.root.right) <= 1);
    }
}
