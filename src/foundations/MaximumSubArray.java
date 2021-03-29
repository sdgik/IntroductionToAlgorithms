package foundations;


import java.util.Arrays;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{13,-3,-25,20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println(Arrays.toString(findMaximumSubArray(arr, 0, arr.length - 1)));
    }

    private static int[] findMaxCrossingSubArray(int[] A, int l, int m, int h) {
        int leftSum = Integer.MIN_VALUE;
        int maxLeft = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = m; i >= l; i--) {
            sum += A[i];
            if ( sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        int maxRight = Integer.MAX_VALUE;

        sum = 0;
        for (int i = m + 1; i <= h; i++) {
            sum += A[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        return new int[]{maxLeft, maxRight, leftSum + rightSum};
    }

    private static int[] findMaximumSubArray(int[] A, int l, int h) {
        if (h == l) {
            return new int[]{l, h, A[l]};
        } else {
            int mid = (l + h) / 2;
            int[] L = findMaximumSubArray(A, l, mid);
            int[] R = findMaximumSubArray(A, mid + 1, h);
            int[] C = findMaxCrossingSubArray(A, l, mid, h);
            if (L[2] >= R[2] && L[2] > C[2]) {
                return L;
            } else if (R[2] >= L[2] && R[2] >= C[2]) {
                return R;
            } else {
                return C;
            }
        }
    }
}
