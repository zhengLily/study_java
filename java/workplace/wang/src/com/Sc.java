package com;

/*
 * 签名过程中，SC需要做的操作
 * 第一步：验证用户发送过来的(r,si,m,ID2)
 * 第二步：计算R = r0*r1***rt,S=si0+si1+**+sit,W=X0^I0*X1^I1***Xt^It
 * 
 */
import java.math.BigInteger;
import java.util.Random;

public class Sc {

	public static void Sc1(int id) {
		// 签名合成者首先对收到的数据进行验证
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
		//		System.err.printf("第%d份额签名验证成功！\n", id);
		//	}
		} else {
			// TODO: Why double mod p!
			le = Variable.g.modPow(Variable.si[id], Variable.p).mod(Variable.p);
			le = le.multiply(
					Variable.D[id].modPow(Variable.hm.multiply(Variable.I[id])
							.mod(Variable.p), Variable.p)).mod(Variable.p);
		//	if (Variable.r[id].equals(le)) {
		//		System.err.printf("第%d份额签名验证成功！\n", id);
		//	}
		}
	}

	public static void Sc2() {
		// 计算R = r0*r1***rt
		Variable.R = BigInteger.ONE;
		for (int i = 0; i < Variable.t; i++) {
			Variable.R = Variable.R.multiply(Variable.r[i]).mod(Variable.p);
		}
		// 计算S=si0+si1+**+sit
		Variable.S = BigInteger.ZERO;
		for (int i = 0; i < Variable.t; i++) {
			// System.out.println(Variable.si[i]+"\n");
			Variable.S = Variable.S.add(Variable.si[i]);
			// System.out.println(Variable.S);
		}
		// 生成校验信息W=X0^I0*X1^I1***Xt^It
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
