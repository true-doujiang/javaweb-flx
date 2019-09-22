package cn.itcast;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CalculatorBean {

	private String firstNum = "0";
	private String secondNum = "0";
	private char operator = '+';  //int char byte short 
	private String result; 

	public void calculate() {
		
		BigDecimal first = new BigDecimal(this.firstNum);
		BigDecimal second = new BigDecimal(this.secondNum);
		
		switch (this.operator) {//switch只能判断int、char byte short 类型
		case '+': {
			this.result = first.add(second).toString();
			break;
		}
		case '-': {
			this.result = first.subtract(second).toString();
			break;
		}
		case '*': {
			this.result = first.multiply(second).toString();
			break;
		}
		case '/': {
			if (second.doubleValue() == 0) {
				throw new RuntimeException("被除数不能为0!!!");
			}
			// 四舍五入
			this.result = first.divide(second,5,BigDecimal.ROUND_HALF_UP).toString();
			break;
		}
		default:
			System.out.println("default");
			throw new RuntimeException("对不起，传入的运算符非法！！");
		}
	}
	
	

}
