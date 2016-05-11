package codejam.s2015.round1a.haircut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

				int result = process(data);
				pw.println("Case #" + index + ": " + result);
				index ++;
				testCaseCount--;
			}
		}
	}

	public static void processTest(int... args) {
		int result = haircut(args);
		System.out.println(result);
	}

	
	public static int process(int... args) {
		return haircut(args);
	}
	
	private static int haircut(int[] args) {
		return 0;
	}


}
