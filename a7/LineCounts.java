package info5100a7;

import java.io.*;

public class LineCounts{
	public static void main(String[] args) throws IOException {
		 File wf = new File("/Users/meatball/Desktop/eclipse-workspace/info5100a7/src/info5100a7/countFile");
		 FileWriter fw = new FileWriter(wf);
		 BufferedWriter bw = new BufferedWriter(fw);
	      if (args.length == 0) {
	          System.out.println("No file found");
	          return;
	      }
	      for (int i = 0; i < args.length; i++) {
			  int lineCount;      
			  File f = new File("/Users/meatball/Desktop/eclipse-workspace/info5100a7/src/info5100a7/"+args[i]);
			  BufferedReader in;
		      try {
		    	  in = new BufferedReader(new FileReader(f));
		      }
		      catch (Exception e) {
		          System.out.println("Error: Can't open this file.");
		          return;
		      }
		      
		      lineCount = 0;
		      
		      try {
		         String line = in.readLine();  
		         while (line != null) {
		             lineCount++;               
		             line = in.readLine();      
		         }
		      }
		      catch (Exception e) {
		         System.out.println("Error: Problem with reading from the file.");
		         return;
		      }
		      
		      bw.write(args[i] + " has " + lineCount + " lines.");
		      bw.newLine();
	      }
	      bw.flush();
		  bw.close();
	 }
}
	      
	