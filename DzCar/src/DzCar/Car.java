package DzCar;

public class Car {

	Rudder rudder;

	Wheel wheel;

	Body body;

	public Car(Rudder rudder, Wheel wheel, Body body) {
		this.rudder = rudder;
		this.wheel = wheel;
		this.body = body;
	}

	public Car(double diametr, boolean button, double diametrWheel, Tire tire,
			String color, String size) {
		this.rudder = new Rudder(diametr, button);
		this.wheel = new Wheel(diametrWheel, tire);
		this.body = new Body(color, size);
	}

	public void setColor(String color) {
		body.setColor(color);
	}

	public void setSize(String size) {
		body.setSize(size);
	}

	public String getSize() {
		return body.getSize();
	}

	public boolean isButton() {
		return rudder.isButton();
	}

	public void increaseRudder() {
		rudder.increaseRudder();
	}

	public Tire getTire() {
		return wheel.getTire();
	}

	public void setTire(Tire tire) {
		wheel.setTire(tire);
	}

	public void increaseDiametrWheel(int increase) {
		wheel.increaseDiametrWheel(increase);
	}

	public Rudder getRudder() {
		return rudder;
	}

	public void setRudder(Rudder rudder) {
		this.rudder = rudder;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public double getDiametrWheel() {
		return wheel.getDiametrWheel();
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public String getColor() {
		return body.getColor();
	}

	public double getDiametr() {
		return rudder.getDiametr();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((rudder == null) ? 0 : rudder.hashCode());
		result = prime * result + ((wheel == null) ? 0 : wheel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (rudder == null) {
			if (other.rudder != null)
				return false;
		} else if (!rudder.equals(other.rudder))
			return false;
		if (wheel == null) {
			if (other.wheel != null)
				return false;
		} else if (!wheel.equals(other.wheel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [rudder=" + rudder + ", wheel=" + wheel + ", body=" + body
				+ "]";
	}

}
