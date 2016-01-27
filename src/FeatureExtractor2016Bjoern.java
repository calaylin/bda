import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang3.StringUtils;


public class FeatureExtractor2016Bjoern {

	public static void main(String[] args) throws IOException, InterruptedException{
		
	
		String test_dir ="/Users/Aylin/Desktop/test/";
		       		
		String output_filename = "/Users/Aylin/Desktop/Princeton/"
		+ "BAA/datasets/c++/optimizations/L1_150authors_2016bjoern.arff" ;

		List test_binary_paths = Util.listBinaryFiles(test_dir);

		String text = "";
		//Writing the test arff
		Util.writeFile("@relation "+test_dir +"2016bjoern"+"\n"+"\n",
		    			output_filename, true);
		Util.writeFile("@attribute instanceID_original {", output_filename, true);

		   	for(int j=0; j < test_binary_paths.size();j++ )
			{
				File sourceFile = new File(test_binary_paths.get(j).toString());
				String fileName = sourceFile.getName() +"_"+ sourceFile.getParentFile().getParentFile().getName();
				Util.writeFile(fileName+",", output_filename, true);
				if ((j+1)==test_binary_paths.size()){
				Util.writeFile("}"+"\n", output_filename, true);
				}
			}

	
			System.out.println("done with cfgUnigrams");

			Thread.sleep(10000000);
			
			//CFG NODE UNIGRAMS - REPR
			//get the basic block node unigrams in bjoern CFG and write the node unigram features
		   	String[] bjoernCFGNodeUnigrams =getBjoernCFGGraphmlNodeUnigrams(test_dir);
				for (int i=0; i<bjoernCFGNodeUnigrams.length; i++){  
					//  System.out.println("@attribute 'bjoernCFGNodeUnigrams"+i+ " "+bjoernCFGNodeUnigrams[i]);
				 //  	Util.writeFile("@attribute 'BjoernCFGGraphmlNodeUnigrams "+i+"=["+bjoernCFGNodeUnigrams[i]+"]' numeric"+ "\n", output_filename, true);
			       }
				
			
		   	//DISASSEMBLY INSTRUCTION UNIGRAMS
			//get the instruction unigrams in bjoern disassembly and write the instruction unigram features
			String[] bjoernDisassemblyUnigrams =getBjoernDisassemblyInstructionUnigrams(test_dir);
			for (int i=0; i<bjoernDisassemblyUnigrams.length; i++){  
				//	bjoernDisassemblyUnigrams[i] = bjoernDisassemblyUnigrams[i].replace("\n", " ");
				//  System.out.println("@attribute 'bjoernDisassemblyUnigrams"+i+ " "+bjoernDisassemblyUnigrams[i]);
			   	Util.writeFile("@attribute 'BjoernDisassemblyInstructionUnigrams "+i+"=["+bjoernDisassemblyUnigrams[i]+"]' numeric"+ "\n", output_filename, true);
		       }
		 
		   	//DISASSEMBLY INSTRUCTION BIGRAMS
		   	//get the instruction bigrams in bjoern disassembly and write the instruction bigram features
			String[] bjoernDisassemblyBigrams =getBjoernDisassemblyInstructionBigrams(test_dir);
		   	for (int i=0; i<bjoernDisassemblyBigrams.length; i++){  
		//   	System.out.println("@attribute 'BjoernDisassemblyInstructionBigrams"+i+ " "+bjoernDisassemblyBigrams[i]);
	    		Util.writeFile("@attribute 'BjoernDisassemblyInstructionBigrams "+i+"=["+bjoernDisassemblyBigrams[i]+"]' numeric"+ "\n", output_filename, true);
		   	}
		   	
		   	//DISASSEMBLY INSTRUCTION TRIGRAMS
		   	//get the instruction trigrams in bjoern disassembly and write the instruction trigram features
			String[] bjoernDisassemblyTrigrams =getBjoernDisassemblyInstructionTrigrams(test_dir);
		   	for (int i=0; i<bjoernDisassemblyTrigrams.length; i++){  
		   	//	System.out.println("@attribute 'BjoernDisassemblyInstructionTrigrams"+i+ " "+bjoernDisassemblyTrigrams[i]);
	    		Util.writeFile("@attribute 'BjoernDisassemblyInstructionTrigrams "+i+"=["+bjoernDisassemblyTrigrams[i]+"]' numeric"+ "\n", output_filename, true);
		   	}
		   	
		   	//DISASSEMBLY LINE UNIGRAMS
		   	//get the line unigrams in bjoern disassembly and write the line unigram features
		       String[] disassemblyLineUnigrams =getBjoernLineUnigrams(test_dir);
		    	for (int i=0; i<disassemblyLineUnigrams.length; i++)	   	
		       {  	//disassemblyLineUnigrams[i] = disassemblyLineUnigrams[i].replace("\n", " ");
		           	Util.writeFile("@attribute 'disassemblyLineUnigrams "+i+"=["+disassemblyLineUnigrams[i]+"]' numeric"+"\n", output_filename, true);
        		//	System.out.println("@attribute 'disassemblyLineUnigrams "+i+"=["+disassemblyLineUnigrams[i]+"]");
		       }		
		    	
			 //DISASSEMBLY LINE BIGRAMS
		   	//get the line bigrams in bjoern disassembly and write the line bigram features
		    	String[] disassemblyLineBigrams =getBjoernLineBigrams(test_dir);
		    	for (int i=0; i<disassemblyLineBigrams.length; i++)	   	
		    	{  	//disassemblyLineBigrams[i] = disassemblyLineBigrams[i].replace("\n", " ");
		    	Util.writeFile("@attribute 'disassemblyLineBigrams "+i+"=["+disassemblyLineBigrams[i]+"]' numeric"+"\n", output_filename, true);
		    	//	System.out.println("@attribute 'disassemblyLineBigrams "+i+"=["+disassemblyLineBigrams[i]+"]");
		    	}		    	
	
		     	
		    File authorFileName = null;
			//Writing the classes (authorname)
			Util.writeFile("@attribute 'authorName_original' {",output_filename, true);
			for(int i=0; i< test_binary_paths.size(); i++){
				authorFileName= new File(test_binary_paths.get(i).toString());
				String authorName= authorFileName.getParentFile().getName() +
						"_"+authorFileName.getParentFile().getParentFile().getName() ;
				text = text.concat(authorName + ",");  
				String[] words = text.split( ",");
				Set<String> uniqueWords = new HashSet<String>();
				   for (String word : words) {
				       uniqueWords.add(word);
				   }
				words = uniqueWords.toArray(new String[0]);
				int authorCount = words.length;
				if (i+1==test_binary_paths.size()){
				   for (int j=0; j< authorCount; j++){
					   {System.out.println(words[j]);
						if(j+1 == authorCount){
							Util.writeFile(words[j]+"}"+"\n\n",output_filename, true);
							}
						else{
						Util.writeFile(words[j]+","+"",output_filename, true);
							}
						}
				   }
				}		   
			}
			
			Util.writeFile("@data"+"\n", output_filename, true);	
			//Finished defining the attributes
			//starting to write the feature vectors
			
			
			//EXTRACT LABELED FEATURES FROM CORRESPONDING FEATURE DATA SOURCES
		   	for(int i=0; i< test_binary_paths.size(); i++){
				authorFileName= new File(test_binary_paths.get(i).toString());
				String authorName= authorFileName.getParentFile().getName() +
						"_"+authorFileName.getParentFile().getParentFile().getName();
				System.out.println(test_binary_paths.get(i));
				System.out.println(authorName);
				File fileCPPID = new File(test_binary_paths.get(i).toString());
				String fileNameID = fileCPPID.getName() +
						"_"+authorFileName.getParentFile().getParentFile().getName();
				Util.writeFile(fileNameID+",", output_filename, true);
				String featureTextBjoernDisassembly = Util.readFile(authorFileName.getParentFile()
				+ File.separator + fileCPPID.getName()+"_bjoernDisassembly"+ File.separator + "nodes.csv");

				
				
				//GETTING CFH NODE UNIGRAMS
				List graphmlCFGFiles = listBjoernCFGGraphmlFiles(authorFileName.getParentFile()
						+ File.separator + fileCPPID.getName()+"_bjoernDisassembly"+ 
						File.separator + fileCPPID.getName()+"CFG"+File.separator);
				
				int len = bjoernCFGNodeUnigrams.length;
				float[] cfgNodeUniCount = new float[len];
			    float[] tmp = new float[len];
			    Arrays.fill(tmp, 0);


				for(int i1=0; i1< graphmlCFGFiles.size();i1++){
				String featureTextCFG = Util.readFile(graphmlCFGFiles.get(i1).toString()) ;
				//get count of each cfg node unigram in CFGBjoern 
			   cfgNodeUniCount = getBjoernCFGGraphmlNodeUnigramsTF(featureTextCFG , bjoernCFGNodeUnigrams);
			    for (int j=0; j<cfgNodeUniCount.length; j++){
			    	cfgNodeUniCount[j]=cfgNodeUniCount[j]+tmp[j];
					tmp[j]= cfgNodeUniCount[j];	
				}
				}
				//DONE WITH CFG NODE UNIGRAMS

			    for (int j=0; j<cfgNodeUniCount.length; j++){
				Util.writeFile(cfgNodeUniCount[j] +",", output_filename, true);
				}
			    
			    //get count of each instruction unigram in disassemblyBjoern 
			    float[] wordUniCount = getBjoernDisassemblyInstructionUnigramsTF(featureTextBjoernDisassembly, bjoernDisassemblyUnigrams);
			    for (int j=0; j<wordUniCount.length; j++)
				{Util.writeFile(wordUniCount[j] +",", output_filename, true);}	
			    
			    //get count of each instruction bigram in disassemblyBjoern	 
			    float[] wordBigramCount = getBjoernDisassemblyInstructionBigramsTF(featureTextBjoernDisassembly, bjoernDisassemblyBigrams);
			    for (int j=0; j<wordBigramCount.length; j++)
				{Util.writeFile(wordBigramCount[j] +",", output_filename, true);}

			    //get count of each instruction trigram in disassemblyBjoern	 
			    float[] wordTrigramCount = getBjoernDisassemblyInstructionTrigramsTF(featureTextBjoernDisassembly, bjoernDisassemblyTrigrams);
			    for (int j=0; j<wordTrigramCount.length; j++)
				{Util.writeFile(wordTrigramCount[j] +",", output_filename, true);}

			    //get count of each line unigram in disassemblyBjoern	 
			    float[] lineUnigramCount = getBjoernLineUnigramsTF(featureTextBjoernDisassembly, disassemblyLineUnigrams);
			    for (int j=0; j<lineUnigramCount.length; j++)
				{Util.writeFile(lineUnigramCount[j] +",", output_filename, true);}
			    
			    //get count of each line bigram in disassemblyBjoern	 
			    float[] lineBigramCount = getBjoernLineBigramsTF(featureTextBjoernDisassembly, disassemblyLineBigrams);
			    for (int j=0; j<lineBigramCount.length; j++)
				{Util.writeFile(lineBigramCount[j] +",", output_filename, true);}
			    
			    
				Util.writeFile(authorName+"\n", output_filename, true);
		   	}
	}
		       	
		   	
		
		
		
	public static String [] getBjoernLineUnigrams(String dirPath) throws IOException{
		
		List test_file_paths = listBjoernNodeFiles(dirPath);
		String[] uniqueLineUnigrams = null;
		Set<String> lineUnigrams = new LinkedHashSet<String>();
		String filePath="";

 	    for(int i=0; i< test_file_paths.size(); i++){	
 	    	filePath = test_file_paths.get(i).toString();  
		//	System.out.println(filePath);						   
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line;
		String[] arr;
		
		while ((line = br.readLine()) != null)
		{
			arr = line.split("\\s+",5);
/*			if ( !arr[4].isEmpty()){
			System.out.println("Redundant " + arr[0] 
		    + " , needed " + arr[4]);
		    }*/
			line = arr[4];
			line =	line.replaceAll("\\\"", " ");	
			line =line.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
			line =line.replaceAll("\\d+", "number");
			line =line.replaceAll("\\s+", " ");	
			if (!line.isEmpty()){
				lineUnigrams.add(line.trim());
			//	System.out.println("line unigram:"+ line.trim());
				}
 	    }
		br.close();
	}	         
 	uniqueLineUnigrams = lineUnigrams.toArray(new String[lineUnigrams.size()]);
	return uniqueLineUnigrams;		
	}	
	
	
    public static float [] getBjoernLineUnigramsTF (String featureText, String[] lineUnigrams  )
    {    	
    	String str;
    	float symbolCount = lineUnigrams.length;
    	float [] counter = new float[(int) symbolCount];
 		featureText=	featureText.replaceAll("\\\"", " ");	
 		featureText=	featureText.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
 		featureText=	featureText.replaceAll("\\d+", "number");
 		featureText=	featureText.replaceAll("\\n", " ");	
 		featureText=	featureText.replaceAll("\\s+", " ");
 		for (int i =0; i<symbolCount; i++){
 			str = lineUnigrams[i].toString();
 			counter[i] = StringUtils.countMatches(featureText, str.trim()); 
 		} 
 		return counter;
    }	

	public static String [] getBjoernLineBigrams(String dirPath) throws IOException{
	
		List test_file_paths = listBjoernNodeFiles(dirPath);
		String[] uniqueLineBigrams = null;
		Set<String> lineBigrams = new LinkedHashSet<String>();
		String filePath="";

 	    for(int i=0; i< test_file_paths.size(); i++){	
 	    	filePath = test_file_paths.get(i).toString();  
		//	System.out.println(filePath);						   
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line;
		String tmp="";
		String[] arr;
		
		while ((line = br.readLine()) != null)
		{
			arr = line.split("\\s+",5);
/*			if ( !arr[4].isEmpty()){
			System.out.println("Redundant " + arr[0] 
		    + " , needed " + arr[4]);
		    }*/
//			A	"Instr_134515592"	"Instr"	"134515592"	"1"	"jmp 0x8048c7f"	"e9f2000000"		"0x8048c7f,eip,="
//			ANR	"Root_134515265"	"Root"	"134515265"
			
			line = arr[4];
			line =	line.replaceAll("\\\"", " ");	
			line =line.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
			line =line.replaceAll("\\d+", "number");
			line =line.replaceAll("\\s+", " ");	
			if (!line.isEmpty()){
				lineBigrams.add(tmp.trim() + " "+ line.trim());
				//System.out.println("line bigram:"+tmp.trim() + " "+ line.trim());
				//System.out.println("line:"+tmp.trim() );
				tmp = line;		
				}
 	    }
		br.close();
	}	         
 	uniqueLineBigrams =   lineBigrams.toArray(new String[lineBigrams.size()]);
	return uniqueLineBigrams;		
	}	
	
    public static float [] getBjoernLineBigramsTF (String featureText, String[] lineBigrams  )
    {    	
    	//improve this by reading bjoern disassembly's columns > 4
    	String str;
    	float symbolCount = lineBigrams.length;
    	float [] counter = new float[(int) symbolCount];
 //   	A	"Instr_134515592"	"Instr"	"134515592"	"1"	"jmp 0x8048c7f"	"e9f2000000"		"0x8048c7f,eip,="
 //   	ANR	"Root_134515265"	"Root"	"134515265"
 		featureText=	featureText.replaceAll("\\\"", " ");	
 		featureText=	featureText.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
 		featureText=	featureText.replaceAll("\\d+", "number");
 		featureText=	featureText.replaceAll("\\s+", " ");
 		featureText=	featureText.replaceAll("ANR Root_number Root number "," ");
 		featureText=	featureText.replaceAll("ANR Func_number Func number "," ");
 		featureText=	featureText.replaceAll("A Instr_number Instr number "," ");
 		featureText=	featureText.replaceAll("A Flag_number Flag number "," ");
// 		featureText=	featureText.replaceAll(" "," ");
		featureText=	featureText.replaceAll("\\n", " ");	
 		featureText=	featureText.replaceAll("\\s+", " ");
		System.out.println("this is featureText"+featureText);
		Util.writeFile(featureText, "/Users/Aylin/Desktop/tesstfeat.txt", true);

 		for (int i =0; i<symbolCount; i++){
 			str = lineBigrams[i].toString();
 			counter[i] = StringUtils.countMatches(featureText, str.trim()); 
 		} 
 		return counter;
    }

	
	
	public static String [] getBjoernDisassemblyInstructionUnigrams(String dirPath) throws IOException{
		
	
		List  test_file_paths = listBjoernNodeFiles(dirPath);
		String[] words = null;
		Set<String> uniGrams = new LinkedHashSet<String>();
		String filePath="";
 	    for(int i=0; i< test_file_paths.size(); i++){
 	    	
 	    	filePath = test_file_paths.get(i).toString();  
		//	System.out.println(filePath);						   
			   String[] arr;
			   String[] toAdd;

				BufferedReader br = new BufferedReader(new FileReader(filePath));
				String line;
				
				while ((line = br.readLine()) != null)
				{					
					arr = line.split("\\s+",5);
						if ( !arr[4].isEmpty()){
				//		System.out.println("Redundant " + arr[0] + " , needed " + arr[4]  );
					    line = arr[4];			
						line = line.replaceAll("\\\"", " ");	
					//	line = line.replaceAll("^[A-Fa-f0-9]+$", "hexadecimal");
						line = line.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
						line = line.replaceAll("\\d+", "number");
						line =line.replaceAll("\\s+", " ");	
						toAdd = line.trim().split("\\s+");
					//	System.out.println("line: "+line);
						for(int i11 =0; i11< toAdd.length; i11++)
							{
						uniGrams.add(toAdd[i11].trim());
					//	System.out.println(toAdd[i11]);
		            		}		
						}
				}	
				br.close();			
 	    }	 	      
 	    		words =   uniGrams.toArray(new String[uniGrams.size()]);
			    return words;		
	}
	

	
	public static String [] getBjoernCFGGraphmlNodeUnigrams(String dirPath) throws IOException{
		
		
		List  test_file_paths = listBjoernCFGGraphmlFiles(dirPath);
		String[] words = null;
		Set<String> uniGrams = new LinkedHashSet<String>();
		String filePath="";
		
		// add newline after </node>
		//then do a csv split
		//if the line contains BB node, take its repr
 	    for(int i=0; i< test_file_paths.size(); i++){
 	    	
 	    	filePath = test_file_paths.get(i).toString();  
			//System.out.println(filePath);						   
			   String[] arr;
			   String[] toAdd;

				BufferedReader br = new BufferedReader(new FileReader(filePath));
				 String line;
				
				while ((line = br.readLine()) != null)
				{	

						line = line.replaceAll("<node id=", "\n <node id=");	
						line = line.replaceAll("<edge id=", "\n <edge id=");	
						BufferedReader br2 = new BufferedReader(new StringReader(line));
						//	System.out.println("unprocessed line: "+line);
						String node;
						while ((node = br2.readLine()) != null)
						{	
						if(node.contains(">BB</data>")){
					//	System.out.println("line: "+node);
						arr = node.split("data key=",5);
						node = arr[1];	
						node = node.replaceAll("\\\"repr\\\">", "");	
						node = node.replaceAll("</data><", "");	
					//	node = node.replaceAll("^[A-Fa-f0-9]+$", "hexadecimal");
						node = node.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
						node = node.replaceAll("\\d+", "number");
						node =node.replaceAll("\\s+", " ");	
						System.out.println("unigram: "+node);
						
						uniGrams.add(node.trim());
					//	System.out.println(toAdd[i11]);
		            				
						}}
						br2.close();
				}	
				br.close();			
 	    }	 	      
 	    		words =   uniGrams.toArray(new String[uniGrams.size()]);
			    return words;		
	}
	
 

    public static float [] getBjoernCFGGraphmlNodeUnigramsTF(String featureText, String[] CFGGraphmlNodeUnigrams  )
    {    	
    String str;
    float symbolCount = CFGGraphmlNodeUnigrams.length;
    float [] counter = new float[(int) symbolCount];
    for (int i =0; i<symbolCount; i++){
 	  str = CFGGraphmlNodeUnigrams[i].toString();
 	
 		featureText=	featureText.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
 		featureText=	featureText.replaceAll("\\d+", "number");
 		featureText=	featureText.replaceAll("\\s+", " ");		
 		counter[i] = StringUtils.countMatches(featureText, str.trim()); 
 	 }
    return counter;
    }
	
	
    public static float [] getBjoernDisassemblyInstructionUnigramsTF (String featureText, String[] wordUnigrams  )
    {    	
    String str;
    float symbolCount = wordUnigrams.length;
    float [] counter = new float[(int) symbolCount];
    for (int i =0; i<symbolCount; i++){
 	  str = wordUnigrams[i].toString();
 	
 		featureText=	featureText.replaceAll("\\\"", " ");	
 		featureText=	featureText.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
 		featureText=	featureText.replaceAll("\\d+", "number");
 		featureText=	featureText.replaceAll("\\s+", " ");		
 		counter[i] = StringUtils.countMatches(featureText, str.trim()); 
 	 }
    return counter;
    }
    
    public static String [] getBjoernDisassemblyInstructionBigrams(String dirPath) throws IOException{
    List test_file_paths = listBjoernNodeFiles(dirPath);
	Set<String> bigrams = new LinkedHashSet<String>();
	String[] uniquebigrams = null;
	String filePath="";

	    for(int i=0; i< test_file_paths.size(); i++){    	
	    	filePath = test_file_paths.get(i).toString();  
	    	String[] arr;
	    	String[] toAdd;
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;		
			while ((line = br.readLine()) != null)
			{					
				arr = line.split("\\s+",5);
					if ( !arr[4].isEmpty()){
			//		System.out.println("Redundant " + arr[0] + " , needed " + arr[4]  );
				    line = arr[4];			
					line = line.replaceAll("\\\"", " ");	
					line = line.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
					line = line.replaceAll("\\d+", "number");
					line =line.replaceAll("\\s+", " ");	
					toAdd = line.trim().split("\\s+");
			//		System.out.println("line:"+line);
					if(toAdd.length > 1){
					if(toAdd[0].equals("number")){
						for(int i11 =2; i11< toAdd.length; i11++){
							bigrams.add(toAdd[i11-1].trim() + " " +toAdd[i11].trim());
			//				System.out.println("1stgram "+toAdd[i11-1]+ " " +"2ndgram "+toAdd[i11]);
						}
					}
					if(!(toAdd[0].equals("number"))){
						for(int i11 =1; i11< toAdd.length; i11++){
							bigrams.add(toAdd[i11-1].trim() + " " +toAdd[i11].trim());
			//				System.out.println("1stgram "+toAdd[i11-1]+ " " +"2ndgram "+toAdd[i11]);
						}	
					}	
			}		       
		}
	}
			br.close();
}
	    uniquebigrams = bigrams.toArray(new String[bigrams.size()]);
	    return uniquebigrams;        
    }
    
    
    public static float [] getBjoernDisassemblyInstructionBigramsTF (String featureText, String[] DisBigrams ) throws IOException
    {    
        float symbolCount = DisBigrams.length;
        float [] counter = new float[(int) symbolCount];
        String str;
        for (int i =0; i<symbolCount; i++){
        	str = DisBigrams[i].toString();
   			featureText=	featureText.replaceAll("\\\"", " ");	
   			featureText=	featureText.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
   			featureText=	featureText.replaceAll("\\d+", "number");
   			featureText=	featureText.replaceAll("\\s+", " ");	
   			counter[i] = StringUtils.countMatches(featureText, str);  	   
        }
        return counter;
}
   
    
    public static String [] getBjoernDisassemblyInstructionTrigrams(String dirPath) throws IOException{
        List test_file_paths = listBjoernNodeFiles(dirPath);
    	Set<String> trigrams = new LinkedHashSet<String>();
    	String[] uniqueTrigrams = null;
    	String filePath="";

    	    for(int i=0; i< test_file_paths.size(); i++){    	
    	    	filePath = test_file_paths.get(i).toString();  
    	    	String[] arr;
    	    	String[] toAdd;
    			BufferedReader br = new BufferedReader(new FileReader(filePath));
    			String line;		
    			while ((line = br.readLine()) != null)
    			{					
    				arr = line.split("\\s+",5);
    					if ( !arr[4].isEmpty()){
    			//		System.out.println("Redundant " + arr[0] + " , needed " + arr[4]  );
    				    line = arr[4];			
    					line = line.replaceAll("\\\"", " ");	
    					line = line.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
    					line = line.replaceAll("\\d+", "number");
    					line =line.replaceAll("\\s+", " ");	
    					toAdd = line.trim().split("\\s+");
    					//System.out.println("line:"+line);
    					if(toAdd.length > 2){
    					if(toAdd[0].equals("number")){
    						for(int i11 =3; i11< toAdd.length; i11++){
    							trigrams.add(toAdd[i11-2].trim() + " "+toAdd[i11-1].trim() + " " +toAdd[i11].trim());
    						//	System.out.println("1stgram "+toAdd[i11-2]+ " " +"2ndgram "+toAdd[i11-1]+ " " +"3rdgram "+toAdd[i11]);
    						}
    					}
    					if(!(toAdd[0].equals("number"))){
    						for(int i11 =2; i11< toAdd.length; i11++){
    							trigrams.add(toAdd[i11-2].trim() + " "+toAdd[i11-1].trim() + " " +toAdd[i11].trim());
    				    	//	System.out.println("1stgram "+toAdd[i11-2]+ " " +"2ndgram "+toAdd[i11-1]+ " " +"3rdgram "+toAdd[i11]);
    						}	
    					}	
    			}		       
    		}
    	}
    			br.close();
    }
    	    uniqueTrigrams = trigrams.toArray(new String[trigrams.size()]);
    	    return uniqueTrigrams;        
        }
    
    public static float [] getBjoernDisassemblyInstructionTrigramsTF (String featureText, String[] DisTrigrams ) throws IOException
    {    
        float symbolCount = DisTrigrams.length;
        float [] counter = new float[(int) symbolCount];
        String str;
        for (int i =0; i<symbolCount; i++){
        	str = DisTrigrams[i].toString();
   			featureText=	featureText.replaceAll("\\\"", " ");	
   			featureText=	featureText.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
   			featureText=	featureText.replaceAll("\\d+", "number");
   			featureText=	featureText.replaceAll("\\s+", " ");	
   			counter[i] = StringUtils.countMatches(featureText, str);  	   
        }
        return counter;
}
	public static List <File> listBjoernEdgeFiles(String dirPath)
    {
        File topDir = new File(dirPath);
        List<File> directories = new ArrayList<>();
        directories.add(topDir);
        List<File> textFiles = new ArrayList<>();
        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*edges.csv");
        FileFilter typeFilter = new WildcardFileFilter(filterWildcards);
        while (directories.isEmpty() == false)
        {
            List<File> subDirectories = new ArrayList<File>();
            for(File f : directories)
            {
                subDirectories.addAll(Arrays.asList(f.listFiles((FileFilter)DirectoryFileFilter.INSTANCE)));
                textFiles.addAll(Arrays.asList(f.listFiles(typeFilter)));
            }
            directories.clear();
            directories.addAll(subDirectories);
        }
        Collections.sort(textFiles);
        return textFiles;
}
    
	public static List <File> listBjoernNodeFiles(String dirPath)
    {
        File topDir = new File(dirPath);
        List<File> directories = new ArrayList<>();
        directories.add(topDir);
        List<File> textFiles = new ArrayList<>();
        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*nodes.csv");
        FileFilter typeFilter = new WildcardFileFilter(filterWildcards);

        while (directories.isEmpty() == false)
        {
            List<File> subDirectories = new ArrayList<File>();
            for(File f : directories)
            {
                subDirectories.addAll(Arrays.asList(f.listFiles((FileFilter)DirectoryFileFilter.INSTANCE)));
                textFiles.addAll(Arrays.asList(f.listFiles(typeFilter)));
            }
            directories.clear();
            directories.addAll(subDirectories);
        }
        Collections.sort(textFiles);
        return textFiles;
    }
	
	public static List <File> listBjoernCFGGraphmlFiles(String dirPath)
    {
        File topDir = new File(dirPath);
        List<File> directories = new ArrayList<>();
        directories.add(topDir);
        List<File> textFiles = new ArrayList<>();
        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*.graphml");
        FileFilter typeFilter = new WildcardFileFilter(filterWildcards);

        while (directories.isEmpty() == false)
        {
            List<File> subDirectories = new ArrayList<File>();
            for(File f : directories)
            {
                subDirectories.addAll(Arrays.asList(f.listFiles((FileFilter)DirectoryFileFilter.INSTANCE)));
                textFiles.addAll(Arrays.asList(f.listFiles(typeFilter)));
            }
            directories.clear();
            directories.addAll(subDirectories);
        }
        Collections.sort(textFiles);
        return textFiles;
    }
}
