package datastructures;

public class Stack {

    private int top;
    private final int[] stackArray;
    private final int maxSize;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    public static void main(String[] args) {
    }

    public boolean stackEmpty() {
        return this.top == -1;
    }

    public void push(int x) {
        this.top++;
        this.stackArray[top] = x;
    }

    public int pop() {
        if (stackEmpty()) {
            throw new Error("stack underflow");
        }
        this.top--;
        return this.stackArray[top + 1];
    }
}
