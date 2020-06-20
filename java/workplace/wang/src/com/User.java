package com;

/*
 * ����һ��User��
 * ����ע���ǩ�������У��û�����Ҫ����������
 * ��һ������������TC���͵�(U,ID1),��֤�����Ƿ��޸ģ�ѡȡx,v����X��V������ID2
 * �ڶ�������������TC���͵�y������d = x+y,D=g^d,�û�ע�����
 * ��������������ǩ�����̣��û�ѡȡk������r=g^k,z=��ϣm������si=k-zdI��
 */
import java.math.BigInteger;

public class User {
	// ��ע������У��û���һ������������TC���͵�(U,ID1),
	public static void user1(int id) {
		// �û���֤�յ���(U,ID1)
		// g^ID1 = Tp^h(ID)*U
		BigInteger le = Variable.g.modPow(Variable.ID1[id], Variable.p);
		BigInteger ri = Variable.Tp.modPow(Variable.HID[id], Variable.p)
				.multiply(Variable.U).mod(Variable.p);
	//	if (le.mod(Variable.p).equals(ri.mod(Variable.p))) {
	//		System.err.println("��һ����֤ͨ����");
	//	}
		// �û�ѡȡ�Լ��Ĳ���˽Կ
		// ѡȡx,X=g^x
		Variable.gen_x_for_User_user1(id);
		Variable.X[id] = Variable.g.modPow(Variable.x[id], Variable.p);

		// �û����ж������ä��
		// ѡȡv,V=g^v
		// ID2=x+h(ID1)+v
		Variable.gen_v_for_User_user1(id);
		Variable.V[id] = Variable.g.modPow(Variable.v[id], Variable.p);

		Variable.gen_HID1(id);
		Variable.ID2[id] = Variable.x[id].multiply(Variable.HID1[id]).add(
				Variable.v[id]);
	}

	public static void user2(int id) {
		// �û�ͨ��d = x+y�������˽Կ
		// ͨ��D = g^dmodp������˹�Կ
		Variable.d[id] = Variable.x[id].add(Variable.y[id]);
		Variable.D[id] = Variable.g.modPow(Variable.d[id], Variable.p);
	}

	public static void user3(int id) {
		// ѡȡk������r=g^k,z=��ϣm������si=k-zdI��
		Variable.gen_k_for_User_user3(id);
		Variable.r[id] = Variable.g.modPow(Variable.k[id], Variable.p);

		Variable.gen_hm();
		Variable.si[id] = Variable.k[id].subtract(Variable.hm.multiply(
				Variable.d[id]).multiply(Variable.I[id]));

	}
}
