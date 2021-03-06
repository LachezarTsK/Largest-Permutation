import java.util.Scanner;

public class Solution {
	private static int[] inputArray;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lengthOfArray = scanner.nextInt();
		int maximumSwaps = scanner.nextInt();
		inputArray = new int[lengthOfArray];
		/**
		 * Array "valueToIndex" maps the values to their corresponding indexes. Since
		 * values start from 1, the array length is extended with 1.
		 * 
		 * Thus, it can be written directly "valueToIndex[value]=index".
		 */
		int[] valueToIndex = new int[lengthOfArray + 1];

		for (int i = 0; i < lengthOfArray; i++) {
			inputArray[i] = scanner.nextInt();
			valueToIndex[inputArray[i]] = i;
		}
		scanner.close();

		calculateLargestPermutation(valueToIndex, maximumSwaps);
		printLargestPermutation();
	}

	/**
	 * The method calculates the largest lexicographical value array that can be
	 * made from the original input array, with a given number of maximum swaps, and
	 * modifies the original input array accordingly.
	 */
	public static void calculateLargestPermutation(int[] valueToIndex, int maximumSwaps) {
		int largestValue = inputArray.length;
		int index = 0;

		while (maximumSwaps > 0 && index < inputArray.length) {
			if (inputArray[index] != largestValue) {
				int temp = inputArray[index];
				inputArray[index] = largestValue;
				inputArray[valueToIndex[largestValue]] = temp;

				/**
				 * Map the low value to the index of the currently swapped large value so that
				 * the lexicographical order in the modified array is preserved.
				 */
				valueToIndex[temp] = valueToIndex[largestValue];
				maximumSwaps--;
			}
			index++;
			largestValue--;
		}
	}

	/**
	 * Print the largest lexicographical value array on one line.
	 */
	private static void printLargestPermutation() {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i] + " ");
		}
	}
}
