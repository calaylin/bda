import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;


public class BigramExtractorC {
	  

    public static void main(String[] args) throws IOException
	{   	
      	Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
       	int month = cal.get(Calendar.MONTH);
       	int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
       	String time = sdf.format(cal.getTime());
    	String output_filename = "/Users/Aylin/Desktop/Drexel/2014/ARLInternship/SCAAarffs/Carffs/"
    			+(month+1) + "." + dayOfMonth + "_" 
    			+ "C_20AuthorsMixed_bigrams.arff" ;
	
    	String dirPath ="/Users/Aylin/Desktop/Drexel/2014/ARLInternship/SCAA_Datasets/"
    			+ "obfuscated_C/mixed/";

    	List test_file_paths = Util.listTextFiles(dirPath);
      	

	String text = "";
  	//Writing the test arff
  	//first specify relation
	Util.writeFile("@relation C_20AuthorsMixed_bigrams"+"\n"+"\n", output_filename, true);
	Util.writeFile("@attribute instanceID {", output_filename, true);
   	List test_c_paths = Util.listCFiles(dirPath);
   	for(int j=0; j < test_c_paths.size();j++ )
	{
		File fileC = new File(test_c_paths.get(j).toString());
		String fileName = fileC.getName();
		Util.writeFile(fileName+",", output_filename, true);
		if ((j+1)==test_c_paths.size())
			Util.writeFile("}"+"\n", output_filename, true);
	}
   	String[] ASTNodeBigrams = null;
	ASTNodeBigrams= getASTNodeBigrams(dirPath);
	
	for (int i=0; i<ASTNodeBigrams.length; i++)	
    	
	  {  	ASTNodeBigrams[i] = ASTNodeBigrams[i].replace("'", "apostrophesymbol");
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
		
		File fileCPPID = new File(test_c_paths.get(i).toString());
		String fileNameID = fileCPPID.getName();
		Util.writeFile(fileNameID+",", output_filename, true);

		String DepASTText = Util.readFile(test_file_paths.get(i).toString().substring(0,testIDlength-3)+"dep");
		  float[] typeCount = getASTNodeBigramsTF(DepASTText, ASTNodeBigrams );
		    for (int j=0; j<ASTNodeBigrams.length; j++)
			{Util.writeFile(typeCount[j] +",", output_filename, true);}	
		  
		
	  
		Util.writeFile(authorName+"\n", output_filename, true);

		
		
		
   	}
    	
}
    
    
    public static String [] getASTNodeBigrams(String dirPath) throws IOException{


    List test_file_paths = Util.listDepFiles(dirPath);
	Set<String> uniqueWords = new LinkedHashSet<String>();
	List<String> unigrams = new ArrayList<String>();
	Set<String> bigrams = new LinkedHashSet<String>();
	String[] uniquebigrams = null;
	
    for(int i=0; i< test_file_paths.size(); i++){
		String filePath = test_file_paths.get(i).toString();  
		System.out.println(filePath);

   String inputText =Util.readFile(filePath);
	int [] lines = DepthASTNode.getASTDepLines(inputText);
	String textAST=null;
	for (int j=0; j<lines.length; j++)
	{
		//System.out.println(lines[j]);

		textAST = DepthASTNode.readLineNumber(inputText, lines[j]);
		String inputTextParanthesisRemoved = textAST.replaceAll("[()]"," ");
		 inputTextParanthesisRemoved = inputTextParanthesisRemoved.replaceAll("\\d+\\t"," ");
		 inputTextParanthesisRemoved = inputTextParanthesisRemoved.replaceAll("( )+"," ");

	//	System.out.println(inputTextParanthesisRemoved);

//   Pattern pattern = Pattern.compile("([\\w']+)");
		   Pattern pattern = Pattern.compile("(\\w+)\\s+");
		   Matcher matcher = pattern.matcher(inputTextParanthesisRemoved);
		   
		   
			while (matcher.find()) {
//				System.out.println("Found a " + matcher.group() + ".");
				unigrams.add(matcher.group());
			}
			
		   while (matcher.find()) {
		       uniqueWords.add(matcher.group(1));}
		   
		   }
		   }
	
		  
	

 //   String[] words = uniqueWords.toArray(new String[0]);
	for(int i=1; i<unigrams.size(); i++){
	   //   System.out.println( unigrams.get(i-1));
		   bigrams.add(unigrams.get(i-1).trim() + " "+unigrams.get(i).trim());
		       uniquebigrams = bigrams.toArray(new String[bigrams.size()]);
	}	
/*	for(int i=1; i<uniquebigrams.length; i++){
			System.out.println(uniquebigrams[i]);		
	}*/
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
		String inputTextParanthesisRemoved = textAST.replaceAll("[()]"," ");
	    inputTextParanthesisRemoved = inputTextParanthesisRemoved.replaceAll("\\d+\\t"," ");
		 inputTextParanthesisRemoved = inputTextParanthesisRemoved.replaceAll("( )+"," ");
	
		//			System.out.println("inputText "+inputTextParanthesisRemoved);


	for (int i=0; i<symbolCount; i++){
		//    	featureText remove paranthesis and replace with one space for feature text
		String str = ASTNodeBigrams[i].toString();
	//	System.out.println(str);
			counter[i] = counter[i] +StringUtils.countMatches(inputTextParanthesisRemoved, str.trim());
		//	System.out.println("counter: "+ counter[i]);
	}
	}
    return counter;
    }
}