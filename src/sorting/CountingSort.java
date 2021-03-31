package sorting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] a = {2, 5, 3, 0, 2, 3, 0 , 3};
        int[] r = countingSort(a, 5);
        System.out.println(Arrays.toString(r));
    }

    public static int[] countingSort(int[] a, int k) {
        int[] b = new int[a.length];
        if (k < 1 || a.length < 1) {
            return new int[0];
        }
        int[] c = new int[k + 1];

        for (int j : a) {
            c[j]++;
        }
        for (int i = 1; i <= k; i++) {
            c[i] += c[ i - 1 ];
        }
        for (int i = a.length - 1; i >= 0; i--) {
            b[c[a[i]] - 1] = a[i];
            c[a[i]]--;
        }

        return b;
    }
}
