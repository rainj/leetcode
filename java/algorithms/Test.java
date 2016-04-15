package algorithms;

import java.math.BigInteger;

public class Test {

	public static void main(String[] args) {
		System.out.println(new BigInteger("10100000000000000000000000000001", 2));
		System.out.println(new BigInteger("10000000000000000000000000000101", 5).mod(BigInteger.valueOf(73)));
	}

}
