package a4;

public class Q4andQ5 {
	 public static void main(String[] args) {
		 
	 }
	 public int[][] multiply(int[][] A, int[][] B) {
	        int rowa = A.length;
	        int cola = A[0].length;
	        int colb = B[0].length;
	        int[][] ans = new int[rowa][colb];
	        for(int i = 0; i<rowa ; i++){
	            for(int j = 0; j<colb;j++){
	                for(int k = 0; k<cola; k++){
	                    ans[i][j] += A[i][k]*B[k][j];
	                }
	            }
	        }
	        return ans;
	        
	    }
	 public int[] diStringMatch(String S) {
	        int n = S.length(); 
	        int left = 0; 
	        int right = n;
	        int[] res = new int[n + 1];
	        for (int i = 0; i < n; i++){
	            if (S.charAt(i) == 'I'){
	                res[i] = left;
	                left ++;
	            }
	            else {
	            	res[i] = right;
	            	right --;
	            }
	        }
	        res[n] = right;
	        return res;
	 
	}
}

