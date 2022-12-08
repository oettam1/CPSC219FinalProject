package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller Class that handles User Input and Button Click Actions
 * @author CS219-user
 *
 */
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
        
    //Empty person so we can add into the values calculated
    User emptyPerson = new User(0.0, 0.0, 20, "Male", "null", "empty");
    
    public boolean isMetricUnit = false;
        
    @FXML
    /**
     * Changes labels and variable so that Imperial is displayed and calculated
     * @param event Button Clicked
     */
    void imperialButtonClicked(ActionEvent event) {
    	isMetricUnit = false;
    	heightUnitLabel.setText("inches");
    	weightUnitLabel.setText("lbs");
    	goalUnitLabel.setText("lbs");
    }
   
    @FXML
    /**
     * Changes labels and variable so that Metric is displayed and calculated
     * @param event Button Clicked
     */
    void metricButtonClicked(ActionEvent event) {
    	isMetricUnit = true;
    	heightUnitLabel.setText("cm");
    	weightUnitLabel.setText("kg");
    	goalUnitLabel.setText("kg");
    }

    @FXML
    /**
     * Clear Button clicked, clears all information input by the user
     * @param event Button Clicked
     */
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
    /**
     * When the Enter button is clicked, verify info and pass that to the constructor
     * @param event when button is presses
     * @throws Exception Can throw errors if not all info is entered or invalid input is entered
     */
    void enterButtonClicked(ActionEvent event) throws Exception {
		
		boolean valid = false;

    	try {
    		while (valid != true) {
    			
    			//Checks if the sexChoice box input is valid    			
    			if (sexChoiceBox.getSelectionModel().getSelectedIndex() == 0 ||
    					sexChoiceBox.getSelectionModel().getSelectedIndex() == 1) 	
    			{
    				emptyPerson.setSex(sexChoiceBox.getSelectionModel().getSelectedItem());
    				// System.out.println(emptyPerson.getSex()); DeBugging
    				valid = true;
	    		} 
	    	
    			else {
    				valid = false;
    				validLabel.setText("Invalid Sex Input: No Chosen Sex");
    				break;
	    		}
	    	
    			//Checks if the age text field is valid
    			if (ageTextField.getText().length() > 0 && isInt(ageTextField.getText()) == true &&
	    			ageTextField.getText().contains("-") == false && valid == true) { 
    				emptyPerson.setAge(Integer.parseInt(ageTextField.getText()));
    				valid = true;
    			} 
	    	
    			else {
    				valid = false;
    				validLabel.setText("Invalid Age: '" + ageTextField.getText() + "' Only enter valid numbers.");
    				break;
    			}
	    	
    			//Checks if the height text field is valid
    			if (heightTextField.getText().length() > 0 && isDouble(heightTextField.getText()) == true &&
    					heightTextField.getText().contains("-") == false && valid == true) { 
    				//Changes calculations if it is metric or not
    				if (isMetricUnit == true) {
    					emptyPerson.setHeight(Double.parseDouble(heightTextField.getText()));
    				} 
    				else {
    					emptyPerson.setHeight(Double.parseDouble(heightTextField.getText())* 2.54d);
    				}
    				valid = true;
    			} 
    			else {
    				valid = false;
    				validLabel.setText("Invalid Height: '" + heightTextField.getText() + "' Only enter valid numbers.");
    				break;
    			}
	    	
    			//Checks if weight text field is valid
    			if (weightTextField.getText().length() > 0 && isDouble(weightTextField.getText()) == true &&
    					weightTextField.getText().contains("-") == false && valid == true) { 
    				//Changes calculations if it is metric or not
	   		 		if (isMetricUnit == true) {
	   		 			emptyPerson.setWeight(Double.parseDouble(weightTextField.getText())); 
	   		 		} 
	   		 		else {
	   		 			emptyPerson.setWeight(Double.parseDouble(weightTextField.getText()) * 0.453d);
	   		 		}	
	   		 		valid = true;
    			} 
    			else {
    				valid = false;
    				validLabel.setText("Invalid Weight: '" + weightTextField.getText() + "' Only enter valid numbers.");
    				break;
    			}
	    	
    			//Checks if the goal text field is valid
    			if (goalTextField.getText().length() > 0 && isDouble(goalTextField.getText()) == true &&
    					goalTextField.getText().contains("-") == false && valid == true) { 
    				//Changes calculations if it is metric or not and does weight 
	   		 		if (isMetricUnit == true) {
	   		 			emptyPerson.setGoalWeight(Double.parseDouble(goalTextField.getText()));
	   		 		} 
	   		 		else {
	   		 			emptyPerson.setGoalWeight(Double.parseDouble(goalTextField.getText())* 0.453d);
	   		 		}
	   		 		valid = true;
    			} 
    			else {
    				valid = false;
    				validLabel.setText("Invalid Goal: '" + goalTextField.getText() + "' Only enter valid numbers.");
    				break;
    			}
	    	
    			//Checks if the timeTextField is valid
    			if (timeTextField.getText().length() > 0 && isDouble(timeTextField.getText()) == true &&
    					timeTextField.getText().contains("-") == false && valid == true) { //this does your time
	   		 		emptyPerson.setGoalTime(Double.parseDouble(timeTextField.getText())); 
	   		 		valid = true;
    			} 
    			else {
    				valid = false;
    				validLabel.setText("Invalid Time: '" + timeTextField.getText() + "' Only enter valid numbers.");
    				break;
    			}
	    	
    			//Checks if the average text field is valid
    			if (averageTextField.getText().length() > 0 && isDouble(averageTextField.getText()) == true &&
    					averageTextField.getText().contains("-") == false) { //this does your time
	   		 		emptyPerson.setAverageCalories(Double.parseDouble(averageTextField.getText()));	   		 	
    			} 
    			else {
    				emptyPerson.setAverageCalories(2000.0d);
    			}
    			
    			//Checks if the body type choice box is valid
    			if (bodyTypeChoiceBox.getSelectionModel().getSelectedIndex() > -1) {
    				emptyPerson.setActivityLevel(bodyTypeChoiceBox.getSelectionModel().getSelectedItem());	    		
    			} 
    			else {
    				emptyPerson.setActivityLevel("Moderate");
	    		}	    	
    		}
    		
    		// If any errors occur, catch them here
    		}catch(NullPointerException npe) {
    			validLabel.setText("Entry is Invalid, only enter numbers. " + npe.getMessage() + ": Error Message");
    			valid = false;
    		}
    		
    		//If the entered weight is greater then goal weight, they want to lose weight
    		if (emptyPerson.getWeight() > emptyPerson.getGoalWeight()) {
    			//If time frame is less then 12, they want to lose weight quickly
    			if (emptyPerson.getGoalTime() < 12) {
    				emptyPerson.setGoal("quick loss");
    			}
    			else{
    				emptyPerson.setGoal("loss");
    			}
    		} 
    		//If the entered weight is less then goal weight, they want to gain weight
    		else if (emptyPerson.getWeight() < emptyPerson.getGoalWeight()) {
    			//If time frame is less then 12, they want to gain weight quickly
    			if (emptyPerson.getGoalTime() < 12) {
    				emptyPerson.setGoal("quick gain");
    			} 
    			else {
    				emptyPerson.setGoal("gain"); }
    			} 
    		else {
    			emptyPerson.setGoal("maintain");
    		}	
    		
    		//If everything is valid calculate the results and display them to the user
    		if(valid){
    			emptyPerson.calculateCalories();
    			emptyPerson.calculateMacros();
    			Application DisplayResults = new DisplayResults(emptyPerson.calculateCalories(),emptyPerson.calculateBMI(),
    					emptyPerson.calculateBMR(), emptyPerson.getProteinAmount(),emptyPerson.getCarbsAmount(),emptyPerson.getFatAmount());
    			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    			DisplayResults.start(window);   		
    	
    		}   		
    	}
    
    /**
     * Checks if input value is a Int
     * @param input value we want to check
     * @return true/false if value is Int or not
     */
    private boolean isInt(String input) {
		
	    boolean x = true;
	    try {
	        Integer.parseInt(input);
	    }catch (NumberFormatException e) {
	        x = false;
	    }
	    return x;
	}
    
    /**
     * Checks if input value is a double
     * @param input value we want to check
     * @return true/false if value is double or not
     */
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
