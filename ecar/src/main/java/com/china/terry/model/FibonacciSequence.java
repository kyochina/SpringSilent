package com.china.terry.model;

public class FibonacciSequence {

	public static void main(String[] args) {
		int n = Fribonacci(4);
		System.out.println(n);
	}
	public static int Fribonacci(int i){
		if(i<=2)
			return 1;
		else 
			return Fribonacci(i-1)+Fribonacci(i-2);
	}

}
