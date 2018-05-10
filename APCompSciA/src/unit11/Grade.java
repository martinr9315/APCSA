package unit11;

public class Grade {
	private double value;
	//add in two constructors
	public Grade(double g) {
		setGrade(g);
	}
	public void setGrade(double g) {
		value = g;
	}
	public double getNumericGrade() {
		return value;
	}
	public String getLetterGrade() {
		if (value>=90)
			return "A";
		else if (value>=80)
			return "B";
		else if (value>=70)
			return "C";
		else if (value>=60)
			return "D";
		return "F";
	}
	
	public String toString()
	{
		String output = getNumericGrade() +"\n"+ getLetterGrade();
		return output;
	}

}
