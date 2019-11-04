package info5100a7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;


public class a7q1 {
	public static void main(String[] args) throws IOException {
		// Reading data from file
		    File f1=new File("/Users/meatball/Desktop/eclipse-workspace/info5100a7/src/info5100a7/Q1Input");
		    FileReader fr=new FileReader(f1);
		    BufferedReader br=new BufferedReader(fr);

		    String in = br.readLine();

		    // Writing data
		    File f2=new File("/Users/meatball/Desktop/eclipse-workspace/info5100a7/src/info5100a7/Q1Output");
		    FileWriter fw=new FileWriter(f2);
		    BufferedWriter bw=new BufferedWriter(fw);
		    while(in !=null)
		    {
	        	if(in == null || in.length() == 0) break;
	            String[] s = in.split(" ");
	            StringBuilder sb = new StringBuilder();
	            int size = s.length;
	            for (int i = size - 1; i >= 0; i--) {
	                sb.append(s[i] + " ");
	            }
		        bw.write(sb.toString());
		        bw.newLine();
		        in = br.readLine();

		    }
		    bw.flush();
		    bw.close();

		}
}
