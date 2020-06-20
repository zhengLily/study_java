package com;
/*用户注册流程
 * 参与者：用户，Tc
 * 
 * */
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

import com.Variable;

public class Registered {

	public static void Registered(int id) {
		// TODO Auto-generated method stub
		//Tc执行第一个操作
		TC.Tc1(id);
		//用户执行第一个操作
		User.user1(id);
		//Tc执行第一个操作
		TC.Tc2(id);
		//用户执行第三个操作
		User.user2(id);
	}
	
}
