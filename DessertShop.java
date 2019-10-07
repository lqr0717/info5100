package a4;

public class DessertShop {
	public final static double TaxRate = 6.5;
	public final static String StoreName = "M & M Dessert Shop";
	public final static int NameSize = 25;
	public final static int ReceiptWidth = 25;
	public final static int maxmimumNumber = 100;
	
	public static String cents2dollarsAndCentsMethod(int cents) {
		String s = "";
		if (cents<0) {
			s += "-";
			cents = cents * -1;
		}
		int dollar = cents/100;
		cents = cents%100;
		if(dollar > 0) {
			s += dollar;
			s += ".";
		}
		if (cents <10) {
			s += 0;
			s += ".";
		}
		s+=cents;
		return s;
	}
}
