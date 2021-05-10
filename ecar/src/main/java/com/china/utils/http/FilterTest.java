package com.china.utils.http;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class StreamFilter {
	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>();
		List<String> out = new ArrayList<String>();
		arr.add("111");
		arr.add("2222");
		arr.add("33333");
		arr.add("444444");
		arr.add("11");
		arr.add("00");
		out = arr.stream().filter(str -> str.startsWith("11")).collect(Collectors.toList());
		
		out.forEach(str -> System.out.println(str));
		
		arr.stream().filter(str -> str.length()>3).forEach(str -> System.out.println(str));
		
	}
}
