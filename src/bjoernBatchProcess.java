import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.script.ScriptException;

import org.apache.commons.io.FilenameUtils;

public class bjoernBatchProcess {
	
	
//	LD_LIBRARY_PATH=./lib/ java -Djava.library.path=lib -jar ./bin/bjoern-radare.jar $@
//	# java -jar ./bin/orientdbImporter.jar nodes.csv edges.csv

	
	public static void main(String[] args) throws IOException, InterruptedException, ScriptException{
		
		String folderToProcess ="/mnt/data_bsd/allOptimizations/";
		
		List binary_paths = Util.listBinaryFiles(folderToProcess);
		for(int i=0; i< binary_paths.size(); i++){
			preprocessBinaryWithBjoern(binary_paths.get(i).toString());
			
		}
	}
	
	
	
	
	
	public static void preprocessBinaryWithBjoern(String filePath) throws IOException, InterruptedException, ScriptException{
		//should take filename to test each time
		//just needs the name of the directory with the authors and their source files as an input
		//and outputs .ast files in source file's corresponding directory - has AST information 
	
		File processing = new File(filePath);
		String path = FilenameUtils.getPath(filePath);
		String filename = processing.getName();
		 Runtime run = Runtime.getRuntime();
/*		 File nodes = new File( File.separator + path +filename+"_nodes.csv" );
		 File edges = new File( File.separator + path +filename+"_edges.csv" );
		 nodes.createNewFile();
		 edges.createNewFile();*/
		 File output = new File (File.separator + path +File.separator+ "output_"+filename + File.separator);
		 System.out.println(output);
		 output.mkdir();
		 
		 String bjoern_radare_tmp=  "#!/bin/sh" +"\n"+
"LD_LIBRARY_PATH=./lib/ java -Djava.library.path=lib -jar ./bin/bjoern-radare.jar $@"+"\n"+
"# java -jar ./bin/orientdbImporter.jar " + File.separator + path + filename +"_nodes.csv " 
+  File.separator + path +filename +"_edges.csv"; 
		
		 PrintWriter writer = new PrintWriter("/home/ubuntu/Desktop/bjoern-radare/bjoern-radare/bjoern-radare.sh");
		 writer.println(bjoern_radare_tmp);
		 writer.close();

		 
		 
		 Process cdInto = run.exec(new String[]{"/bin/sh", "-c",
	    		//   "cd "  +File.separator+ path +"\n"+ 
		  "chmod a+x /home/ubuntu/Desktop/bjoern-radare/bjoern-radare/bjoern-radare.sh " +"\n"+
	    				   " cd /home/ubuntu/Desktop/bjoern-radare/bjoern-radare/ "+ "\n"
		  + "./bjoern-radare.sh " +
	    				   filePath + " -outdir "+output+"\n"
	    				+	 "pwd"+"\n"
		 });
	       cdInto.waitFor();
	       BufferedReader br = new BufferedReader(new InputStreamReader(cdInto.getInputStream()));
	       while(br.ready())
	           System.out.println(br.readLine());
	       
	
	   

		
	}

}
