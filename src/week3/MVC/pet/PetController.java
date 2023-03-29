package week3.MVC.pet;

import javafx.event.ActionEvent;

public class PetController {
	private PetView view;
	private PetModel model;

	public PetController(PetModel model, PetView view) {
		this.model = model;
		this.view = view;
		
		view.btnSave.setOnAction(this::save);
		view.btnDelete.setOnAction(this::delete);
		// new event
		view.btnLoad.setOnAction( event -> {
			model.loadPets();
			updateView(model.getPet());
			
		});
		view.btnSave1.setOnAction( event -> {
			model.savePets();
		});
		
		view.btnDelete.disableProperty().bind(model.petProperty().isNull());
		view.btnSave.disableProperty().bind(view.txtName.textProperty().isEmpty());
	}
	private void save(ActionEvent e) {
		week3.MVC.pet.Pet1.Species species = view.cmbSpecies.getValue();
		week3.MVC.pet.Pet1.Gender gender = view.cmbGender.getValue();
		String name = view.txtName.getText(); // string value should go to pets
		if (species != null && gender != null && name != null && name.length() > 0) {
			model.savePet(species, gender, name);
			//model.addPet(name);
			updateView(model.getPet());
		}
		
	}
	
	private void delete(ActionEvent e) {
		model.deletePet();
		updateView(model.getPet());
	}
	
	private void updateView(Pet1 pet1) {
		if (pet1 != null) {
			view.lblDataID.setText(Integer.toString(pet1.getID()));
			view.lblDataName.setText(pet1.getName());
			view.lblDataSpecies.setText(pet1.getSpecies().toString());
			view.lblDataGender.setText(pet1.getGender().toString());
		} else {
			view.lblDataID.setText("");
			view.lblDataName.setText("");
			view.lblDataSpecies.setText("");
			view.lblDataGender.setText("");
		}
	}
	

}
