package a4;

public class Checkout {
	private DessertItem[] items;
	private int numberofItem;
	
	
	public Checkout() {
		this.items = new DessertItem[(int) DessertShop.maxmimumNumber];
		this.numberofItem = 0;
		
	}
	public int numberOfItems() {
		return this.numberofItem;
	}
	public void enterItem(DessertItem item) {
		this.items[numberofItem] = item;
		this.numberofItem++;
	}
	public void clear() {
		this.numberofItem = 0;
		this.items = new DessertItem[(int) DessertShop.maxmimumNumber];
	}
	public int totalCost() {
		int total = 0;
		for(int i = 0; i< numberofItem; i++) {
			DessertItem di = items[i];
			total += di.getCost();
		}
		return total;
	}
	public int totalTax() {
		return (int) Math.round(totalCost()*DessertShop.TaxRate/100);
		
	}
	@Override
	public String toString() {
		String result = "      " + DessertShop.StoreName +"\n";
		result += "      --------------------\n";
		result += "\n";
		for(int i = 0; i<numberofItem; i++) {
			DessertItem di = items[i];
			if( di instanceof Sundae) {
				String sundaeAddName = String.format("%-25s", (((Sundae) di).addOn)+" Sundae with");
				result += sundaeAddName;
				result += "\n";
				String SundaeTotalPrice = String.valueOf(((double) di.getCost())/100);
				String IceCreamNameString = String.format("%-25s", di.name);
				SundaeTotalPrice= String.format("%10s", SundaeTotalPrice);
				result += IceCreamNameString + SundaeTotalPrice +"\n";
				
				
			}else if (di instanceof IceCream) {
				String IceCreamTotalPrice = String.valueOf(((double) di.getCost())/100);
				String IceCreamNameString = String.format("%-25s", di.name);
				IceCreamTotalPrice= String.format("%10s", IceCreamTotalPrice);
				result += IceCreamNameString + IceCreamTotalPrice +"\n";
			}else if (di instanceof Cookie) {
				result += ((Cookie) di).quantity + " @ " + (((Cookie) di).priceperDozen/100) +" /dz.\n";
				String cookieTotalPrice = String.valueOf(((double) di.getCost())/100);
				String cookieNameString = String.format("%-25s", di.name);
				cookieTotalPrice= String.format("%10s", cookieTotalPrice);
				result += cookieNameString + cookieTotalPrice +"\n";
			}else if (di instanceof Candy) {
				result += ((Candy) di).weight + " lbs. @ " + (((Candy) di).priceperPound/100) +" /lb.\n";
				String candyTotalPrice = String.valueOf(((double) di.getCost())/100);
				String candyNameString = String.format("%-25s", di.name);
				candyTotalPrice = String.format("%10s", candyTotalPrice);
				result += candyNameString + candyTotalPrice +"\n";
			}
		}
		result +="\n";
		String TaxLine = String.format("%-15s", "Tax");
		String TPrice= String.valueOf(((double) totalTax())/100);
		int tplen = TPrice.length();
		TPrice= String.format("%10s", TPrice.substring(1, tplen));
		result += TaxLine + TPrice;
		result += "\n";
		String TotalLine = String.format("%-15s", "Total Cost");
		String ToPrice= String.format("%10s", String.valueOf(((double) totalCost()+totalTax())/100));
		result += TotalLine + ToPrice;
		result += "\n" + "\n";
		return result;
	}
    
	
	
}
