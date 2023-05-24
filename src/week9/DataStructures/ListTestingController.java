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
	
	/*private void setUpTest(ActionEvent e) {
		// Get selections from View
		Integer amountOfData = view.cmbNumElements.getValue();
		COLLECTION_TYPES collectionType = view.cmbListType.getValue(); // here too
		WHERE_CHOICES whereChoice = view.cmbWhere.getValue();
		SampleData selectedObject = view.getSelectedObject();

		float runTime = model.runTest(amountOfData, collectionType, whereChoice);
		view.lblResult.setText("Time: " + timeFormatter.format(runTime) + " seconds");
		//runTime = model.runFindTest(amountOfData, collectionType);
		float runtime2 = model.runFindTest(amountOfData, collectionType, selectedObject);
		view.lblResult1.setText("Time: " + timeFormatter.format(runtime2) + " seconds");
		// Trigger garbage collection
		System.gc();
	}*/
	private void setUpTest(ActionEvent e) {
	    // Get selections from View
	    Integer amountOfData = view.cmbNumElements.getValue();
	    COLLECTION_TYPES collectionType = view.cmbListType.getValue();
	    WHERE_CHOICES whereChoice = view.cmbWhere.getValue();
	    SampleData selectedObject = view.getSelectedObject(); // Retrieve the selected object

	    float runTime = model.runTest(amountOfData, collectionType, whereChoice);
	    view.lblResult.setText("Time: " + timeFormatter.format(runTime) + " seconds");

	    // Run the find test using the selected object
	    if (selectedObject != null) {
	        float findRunTime = model.runFindTest(amountOfData, collectionType, selectedObject);
	        view.lblResult1.setText("Find Time: " + timeFormatter.format(findRunTime) + " seconds");
	    }

	    // Trigger garbage collection
	    System.gc();
	}
	/*private void setUpTest(ActionEvent e) {
	    // Get selections from View
	    int amountOfData = Integer.parseInt(view.cmbNumElements.getValue());
	    ListTestingModel.COLLECTION_TYPES collectionType = view.cmbListType.getValue();
	    ListTestingModel.WHERE_CHOICES whereChoice = view.cmbWhere.getValue();
	    SampleData selectedObject = view.getSelectedObject(); // Assuming there's a method to get the selected object from the view

	    float runTime = 0.0f;
	    if (view.rbAdd.isSelected()) {
	        runTime = model.runAddTest(amountOfData, collectionType, whereChoice);
	    } else if (view.rbFind.isSelected()) {
	        runTime = model.runFindTest(amountOfData, collectionType, selectedObject);
	    }

	    view.lblResult.setText("Time: " + timeFormatter.format(runTime) + " seconds");

	    // Trigger garbage collection
	    System.gc();
	}*/


}
