package datastructures;

/**
 * TODO: need refactoring for object structure
 */
public class LinkedList {
    private int key;
    private LinkedList prev;
    private LinkedList next;
    private LinkedList head;

    public LinkedList(int key) {
        this.key = key;
        this.head = this;
    }

    public LinkedList listSearch(int k) {
        LinkedList x = this.head;
        while (x != null && x.key != k) {
            x = x.next;
        }

        return x;
    }

    public void listInsert(int x) {
    }
}
