package week9.DataStructures;

import java.util.HashSet;
import java.util.TreeSet;

import javafx.application.Application;
import javafx.stage.Stage;
//=======================================================================================
/*The program has been extended to add Treeset and Hashset. Please also note you need to select an object from the list given to get result of speed in finding an object*/

//======================================================================

// These programs are extended as per as the question
public class ListTesting extends Application {
	private ListTestingView view;
    private ListTestingController controller;
    private ListTestingModel model;

	@Override
	public void start(Stage stage) throws Exception {
		model = new ListTestingModel();
        view = new ListTestingView(stage, model);
        controller = new ListTestingController(model, view);
        
        view.start();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
