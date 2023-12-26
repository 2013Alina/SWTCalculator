package main;

import main.controller.CalculatorController;
import main.model.CalculatorModel;
import main.view.CalculatorView;

public class MainSWT {
	public static void main(String[] args) {

        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(model);
        CalculatorView view = new CalculatorView(controller);
        
        controller.setOperationListener(new OperationListener() {
            @Override
            public void onOperationPerformed(double result) {
            	view.updateResult(model.getResult());
            }
        });

        
        view.open();
        
	}
}
