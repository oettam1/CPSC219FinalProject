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
    Calculations emptyPerson = new Calculations(0.0, 0.0, 20, "Male", "null", "empty");
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
		
		boolean valid = true;

    	try {
	    	if (sexChoiceBox.getSelectionModel().getSelectedIndex() ==-1 ||
	    		sexChoiceBox.getSelectionModel().getSelectedIndex() == 0 ||
	    		sexChoiceBox.getSelectionModel().getSelectedIndex() == 1) 	
	    	{
	    		emptyPerson.setSex(sexChoiceBox.getSelectionModel().getSelectedItem());
	    		System.out.println(emptyPerson.getSex());
	    		} 
	    	else {
	    		valid = false;
	    		}
	    	
	    	if (ageTextField.getText().length() > 0 && isInt(ageTextField.getText()) == true &&
	    			ageTextField.getText().contains("-") == false) { //this does your age
	    		emptyPerson.setAge(Integer.parseInt(ageTextField.getText()));
	    	} 
	    	else {
	    		valid = false;
	    		ageTextField.setText(null);
	    	}
	    	
	    	if (heightTextField.getText().length() > 0 && isDouble(heightTextField.getText()) == true &&
	    			heightTextField.getText().contains("-") == false) { //this does your height
	    		 if (isMetricUnit == true) {
	    			 emptyPerson.setHeight(Double.parseDouble(heightTextField.getText()));
	    		 } 
	    		 else {
	    			 emptyPerson.setHeight(Double.parseDouble(heightTextField.getText())* 2.54d);
	    		 }
	    	} 
	    	else {
	    		valid = false;
	    		heightTextField.setText(null);
	    	}
	    	
	    	if (weightTextField.getText().length() > 0 && isDouble(weightTextField.getText()) == true &&
	    			weightTextField.getText().contains("-") == false) { //this does your weight
	   		 	if (isMetricUnit == true) {
	   		 		emptyPerson.setWeight(Double.parseDouble(weightTextField.getText())); 
	   		 	} 
	   		 	else {
	   		 		emptyPerson.setWeight(Double.parseDouble(weightTextField.getText()) * 0.453d);
	   		 	}
	    	} 
	    	else {
	    		valid = false;
	    		weightTextField.setText(null);
	    	}
	    	
	    	if (goalTextField.getText().length() > 0 && isDouble(goalTextField.getText()) == true &&
	    			goalTextField.getText().contains("-") == false) { //this does your weight
	   		 	if (isMetricUnit == true) {
	   		 		emptyPerson.setGoalWeight(Double.parseDouble(goalTextField.getText()));
	   		 	} 
	   		 	else {
	   		 		emptyPerson.setGoalWeight(Double.parseDouble(goalTextField.getText())* 0.453d);
	   		 	}
	    	} 
	    	else {
	    		valid = false;
	    		goalTextField.setText(null);
	    	}
	    	
	    	if (timeTextField.getText().length() > 0 && isDouble(timeTextField.getText()) == true &&
	    			timeTextField.getText().contains("-") == false) { //this does your time
	   		 	emptyPerson.setGoalTime(Double.parseDouble(timeTextField.getText())); 
	    	} 
	    	else {
	    		valid = false;
	    		timeTextField.setText(null);
	    	}
	    	
	    	if (averageTextField.getText().length() > 0 && isDouble(averageTextField.getText()) == true &&
	    			averageTextField.getText().contains("-") == false) { //this does your time
	   		 	emptyPerson.setAverageCalories(Double.parseDouble(averageTextField.getText()));
	    	} 
	    	else {
	    		emptyPerson.setAverageCalories(2000.0d);
	    		averageTextField.setText(null);
	    	}
	 
	    	if (bodyTypeChoiceBox.getSelectionModel().getSelectedIndex() > -1) {
	    		emptyPerson.setActivityLevel(bodyTypeChoiceBox.getSelectionModel().getSelectedItem());
	    	} 
	    	else {
	    		emptyPerson.setActivityLevel("Moderate");
	    		}
    	}catch(NullPointerException npe) {
    		//PUT ERROR LABEL STUFF HERE
    	}
    	
    	if (emptyPerson.getWeight() > emptyPerson.getGoalWeight()) {
    		if (emptyPerson.getGoalTime() < 12) {
    			emptyPerson.setGoal("quick loss");
    			}
    		else{
    				emptyPerson.setGoal("loss");
    			}
    	} 
    	else if (emptyPerson.getWeight() < emptyPerson.getGoalWeight()) {
    		if (emptyPerson.getGoalTime() < 12) {
    			emptyPerson.setGoal("quick gain");
    			} 
    		else {
    			emptyPerson.setGoal("gain"); }
    			} 
    	else {
    			emptyPerson.setGoal("maintain");
    	}	
    	
    	if(valid){
    		emptyPerson.calculateCalories();
    		emptyPerson.calculateMacros();
    		Application DisplayResults = new DisplayResults(emptyPerson.calculateCalories(),emptyPerson.calculateBMI(),
    				emptyPerson.calculateBMR(), emptyPerson.getProteinAmount(),emptyPerson.getCarbsAmount(),emptyPerson.getFatAmount());
    		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		DisplayResults.start(window);   		
    	
    	}else {
    		validLabel.setText("please enter all required information");
    	}
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
