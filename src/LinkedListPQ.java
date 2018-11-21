import java.util.LinkedList;

public class LinkedListPQ {
    private Node root;
    private int size;
    private int height;

    private class Node {
        private Jobs job;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        public Node(Jobs j) {
            job = j;
            size++;
        }
    }

    public LinkedListPQ() {
        root = null;
        size = 0;
    }

    public void insert(Jobs j) {

    }
}