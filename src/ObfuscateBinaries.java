import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

public class ObfuscateBinaries {
	
	  public static void main(String[] args) throws IOException, InterruptedException{
	        
	        String workingDirectory = System.getProperty("user.dir");
	        
	        String outputFile = "";
	        String filename = "";
	        
	        List cppFilePaths = Util.listCPPFiles("test");
	        String obfuscationType="-mllvm -sub -mllvm -fla -mllvm -bcf";
	        for(int i =0; i< cppFilePaths.size();i++){
	        
      	
	        	//to generate obfuscated code
	        	File cppFile = new File(cppFilePaths.get(i).toString());
	            filename = cppFile.getName();
	            outputFile = filename.concat("obfuscatedExecutable");
	            System.out.println(filename);
	        Runtime decompiler = Runtime.getRuntime();
	                Process process = decompiler.exec(new String[]{"/bin/sh","/c",
	               "/home/ubuntu/build/bin/clang++ -m32 "+
	               		cppFilePaths.get(i).toString()+" -o "+
	            		   
	               		cppFile.getParentFile().getPath()+File.separator+outputFile+
	               		" "+obfuscationType
	            });    
	    //end of obfuscation
	                
	                
	                	        process.waitFor();
	    
	    InputStream in = process.getInputStream();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    
	    while(reader.ready()){
	        System.out.println("input str: "+reader.readLine());
	    }
	    
	     in = process.getErrorStream();
	     reader = new BufferedReader(new InputStreamReader(in));
	    
	    while(reader.ready()){
	        System.out.println("err str: "+reader.readLine());
	    }
	    
	    

	        }
	    }
	
}
