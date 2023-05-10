package week7.Artwebshop;

public class Painting extends Product{
	 private String medium;

	    public Painting(String name, String artist, double price, String medium) {
	        super(name, artist, price);
	        this.medium = medium;
	    }

	    public String getMedium() {
	        return medium;
	    }

	    public void setMedium(String medium) {
	        this.medium = medium;
	    }

	    @Override
	    public String toString() {
	        return super.toString() + ", medium=" + medium;
	    }
	}
