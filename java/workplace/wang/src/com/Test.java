package com;

/*
 * ��һ����ϵͳ��ʼ��
 * �ڶ�����Ϊÿ���û�ע��
 * ��������ǩ��
 * ���Ĳ�����֤ǩ��
 * */
import java.math.BigInteger;

public class Test {
	public static long get_time(){
		return System.nanoTime();
	}
	
	public static void main(String[] args) {
		int iters = 10;
		long beginTime,endTime;	
		for(Variable.n = 5;Variable.n<=100; Variable.n+=5){
			Variable.t = Variable.n / 2;
			long[] alltime = {0,0,0,0,0};
			for (int times = 1; times <= iters; times += 1) {	
				beginTime = get_time();
				// 1.ϵͳ��ʼ��
				Init.init();
				endTime = get_time();
				alltime[0]+= endTime - beginTime;
				
				// 2.�û�ע��
				beginTime = get_time();
				for (int i = 0; i < Variable.n; i++) {
					Registered.Registered(i);
				}
				endTime = get_time();
				alltime[1]+= endTime - beginTime;

				// �����������ղ�ֵ�㷨�е�I������Ϣ��
				// ����IΪ������Ϣ
				for (int i = 0; i < Variable.t; i++) {
					Variable.I[i] = BigInteger.ONE;
					BigInteger z = BigInteger.ONE;
					BigInteger m = BigInteger.ONE;
					for (int j = 0; j < Variable.t; j++) {
						if (i != j) {
							z = z.multiply(Variable.ID2[j]);
							m = m.multiply(Variable.ID2[j]
									.subtract(Variable.ID2[i]));
						}
					}
					// ��֤��ĸ��Ϊ����
					if (m.compareTo(BigInteger.ZERO) < 0) {
						z = z.multiply(new BigInteger(String.valueOf(-1)));
						m = m.multiply(new BigInteger(String.valueOf(-1)));
					}
					Variable.I[i] = z.multiply(
							m.modPow(Variable.p.subtract(new BigInteger(String
									.valueOf(2))), Variable.p)).mod(Variable.p);
					Variable.I[i] = Variable.I[i].add(Variable.p).mod(Variable.p);
				}

				// 3.���ɷݶ�ǩ��
				beginTime = get_time();
				for (int i = 0; i < Variable.t; i++) {
					User.user3(i);
				}
				endTime = get_time();
				alltime[2]+= endTime - beginTime;

				// 4.�ϳ�ǩ��
				beginTime = get_time();
				for (int i = 0; i < Variable.t; i++) {
					// ��֤���յĲ���ǩ��
					Sc.Sc1(i);
				}
				// �ϳ�ǩ��
				Sc.Sc2();
				endTime = get_time();
				alltime[3]+= endTime - beginTime;

				// 5.��֤ǩ��
				beginTime = get_time();
				Verifier.ver();
				endTime = get_time();
				alltime[4]+= endTime - beginTime;
			}
			System.out.printf("%d %d %.2f %.2f %.2f %.2f %.2f\n",Variable.n,Variable.t,alltime[0]/iters/1000000.0,alltime[1]/iters/1000000.0,alltime[2]/iters/1000000.0,alltime[3]/iters/1000000.0,alltime[4]/iters/1000000.0);
		}	
	}

}
