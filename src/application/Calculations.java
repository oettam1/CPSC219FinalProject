package application;

public class Calculations {
	
		private double weight = 0.0;
		private double height = 0.0;
		private double goalWeight = 0.0;
		private double goalTime = 1.0;
		private double averageCalories = 2500.0;
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
		
		public int getProtein() {
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
			this.carbsAmount = setFat;
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
		
		public void setCalories(double calorieSet) {
			this.averageCalories = calorieSet;
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
			this.setBMI(getWeight() / getHeight() / getHeight() * 10000.0);
			return getBMI();
		}
		
		//Calculate BMR
		public double calculateBMR() {
			
			if (getSex() == "M") {
				setBMR((10 * getWeight()) + (6.25 * getHeight()) - (5* getAge()) + 5);
			} else {
				setBMR((10 * getWeight()) + (6.25 * getHeight()) - (5 * getAge()) - 161);
			}
			return getBMR();
		}
		
		
		private int goalDifference(String aGoal) {
			return 0;
		}		
		
		 public int calculateCalories() {
			return 0;			
		}
		 
		public void calculateMacros() {
			
		}

							
}
