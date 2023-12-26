package main.controller;

import main.OperationListener;
import main.model.CalculatorModel;

public class CalculatorController {
	
	private CalculatorModel model;
    private OperationListener operationListener;
    
    public CalculatorController(CalculatorModel model) {
    	this.model = model;
    }
    
    public void setOperationListener(OperationListener listener) {
        this.operationListener = listener;
    }
    
    public void performOperation(double operandFirst, double operandSecond, String operator) {
        model.setOperandFirst(operandFirst);
        model.setOperandSecond(operandSecond);
        model.setOperator(operator);
        model.performingOperations();
        if (operationListener != null) {
            operationListener.onOperationPerformed(model.getResult());
        }
    }
}
