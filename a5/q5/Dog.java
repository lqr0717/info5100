package Dog;

import Date.Date;
import Pet.Boardable;
import Pet.Pet;

public class Dog extends Pet implements Boardable{
	private String size;
	private Date boardingStart, boardingEnd;

	public Dog (String name, String ownerName, String color, String size) {
		super(name,ownerName,color);
		this.size = size;
	}
	public String getSize() {
		return this.size;
	}
	@Override
	public String toString() {
		String s = "DOG: \n";
		s = s + super.toString();
		s = "Size: " + this.size + "\n";
		return s;
	}
	@Override
	public void setBoardStart(int month, int day, int year) {
		this.boardingStart = new Date(month,day,year);
	}
	@Override
	public void setBoardEnd(int month, int day, int year) {
		this.boardingEnd = new Date(month,day,year);
		
	}
	@Override
	public boolean boarding(int month, int day, int year) {
		Date thisDay = new Date(month,day,year);
		return (thisDay.aheadDate(boardingStart) && thisDay.behindDate(boardingEnd));
	}
}
