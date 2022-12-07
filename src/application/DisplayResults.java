package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DisplayResults extends Application {
	
	String calorieText;
	String bmiText;
	String bmrText;
	String carbsText;
	String proteinText;
	String fatsText;
	int proteins;
	int carbs;
	int fats;

	/**
	 * @param calculateCalories
	 * @param calculateBMI
	 * @param calculateBMR
	 * @param proteinAmount
	 * @param carbsAmount
	 * @param fatAmount
	 */
	public DisplayResults(int calculateCalories, double calculateBMI, double calculateBMR, int proteinAmount, int carbsAmount, int fatAmount) {
		calorieText = String.valueOf(calculateCalories);
		bmiText = String.valueOf(calculateBMI);
		bmrText = String.valueOf(calculateBMR);
		carbsText = String.valueOf(carbsAmount);
		proteinText = String.valueOf(proteinAmount);
		fatsText = String.valueOf(fatAmount);
		
		this.proteins = proteinAmount;
		this.carbs = carbsAmount;
		this.fats = fatAmount;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();		
		
		VBox goalsVBox = new VBox();
		
		//Setting all the labels to their calculated values
		Label calorieGoal = new Label("Your daily calorie goal is : " +  calorieText);
		Label carbohydrateGoal = new Label("Your daily carbohydrate goal is: " +  carbsText + "g");
		Label proteinGoal = new Label("Your daily protein goal is: " +  proteinText + "g");
		Label fatsGoal = new Label("Your daily fat goal is: " +  fatsText + "g");
		Label BMI = new Label("Your BMI is: " + bmiText);
		Label BMR = new Label("Your BMR is: " + bmrText);
		
		goalsVBox.setAlignment(Pos.CENTER_LEFT);
		goalsVBox.setSpacing(20);
		
		//Adding all the labels into the VBox
		goalsVBox.getChildren().add(calorieGoal);
		goalsVBox.getChildren().add(carbohydrateGoal);
		goalsVBox.getChildren().add(proteinGoal);
		goalsVBox.getChildren().add(fatsGoal);
		goalsVBox.getChildren().add(BMI);
		goalsVBox.getChildren().add(BMR);
		
		//Creating return button
		Button returnButton = new Button("return");
		returnButton.setOnAction(new ReturnButtonHandler());
		
		goalsVBox.getChildren().add(returnButton);
		
		//Creating Pie Chart
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList(
				new PieChart.Data("Carbs", carbs),
				new PieChart.Data("Protien", proteins),
				new PieChart.Data("Fats", fats));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Macronutrients");
		
		
		HBox chartBox = new HBox();
		
		chartBox.getChildren().add(chart);
		chartBox.getChildren().add(goalsVBox);
		
		
		root.getChildren().add(chartBox);		
		
		Scene scene = new Scene(root, 700, 400);		
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
