import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;

import javax.script.ScriptException;

import org.apache.commons.exec.ExecuteException;
import org.apache.commons.io.FilenameUtils;

public class CompileBInaries {
	

	public static void main(String[] args) throws IOException, InterruptedException, ScriptException{
		
		String folderToProcess ="testdir";
		
		List cpp_files = Util.listCPPFiles(folderToProcess);
		List c_files = Util.listCFiles(folderToProcess);

		for(int i=0; i< c_files.size(); i++){
			compileObjC(c_files.get(i).toString());			
		}
		for(int i=0; i< cpp_files.size(); i++){
			compileObjCPP(cpp_files.get(i).toString());
		}

	}
	
	public static void compileObjCPP(String filePath) throws IOException, InterruptedException, ScriptException{
		//disassembles binary in filePath with bjoern-radare to outdir as nodes.csv and edges.csv
		//should take filename to test each time
		//just needs the name of the directory with the authors and their binaries as an input
		//and outputs .csv files in binary file's outdir directory - disassembles with radare 
	
		File processing = new File(filePath);
		String path = FilenameUtils.getPath(filePath);
		String filename = processing.getName();
		 Runtime run = Runtime.getRuntime();
		 String outdir = File.separator + path + File.separator  +"gen" + File.separator ;
	//	 File output = new File(outdir);
	//	 output.mkdir();
		 
       //  System.out.println("outdir: "+outdir);
         System.out.println("filepath: "+filePath);
//         System.out.println("path: "+path);



		

			 Process fileProcess = run.exec(new String[]{"/bin/sh", "-c",
					 "cd /"+File.separator+path +" ;"+
					 "/usr/local/gcc-4.8.1-for-linux32/bin/i586-pc-linux-g++ -c "
				    	   		+ filePath 
					 });
		  
				       fileProcess.waitFor();
				       BufferedReader br = new BufferedReader(new InputStreamReader(fileProcess.getInputStream()));
				       while(br.ready())
				           System.out.println("input stream: "+br.readLine());
				        br = new BufferedReader(new InputStreamReader(fileProcess.getErrorStream()));
				       while(br.ready())
				           System.out.println("error stream: "+br.readLine());
			
	
	}
	public static void compileObjC(String filePath) throws IOException, InterruptedException, ScriptException{
		//disassembles binary in filePath with bjoern-radare to outdir as nodes.csv and edges.csv
		//should take filename to test each time
		//just needs the name of the directory with the authors and their binaries as an input
		//and outputs .csv files in binary file's outdir directory - disassembles with radare 
	
		File processing = new File(filePath);
		String path = FilenameUtils.getPath(filePath);
		String filename = processing.getName();
		 Runtime run = Runtime.getRuntime();
		 String outdir = File.separator + path + File.separator  +"gen" + File.separator ;
	//	 File output = new File(outdir);
	//	 output.mkdir();
		 
       //  System.out.println("outdir: "+outdir);
        // System.out.println("filepath: "+filePath);
         System.out.println("path: "+path);



		

			 Process fileProcess = run.exec(new String[]{"/bin/sh", "-c",
					 "cd "+File.separator+path +" ;"
					 + "/usr/local/gcc-4.8.1-for-linux32/bin/i586-pc-linux-gcc -c "
				    	   		+ filePath 
					 });
		  
		       fileProcess.waitFor();
		       BufferedReader br = new BufferedReader(new InputStreamReader(fileProcess.getInputStream()));
		       while(br.ready())
		           System.out.println("input stream: "+br.readLine());
		        br = new BufferedReader(new InputStreamReader(fileProcess.getErrorStream()));
		       while(br.ready())
		           System.out.println("error stream: "+br.readLine());
	
			
	
	}
}
