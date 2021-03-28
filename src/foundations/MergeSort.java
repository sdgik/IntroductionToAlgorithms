package foundations;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {3, 41, 52, 26, 38, 57, 9, 49};
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) >> 1;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    private static void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = a[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = a[m + j + 1];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i++];
            } else {
                a[k] = R[j++];
            }
            k++;
        }

        while (i < n1) {
            a[k] = L[i++];
            k++;
        }
        while (j < n2) {
            a[k] = R[j++];
            k++;
        }
    }
}
