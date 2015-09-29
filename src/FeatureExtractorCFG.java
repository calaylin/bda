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


public class FeatureExtractorCFG {

	public static void main(String[] args) throws IOException{
		
	
    				String test_dir ="/Users/Aylin/Desktop/Princeton/BAA/datasets/"
    						+ "c++/test/";
		       		
		        	String output_filename = "/Users/Aylin/Desktop/Princeton/"
		        			+ "BAA/arffs/"
		        			+ "testCFG.arff" ;

		        	
		        	

		           	List test_dot_paths = Util.listDotFiles(test_dir);
			
		 
		        		

		    	String text = "";
		      	//Writing the test arff
		      	//first specify relation
		    	Util.writeFile("@relation "+"CFGfeatures"+"\n"+"\n",
		    			output_filename, true);
		    	Util.writeFile("@attribute instanceID {", output_filename, true);
		  
		    	


		   	for(int j=0; j < test_dot_paths.size();j++ )
			{
				File sourceFile = new File(test_dot_paths.get(j).toString());
				String fileName = sourceFile.getName().replace(".dot", "");
				Util.writeFile(fileName+",", output_filename, true);
				if ((j+1)==test_dot_paths.size())
					Util.writeFile("}"+"\n", output_filename, true);
			}


		   	//get the Unigrams in the disassembly and write the unigram features
		       String[] cfgUnigrams =getCFGUnigrams(test_dir);
		    	for (int i=0; i<cfgUnigrams.length; i++)	   	
		       {  	cfgUnigrams[i] = cfgUnigrams[i].replace("'", "apostrophesymbol");
		            	Util.writeFile("@attribute 'CFGUnigrams "+i+"=["+cfgUnigrams[i]+"]' numeric"+"\n", output_filename, true);}
			   
		   	
		    	//get the bigrams in the disassembly and write the bigram features
		    	String[] cfgBigrams =getCFGBigrams(test_dir);
		     	for (int i=0; i<cfgBigrams.length; i++)	   	
			       {  	cfgBigrams[i] = cfgBigrams[i].replace("'", "apostrophesymbol");
			            	Util.writeFile("@attribute 'CFGBigrams "+i+"=["+cfgBigrams[i]+"]' numeric"+"\n", output_filename, true);}


		    File authorFileName = null;
			//Writing the classes (authorname)
			Util.writeFile("@attribute 'authorName_original' {",output_filename, true);
			for(int i=0; i< test_dot_paths.size(); i++){
				int testIDlength = test_dot_paths.get(i).toString().length();   
				authorFileName= new File(test_dot_paths.get(i).toString());
				String authorName= authorFileName.getParentFile().getName();

				text = text.concat(authorName + ",");  
				String[] words = text.split( ",");
				  Set<String> uniqueWords = new HashSet<String>();

				   for (String word : words) {
				       uniqueWords.add(word);
				   }
				   words = uniqueWords.toArray(new String[0]);
				   int authorCount = words.length;
				   if (i+1==test_dot_paths.size()){
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
		   	for(int i=0; i< test_dot_paths.size(); i++){
				String featureText = Util.readFile(test_dot_paths.get(i).toString());
				int testIDlength = test_dot_paths.get(i).toString().length(); 
				authorFileName= new File(test_dot_paths.get(i).toString());
				String authorName= authorFileName.getParentFile().getName();

				System.out.println(test_dot_paths.get(i));
				System.out.println(authorName);
				File fileCPPID = new File(test_dot_paths.get(i).toString());
				String fileNameID = fileCPPID.getName().replace(".dot", "");
				Util.writeFile(fileNameID+",", output_filename, true);
				String disText = Util.readFile(test_dot_paths.get(i).toString());

				
		   
				    
			    //get count of each wordUnigram in disassembly 
			    float[] wordUniCount = getCFGUnigramTF(disText, cfgUnigrams);
			    for (int j=0; j<wordUniCount.length; j++)
				{Util.writeFile(wordUniCount[j] +",", output_filename, true);}	
			    
			    //get count of each bigram in in disassembly	 
			    float[] wordBigramCount = getCFGBigramsTF(disText, cfgBigrams);
			    for (int j=0; j<wordBigramCount.length; j++)
				{Util.writeFile(wordBigramCount[j] +",", output_filename, true);}
			   	
		    	
				Util.writeFile(authorName+"\n", output_filename, true);

		   	
		   	}}
		       	
		   	
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String [] getCFGUnigrams(String dirPath) throws IOException{
		
	
		List  test_file_paths = Util.listDotFiles(dirPath);
		String[] words = null;
		Set<String> uniGrams = new LinkedHashSet<String>();


		String filePath="";

 	    for(int i=0; i< test_file_paths.size(); i++){
 	    	
 	    	filePath = test_file_paths.get(i).toString();  
			System.out.println(filePath);						   

				BufferedReader br = new BufferedReader(new FileReader(filePath));
				String line;
				
				while ((line = br.readLine()) != null)
				{						
						line=	line.replaceAll("[0-9]+/*\\.*[0-9]*", "0");
						line=	line.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
						line=	line.replaceAll("\"", " ");
						line=	line.replaceAll("\\];", "");
						line=	line.replaceAll("\\[shape=box,label=", " ");
						line=	line.replaceAll("\\\\n", " nodeNewline ");
						line=	line.replaceAll("\n\"];" , " ");
					//	System.out.println(line);
						uniGrams.add(line.toString());
					}
 	    }	 	       	      
 	    		words =   uniGrams.toArray(new String[uniGrams.size()]);
			    return words;
 
		
	}
	

 
 //not normalized by the number of ASTTypes in the source code in the source code
    public static float [] getCFGUnigramTF (String featureText, String[] wordUnigrams  )
    {    
    	String line = featureText;
    	line=	line.replaceAll("[0-9]+/*\\.*[0-9]*", "0");
		line=	line.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
		line=	line.replaceAll("\"", " ");
		line=	line.replaceAll("\\];", "");
		line=	line.replaceAll("\\[shape=box,label=", " ");
		line=	line.replaceAll("\\\\n", " nodeNewline ");
		line=	line.replaceAll("\n\"];" , " ");
		
    	String str;
    float symbolCount = wordUnigrams.length;
    float [] counter = new float[(int) symbolCount];
    for (int i =0; i<symbolCount; i++){
 	  str = wordUnigrams[i].toString();

 	 counter[i] = StringUtils.countMatches(line, str); 
 	 

    }
    return counter;
    }
    
    
    
    
    
    
    public static String [] getCFGBigrams(String dirPath) throws IOException{


			
    	
		List  test_file_paths = Util.listDotFiles(dirPath);
		String[] words = null;
		Set<String> uniGrams = new LinkedHashSet<String>();


		String filePath="";
		String temp = null;
 	    for(int i=0; i< test_file_paths.size(); i++){
 	    	filePath = test_file_paths.get(i).toString();  
			System.out.println(filePath);						   

				BufferedReader br = new BufferedReader(new FileReader(filePath));
				String line;
				
				while ((line = br.readLine()) != null)
				{						
						line=	line.replaceAll("[0-9]+/*\\.*[0-9]*", "0");
						line=	line.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
						line=	line.replaceAll("\"", " ");
						line=	line.replaceAll("\\];", "");
						line=	line.replaceAll("\\[shape=box,label=", " ");
						line=	line.replaceAll("\\\\n", " nodeNewline ");
						line=	line.replaceAll("\n\"];" , " ");
						uniGrams.add(temp + line);
						temp = line;
					}
 	    }	 	       	      
 	    		words =   uniGrams.toArray(new String[uniGrams.size()]);
			    return words;
 
		
	    
    }
    
    
    public static float [] getCFGBigramsTF (String featureText, String[] DisBigrams ) throws IOException
    {    
    	
    	String line = featureText;
    	line=	line.replaceAll("[0-9]+/*\\.*[0-9]*", "0");
		line=	line.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
		line=	line.replaceAll("\"", " ");
		line=	line.replaceAll("\\];", "");
		line=	line.replaceAll("\\[shape=box,label=", " ");
		line=	line.replaceAll("\\\\n", " nodeNewline ");
		line=	line.replaceAll("\n\"];" , " ");
		
    	String str;
    float symbolCount = DisBigrams.length;
    float [] counter = new float[(int) symbolCount];
    for (int i =0; i<symbolCount; i++){
 	  str = DisBigrams[i].toString();

 	 counter[i] = StringUtils.countMatches(line, str); 
 	 

    }
    return counter;

}

    
    
    
    
    
    
    
}
