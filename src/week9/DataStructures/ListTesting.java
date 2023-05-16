package week9.DataStructures;

import java.util.HashSet;
import java.util.TreeSet;

import javafx.application.Application;
import javafx.stage.Stage;

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
		// just testing 
		/*HashSet<SampleData> hashSet = new HashSet<>();
        TreeSet<SampleData> treeSet = new TreeSet<>();

        SampleData data1 = new SampleData();
        SampleData data2 = new SampleData();

        hashSet.add(data1);
        hashSet.add(data2);

        treeSet.add(data1);
        treeSet.add(data2);

        System.out.println("HashSet size: " + hashSet.size()); // Output: 2
        System.out.println("TreeSet size: " + treeSet.size()); // Output: 2*/

	}

}
