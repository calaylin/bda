import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;

import javax.script.ScriptException;

import org.apache.commons.exec.ExecuteException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class bjoernGenerateGraphmlCFG {
	

	public static void main(String[] args) throws IOException, InterruptedException, ScriptException{
		
		String folderToProcess = "/Users/Aylin/Desktop/test/";
				//"/Users/Aylin/Desktop/Princeton/"+ "BAA/datasets/c++/optimizations/100authors_strippedS/";

		//Start server for once
		//./Users/Aylin/git/bjoern-radare/bjoern-server.shh 
		// orientdb-community-2.1.5/bin/server.sh
		 Runtime run = Runtime.getRuntime();
		 Process runScript;
		   runScript = run.exec(new String[]{"/bin/bash", "-c",
			//		"export PATH=$PATH:/usr/local/bin/: \n"+
					"cd /Users/Aylin/git/bjoern-radare/ \n" +
			//	    "/bin/bash /Users/Aylin/git/bjoern-radare/orientdb-community-2.1.5/bin/shutdown.sh \n"	 
			    "/bin/bash /Users/Aylin/git/bjoern-radare/bjoern-server.sh \n"
			//	"/bin/bash /Users/Aylin/git/bjoern-radare/orientdb-community-2.1.5/bin/server.sh \n"	 
			 
				 });
				
				 runScript.waitFor();
			     BufferedReader br = new BufferedReader(new InputStreamReader(runScript.getInputStream()));

			     while(br.ready())
			     {  System.out.println("input stream:"+br.readLine());}
			     br.close();
			     BufferedReader br2 = new BufferedReader(new InputStreamReader(runScript.getErrorStream()));
			     while(br2.ready())
			     {  System.out.println("error stream:"+br2.readLine());}
			     br2.close();
				 int exitCode = runScript.exitValue();
				 System.out.println("Process exit code: " + exitCode); 

		List binary_paths = Util.listBinaryFiles(folderToProcess);
		for(int i=0; i< binary_paths.size(); i++){
			bjoernGenerateCFG(binary_paths.get(i).toString());
		}
		
		for(int i=0; i< binary_paths.size(); i++){
			dumpCFG(binary_paths.get(i).toString());
		}
		//kill server
		runScript = run.exec(new String[]{"/bin/bash", "-c",
				    "/bin/bash /Users/Aylin/git/bjoern-radare/orientdb-community-2.1.5/bin/shutdown.sh"	 
				 });
		 runScript.waitFor();
		 BufferedReader br21 = new BufferedReader(new InputStreamReader(runScript.getInputStream()));
		 while(br21.ready())
		 {	System.out.println(br21.readLine());}
		 br21.close();
	}
	
	public static void bjoernGenerateCFG(String filePath) throws IOException, InterruptedException, ScriptException{
		//disassembles binary in filePath with bjoern-radare to outdir 
		//generates the cfgs in outdir
	
		
		
		File processing = new File(filePath);
		String path = FilenameUtils.getPath(filePath);
		String filename = processing.getName();
		 String outdir = File.separator + path + filename +"_bjoernDisassembly" + File.separator ;
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
					  "chmod 777 /Users/Aylin/git/bjoern-radare/bjoern-radare2.sh \n"

					 });
		  
				       fileProcess.waitFor();
				        BufferedReader br = new BufferedReader(new InputStreamReader(fileProcess.getInputStream()));
				       while(br.ready())
				           System.out.println(br.readLine());
				       br.close();
				       
				       
		//	File cfgDB = new File(cfgDBFolder+ dbName );
		//	System.out.println(cfgDB);
			/*if(cfgDB.exists()){	       
			 fileProcess = run.exec(new String[]{"/bin/sh", "-c",
							  "rm -r "+ outdir+dbName +" \n"
							 });
				  
			fileProcess.waitFor();
			br = new BufferedReader(new InputStreamReader(fileProcess.getInputStream()));
			while(br.ready())
			System.out.println(br.readLine());}*/
		
			 Runtime runBjoern = Runtime.getRuntime();
			Process runScript = runBjoern.exec(new String[]{"/bin/bash", "-c",
				"cd /Users/Aylin/git/bjoern-radare/ \n"
			    +"/bin/bash /Users/Aylin/git/bjoern-radare/bjoern-radare2.sh \n"+
			    "tail -n+2 "+outdirTMP+"nodes.csv | sort -r | uniq > "+ outdirTMP +"nodes.csv_ \n"+
			    "tail -n+2 "+outdirTMP+"edges.csv | sort -r | uniq > "+outdirTMP+"edges.csv_ \n"+

			    "head -n 1 "+outdirTMP+"nodes.csv > "+outdirTMP+"nodeHead.csv \n"+
			    "head -n 1 "+outdirTMP+"edges.csv > "+outdirTMP+"edgeHead.csv \n"+

/*			    "cat "+outdirTMP+"nodeHead.csv >  "+outdirTMP+"nodes.csv \n"+
			    "cat "+outdirTMP+"nodes.csv_ >> "+outdirTMP+"nodes.csv \n"+

			    "cat "+outdirTMP+"edgeHead.csv > "+outdirTMP+"edges.csv \n"+
			    "cat "+outdirTMP+"edges.csv_ >> "+outdirTMP+"edges.csv \n"+*/

			    "cat "+outdirTMP+"nodeHead.csv >  nodes.csv \n"+
			    "cat "+outdirTMP+"nodes.csv_ >> nodes.csv \n"+

			    "cat "+outdirTMP+"edgeHead.csv > edges.csv \n"+
			    "cat "+outdirTMP+"edges.csv_ >> edges.csv \n"+
			    
			//    "/bin/bash /Users/Aylin/git/bjoern-radare/bjoern-csvimport.sh -dbname "+dbName + " \n"
		    "export PATH=$PATH:/usr/local/bin/ \n"+   
			"java -cp /Users/Aylin/git/bjoern-radare/bin/bjoern.jar:/usr/local/bin/ "
			+ "clients.bjoernImport.BjoernImport -dbname "+dbName + " \n"
			 });
			 
			 runScript.waitFor(); 
			 System.out.println(filename +": importing binary");
			 br = new BufferedReader(new InputStreamReader(runScript.getInputStream()));
		     while(br.ready()) {System.out.println("import input stream:"+br.readLine());}
		     br = new BufferedReader(new InputStreamReader(runScript.getErrorStream()));
		     while(br.ready()) {System.out.println("import error stream:"+br.readLine());}
		     
	}
	
	
	public static void dumpCFG(String filePath) throws IOException, InterruptedException, ScriptException{
		//disassembles binary in filePath with bjoern-radare to outdir 
		//generates the cfgs in outdir
	
		
		
		File processing = new File(filePath);
		String path = FilenameUtils.getPath(filePath);
		String filename = processing.getName();
		 String outdir = File.separator + path + filename +"_bjoernDisassembly" + File.separator ;
		 String outdirTMP = File.separator + path + filename +"_bjoernDisassembly" + File.separator +"bjoernCFG"+File.separator;
		 String dbName = filename +"CFG" ;
		 File outputTMP = new File(outdirTMP);
		 outputTMP.mkdir();
		 
       //  System.out.println("outdir: "+outdir);
        // System.out.println("filepath: "+filePath);
//         System.out.println("path: "+path);


			String cfgDBFolder ="/Users/Aylin/git/bjoern-radare/orientdb-community-2.1.5/databases/";

			 Runtime dumpTime = Runtime.getRuntime();
		     Process dumpCFG = dumpTime.exec(new String[]{"/bin/bash", "-c",
		    		 "curl http://localhost:2480/dumpcfg/"+ dbName + " \n"+
		    			"mv /Users/Aylin/git/bjoern-radare/dump/cfg/"+dbName +  " " + outdir  + " \n"+
					    "rm -rf "+outdirTMP+" \n"+
					    "rm -rf /Users/Aylin/git/bjoern-radare/dump/cfg/"+ dbName+" \n"+
					    "rm -rf "+cfgDBFolder+ dbName +"\n"
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
			
			//remove DB
		//	File cfgDB = new File(cfgDBFolder+ dbName ); 
		//	FileUtils.deleteDirectory(cfgDB );
				 
	}
}
