package week9.DataStructures;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import week9.DataStructures.ListTestingModel.COLLECTION_TYPES;

import week9.DataStructures.ListTestingModel.WHERE_CHOICES;;

public class ListTestingView {
	private Stage stage;
	private ListTestingModel model;
	//---------------------------------
	private ListView<SampleData> listView;
    private TextField txtSelectedObject;
    
    // new change
    private ObservableList<SampleData> data;
    
    //---------------

	protected final Integer[] DATA_AMOUNTS = {10000,30000,100000,300000,1000000};

	private Label lblNumElements = new Label("Amount of data");
	protected ComboBox<Integer> cmbNumElements = new ComboBox<>();
	private Label lblListType = new Label("List type");
	protected ComboBox<COLLECTION_TYPES> cmbListType = new ComboBox<>();
	private Label lblWhereToAdd = new Label("Add elements at");
	protected ComboBox<WHERE_CHOICES> cmbWhere = new ComboBox<>();
	protected Button btnGo = new Button("Run test");
	protected Button btnGo1 = new Button("Run Find test");
	protected Label lblResult = new Label();
	protected Label lblResult1 = new Label();
	
	
	public ListTestingView(Stage stage, ListTestingModel model) {
		this.stage = stage;
		this.model = model;
		//------
		listView = new ListView<>();
	    txtSelectedObject = new TextField();
	    listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	    listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtSelectedObject.setText(newValue.toString());
            } else {
                txtSelectedObject.setText("");
            }
        });
	    //--------
		cmbNumElements.getItems().setAll(DATA_AMOUNTS);
		cmbNumElements.setValue(DATA_AMOUNTS[0]);
		
		cmbListType.getItems().setAll(COLLECTION_TYPES.values());
		cmbListType.setValue(COLLECTION_TYPES.ArrayList);
		
		cmbWhere.getItems().setAll(WHERE_CHOICES.values());
		cmbWhere.setValue(WHERE_CHOICES.Start);
		
		GridPane grid = new GridPane();
		grid.addRow(0, lblNumElements, cmbNumElements);
		grid.addRow(1, lblListType, cmbListType);
		grid.addRow(2, lblWhereToAdd, cmbWhere);
		
		VBox root = new VBox();
        root.getChildren().addAll(grid, btnGo, btnGo1, lblResult, lblResult1, listView, txtSelectedObject);
        root.getStyleClass().add("vbox");

        Scene scene = new Scene(root);
		//scene.getStylesheets().add(
				//getClass().getResource("styles.css").toExternalForm());        
        stage.setScene(scene);
        stage.setTitle("List testing");
        
        //new change
        data = FXCollections.observableArrayList();
        generateSampleData(DATA_AMOUNTS[0]); // Generate sample data with default amount
        listView.setItems(data);
	}
	//--------------------------------
	public SampleData getSelectedObject() {
        return listView.getSelectionModel().getSelectedItem();
    }
	//public void populateListView(ObservableList<SampleData> data) {
     //   listView.setItems(data);
   // }
	public void generateSampleData(int amount) {
	    data.clear(); // Clear the existing data

	    //for (String firstName : SampleData.FIRSTNAMES) {
	       // SampleData sample = new SampleData();
	       // sample.setName(firstName);
	       // data.add(sample);
	  //  }
	    for (int i = 0; i < amount; i++) {
	        SampleData sample = new SampleData();
	        data.add(sample);
	    }
	}
	/*public void generateSampleData(int amount) {
	    data.clear(); // Clear the existing data

	    for (int i = 0; i < amount; i++) {
	        SampleData sample = new SampleData();
	        String firstName = SampleData.FIRSTNAMES[i % SampleData.FIRSTNAMES.length];
	        sample.setName(firstName);
	        data.add(sample);
	    }

	    listView.setItems(data); // Set the updated data to the ListView
	}*/

    //----------------------------------------
	public void start() {
		stage.show();
	}

}
