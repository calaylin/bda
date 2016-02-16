import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import weka.core.Instances;

public class CleanUpARFFS {
	 public static void main(String[] args) throws Exception, IOException, InterruptedException {

			String output_filename = "/home/ubuntu/Desktop/usenix16/arffs/"
					+ "github_partial/github_partial/github_concurrent";
			
			
			int threads=30;
			for(int no=1; no<=threads+1;no++){
	    	File arffFile1 = new File(output_filename  +no+".arff");
	    	File tmpFile = new File(output_filename  +no+"temp.arff");
	    	String line="";
	    	BufferedReader reader = new BufferedReader(new FileReader(arffFile1));
	    	BufferedWriter writer  = new BufferedWriter(new FileWriter(tmpFile));
	    	int counter=0;
	    	while((line = reader.readLine())!= null){
    			//System.out.println(line);

	    	
	    		if(line.contains("BinaryDeanonymizationAllFeatures")){
	    			counter++;
	    			System.out.println("DETECTED LINE:"+line);
	    		}}
	    	
	    	
	    	
	    	
	    	BufferedReader reader2 = new BufferedReader(new FileReader(arffFile1));
	    	int counter2=0;
	    	while((line = reader2.readLine())!= null){
	    		if(line.contains("BinaryDeanonymizationAllFeatures")){
	    			counter2++;
	    		}
	    		if(counter2==counter){
	    			if (line.contains("instanceID"))
	    			{	    		writer.write("@attribute instanceID string"+"\n");}
	    			if (!(line.contains("instanceID")))
	    			{
	    		writer.write(line+"\n");}
	    			//System.out.println("WRITE LINE:"+line);

	    			}  		
	    	}
	    	
	    	writer.close();
	    	reader.close();
	    	tmpFile.renameTo(arffFile1);
	    	
			}}

	    	
	    	
	}
	 
