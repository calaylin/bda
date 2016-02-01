import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;


public class FeatureExtractorDisassemblyNDISASM {

	public static void main(String[] args) throws IOException{
		
	
		String test_dir ="/Users/Aylin/Desktop/Princeton/"
				+ "BAA/datasets/c++/optimizations/L1_150authors/23nigam/";
				       		
		String output_filename = "/Users/Aylin/Desktop/Princeton/"
				+ "BAA/datasets/c++/optimizations/L1_150authors_ndisasm.arff" ;
		List test_binary_paths = Util.listDisFiles(test_dir);

		String text = "";
		//Writing the test arff
		//first specify relation
		Util.writeFile("@relation "+"NDISASM_Disassembly_Unigrams_Bigrams"+"\n"+"\n",
		    			output_filename, true);
		Util.writeFile("@attribute instanceID_original {", output_filename, true);

		for(int j=0; j < test_binary_paths.size();j++ )
			{
			File sourceFile = new File(test_binary_paths.get(j).toString());
			String fileName = sourceFile.getName();
			fileName = fileName.substring(0,fileName.length()-4) + "_" + sourceFile.getParentFile().getParentFile().getName();
			Util.writeFile(fileName+",", output_filename, true);
			if ((j+1)==test_binary_paths.size())
				{Util.writeFile("}"+"\n", output_filename, true);}
			}
		


    	 	//get the instruction unigrams in NDISASM disassembly and write the instruction unigram features
		    String[] disassemblyUnigrams =getNDISASMDisassemblyInstructionUnigrams(test_dir);
		    for (int i=0; i<disassemblyUnigrams.length; i++)	   	
		       {  
		    	Util.writeFile("@attribute 'NDISASMDisassemblyInstructionUnigrams "+i+"=["+disassemblyUnigrams[i]+"]' numeric"+"\n", output_filename, true);
		    	}
			   

	     	//get the instruction bigrams in NDISASM disassembly and write the instruction bigram features
		    String[] disassemblyBigrams =getNDISASMDisassemblyInstructionBigrams(test_dir);
		    for (int i=0; i<disassemblyBigrams.length; i++)	   	
		       {  	
	           	Util.writeFile("@attribute 'NDISASMDisassemblyInstructionBigrams "+i+"=["+disassemblyBigrams[i]+"]' numeric"+"\n", output_filename, true);
		       }

	     	//get the instruction bigrams in NDISASM disassembly and write the instruction bigram features
			String[] disassemblyTrigrams =getNDISASMDisassemblyInstructionTrigrams(test_dir);
			for (int i=0; i<disassemblyTrigrams.length; i++)	   	
			{  	
       	 	Util.writeFile("@attribute 'NDISASMDisassemblyInstructionTrigrams "+i+"=["+disassemblyTrigrams[i]+"]' numeric"+"\n", output_filename, true);	
			}
			    
			 //get the lineBigrams in NDISASM disassembly and write the lineBigram features
			String[] disassemblyLineBigrams =getNDISASMDisassemblyLineBigrams(test_dir);
			for (int i=0; i<disassemblyLineBigrams.length; i++)	   	
		 	{  
				Util.writeFile("@attribute 'NDISASMDisassemblyLineBigrams "+i+"=["+disassemblyLineBigrams[i]+"]' numeric"+"\n", output_filename, true);	
			}
				 
		    File authorFileName = null;
			//Writing the classes (authorname)
			Util.writeFile("@attribute 'authorName_original' {",output_filename, true);
			for(int i=0; i< test_binary_paths.size(); i++){
				authorFileName= new File(test_binary_paths.get(i).toString());
				String authorName= authorFileName.getParentFile().getName() + "_"+
						authorFileName.getParentFile().getParentFile().getName();

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
						if(j+1 == authorCount)
						{
					   Util.writeFile(words[j]+"}"+"\n\n",output_filename, true);
						}
						else
						{
						Util.writeFile(words[j]+","+"",output_filename, true);

							}
						}
					   }

				   }
				   
				 }
			
		   	
			Util.writeFile("@data"+"\n", output_filename, true);	
			//Finished defining the attributes
			
			
			//EXTRACT LABELED FEATURES
		   	for(int i=0; i< test_binary_paths.size(); i++){
				authorFileName= new File(test_binary_paths.get(i).toString());
				String authorName= authorFileName.getParentFile().getName() + "_"+
						authorFileName.getParentFile().getParentFile().getName();
				System.out.println(test_binary_paths.get(i));
				System.out.println(authorName);
				File fileCPPID = new File(test_binary_paths.get(i).toString());
				String fileNameID = fileCPPID.getName();
				fileNameID =fileNameID.substring(0, fileNameID.length()-4)+
						"_" + fileCPPID.getParentFile().getParentFile().getName();
						
						
				Util.writeFile(fileNameID+",", output_filename, true);
				String disText = Util.readFile(test_binary_paths.get(i).toString());
				String disTextNdisasm = Util.readNDISASMFile(test_binary_paths.get(i).toString());

    
				 //get count of each NDISASMDisassemblyInstructionUnigram in NDISASM disassembly 
			    float[] instructionUnigramCount = getNDISASMDisassemblyInstructionUnigramsTF(disText, disassemblyUnigrams);
			    for (int j=0; j<instructionUnigramCount.length; j++)
				{Util.writeFile(instructionUnigramCount[j] +",", output_filename, true);}	
			    
				 //get count of each NDISASMDisassemblyInstructionBigram in NDISASM disassembly 
			    float[] instructionBigramCount = getNDISASMDisassemblyInstructionBigramsTF(disText, disassemblyBigrams);
			    for (int j=0; j<instructionBigramCount.length; j++)
				{Util.writeFile(instructionBigramCount[j] +",", output_filename, true);}
			   	
				 //get count of each NDISASMDisassemblyInstructionTrigram in NDISASM disassembly 
			    float[] instructionTrigramCount = getNDISASMDisassemblyInstructionTrigramsTF(disText, disassemblyTrigrams);
			    for (int j=0; j<instructionTrigramCount.length; j++)
				{Util.writeFile(instructionTrigramCount[j] +",", output_filename, true);}
			   	
				 //get count of each NDISASMDisassemblyLineBigrams in NDISASM disassembly 
			    float[] lineBigramCount = getNDISASMDisassemblyLineBigramsTF(disTextNdisasm, disassemblyLineBigrams);
			    for (int j=0; j<lineBigramCount.length; j++)
				{Util.writeFile(lineBigramCount[j] +",", output_filename, true);}	
			    
				Util.writeFile(authorName+"\n", output_filename, true);

		   	
		   	}}
		       	
		   	
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String [] getNDISASMDisassemblyInstructionUnigrams(String dirPath) throws IOException{
		
		List  test_file_paths = Util.listDisFiles(dirPath);
		String[] words = null;
		Set<String> uniGrams = new LinkedHashSet<String>();
		String filePath="";
		
 	    for(int i=0; i< test_file_paths.size(); i++){
 	    	filePath = test_file_paths.get(i).toString();  
			String[] arr;
			String[] toAdd;
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
				
				while ((line = br.readLine()) != null)
				{
					//System.out.println("line: "+line);
					arr = line.split("\\s+",3);
					if (arr.length > 2){
/*					System.out.println("Redundant " + arr[0] 
		                                 + " , needed " + arr[2] 
		                            );*/	
			   		arr[2]=	arr[2].replaceAll("\\\"", " ");
			//		arr[2]=	arr[2].replaceAll(",", " ");
			//		arr[2]=	arr[2].replaceAll("\\+", " ");
			//		arr[2]=	arr[2].replaceAll("\\-", " ");
					arr[2]=	arr[2].replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
					arr[2]=	arr[2].replaceAll("\\d+", "number");
					arr[2]=	arr[2].replaceAll("\\s+", " ");
					//System.out.println("line processed: "+arr[2]);
					toAdd = arr[2].split("\\s+");
					for(int i1 =0; i1< toAdd.length; i1++)
						{
						uniGrams.add(toAdd[i1]);
						//System.out.println("unigram "+i1+": "+toAdd[i1]);
		            	}	
					}
				}	
			br.close();
 	    }	 	      
  	   words = uniGrams.toArray(new String[uniGrams.size()]);
 	   return words;
	}
	

 
    public static float [] getNDISASMDisassemblyInstructionUnigramsTF (String featureText, String[] wordUnigrams  )
    {    
    	String str;
    	float symbolCount = wordUnigrams.length;
    	float [] counter = new float[(int) symbolCount];
    	for (int i =0; i<symbolCount; i++){	
    		//if case insensitive, make lowercase
    		//   String str = APISymbols[i].toString().toLowerCase();
    		str = wordUnigrams[i].toString();
    		//if case insensitive, make lowercase
    		//   strcounter = StringUtils.countMatches(featureText.toLowerCase(), str);
 	 
    		featureText = featureText.replaceAll("\\\"", " ");
    		featureText = featureText.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
    		featureText = featureText.replaceAll("\\d+", "number");
    		featureText = featureText.replaceAll("\\s+", " ");	
    		counter[i] = StringUtils.countMatches(featureText, str); 	
    	}
    return counter;
    }
    
    
    
    
    
    
    public static String [] getNDISASMDisassemblyInstructionBigrams(String dirPath) throws IOException{
    	List  test_file_paths = Util.listDisFiles(dirPath);
    	String[] uniqueBigrams = null;
   		Set<String> biGrams = new LinkedHashSet<String>();
   		String filePath="";
   		
         for(int i=0; i< test_file_paths.size(); i++){
        	 filePath = test_file_paths.get(i).toString();  
        	// System.out.println(filePath);						   
        	 String[] arr;
        	 String[] toAdd;
        	 BufferedReader br = new BufferedReader(new FileReader(filePath));
        	 String line;
    				
        	 while ((line = br.readLine()) != null)
        	 	{
    		//	System.out.println("line: "+line);
   				arr = line.split("\\s+",3);
   				if (arr.length > 2){
    /*					System.out.println("Redundant " + arr[0] 
    		                                 + " , needed " + arr[2] 
    		                            );*/	
    			   	arr[2]=	arr[2].replaceAll("\\\"", " ");
    		//		arr[2]=	arr[2].replaceAll(",", " ");
    		//		arr[2]=	arr[2].replaceAll("\\+", " ");
   			//		arr[2]=	arr[2].replaceAll("\\-", " ");
   					arr[2]=	arr[2].replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
   					arr[2]=	arr[2].replaceAll("\\d+", "number");
   					arr[2]=	arr[2].replaceAll("\\s+", " ");
    		//		System.out.println("line processed: "+arr[2]);
    				toAdd = arr[2].split("\\s+");
    				for(int i1 =1; i1< toAdd.length; i1++)
    					{
    					biGrams.add(toAdd[i1-1].trim() + " " +toAdd[i1].trim());
   				//		System.out.println(toAdd[i1-1]+ " " +toAdd[i1]);
   		            	}	
   					}
   				}	
        	 br.close();
     	   }	 	      
         uniqueBigrams = biGrams.toArray(new String[biGrams.size()]);
         return uniqueBigrams;
    }
    
    
    public static float [] getNDISASMDisassemblyInstructionBigramsTF (String featureText, String[] DisBigrams ) throws IOException
    {    
        float symbolCount = DisBigrams.length;
        float [] counter = new float[(int) symbolCount];
        String str;
        for (int i =0; i<symbolCount; i++){
    //if case insensitive, make lowercase
    //   String str = APISymbols[i].toString().toLowerCase();
     	  str = DisBigrams[i].toString();
    //if case insensitive, make lowercase
    //   strcounter = StringUtils.countMatches(featureText.toLowerCase(), str);
     	featureText = featureText.replaceAll("\\\"", " ");
 		featureText = featureText.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
 		featureText = featureText.replaceAll("\\d+", "number");
 		featureText = featureText.replaceAll("\\s+", " ");	
 		counter[i] = StringUtils.countMatches(featureText, str); 	
        }
        return counter;
    

}

   
    public static String [] getNDISASMDisassemblyInstructionTrigrams(String dirPath) throws IOException{
    	List  test_file_paths = Util.listDisFiles(dirPath);
    	String[] uniqueTrigrams = null;
   		Set<String> triGrams = new LinkedHashSet<String>();
   		String filePath="";
   		
         for(int i=0; i< test_file_paths.size(); i++){
        	 filePath = test_file_paths.get(i).toString();  
        	 String[] arr;
        	 String[] toAdd;
        	 BufferedReader br = new BufferedReader(new FileReader(filePath));
        	 String line;
    				
        	 while ((line = br.readLine()) != null)
        	 	{
    		//	System.out.println("line: "+line);
   				arr = line.split("\\s+",3);
   				if (arr.length > 2){
    /*					System.out.println("Redundant " + arr[0] 
    		                                 + " , needed " + arr[2] 
    		                            );*/	
    			   	arr[2]=	arr[2].replaceAll("\\\"", " ");
   					arr[2]=	arr[2].replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
   					arr[2]=	arr[2].replaceAll("\\d+", "number");
   					arr[2]=	arr[2].replaceAll("\\s+", " ");
    	//			System.out.println("line processed: "+arr[2]);
    				toAdd = arr[2].split("\\s+");
    				if(toAdd.length>2){
    				for(int i1 =2; i1< toAdd.length; i1++)
    					{
    					triGrams.add(toAdd[i1-2].trim() +" "+ toAdd[i1-1].trim() + " " +toAdd[i1].trim());
   			//			System.out.println(toAdd[i1-2].trim()+" " +toAdd[i1-1]+ " " +toAdd[i1]);
   		            	}	
   					}}
   				}	
        	 br.close();
     	   }	 	      
         uniqueTrigrams = triGrams.toArray(new String[triGrams.size()]);
         return uniqueTrigrams;
    }
    
    public static float [] getNDISASMDisassemblyInstructionTrigramsTF (String featureText, String[] DisTrigrams ) throws IOException
    {    
        float symbolCount = DisTrigrams.length;
        float [] counter = new float[(int) symbolCount];
        String str;
        for (int i =0; i<symbolCount; i++){
    //if case insensitive, make lowercase
    //   String str = APISymbols[i].toString().toLowerCase();
        	str = DisTrigrams[i].toString();
    //if case insensitive, make lowercase
    //   strcounter = StringUtils.countMatches(featureText.toLowerCase(), str);
        	featureText = featureText.replaceAll("\\\"", " ");
        	featureText = featureText.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
        	featureText = featureText.replaceAll("\\d+", "number");
        	featureText = featureText.replaceAll("\\s+", " ");	
        	counter[i] = StringUtils.countMatches(featureText, str); 	
        }
        return counter;
    }
    
    public static String [] getNDISASMDisassemblyLineBigrams(String dirPath) throws IOException{
		
    	
		List  test_file_paths = Util.listDisFiles(dirPath);
		String[] words = null;
		Set<String> lineUniGrams = new LinkedHashSet<String>();
		String filePath="";

 	    for(int i=0; i< test_file_paths.size(); i++){ 	    	
 	    	filePath = test_file_paths.get(i).toString();  
		//	System.out.println(filePath);						   
			String[] arr;
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			String tmp="";
				while ((line = br.readLine()) != null)
				{	
			   		arr = line.split("\\s+",3);
			   		if(arr.length>2){
			   		line = arr[2];
				//	System.out.println("line: "+line);	
					line = line.replaceAll("\\\"", " ");
					line = line.replaceAll("0[xX]?[0-9a-fA-F]+", "hexadecimal");
		//			line = line.replaceAll("/(0x)?[0-9a-f]+/i", "hexadecimal");	
					line = line.replaceAll("\\d+", "number");
					line = line.replaceAll("\\s+", " ");
				//	System.out.println(line);							
					lineUniGrams.add(tmp.trim() + " "+ line.trim());
				//	System.out.println("LineBigram: "+tmp.trim() + " "+ line.trim());
					tmp = line;	
					}								 
		}
	br.close();	
	}	         
	words =   lineUniGrams.toArray(new String[lineUniGrams.size()]);	
	return words;		
}	
	
    public static float [] getNDISASMDisassemblyLineBigramsTF (String featureText, String[] lineBigrams  ) throws IOException
    {    
    	
    	BufferedReader br = new BufferedReader(new StringReader(featureText));
		String[] arr;
		String tmp="";
		String line="";

		while ((line = br.readLine()) != null)
			{	
		   		arr = line.split("\\s+",3);
		   		if(arr.length>2){
		   		line = arr[2];
				line = line.replaceAll("\\\"", " ");
				line = line.replaceAll("0[xX]?[0-9a-fA-F]+", "hexadecimal");
				line = line.replaceAll("\\d+", "number");
				line = line.replaceAll("\\s+", " ");
				line = line + " " + tmp;
				tmp = line;	
				}
		   		}	
		   		
    	
    	
    String str;
    float symbolCount = lineBigrams.length;
    float [] counter = new float[(int) symbolCount];

 	for (int i =0; i<symbolCount; i++){
 		str = lineBigrams[i].toString();
 		counter[i] = StringUtils.countMatches(line, str.trim()); 
 		}
    return counter;
    
    
    }
  
    
    
}
