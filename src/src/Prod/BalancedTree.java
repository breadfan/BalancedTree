package Prod;

public class BalancedTree {


    private class Node{
        int a;
        private Node leftKid, rightKid;
        Node(){}
        private Node(Node leftKid, Node rightKid){ //constructor
            this.leftKid = leftKid;
            this.rightKid = rightKid;
           // a = rightKid.a + leftKid.a;
        }
    }

    public void buildTree(Node root, int[] arr, int count){
        if(count != arr.length - 2) {
            if (arr[count + 1] < arr[count] && root.leftKid != null) {
                root.leftKid.a = arr[count + 1];
                buildTree(root.leftKid, arr, count + 1);
            } else if (arr[count + 1] > arr[count] && root.rightKid != null) {
                root.rightKid.a = arr[count + 1];
                buildTree(root.rightKid, arr, count + 1);
            }
        }
    }
}
