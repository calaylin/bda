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

public class DecompileBinaries {
	
	  public static void main(String[] args) throws IOException, InterruptedException{
	        
	        String workingDirectory = System.getProperty("user.dir");
	        
	        String outputFile = "";
	        String filename = "";
	        
	        List binary_files = listBinaryFiles("test");
	        
	        for(int i =0; i< binary_files.size();i++){
	        
/*	        	//to generate decompiled code
				filename = binary_files.get(i).toString();
				outputFile = filename.concat("_SnowmanDecompiled.cpp");
				System.out.println(filename);
			Runtime decompiler = Runtime.getRuntime();
					Process process = decompiler.exec(new String[]{"cmd.exe","/c",
					workingDirectory + File.separator + "snowman-v0.0.7-win-x64"+ File.separator+"nocode.exe "
					+  filename +" > "
					+  outputFile});
	        	//end of decompiled code generation
*/	        	
	        	//to generate cfgs
	            filename = binary_files.get(i).toString();
	            outputFile = filename.concat("_SnowmanDecompiled.cfg");
	            System.out.println(filename);
	        Runtime decompiler = Runtime.getRuntime();
	                Process process = decompiler.exec(new String[]{"cmd.exe","/c",
	                workingDirectory + File.separator + "snowman-v0.0.7-win-x64"+
	                File.separator+"nocode.exe "
	                +  filename +" --print-cfg > "
	                +  outputFile });    
	    //end of generating cfg
	                
	                
	                
	                //use the --print-cfg flag to print the dot formatted cfg to a file
	        process.waitFor();
	    
	    InputStream in = process.getInputStream();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    
	    while(reader.ready()){
	        System.out.println(reader.readLine());
	    }
	    
	    

	        }
	    }
	
	   public static List <File> listBinaryFiles(String dirPath){

	    	

	    	Collection files = FileUtils.listFiles(

	    			new File(dirPath), 

	    			  new RegexFileFilter("^(.*?)"), 

	    			  DirectoryFileFilter.DIRECTORY

	    			);

	    	List list = new ArrayList(files);

	    	Collections.sort(list);
	    	String ext ="";
	    	for (int i=0; i< list.size(); i++){

	    	

//	    		String ext = FilenameUtils.getExtension(list.get(i).toString());
	    		 ext = list.get(i).toString().substring(list.get(i).toString().length()-4 , list.get(i).toString().length());
	    		//if (!ext.isEmpty()){
	    		if (ext.contains(".cpp")){
	    			list.remove(i);
	    			i--;}

	    	}


	    	return list;

	    	

	    }
	
}
