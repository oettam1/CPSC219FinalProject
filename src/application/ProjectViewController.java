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
    
    //Changes calculations and labels to imperial when button is clicked
    @FXML
    void imperialButtonClicked(ActionEvent event) {
    	isMetricUnit = false;
    	heightUnitLabel.setText("inches");
    	weightUnitLabel.setText("lbs");
    	goalUnitLabel.setText("lbs");
    }

    //Changes calculations and labels to metric when button is clicked
    @FXML
    void metricButtonClicked(ActionEvent event) {
    	isMetricUnit = true;
    	heightUnitLabel.setText("cm");
    	weightUnitLabel.setText("kg");
    	goalUnitLabel.setText("kg");
    }

    //Clears all entries when the button is clicked
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
    
    //Checks all inputs are valid and changes scene when button is clicked
    @FXML
    void enterButtonClicked(ActionEvent event) throws Exception {
		
		boolean valid = false;

    	try {
    		while (valid != true) {
    			
    			//Checks if the sexChoice box input is valid
    			if (sexChoiceBox.getSelectionModel().getSelectedIndex() ==-1 ||
    					sexChoiceBox.getSelectionModel().getSelectedIndex() == 0 ||
    					sexChoiceBox.getSelectionModel().getSelectedIndex() == 1) 	
    			{
    				emptyPerson.setSex(sexChoiceBox.getSelectionModel().getSelectedItem());
    				System.out.println(emptyPerson.getSex());
    				valid = true;
	    		} 
	    	
    			else {
    				valid = false;
	    		}
	    	
    			//Checks if the age text field is valid
    			if (ageTextField.getText().length() > 0 && isInt(ageTextField.getText()) == true &&
	    			ageTextField.getText().contains("-") == false) { 
    				emptyPerson.setAge(Integer.parseInt(ageTextField.getText()));
    				valid = true;
    			} 
	    	
    			else {
    				valid = false;
    				ageTextField.setText(null);
    			}
	    	
    			//Checks if the height text field is valid
    			if (heightTextField.getText().length() > 0 && isDouble(heightTextField.getText()) == true &&
    					heightTextField.getText().contains("-") == false) { 
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
    				heightTextField.setText(null);
    			}
	    	
    			//Checks if weight text field is valid
    			if (weightTextField.getText().length() > 0 && isDouble(weightTextField.getText()) == true &&
    					weightTextField.getText().contains("-") == false) { 
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
    				weightTextField.setText(null);
    			}
	    	
    			//Checks if the goal text field is valid
    			if (goalTextField.getText().length() > 0 && isDouble(goalTextField.getText()) == true &&
    					goalTextField.getText().contains("-") == false) { 
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
    				goalTextField.setText(null);
    			}
	    	
    			//Checks if the timeTextField is valid
    			if (timeTextField.getText().length() > 0 && isDouble(timeTextField.getText()) == true &&
    					timeTextField.getText().contains("-") == false) { //this does your time
	   		 		emptyPerson.setGoalTime(Double.parseDouble(timeTextField.getText())); 
	   		 		valid = true;
    			} 
    			else {
    				valid = false;
    				timeTextField.setText(null);
    			}
	    	
    			//Checks if the average text field is valid
    			if (averageTextField.getText().length() > 0 && isDouble(averageTextField.getText()) == true &&
    					averageTextField.getText().contains("-") == false) { //this does your time
	   		 		emptyPerson.setAverageCalories(Double.parseDouble(averageTextField.getText()));	   		 	
    			} 
    			else {
    				emptyPerson.setAverageCalories(2000.0d);
    				averageTextField.setText(null);
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
    			System.out.println("Testiong");
    			valid = false;
    		}
    		
    		//Checks where the persons entered weight loss goal should fall
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
    		
    		//If everything is valid calculate the results and display them to the user
    		if(valid){
    			emptyPerson.calculateCalories();
    			emptyPerson.calculateMacros();
    			Application DisplayResults = new DisplayResults(emptyPerson.calculateCalories(),emptyPerson.calculateBMI(),
    					emptyPerson.calculateBMR(), emptyPerson.getProteinAmount(),emptyPerson.getCarbsAmount(),emptyPerson.getFatAmount());
    			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    			DisplayResults.start(window);   		
    	
    		}
    		else {
    			validLabel.setText("please enter all required information");
    		}
    	}
    
    /**
     * 
     * @param input
     * @return
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
     * 
     * @param input
     * @return
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
