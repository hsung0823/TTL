package com.choa.test;

import java.util.Random;

public class Test4 {
	public static void main(String[] args) {
		Random r = new Random();
		String str = String.valueOf(r.nextInt(9));
		str = str + String.valueOf(r.nextInt(9));
		str = str + String.valueOf(r.nextInt(9));
		str = str + String.valueOf(r.nextInt(9));
		str = str + String.valueOf(r.nextInt(9));
		str = str + String.valueOf(r.nextInt(9));
		System.out.println(str);
	}
}
