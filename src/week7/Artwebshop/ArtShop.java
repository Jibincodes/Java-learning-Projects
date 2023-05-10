package week7.Artwebshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ArtShop extends Application {
	private Stage stage;
	private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
    private ObservableList<Product> productObservableList = FXCollections.observableArrayList();
    private ListView<Transaction> transactionListView = new ListView<>();
    private ListView<Customer> customerListView;
    private ListView<Product> productListView;


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		customers.add(new Customer("John ", "john23@gmail.com", "Seestrasse 201", "0782269315"));
        customers.add(new Customer(" Smith", "smith@yahoo.com", "Newyork Main 123", "0782269324"));
        products.add(new Painting("Painting 1", "Artist 1- Mike", 50, "Oil"));
        products.add(new Painting("Painting 2", "Artist 2- Johnny", 100, "Watercolor"));
        products.add(new Sculpture("Sculpture 1", "Artist 3- Luke", 200, "Marble"));

        // Creating the labels required
        Label customerLabel = new Label("Customers");
        customerListView = new ListView<>(customerObservableList);
        customerListView.setPrefWidth(200);
        customerListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //making them visible in the interface
        customerObservableList.addAll(customers);
        productObservableList.addAll(products);
        //===========================================
        Button addCustomerButton = new Button("Add Customer");
        Button deleteCustomerButton = new Button("Delete Customer");
        addCustomerButton.setOnAction(e -> addCustomer());
        deleteCustomerButton.setOnAction(e -> deleteCustomer(customerListView.getSelectionModel().getSelectedItem()));
        //======================================
        Label productLabel = new Label("Products");
        productListView = new ListView<>(productObservableList);
        productListView.setPrefWidth(200);
        productListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button addProductButton = new Button("Add Product");
        Button deleteProductButton = new Button("Delete Product");
        addProductButton.setOnAction(e -> addProduct());
        deleteProductButton.setOnAction(e -> deleteProduct(productListView.getSelectionModel().getSelectedItem()));

        Label transactionLabel = new Label("Transactions");
        transactionListView.setPrefWidth(400);
        Button makeTransactionButton = new Button("Make Transaction");
        makeTransactionButton.setOnAction(e -> makeTransaction());

        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(customerLabel, 0, 0);
        gridPane.add(customerListView, 0, 1);
        gridPane.add(addCustomerButton, 0, 2);
        gridPane.add(deleteCustomerButton, 0, 3);

        gridPane.add(productLabel, 1, 0);
        gridPane.add(productListView, 1, 1);
        gridPane.add(addProductButton, 1, 2);
        gridPane.add(deleteProductButton, 1, 3);

        gridPane.add(transactionLabel, 2, 0);
        gridPane.add(transactionListView, 2, 1, 1, 3);
        gridPane.add(makeTransactionButton, 2, 4);
        
        Scene scene = new Scene(gridPane, 800, 400);
        stage.setTitle("Art Shop");
        stage.setScene(scene);
        stage.show();


	}

	public static void main(String[] args) {
		launch(args);

	}
	private void addProduct() {
		// This is just done manually here because the focus is on inheritance rather than the logical implementation. This can be easily done via input fields or dialog
	    Product newProduct = new Product("New Product", "New Artist", 0);

	    
	    products.add(newProduct);
	    productObservableList.add(newProduct);
	}

	private void deleteProduct(Product selectedProduct) {
	    if (selectedProduct != null) {
	       
	        products.remove(selectedProduct);
	        productObservableList.remove(selectedProduct);      
	    }
	}
	
	private void addCustomer() {
	    // I could have used the dialog
	    // manually done just to demonstrate the process
		// This  is usually done uping input infiedls but here the focus is on inheritance, so i just did it manually
	    Customer newCustomer = new Customer("New Customer", "newcustomer@example.com", "Address", "Phone");
	    customers.add(newCustomer);
	    customerObservableList.add(newCustomer);
	}

	
	private void deleteCustomer(Customer selectedCustomer) {
	    if (selectedCustomer != null) {
	        customers.remove(selectedCustomer);
	        customerObservableList.remove(selectedCustomer);
	    }
	}
	
	private void makeTransaction() {
	    
		Customer selectedCustomer = customerListView.getSelectionModel().getSelectedItem();
	    Product selectedProduct = productListView.getSelectionModel().getSelectedItem();

	    if (selectedCustomer == null || selectedProduct == null) {
	        showAlert(Alert.AlertType.ERROR, "Error", "Customer and Product Selection",
	                "Please select a customer and a product.");
	        return;
	    }
	    ChoiceDialog<Integer> quantityDialog = new ChoiceDialog<>(1);
	    quantityDialog.setTitle("Make Transaction");
	    quantityDialog.setHeaderText("Enter the quantity");

	    quantityDialog.setContentText("Quantity:");
	    quantityDialog.getItems().addAll(1, 2, 3, 4, 5); // Adding available quantity options

	    
	    quantityDialog.showAndWait().ifPresent(quantity -> {
	        double totalPrice = selectedProduct.getPrice() * quantity;

	        // Confirmation of the transaction with the user
	        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
	        confirmationAlert.setTitle("Make Transaction");
	        confirmationAlert.setHeaderText("Confirm Transaction");
	        confirmationAlert.setContentText("Customer: " + selectedCustomer.getName() + "\n"
	                + "Product: " + selectedProduct.getName() + "\n"
	                + "Quantity: " + quantity + "\n"
	                + "Total Price: $" + decimalFormat.format(totalPrice) + "\n"
	                + "Proceed with the transaction?");

	        confirmationAlert.showAndWait().ifPresent(response -> {
	            if (response == ButtonType.OK) {
	              
	                Transaction transaction = new Transaction(selectedCustomer, selectedProduct, quantity, totalPrice);
	                transactions.add(transaction);
	                transactionListView.getItems().add(transaction);

	                showAlert(Alert.AlertType.INFORMATION, "Transaction Successful",
	                        "Transaction completed successfully.",
	                       "Transaction Details: "+ transaction.getId());
	            }
	        });
	    });
	}
	protected void showAlert(Alert.AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
	



}
