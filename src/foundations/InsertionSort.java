package foundations;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {31,41,59,26,41,58};
		sort(arr,false);
		System.out.println(Arrays.toString(arr));

		int[] a = {1,1,0,1};
		int[] b = {1,1,1,0};
		System.out.println(Arrays.toString(binarySum(a,b)));
	}

	/**
	 * Exercise 2.1-1
	 *
	 * @param arr Input array
	 */
	private static void sort(int[] arr){
		for (int j = 1; j < arr.length; j++) {
			int key = arr[j];
			int i = j - 1;

			while (i >= 0 && arr[i] > key) {
				arr[i+1] = arr[i];
				i--;
			}
			arr[i+1] = key;
		}
	}

	/**
	 * Exercise 2.1-2
	 *
	 * @param arr Input array
	 * @param asc Sort order true if ascending, else otherwise.
	 */
	private static void sort(int[] arr, boolean asc) {
		for (int j = 1; j < arr.length; j++) {
			int key = arr[j];
			int i = j - 1;

			while(i >= 0 && (asc == (arr[i] <= key))) {
				arr[i+1] = arr[i];
				i--;
			}
			arr[i+1] = key;
		}
	}

	/**
	 * Exercise 2.1-4
	 *
	 * @param a binary from of A
	 * @param b binary form of B
	 * @return binary form of A and B sum.
	 */
	private static int[] binarySum(int[] a, int[] b) {
		int n = Math.max(a.length, b.length);
		int[] c = new int[n + 1];
		int carry = 0;

		for (int i = 0; i < n; i++) {

			c[i] = (a[i] + b[i] + carry) % 2;
			carry = (a[i] + b[i] + carry) / 2;
		}

		c[n] = carry;
		return c;
	}
}
