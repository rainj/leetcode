package codejam.s2016.qualification.coin_jam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static List<Long> primeArray = new ArrayList<Long>();

	public static void main(String[] args) throws FileNotFoundException {
//		String inputFile = args[0];
//		String outputFile = args[1];
//
//		try (Scanner scanner = new Scanner(new FileInputStream(inputFile));
//				PrintWriter pw = new PrintWriter(outputFile)) {
//			int testCaseCount = scanner.nextInt();
//			int index = 1;
//			while (testCaseCount > 0) {
//				String[] result = findJamCoins(scanner.nextInt(), scanner.nextInt());
//				pw.println("Case #" + index + ": ");
//				for (String str : result) {
//					pw.println(str);
//				}
//				testCaseCount--;
//				index++;
//			}
//		}
		
		PrintStream pw = System.out;
		int index = 1;
		
		String[] result = findJamCoins(16, 50);
		pw.println("Case #" + index + ": ");
		for (String str : result) {
			pw.println(str);
		}

	}

	public static String[] findJamCoins(int bitCount, int count) {
		String[] result = new String[count];
		int length = bitCount;
		long minNum = (1l << (length - 1)) + 1;
		long maxNum = (1l << length) - 1;
		long number = minNum;
		int index = 0;
		int[] bitOfNumber = new int[bitCount];
		while (number < maxNum && index < count) {
			long temp = number;
			int bitIndex = bitCount - 1;
			while (temp > 0) {
				bitOfNumber[bitIndex--] = (int) (temp & 1);
				temp = temp >>> 1;
			}
			String line = findJamCoin(bitOfNumber);
			if (null != line) {
				result[index] = line;
				index++;
			}
			number += 2;
		}
		return result;
	}

	public static String findJamCoin(int[] bitArray) {
		StringBuilder sb = new StringBuilder();
		int length = bitArray.length;
		long number = -1;
		for (int i = 2; i <= 10; i++) {
			number = bitArray[0];
			for (int j = 1; j < length; j++) {
				if(Long.MAX_VALUE/i - number < 0){
					System.out.println("array " + Arrays.toString(bitArray) + " exceed with j=" + j + "and i=" + i);
				}
				number = number * i + bitArray[j];
			}
			long factor = findFactor(number);
			if (factor < 0) {
				return null;
			} else {
				sb.append(" ").append(factor);
			}
		}
		return sb.insert(0, number).toString();
	}

	public static long findFactor(long number) {
		if (number % 2 == 0) {
			return 2;
		}
		if (number % 3 == 0) {
			return 3;
		}
		for (long i = 5; i * i < number; i += 6) {
			if (number % i == 0) {
				return i;
			}
			if (number % (i + 2) == 0) {
				return i + 2;
			}
		}
		return -1;
	}

}
