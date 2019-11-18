/**
 * This class stores a score computed from the assessor class.
 * @author James Campion
 * @version 1.0
 */
public class InsuranceScore {
	String first, last, risk;
	int score;
	
	/**
	 * Default constructor.
	 */
    public InsuranceScore() {
        first = "";
        last = "";
        score = 0;
        setRisk(0);
    }
    
    /**
     * Constructor with provided values.
     * @param first First name of individual.
     * @param last Last name of individual.
     * @param score Their insurance score calculated from assessor class.
     */
    public InsuranceScore(String first, String last, int score) {
        setFirst(first);
        setLast(last);
        setScore(score);
        setRisk(score);
    }
    
    /**
	 * This puts the user into a risk bracket based on score.
	 * @param score Takes in score of the user.
	 */
	public void setRisk(int score) {
		if (score <= 20) {
			this.risk = "low risk";
		}
		else if (score <= 50) {
			this.risk = "moderate risk";
		}
		else if (score <= 75) {
			this.risk = "high risk";
		}
		else {
			this.risk = "uninsurable";
		}
	}
    
    /**
     * Override the toString function to properly print these scores.
     */
    @Override
    public String toString() { 
    	return String.format("Name:  %s, %s\nScore:  %d\nVerdict:  %s",
    			last, first, score, risk);
    }
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	
	public String getRisk() {
		return risk;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
