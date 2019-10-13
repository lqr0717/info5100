package Cat;

import Date.Date;
import Pet.Boardable;
import Pet.Pet;

public class Cat extends Pet implements Boardable{
	private  String hairLength;
	private Date boardingStart, boardingEnd;
	
	public Cat (String name, String ownerName, String color, String hairLength) {
		super(name,ownerName,color);
		this.hairLength = hairLength;
	}
	public String getHairLength() {
		return this.hairLength;
	}
	@Override
	public String toString() {
		String s = "CAT: \n";
		s = s + super.toString();
		s = "Hair: " + this.getHairLength() + "\n";
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
