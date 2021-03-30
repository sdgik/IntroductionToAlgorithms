package sorting;

import java.util.Arrays;

public class Heapsort {

    public static void main(String[] args) {
        System.out.println("\nMax Heapify test");
        int[] array = new int[]{16,4,10,14,7,9,3,2,8,1};
        System.out.println(Arrays.toString(array));
        maxHeapify(array, 1, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void maxHeapify(int[] a, int i, int heapMaxId) {
        int l = getLeftChild(i);
        int r = getRightChild(i);
        int largest = i;

        if (l <= heapMaxId && a[l] > a[i]) {
            largest = l;
        }

        if (r <= heapMaxId && a[r] >= a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapMaxId);
        }
    }

    private static void buildMaxHeap(int[] a) {
        int heapMaxId = a.length - 1;
        for (int i = heapMaxId / 2; i >= 0; i--) {
            maxHeapify(a, i, heapMaxId);
        }
    }

    private static void heapsort(int[] a) {
        int heapMaxIdx = a.length - 1;
        buildMaxHeap(a);
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i--);
            maxHeapify(a, 0, heapMaxIdx);
        }
    }

    private static int getParent(int i) {
        return i / 2 ;
    }

    private static int getLeftChild(int i) {
        return 2 * i;
    }

    private static int getRightChild(int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
