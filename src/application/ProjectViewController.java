package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProjectViewController {
	
	@FXML
    private Label weightUnitLabel;

    @FXML
    private Button enterButton;

    @FXML
    private Label goalUnitLabel;

    @FXML
    private Button metricButton;

    @FXML
    private Label heightUnitLabel;

    @FXML
    private TextField timeTextField;

    @FXML
    private TextField goalTextField;

    @FXML
    private Label validLabel;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField weightTextField;

    @FXML
    private Button clearButton;

    @FXML
    private TextField averageTextField;

    @FXML
    private Button imperialButton;

    @FXML
    private TextField heightTextField;

    @FXML
    private ChoiceBox<String> bodyTypeChoiceBox;

    @FXML
    private ChoiceBox<String> sexChoiceBox;                
        
    //Changes the calculation and labels to metric or imperial
    public boolean isMetricUnit = false;
    
    @FXML
    void imperialButtonClicked(ActionEvent event) {
    	isMetricUnit = false;
    	heightUnitLabel.setText("inches");
    	weightUnitLabel.setText("lbs");
    	goalUnitLabel.setText("lbs");
    }

    @FXML
    void metricButtonClicked(ActionEvent event) {
    	isMetricUnit = true;
    	heightUnitLabel.setText("cm");
    	weightUnitLabel.setText("kg");
    	goalUnitLabel.setText("kg");
    }

    @FXML
    void clearButtonClicked(ActionEvent event) {
    	ageTextField.setText(null);
    	heightTextField.setText(null);
    	weightTextField.setText(null);
    	goalTextField.setText(null);
    	timeTextField.setText(null);
    	averageTextField.setText(null);
    	bodyTypeChoiceBox.getSelectionModel().select(-1);
    	sexChoiceBox.getSelectionModel().select(-1);
    }

    @FXML
    void enterButtonClicked(ActionEvent event) throws Exception {
		
    }
    
    private boolean isInt(String input) {
		
	    boolean x = true;
	    try {
	        Integer.parseInt(input);
	    }catch (NumberFormatException e) {
	        x = false;
	    }
	    return x;
	}
    
    private boolean isDouble(String input) {
	
    	boolean x = true;
    	try {
    		Double.parseDouble(input);
    	}catch (NumberFormatException e) {
    		x = false;
    	}
    	return x;
    }

}
