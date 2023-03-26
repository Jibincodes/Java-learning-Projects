package week3.MVC.pet;

import javafx.beans.property.SimpleObjectProperty;


public class PetModel {
	private final SimpleObjectProperty<Pet1> petProperty = new SimpleObjectProperty<>();
	
	public void savePet(Pet1.Species species, Pet1.Gender gender, String name) {
		petProperty.set(new Pet1(species, gender, name));
	}
	
	public void deletePet() {
		petProperty.set(null);
	}
	
	public Pet1 getPet() {
		return petProperty.get();
	}
	
	public SimpleObjectProperty<Pet1> petProperty() {
		return petProperty;
	}
}

