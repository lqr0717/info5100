package info5100a5;

import java.util.Random;

public class MyIndexOutOfBoundException extends RuntimeException{
	int lowerBound;
	int upperBound;
	int index;
	
	public MyIndexOutOfBoundException() {
		
	}
	public MyIndexOutOfBoundException(int l, int u, int i){
		this.lowerBound = l;
		this.upperBound = u;
		this.index = i;
	}

	public String toString() {
		return "Error Message: Index: " + index + ", but Lower bound: " + lowerBound + ", Upper bound: " + upperBound;
	}
	
	public static void main(String args[]) {
		int a = 40;
		int b = 70;
		Random random = new Random();
		try {
			int c = random.nextInt(100);
			while(a<c && c<b) {
				System.out.println(c);
				c =random.nextInt(100);
			}
				throw new MyIndexOutOfBoundException(a,b,c);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

