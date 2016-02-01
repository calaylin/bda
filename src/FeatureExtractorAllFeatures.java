import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FeatureExtractorAllFeatures {

	public static void main(String[] args) throws IOException, InterruptedException{
		
	
		String test_dir ="/Users/Aylin/Desktop/test/";
		       		
		String output_filename = "/Users/Aylin/Desktop/testAllFeatures.arff" ;

		List test_binary_paths = Util.listBinaryFiles(test_dir);

		String text = "";
		//Writing the test arff
		Util.writeFile("@relation "+test_dir +"BinaryDeanonymizationAllFeatures"+"\n"+"\n",
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

		   	//BJOERN FEATURES START
		   	// Related files:
		     // 1645485_1480492_a9108_bjoernDisassembly/nodes.csv
			 // 1645485_1480492_a9108_bjoernDisassembly/1645485_1480492_a9108CFG/*.graphml
		  //get the basic block node unigrams in bjoern CFG and write the node unigram features
		   	String[] bjoernCFGNodeUnigrams =FeatureExtractor2016Bjoern.getBjoernCFGGraphmlNodeUnigrams(test_dir);
				for (int i=0; i<bjoernCFGNodeUnigrams.length; i++){  
					//  System.out.println("@attribute 'bjoernCFGNodeUnigrams"+i+ " "+bjoernCFGNodeUnigrams[i]);
				  	Util.writeFile("@attribute 'BjoernCFGGraphmlNodeUnigrams "+i+"=["+bjoernCFGNodeUnigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+ "\n", output_filename, true);
			       }
				
			//CFG NODE BIGRAMS AKA EDGES - REPR
			//get the cflow edges in bjoern CFG and write the node bigram features
		   	String[] bjoernCFGNodeBigrams =FeatureExtractor2016Bjoern.getBjoernCFGGraphmlNodeBigrams(test_dir);
		   	for (int i=0; i<bjoernCFGNodeBigrams.length; i++){  		   
			   	Util.writeFile("@attribute 'BjoernCFGGraphmlNodeBigrams "+i+"=["+bjoernCFGNodeBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+ "\n", output_filename, true);
				       }
		   	
			//		System.out.println("done with cfgUnigrams");

			//		Thread.sleep(10000000);
		   
		   	//DISASSEMBLY INSTRUCTION UNIGRAMS
			//CFG NODE UNIGRAMS - REPR
			//get the instruction unigrams in bjoern disassembly and write the instruction unigram features
			String[] bjoernDisassemblyUnigrams =FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionUnigrams(test_dir);
			for (int i=0; i<bjoernDisassemblyUnigrams.length; i++){  
				//	bjoernDisassemblyUnigrams[i] = bjoernDisassemblyUnigrams[i].replace("'", "apostrophesymbol");
				//  System.out.println("@attribute 'bjoernDisassemblyUnigrams"+i+ " "+bjoernDisassemblyUnigrams[i]);
			   	Util.writeFile("@attribute 'BjoernDisassemblyInstructionUnigrams "+i+"=["+bjoernDisassemblyUnigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+ "\n", output_filename, true);
		       }
		 
		   	//DISASSEMBLY INSTRUCTION BIGRAMS
		   	//get the instruction bigrams in bjoern disassembly and write the instruction bigram features
			String[] bjoernDisassemblyBigrams =FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionBigrams(test_dir);
		   	for (int i=0; i<bjoernDisassemblyBigrams.length; i++){ 
		//   	System.out.println("@attribute 'BjoernDisassemblyInstructionBigrams"+i+ " "+bjoernDisassemblyBigrams[i]);
	    		Util.writeFile("@attribute 'BjoernDisassemblyInstructionBigrams "+i+"=["+bjoernDisassemblyBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+ "\n", output_filename, true);
		   	}
		   	
		   	//DISASSEMBLY INSTRUCTION TRIGRAMS
		   	//get the instruction trigrams in bjoern disassembly and write the instruction trigram features
			String[] bjoernDisassemblyTrigrams =FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionTrigrams(test_dir);
		   	for (int i=0; i<bjoernDisassemblyTrigrams.length; i++){  
		   	//	System.out.println("@attribute 'BjoernDisassemblyInstructionTrigrams"+i+ " "+bjoernDisassemblyTrigrams[i]);
	    		Util.writeFile("@attribute 'BjoernDisassemblyInstructionTrigrams "+i+"=["+bjoernDisassemblyTrigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+ "\n", output_filename, true);
		   	}
		   	
		   	//DISASSEMBLY LINE UNIGRAMS
		   	//get the line unigrams in bjoern disassembly and write the line unigram features
		       String[] disassemblyLineUnigrams =FeatureExtractor2016Bjoern.getBjoernLineUnigrams(test_dir);
		    	for (int i=0; i<disassemblyLineUnigrams.length; i++)	   	
		    {
		    		Util.writeFile("@attribute 'disassemblyLineUnigrams "+i+"=["+disassemblyLineUnigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
        		//	System.out.println("@attribute 'disassemblyLineUnigrams "+i+"=["+disassemblyLineUnigrams[i]+"]");
		       }		
		    	
			 //DISASSEMBLY LINE BIGRAMS
		   	//get the line bigrams in bjoern disassembly and write the line bigram features
		    	String[] disassemblyLineBigrams =FeatureExtractor2016Bjoern.getBjoernLineBigrams(test_dir);
		    	for (int i=0; i<disassemblyLineBigrams.length; i++)	   	
		    	{  	
		    	Util.writeFile("@attribute 'disassemblyLineBigrams "+i+"=["+disassemblyLineBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
		    	//	System.out.println("@attribute 'disassemblyLineBigrams "+i+"=["+disassemblyLineBigrams[i]+"]");
		    	}	
			 //BJOERN FEATURES END
			 // Related files:
		     // 1645485_1480492_a9108_bjoernDisassembly/nodes.csv
			 // 1645485_1480492_a9108_bjoernDisassembly/1645485_1480492_a9108CFG/*.graphml

		    	
	     	// SNOWMAN CFG FEATURES START - Related files: (1842485_1486492_a9108_SnowmanDecompiled.dot)
	    	//FeatureExtractorSnowmanCFG		     	
		   	//get the Unigrams in the CFG and write the unigram features
		       String[] cfgSnowmanUnigrams =FeatureExtractorSnowmanCFG.getCFGUnigrams(test_dir);
		    	for (int i=0; i<cfgSnowmanUnigrams.length; i++)	   	
		       {  	
		           Util.writeFile("@attribute 'cfgSnowmanUnigrams "+i+"=["+cfgSnowmanUnigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);}
			   
		    	
		    	//the slowest feature
/*			   	// write the unigram tfidf features	   	
			    	for (int i=0; i<cfgSnowmanUnigrams.length; i++)	   	
			       {  	
			            	Util.writeFile("@attribute 'cfgSnowmanUnigramsTFIDF "+i+"=["+cfgSnowmanUnigrams[i]+"]' numeric"+"\n", output_filename, true);}
				   */
		    	
		    	  String[] cfgSnowmanNodeLastLine =FeatureExtractorSnowmanCFG.getCFGNodeLine(test_dir);
			    	for (int i=0; i<cfgSnowmanNodeLastLine.length; i++)	   	
			       {  	
			            Util.writeFile("@attribute 'cfgSnowmanNodeLastLine "+i+"=["+cfgSnowmanNodeLastLine[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);}			
			    	
		    	//get the bigrams in the CFG and write the bigram features
		    	String[] cfgSnowmanBigrams =FeatureExtractorSnowmanCFG.getCFGBigrams(test_dir);
		     	for (int i=0; i<cfgSnowmanBigrams.length; i++)	   	
			       {  
		     				String temp= cfgSnowmanBigrams[i].replace("'", "apostrophesymbol");
			            	Util.writeFile("@attribute 'cfgSnowmanBigrams "+i+"=["+temp.replace("\n", " ")+"]' numeric"+"\n", output_filename, true);}
	
		    	//get the bigrams in the CFG and write the bigram features
		    	String[] cfgSnowmanLineBigrams =FeatureExtractorSnowmanCFG.getCFGNodeLineBigram(test_dir);
		     	for (int i=0; i<cfgSnowmanLineBigrams.length; i++)	   	
			       {  		
		     				String temp= cfgSnowmanLineBigrams[i].replace("'", "apostrophesymbol");
			            	Util.writeFile("@attribute 'cfgSnowmanLineBigrams "+i+"=["+temp.replace("\n", " ")+"]' numeric"+"\n", output_filename, true);}		    			    	
				// SNOWMAN CFG FEATURES END	- Related files: (1842485_1486492_a9108_SnowmanDecompiled.dot)
		    	
		    	

			   	// NDISASM FEATURES START - DISASSEMBLY - Related files: (1842485_1486492_a9108.dis)
		    	//get the instruction unigrams in NDISASM disassembly and write the instruction unigram features
			    String[] disassemblyNDISASMUnigrams =FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionUnigrams(test_dir);
			    for (int i=0; i<disassemblyNDISASMUnigrams.length; i++)	   	
			       {  		
			    	Util.writeFile("@attribute 'NDISASMDisassemblyInstructionUnigrams "+i+"=["+disassemblyNDISASMUnigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
			    	}
			     

		     	//get the instruction bigrams in NDISASM disassembly and write the instruction bigram features
			    String[] disassemblyNDISASMBigrams =FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionBigrams(test_dir);
			    for (int i=0; i<disassemblyNDISASMBigrams.length; i++)	   	
			       {  		
		           	Util.writeFile("@attribute 'NDISASMDisassemblyInstructionBigrams "+i+"=["+disassemblyNDISASMBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
			       }

		     	//get the instruction trigrams in NDISASM disassembly and write the instruction trigram features
				String[] disassemblyNDISASMTrigrams =FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionTrigrams(test_dir);
				for (int i=0; i<disassemblyNDISASMTrigrams.length; i++)	   	
			       {  	
	       	 	Util.writeFile("@attribute 'NDISASMDisassemblyInstructionTrigrams "+i+"=["+disassemblyNDISASMTrigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);	
				}
				    
				 //get the lineBigrams in NDISASM disassembly and write the lineBigram features
				String[] disassemblyNDISASMLineBigrams =FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyLineBigrams(test_dir);
				for (int i=0; i<disassemblyNDISASMLineBigrams.length; i++)	   	
			    {  		
					Util.writeFile("@attribute 'NDISASMDisassemblyLineBigrams "+i+"=["+disassemblyNDISASMLineBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);	
				}
		     	// NDISASM FEATURES END - DISASSEMBLY - Related files: (1842485_1486492_a9108.dis)
		    	
		      	// DECOMPILED CODE AKA SCAA FEATURES START (FROM HEXRAYS)
			   	// Related files:
		    	// 1842485_1486492_a9108_hexrays_decompiled.cpp
		    	// 1842485_1486492_a9108_hexrays_decompiled.ast
		    	// 1842485_1486492_a9108_hexrays_decompiled.dep
		    	// 1842485_1486492_a9108_hexrays_decompiled.txt
		    	
				// DECOMPILED CODE AKA SCAA FEATURES END (FROM HEXRAYS)
			   	// Related files:
		       	// 1842485_1486492_a9108_hexrays_decompiled.cpp
		    	// 1842485_1486492_a9108_hexrays_decompiled.ast
		    	// 1842485_1486492_a9108_hexrays_decompiled.dep
		    	// 1842485_1486492_a9108_hexrays_decompiled.txt
			  
				
			    //uniqueASTTypes does not contain user input, such as function and variable names
			    //uniqueDepASTTypes contain user input, such as function and variable names
			    
			//Use the following for syntactic inner nodes and code leaves (remember to change astlabel.py accordingly!
			 
			  String[] wordUnigramsCPP =FeatureExtractorDecompiledCode.getWordUnigramsDecompiledCode(test_dir, "cpp");
			  for (int i=0; i<wordUnigramsCPP.length; i++)	   	
		     {  	
		     Util.writeFile("@attribute 'wordUnigramsCPP "+i+"=["+wordUnigramsCPP[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
		     }	
 
			  String[] ASTNodeBigrams = BigramExtractor.getASTNodeBigrams(test_dir);
			  for (int i=0; i<ASTNodeBigrams.length; i++)		
		   	  {  	
			    	Util.writeFile("@attribute 'ASTNodeBigramsTF "+i+"=["+ASTNodeBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
			  }
			   
			  String[] ASTtypes =FeatureCalculators.uniqueDepASTTypes(test_dir);     
			    for (int i=0; i<ASTtypes.length; i++)	   	
			  {  	
			    	Util.writeFile("@attribute 'ASTNodeTypesTF "+i+"=["+ASTtypes[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
			  }
			  
			    for (int i=0; i<ASTtypes.length; i++)	
			  {	   
			    	Util.writeFile("@attribute 'ASTNodeTypesTFIDF "+i+"=["+ASTtypes[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
			  }
			  
			    for (int i=0; i<ASTtypes.length; i++)	
			    {	   
			    	Util.writeFile("@attribute 'ASTNodeTypeAvgDep "+i+"=["+ASTtypes[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
			    }
			  
			    
			    
			    String [] cppKeywords = {"auto", 	"break", 	"case", 	"char", 	"const", 	
				  "continue", 	"default", 	"do", 	"double", 	"else", 	"enum", 	
				  "extern", 	"float", 	"for", 	"goto", 	"if", 	"inline", 	
				  "int", 	"long", 	"register", 	"restrict", 	"return", 	"short", 	
				  "signed", 	"sizeof", 	"static", 	"struct", 	"switch", 	"typedef", 	
				  "union", 	"unsigned", 	"void", 	"volatile", 	"while", 	"_Alignas", 	
				  "_Alignof", 	"_Atomic", 	"_Bool", 	"_Complex", 	"_Generic", 	"_Imaginary",
				  "_Noreturn", 	"_Static_assert", 	"_Thread_local","alignas",	"alignof",	"and",	"and_eq",	"asm",	
				  "bitand",	"bitor",	"bool",	"catch",	"char",	"char16_t",	"char32_t",
				  "class",	"compl",	"const",	"constexpr",	"const_cast",	"decltype",	
				  "delete",	"dynamic_cast",	"explicit",	"export",	
				  "FALSE",		"friend",		
				  "mutable",	"namespace",	"new",	"noexcept",	"not",	"not_eq",	"nullptr",	"operator",	"or",
				  "or_eq"	,"private"	,"protected"	,"public"	,	"reinterpret_cast",	
				  "static_assert",	"static_cast",	
				  	"template",	"this"	,"thread_local",	"throw",	"TRUE",	"try",		"typeid",
				  "typename",		"using",	"virtual",		"wchar_t",
				  "xor",	"xor_eq", "override", "final"}; 
			    for (int i=0; i<cppKeywords.length; i++)	
			  {	Util.writeFile("@attribute 'cppKeyword "+i+"=["+cppKeywords[i]+"]' numeric"+"\n", output_filename, true);}


		    	

	
		     	
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
				authorFileName = new File(test_binary_paths.get(i).toString());
				String authorName= authorFileName.getParentFile().getName() +
						"_"+authorFileName.getParentFile().getParentFile().getName();
				System.out.println("Binary filename: "+test_binary_paths.get(i));
				System.out.println("Author: "+authorName);
				String fileNameID = authorFileName.getName() +
						"_"+authorFileName.getParentFile().getParentFile().getName();
				Util.writeFile(fileNameID+",", output_filename, true);
				String featureTextBjoernDisassembly = Util.readFile(authorFileName.getParentFile()
				+ File.separator + authorFileName.getName()+"_bjoernDisassembly"+ File.separator + "nodes.csv");

				
			     // BJOERN FEATURES START
				 // Related files:
			     // 1645485_1480492_a9108_bjoernDisassembly/nodes.csv
				 // 1645485_1480492_a9108_bjoernDisassembly/1645485_1480492_a9108CFG/*.graphml

				//GETTING CFG NODE UNIGRAMS
				//get count of each cfg node unigram in CFGBjoern 
				float[] cfgNodeUniCount = FeatureExtractor2016Bjoern.getBjoernCFGGraphmlNodeUnigramsTF(authorFileName , bjoernCFGNodeUnigrams);			   
			    for (int j=0; j<cfgNodeUniCount.length; j++){
				Util.writeFile(cfgNodeUniCount[j] +",", output_filename, true);
				}
			    
				//GETTING CFG EDGES AKA NODE BIGRAMS
				//get count of each cfg node bigram in CFGBjoern 
				float[] cfgEdgeBigramCount = FeatureExtractor2016Bjoern.getBjoernCFGGraphmlNodeBigramsTF(authorFileName , bjoernCFGNodeBigrams);			   
			    for (int j=0; j<cfgEdgeBigramCount.length; j++){
				Util.writeFile(cfgEdgeBigramCount[j] +",", output_filename, true);
				}
			    
			    //get count of each instruction unigram in disassemblyBjoern 
			    float[] wordUniCount = FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionUnigramsTF(featureTextBjoernDisassembly, bjoernDisassemblyUnigrams);
			    for (int j=0; j<wordUniCount.length; j++)
				{Util.writeFile(wordUniCount[j] +",", output_filename, true);}	
			    
			    //get count of each instruction bigram in disassemblyBjoern	 
			    float[] wordBigramCount = FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionBigramsTF(featureTextBjoernDisassembly, bjoernDisassemblyBigrams);
			    for (int j=0; j<wordBigramCount.length; j++)
				{Util.writeFile(wordBigramCount[j] +",", output_filename, true);}

			    //get count of each instruction trigram in disassemblyBjoern	 
			    float[] wordTrigramCount = FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionTrigramsTF(featureTextBjoernDisassembly, bjoernDisassemblyTrigrams);
			    for (int j=0; j<wordTrigramCount.length; j++)
				{Util.writeFile(wordTrigramCount[j] +",", output_filename, true);}

			    //get count of each line unigram in disassemblyBjoern	 
			    float[] lineUnigramCount = FeatureExtractor2016Bjoern.getBjoernLineUnigramsTF(featureTextBjoernDisassembly, disassemblyLineUnigrams);
			    for (int j=0; j<lineUnigramCount.length; j++)
				{Util.writeFile(lineUnigramCount[j] +",", output_filename, true);}
			    
			    //get count of each line bigram in disassemblyBjoern	 
			    float[] lineBigramCount = FeatureExtractor2016Bjoern.getBjoernLineBigramsTF(featureTextBjoernDisassembly, disassemblyLineBigrams);
			    for (int j=0; j<lineBigramCount.length; j++)
				{Util.writeFile(lineBigramCount[j] +",", output_filename, true);}
			    //BJOERN FEATURES END
				 // Related files:
			     // 1645485_1480492_a9108_bjoernDisassembly/nodes.csv
				 // 1645485_1480492_a9108_bjoernDisassembly/1645485_1480492_a9108CFG/*.graphml

			    
			   	// SNOWMAN CFG FEATURES START - Related files: (1842485_1486492_a9108_SnowmanDecompiled.dot)
				String featureTextSnowmanCFG = Util.readFile(authorFileName.getParentFile()
						+ File.separator + authorFileName.getName()+"_SnowmanDecompiled.dot");		     	
			    //get count of each wordUnigram in Snowman CFG 
				
			    float[] wordUniCount1 = FeatureExtractorSnowmanCFG.getCFGUnigramTF(featureTextSnowmanCFG, cfgSnowmanUnigrams);
			    for (int j=0; j<wordUniCount1.length; j++)
				{Util.writeFile(wordUniCount1[j] +",", output_filename, true);}	
			    
			    //tfidf is the slowest feature so far
/*			    
 * 				String [] cfgSnowmanUnigramsTFIDF= cfgSnowmanUnigrams;
 * 				float[] uniTFIDF = FeatureExtractorSnowmanCFG.getCFGUnigramsTFIDF(featureTextSnowmanCFG, test_dir, cfgSnowmanUnigrams);
			    for (int j=0; j<uniTFIDF.length; j++)
				{Util.writeFile(uniTFIDF[j] +",", output_filename, true);}	*/
			    
			    //get count of each line unigram in Snowman CFG	 
			    float[] cfgNodeLastLineCount = FeatureExtractorSnowmanCFG.getCFGNodeLineTF(featureTextSnowmanCFG, cfgSnowmanNodeLastLine);
			    for (int j=0; j<cfgNodeLastLineCount.length; j++)
				{Util.writeFile(cfgNodeLastLineCount[j] +",", output_filename, true);}	


			    
			    //get count of each bigram in Snowman CFG	 
			    float[] wordBigramCount1 = FeatureExtractorSnowmanCFG.getCFGBigramsTF(featureTextSnowmanCFG, cfgSnowmanBigrams);
			    for (int j=0; j<wordBigramCount1.length; j++)
				{Util.writeFile(wordBigramCount1[j] +",", output_filename, true);}
			    
			    //get count of each line bigram in Snowman CFG 	 
			    float[] lineBigramSnowmanCount = FeatureExtractorSnowmanCFG.getCFGNodeLineBigramTF(featureTextSnowmanCFG, cfgSnowmanLineBigrams);
			    for (int j=0; j<lineBigramSnowmanCount.length; j++)
				{Util.writeFile(lineBigramSnowmanCount[j] +",", output_filename, true);}			   	
			   // SNOWMAN CFG FEATURES END	- Related files: (1842485_1486492_a9108_SnowmanDecompiled.dot)

				 // NDISASM FEATURES START - DISASSEMBLY - Related files: (1842485_1486492_a9108.dis)
				String featureTextNDISASMDisassembly = Util.readFile(authorFileName.getParentFile()
				+ File.separator + authorFileName.getName()+".dis");
			
				 //get count of each NDISASMDisassemblyInstructionUnigram in NDISASM disassembly 
			    float[] instructionUnigramNDISASMCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionUnigramsTF(featureTextNDISASMDisassembly, disassemblyNDISASMUnigrams);
			    for (int j=0; j<instructionUnigramNDISASMCount.length; j++)
				{Util.writeFile(instructionUnigramNDISASMCount[j] +",", output_filename, true);}	
			    
				 //get count of each NDISASMDisassemblyInstructionBigram in NDISASM disassembly 
			    float[] instructionBigramNDISASMCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionBigramsTF(featureTextNDISASMDisassembly, disassemblyNDISASMBigrams);
			    for (int j=0; j<instructionBigramNDISASMCount.length; j++)
				{Util.writeFile(instructionBigramNDISASMCount[j] +",", output_filename, true);}
			   	
				 //get count of each NDISASMDisassemblyInstructionTrigram in NDISASM disassembly 
			    float[] instructionTrigramNDISASMCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionTrigramsTF(featureTextNDISASMDisassembly, disassemblyNDISASMTrigrams);
			    for (int j=0; j<instructionTrigramNDISASMCount.length; j++)
				{Util.writeFile(instructionTrigramNDISASMCount[j] +",", output_filename, true);}
			   	
				String disTextNdisasm = Util.readNDISASMFile(test_binary_paths.get(i).toString());
				 //get count of each NDISASMDisassemblyLineBigrams in NDISASM disassembly 
			    float[] lineBigramNDISASMCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyLineBigramsTF(disTextNdisasm, disassemblyNDISASMLineBigrams);
			    for (int j=0; j<lineBigramNDISASMCount.length; j++)
				{Util.writeFile(lineBigramNDISASMCount[j] +",", output_filename, true);}	
			    // NDISASM FEATURES END - DISASSEMBLY - Related files: (1842485_1486492_a9108.dis)
			    	

		    	// Related files:
		      	// DECOMPILED CODE AKA SCAA FEATURES START (FROM HEXRAYS)
		    	// 1842485_1486492_a9108_hexrays_decompiled.cpp
				String featureTextHexraysDecompiledCodeCPP = Util.readFile(authorFileName.getParentFile()
				+ File.separator + authorFileName.getName()+"_hexrays_decompiled.cpp");
			    // 1842485_1486492_a9108_hexrays_decompiled.ast
				String featureTextHexraysDecompiledCodeAST = Util.readFile(authorFileName.getParentFile()
						+ File.separator + authorFileName.getName()+"_hexrays_decompiled.ast");
			   	// 1842485_1486492_a9108_hexrays_decompiled.dep
				String featureTextHexraysDecompiledCodeDEP = Util.readFile(authorFileName.getParentFile()
						+ File.separator + authorFileName.getName()+"_hexrays_decompiled.dep");
			   	// 1842485_1486492_a9108_hexrays_decompiled.txt
				String featureTextHexraysDecompiledCodeTXT = Util.readFile(authorFileName.getParentFile()
						+ File.separator + authorFileName.getName()+"_hexrays_decompiled.txt");
			    	
				
			    //get count of each wordUnigram in C source file	 
			    float[] wordUniCountCPP = FeatureExtractorDecompiledCode.getWordUnigramsDecompiledCodeTF(featureTextHexraysDecompiledCodeCPP, wordUnigramsCPP);
			    for (int j=0; j<wordUniCountCPP.length; j++)
				{Util.writeFile(wordUniCountCPP[j] +",", output_filename, true);}	
				
			    //AST node bigrams
				float[] bigramCount = BigramExtractor.getASTNodeBigramsTF(featureTextHexraysDecompiledCodeDEP, ASTNodeBigrams );
				for (int j=0; j<ASTNodeBigrams.length; j++)
				{Util.writeFile(bigramCount[j] +",", output_filename, true);}	    
				    
				
			    //get count of each ASTtype not-DepAST type present	 
			    float[] typeCount = FeatureCalculators.DepASTTypeTF(featureTextHexraysDecompiledCodeDEP, ASTtypes );
			    for (int j=0; j<ASTtypes.length; j++)
				{Util.writeFile(typeCount[j] +",", output_filename, true);}	
			    
				//get tfidf of each AST Type present	 
			    float[] DepastTypeTFIDF = FeatureCalculators.DepASTTypeTFIDF(featureTextHexraysDecompiledCodeDEP, test_dir, ASTtypes);
			    for (int j=0; j<ASTtypes.length; j++)
				{Util.writeFile(DepastTypeTFIDF[j]+",", output_filename, true);}	
				
			    //get AST node avg depth
		    	float [] depFeature =DepthASTNode.getAvgDepthASTNode(featureTextHexraysDecompiledCodeDEP,ASTtypes);
		    	for(int k=0;k<depFeature.length;k++)
				{Util.writeFile(depFeature[k] +",", output_filename, true);}	
			    
		    	float [] cppKeywordsTF =FeatureCalculators.getCandCPPKeywordsTF(featureTextHexraysDecompiledCodeCPP);
		    	for(int k=0;k<cppKeywordsTF.length;k++)
				{Util.writeFile(cppKeywordsTF[k] +",", output_filename, true);}		
			   	// Related files:
				// DECOMPILED CODE AKA SCAA FEATURES END (FROM HEXRAYS)
		       	// 1842485_1486492_a9108_hexrays_decompiled.cpp
			    // 1842485_1486492_a9108_hexrays_decompiled.ast
			    // 1842485_1486492_a9108_hexrays_decompiled.dep
			    // 1842485_1486492_a9108_hexrays_decompiled.txt
			    			    			   
				Util.writeFile(authorName+"\n", output_filename, true);
		   	}
	}		
}