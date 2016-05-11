package codejam.s2015.round1a.mushroom_monster;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		 processFile(args[0], args[1]);
//		processTest(new int[] { 10, 5, 15, 5 });
//		processTest(new int[] { 100, 100 }); 
//		//81 81 81 81 81 81 81 0
//		processTest(new int[] { 81, 81, 81, 81, 81, 81, 81, 0 }); 
//		//23 90 40 0 100 9
//		processTest(new int[] { 23, 90, 40, 0, 100, 9 }); 

	}

	public static void processFile(String inputFileName, String outputFileName) throws FileNotFoundException {

		try (Scanner scanner = new Scanner(new FileInputStream(inputFileName));
				PrintWriter pw = new PrintWriter(outputFileName)) {
			int testCaseCount = scanner.nextInt();
			int index = 1;
			while (testCaseCount > 0) {
				int count = scanner.nextInt();
				int[] data = new int[count];
				int i = 0;
				while (i < count) {
					data[i] = scanner.nextInt();
					i++;
				}

				List<Integer> result = process(data);
				pw.print("Case #" + index + ": ");
				for (Integer element : result) {
					pw.print(element + " ");
				}
				pw.println();
				index ++;
				testCaseCount--;
			}
		}
	}

	public static void processTest(int... args) {
		List<Integer> result = eatMushroom(args);
		System.out.println(Arrays.toString(result.toArray(new Integer[2])));
	}

	public static List<Integer> process(int... args) {
		return eatMushroom(args);
	}

	public static List<Integer> eatMushroom(int[] mushrooms) {
		List<Integer> result = new ArrayList<Integer>(2);
		int largestDecrease = 0;
		int minimalEaten = 0;
		for (int i = 1; i < mushrooms.length; i++) {
			if (mushrooms[i] < mushrooms[i - 1]) {
				int decrease = mushrooms[i - 1] - mushrooms[i];
				if (decrease > largestDecrease) {
					largestDecrease = decrease;
				}
				minimalEaten += decrease;
			}
		}
		result.add(minimalEaten);
		if (largestDecrease == 0) {
			result.add(0);
			return result;
		}
		minimalEaten = 0;
		for (int i = 0; i < mushrooms.length - 1; i++) {
			if (mushrooms[i] < largestDecrease) {
				minimalEaten += mushrooms[i];
			} else {
				minimalEaten += largestDecrease;
			}
		}
		result.add(minimalEaten);
		return result;
	}

}
