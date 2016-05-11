package codejam.s2016.qualification.coin_jam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		String inputFile = args[0];

		try (Scanner scanner = new Scanner(new FileInputStream(inputFile))) {
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				StringTokenizer st = new StringTokenizer(line);
				String numberStr = st.nextToken();
				int i = 2;
//				System.out.println(numberStr);
				while(st.hasMoreTokens()){
					int factor = Integer.parseInt(st.nextToken().trim());
					BigInteger number = new BigInteger(numberStr, i);
					if(number.mod(BigInteger.valueOf(factor)).intValue() != 0) {
						System.err.println("Error!!!!!!!!!!!!!!");
					}
					i++;
				}
			}
		}
	}

}
