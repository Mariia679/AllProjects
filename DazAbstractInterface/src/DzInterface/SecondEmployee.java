package DzInterface;

public class SecondEmployee implements Salary {
	
	private static final double wageRate = 500;

	@Override
	public double salary() {
		return wageRate;
	}

}
