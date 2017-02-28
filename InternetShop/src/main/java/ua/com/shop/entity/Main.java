package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "main")
public class Main {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private int price;

	private int length;

	private int weight;

	@ManyToOne
	@JoinColumn(name = "id_main_material")
	private MainMaterial mainMaterial;

	@ManyToOne
	@JoinColumn(name = "id_wood")
	private Wood wood;

	@ManyToOne
	@JoinColumn(name = "id_ferula")
	private Ferula ferula;

	@ManyToOne
	@JoinColumn(name = "id_gash_type")
	private GashType gashType;

	@ManyToOne
	@JoinColumn(name = "id_gash")
	private Gash gash;

	@ManyToOne
	@JoinColumn(name = "id_sticker")
	private Sticker sticker;

	@ManyToOne
	@JoinColumn(name = "id_stype_ticker")
	private TypeSticker typeSticker;

	@ManyToOne
	@JoinColumn(name = "id_ring_end")
	private RingEnd ringEnd;

	@ManyToOne
	@JoinColumn(name = "id_ring_bumper")
	private RingBumper ringBumper;

	@ManyToOne
	@JoinColumn(name = "id_damper")
	private Damper damper;

	@ManyToOne
	@JoinColumn(name = "joint")
	private Joint joint;

	@ManyToMany
	@JoinTable(name = "main_user", joinColumns = @JoinColumn(name = "id_main"), inverseJoinColumns = @JoinColumn(name = "id_user"))
	private List<User> users;

	public Main() {

	}

	public Main(String name, int price, int length, int weight,
			MainMaterial mainMaterial, Wood wood, Ferula ferula,
			GashType gashType, Gash gash, Sticker sticker,
			TypeSticker typeSticker, RingEnd ringEnd, RingBumper ringBumper,
			Damper damper, Joint joint) {
		this.name = name;
		this.price = price;
		this.length = length;
		this.weight = weight;
		this.mainMaterial = mainMaterial;
		this.wood = wood;
		this.ferula = ferula;
		this.gashType = gashType;
		this.gash = gash;
		this.sticker = sticker;
		this.typeSticker = typeSticker;
		this.ringEnd = ringEnd;
		this.ringBumper = ringBumper;
		this.damper = damper;
		this.joint = joint;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public MainMaterial getMainMaterial() {
		return mainMaterial;
	}

	public void setMainMaterial(MainMaterial mainMaterial) {
		this.mainMaterial = mainMaterial;
	}

	public Wood getWood() {
		return wood;
	}

	public void setWood(Wood wood) {
		this.wood = wood;
	}

	public Ferula getFerula() {
		return ferula;
	}

	public void setFerula(Ferula ferula) {
		this.ferula = ferula;
	}

	public GashType getGashType() {
		return gashType;
	}

	public void setGashType(GashType gashType) {
		this.gashType = gashType;
	}

	public Gash getGash() {
		return gash;
	}

	public void setGash(Gash gash) {
		this.gash = gash;
	}

	public Sticker getSticker() {
		return sticker;
	}

	public void setSticker(Sticker sticker) {
		this.sticker = sticker;
	}

	public Joint getJoint() {
		return joint;
	}

	public void setJoint(Joint joint) {
		this.joint = joint;
	}

	public TypeSticker getTypeSticker() {
		return typeSticker;
	}

	public void setTypeSticker(TypeSticker typeSticker) {
		this.typeSticker = typeSticker;
	}

	public RingEnd getRingEnd() {
		return ringEnd;
	}

	public void setRingEnd(RingEnd ringEnd) {
		this.ringEnd = ringEnd;
	}

	public RingBumper getRingBumper() {
		return ringBumper;
	}

	public void setRingBumper(RingBumper ringBumper) {
		this.ringBumper = ringBumper;
	}

	public Damper getDamper() {
		return damper;
	}

	public void setDamper(Damper damper) {
		this.damper = damper;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Main [id=" + id + ", name=" + name + ", price=" + price
				+ ", length=" + length + ", weight=" + weight + "]";
	}

}
