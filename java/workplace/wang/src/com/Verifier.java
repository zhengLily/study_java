package com;

/*
 * ��֤ǩ��ʱ����ȷ
 * R = g^S*(gp^W)^zmodp
 */

import java.math.BigInteger;

public class Verifier {
	public static void ver() {
		/*BigInteger le, ri;
		// SΪ����
		if (Variable.S.compareTo(BigInteger.ZERO) < 0) {
			le = Variable.R.multiply(
					Variable.g.modPow(Variable.S.multiply(new BigInteger(String
							.valueOf(-1))), Variable.p)).mod(Variable.p);
			ri = Variable.gp.multiply(Variable.W).modPow(Variable.hm,
					Variable.p);
			if (le.equals(ri)) {
				System.err.println("ǩ����֤�ɹ���");
			}
		} else {
			ri = Variable.g.modPow(Variable.S, Variable.p);
			BigInteger temp = Variable.gp.multiply(Variable.W).modPow(
					Variable.hm, Variable.p);
			ri = ri.multiply(temp).mod(Variable.p);
			if (Variable.R.equals(ri)) {
				System.err.println("ǩ����֤�ɹ���");
			}
		}*/
		BigInteger left = BigInteger.ZERO;
		for (int i = 0; i < Variable.t; i++) {
			left = left.add(Variable.k[i]);
		}
		left = left.mod(Variable.p);
		
		if (Variable.g.modPow(Variable.W,Variable.p).equals(Variable.g.modPow(left,Variable.p))) {
		//	System.out.println("ǩ����֤�ɹ���");
		}
	}

}
