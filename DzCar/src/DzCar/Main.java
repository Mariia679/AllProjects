package DzCar;

public class Main {

	public static void main(String[] args) {
		/*
		 * Rudder rudder = new Rudder(10, 5, 380, 0,true);
		 * Wheel wheel = new Wheel(100);
		 * Carcase body = new Body("Red", "Pessenger car");
		 * Car car=new Car(rudder, wheel, body);
		 * System.out.println(car);
		 */
		
        /*
         * Car car=new Car(380,true, 150, "Blue", "Truck");
         * System.out.println(car);
         * car.turn();
         * System.out.println(car);
         * car.setColor("Red");
         * System.out.println(car);
         * car.setSize("Pessenger car");
         * System.out.println(car);
         * System.out.println(car);
         * car.increaseDiametrWheel();
         * System.out.println(car);
         * car.turn();
         * System.out.println(car);
         */
		
		Car car=new Car(new Rudder(380,true),new Wheel(100,Tire.SUMMER),new Body("Blue", "Truck"));
		System.out.println(car);
	}

}
