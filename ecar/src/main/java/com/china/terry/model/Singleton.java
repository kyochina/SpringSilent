package com.china.terry.model;

public class Singleton {
	private static Singleton singloten;
	private Singleton(){}
	public static synchronized Singleton getInstance(){
		if(singloten == null){
			return new Singleton();
		}
		return singloten;
	}

}
