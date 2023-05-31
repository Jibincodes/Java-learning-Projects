 package week3.MVC.pet;

import javafx.application.Application;
import javafx.stage.Stage;


public class Pet extends Application {
	private PetView view;
	private PetModel model;
	private PetController controller;
	
	@Override
	public void start(Stage stage) throws Exception {
		model = new PetModel();
		view = new PetView(stage, model);
		controller = new PetController(model, view);
		view.start();
	}
	

	public static void main(String[] args) {
		launch();

	}

}
