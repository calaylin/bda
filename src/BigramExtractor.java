import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;


public class BigramExtractor {
	  

    public static void main(String[] args) throws IOException
	{   	
      	
    	String dirPath = "/mnt/data_bsd/100NoOptimization/100NoOptimization/" ;
	
    	String output_filename="/mnt/data_bsd/100NoOptimization/100author_bigrams_test.arff";      
    	List test_file_paths = Util.listTextFiles(dirPath);
      	

	String text = "";
  	//Writing the test arff
  	//first specify relation
	Util.writeFile("@relation 100author_bigrams_test"+"\n"+"\n", output_filename, true);
	Util.writeFile("@attribute instanceID {", output_filename, true);
   	List test_cpp_paths = Util.listCPPFiles(dirPath);
   	for(int j=0; j < test_cpp_paths.size();j++ )
	{
		File fileCPP = new File(test_cpp_paths.get(j).toString());
		String fileName = fileCPP.getName();
		Util.writeFile(fileName+",", output_filename, true);
		if ((j+1)==test_cpp_paths.size())
			Util.writeFile("}"+"\n", output_filename, true);
	}
   	String[] ASTNodeBigrams = null;
	ASTNodeBigrams= getASTNodeBigrams(dirPath);
	
	for (int i=0; i<ASTNodeBigrams.length; i++)	
    	
	  {  	
	    	Util.writeFile("@attribute 'ASTNodeBigramsTF "+i+"=["+ASTNodeBigrams[i]+"]' numeric"+"\n", output_filename, true);}
	Util.writeFile("@attribute 'authorName' {",output_filename, true);
	for(int i=0; i< test_file_paths.size(); i++){
		int testIDlength = test_file_paths.get(i).toString().length();   
		File authorFileName= new File(test_file_paths.get(i).toString());
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
		int testIDlength = test_file_paths.get(i).toString().length(); 
		File authorFileName= new File(test_file_paths.get(i).toString());
		String authorName= authorFileName.getParentFile().getName();

		System.out.println(test_file_paths.get(i));
		System.out.println(authorName);
		
		File fileCPPID = new File(test_cpp_paths.get(i).toString());
		String fileNameID = fileCPPID.getName();
		Util.writeFile(fileNameID+",", output_filename, true);

		String DepASTText = Util.readFile((test_file_paths.get(i).toString().substring(0,test_file_paths.get(i).toString().length()-3))+"dep");
		  float[] typeCount = getASTNodeBigramsTF(DepASTText, ASTNodeBigrams );
		    for (int j=0; j<ASTNodeBigrams.length; j++)
			{Util.writeFile(typeCount[j] +",", output_filename, true);}	
		  
		
	  
		Util.writeFile(authorName+"\n", output_filename, true);

		
		
		
   	}
    	
}
    
    
    public static String [] getASTNodeBigrams(String dirPath) throws IOException{


    List test_file_paths = Util.listDepFiles(dirPath);
	Set<String> bigrams = new LinkedHashSet<String>();
	String[] uniquebigrams = null;
	
    for(int i=0; i< test_file_paths.size(); i++){
		String filePath = test_file_paths.get(i).toString();  
	//	System.out.println(filePath);

   String inputText =Util.readFile(filePath);
	int [] lines = DepthASTNode.getASTDepLines(inputText);
	String textAST=null;
	String inputTextParanthesisRemoved="";
	String [] arr;
	for (int j=0; j<lines.length; j++)
	{
		//System.out.println(lines[j]);

		textAST = DepthASTNode.readLineNumber(inputText, lines[j]);
/*		String inputTextParanthesisRemoved = textAST.replaceAll("[()]"," ");
		 inputTextParanthesisRemoved = inputTextParanthesisRemoved.replaceAll("\\d+\\t"," ");
		 inputTextParanthesisRemoved = inputTextParanthesisRemoved.replaceAll("( )+"," ");*/
			 inputTextParanthesisRemoved = textAST.replaceAll("\\("," ");
			 inputTextParanthesisRemoved = inputTextParanthesisRemoved.replaceAll("\\)"," ");
			 inputTextParanthesisRemoved = inputTextParanthesisRemoved.replaceAll("\\d+\\t"," ");
			 inputTextParanthesisRemoved = inputTextParanthesisRemoved.replaceAll("\\s+"," ");	
			arr = inputTextParanthesisRemoved.split("\\s+");
			if (arr.length>1){
			for(int i1=1;i1< arr.length; i1++){
				bigrams.add(arr[i1-1].trim()+" "+arr[i1].trim()); 
				System.out.println("bigram: "+arr[i1-1].trim()+" "+arr[i1].trim()); 
				}
			} 
		}
  }
	uniquebigrams = bigrams.toArray(new String[bigrams.size()]);	
    return uniquebigrams;
    
    }
    
    
    public static float [] getASTNodeBigramsTF (String featureText, String[] ASTNodeBigrams ) throws IOException
    {    
    	float symbolCount = ASTNodeBigrams.length;
        float [] counter = new float[(int) symbolCount];
    	int [] lines = DepthASTNode.getASTDepLines(featureText);
		String textAST=null;

		for (int j=0; j<lines.length; j++){
		
			textAST = DepthASTNode.readLineNumber(featureText, lines[j]);
		//System.out.println("line: "+ lines[j]);
/*			String inputTextParanthesisRemoved = textAST.replaceAll("[()]"," ");
		    inputTextParanthesisRemoved = inputTextParanthesisRemoved.replaceAll("\\d+\\t"," ");
			 inputTextParanthesisRemoved = inputTextParanthesisRemoved.replaceAll("( )+"," ");
		*/
			//			System.out.println("inputText "+inputTextParanthesisRemoved);
				String inputTextParanthesisRemoved = textAST.replaceAll("\\("," ");
				 inputTextParanthesisRemoved = inputTextParanthesisRemoved.replaceAll("\\)"," ");
				 inputTextParanthesisRemoved = inputTextParanthesisRemoved.replaceAll("\\d+\\t"," ");
				 inputTextParanthesisRemoved = inputTextParanthesisRemoved.replaceAll("\\s+"," ");

		for (int i=0; i<symbolCount; i++){
			//    	featureText remove paranthesis and replace with one space for feature text
			String str = ASTNodeBigrams[i].toString();
		//	System.out.println(str);
				counter[i] = counter[i] + StringUtils.countMatches(inputTextParanthesisRemoved, str.trim());
			//	System.out.println("counter: "+ counter[i]);
		}
		}
	    return counter;

}}
    
