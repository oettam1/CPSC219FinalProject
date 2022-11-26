package application;

public class Calculations {
	
		private double weight = 0.0;
		private double height = 0.0;
		private double goalWeight = 0.0;
		private double goalTime = 1.0;
		private double averageCalories = 2000.0;
		private double BMI;
		private double BMR;
		
		private String goal;
		private String sex;
		private String activityLevel;		
		
		private int age = 0;		
		private int calories;
		private int proteinAmount;
		private int carbsAmount;
		private int fatAmount;
		
		Calculations(double aWeight, double aHeight, int aAge, String aSex, String aActivityLevel, String aGoal){
		}
		
		public double getWeight() {
			return weight;
		}
		
		public void setWeight(double weightSet) {
			this.weight = weightSet;
		}
		
		public double getHeight() {
			return height;
		}
		
		public void setHeight(double heightSet) {
			this.height = heightSet;
		}

		public int getAge() {
			return age;
		}
		
		public void setAge(int ageSet) {
			this.age = ageSet;
		}

		public String getSex() {
			return sex;
		}
		
		public void setSex(String sexSet) {
			this.sex = sexSet;
		}

		public String getActivityLevel() {
			return activityLevel;
		}
		
		public void setActivityLevel(String activityLevelSet) {
			this.activityLevel = activityLevelSet;
		}

		public String getGoal() {
			return goal;
			}
		
		public void setGoal(String goalSet) {
			this.goal = goalSet;
			}
		
		public double getGoalWeight() {
			return goalWeight;
		}
		
		public void setGoalWeight(double goalWeightSet) {
			this.goalWeight = goalWeightSet;
		}
		
		public int getProteinAmount() {
			return proteinAmount;
		}
		
		public void setProteinAmount(int setProtein) {
			this.proteinAmount = setProtein;
		}

		public int getCarbsAmount() {
			return carbsAmount;
		}
		
		public void setCarbsAmount(int setCarbs) {
			this.carbsAmount = setCarbs;
		}

		public int getFatAmount() {
			return fatAmount;
		}
		
		public void setFatAmount(int setFat) {
			this.fatAmount = setFat;
		}
		
		public double getGoalTime() {
			return goalTime;
		}
		
		public void setGoalTime(double goalTimeSet) {
			this.goalTime = goalTimeSet;
		}
		
		public double getAverageCalories() {
			return averageCalories;
		}
		
		public void setAverageCalories(double averageCaloriesSet) {
			this.averageCalories = averageCaloriesSet;
		}

		public int getCalories() {
			return calories;
		}
		
		public void setCalories(int calorieSet) {
			this.calories = calorieSet;
		}
		
		double getBMI() {
			return BMI;
		}

		void setBMI(double bMI) {
			BMI = bMI;
		}

		double getBMR() {
			return BMR;
		}

		void setBMR(double bMR) {
			BMR = bMR;
		}
		
		//Calculate BMI Simple Calculation
		public double calculateBMI() {
			this.setBMI(Math.round((getWeight() / getHeight() / getHeight() * 10000.0) * 100.0) / 100.0);
			return getBMI();
		}
		
		//Calculate BMR
		public double calculateBMR() {
			
			if (getSex().equals("Male")) {
				setBMR(Math.round(((10 * getWeight()) + (6.25 * getHeight()) - (5* getAge()) + 5) * 100.0) / 100.0);
				} 
			else {
				setBMR(Math.round((10 * getWeight()) + (6.25 * getHeight()) - (5 * getAge()) - 161) * 100.0 / 100.0);
				}
			return getBMR();
		}
		
		// Goals factors
		private int goalDifference(String aGoal) {
			if(aGoal.equals("loss")) return -250;
			else if(aGoal.equals("quick loss")) return -500;
			else if(aGoal.equals("maintain")) return 0;
			else if(aGoal.equals("gain")) return 250;
			else if(aGoal.equals("quick gain")) return 500;
			else return 0;
		}		
		
		// Calorie Calculations
		 public int calculateCalories() {
			double maintenance = 0;
			double activityFactor = 0;
			int goalFactor = 0;
			 
			if(getSex().equals("Male") ) {
				maintenance = Math.ceil((10 * getWeight()) + (6.25 * getHeight()) - (5 * getAge()) + 5);
			}
			else if(getSex().equals("Female")) {
				maintenance = Math.ceil((10 * getWeight()) + (6.25 * getHeight()) - (5 * getAge()) - 165);
			
				}			
				
			if(getActivityLevel().equals("None")) {
				activityFactor = 1.2;
				goalFactor = goalDifference(getGoal());
			}
			else if(getActivityLevel().equals("Low")) {
				activityFactor = 1.375;
				goalFactor = goalDifference(getGoal());
			}
			else if(getActivityLevel().equals("Moderate")) {
				activityFactor = 1.55;
				goalFactor = goalDifference(getGoal());
			}
			else if(getActivityLevel().equals("Active")) {
				activityFactor = 1.725;
				goalFactor = goalDifference(getGoal());
			}
			else if(getActivityLevel().equals("Very Active")) {
				activityFactor = 1.9;
				goalFactor = goalDifference(getGoal());
			}
				
			setCalories((int)(maintenance * activityFactor + goalFactor));
				
			return getCalories();		
		}
		 
		// Macro Calculation
		public void calculateMacros() {
			if(getGoal().equals("loss")) {
				setFatAmount((int) ((getCalories() * 0.20) / 9)) ;
				setCarbsAmount((int)(getCalories() * 0.55) / 4);
				setProteinAmount((int)(getCalories() * 0.25) / 4);
			}
			
			else if(getGoal().equals("quick loss")) {
				setFatAmount((int)(getCalories() * 0.25) / 9);
				setCarbsAmount((int)(getCalories() * 0.45) / 4);
				setProteinAmount((int)(getCalories() * 0.30) / 4);
			}
			
			else if(getGoal().equals("maintain")) {
				setFatAmount((int)(getCalories() * 0.25) / 9);
				setCarbsAmount((int)(getCalories() * 0.50) / 4);
				setProteinAmount((int)(getCalories() * 0.25) / 4);
			}
			
			else if(getGoal().equals("gain")) {
				setFatAmount((int)(getCalories() * 0.25) / 9);
				setCarbsAmount((int)(getCalories() * 0.45) / 4);
				setCarbsAmount((int)(getCalories() * 0.30) / 4);
			}
			
			else if(getGoal().equals("quick gain")) {
				setFatAmount((int)(getCalories() * 0.20) / 9);
				setFatAmount((int)(getCalories() * 0.45) / 4);
				setFatAmount((int)(getCalories() * 0.35) / 4);
			}
		}

							
}
