package com;
/*
 * 对数据进行初始化
 * 选定大素数P，生成元g=2；
 * 选定私钥Ts = s，s属于Zp，公钥Tp=g^smodP
 * 选定一元多项式系数ai组成t-1次多项式f(x).
 * 其中
 * a0为群私钥，gp=g^a0modp为群公钥
 *
 * */
import java.math.BigInteger;
import java.util.Random;

public class Init {
	public static void init(){
		//随机选取s，Tp=g^s
		Variable.gen_s_for_Init_init();
		Variable.Tp = Variable.g.modPow(Variable.s, Variable.p);
		
		//随机选取t-1个随机数，组成t-1次方程式，gp = g^a0
		Variable.gen_a_for_Init_init();
		Variable.gp = Variable.g.modPow(Variable.a[0], Variable.p);
		//System.out.println("初始化完毕！");
	}
}
