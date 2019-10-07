package a4;

public abstract class DessertItem extends Object {
	protected String name;
	public DessertItem() {
		this("");
	}
	public DessertItem(String name) {
		if(name.length() <= DessertShop.NameSize) {
			this.name = name;
		}
		else {
			this.name = name.substring(0,DessertShop.NameSize);
		}
	}
	
	public final String getName(){
		return name;
	}
	public abstract int getCost();


}
