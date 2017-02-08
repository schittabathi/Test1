package com.openx.lego.tests.grid_publishing;

import java.util.Arrays;

public class JedisMain {

	public static void main(String[] args) {
		int array1[] = { 2, 3, 12, 42, 11, 111, 22, 332, -121, -222 };
		int array2[] = { 2, 3, 12, 42, 11, 111, 22, 332, -121, -222 };
		
		getOddNumbersMethod1(array1);
		
		getOddNumbersMethod2(array2);
		
		
		printPascalTriangle(7);
	}
	
	
// First approach to get the odd numbers
	public static int[] getOddNumbersMethod1(int[] numbers) {
		return Arrays.stream(numbers).filter(s -> Math.abs(s % 2) == 1).toArray();
	}

	// Second approach to get the odd numbers
	public static int[] getOddNumbersMethod2(int[] numbers, int... index) {
		if (numbers == null || numbers.length == 0)
			throw new RuntimeException("Empty input array");
		if (index == null || index.length == 0) {
			if (numbers[0] % 2 == 0)
				numbers[0] = 0;
		    getOddNumbersMethod2(numbers, 1);

		} else {
			if(index[0]==numbers.length )
				return numbers;
			if (numbers[index[0]] % 2 == 0)
				numbers[index[0]] = 0;
			getOddNumbersMethod2(numbers, index[0] + 1);
		}

		return numbers;

	}

	public static void printPascalTriangle(int numberOfRows) {
		int[] numbers = new int[2 * numberOfRows + 1];
		int[] numbersRow = new int[2 * numberOfRows + 1];
		numbers[numberOfRows] = 1;
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (i == 0) {
					System.out.print(numbers[j] == 0 ? " " : numbers[j]);
				} else {
					int temp = valueForIndex(j - 1, numbers) + valueForIndex(j + 1, numbers);
					System.out.print(temp == 0 ? " " : temp);
					numbersRow[j] = temp;
				}

			}
			System.out.println("\n");
			if (i > 0)
				numbers = numbersRow.clone();

		}

	}

	private static int valueForIndex(int i, int[] array) {
		if (i < 0 || i > array.length - 1)
			return 0;
		else
			return array[i];
	}

}
