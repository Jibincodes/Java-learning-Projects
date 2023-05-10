package week7.Artwebshop;

import java.util.Date;

public class Transaction {
	 private Customer customer;
	    private Product product;
	    private int quantity;
	    private Date date;
	    private double price;

	    public Transaction(Customer customer, Product product, int quantity, double price) {
	        this.customer = customer;
	        this.product = product;
	        this.quantity = quantity;
	        this.price = price;
	        this.date = new Date();
	    }

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public Date getDate() {
			return date;
		}
        // not sure if needed
		public void setDate(Date date) {
			this.date = date;
		}

		@Override
		public String toString() {
			return "Transaction [customer=" + customer + ", product=" + product + ", quantity=" + quantity + ", date="
					+ date + "]";
		}
		// newly created
		public String getId()
		{
			return "Transaction [customer=" + customer + ", product=" + product + ", quantity=" + quantity + ", date="
					+ date + "]";

		}
		
	    
}
