package com;
/*
 * ע������У�TC��������
 * 
 * ��һ����ѡȡu������U=g^u,ID1=s*h(ID)+u
 * 
 * �ڶ�����������֤�û����͵�����(X,V,ID1,ID2),����y=f(ID2),A=g^ai
 * */
import java.math.BigInteger;

public class TC {
	//TC�ĵ�һ������
	public static void Tc1(int id){
		//ѡȡu������U=g^u,ID1=s*h(ID)+u
		Variable.gen_u_for_TC_Tc1(id);
		Variable.U = Variable.g.modPow(Variable.u, Variable.p);
		//��ϣ������ʱд���������޸�
		Variable.gen_HID_for_TC_Tc1(id);
		Variable.ID1[id] = Variable.s.multiply(Variable.HID[id]).add(Variable.u);
		
	}
	//TC�ĵڶ�������
	public static void Tc2(int id){
		//TC��֤�յ�������(X,V,ID1,ID2)
		//g^ID1 = X^h(ID)*V
		BigInteger le = Variable.g.modPow(Variable.ID2[id], Variable.p);
		BigInteger ri = Variable.X[id].modPow(Variable.HID1[id], Variable.p).multiply(Variable.V[id]).mod(Variable.p);
	//	if(le.equals(ri)){
	//		System.err.println("�ڶ�����֤ͨ����");
	//	}
		//TCΪ�û�������һ��˽Կy
		Variable.y[id] = BigInteger.ZERO;
		for(int i = 0; i < Variable.t; i++){
			Variable.y[id] = Variable.y[id].add(Variable.a[i].multiply(Variable.ID2[id].modPow(new BigInteger(String.valueOf(i)),
			Variable.p))).mod(Variable.p);
		}
	}
}
