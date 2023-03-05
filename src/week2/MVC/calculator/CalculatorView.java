package week2.MVC.calculator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class CalculatorView {
    protected Stage stage;
    private CalculatorModel model;
    protected Button digits[] = new Button[10]; // for numbers from 0 to 9
    protected Button plus; // for addition operation
    protected Button minus; // for subtraction operation
    protected Button equalto; 
    protected Button clear; // to clear the text field
    protected TextField txt; // to make the number entry
    
    
    
	public CalculatorView(Stage primaryStage, CalculatorModel model) {
		this.stage = primaryStage;
		this.model = model;
		
		BorderPane root = new BorderPane();
		txt = new TextField();
		txt.setDisable(true); //if needed idk
		root.setTop(txt);
		
		GridPane buttons = new GridPane();
		root.setCenter(buttons);
		
		for(int i =0; i<10; i++)
		{
			digits[i]= new Button(Integer.toString(i)); // have to do probably integer.to string
		}
		buttons.add(digits[0], 0, 3);
		for (int i = 1; i < digits.length; i++) {
			buttons.add(digits[i], (i-1) % 3, 2 - (i-1) / 3);
		}	
		plus = new Button("+");
		buttons.add(plus, 3, 0);
		clear = new Button("C");
		buttons.add(clear,1, 3, 2, 3);
		equalto = new Button("=");
		buttons.add(equalto, 3, 2);
		minus = new Button("-");
		buttons.add(minus, 3, 1);
		
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(25);
		buttons.getColumnConstraints().addAll(cc, cc, cc, cc);
		RowConstraints rc = new RowConstraints();
		rc.setPercentHeight(25);
		buttons.getRowConstraints().addAll(rc, rc, rc, rc);
		
		Scene scene = new Scene(root);
		// if needed css
		stage.setScene(scene);
		stage.setTitle("Calculator");
		
	}

	public void start() {
		stage.show();
		
	}

}
