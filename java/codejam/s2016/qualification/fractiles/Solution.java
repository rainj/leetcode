package codejam.s2016.qualification.fractiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
//		String inputFile = args[0];
//		String outputFile = args[1];
//
//		try (Scanner scanner = new Scanner(new FileInputStream(inputFile));
//				PrintWriter pw = new PrintWriter(outputFile)) {
//			int testCaseCount = scanner.nextInt();
//			int index = 1;
//			while (testCaseCount > 0) {
//				Long[] result = fractiles(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
//				pw.print("Case #" + index + ": ");
//				if (null == result || result.length == 0) {
//					pw.println("IMPOSSIBLE");
//				}
//				for (Long column : result) {
//					pw.print(column + " ");
//				}
//				pw.println();
//				testCaseCount--;
//				index++;
//			}
//		}
		System.out.println(Arrays.toString(fractiles(3, 2, 3)));
	}

	public static Long[] fractiles(int k, int c, int s) {
		if (c <= 1) {
			if (s < k) {
				return null;
			} else {
				Long[] result = new Long[k];
				for (int i = 1; i <= k; i++) {
					result[i - 1] = (long) i;
				}
				return result;
			}
		}
		if(k == 1) {
			Long[] result = new Long[1];
			result[0] = 1l;
			return result;
		}

		long largestIndex = 1;
		int count = c;
		while (count > 0) {
			largestIndex *= k;
			count--;
		}
		int topIndex = k - c;
		long topColumn = largestIndex / k + c;
		long topHigh = 0l;
		long topLow = 0l;
		if (topIndex > 63) {
			topHigh = 1 << (topIndex - 63);
		} else {
			topLow = 1 << topIndex;
		}
		List<Long> result = new ArrayList<Long>();
		if (c == 2) {
			topColumn--;
		}
		result.add(topColumn);

		int index = c;
		while (topHigh > 0 || topLow > 1) {
			index += 2;
			topColumn = (index - 2) * (largestIndex / k) + index;
			result.add(topColumn);
			topIndex = k - index;
			if (topIndex > 63) {
				topHigh = 1l << (topIndex - 63);
			} else {
				topLow = 1l << topIndex;
				topHigh = 0;
			}
			if(result.size() > s) {
				return null;
			}
		}

		return result.toArray(new Long[result.size()]);
	}

}
