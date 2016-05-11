package codejam.s2016.qualification.fractiles;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) throws IOException {
		
		int k = 5;
		for (int index = k; index < k+1 ; index++) {
			char[][] result = printTiles(k, index);
			String fileName = "/Users/rjiang/Downloads/tiles/" + k + "-" + index ;
			try (BufferedWriter pw = new BufferedWriter(new PrintWriter(fileName))) {
				for (int i = 0; i < result.length; i++) {
					char[] element = result[i];
					pw.write(element, 0, 200);
					pw.newLine();
				}
			}

		}
	}

	public static char[][] printTiles(int k, int c) {
		int count = 1 << k;
		char[][] initialized = new char[count][k];
		for (int i = 0; i < count; i++) {
			initialized[i][k - 1] = (char) ('0' + (i & 1));
			for (int j = 1; j < k; j++) {
				initialized[i][k - 1 - j] = (char) ('0' + ((i >>> j) & 1));
			}
		}

		return printTiles(k, c, initialized);

	}

	public static char[][] printTiles(int k, int c, char[][] initialized) {
		if (c == 1) {
			return initialized;
		}
		char[][] previousLevel = printTiles(k, c - 1, initialized);
		int column = previousLevel[0].length;
		int row = previousLevel.length;
		char[][] result = new char[row][column * k];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (previousLevel[i][j] == '0') {
					for (int m = 0; m < k; m++) {
						result[i][m + k * j] = '0';
					}
				} else {
					for (int m = 0; m < k; m++) {
						result[i][m + k * j] = initialized[i][m];
					}
				}
			}
		}

		return result;
	}

}
