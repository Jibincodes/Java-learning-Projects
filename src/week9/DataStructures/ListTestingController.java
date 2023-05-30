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
	    COLLECTION_TYPES collectionType = view.cmbListType.getValue();
	    WHERE_CHOICES whereChoice = view.cmbWhere.getValue();
	    SampleData selectedObject = view.getSelectedObject(); 

	    float runTime = model.runTest(amountOfData, collectionType, whereChoice);
	    view.lblResult.setText("Time: " + timeFormatter.format(runTime) + " seconds");

	    // Running the find test using the selected object
	    if (selectedObject != null) {
	        float findRunTime = model.runFindTest(amountOfData, collectionType, selectedObject);
	        view.lblResult1.setText("Find Time: " + timeFormatter.format(findRunTime) + " seconds");
	    }

	    // Trigger garbage collection
	    System.gc();
	}
}
