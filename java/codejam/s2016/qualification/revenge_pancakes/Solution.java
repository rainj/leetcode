package codejam.s2016.qualification.revenge_pancakes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		String inputFile = args[0];
		String outputFile = args[1];

		try (Scanner scanner = new Scanner(new FileInputStream(inputFile));
				PrintWriter pw = new PrintWriter(outputFile)) {
			int testCaseCount = scanner.nextInt();
			scanner.nextLine();
			int index = 1;
			while (testCaseCount > 0) {
				int result = flipPanCake(scanner.nextLine());
				pw.println("Case #" + index + ": " + result);
				testCaseCount--;
				index++;
			}
		}
		
//		System.out.println(flipPanCake("---+--++-++++++++--++-++++-+--+-+-++-----+++-+-+-++-++-+-+-+-+-+-+--+-+"));
	}

	public static int flipPanCake(String stack) {
		if (null == stack || 0 == stack.length()) {
			return 0;
		}
		int length = stack.length();
		long low = 0l;
		long high = 0l;
		for (int i = length - 1; i >= 0; i--) {
			if (stack.charAt(i) == '-') {
				if (length - 1 - i < 64) {
					low = low | (1l << (length - 1 - i));
				} else {
					high = high | (1l << (length - 65 - i));
				}
			}
		}
		int count = 0;
		long lastBitOfHigh;
		while (length >= 64) {
			lastBitOfHigh = high & 1;
			if ((low & 1) == 0) {
				low = low >>> 1;
				length--;
				if (lastBitOfHigh > 0) {
					low = low | (lastBitOfHigh << 63);
				}
				high = high >>> 1;
			} else {
				low = ~low;
				high = (~high) & ((1l << length - 64) - 1);
				count++;
			}

		}
		while (low != 0) {
			if ((low & 1) == 0) {
				low = low >>> 1;
				length--;
			} else {
				low = ~low;
				low = low & ((1l << length) - 1);
				count++;
			}
		}

		return count;
	}

}
