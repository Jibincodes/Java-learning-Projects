package week3.MVC.pet;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import week3.MVC.pet.Pet1.Gender;
import week3.MVC.pet.Pet1.Species;



public class PetView {
	private Stage stage;
	private PetModel model;
	
	// variables given in the slides
	TextField txtName = new TextField();
	ComboBox<Species> cmbSpecies = new ComboBox<>();
	ComboBox<Gender> cmbGender = new ComboBox<>();
	Label lblDataID = new Label();
	Label lblDataName = new Label();
	Label lblDataSpecies = new Label();
	Label lblDataGender = new Label();
	Button btnSave = new Button("Save");
	Button btnDelete = new Button("Delete");
	
	

	public PetView(Stage stage, PetModel model) {
		this.stage = stage;
		this.model = model;
		
		VBox root = new VBox();
		root.getChildren().add(createDataEntryPane());
		root.getChildren().add(createControlPane());
		root.getChildren().add(createDataDisplayPane());
		
		Scene scene = new Scene(root);
		stage.setTitle("Enter and display a pet");
		stage.setScene(scene);
		stage.show();
	}

	public void start() {
		stage.show();
		
	}
	private Pane createDataEntryPane()
	{
		GridPane pane = new GridPane();
		pane.setId("DataEntries");
		Label lbname = new Label("Name");
		Label lbspecies = new Label("Species");
		Label lbgender = new Label("Gender");
		
		cmbSpecies.getItems().addAll(Pet1.Species.values()); // remember pet1
		cmbSpecies.setValue(Species.DOG); 
		cmbGender.getItems().addAll(Pet1.Gender.values());
		cmbGender.setValue(Gender.FEMALE); 
		
		pane.add(lbname, 0, 0);		
		pane.add(txtName, 1, 0);
		pane.add(lbspecies, 0, 1);		
		pane.add(cmbSpecies, 1, 1);
		pane.add(lbgender, 0, 2);	
		pane.add(cmbGender, 1, 2);
		
		return pane;
		
	}
	private Pane createControlPane() 
	{
		GridPane pane = new GridPane();
		pane.setId("controlArea");
		pane.add(btnSave, 1, 0);
		pane.add(btnDelete, 0, 0);
		
		return pane;
	}
	private Pane createDataDisplayPane() 
	{
		GridPane pane = new GridPane();
		pane.setId("dataDisplay");
		
	    Label lbid = new Label("ID");
		Label lbname = new Label("Name");
		Label lbspecies = new Label("Species");
		Label lbgender = new Label("Gender");
		
		
	    pane.add(lbid, 0, 0); 
	    pane.add(lblDataID, 1, 0);
	    pane.add(lbname, 0, 1); 
	    pane.add(lblDataName, 1, 1);
	    pane.add(lbspecies, 0, 2); 
	    pane.add(lblDataSpecies, 1, 2);
	    pane.add(lbgender, 0, 3);
	    pane.add(lblDataGender, 1, 3);
	    
	    return pane;
	}

}
