package Pet;

public class Pet {
	private String name;
	private String ownerName;
	private String color;
	public static final int MALE = 1, FEMALE = 2, SPAYED =3 , NEUTERED =4 ;
	protected enum sex {MALE, FEMALE, SPAYED , NEUTERED};
	protected sex petSex;
	public Pet (String name, String ownerName, String color){
		this.name = name;
		this.ownerName = ownerName;
		this.color = color;
	}
	String getPetName() {
		return this.name;
	}
	String getOwnerName() {
		return this.ownerName;
	}
	String getColor() {
		return this.color;
	}
	void setSex(int sexid) {
		try {
			switch(sexid) {
			case MALE:
				petSex = sex.MALE;
				break;
			case FEMALE:
				petSex = sex.FEMALE;
				break;
			case SPAYED:
				petSex = sex.SPAYED;
				break;
			case NEUTERED:
				petSex = sex.NEUTERED;
				break;
			}
		} catch(Exception e){
			throw new IllegalArgumentException("Value not allowed!");
		}
	}
	
	String getSex() {
		return petSex.toString();
	}
	@Override
	public
	String toString() {
		String s = "";
		s = s+ this.name + "owned by " + this.ownerName +"\n";
		s = s + "Color: "+ this.color + "\n";
		s = s + "Sex: " + this.getSex() + "\n";
		return s;
	}
}

