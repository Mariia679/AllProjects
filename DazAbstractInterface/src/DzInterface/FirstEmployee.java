package DzInterface;

public class FirstEmployee implements Salary {

	private double wageRate;
	
	private int hour;

	public double getWageRate() {
		return wageRate;
	}

	public void setWageRate(double wageRate) {
		this.wageRate = wageRate;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public double salary() {
		return this.wageRate*this.hour;
	}

}
