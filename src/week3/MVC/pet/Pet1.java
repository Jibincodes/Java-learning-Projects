package week3.MVC.pet;

// taken from the solution class for usage and this program is being extended as per as the question
public class Pet1 {
	public enum Species {CAT, DOG, HORSE};
	public enum Gender {MALE, FEMALE};
	
	private static int highestID = -1;
	
	private final int ID;
	private Species species;
	private Gender gender;
	private String name;
	
    Pet1(int ID) {
		this.ID = ID;
	}
	// Class method to get next available ID
	private static int getNextID() {
		return ++highestID;
	}
	
	public Pet1(Species species, Gender gender, String name) {
		this.ID = getNextID();
		this.species = species;
		this.gender = gender;
		this.name = name;
	}
	
	public Pet1(int ID, Species species, Gender gender, String name) {
		this.ID = ID;
		this.species = species;
		this.gender = gender;
		this.name = name;
	}
	
	
	// --- Getters and Setters ---
	
	public int getID() {
		return ID;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
