package com;
/*
 * �����ݽ��г�ʼ��
 * ѡ��������P������Ԫg=2��
 * ѡ��˽ԿTs = s��s����Zp����ԿTp=g^smodP
 * ѡ��һԪ����ʽϵ��ai���t-1�ζ���ʽf(x).
 * ����
 * a0ΪȺ˽Կ��gp=g^a0modpΪȺ��Կ
 *
 * */
import java.math.BigInteger;
import java.util.Random;

public class Init {
	public static void init(){
		//���ѡȡs��Tp=g^s
		Variable.gen_s_for_Init_init();
		Variable.Tp = Variable.g.modPow(Variable.s, Variable.p);
		
		//���ѡȡt-1������������t-1�η���ʽ��gp = g^a0
		Variable.gen_a_for_Init_init();
		Variable.gp = Variable.g.modPow(Variable.a[0], Variable.p);
		//System.out.println("��ʼ����ϣ�");
	}
}
