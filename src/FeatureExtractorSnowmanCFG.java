import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
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


public class FeatureExtractorSnowmanCFG {

	public static void main(String[] args) throws IOException{
		
	
    				String test_dir ="/Users/Aylin/Desktop/Princeton/BAA/datasets/"
    						+ "c++/CFGSnowman100authors/";
		       		
		        	String output_filename = "/Users/Aylin/Desktop/Princeton/"
		        			+ "BAA/arffs/"
		        			+ "CFGSnowman100authors.arff" ;

		        	
		        	

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
		       String[] disassemblyUnigrams =FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionUnigrams(test_dir);
		    	for (int i=0; i<disassemblyUnigrams.length; i++)	   	
		       {  	disassemblyUnigrams[i] = disassemblyUnigrams[i].replace("'", "apostrophesymbol");
		            	Util.writeFile("@attribute 'disassemblyUnigrams "+i+"=["+disassemblyUnigrams[i]+"]' numeric"+"\n", output_filename, true);}
			   
		   	
		    	//get the bigrams in the disassembly and write the bigram features
		    	String[] disassemblyBigrams =FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionBigrams(test_dir);
		     	for (int i=0; i<disassemblyBigrams.length; i++)	   	
			       {  	disassemblyBigrams[i] = disassemblyBigrams[i].replace("'", "apostrophesymbol");
			            	Util.writeFile("@attribute 'disassemblyBigrams "+i+"=["+disassemblyBigrams[i]+"]' numeric"+"\n", output_filename, true);}

		     	
		   	//get the Unigrams in the CFG and write the unigram features
		       String[] cfgUnigrams =getCFGUnigrams(test_dir);
		    	for (int i=0; i<cfgUnigrams.length; i++)	   	
		       {  	//cfgUnigrams[i] = cfgUnigrams[i].replace("'", "apostrophesymbol");
		            	Util.writeFile("@attribute 'CFGUnigrams "+i+"=["+cfgUnigrams[i]+"]' numeric"+"\n", output_filename, true);}
			   
		    	
		    	  String[] cfgNodeLastLine =getCFGNodeLine(test_dir);
			    	for (int i=0; i<cfgNodeLastLine.length; i++)	   	
			       {  	//cfgUnigrams[i] = cfgUnigrams[i].replace("'", "apostrophesymbol");
			            	Util.writeFile("@attribute 'cfgNodeLastLine "+i+"=["+cfgNodeLastLine[i]+"]' numeric"+"\n", output_filename, true);}
			
			    	
			    	//the slowest feature
/*			   	// write the unigram tfidf features	   	
			    	for (int i=0; i<cfgUnigrams.length; i++)	   	
			       {  	//cfgUnigrams[i] = cfgUnigrams[i].replace("'", "apostrophesymbol");
			            	Util.writeFile("@attribute 'CFGUnigramsTFIDF "+i+"=["+cfgUnigrams[i]+"]' numeric"+"\n", output_filename, true);}
				   */
			    	
		    	//get the bigrams in the CFG and write the bigram features
		    	String[] cfgBigrams =getCFGBigrams(test_dir);
		     	for (int i=0; i<cfgBigrams.length; i++)	   	
			       {  //	cfgBigrams[i] = cfgBigrams[i].replace("'", "apostrophesymbol");
		     				String temp= cfgBigrams[i];
			            	Util.writeFile("@attribute 'CFGBigrams "+i+"=["+temp.replace("\n", " ")+"]' numeric"+"\n", output_filename, true);}

		    	//get the bigrams in the CFG and write the bigram features
		    	String[] cfgLineBigrams =getCFGNodeLineBigram(test_dir);
		     	for (int i=0; i<cfgLineBigrams.length; i++)	   	
			       {  //	cfgBigrams[i] = cfgBigrams[i].replace("'", "apostrophesymbol");
		     				String temp= cfgLineBigrams[i];
			            	Util.writeFile("@attribute 'cfgLineBigrams "+i+"=["+temp.replace("\n", " ")+"]' numeric"+"\n", output_filename, true);}



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
				String disText = Util.readFile(test_dot_paths.get(i).toString().substring(0,testIDlength-22)+".dis");
				System.out.println(test_dot_paths.get(i));
				System.out.println(authorName);
				File fileCPPID = new File(test_dot_paths.get(i).toString());
				String fileNameID = fileCPPID.getName().replace(".dot", "");
				Util.writeFile(fileNameID+",", output_filename, true);

				
		   
				 //get count of each wordUnigram in disassembly 
			    float[] wordUniCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionUnigramsTF(disText, disassemblyUnigrams);
			    for (int j=0; j<wordUniCount.length; j++)
				{Util.writeFile(wordUniCount[j] +",", output_filename, true);}	
			    
			    //get count of each bigram in in disassembly	 
			    float[] wordBigramCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionBigramsTF(disText, disassemblyBigrams);
			    for (int j=0; j<wordBigramCount.length; j++)
				{Util.writeFile(wordBigramCount[j] +",", output_filename, true);}    
				
				
			    //get count of each wordUnigram in cfg 
				String [] cfgUnigramsTFIDF= cfgUnigrams;
			    float[] wordUniCount1 = getCFGUnigramTF(featureText, cfgUnigrams);
			    for (int j=0; j<wordUniCount1.length; j++)
				{Util.writeFile(wordUniCount1[j] +",", output_filename, true);}	
			    
			    
			    float[] cfgNodeLastLineCount = getCFGNodeLineTF(featureText, cfgNodeLastLine);
			    for (int j=0; j<cfgNodeLastLineCount.length; j++)
				{Util.writeFile(cfgNodeLastLineCount[j] +",", output_filename, true);}	
			    
			    

			    
			    
			    //tfidf is the slowest feature so far
/*			    float[] uniTFIDF = getCFGUnigramsTFIDF(featureText, test_dir, cfgUnigrams);
			    for (int j=0; j<uniTFIDF.length; j++)
				{Util.writeFile(uniTFIDF[j] +",", output_filename, true);}	*/
			    
			    //get count of each bigram in in disassembly	 
			    float[] wordBigramCount1 = getCFGBigramsTF(featureText, cfgBigrams);
			    for (int j=0; j<wordBigramCount1.length; j++)
				{Util.writeFile(wordBigramCount1[j] +",", output_filename, true);}
			    
			    //get count of each bigram in in disassembly	 
			    float[] lineBigramCount = getCFGNodeLineBigramTF(featureText, cfgLineBigrams);
			    for (int j=0; j<lineBigramCount.length; j++)
				{Util.writeFile(lineBigramCount[j] +",", output_filename, true);}
			   	
			   	
		    	
				Util.writeFile(authorName+"\n", output_filename, true);

		   	
		   	}}
		       	
		   	
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String [] getCFGUnigrams(String dirPath) throws IOException{
		
	
		List  test_file_paths = Util.listDotFiles(dirPath);
		String[] words = null;
		Set<String> uniGrams = new LinkedHashSet<String>();


		String filePath="";

 	    for(int i=0; i< test_file_paths.size(); i++){
 	    	
 	    	filePath = test_file_paths.get(i).toString();  
		//	System.out.println(filePath);						   

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
				//		System.out.println(line);
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
		
    	String str;
    float symbolCount = wordUnigrams.length;
    float [] counter = new float[(int) symbolCount];
    for (int i =0; i<symbolCount; i++){
 	  str = wordUnigrams[i].toString();

 	 counter[i] = StringUtils.countMatches(line, str); 
 	 

    }
    return counter;
    }
    
    
    public static float getCFGUnigramIDF (String datasetDir, String wordUnigram  ) throws IOException

	 {    
			
		 float counter = 0;
		 float IDFcounter = 0;

		 File file = new File(datasetDir);
	     String[] directories = file.list(new FilenameFilter() {
	    	 @Override
	     public boolean accept(File current, String name) 
	    	 {
	    		 return new File(current, name).isDirectory();
			 }
				   });
	     float dirLen = directories.length;
	     String line="";
		 for(int j=0; j< dirLen; j++)
			{
			String authorName = directories[j];
			List test_file_paths = Util.listDotFiles(datasetDir+authorName+ File.separator);
	 		for(int i=0; i< test_file_paths.size(); i++)
	 		{
	 			line = Util.readFile(test_file_paths.get(i).toString());	 			
				line=	line.replaceAll("[0-9]+/*\\.*[0-9]*", "0");
				line=	line.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
				line=	line.replaceAll("\"", " ");
				line=	line.replaceAll("\\];", "");
				line=	line.replaceAll("\\[shape=box,label=", " ");
				line=	line.replaceAll("\\\\n", " nodeNewline ");
	 		  	 int termFrequencyAuthor = StringUtils.countMatches(line, wordUnigram); 
/*	 		  	if(termFrequencyAuthor>0)
	 		  	 System.out.println("term freq:"+termFrequencyAuthor);
*/
	 		  	 if (termFrequencyAuthor>0)
	 		  		 {counter++;}
/*	 		  	 if(counter>0){
	 		  	 System.out.println(counter);}
*/
	 		} 
	 		if(counter>0)
	 			IDFcounter++;
	 		
	 }
		 if (IDFcounter==0)
		 {return 0;}
		return (float) ((Math.log(dirLen/IDFcounter))/ (Math.log(2)));
	
	 }
    
    
	public static float [] getCFGUnigramsTFIDF (String featureText, String datasetDir, String[] cfgUnigrams ) throws IOException
	   {    
	   float symbolCount = cfgUnigrams.length;
	   float idf = 0;
	   float[] tf = getCFGUnigramTF(featureText, cfgUnigrams);
	   float [] counter = new float[(int) symbolCount];
	//   tf = StringUtils.countMatches(featureText, str);  	

	   for (int i =0; i<symbolCount; i++){	   
		   if ((tf[i] != 0) ){
		 idf = getCFGUnigramIDF(datasetDir, cfgUnigrams[i].toString());}
		 else {
			 idf =0;
		 }
		 if ((tf[i] != 0) && (idf != 0))
		 counter[i] = tf[i] * idf;
		 else
			 counter[i]=0;
	   }
	   return counter;
	   }
    
    
    public static String [] getCFGBigrams(String dirPath) throws IOException{


			
    	
		List  test_file_paths = Util.listDotFiles(dirPath);
		String[] words = null;
		Set<String> uniGrams = new LinkedHashSet<String>();


		String filePath="";
		String temp = "";
 	    for(int i=0; i< test_file_paths.size(); i++){
 	    	filePath = test_file_paths.get(i).toString();  
		//	System.out.println(filePath);						   

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
						uniGrams.add(temp + "\n"+ line);
			//			System.out.println("BIGRAM IS: " +temp + "\n"+  line);
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
	//	System.out.println(line);
		
    	String str;
    float symbolCount = DisBigrams.length;
    float [] counter = new float[(int) symbolCount];
    for (int i =0; i<symbolCount; i++){
 	  str = DisBigrams[i].toString();
 //	  if(i==3){System.out.println("line: "+line);System.out.println("str: "+str);}
 	 counter[i] = StringUtils.countMatches(line, str); 

    }
    return counter;

}

    
    
	public static String [] getCFGNodeLine(String dirPath) throws IOException{
		
		
		List  test_file_paths = Util.listDotFiles(dirPath);
		String[] words = null;
		Set<String> uniGrams = new LinkedHashSet<String>();


		String filePath="";

 	    for(int i=0; i< test_file_paths.size(); i++){
 	    	
 	    	filePath = test_file_paths.get(i).toString();  
		//	System.out.println(filePath);						   

				BufferedReader br = new BufferedReader(new FileReader(filePath));
				String line;
				String textInBetween="";
				while ((line = br.readLine()) != null)
				{						
						line=	line.replaceAll("[0-9]+/*\\.*[0-9]*", "0");
						line=	line.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
						line=	line.replaceAll("\"", " ");
						line=	line.replaceAll("\\];", "");
						line=	line.replaceAll("\\[shape=box,label=", " ");
						line=	line.replaceAll("\\\\n", " nodeNewline ");
				//		System.out.println(line);
						Pattern pattern = Pattern.compile("(?s)(?<=nodeNewline ).+?(?= nodeNewline)");
						// text contains the full text that you want to extract data
						Matcher matcher = pattern.matcher(line);
						while (matcher.find()) {
						   textInBetween = matcher.group(0); // Since (.*?) is capturing group 1
						  // System.out.println("textInBetween:"+textInBetween);
							uniGrams.add(textInBetween.toString());
						}
						

					}
 	    }	 	       	      
 	    		words =   uniGrams.toArray(new String[uniGrams.size()]);
			    return words;
 
		
	}
	

 
 //not normalized by the number of ASTTypes in the source code in the source code
    public static float [] getCFGNodeLineTF (String featureText, String[] wordUnigrams  )
    {    
    	String line = featureText;
		line=	line.replaceAll("[0-9]+/*\\.*[0-9]*", "0");
		line=	line.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
		line=	line.replaceAll("\"", " ");
		line=	line.replaceAll("\\];", "");
		line=	line.replaceAll("\\[shape=box,label=", " ");
		line=	line.replaceAll("\\\\n", " nodeNewline ");
		
    	String str;
    float symbolCount = wordUnigrams.length;
    float [] counter = new float[(int) symbolCount];
    for (int i =0; i<symbolCount; i++){
 	  str = wordUnigrams[i].toString();

 	 counter[i] = StringUtils.countMatches(line, str); 
 	 

    }
    return counter;
    }
    
	public static String [] getCFGNodeLineBigram(String dirPath) throws IOException{
		
		
		List  test_file_paths = Util.listDotFiles(dirPath);
		String[] words = null;
		Set<String> uniGrams = new LinkedHashSet<String>();


		String filePath="";
		String temp="";
 	    for(int i=0; i< test_file_paths.size(); i++){
 	    	
 	    	filePath = test_file_paths.get(i).toString();  
		//	System.out.println(filePath);						   

				BufferedReader br = new BufferedReader(new FileReader(filePath));
				String line;
				String textInBetween="";
				while ((line = br.readLine()) != null)
				{						
						line=	line.replaceAll("[0-9]+/*\\.*[0-9]*", "0");
						line=	line.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
						line=	line.replaceAll("\"", " ");
						line=	line.replaceAll("\\];", "");
						line=	line.replaceAll("\\[shape=box,label=", " ");
						line=	line.replaceAll("\\\\n", " nodeNewline ");
						line=	line.replaceAll("  ", " ");
						line=	line.replaceAll("  ", " ");
				//		System.out.println(line);
						Pattern pattern = Pattern.compile("(?s)(?<=nodeNewline ).+?(?= nodeNewline)");
						// text contains the full text that you want to extract data
						Matcher matcher = pattern.matcher(line);
						while (matcher.find()) {
						   textInBetween = matcher.group(0); // Since (.*?) is capturing group 1
						 //  System.out.println("bigram:"+ temp + " "+textInBetween.toString());
							uniGrams.add(temp.trim() + " "+textInBetween.toString().trim());
							temp=textInBetween;
							
						}
						

					}
 	    }	 	       	      
 	    		words =   uniGrams.toArray(new String[uniGrams.size()]);
			    return words;
 
		
	}

    public static float [] getCFGNodeLineBigramTF (String featureText, String[] DisBigrams ) throws IOException
    {    
    	
    	String line = featureText;
		line=	line.replaceAll("[0-9]+/*\\.*[0-9]*", "0");
		line=	line.replaceAll("0[xX][0-9a-fA-F]+", "hexadecimal");
		line=	line.replaceAll("\"", " ");
		line=	line.replaceAll("\\];", "");
		line=	line.replaceAll("\\[shape=box,label=", " ");
		line=	line.replaceAll("\\\\n", " nodeNewline ");
		line=	line.replaceAll("nodeNewline", "");
		line=	line.replaceAll("  ", " ");
		line=	line.replaceAll("  ", " ");

    	String str;
    float symbolCount = DisBigrams.length;
    float [] counter = new float[(int) symbolCount];
    for (int i =0; i<symbolCount; i++){
 	  str = DisBigrams[i].toString();
 //	  if(i==3){System.out.println("line: "+line);System.out.println("str: "+str);}
 	 counter[i] = StringUtils.countMatches(line, str); 
 	 

    }
    return counter;

}
    
    
    
    
}
