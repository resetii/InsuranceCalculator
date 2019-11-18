import java.io.Serializable;

/**
 * This is a class called Member that defines the data pertaining to the medical history of an individual. 
 * @author James Campion
 * @version 1.0
 */
public class Member implements Serializable {
	int age, height, weight, bpSys, bpDias;
	boolean cancer, diabetes, alz;
	String first, last;
	InsuranceScore myScore;

	/**
	 * Default constructor, sets everything to 0, "", or false. 
	 */
    public Member() {
        first = "";
    	last = "";
    	age = 0;
        height = 0;
        weight = 0;
        bpSys = 0;
        bpDias = 0;
        cancer = false;
        diabetes = false;
        alz = false;
    }
    
    /**
     * This constructs a member with specified values for each parameter. 
     * @param first The first name of the person. 
     * @param last The last name of the person.
     * @param age The age of the person.
     * @param height The height of the person.
     * @param weight The weight of the person.
     * @param bpSys The systolic blood pressure of the person.
     * @param bpDias The diastolic blood pressure of the person.
     * @param cancer Does this user have a history of cancer in the family?
     * @param diabetes Does this user have a history of diabetes in the family?
     * @param alz Does this user have a history of alzheimer's in the family?
     */
    public Member(String first, String last, int age, int height, int weight, int bpSys, int bpDias, boolean cancer, boolean diabetes, boolean alz) {
        setAge(age);
        setHeight(height);
        setWeight(weight);
        setSys(bpSys);
        setDias(bpDias);
        setCancer(cancer);
        setDiabetes(diabetes);
        setAlz(alz);
        setFirst(first);
        setLast(last);
    }
	
    /**
     * Overrides Java's toString function to be able to print members in desired format
     * @return a formatted list of all data for that member
     * @see java.lang.Object.toString
     */
    @Override
    public String toString() { 
    	String can, dia, al;
    	if (cancer) {can="y";} else {can="n";}
    	if (diabetes) {dia="y";} else {dia="n";}
    	if (alz) {al="y";} else {al="n";}

    	return String.format("%s, %s\nAge           %d\nHeight        %d in\nWeight       %d lbs\nBP Syst       %d\nBP Dias       %d\nCancer         %s\nDiabetes       %s\nAlzheimers     %s",
    			last,first,age,height,weight,bpSys,bpDias,can,dia,al);
    }
    
    /**
     * This function uses the Assessor class to assign an object of type InsuranceScore to this member.
     */
    public void assessment() {
    	int temp = Assessor.assessScore(age, height, weight, bpSys, bpDias, cancer, diabetes, alz);
    	myScore = new InsuranceScore(first, last, temp);
    }
	
    /**
     * @return Age of member.
     */
	public int getAge() {
        return age;
    }
	/**
	 * @param age Sets age.
	 */
    public void setAge(int age) {
        this.age = age;
    }
    // height of user as int
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    // weight of user as int
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    // systolic blood pressure as int
    public int getSys() {
        return bpSys;
    }
    public void setSys(int bpSys) {
        this.bpSys = bpSys;
    }
    // diastolic blood pressure
    public int getDias() {
        return bpDias;
    }
    public void setDias(int bpDias) {
        this.bpDias = bpDias;
    }
    // cancer yes or no
    public boolean getCancer() {
        return cancer;
    }
    public void setCancer(boolean cancer) {
        this.cancer = cancer;
    }
    // diabetes yes or no
    public boolean getDiabetes() {
        return diabetes;
    }
    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }
    // alzheimers yes or no
    public boolean getAlz() {
        return alz;
    }
    public void setAlz(boolean alz) {
        this.alz = alz;
    }
    // first name
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}
	// last name
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	// Insurance Score via Assessor class
	public InsuranceScore getMyScore() {
		return myScore;
	}
	public void setMyScore(InsuranceScore myScore) {
		this.myScore = myScore;
	}

}
