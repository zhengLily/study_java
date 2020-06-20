package com;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Variable {	
	
	static BigInteger s,z,Tp,gp,u,U,hid,R,S,W,hm;
	static BigInteger[] si = new BigInteger[100];
	static BigInteger[] ID = new BigInteger[100];
	static BigInteger[] ID1 = new BigInteger[100];
	static BigInteger[] ID2 = new BigInteger[100];
	static BigInteger[] x = new BigInteger[100];
	static BigInteger[] X = new BigInteger[100];
	static BigInteger[] v = new BigInteger[100];
	static BigInteger[] V = new BigInteger[100];
	static BigInteger[] y = new BigInteger[100];
	static BigInteger[] A = new BigInteger[100];
	static BigInteger[] d = new BigInteger[100];
	static BigInteger[] D = new BigInteger[100];
	static BigInteger[] a = new BigInteger[100];
	static BigInteger[] k = new BigInteger[100];
	static BigInteger[] r = new BigInteger[100];
	static BigInteger[] I = new BigInteger[100];
	static BigInteger[] HID = new BigInteger[100];
	static BigInteger[] HID1 = new BigInteger[100];
	static Random  rand = new Random();	
	
	//Define Hash function
	//from IDi to h(IDi)
	public static void gen_HID_for_TC_Tc1(int id){
		int nid = id +1;
		Variable.HID[id] = new BigInteger(""+ nid);
	}
	//from IDi1 to h(IDi1)
	public static void gen_HID1(int id){
		Variable.HID1[id] = Variable.ID1[id].add(BigInteger.ONE);
	}
	//generate z=h(m)
	public static void gen_hm(){
		Variable.hm = Variable.m.add(BigInteger.ONE);
	}
	
	//Generate Random Number
	static BigInteger p = new BigInteger("8780710799663312522437781984754049815806883"
			+ "199414208211028653399266475630880222957078625179422662221423155858769582317459277713367317481324925129998224791");
//	static BigInteger p = new BigInteger("100001029");
	static long t=40;
	static long n=100;
	static BigInteger g = new BigInteger("2");
	static BigInteger m = new BigInteger("4");
	
	public static void gen_s_for_Init_init(){
		Variable.s = new BigInteger(Variable.p.bitLength()-1, Variable.rand);
	}
	
	public static void gen_a_for_Init_init(){
		for(int i = 0; i <Variable.t; i++){
			Variable.a[i] = new BigInteger(Variable.p.bitLength()-1, Variable.rand);
		}
	}
	
	public static void gen_u_for_TC_Tc1(int id){
		Variable.u = new BigInteger(Variable.p.bitLength()-1, Variable.rand);
	}
	
	public static void gen_x_for_User_user1(int id){
		Variable.x[id] = new BigInteger(Variable.p.bitLength() - 1,Variable.rand);
	}
	
	public static void gen_v_for_User_user1(int id){
		Variable.v[id] = new BigInteger(Variable.p.bitLength() - 1, Variable.rand);
	}
	
	public static void gen_k_for_User_user3(int id){
		Variable.k[id] = new BigInteger(Variable.p.bitLength() - 1, Variable.rand);
	}


	/* For Test
	//Generate Random Number
	static BigInteger p = new BigInteger("8780710799663312522437781984754049815806883"
			+ "199414208211028653399266475630880222957078625179422662221423155858769582317459277713367317481324925129998224791");
	static long t=2;
	static long n=3;
	static BigInteger g = new BigInteger("2");
	static BigInteger m = new BigInteger("0");
	
	public static void gen_s_for_Init_init(){
		Variable.s = new BigInteger("2");
	}
	public static void gen_a_for_Init_init(){
		Variable.a[0] = new BigInteger("2");
		Variable.a[1] = new BigInteger("1");
	}
	
	public static void gen_u_for_TC_Tc1(int id){
		Variable.u = new BigInteger("2");
	}
	
	public static void gen_x_for_User_user1(int id){
		Variable.x[0] = new BigInteger("2");
		Variable.x[1] = new BigInteger("1");
		Variable.x[2] = new BigInteger("2");
	}
	
	public static void gen_v_for_User_user1(int id){
		Variable.v[0] = new BigInteger("1");
		Variable.v[1] = new BigInteger("2");
		Variable.v[2] = new BigInteger("2");
	}
	
	public static void gen_k_for_User_user3(int id){
		Variable.k[0] = new BigInteger("1");
		Variable.k[1] = new BigInteger("2");
	}
	*/
}
