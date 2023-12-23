package main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
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

public class MainSWT {
	public static void main(String[] args) {

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWT Calculator");

		FillLayout layout = new FillLayout();
		layout.marginHeight = 10;
		layout.marginWidth = 10;
		shell.setLayout(layout);
		Color color1 = new Color(204, 102, 255);
		shell.setBackground(color1);

		TabFolder tabFolder = new TabFolder(shell, SWT.BORDER);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		tabFolder.setLayout(gridLayout);

		TabItem itemCalculator = new TabItem(tabFolder, SWT.NONE);
		itemCalculator.setText("Calculator");

		Composite compositeCalculator = new Composite(tabFolder, SWT.NONE);
		itemCalculator.setControl(compositeCalculator);
		compositeCalculator.setLayout(new GridLayout(3, true));
		Color color2 = new Color(255, 204, 255);
		compositeCalculator.setBackground(color2);

		Text text1 = new Text(compositeCalculator, SWT.BORDER);
		text1.setSize(100, 20);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		text1.setLayoutData(gridData);

		Combo operationCombo = new Combo(compositeCalculator, SWT.NONE);
		String[] mathOperations = new String[] { "+", "-", "*", "/" };
		operationCombo.setItems(mathOperations);
		operationCombo.setSize(100, 20);
		operationCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Text text2 = new Text(compositeCalculator, SWT.BORDER);
		text2.setSize(100, 20);
		text2.setLayoutData(gridData);

		Button checkButton = new Button(compositeCalculator, SWT.CHECK);
		checkButton.setText("Calculator on the fly");
		gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gridData.verticalIndent = 250;
		checkButton.setLayoutData(gridData);

		Button calculateButton = new Button(compositeCalculator, SWT.PUSH);
		calculateButton.setText("Calculate");
		gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gridData.verticalIndent = 250;
		calculateButton.setLayoutData(gridData);

		Label label = new Label(compositeCalculator, SWT.NONE);
		label.setText("Result");
		Text text3 = new Text(compositeCalculator, SWT.BORDER);
		text3.setSize(100, 20);
		gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gridData.verticalIndent = 20;
		text3.setLayoutData(gridData);
		
		

		TabItem itemHistory = new TabItem(tabFolder, SWT.NONE);
		itemHistory.setText("History");
		Color color3 = new Color(204, 255, 255);

		shell.pack();
		shell.setSize(400, 500);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	}
}
