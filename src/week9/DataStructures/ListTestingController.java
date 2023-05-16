package week9.DataStructures;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import week9.DataStructures.ListTestingModel.COLLECTION_TYPES;
//import week9.DataStructures.ListTestingModel.LIST_TYPES;
import week9.DataStructures.ListTestingModel.WHERE_CHOICES;;

public class ListTestingController {
	private ListTestingModel model;
	private ListTestingView view;

	private final DecimalFormat timeFormatter = new DecimalFormat("0.000");
	
	public ListTestingController(ListTestingModel model, ListTestingView view) {
		this.model = model;
		this.view = view;
		
		view.btnGo.setOnAction(this::setUpTest);
	}
	
	private void setUpTest(ActionEvent e) {
		// Get selections from View
		Integer amountOfData = view.cmbNumElements.getValue();
		COLLECTION_TYPES collectionType = view.cmbListType.getValue(); // here too
		WHERE_CHOICES whereChoice = view.cmbWhere.getValue();

		float runTime = model.runTest(amountOfData, collectionType, whereChoice);
		
		view.lblResult.setText("Time: " + timeFormatter.format(runTime) + " seconds");
		
		// Trigger garbage collection
		System.gc();
	}

}