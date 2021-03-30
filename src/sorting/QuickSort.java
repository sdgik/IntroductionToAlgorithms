package sorting;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {3, 41, 52, 26, 38, 57, 9, 49};
        randomizedQuicksort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quicksort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quicksort(a, p, q - 1);
            quicksort(a, q + 1, r);
        }
    }

    public static void randomizedQuicksort(int[] a, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(a, p, r);
            randomizedQuicksort(a, p, q - 1);
            randomizedQuicksort(a, q + 1, r);
        }
    }

    private static int randomizedPartition(int[] a, int p, int r) {
        int i =  ThreadLocalRandom.current().nextInt(p, r + 1);
        swap(a, r, i);
        return hoarePartition(a, p, r);
    }

    private static int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j < r ; j++) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    private static int hoarePartition(int[] a, int p, int r) {
        int x = a[p];
        int i = p - 1;
        int j = r + 1;
        while(true) {
            do {
                j--;
            } while (a[j] > x);
            do {
                i++;
            } while (a[i] < x);
            if (i < j) {
                swap(a, i, j);
            } else {
                return j;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
