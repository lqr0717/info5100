package a4;

public class Cookie extends DessertItem{
	protected double quantity;
	protected double priceperDozen;
	public Cookie(String name, double quan,int price) {
		super(name);
		this.quantity = quan;
		this.priceperDozen  = price;
		
	}
	@Override
	public int getCost() {
		return (int) Math.round(this.quantity/12*this.priceperDozen);
	}

}
