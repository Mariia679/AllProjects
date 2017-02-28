package Kii;

import static Kii.Purpose.*;
import static Kii.Material.*;

public enum Title {

	ARROW(AMATEUR, 390, GRAB), DARKHHORNBEAM(AMATEUR, 600, DARKGRAB), PALISANDER(
			AMATEUR, 1200, PALISANDR), SPICA(ELITE, 1650, VENGE), TULIP(ELITE,
			2600, VENGE), TULIPGRAB(ELITE, 2800, BLACKGRAB), K2VENGE(
			PROFESSIONAL, 1100, VENGE), MARS(PROFESSIONAL, 1750, PADUK), K2PALISANDER(
			PROFESSIONAL, 1300, PALISANDR);

	public Purpose purpose;
	public int price;
	public Material material;

	private Title(Purpose purpose, int price, Material material) {
		this.purpose = purpose;
		this.price = price;
		this.material = material;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

}
