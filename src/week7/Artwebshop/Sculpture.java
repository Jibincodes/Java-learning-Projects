package week7.Artwebshop;

public class Sculpture extends Product {
	private String material;

    public Sculpture(String name, String artist, double price, String material) {
        super(name, artist, price);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() + ", material=" + material;
    }
}









