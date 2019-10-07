package a4;

public class IceCream extends DessertItem{
	protected int price;
	public IceCream(String name,int price) {
		super(name);
		this.price  = price;
		
	}
	@Override
	public int getCost() {
		return price;
	}

}


