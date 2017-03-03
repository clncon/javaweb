package cn.itcast.web.domain;

public class countBean {
	private double firstNumber;
	private double secondNumber;
	private double resultNumber;
	private String operator="+";
	private static countBean cb;

	
	public countBean(){}

	public double getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(double firstNumber) {
		this.firstNumber = firstNumber;
	}

	public double getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(double secondNumber) {
		this.secondNumber = secondNumber;
	}

	public double getResultNumber() {
		return resultNumber;
	}

	public void setResultNumber(double resultNumber) {
		this.resultNumber = resultNumber;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public void counting(double f1,double f2,String op ){
		
		if(op.equals("+")){
			resultNumber=f1+f2;
		}
		else if(op.equals("-")){
			resultNumber = f1-f2;
		}
		else if (op.equals("*")){
			resultNumber = f1*f2;
		}
		else{
			resultNumber = f1/f2;
		}
		
		
		
	}
	public static countBean getBean(){
		if(cb==null){
			cb = new countBean();
		}
		
		return cb;
	}

	

}
