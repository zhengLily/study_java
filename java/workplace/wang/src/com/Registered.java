package com;
/*�û�ע������
 * �����ߣ��û���Tc
 * 
 * */
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

import com.Variable;

public class Registered {

	public static void Registered(int id) {
		// TODO Auto-generated method stub
		//Tcִ�е�һ������
		TC.Tc1(id);
		//�û�ִ�е�һ������
		User.user1(id);
		//Tcִ�е�һ������
		TC.Tc2(id);
		//�û�ִ�е���������
		User.user2(id);
	}
	
}
