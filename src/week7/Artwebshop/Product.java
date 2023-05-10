package week7.Artwebshop;

public class Product {
	private String name;
    private String artist;
    private double price;

    public Product(String name, String artist, double price) {
        this.name = name;
        this.artist = artist;
        this.price = price;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", artist=" + artist + ", price=" + price + "]";
	}
    
}
