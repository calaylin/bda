import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import javax.script.ScriptException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class CompileCode {
	

	public static void main(String[] args) throws IOException, InterruptedException, ScriptException{
		
		String folderToProcess ="githubRepos/";
		
		List all_files = Util.listAllFilesFolders(folderToProcess);
				
		File direct = new File(folderToProcess);
			String [] dir=	direct.list(new FilenameFilter(){
				@Override
			public boolean accept(File current, String name){
				return new File(current, name).isDirectory();
			}
		});
			String newFolder="githubReposProcessed/";
			int counter=0;
				for(int i=0; i< dir.length; i++){
					List obj_files = Util.listObjFiles(folderToProcess+File.separator+dir[i]);
					System.out.println(dir[i] +": "+ obj_files.size());
					if(obj_files.size()>3){
						counter++;
					}
					
					for(int j=0; j< obj_files.size(); j++){
						File src =new File(obj_files.get(j).toString());
						File dest = new File(newFolder+dir[i]+File.separator+j+src.getName());
				//	FileUtils.copyFile(src, dest);
					}
	
					
					System.out.println("counter:"+counter);
					if(obj_files.size()<2){
						File directory = new File(folderToProcess+File.separator+dir[i]);
						FileUtils.deleteDirectory(directory);
					}
				}
		
		List cpp_files = Util.listCPPFiles(folderToProcess);
		List c_files = Util.listCFiles(folderToProcess);


		
		for(int i=0; i< c_files.size(); i++){
		//	System.out.println("c file no: "+i);
		//	compileObjC(c_files.get(i).toString());			
		}
		for(int i=12680; i< cpp_files.size(); i++){
		//	System.out.println("cpp file no: "+i);
		//	compileObjCPP(cpp_files.get(i).toString());
		}
		
		List obj_files = Util.listObjFiles(folderToProcess);
        System.out.println("OBJfiles size: "+obj_files.size());
        
      //  File dirs = new File()
		for(int i=0; i< obj_files.size(); i++){

	      //   System.out.println("OBJfilepath: "+obj_files.get(i));
			}
	}
	
	public static void compileObjCPP(String filePath) throws IOException, InterruptedException, ScriptException{

		File processing = new File(filePath);
		String path = FilenameUtils.getPath(filePath);
		String filename = processing.getName();
		 Runtime run = Runtime.getRuntime();
		 String outdir = File.separator + path + File.separator  +"gen" + File.separator ;
	//	 File output = new File(outdir);
	//	 output.mkdir();
		 
         System.out.println("filepath: "+filePath);



		

			 Process fileProcess = run.exec(new String[]{"/bin/sh", "-c",
					 "cd /"+File.separator+path +" ;"+
					 "g++ -m32 -I "+File.separator+path+" -c "
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
	
		File processing = new File(filePath);
		String path = FilenameUtils.getPath(filePath);
		String filename = processing.getName();
		 Runtime run = Runtime.getRuntime();
		 String outdir = File.separator + path + File.separator  +"gen" + File.separator ;

         System.out.println("path: "+path);



		

			 Process fileProcess = run.exec(new String[]{"/bin/sh", "-c",
					 "cd "+File.separator+path +" ;"+
							 "gcc -m32 -I "+File.separator+path+" -c "
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
