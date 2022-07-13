package com.java.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GugudanInput implements Input {

	@Override
	public Map<String, Integer> excute() {
		Map<String, Integer> data = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.print("단수 >>");
		data.put("dan", Integer.parseInt(sc.nextLine()));
		System.out.print("곱수 >>");
		data.put("gop", Integer.parseInt(sc.nextLine()));
		return data;
	}

}
