import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.script.ScriptException;

import org.apache.commons.io.FilenameUtils;

public class bjoernGenerateGraphmlCFG {
	

	public static void main(String[] args) throws IOException, InterruptedException, ScriptException{
		
		String folderToProcess = "/Users/Aylin/Desktop/test/";
				//"/Users/Aylin/Desktop/Princeton/"+ "BAA/datasets/c++/optimizations/100authors_strippedS/";

		//Start server for once
		//./Users/Aylin/git/bjoern-radare/bjoern-server.sh
		// orientdb-community-2.1.5/bin/server.sh
		
		//the server keeps running in the background
		Thread t = new Thread(new Runnable()
		{
		    public void run()
		    {
			  try
			  {
				  Process runScript;
					Runtime run = Runtime.getRuntime();

					String cmd =// "cd /Users/Aylin/git/bjoern-radare/ "+";"+
							//"echo startingOrientDB ;"+
							//	"export PATH=$PATH:/usr/local/bin/ ;"+
								"/bin/bash /Users/Aylin/git/bjoern-radare/orientdb-community-2.1.5/bin/server.sh ";	 
					    //"/bin/bash /Users/Aylin/git/bjoern-radare/bjoern-server.sh";
					
					
					runScript = run.exec(new String[]{"/bin/bash","-c",cmd});			
					 BufferedReader br = new BufferedReader(new InputStreamReader(runScript.getInputStream()));
					 while(br.ready())
					 {	System.out.println(br.readLine());}
					 br.close();		
					 br = new BufferedReader(new InputStreamReader(runScript.getInputStream()));
					 while(br.ready())
						     {  System.out.println("input stream:"+br.readLine());}
						     br.close();
						      br = new BufferedReader(new InputStreamReader(runScript.getErrorStream()));
						     while(br.ready())
						     {  System.out.println("error stream:"+br.readLine());}
						     br.close();
							 int exitCode = runScript.exitValue();
							 System.out.println("Process exit code: " + exitCode); 
					runScript.destroyForcibly();}
			  catch(IOException e)
			  {		      
			      // Handle error.
			      e.printStackTrace();
			  }
		    }
		});
		t.start();
		
		   
	 
				 
				 
		List binary_paths = Util.listBinaryFiles(folderToProcess);
		for(int i=0; i< binary_paths.size(); i++){
			bjoernGenerateCFG(binary_paths.get(i).toString());
		}
		
		for(int i=0; i< binary_paths.size(); i++){
			dumpCFG(binary_paths.get(i).toString());
		}
		
		//kill server
		Runtime run = Runtime.getRuntime();
		Process runScript = run.exec(new String[]{"/bin/bash", "-c",
				    "/bin/bash /Users/Aylin/git/bjoern-radare/orientdb-community-2.1.5/bin/shutdown.sh"	 
				 });
		 runScript.waitFor();
		  BufferedReader br = new BufferedReader(new InputStreamReader(runScript.getInputStream()));
		 while(br.ready())
		 {	System.out.println(br.readLine());}
		 br.close();
		 t.stop();
	}
	
	public static void bjoernGenerateCFG(String filePath) throws IOException, InterruptedException, ScriptException{
		//disassembles binary in filePath with bjoern-radare to outdir 
		//generates the cfg databases
		File processing = new File(filePath);
		String path = FilenameUtils.getPath(filePath);
		String filename = processing.getName();
		String outdirTMP = File.separator + path + filename +"_bjoernDisassembly" + File.separator +"bjoernCFG"+File.separator;
		String dbName = filename +"CFG" ;
		File outputTMP = new File(outdirTMP);
		outputTMP.mkdir();
		 
       //  System.out.println("outdir: "+outdir);
        // System.out.println("filepath: "+filePath);
//         System.out.println("path: "+path);


			 String bjoern_radare_tmp=  "#!/bin/sh" +"\n"+
			 "export PATH=$PATH:/usr/local/bin/ \n"+
					 "java -cp "
		    	   		+ "/Users/Aylin/git/bjoern-radare/bin/bjoern.jar:/usr/local/bin/ "
		    	   		+ "exporters.radare.RadareExporterMain "
		    	   		+ filePath+" "+ " -outdir "+outdirTMP +"\n";

			
			 PrintWriter writer = new PrintWriter("/Users/Aylin/git/bjoern-radare/bjoern-radare2.sh");
			 writer.println(bjoern_radare_tmp);
			 writer.close();

			 
			 Runtime run = Runtime.getRuntime();
			 Process fileProcess = run.exec(new String[]{"/bin/sh", "-c",
					  "chmod 777 /Users/Aylin/git/bjoern-radare/bjoern-radare2.sh"

					 });
		  
				       fileProcess.waitFor();
				        BufferedReader br = new BufferedReader(new InputStreamReader(fileProcess.getInputStream()));
				       while(br.ready())
				           System.out.println(br.readLine());
				       br.close();

		
			 Runtime runBjoern = Runtime.getRuntime();
			Process runScript = runBjoern.exec(new String[]{"/bin/bash", "-c",
				"cd /Users/Aylin/git/bjoern-radare/ ;"
			    +"/bin/bash /Users/Aylin/git/bjoern-radare/bjoern-radare2.sh ;"+
			    "tail -n+2 "+outdirTMP+"nodes.csv | sort -r | uniq > "+ outdirTMP +"nodes.csv_ ;"+
			    "tail -n+2 "+outdirTMP+"edges.csv | sort -r | uniq > "+outdirTMP+"edges.csv_ ;"+

			    "head -n 1 "+outdirTMP+"nodes.csv > "+outdirTMP+"nodeHead.csv ;"+
			    "head -n 1 "+outdirTMP+"edges.csv > "+outdirTMP+"edgeHead.csv ;"+

			    "cat "+outdirTMP+"nodeHead.csv >  nodes.csv ;"+
			    "cat "+outdirTMP+"nodes.csv_ >> nodes.csv ;"+

			    "cat "+outdirTMP+"edgeHead.csv > edges.csv ;"+
			    "cat "+outdirTMP+"edges.csv_ >> edges.csv ;"+
			    
			    "/bin/bash /Users/Aylin/git/bjoern-radare/bjoern-csvimport.sh -dbname "+dbName 
/*		    "export PATH=$PATH:/usr/local/bin/ ;"+   
			"java -cp /Users/Aylin/git/bjoern-radare/bin/bjoern.jar:/usr/local/bin/ "
			+ "clients.bjoernImport.BjoernImport -dbname "+dbName + " ;"*/
			 });
			 
			 runScript.waitFor(); 
			 System.out.println(filename +": importing binary");
			 br = new BufferedReader(new InputStreamReader(runScript.getInputStream()));
		     while(br.ready()) {System.out.println("import input stream:"+br.readLine());}
		     br = new BufferedReader(new InputStreamReader(runScript.getErrorStream()));
		     while(br.ready()) {System.out.println("import error stream:"+br.readLine());}
		     
	}
	
	
	public static void dumpCFG(String filePath) throws IOException, InterruptedException, ScriptException{
		//generates the cfgs in outdir
		File processing = new File(filePath);
		String path = FilenameUtils.getPath(filePath);
		String filename = processing.getName();
		 String outdir = File.separator + path + filename +"_bjoernDisassembly" + File.separator ;
		 String outdirTMP = File.separator + path + filename +"_bjoernDisassembly" + File.separator +"bjoernCFG"+File.separator;
		 String dbName = filename +"CFG" ;
		 File outputTMP = new File(outdirTMP);
		 outputTMP.mkdir();


			String cfgDBFolder ="/Users/Aylin/git/bjoern-radare/orientdb-community-2.1.5/databases/";

			 Runtime dumpTime = Runtime.getRuntime();
		     Process dumpCFG = dumpTime.exec(new String[]{"/bin/bash", "-c",
		    		 "curl http://localhost:2480/dumpcfg/"+ dbName + " ;"+
		    		  "mkdir "+ outdir+" ;"+
		    			"mv -v /Users/Aylin/git/bjoern-radare/dump/cfg/"+dbName +  " " + outdir  + " ;"+
					    "rm -rf "+outdirTMP+" ;"+
					    "rm -rf /Users/Aylin/git/bjoern-radare/dump/cfg/"+ dbName+" ;"+
					    "rm -rf "+cfgDBFolder+ dbName +";"
					 });
					 
					 System.out.println(filename +": dumping cfg");
					 dumpCFG.waitFor();
				//	 int exitCode = runScript.exitValue();
				//	 System.out.println("Process exit code: " + exitCode); 
				     BufferedReader br = new BufferedReader(new InputStreamReader(dumpCFG.getInputStream()));
				    while(br.ready())     {System.out.println("cfgDump input stream:"+br.readLine());} 
				    br.close();
				    br = new BufferedReader(new InputStreamReader(dumpCFG.getErrorStream()));
				    while(br.ready())     {System.out.println("cfgDump error stream:"+br.readLine());} 
				    br.close();

				 
	}
}
