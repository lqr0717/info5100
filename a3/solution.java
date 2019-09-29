package info5100A3;

public class solution {

	public static void main(String[] args) {
		
	}
	//Q5
	public String countAndSay(int n) {
		if(n == 1) return "1";

		StringBuilder res = new StringBuilder();

		String s = countAndSay(n-1) + "0"; 
		for(int i=0, c=1; i < s.length()-1; i++, c++){
			if(s.charAt(i+1) != s.charAt(i)){
				res.append(c).append(s.charAt(i));
				c = 0;  
			}
		}

		return res.toString();
	}
	
	//Q6
	public String reverseStr(String s) {
		StringBuilder res = new StringBuilder();
	    for (int i = 0; i < s.length(); i++) {
	        if(s.charAt(i) != ' ') {
	            int start = i;
	            while(i < s.length() && s.charAt(i) != ' '){
	             i++;   
	            }
	        res.insert(0, s.substring(start, i)).insert(0, " ");
	   }else{
	            continue;
	        }
	    }
	          return res.toString().trim();
	    }
	//Q7
	public int[] spiralOrder(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[] res = new int[row*col];
		int r1 = 0;
		int r2= row-1;
		int c1=0;
		int c2= col-1;
		int count = 0;
		while(r1<=r2 && c1<=c2) {
			for(int c = c1; c<=c2;c++) {
				res[count] = matrix[r1][c];
				count++;
			}
			for(int r = r1+1;r<=r2;r++){
				res[count] = matrix[r][c2];
				count++;
			}
			if(r1<r2&&c1<c2) {
				for(int c =c2-1;c>c1;c--) {
					res[count] = matrix[r2][c];
					count++;
				}
				for(int r= r2; r>r1;r--) {
					res[count] = matrix[r][c1];
					count++;
				}
			}
				r1++;
				r2--;
				c1++;
				c2--;
		}
		return res;
		
	}
	//Q8
	public String convert(String s, int numRows) {
		if (numRows == 1) return s;
		StringBuilder res = new StringBuilder();
		int pre = 2*numRows -2;
		for(int i = 0;i<s.length();i +=pre) {
			res.append(s.charAt(i));
		}
		
		for(int k = 1; k<= numRows-2; k++) {
			for(int i = 0; i+k<s.length();i+=pre) {
				res.append(s.charAt(i+k));
				if(i+pre-k<s.length()) {
					 res.append(s.charAt(i+pre-k));
				}
			}
		}
		
		for(int i = numRows-1; i<s.length();i +=pre) {
			res.append(s.charAt(i));
		}
		return res.toString();
	    }

	
}