package main.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import main.controller.CalculatorController;

public class CalculatorView {
	private Display display;
	private Shell shell;
	private FillLayout layout;
	private TabFolder tabFolder;
	private GridLayout gridLayout;
	private TabItem itemCalculator;
	private Composite compositeCalculator;
	private Text textOperandFirst;
	private Combo operationCombo;
	private Text textOperandSecond;
	private Button checkButton;
	private Button calculateButton;
	private Label label;
	private Text textResult;
	private TabItem itemHistory;
	private CalculatorController controller;

	public CalculatorView(CalculatorController controller) {
		this.controller = controller;
		createContents();
	}

	private void createContents() {
		display = new Display();
		shell = new Shell();
		layout = new FillLayout();
		layout.marginHeight = 10;
		layout.marginWidth = 10;
		shell.setLayout(layout);
		Color color1 = new Color(204, 102, 255);
		shell.setBackground(color1);

		tabFolder = new TabFolder(shell, SWT.BORDER);
		gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		tabFolder.setLayout(gridLayout);

		itemCalculator = new TabItem(tabFolder, SWT.NONE);
		itemCalculator.setText("Calculator");

		compositeCalculator = new Composite(tabFolder, SWT.NONE);
		itemCalculator.setControl(compositeCalculator);
		compositeCalculator.setLayout(new GridLayout(3, true));
		Color color2 = new Color(255, 204, 255);
		compositeCalculator.setBackground(color2);

		textOperandFirst = new Text(compositeCalculator, SWT.BORDER);
		textOperandFirst.setSize(100, 20);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		textOperandFirst.setLayoutData(gridData);

		operationCombo = new Combo(compositeCalculator, SWT.NONE);
		String[] mathOperations = new String[] { "+", "-", "*", "/" };
		operationCombo.setItems(mathOperations);
		operationCombo.setSize(100, 20);
		operationCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		textOperandSecond = new Text(compositeCalculator, SWT.BORDER);
		textOperandSecond.setSize(100, 20);
		textOperandSecond.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		checkButton = new Button(compositeCalculator, SWT.CHECK);
		checkButton.setText("Calculator on the fly");
		gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gridData.verticalIndent = 250;
		checkButton.setLayoutData(gridData);

		calculateButton = new Button(compositeCalculator, SWT.PUSH);
		calculateButton.setText("Calculate");
		gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gridData.verticalIndent = 250;
		calculateButton.setLayoutData(gridData);
		calculateButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String operandFirst = textOperandFirst.getText();
				Double doubleFirstOperand = Double.parseDouble(operandFirst);
				String operandSecond = textOperandSecond.getText();
				Double doubleSecondOperand = Double.parseDouble(operandSecond);
				String operation = operationCombo.getText();
				controller.performOperation(doubleFirstOperand, doubleSecondOperand, operation);
			}
		});

		label = new Label(compositeCalculator, SWT.NONE);
		label.setText("Result");
		gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gridData.verticalIndent = 20;
		label.setLayoutData(gridData);

		textResult = new Text(compositeCalculator, SWT.BORDER);
		textResult.setSize(100, 20);
		gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gridData.verticalIndent = 20;
		textResult.setLayoutData(gridData);

		itemHistory = new TabItem(tabFolder, SWT.NONE);
		itemHistory.setText("History");
		Color color3 = new Color(204, 255, 255);

		shell.pack();
		shell.setSize(400, 500);
	}

	public void open() {
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}


	public void updateResult(double result) {
		textResult.setText(String.valueOf(result));
	}

}
