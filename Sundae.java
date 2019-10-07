package a4;

public class Sundae extends IceCream{
	protected String addOn;
	protected int addonPrice;
	public Sundae(String name,int price,String add, int ap) {
		super(name,price);
		this.addOn = add;
		this.addonPrice = ap;
		
	}
	public int getCost() {
		// TODO Auto-generated method stub
		return price + addonPrice;
	}
}
