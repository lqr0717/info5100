package info5100a7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

public class a7q2 {
	public static void main(String[] args) throws IOException {
		File f1 = new File("/Users/meatball/Desktop/eclipse-workspace/info5100a7/src/info5100a7/Q2Input");
	    FileReader fr = new FileReader(f1);
	    BufferedReader br =new BufferedReader(fr);
	    File f2 = new File("/Users/meatball/Desktop/eclipse-workspace/info5100a7/src/info5100a7/Q2Output");
	    FileWriter fw = new FileWriter(f2);
	    BufferedWriter bw = new BufferedWriter(fw);
	    String in = br.readLine();
	    while(in !=null){
        	if(in == null || in.length() == 0) break;
            String s = decodeString(in);
	        bw.write(s);
	        bw.newLine();
	        in = br.readLine();

	    }
	    bw.flush();
	    bw.close();

	}
	private static String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
	    int i = 0;
	    result.push("");
	    while (i < s.length()) {
	        char ch = s.charAt(i);
	        if (ch >= '0' && ch <= '9') {
	        	int start = i;
	            while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
	            count.push(Integer.parseInt(s.substring(start, i + 1)));
	            } else if (ch == '[') {
	                result.push("");
	            } else if (ch == ']') {
	                String str = result.pop();
	                StringBuilder sb = new StringBuilder();
	                int times = count.pop();
	                for (int j = 0; j < times; j += 1) {
	                    sb.append(str);
	                }
	                result.push(result.pop() + sb.toString());
	            } else {
	                result.push(result.pop() + ch);
	            }
	            i += 1;
	        }
	        return result.pop();
	    }

}


