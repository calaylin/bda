import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import weka.core.Instances;

public class CleanUpARFFS {
	 public static void main(String[] args) throws Exception, IOException, InterruptedException {

			String output_filename = "/data/usenix16/arffs/L0_600AuthorsConcurrent_part1/"
				+ "L0_600authors_allfeaturesNoAVGDep_concurrent_part1";
			
			
			int threads=30;
			
			
			
			
			File arffFile1 = new File(output_filename +"1.arff");
	    	File tmpFile = new File(output_filename  +"Final.arff");
/*	    	BufferedReader reader = new BufferedReader(new FileReader(tmpFile));
	    	String line="";
	    	int lineNo=0;
	    	while((line = reader.readLine())!= null){
	    		lineNo++;
	    	if(lineNo> 1487074 && lineNo< 1487079){
	    		System.out.println(line);
	    		Thread.sleep(millis);}}
	    	reader.close();*/
	    	
	    	String line="";
	    	BufferedReader reader = new BufferedReader(new FileReader(arffFile1));
	    	BufferedWriter writer  = new BufferedWriter(new FileWriter(tmpFile));
	    	int counter=0;
   	
	   	    	while((line = reader.readLine())!= null){
	    		
	    			
	    		writer.write(line+"\n");}
	   	    	reader.close();
			
			
			for(int no=2; no<=threads+1;no++){
	    	 arffFile1 = new File(output_filename  +no+".arff");
	    	 line="";
	    	 reader = new BufferedReader(new FileReader(arffFile1));
	    	 counter=0;
	    	 String tmp=null;
	    	while((line = reader.readLine())!= null){
    			//System.out.println(line);

	    	
	    		if(line.contains("@data")){
	    			counter++;
	    			System.out.println("DETECTED LINE:"+line);
	    		}
	    		
	    		if(counter >0){
	    			if(!(tmp==null)){
		    		writer.write(tmp+"\n");}}
	    			tmp =line;
	    			
	    		}
	    	reader.close();
	    		
	    	}
	    	
	    	writer.close();
	    	
			
	    	}
	
}
 
