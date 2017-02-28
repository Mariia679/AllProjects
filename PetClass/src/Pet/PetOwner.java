package Pet;

public class PetOwner {

	public static void main(String[] args) {
		Pet myPet = new Pet();
		myPet.sleep();
		System.out.println(myPet.say("BlaBla"));
		Fish myFish=new Fish();
		myFish.sleep();
		System.out.println(myFish.say("BlaBla"));
		
	}

}
