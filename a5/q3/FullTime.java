package info5100a5;

public class FullTime extends Employee{

	public FullTime(String name, int paymentPerHour) {
		super(name, paymentPerHour);
	}

	@Override
	public int calculateSalary() {
		return getPaymentPerHour()*8;
	}
	
}
