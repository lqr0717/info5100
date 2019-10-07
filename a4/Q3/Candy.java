package a4;

public class Candy extends DessertItem{
	protected double weight;
	protected double priceperPound;
	public Candy(String name, double wei,int price) {
		super(name);
		this.weight = wei;
		this.priceperPound  = price;
		
	}
	@Override
	public int getCost() {
		return (int) Math.round(this.weight*this.priceperPound);
	}

}
