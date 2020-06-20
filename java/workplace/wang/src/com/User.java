package com;

/*
 * 建立一个User类
 * 包含注册和签名过程中，用户所需要的三个操作
 * 第一个操作：接收TC发送的(U,ID1),验证数据是否被修改，选取x,v计算X，V，生成ID2
 * 第二个操作：接收TC发送的y，计算d = x+y,D=g^d,用户注册完成
 * 第三个操作：在签名过程，用户选取k，计算r=g^k,z=哈希m，计算si=k-zdI。
 */
import java.math.BigInteger;

public class User {
	// 在注册过程中，用户第一个操作，接收TC发送的(U,ID1),
	public static void user1(int id) {
		// 用户验证收到的(U,ID1)
		// g^ID1 = Tp^h(ID)*U
		BigInteger le = Variable.g.modPow(Variable.ID1[id], Variable.p);
		BigInteger ri = Variable.Tp.modPow(Variable.HID[id], Variable.p)
				.multiply(Variable.U).mod(Variable.p);
	//	if (le.mod(Variable.p).equals(ri.mod(Variable.p))) {
	//		System.err.println("第一步验证通过！");
	//	}
		// 用户选取自己的部分私钥
		// 选取x,X=g^x
		Variable.gen_x_for_User_user1(id);
		Variable.X[id] = Variable.g.modPow(Variable.x[id], Variable.p);

		// 用户进行二次身份盲化
		// 选取v,V=g^v
		// ID2=x+h(ID1)+v
		Variable.gen_v_for_User_user1(id);
		Variable.V[id] = Variable.g.modPow(Variable.v[id], Variable.p);

		Variable.gen_HID1(id);
		Variable.ID2[id] = Variable.x[id].multiply(Variable.HID1[id]).add(
				Variable.v[id]);
	}

	public static void user2(int id) {
		// 用户通过d = x+y计算个人私钥
		// 通过D = g^dmodp计算个人公钥
		Variable.d[id] = Variable.x[id].add(Variable.y[id]);
		Variable.D[id] = Variable.g.modPow(Variable.d[id], Variable.p);
	}

	public static void user3(int id) {
		// 选取k，计算r=g^k,z=哈希m，计算si=k-zdI。
		Variable.gen_k_for_User_user3(id);
		Variable.r[id] = Variable.g.modPow(Variable.k[id], Variable.p);

		Variable.gen_hm();
		Variable.si[id] = Variable.k[id].subtract(Variable.hm.multiply(
				Variable.d[id]).multiply(Variable.I[id]));

	}
}
