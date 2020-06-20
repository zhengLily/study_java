package com;

/*
 * ǩ�������У�SC��Ҫ���Ĳ���
 * ��һ������֤�û����͹�����(r,si,m,ID2)
 * �ڶ���������R = r0*r1***rt,S=si0+si1+**+sit,W=X0^I0*X1^I1***Xt^It
 * 
 */
import java.math.BigInteger;
import java.util.Random;

public class Sc {

	public static void Sc1(int id) {
		// ǩ���ϳ������ȶ��յ������ݽ�����֤
		// g^si*D^zI = r
		BigInteger le, ri;
		if (Variable.si[id].compareTo(BigInteger.ZERO) < 0) {
			le = Variable.D[id].modPow(Variable.hm.multiply(Variable.I[id]),
					Variable.p);
			ri = Variable.g
					.modPow(Variable.si[id].multiply(new BigInteger(String
							.valueOf(-1))), Variable.p)
					.multiply(Variable.r[id]).mod(Variable.p);
		//	if (le.equals(ri)) {
		//		System.err.printf("��%d�ݶ�ǩ����֤�ɹ���\n", id);
		//	}
		} else {
			// TODO: Why double mod p!
			le = Variable.g.modPow(Variable.si[id], Variable.p).mod(Variable.p);
			le = le.multiply(
					Variable.D[id].modPow(Variable.hm.multiply(Variable.I[id])
							.mod(Variable.p), Variable.p)).mod(Variable.p);
		//	if (Variable.r[id].equals(le)) {
		//		System.err.printf("��%d�ݶ�ǩ����֤�ɹ���\n", id);
		//	}
		}
	}

	public static void Sc2() {
		// ����R = r0*r1***rt
		Variable.R = BigInteger.ONE;
		for (int i = 0; i < Variable.t; i++) {
			Variable.R = Variable.R.multiply(Variable.r[i]).mod(Variable.p);
		}
		// ����S=si0+si1+**+sit
		Variable.S = BigInteger.ZERO;
		for (int i = 0; i < Variable.t; i++) {
			// System.out.println(Variable.si[i]+"\n");
			Variable.S = Variable.S.add(Variable.si[i]);
			// System.out.println(Variable.S);
		}
		// ����У����ϢW=X0^I0*X1^I1***Xt^It
		Variable.W = BigInteger.ZERO;
		for (int i = 0; i < Variable.t; i++) {
			Variable.W = Variable.W.add(Variable.I[i].multiply(Variable.x[i]));
		//	Variable.W = Variable.W.multiply(
		//			Variable.X[i].modPow(Variable.I[i], Variable.p)).mod(
		//			Variable.p);
		}
		Variable.W = Variable.W.multiply(Variable.hm).add(Variable.S);	
		Variable.W =  Variable.a[0].multiply(Variable.hm).add(Variable.W).mod(Variable.p);
	}

}
