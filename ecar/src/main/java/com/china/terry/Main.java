package com.china.terry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.china.terry.action.UppAction;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new
				FileSystemXmlApplicationContext("src/main/resources/BeanManager.xml");
		UppAction upp = (UppAction)ctx.getBean("upp");
		System.out.println(upp.exectue());	
	}

}
