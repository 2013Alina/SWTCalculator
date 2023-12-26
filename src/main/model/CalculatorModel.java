package main.model;

public class CalculatorModel {

	private double operandFirst;
    private double operandSecond;
    private String operator;
	private double result;

	public double getOperandFirst() {
		return operandFirst;
	}

	public void setOperandFirst(double operandFirst) {
		this.operandFirst = operandFirst;
	}

	public double getOperandSecond() {
		return operandSecond;
	}

	public void setOperandSecond(double operandSecond) {
		this.operandSecond = operandSecond;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public void performingOperations() {
		switch (operator) {
		case "+":
			result = operandFirst + operandSecond;
			break;
		case "-":
			result = operandFirst - operandSecond;
			break;
		case "*":
			result = operandFirst * operandSecond;
			break;
		case "/":
			if (operandSecond != 0) {
				result = operandFirst / operandSecond;
			} else {
				result = Double.NaN;
			}
			break;
		}
	}
}
