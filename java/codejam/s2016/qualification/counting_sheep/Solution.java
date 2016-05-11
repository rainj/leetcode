package codejam.s2016.qualification.counting_sheep;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileInputStream("/Users/rjiang/Downloads/A-Large.in"));
		PrintWriter pw = new PrintWriter("/Users/rjiang/Downloads/A-Large.out");
		int testCaseCount = scanner.nextInt();
		int index = 1;
		try {
			while (testCaseCount > 0) {
				int number = scanner.nextInt();
				int result = lastCapableNumber(number);
				if (result > 0) {
					pw.println("Case #" + index + ": " + result);
				} else {
					pw.println("Case #" + index + ": INSOMNIA");
				}
				testCaseCount--;
				index ++;
			}
			pw.flush();
		} finally {
			try {
				pw.close();
			} catch (Exception e) {

			}
			try {
				scanner.close();
			} catch (Exception e) {

			}
		}
	}

	public static int lastCapableNumber(int number) {
		if (number == 0) {
			return -1;
		}

		int numberMap = 0;
		int n = 1;
		int num = -1;
		while (numberMap < 1023) {
			num = n * number;
			n++;
			int parseNum = num;
			while (parseNum > 0) {
				numberMap = numberMap | (1 << (parseNum % 10));
				parseNum = parseNum / 10;
			}
		}
		return num;

	}

}
