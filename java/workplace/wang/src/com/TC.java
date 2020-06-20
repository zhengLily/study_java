package com;
/*
 * 注册过程中，TC所做操作
 * 
 * 第一步：选取u，计算U=g^u,ID1=s*h(ID)+u
 * 
 * 第二步操作：验证用户发送的数据(X,V,ID1,ID2),计算y=f(ID2),A=g^ai
 * */
import java.math.BigInteger;

public class TC {
	//TC的第一个操作
	public static void Tc1(int id){
		//选取u，计算U=g^u,ID1=s*h(ID)+u
		Variable.gen_u_for_TC_Tc1(id);
		Variable.U = Variable.g.modPow(Variable.u, Variable.p);
		//哈希函数暂时写死，后期修改
		Variable.gen_HID_for_TC_Tc1(id);
		Variable.ID1[id] = Variable.s.multiply(Variable.HID[id]).add(Variable.u);
		
	}
	//TC的第二个操作
	public static void Tc2(int id){
		//TC验证收到的数据(X,V,ID1,ID2)
		//g^ID1 = X^h(ID)*V
		BigInteger le = Variable.g.modPow(Variable.ID2[id], Variable.p);
		BigInteger ri = Variable.X[id].modPow(Variable.HID1[id], Variable.p).multiply(Variable.V[id]).mod(Variable.p);
	//	if(le.equals(ri)){
	//		System.err.println("第二步验证通过！");
	//	}
		//TC为用户分配另一份私钥y
		Variable.y[id] = BigInteger.ZERO;
		for(int i = 0; i < Variable.t; i++){
			Variable.y[id] = Variable.y[id].add(Variable.a[i].multiply(Variable.ID2[id].modPow(new BigInteger(String.valueOf(i)),
			Variable.p))).mod(Variable.p);
		}
	}
}
