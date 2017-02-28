package MyMath;

public class MyMath {

	public static final double numberPi = 3.14;

	public static final int numberPlus = 5;

	public static final int numberMultiply = 50;
	
	public static final int numberMinus = 250;
	
	public static final int multiply = 2;

	public static double involution(double numberRaised, int involute) {
		double numberInvolution = 1;
		for (int i = 0; i < involute; i++) {
			numberInvolution *= numberRaised;
		}
		return numberInvolution;
	}

	public static double divideByPi(double dividedNumber) {
		return dividedNumber / numberPi;
	}

	public static double dividedPi(double divideNumber) {
		return numberPi / divideNumber;
	}
	public static double multiplyPi(double multiplyedNumber) {
		return numberPi *multiplyedNumber;
	}
	public static int birthDay(int day, int month) {
		
		day *= multiply;
		day += numberPlus;
		day *= numberMultiply;
		day += month;
		day -= numberMinus;

		return day;
	}
	

}
