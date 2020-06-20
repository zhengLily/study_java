package com;
import java.math.BigInteger;
public class ForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger p = new BigInteger("999903");
		BigInteger tmp = new BigInteger("2").modPow(p,new BigInteger("1999799"));
		System.out.printf("%s\n",tmp.toString());
	}

}
