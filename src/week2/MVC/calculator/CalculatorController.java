package week2.MVC.calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class CalculatorController implements EventHandler<ActionEvent> {
	private CalculatorModel model;
	private CalculatorView view;
	
	public CalculatorController(CalculatorModel model, CalculatorView view) {
		this.model = model;
		this.view = view;
		
		for (Button b : view.digits) {
			b.setOnAction(this);
		}
		view.plus.setOnAction(this);
		view.clear.setOnAction(this);
		view.equalto.setOnAction(this);
		view.minus.setOnAction(this);
	}

@Override
public void handle(ActionEvent event) {
	Button btn = (Button) event.getSource();
	
	if (btn == view.clear) {
		view.txt.setText("");
	}
	else if (btn == view.equalto) {
		String result = model.calculate(view.txt.getText());
		view.txt.setText(result);
	}else { 
		view.txt.setText(view.txt.getText() + btn.getText());
	}
}
}
