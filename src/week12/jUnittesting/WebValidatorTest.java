package week12.jUnittesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//------------------------------------------------------------------
//The Failure of jUnit Test has been explained in the word document (uploaded in Github)
//-------------------------------------------------------------------

class WebValidatorTest {

	
	private Webvalidator1 wav = new Webvalidator1();

	private String[] validNumericAddresses = {
			"0.1.0.1", "255.255.255.255", "127.0.0.1",
			"000.000.000.000", "233.234.234.234"
	};

	private String[] invalidNumericAddresses = {
			"0.0.0", "255.255.255", "256.0.0.1",
			"127.0.0.256", "8.8", "8", "8.8.8.8.8"
	};
	
	private String[] validSymbolicAddresses = {
			"google.com", "www.google.com",
			"someone.edu", "ch.ch"
	};

	private String[] invalidSymbolicAddresses = {
			".google.com", "google.com.",
			"google,com", "com", "cm.", ".cm"
	};

	@Test
	void testVNA() {
		for (String s : validNumericAddresses) {
			assertTrue(wav.isValidWebAddress(s));
		}
	}

	@Test
	void testINA() {
		for (String s : invalidNumericAddresses) {
			assertFalse(wav.isValidWebAddress(s));
		}
	}

	@Test
	void testVSA() {
		for (String s : validSymbolicAddresses) {
			assertTrue(wav.isValidWebAddress(s));
		}
	}

	@Test
	void testISA() {
		for (String s : invalidSymbolicAddresses) {
			assertFalse(wav.isValidWebAddress(s));
		}
	}
	

}
