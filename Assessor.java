
public class Assessor {
	public static int assessScore(int age, int height, int weight, int bpSys, int bpDias, boolean cancer, boolean diabetes, boolean alz) {
		int counter = 0;
		double bmi;
		if ( age < 30) {
			counter = counter + 0;
		}
		else if (age < 45) {
			counter = counter + 10;
		}
		else if (age < 60) {
			counter = counter + 20;
		}
		else{
			counter = counter + 30;
		}
		
		// convert lbs inches to the bmi in appropriate units 
		bmi = (weight / (height*height)) * 703.0;
		
		// bmi is normal
		if ( bmi < 25 && bmi >= 18.5) {
			counter = counter + 0;
		}
		// bmi is overweight
		else if (bmi < 30 && bmi >= 25) {
			counter = counter + 30;
		}
		// bmi is obese or really low
		else{
			counter = counter + 75;
		}
		
		// BP is normal
		if (bpSys < 120 && bpDias < 80) {
			counter = counter + 0;
		}
		// BP elevated
		else if ((bpSys < 130 && bpSys >= 120) && (bpDias < 80)) {
			counter = counter + 15;
		}
		// BP Stage 1 
		else if ((bpSys < 140 && bpSys >= 130) || (bpDias >= 80 && bpDias < 90)) {
			counter = counter + 30;
		}
		// BP Stage 2 
		else if (bpSys < 180 || bpDias < 120) {
			counter = counter + 75;
		}
		// BP is in crisis
		else {
			counter = counter + 100;
		}
		
		if (cancer) {
			counter = counter + 10;
		}
		if (diabetes) {
			counter = counter + 10;
		}
		if (alz) {
			counter = counter + 10;
		}
		
		return counter;
	}
}
