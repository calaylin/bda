import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

import javax.script.ScriptException;

/**
 * FeatureExtractor writes extracted features to arff file to be used with WEKA
 * @author Aylin Caliskan-Islam (ac993@drexel.edu)
 */

public class BinaryDisassembleAndExtractFeatures {
	

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InterruptedException, ScriptException {
		
		  
		//Specifying the test arff filename
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
       	int month = cal.get(Calendar.MONTH);
       	int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
       	String time = sdf.format(cal.getTime());
    	//TODO when time changes, output_filename changes every time which needs to be corrected
//       	String output_filename = "/Users/Aylin/Desktop/Drexel/2014/ARLInternship/SCAAarffs/incremental/" +"CodeJam_14FilesPerAuthor_2014_"+ (month+1) + "." + 
//    	dayOfMonth + "_"+ time +".arff" ;
       	for(int numberFiles=55; numberFiles<56; numberFiles++){
       		
       		
        	String output_filename = "/Users/Aylin/Desktop/Princeton/"
        			+ "BAA/arffs/100authors_hexraysDecompiled_noOptimizationUnigrams.arff" ;
        	String test_dir ="/Users/Aylin/Desktop/Princeton/BAA/datasets/"
        			+ "c++/"
        			+ "9Files_largescale_CPP_and_binary_NOToptimized/";
        	
        	

           	List test_file_paths = Util.listCFiles(test_dir);
           	List test_binary_paths = Util.listBinaryFiles(test_dir);
           	List test_dis_paths = Util.listDisFiles(test_dir);
	
           	
           	
        	//delete all disassembled files
           	for(int bin=0; bin< test_dis_paths.size(); bin++){
        		System.out.println(test_dis_paths.get(bin).toString());
        			File toDelete = new File(test_dis_paths.get(bin).toString());
        		//	toDelete.delete();
        			}
           	
           	
          	//disassemble the binaries from the test folder 
           	for(int bin=0; bin< test_binary_paths.size(); bin++){
        		System.out.println(test_binary_paths.get(bin).toString());
        		disassembleBinaries(test_binary_paths.get(bin).toString(), "32");
        			}
        		

    	String text = "";
      	//Writing the test arff
      	//first specify relation
    	Util.writeFile("@relation "+"testBinary"+"\n"+"\n", output_filename, true);
    	Util.writeFile("@attribute instanceID_original {", output_filename, true);
  
    	


   	List test_cpp_paths = Util.listCPPFiles(test_dir);
   	for(int j=0; j < test_cpp_paths.size();j++ )
	{
		File fileCPP = new File(test_cpp_paths.get(j).toString());
		String fileName = fileCPP.getName();
		Util.writeFile(fileName+",", output_filename, true);
		if ((j+1)==test_cpp_paths.size())
			Util.writeFile("}"+"\n", output_filename, true);
	}




       String[] wordUnigramsCPP =FeatureCalculators.wordUnigramsBytes(test_dir);
    	


    	for (int i=0; i<wordUnigramsCPP.length; i++)	   	
       {  	wordUnigramsCPP[i] = wordUnigramsCPP[i].replace("'", "apostrophesymbol");
            	Util.writeFile("@attribute 'wordUnigramsCPP_original "+i+"=["+wordUnigramsCPP[i]+"]' numeric"+"\n", output_filename, true);}


    File authorFileName = null;
	//Writing the classes (authorname)
	Util.writeFile("@attribute 'authorName_original' {",output_filename, true);
	for(int i=0; i< test_file_paths.size(); i++){
		int testIDlength = test_file_paths.get(i).toString().length();   
		authorFileName= new File(test_file_paths.get(i).toString());
		String authorName= authorFileName.getParentFile().getName();

		text = text.concat(authorName + ",");  
		String[] words = text.split( ",");
		  Set<String> uniqueWords = new HashSet<String>();

		   for (String word : words) {
		       uniqueWords.add(word);
		   }
		   words = uniqueWords.toArray(new String[0]);
		   int authorCount = words.length;
		   if (i+1==test_file_paths.size()){
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
   	for(int i=0; i< test_file_paths.size(); i++){
		String featureText = Util.readFile(test_file_paths.get(i).toString());
		int testIDlength = test_file_paths.get(i).toString().length(); 
		authorFileName= new File(test_file_paths.get(i).toString());
		String authorName= authorFileName.getParentFile().getName();

		System.out.println(test_file_paths.get(i));
		System.out.println(authorName);
		File fileCPPID = new File(test_cpp_paths.get(i).toString());
		String fileNameID = fileCPPID.getName();
		Util.writeFile(fileNameID+",", output_filename, true);
		String disText = Util.readFile(test_file_paths.get(i).toString().substring(0,testIDlength-3)+"dis");
		String sourceCode = Util.readFile(test_file_paths.get(i).toString().substring(0,testIDlength-3)+"cpp");

		
   
		    
	    //get count of each wordUnigram in CPP source file	 
	    float[] wordUniCount = FeatureCalculators.WordUnigramTF(disText, wordUnigramsCPP);
	    for (int j=0; j<wordUniCount.length; j++)
		{Util.writeFile(wordUniCount[j] +",", output_filename, true);}	
	   	
    	
		Util.writeFile(authorName+"\n", output_filename, true);

   	
   	}}
       	
   	}
   
	  
   	
	  public static String[]  uniqueDirectoryWords (String directoryFilePath){

		    String text = "FunctionName: operator"+ "";
		            
		            

		    Matcher m = Pattern.compile("(?m)^.*$").matcher(text);

		   
		    while (m.find()) {
		        System.out.println("line = " + m.group());
		        if(m.group().startsWith("Features (list):"));
		        
		    }
		  


	        while (m.find()) {
	            System.out.println("line = " + m.group());}
		  
		  String[] words = text.split( "\\s+");
		  Set<String> uniqueWords = new HashSet<String>();

		   for (String word : words) {
		       uniqueWords.add(word);
		   }
		   words = uniqueWords.toArray(new String[0]);
		   return words;
		 }
		   

	  
		public static void disassembleBinaries(String filePath, String bits) throws IOException, InterruptedException, ScriptException{
			//should take filename to test each time
			//just needs the name of the directory with the authors and their source files as an input
		
			 Runtime disTime = Runtime.getRuntime();
			 String output_filename = filePath.concat(".dis");
			 String cmd1 = "ndisasm -b " +bits +" " + filePath.toString() + " > " + output_filename;      
		     Process disassemble = disTime.exec((new String[]{"/bin/sh","-c", cmd1}));
		     disassemble.waitFor();
		}


				
	
}
	











