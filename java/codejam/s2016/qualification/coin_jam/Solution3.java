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

public class Solution3 {

	public static int[] primeArray = new int[]{
		2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
	};
	

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
		
//		PrintStream pw = System.out;
//		int index = 1;
//		
//		String[] result = findJamCoins(32, 5);
//		pw.println("Case #" + index + ": ");
//		for (String str : result) {
//			pw.println(str);
//		}
		int bitCount = 32;
		int[] bitOfNumber = new int[bitCount];
		long temp = 2684354561l;
		int bitIndex = bitCount - 1;
		while (temp > 0) {
			bitOfNumber[bitIndex--] = (int) (temp & 1);
			temp = temp >>> 1;
		}
		String line = findJamCoin(bitOfNumber);
		System.out.println(line);
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
		int primCount = primeArray.length;
		int[] numberArray = new int[primeArray.length];
		for (int i = 2; i <= 10; i++) {
			boolean hasFactor = false;
			for(int j = 0; j < primCount; j ++) {
				numberArray[j] = bitArray[0];
			}
			for (int k = 1; k < length; k++) {
				for(int j = 0; j <  primCount; j ++) {
					numberArray[j] = numberArray[j] * i + bitArray[k];
					numberArray[j] = numberArray[j] % primeArray[j];
				}
			}
			for(int j = 0; j < primCount; j ++) {
				if(numberArray[j] == 0) {
					hasFactor = true;
					sb.append(" ").append(primeArray[j]);
					break;
				}
			}
			if (!hasFactor){
				return null;
			}
		}
		for(int k = 0; k < length; k ++) {
			sb.insert(0, bitArray[k]);
		}
		return sb.toString();
	}

}
