import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
		
	
    				String test_dir ="/mnt/data_bsd/allOptimizations/L0_150authors/";
		       		
		        	String output_filename = "/mnt/data_bsd/allOptimizations/L0_150authors_ndisasmLineBigramNAMED.arff" ;

		        	
		        	

//		           			           	List test_binary_paths = Util.listBinaryFiles(test_dir);

		        	List test_binary_paths = Util.listDisFiles(test_dir);
		           	List test_dis_paths = Util.listDisFiles(test_dir);
			
		 
		        		

		    	String text = "";
		      	//Writing the test arff
		      	//first specify relation
		    	Util.writeFile("@relation "+"Disassembly_Unigrams_Bigrams"+"\n"+"\n",
		    			output_filename, true);
		    	Util.writeFile("@attribute instanceID_original {", output_filename, true);
		  
		    	


		   	for(int j=0; j < test_binary_paths.size();j++ )
			{
				File sourceFile = new File(test_binary_paths.get(j).toString());
				String fileName = sourceFile.getName();
				Util.writeFile(fileName+",", output_filename, true);
				if ((j+1)==test_binary_paths.size())
					Util.writeFile("}"+"\n", output_filename, true);
			}

		   	
		   	//get the Unigrams in the disassembly and write the unigram features
		       String[] disassemblyLineBigrams =getDisLineBigrams(test_dir);
		    	for (int i=0; i<disassemblyLineBigrams.length; i++)	   	
		       {  
		            	Util.writeFile("@attribute 'disassemblyNDISASMLineBigrams "+i+"=["+disassemblyLineBigrams[i]+"]' numeric"+"\n", output_filename, true);}
			   
		

/*		   	//get the Unigrams in the disassembly and write the unigram features
		       String[] disassemblyUnigrams =getDisUnigrams(test_dir);
		    	for (int i=0; i<disassemblyUnigrams.length; i++)	   	
		       {  
		            	Util.writeFile("@attribute 'disassemblyUnigrams "+i+"=["+disassemblyUnigrams[i]+"]' numeric"+"\n", output_filename, true);}
			   
		   	
		    	//get the bigrams in the disassembly and write the bigram features
		    	String[] disassemblyBigrams =getDisBigrams(test_dir);
		     	for (int i=0; i<disassemblyBigrams.length; i++)	   	
			       {  	
			            	Util.writeFile("@attribute 'disassemblyBigrams "+i+"=["+disassemblyBigrams[i]+"]' numeric"+"\n", output_filename, true);}
*/

		    File authorFileName = null;
			//Writing the classes (authorname)
			Util.writeFile("@attribute 'authorName_original' {",output_filename, true);
			for(int i=0; i< test_binary_paths.size(); i++){
				int testIDlength = test_binary_paths.get(i).toString().length();   
				authorFileName= new File(test_binary_paths.get(i).toString());
				String authorName= authorFileName.getParentFile().getName();

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
				int testIDlength = test_binary_paths.get(i).toString().length(); 
				authorFileName= new File(test_binary_paths.get(i).toString());
				String authorName= authorFileName.getParentFile().getName();

				System.out.println(test_binary_paths.get(i));
				System.out.println(authorName);
				File fileCPPID = new File(test_binary_paths.get(i).toString());
				String fileNameID = fileCPPID.getName();
				Util.writeFile(fileNameID+",", output_filename, true);
				String disText = Util.readFile(test_binary_paths.get(i).toString());

				
				 //get count of each wordUnigram in disassembly 
			    float[] wordUniCount = getDisLineBigramTF(disText, disassemblyLineBigrams);
			    for (int j=0; j<wordUniCount.length; j++)
				{Util.writeFile(wordUniCount[j] +",", output_filename, true);}	
			    
			    
			   /* //get count of each wordUnigram in disassembly 
			    float[] wordUniCount = getDisUnigramTF(disText, disassemblyUnigrams);
			    for (int j=0; j<wordUniCount.length; j++)
				{Util.writeFile(wordUniCount[j] +",", output_filename, true);}	
			    
			    //get count of each bigram in in disassembly	 
			    float[] wordBigramCount = getDisBigramsTF(disText, disassemblyBigrams);
			    for (int j=0; j<wordBigramCount.length; j++)
				{Util.writeFile(wordBigramCount[j] +",", output_filename, true);}*/
			   	
		    	
				Util.writeFile(authorName+"\n", output_filename, true);

		   	
		   	}}
		       	
		   	
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String [] getDisUnigrams(String dirPath) throws IOException{
		
	
		List  test_file_paths = Util.listDisFiles(dirPath);
		String[] words = null;
		Set<String> uniGrams = new LinkedHashSet<String>();

		ArrayList<String> ar = new ArrayList<String>();

		String filePath="";
		HashSet<String> uniqueWords = new HashSet<String>();

 	    for(int i=0; i< test_file_paths.size(); i++){
 	    	
 	    	filePath = test_file_paths.get(i).toString();  
			System.out.println(filePath);						   
			   String[] arr;
			   String[] toAdd;

				BufferedReader br = new BufferedReader(new FileReader(filePath));
				String line;
				
				while ((line = br.readLine()) != null)
				{
					arr = line.split("\\s+",3);
					if (arr.length > 2){
/*					System.out.println("Redundant " + arr[0] 
		                                 + " , needed " + arr[2] 
		                            );*/
						arr[2]=	arr[2].replaceAll(",", " ");
						arr[2]=	arr[2].replaceAll("\\+", " ");
						arr[2]=	arr[2].replaceAll("\\-", " ");

						arr[2]=	arr[2].replaceAll("^[A-Fa-f0-9]+$", "hexadecimal");
					toAdd = arr[2].split("\\s+");
					for(int i1 =0; i1< toAdd.length; i1++)
						{
						if(toAdd[i1].contains("0x")){
							toAdd[i1]="hexadecimal";
						}
						uniGrams.add(toAdd[i1]);
							//	System.out.println(toAdd[i1]);
		            	}	
					}
				}
				
				
 	    }	 	      
 	      
       
 	    		words =   uniGrams.toArray(new String[uniGrams.size()]);
			    return words;
 
		
	}
	

 
 //not normalized by the number of ASTTypes in the source code in the source code
    public static float [] getDisUnigramTF (String featureText, String[] wordUnigrams  )
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
 	 
 	 if(str.equals("hexadecimal")){
 	 	 counter[i] = StringUtils.countMatches(featureText, "0x"); 
 	 }
 	 else{
 	 counter[i] = StringUtils.countMatches(featureText, str); 
 	 }

    }
    return counter;
    }
    
    
    
    
    
    
    public static String [] getDisBigrams(String dirPath) throws IOException{

    	
    

    List test_file_paths = Util.listDisFiles(dirPath);
	Set<String> bigrams = new LinkedHashSet<String>();
	String[] uniquebigrams = null;
	ArrayList<String> ar = new ArrayList<String>();
	String filePath="";

	    for(int i=0; i< test_file_paths.size(); i++){
	    	
	    	filePath = test_file_paths.get(i).toString();  
		System.out.println(filePath);						   
		   String[] arr;
		   String[] toAdd;

			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			
			while ((line = br.readLine()) != null)
			{
				arr = line.split("\\s+",3);
				if (arr.length > 2){
/*					System.out.println("Redundant " + arr[0] 
	                                 + " , needed " + arr[2] 
	                            );*/
					
/*					arr[2]=	arr[2].replaceAll(",", " ");
					arr[2]=	arr[2].replaceAll("\\+", " ");
					arr[2]=	arr[2].replaceAll("\\-", " ");*/

					arr[2]=	arr[2].replaceAll("^[A-Fa-f0-9]+$", "hexadecimal");
				toAdd = arr[2].split("\\s+");
				
				for(int i1 =1; i1< toAdd.length; i1++)
					{
					if(toAdd[i1].contains("0x")){
						toAdd[i1]="hexadecimal";}
					bigrams.add(toAdd[i1-1].trim() + " " +toAdd[i1].trim());
						//	System.out.println(toAdd[i1-1]+ " " +toAdd[i1]);
	            	}	
				}
			}
			
			
	    }	 	      
		       
    
	    uniquebigrams = bigrams.toArray(new String[bigrams.size()]);
		

	    return uniquebigrams;
	    
    }
    
    
    public static float [] getDisBigramsTF (String featureText, String[] DisBigrams ) throws IOException
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
/*     	featureText = featureText.replaceAll(",", " ");
     	featureText=  featureText.replaceAll("\\+", " ");
     	featureText=  featureText.replaceAll("\\-", " ");*/
     	featureText=  featureText.replaceAll("^[A-Fa-f0-9]+$", "hexadecimal");   	
     	 counter[i] = StringUtils.countMatches(featureText, str);  	   

        }
        return counter;
    

}

    
    
    public static String [] getDisLineBigrams(String dirPath) throws IOException{
		
    	
		List  test_file_paths = Util.listDisFiles(dirPath);
		String[] words = null;
		Set<String> uniGrams = new LinkedHashSet<String>();

		ArrayList<String> ar = new ArrayList<String>();

		String filePath="";
		HashSet<String> uniqueWords = new HashSet<String>();

 	    for(int i=0; i< test_file_paths.size(); i++){
 	    	
 	    	filePath = test_file_paths.get(i).toString();  
		//	System.out.println(filePath);						   
			   String[] arr;
			   String toAdd;

				BufferedReader br = new BufferedReader(new FileReader(filePath));
				String line;
				String tmp="";
				while ((line = br.readLine()) != null)
				{
						line =	line.replaceAll("\\\"", " ");	
						line =line.replaceAll("^[A-Fa-f0-9]+$", "hexadecimal");
						line =line.replaceAll("\\d+", "number");
						line =line.replaceAll("\\s+", " ");	
						 arr = line.split(" ",2 );
						 if(arr.length>1)
						 {line = arr[1];}						 
						 System.out.println("line1: "+line);
						 arr = line.split(" ",2 );
						 if(arr.length>1)
						 {line = arr[1];}
						 System.out.println(line);
					uniGrams.add(tmp.trim() + " "+ line.trim());
				//	System.out.println(tmp.trim() + " "+ line.trim());

				tmp = line;		
					
 	    }	 }	         
       
 	    		words =   uniGrams.toArray(new String[uniGrams.size()]);
			    return words;
 
		
	}	
	
    public static float [] getDisLineBigramTF (String featureText, String[] lineBigrams  )
    {    
    	
    	
    	
    	String str;
    float symbolCount = lineBigrams.length;
    float [] counter = new float[(int) symbolCount];
    
 		featureText=	featureText.replaceAll("\\\"", " ");	
 		featureText=	featureText.replaceAll("^[A-Fa-f0-9]+$", "hexadecimal");
 		featureText=	featureText.replaceAll("\\d+", "number");
 		featureText=	featureText.replaceAll("\\n", " ");	
 		featureText=	featureText.replaceAll("\\s+", " ");
	
	//System.out.println(featureText);
		
 		for (int i =0; i<symbolCount; i++){
 		 	  str = lineBigrams[i].toString();
 		 	
 	 counter[i] = StringUtils.countMatches(featureText, str.trim()); 
 	 }
    return counter;
    }
    
    
    
    
    
    
    
    
}
