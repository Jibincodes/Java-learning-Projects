package week12.jUnittesting;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class WebValidator_View {
    private WebValidator_Model model;
    private Stage stage;

    protected Label lblIpAddress = new Label("Web address:");
    protected TextField txtIpAddress = new TextField();
    protected Label lblPort = new Label("Port:");
    protected TextField txtPort = new TextField();
    protected Button btnConnect = new Button("Connect");

    protected WebValidator_View(Stage stage, WebValidator_Model model) {
        this.stage = stage;
        this.model = model;
        
        stage.setTitle("Web Address Validator");
        
        HBox root = new HBox();
        Region spacer1 = new Region();
        Region spacer2 = new Region();
        root.getChildren().addAll(lblIpAddress, txtIpAddress, spacer1, lblPort, txtPort, spacer2, btnConnect);

        Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("WebValidator.css").toExternalForm());    
        stage.setScene(scene);;
    }
    
    public void start() {
        stage.show();
    }
    
    /**
     * Getter for the stage, so that the controller can access window events
     */
    public Stage getStage() {
        return stage;
    }
}