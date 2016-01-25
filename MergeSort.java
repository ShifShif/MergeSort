package MergeSort;

import java.util.Arrays;

/**
 * @pre array elements are different from each other
 */
public class MergeSort {
	public static int[] mergesort(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		else {
			int[] A = Arrays.copyOfRange(array, 0, (int) Math.ceil(array.length/2));
			int[] B = Arrays.copyOfRange(array, (int) Math.ceil(array.length/2), array.length);
			
			return merge(mergesort(A), mergesort(B), array);
		}
	}
	
	private static int[] merge(int[] A, int[] B, int[] array) {
		int[] result = new int[array.length];
		int i = 0;
		int j = 0;
		int resultIndex = 0;
		while (i < A.length && j < B.length) {
			if (A[i] < B[j]) {
				result[resultIndex] = A[i];
				i++;
			}
			else {
				result[resultIndex] = B[j];
				j++;
			}
			resultIndex++;
		}
		//add whatever remains from the two halves
		if (i == A.length) { //all of the first half was already inserted to the result array
			for (int index = resultIndex; resultIndex < result.length; resultIndex++) {
				result[index] = B[j];
				j++;
			}
		}
		else {
			for (int index = resultIndex; resultIndex < result.length; resultIndex++) {
				result[index] = A[i];
				i++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] exampleArray = { 5, 1, 7, 2, 4, 8, 6, 3};
		System.out.print("This is the unsorted array:");
		System.out.println(Arrays.toString(exampleArray));
		
		int[] sorted = mergesort(exampleArray);
		System.out.print("This is the sorted array:");
		for (int l = 0; l < sorted.length; l++) {
			System.out.print(" " + sorted[l]);
		}
	}
}
