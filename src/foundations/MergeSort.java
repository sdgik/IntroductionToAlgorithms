package foundations;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {3, 41, 52, 26, 38, 57, 9, 49};
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) >> 1;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    private static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = a[p + i - 1];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = a[q + j];
        }
        L[n1 + 1] = Integer.MAX_VALUE;
        R[n2 + 1] = Integer.MAX_VALUE;

        int i = 1;
        int j = 1;
        for (int k = p; k < r; k++) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
        }
    }
}
