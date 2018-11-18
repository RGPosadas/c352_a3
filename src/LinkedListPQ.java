public class LinkedListPQ<E> {
    private E root;
    private int size;
    private int height;

    private class Node<E> {
        private E job;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        public Node(Jobs j) {
            job = (E) j;
            size++;
        }
    }
}