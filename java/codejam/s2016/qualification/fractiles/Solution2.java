package codejam.s2016.qualification.fractiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) throws FileNotFoundException {
		String inputFile = args[0];
		String outputFile = args[1];

		try (Scanner scanner = new Scanner(new FileInputStream(inputFile));
				PrintWriter pw = new PrintWriter(outputFile)) {
			int testCaseCount = scanner.nextInt();
			int index = 1;
			while (testCaseCount > 0) {
				List<Long> result = fractiles(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
				pw.print("Case #" + index + ": ");
				if (null == result || result.size() == 0) {
					pw.print("IMPOSSIBLE");
				} else {
					for (Long column : result) {
						pw.print(column + " ");
					}
				}
				pw.println();
				testCaseCount--;
				index++;
			}
		}
		// System.out.println(Arrays.toString(fractiles(3, 4, 6)));
	}

	public static List<Long> fractiles(int k, int c, int s) {
		if (s * c < k) {
			return null;
		}
		int complex = c > k ? k : c;

		List<Long> result = new ArrayList<Long>();
		for (int i = 0; i < k; i += complex) {
			long current = i;
			for (int j = i + 1; j < i + complex && j <= k; j++) {
				current = current * k;
				if (j < k) {
					if (j == i + complex - 1) {
						current += i;
					} else if (j < k) {
						current += j;
					}
				}
			}
			if (i + complex <= k) {
				current += complex;
			}
			result.add(current);
		}

		return result;
	}

}
