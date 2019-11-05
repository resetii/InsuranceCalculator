public class InsuranceScore {
	String first, last, risk;
	int score;
	
	// default constructor
    public InsuranceScore() {
        first = "";
        last = "";
        score = 0;
        setRisk(0);
    }
    
    // constructor with values
    public InsuranceScore(String first, String last, int score) {
        setFirst(first);
        setLast(last);
        setScore(score);
        setRisk(score);
    }
    
    // print in favorable string format
    @Override
    public String toString() { 
    	return String.format("Name:            %s, %s\nScore:                     %d\nVerdict:            %s",
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
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
