package week3.MVC.pet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import javafx.beans.property.SimpleObjectProperty;
import week3.MVC.pet.Pet1.Gender;
import week3.MVC.pet.Pet1.Species;




public class PetModel {
	private final SimpleObjectProperty<Pet1> petProperty = new SimpleObjectProperty<>();
	// new changes
	private static String PETS_FILE = "C:/Users/jibin/git/individualprojectjibin/src/week3/MVC/pet/pets.txt";
	private static String SEPARATOR = ";";
	private ArrayList<Pet1> pets = new ArrayList<Pet1>();
	
	public void savePet(Pet1.Species species, Pet1.Gender gender, String name) {
		Pet1 woof = new Pet1(species, gender, name);
		petProperty.set(woof);
		
		pets.add(woof);
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
	// changes made for file saving
	public ArrayList<Pet1> getPets() {
		return pets;
	}
	public void addPet(Pet1 pet) {
		pets.add(pet);
	}
	// for loading
	public void loadPets() {
		File petsFile = new File(PETS_FILE);
		//InputStream inStream = this.getClass().getResourceAsStream("C:/Users/jibin/git/individualprojectjibin/src/week3/MVC/pet"
		//		+ PETS_FILE);
		try (Reader inReader = new FileReader(petsFile)) {
			BufferedReader in = new BufferedReader(inReader);
     		String line = in.readLine();
			while (line != null) {
				Pet1 pet = readPet(line);
				pets.add(pet);
				line = in.readLine();
		
			}
			petProperty.set(pets.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// for reading
	private Pet1 readPet(String line) {
		String[] attributes = line.split(SEPARATOR);
		int ID = Integer.parseInt(attributes[0]);
		Species species = Species.valueOf(attributes[1]);
		Gender gender = Gender.valueOf(attributes[2]);
		String name = attributes[3];
		Pet1 pet = new Pet1(ID, species, gender, name);
		//pet.setName(name); was just testing something
		pets.add(pet);
		return pet;
	}
	// for saving
	public void savePets() {
		File petsFile = new File(PETS_FILE);
		try (Writer out = new FileWriter(petsFile)) {
			for (Pet1 pet : pets) {
				String line = writePet(pet);
				out.write(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// for writing
	private String writePet(Pet1 pet) {
		String line = pet.getID() + SEPARATOR + pet.getSpecies()+ SEPARATOR + pet.getGender() + SEPARATOR + pet.getName() + "\n";
		return line;
	}
	public void stop() {
	    try {
	        FileOutputStream fileOut = new FileOutputStream("pets.txt");
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        out.writeObject(pets);
	        out.close();
	        fileOut.close();
	    } catch (IOException e) {
	        // Handle the case where the file can't be written
	    	e.printStackTrace();
	    }
	}
}

