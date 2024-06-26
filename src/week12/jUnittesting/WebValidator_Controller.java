package week12.jUnittesting;

public class WebValidator_Controller {
	final private WebValidator_Model model;
	final private WebValidator_View view;

	// Validity checks for the two text fields
	private boolean webAddressValid = false;
	private boolean portValid = false;

	protected WebValidator_Controller(WebValidator_Model model,
			WebValidator_View view) {
		this.model = model;
		this.view = view;

		// ChangeListener for the text-property of the web address
		view.txtIpAddress.textProperty().addListener(
				// Parameters of any PropertyChangeListener
				(observable, oldValue, newValue) -> {
					validateWebAddress(newValue);
				});

		// ChangeListener for the text-property of the port number
		view.txtPort.textProperty().addListener(
				// Parameters of any PropertyChangeListener
				(observable, oldValue, newValue) -> {
					validatePortNumber(newValue);
				});
	}

	/**
	 * Two options: numeric (IPv4) or symbolic (e.g., www.fhnw.ch). In either
	 * case, we split on the periods.
	 */
	private void validateWebAddress(String newValue) {
		boolean valid = isValidWebAddress(newValue);

		// Change text color
		view.txtIpAddress.getStyleClass().remove("valid");
		view.txtIpAddress.getStyleClass().remove("invalid");
		if (valid) {
			view.txtIpAddress.getStyleClass().add("valid");
		} else {
			view.txtIpAddress.getStyleClass().add("invalid");
		}

		// Save result
		webAddressValid = valid;

		// Enable or disable button, as appropriate
		enableDisableButton();
	}

	/**
	 * Must be an integer 1-65535
	 */
	private void validatePortNumber(String newValue) {
		boolean valid = isValidPortNumber(newValue);

		// Change text color
		view.txtPort.getStyleClass().remove("valid");
		view.txtPort.getStyleClass().remove("invalid");
		if (valid) {
			view.txtPort.getStyleClass().add("valid");
		} else {
			view.txtPort.getStyleClass().add("invalid");
		}

		// Save result
		portValid = valid;

		// Enable or disable button, as appropriate
		enableDisableButton();
	}

	/**
	 * Enable or disable the Connect button, based on the validity of the two
	 * text controls
	 */
	private void enableDisableButton() {
		boolean valid = webAddressValid & portValid;
		view.btnConnect.setDisable(!valid);
	}
	
	protected boolean isValidWebAddress(String newValue) {
		boolean valid = false;
		String[] parts = newValue.split("\\.", -1);

		// check for a numeric address first: 4 parts, each an integer 0 to 255
		if (parts.length == 4) {
			valid = true;
			for (String part : parts) {
				try {
					int value = Integer.parseInt(part);
					if (value < 0 || value > 255) valid = false;
				} catch (NumberFormatException e) {
					// wasn't an integer
					valid = false;
				}
			}
		}

		// If not valid, try for a symbolic address: at least two parts, each
		// part at least two characters. We don't bother checking what kinds of
		// characters they are.
		if (!valid) {
			if (parts.length >= 2) {
				valid = true;
				for (String part : parts) {
					if (part.length() < 2) valid = false;
				}
			}
		}
		
		return valid;
	}
	
	protected boolean isValidPortNumber(String newValue) {
		boolean valid = true;

		try {
			int value = Integer.parseInt(newValue);
			if (value < 1 || value > 65535) valid = false;
		} catch (NumberFormatException e) {
			// wasn't an integer
			valid = false;
		}

		return valid;
	}	
}
