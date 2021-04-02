package datastructures;

/**
 * TODO: need refactoring for object structure
 */
public class Queue {
    private int tail;
    private int head;
    private int[] queueArray;
    private int maxSize;
    private int nItems;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new int[maxSize];
        this.head = 0;
        this.tail = 0;
        this.nItems = 0;
    }

    public static void main(String[] args) {

    }

    public void enqueue(int x) {
        this.queueArray[this.tail] = x;
        this.nItems++;
        if (this.nItems == this.tail) {
            this.tail = 1;
        } else {
            this.head++;
        }
    }

    public int dequeue() {
        int x = this.queueArray[this.head];
        if (this.head == this.nItems) {
            this.head = 1;
        } else {
            this.head++;
        }
        return x;
    }
}
