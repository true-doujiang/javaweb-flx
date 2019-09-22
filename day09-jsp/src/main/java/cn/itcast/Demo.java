package cn.itcast;

import java.math.BigDecimal;

public class Demo {

	public static void main(String[] args) {
		/**
		 * double 只适合做不精确的算术运算，
		 * 精确运算要用BigDecmial类 查API java.math.BigDecimal
		 */
		/*double a = 0.1;
		double b = 0.006;
		System.out.println(a+b); //0.10600000000000001 不精确
		 */	
		
		BigDecimal a = new BigDecimal("0.1");
		BigDecimal b = new BigDecimal("0.0006");
		System.out.println(a.add(b).toString());
		System.out.println(a.multiply(b).toString());
		//保留15位小数，向上舍入
		System.out.println(a.divide(b,15,BigDecimal.ROUND_HALF_UP).toString());
	}
}
