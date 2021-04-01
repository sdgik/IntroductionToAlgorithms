package datastructures;

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
    }
}
