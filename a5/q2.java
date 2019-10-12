package info5100a5;

public class Number {
	private int x;
	private int y;
	public static void main(String args[]) {
		Number a = new Number();
		a.x = 10;
		a.y = 0;
		a.count();
	}
	public void count() {
		try {
			int z = x/y;
			System.out.println("Result: " + z);
		}
		
		catch(ArithmeticException e){
			//System.out.println("Error:"+e.getMessage());
			System.out.println("Error:"+e);
		}
		
		finally {
			System.out.println("End");
		}
	}
}

