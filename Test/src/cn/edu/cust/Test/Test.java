package cn.edu.cust.Test;

import java.util.Date;
import java.util.Properties;

public class Test {
	public static void main(String[] args){
		Properties pro = new Properties();
		pro.setProperty("Mon","111");
		pro.setProperty("Tue", "222");
		System.out.println(pro.getProperty("Mon"));
		pro.put("Wed", "333");
		System.out.println(pro.getProperty("Wed"));
		System.out.println(new Date().getTime());
		System.out.println(System.currentTimeMillis());
	}
}
