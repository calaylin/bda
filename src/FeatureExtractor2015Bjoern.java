import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
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
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;


public class FeatureExtractor2015Bjoern {

	public static void main(String[] args) throws IOException{
		
	
    				String test_dir ="/mnt/data_bsd/allOptimizations/L0_150authors/";
		       		
		        	String output_filename = "/mnt/data_bsd/allOptimizations/L0_150authors_bjoernlinebigrams2.arff" ;

		        	
		        	

		           	List test_binary_paths = Util.listBinaryFiles(test_dir);
		           	List test_dis_paths = listBjoernNodeFiles(test_dir);
			
		 
		        		

		    	String text = "";
		      	//Writing the test arff
		    	Util.writeFile("@relation "+"100authors_noOptimization_bjoern_snowmanCFG"+"\n"+"\n",
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
		       String[] disassemblyLineBigrams =getBjoernLineBigrams(test_dir);
		    	for (int i=0; i<disassemblyLineBigrams.length; i++)	   	
		       {  	disassemblyLineBigrams[i] = disassemblyLineBigrams[i].replace("\n", " ");
		            //	Util.writeFile("@attribute 'disassemblyUnigrams "+i+"=["+disassemblyLineBigrams[i]+"]' numeric"+"\n", output_filename, true);}
            	Util.writeFile("@attribute 'disassemblyLineBigrams "+i+"' numeric"+"\n", output_filename, true);}

/*		   	
		    	//get the bigrams in the disassembly and write the bigram features
		    	String[] disassemblyBigrams =getBjoernBigrams(test_dir);
		     	for (int i=0; i<disassemblyBigrams.length; i++)	   	
			       {  	disassemblyBigrams[i] = disassemblyBigrams[i].replace("'", "apostrophesymbol");
			            	Util.writeFile("@attribute 'disassemblyBigrams "+i+"=["+disassemblyBigrams[i]+"]' numeric"+"\n", output_filename, true);}


		     	//CFG Features from snowman CFGs
			   	//get the Unigrams in the CFG and write the unigram features
			       String[] cfgUnigrams =FeatureExtractorCFGDisassembly.getCFGUnigrams(test_dir);
			    	for (int i=0; i<cfgUnigrams.length; i++)	   	
			       {  	//cfgUnigrams[i] = cfgUnigrams[i].replace("'", "apostrophesymbol");
			            	Util.writeFile("@attribute 'CFGUnigrams "+i+"=["+cfgUnigrams[i]+"]' numeric"+"\n", output_filename, true);}
				   
			    	
			    	  String[] cfgNodeLastLine =FeatureExtractorCFGDisassembly.getCFGNodeLine(test_dir);
				    	for (int i=0; i<cfgNodeLastLine.length; i++)	   	
				       {  	//cfgUnigrams[i] = cfgUnigrams[i].replace("'", "apostrophesymbol");
				            	Util.writeFile("@attribute 'cfgNodeLastLine "+i+"=["+cfgNodeLastLine[i]+"]' numeric"+"\n", output_filename, true);}
				
				    	
				    	//the slowest feature
				   	// write the unigram tfidf features	   	
				    	for (int i=0; i<cfgUnigrams.length; i++)	   	
				       {  	//cfgUnigrams[i] = cfgUnigrams[i].replace("'", "apostrophesymbol");
				            	Util.writeFile("@attribute 'CFGUnigramsTFIDF "+i+"=["+cfgUnigrams[i]+"]' numeric"+"\n", output_filename, true);}
					   
				    	
			    	//get the bigrams in the CFG and write the bigram features
			    	String[] cfgBigrams =FeatureExtractorCFGDisassembly.getCFGBigrams(test_dir);
			     	for (int i=0; i<cfgBigrams.length; i++)	   	
				       {  //	cfgBigrams[i] = cfgBigrams[i].replace("'", "apostrophesymbol");
			     				String temp= cfgBigrams[i];
				            	Util.writeFile("@attribute 'CFGBigrams "+i+"=["+temp.replace("\n", " ")+"]' numeric"+"\n", output_filename, true);}

			    	//get the bigrams in the CFG and write the bigram features
			    	String[] cfgLineBigrams =FeatureExtractorCFGDisassembly.getCFGNodeLineBigram(test_dir);
			     	for (int i=0; i<cfgLineBigrams.length; i++)	   	
				       {  //	cfgBigrams[i] = cfgBigrams[i].replace("'", "apostrophesymbol");
			     				String temp= cfgLineBigrams[i];
				            	Util.writeFile("@attribute 'cfgLineBigrams "+i+"=["+temp.replace("\n", " ")+"]' numeric"+"\n", output_filename, true);}


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
				String featureText = Util.readFile(test_binary_paths.get(i).toString()+"_SnowmanDecompiled.dot");
				int testIDlength = test_binary_paths.get(i).toString().length(); 
				authorFileName= new File(test_binary_paths.get(i).toString());
				String authorName= authorFileName.getParentFile().getName();

				System.out.println(test_binary_paths.get(i));
				System.out.println(authorName);
				File fileCPPID = new File(test_binary_paths.get(i).toString());
				String fileNameID = fileCPPID.getName();
				Util.writeFile(fileNameID+",", output_filename, true);
				String disText = Util.readFile(authorFileName.getParentFile()
						+ File.separator + "output_"+fileCPPID.getName()+
						File.separator + "nodes.csv");

				
		   
				    
			    //get count of each wordUnigram in disassembly 
			    float[] wordUniCount = getBjoernLineBigramTF(disText, disassemblyLineBigrams);
			    for (int j=0; j<wordUniCount.length; j++)
				{Util.writeFile(wordUniCount[j] +",", output_filename, true);}	
			    
			    /*//get count of each bigram in in disassembly	 
			    float[] wordBigramCount = getBjoernBigramsTF(disText, disassemblyBigrams);
			    for (int j=0; j<wordBigramCount.length; j++)
				{Util.writeFile(wordBigramCount[j] +",", output_filename, true);}
			   	
			    
			    
				
			    //get count of each wordUnigram in cfg 
				String [] cfgUnigramsTFIDF= cfgUnigrams;
			    float[] wordUniCount1 = FeatureExtractorCFGDisassembly.getCFGUnigramTF(featureText, cfgUnigrams);
			    for (int j=0; j<wordUniCount1.length; j++)
				{Util.writeFile(wordUniCount1[j] +",", output_filename, true);}	
			    
			    
			    float[] cfgNodeLastLineCount = FeatureExtractorCFGDisassembly.getCFGNodeLineTF(featureText, cfgNodeLastLine);
			    for (int j=0; j<cfgNodeLastLineCount.length; j++)
				{Util.writeFile(cfgNodeLastLineCount[j] +",", output_filename, true);}	
			    
			    

			    
			    
			    //tfidf is the slowest feature so far
			    float[] uniTFIDF = getCFGUnigramsTFIDF(featureText, test_dir, cfgUnigrams);
			    for (int j=0; j<uniTFIDF.length; j++)
				{Util.writeFile(uniTFIDF[j] +",", output_filename, true);}	
			    
			    //get count of each bigram in in disassembly	 
			    float[] wordBigramCount1 = FeatureExtractorCFGDisassembly.getCFGBigramsTF(featureText, cfgBigrams);
			    for (int j=0; j<wordBigramCount1.length; j++)
				{Util.writeFile(wordBigramCount1[j] +",", output_filename, true);}
			    
			    //get count of each bigram in in disassembly	 
			    float[] lineBigramCount = FeatureExtractorCFGDisassembly.getCFGNodeLineBigramTF(featureText, cfgLineBigrams);
			    for (int j=0; j<lineBigramCount.length; j++)
				{Util.writeFile(lineBigramCount[j] +",", output_filename, true);}
			    
			 */   
			    
		    	
				Util.writeFile(authorName+"\n", output_filename, true);

		   	
		   	}}
		       	
		   	
		
		
		
		
		
	
	
	
	
	
	public static String [] getBjoernLineBigrams(String dirPath) throws IOException{
		
	
		List  test_file_paths = listBjoernNodeFiles(dirPath);
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
					uniGrams.add(tmp.trim() + " "+ line.trim());
				//	System.out.println(tmp.trim() + " "+ line.trim());

				tmp = line;		
					
 	    }	 }	         
       
 	    		words =   uniGrams.toArray(new String[uniGrams.size()]);
			    return words;
 
		
	}	
	
    public static float [] getBjoernLineBigramTF (String featureText, String[] lineBigrams  )
    {    
    	
    	
    	
    	String str;
    float symbolCount = lineBigrams.length;
    float [] counter = new float[(int) symbolCount];
  
 	
 		featureText=	featureText.replaceAll("\\\"", " ");	
 		featureText=	featureText.replaceAll("^[A-Fa-f0-9]+$", "hexadecimal");
 		featureText=	featureText.replaceAll("\\d+", "number");
 		featureText=	featureText.replaceAll("\\n", " ");	
 		featureText=	featureText.replaceAll("\\s+", " ");
 		  for (int i =0; i<symbolCount; i++){
 		 	  str = lineBigrams[i].toString();
	
 	 counter[i] = StringUtils.countMatches(featureText, str.trim()); 
 	 }

    
    return counter;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	public static String [] getBjoernUnigrams(String dirPath) throws IOException{
		
	
		List  test_file_paths = listBjoernNodeFiles(dirPath);
		String[] words = null;
		Set<String> uniGrams = new LinkedHashSet<String>();

		ArrayList<String> ar = new ArrayList<String>();

		String filePath="";
		HashSet<String> uniqueWords = new HashSet<String>();

 	    for(int i=0; i< test_file_paths.size(); i++){
 	    	
 	    	filePath = test_file_paths.get(i).toString();  
		//	System.out.println(filePath);						   
			   String[] arr;
			   String[] toAdd;

				BufferedReader br = new BufferedReader(new FileReader(filePath));
				String line;
				
				
				
				
				
				while ((line = br.readLine()) != null)
				{
					arr = line.split("\\s+",2);
					if (arr.length > 1){
/*						System.out.println("Redundant " + arr[0] 
		                                 + " , needed " + arr[1] 
		                            );*/

						arr[1]=	arr[1].replaceAll("\\\"", " ");	
						arr[1]=	arr[1].replaceAll("^[A-Fa-f0-9]+$", "hexadecimal");
						arr[1]=	arr[1].replaceAll("\\d+", "number");
					
						
						toAdd = arr[1].trim().split("\\s+");
						for(int i11 =0; i11< toAdd.length; i11++)
						{
						if(toAdd[i11].contains("0x")){
							toAdd[i11]="hexadecimal";
						}
						uniGrams.add(toAdd[i11].trim());
				//				System.out.println(toAdd[i11]);
		            	}		
					}	
				
		    }
				
				
				
				
				
				
				
				while ((line = br.readLine()) != null)
				{
					arr = line.split("\\\t");
					if (arr.length > 1){
	/*				System.out.println("Redundant " + arr[0] 
		                                 + " , needed1 " +arr[1]  
		                            );*/
						for(int i1=1; i1< arr.length; i1++){

						arr[i1]=	arr[i1].replaceAll("\\\"", " ");	
						arr[i1]=	arr[i1].replaceAll("^[A-Fa-f0-9]+$", "hexadecimal");
						arr[i1]=	arr[i1].replaceAll("\\d+", "number");
					
						toAdd = arr[i1].split("\\s+");
					
					for(int i11 =0; i11< toAdd.length; i11++)
						{
						if(toAdd[i11].contains("0x")){
							toAdd[i11]="hexadecimal";
						}
						uniGrams.add(toAdd[i11].trim());
						//		System.out.println(toAdd[i11]);
		            	}	
					}}
				}
				br.close();
				
				
 	    }	 	      
 	      
       
 	    		words =   uniGrams.toArray(new String[uniGrams.size()]);
			    return words;
 
		
	}
	

 
 //not normalized by the number of ASTTypes in the source code in the source code
    public static float [] getBjoernUnigramTF (String featureText, String[] wordUnigrams  )
    {    
    	
    	
    	
    	String str;
    float symbolCount = wordUnigrams.length;
    float [] counter = new float[(int) symbolCount];
    for (int i =0; i<symbolCount; i++){
 	  str = wordUnigrams[i].toString();
 	
 		featureText=	featureText.replaceAll("\\\"", " ");	
 		featureText=	featureText.replaceAll("^[A-Fa-f0-9]+$", "hexadecimal");
 		featureText=	featureText.replaceAll("\\d+", "number");
 		featureText=	featureText.replaceAll("\\s+", " ");	
	
 	 counter[i] = StringUtils.countMatches(featureText, str.trim()); 
 	 }

    
    return counter;
    }
    
    
    
    
    
    
    public static String [] getBjoernBigrams(String dirPath) throws IOException{

    	
    

    List test_file_paths = listBjoernNodeFiles(dirPath);
	Set<String> bigrams = new LinkedHashSet<String>();
	String[] uniquebigrams = null;
	String filePath="";

	    for(int i=0; i< test_file_paths.size(); i++){
	    	
	    	filePath = test_file_paths.get(i).toString();  
//	    	System.out.println(filePath);						   
		   String[] arr;
		   String[] toAdd;

			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			
			while ((line = br.readLine()) != null)
			{
				arr = line.split("\\s+",2);
				if (arr.length > 1){
/*					System.out.println("Redundant " + arr[0] 
	                                 + " , needed " + arr[1] 
	                            );*/

					arr[1]=	arr[1].replaceAll("\\\"", " ");	
					arr[1]=	arr[1].replaceAll("^[A-Fa-f0-9]+$", "hexadecimal");
					arr[1]=	arr[1].replaceAll("\\d+", "number");
				
					
					toAdd = arr[1].trim().split("\\s+");
					if(toAdd.length > 1){
				for(int i11 =1; i11< toAdd.length; i11++)
					{
					if(toAdd[i11].contains("0x")){
						toAdd[i11]="hexadecimal";}
					bigrams.add(toAdd[i11-1].trim() + " " +toAdd[i11].trim());
				//			System.out.println("1stgram "+toAdd[i11-1]+ " " +"2ndgram "+toAdd[i11]);
	            	}	}
					
				
			}
			
			
	    }
			br.close();
		       
	    }
	    uniquebigrams = bigrams.toArray(new String[bigrams.size()]);
		

	    return uniquebigrams;
	    
    }
    
    
    public static float [] getBjoernBigramsTF (String featureText, String[] DisBigrams ) throws IOException
    {    
        float symbolCount = DisBigrams.length;
        float [] counter = new float[(int) symbolCount];
        String str;
        for (int i =0; i<symbolCount; i++){

     	  str = DisBigrams[i].toString();

   		featureText=	featureText.replaceAll("\\\"", " ");	
   		featureText=	featureText.replaceAll("^[A-Fa-f0-9]+$", "hexadecimal");
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
    
}
