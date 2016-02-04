import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FeatureExtractorAllFeaturesConcurrent implements Runnable {

	private String test_dir; 
	private String output_filename;
	private int start;
	private int end;

		    public FeatureExtractorAllFeaturesConcurrent(String test_dir, 
			String output_filename,int start, int end){
				

		    	this.test_dir =test_dir;
		    	this.output_filename=output_filename;
		        this.start = start;
		        this.end = end;
		    }

		    public static void main(String[] args){
		    	String test_dir ="/home/ubuntu/Desktop/usenix16/datasets/L0_150authors/";	       		
				String output_filename = "/home/ubuntu/Desktop/usenix16/arffs/L0_150authorsConcurrent/L0_150authors_allfeatures_concurrent";

				List test_binary_paths = Util.listBinaryFiles(test_dir);
				int totalFiles = test_binary_paths.size();
				int threads = 20;
				int extra = totalFiles % threads;
				int noFiles= totalFiles/threads;
		        Thread looper21 = null;

				
				
		        Thread looper1 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"1.arff" ,(noFiles*0),(noFiles*1)-1));
		        Thread looper2 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"2.arff",(noFiles*1),(noFiles*2)-1));
		        Thread looper3 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"3.arff" ,(noFiles*2),(noFiles*3)-1));
		        Thread looper4 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"4.arff",(noFiles*3),(noFiles*4)-1));		        
		        Thread looper5 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"5.arff" ,(noFiles*4),(noFiles*5)-1));
		        Thread looper6 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"6.arff",(noFiles*5),(noFiles*6)-1));
		        Thread looper7 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"7.arff" ,(noFiles*6),(noFiles*7)-1));
		        Thread looper8 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"8.arff",(noFiles*7),(noFiles*8)-1));		    
		        Thread looper9 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"9.arff" ,(noFiles*8),(noFiles*9)-1));
		        Thread looper10 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"10.arff",(noFiles*9),(noFiles*10)-1));		        
		        Thread looper11 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"11.arff" ,(noFiles*10),(noFiles*11)-1));
		        Thread looper12 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"12.arff",(noFiles*11),(noFiles*12)-1));		        
		        Thread looper13 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"13.arff" ,(noFiles*12),(noFiles*13)-1));
		        Thread looper14 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"14.arff",(noFiles*13),(noFiles*14)-1));
		        Thread looper15 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"15.arff" ,(noFiles*14),(noFiles*15)-1));
		        Thread looper16 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"16.arff" ,(noFiles*15),(noFiles*16)-1));
		        Thread looper17 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"17.arff" ,(noFiles*16),(noFiles*17)-1));
		        Thread looper18 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"18.arff" ,(noFiles*17),(noFiles*18)-1));
		        Thread looper19 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"19.arff" ,(noFiles*18),(noFiles*19)-1));
		        Thread looper20 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"20.arff" ,(noFiles*19),(noFiles*20)-1));
    
				if (extra > 0){
					   looper21 = new Thread(new 
				        		FeatureExtractorAllFeaturesConcurrent(test_dir,
				        				output_filename+"21.arff" ,(noFiles*20),(totalFiles-1)));	
						looper21.start();

				}
		        
		        
		        looper1.start();
		        looper2.start();
		        looper3.start();
		        looper4.start();
		        looper5.start();
		        looper6.start();
		        looper7.start();
		        looper8.start();
		        looper9.start();
		        looper10.start();
		        looper11.start();
		        looper12.start();
		        looper13.start();
		        looper14.start();
		        looper15.start();
		        looper16.start();
		        looper17.start();
		        looper18.start();
		        looper19.start();
		        looper20.start();


		    }
		    @Override
		    public void run() {
		      		   

		List test_binary_paths = Util.listBinaryFiles(test_dir);

		String text = "";
		//Writing the test arff
		Util.writeFile("@relation "+test_dir +"BinaryDeanonymizationAllFeatures"+"\n"+"\n",
		    			output_filename, true);
		Util.writeFile("@attribute instanceID_original {", output_filename, true);

		   	for(int j=0; j < test_binary_paths.size();j++)
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
		   	String[] bjoernCFGNodeUnigrams = null;
			try {
				bjoernCFGNodeUnigrams = FeatureExtractor2016Bjoern.getBjoernCFGGraphmlNodeUnigrams(test_dir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				for (int i=0; i<bjoernCFGNodeUnigrams.length; i++){  
					//  System.out.println("@attribute 'bjoernCFGNodeUnigrams"+i+ " "+bjoernCFGNodeUnigrams[i]);
				  	Util.writeFile("@attribute 'BjoernCFGGraphmlNodeUnigrams "+i+"=["+bjoernCFGNodeUnigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+ "\n", output_filename, true);
			       }
				
			//CFG NODE BIGRAMS AKA EDGES - REPR
			//get the cflow edges in bjoern CFG and write the node bigram features
		   	String[] bjoernCFGNodeBigrams = null;
			try {
				bjoernCFGNodeBigrams = FeatureExtractor2016Bjoern.getBjoernCFGGraphmlNodeBigrams(test_dir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   	for (int i=0; i<bjoernCFGNodeBigrams.length; i++){  		   
			   	Util.writeFile("@attribute 'BjoernCFGGraphmlNodeBigrams "+i+"=["+bjoernCFGNodeBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+ "\n", output_filename, true);
				       }
		   	
			//		System.out.println("done with cfgUnigrams");

			//		Thread.sleep(10000000);
		   
		   	//DISASSEMBLY INSTRUCTION UNIGRAMS
			//CFG NODE UNIGRAMS - REPR
			//get the instruction unigrams in bjoern disassembly and write the instruction unigram features
			String[] bjoernDisassemblyUnigrams = null;
			try {
				bjoernDisassemblyUnigrams = FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionUnigrams(test_dir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i=0; i<bjoernDisassemblyUnigrams.length; i++){  
				//	bjoernDisassemblyUnigrams[i] = bjoernDisassemblyUnigrams[i].replace("'", "apostrophesymbol");
				//  System.out.println("@attribute 'bjoernDisassemblyUnigrams"+i+ " "+bjoernDisassemblyUnigrams[i]);
			   	Util.writeFile("@attribute 'BjoernDisassemblyInstructionUnigrams "+i+"=["+bjoernDisassemblyUnigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+ "\n", output_filename, true);
		       }
		 
		   	//DISASSEMBLY INSTRUCTION BIGRAMS
		   	//get the instruction bigrams in bjoern disassembly and write the instruction bigram features
			String[] bjoernDisassemblyBigrams = null;
			try {
				bjoernDisassemblyBigrams = FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionBigrams(test_dir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   	for (int i=0; i<bjoernDisassemblyBigrams.length; i++){ 
		//   	System.out.println("@attribute 'BjoernDisassemblyInstructionBigrams"+i+ " "+bjoernDisassemblyBigrams[i]);
	    		Util.writeFile("@attribute 'BjoernDisassemblyInstructionBigrams "+i+"=["+bjoernDisassemblyBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+ "\n", output_filename, true);
		   	}
		   	
		   	//DISASSEMBLY INSTRUCTION TRIGRAMS
		   	//get the instruction trigrams in bjoern disassembly and write the instruction trigram features
			String[] bjoernDisassemblyTrigrams = null;
			try {
				bjoernDisassemblyTrigrams = FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionTrigrams(test_dir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   	for (int i=0; i<bjoernDisassemblyTrigrams.length; i++){  
		   	//	System.out.println("@attribute 'BjoernDisassemblyInstructionTrigrams"+i+ " "+bjoernDisassemblyTrigrams[i]);
	    		Util.writeFile("@attribute 'BjoernDisassemblyInstructionTrigrams "+i+"=["+bjoernDisassemblyTrigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+ "\n", output_filename, true);
		   	}
		   	
		   	//DISASSEMBLY LINE UNIGRAMS
		   	//get the line unigrams in bjoern disassembly and write the line unigram features
		       String[] disassemblyLineUnigrams = null;
			try {
				disassemblyLineUnigrams = FeatureExtractor2016Bjoern.getBjoernLineUnigrams(test_dir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    	for (int i=0; i<disassemblyLineUnigrams.length; i++)	   	
		    {
		    		Util.writeFile("@attribute 'disassemblyBjoernLineUnigrams "+i+"=["+disassemblyLineUnigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
        		//	System.out.println("@attribute 'disassemblyLineUnigrams "+i+"=["+disassemblyLineUnigrams[i]+"]");
		       }		
		    	
			 //DISASSEMBLY LINE BIGRAMS
		   	//get the line bigrams in bjoern disassembly and write the line bigram features
		    	String[] disassemblyLineBigrams = null;
				try {
					disassemblyLineBigrams = FeatureExtractor2016Bjoern.getBjoernLineBigrams(test_dir);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	for (int i=0; i<disassemblyLineBigrams.length; i++)	   	
		    	{  	
		    	Util.writeFile("@attribute 'disassemblyBjoernLineBigrams "+i+"=["+disassemblyLineBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
		    	//	System.out.println("@attribute 'disassemblyLineBigrams "+i+"=["+disassemblyLineBigrams[i]+"]");
		    	}	
			 //BJOERN FEATURES END
			 // Related files:
		     // 1645485_1480492_a9108_bjoernDisassembly/nodes.csv
			 // 1645485_1480492_a9108_bjoernDisassembly/1645485_1480492_a9108CFG/*.graphml

		    	
	     	// SNOWMAN CFG FEATURES START - Related files: (1842485_1486492_a9108_SnowmanDecompiled.dot)
	    	//FeatureExtractorSnowmanCFG		     	
		   	//get the Unigrams in the CFG and write the unigram features
		       String[] cfgSnowmanUnigrams = null;
			try {
				cfgSnowmanUnigrams = FeatureExtractorSnowmanCFG.getCFGUnigrams(test_dir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    	for (int i=0; i<cfgSnowmanUnigrams.length; i++)	   	
		       {  	
		           Util.writeFile("@attribute 'cfgSnowmanUnigrams "+i+"=["+cfgSnowmanUnigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);}
			   
		    	
		    	//the slowest feature
/*			   	// write the unigram tfidf features	   	
			    	for (int i=0; i<cfgSnowmanUnigrams.length; i++)	   	
			       {  	
			            	Util.writeFile("@attribute 'cfgSnowmanUnigramsTFIDF "+i+"=["+cfgSnowmanUnigrams[i]+"]' numeric"+"\n", output_filename, true);}
				   */
		    	
		    	  String[] cfgSnowmanNodeLastLine = null;
				try {
					cfgSnowmanNodeLastLine = FeatureExtractorSnowmanCFG.getCFGNodeLine(test_dir);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    	for (int i=0; i<cfgSnowmanNodeLastLine.length; i++)	   	
			       {  	
			            Util.writeFile("@attribute 'cfgSnowmanNodeLastLine "+i+"=["+cfgSnowmanNodeLastLine[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);}			
			    	
		    	//get the bigrams in the CFG and write the bigram features
		    	String[] cfgSnowmanBigrams = null;
				try {
					cfgSnowmanBigrams = FeatureExtractorSnowmanCFG.getCFGBigrams(test_dir);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     	for (int i=0; i<cfgSnowmanBigrams.length; i++)	   	
			       {  
		     				String temp= cfgSnowmanBigrams[i].replace("'", "apostrophesymbol");
			            	Util.writeFile("@attribute 'cfgSnowmanBigrams "+i+"=["+temp.replace("\n", " ")+"]' numeric"+"\n", output_filename, true);}
	
		    	//get the bigrams in the CFG and write the bigram features
		    	String[] cfgSnowmanLineBigrams = null;
				try {
					cfgSnowmanLineBigrams = FeatureExtractorSnowmanCFG.getCFGNodeLineBigram(test_dir);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     	for (int i=0; i<cfgSnowmanLineBigrams.length; i++)	   	
			       {  		
		     				String temp= cfgSnowmanLineBigrams[i].replace("'", "apostrophesymbol");
			            	Util.writeFile("@attribute 'cfgSnowmanLineBigrams "+i+"=["+temp.replace("\n", " ")+"]' numeric"+"\n", output_filename, true);}		    			    	
				// SNOWMAN CFG FEATURES END	- Related files: (1842485_1486492_a9108_SnowmanDecompiled.dot)
		    	
		    	

			   	// NDISASM FEATURES START - DISASSEMBLY - Related files: (1842485_1486492_a9108.dis)
		    	//get the instruction unigrams in NDISASM disassembly and write the instruction unigram features
			    String[] disassemblyNDISASMUnigrams = null;
				try {
					disassemblyNDISASMUnigrams = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionUnigrams(test_dir);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int i=0; i<disassemblyNDISASMUnigrams.length; i++)	   	
			       {  		
			    	Util.writeFile("@attribute 'NDISASMDisassemblyInstructionUnigrams "+i+"=["+disassemblyNDISASMUnigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
			    	}
			     

		     	//get the instruction bigrams in NDISASM disassembly and write the instruction bigram features
			    String[] disassemblyNDISASMBigrams = null;
				try {
					disassemblyNDISASMBigrams = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionBigrams(test_dir);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int i=0; i<disassemblyNDISASMBigrams.length; i++)	   	
			       {  		
		           	Util.writeFile("@attribute 'NDISASMDisassemblyInstructionBigrams "+i+"=["+disassemblyNDISASMBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
			       }

		     	//get the instruction trigrams in NDISASM disassembly and write the instruction trigram features
				String[] disassemblyNDISASMTrigrams = null;
				try {
					disassemblyNDISASMTrigrams = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionTrigrams(test_dir);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i=0; i<disassemblyNDISASMTrigrams.length; i++)	   	
			       {  	
	       	 	Util.writeFile("@attribute 'NDISASMDisassemblyInstructionTrigrams "+i+"=["+disassemblyNDISASMTrigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);	
				}
				    
				 //get the lineBigrams in NDISASM disassembly and write the lineBigram features
				String[] disassemblyNDISASMLineBigrams = null;
				try {
					disassemblyNDISASMLineBigrams = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyLineBigrams(test_dir);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			 
			  String[] wordUnigramsCPP = null;
			try {
				wordUnigramsCPP = FeatureExtractorDecompiledCode.getWordUnigramsDecompiledCode(test_dir, "cpp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  for (int i=0; i<wordUnigramsCPP.length; i++)	   	
		     {  	
		     Util.writeFile("@attribute 'wordUnigramsCPP "+i+"=["+wordUnigramsCPP[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
		     }	
 
			  String[] ASTNodeBigrams = null;
			try {
				ASTNodeBigrams = BigramExtractor.getASTNodeBigrams(test_dir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  for (int i=0; i<ASTNodeBigrams.length; i++)		
		   	  {  	
			    	Util.writeFile("@attribute 'ASTNodeBigramsTF "+i+"=["+ASTNodeBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
			  }
			   
			  String[] ASTtypes = null;
			try {
				ASTtypes = FeatureCalculators.uniqueDepASTTypes(test_dir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     
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
			
			
			//THIS IS WHERE THE TEST PARAMETERS BECOME EFFECTIVE			
			//for(int i=0; i< test_binary_paths.size(); i++){
//	         test_dir output_filename start end		
			for(int i=start; i<=end; i++){

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
				String featureTextBjoernDisassembly = null;
				try {
					featureTextBjoernDisassembly = Util.readFile(authorFileName.getParentFile()
					+ File.separator + authorFileName.getName()+"_bjoernDisassembly"+ File.separator + "nodes.csv");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			     // BJOERN FEATURES START
				 // Related files:
			     // 1645485_1480492_a9108_bjoernDisassembly/nodes.csv
				 // 1645485_1480492_a9108_bjoernDisassembly/1645485_1480492_a9108CFG/*.graphml

				//GETTING CFG NODE UNIGRAMS
				//get count of each cfg node unigram in CFGBjoern 
				float[] cfgNodeUniCount = null;
				try {
					cfgNodeUniCount = FeatureExtractor2016Bjoern.getBjoernCFGGraphmlNodeUnigramsTF(authorFileName , bjoernCFGNodeUnigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			   
			    for (int j=0; j<cfgNodeUniCount.length; j++){
				Util.writeFile(cfgNodeUniCount[j] +",", output_filename, true);
				}
			    
				//GETTING CFG EDGES AKA NODE BIGRAMS
				//get count of each cfg node bigram in CFGBjoern 
				float[] cfgEdgeBigramCount = null;
				try {
					cfgEdgeBigramCount = FeatureExtractor2016Bjoern.getBjoernCFGGraphmlNodeBigramsTF(authorFileName , bjoernCFGNodeBigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			   
			    for (int j=0; j<cfgEdgeBigramCount.length; j++){
				Util.writeFile(cfgEdgeBigramCount[j] +",", output_filename, true);
				}
			    
			    //get count of each instruction unigram in disassemblyBjoern 
			    float[] wordUniCount = FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionUnigramsTF(featureTextBjoernDisassembly, bjoernDisassemblyUnigrams);
			    for (int j=0; j<wordUniCount.length; j++)
				{Util.writeFile(wordUniCount[j] +",", output_filename, true);}	
			    
			    //get count of each instruction bigram in disassemblyBjoern	 
			    float[] wordBigramCount = null;
				try {
					wordBigramCount = FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionBigramsTF(featureTextBjoernDisassembly, bjoernDisassemblyBigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<wordBigramCount.length; j++)
				{Util.writeFile(wordBigramCount[j] +",", output_filename, true);}

			    //get count of each instruction trigram in disassemblyBjoern	 
			    float[] wordTrigramCount = null;
				try {
					wordTrigramCount = FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionTrigramsTF(featureTextBjoernDisassembly, bjoernDisassemblyTrigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<wordTrigramCount.length; j++)
				{Util.writeFile(wordTrigramCount[j] +",", output_filename, true);}

			    //get count of each line unigram in disassemblyBjoern	 
			    float[] lineUnigramCount = FeatureExtractor2016Bjoern.getBjoernLineUnigramsTF(featureTextBjoernDisassembly, disassemblyLineUnigrams);
			    for (int j=0; j<lineUnigramCount.length; j++)
				{Util.writeFile(lineUnigramCount[j] +",", output_filename, true);}
			    
			    //get count of each line bigram in disassemblyBjoern	 
			    float[] lineBigramCount = null;
				try {
					lineBigramCount = FeatureExtractor2016Bjoern.getBjoernLineBigramsTF(featureTextBjoernDisassembly, disassemblyLineBigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<lineBigramCount.length; j++)
				{Util.writeFile(lineBigramCount[j] +",", output_filename, true);}
			    //BJOERN FEATURES END
				 // Related files:
			     // 1645485_1480492_a9108_bjoernDisassembly/nodes.csv
				 // 1645485_1480492_a9108_bjoernDisassembly/1645485_1480492_a9108CFG/*.graphml

			    
			   	// SNOWMAN CFG FEATURES START - Related files: (1842485_1486492_a9108_SnowmanDecompiled.dot)
				String featureTextSnowmanCFG = null;
				try {
					featureTextSnowmanCFG = Util.readFile(authorFileName.getParentFile()
							+ File.separator + authorFileName.getName()+"_SnowmanDecompiled.dot");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		     	
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
			    float[] wordBigramCount1 = null;
				try {
					wordBigramCount1 = FeatureExtractorSnowmanCFG.getCFGBigramsTF(featureTextSnowmanCFG, cfgSnowmanBigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<wordBigramCount1.length; j++)
				{Util.writeFile(wordBigramCount1[j] +",", output_filename, true);}
			    
			    //get count of each line bigram in Snowman CFG 	 
			    float[] lineBigramSnowmanCount = null;
				try {
					lineBigramSnowmanCount = FeatureExtractorSnowmanCFG.getCFGNodeLineBigramTF(featureTextSnowmanCFG, cfgSnowmanLineBigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<lineBigramSnowmanCount.length; j++)
				{Util.writeFile(lineBigramSnowmanCount[j] +",", output_filename, true);}			   	
			   // SNOWMAN CFG FEATURES END	- Related files: (1842485_1486492_a9108_SnowmanDecompiled.dot)

				 // NDISASM FEATURES START - DISASSEMBLY - Related files: (1842485_1486492_a9108.dis)
				String featureTextNDISASMDisassembly = null;
				try {
					featureTextNDISASMDisassembly = Util.readFile(authorFileName.getParentFile()
					+ File.separator + authorFileName.getName()+".dis");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				 //get count of each NDISASMDisassemblyInstructionUnigram in NDISASM disassembly 
			    float[] instructionUnigramNDISASMCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionUnigramsTF(featureTextNDISASMDisassembly, disassemblyNDISASMUnigrams);
			    for (int j=0; j<instructionUnigramNDISASMCount.length; j++)
				{Util.writeFile(instructionUnigramNDISASMCount[j] +",", output_filename, true);}	
			    
				 //get count of each NDISASMDisassemblyInstructionBigram in NDISASM disassembly 
			    float[] instructionBigramNDISASMCount = null;
				try {
					instructionBigramNDISASMCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionBigramsTF(featureTextNDISASMDisassembly, disassemblyNDISASMBigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<instructionBigramNDISASMCount.length; j++)
				{Util.writeFile(instructionBigramNDISASMCount[j] +",", output_filename, true);}
			   	
				 //get count of each NDISASMDisassemblyInstructionTrigram in NDISASM disassembly 
			    float[] instructionTrigramNDISASMCount = null;
				try {
					instructionTrigramNDISASMCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionTrigramsTF(featureTextNDISASMDisassembly, disassemblyNDISASMTrigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<instructionTrigramNDISASMCount.length; j++)
				{Util.writeFile(instructionTrigramNDISASMCount[j] +",", output_filename, true);}
			   	
				 //get count of each NDISASMDisassemblyLineBigrams in NDISASM disassembly 
			    float[] lineBigramNDISASMCount = null;
				try {
					lineBigramNDISASMCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyLineBigramsTF(featureTextNDISASMDisassembly, disassemblyNDISASMLineBigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<lineBigramNDISASMCount.length; j++)
				{Util.writeFile(lineBigramNDISASMCount[j] +",", output_filename, true);}	
			    // NDISASM FEATURES END - DISASSEMBLY - Related files: (1842485_1486492_a9108.dis)
			    	

		    	// Related files:
		      	// DECOMPILED CODE AKA SCAA FEATURES START (FROM HEXRAYS)
		    	// 1842485_1486492_a9108_hexrays_decompiled.cpp
				String featureTextHexraysDecompiledCodeCPP = null;
				try {
					featureTextHexraysDecompiledCodeCPP = Util.readFile(authorFileName.getParentFile()
					+ File.separator + authorFileName.getName()+"_hexrays_decompiled.cpp");
				} catch (IOException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				}
			    // 1842485_1486492_a9108_hexrays_decompiled.ast
				try {
					String featureTextHexraysDecompiledCodeAST = Util.readFile(authorFileName.getParentFile()
							+ File.separator + authorFileName.getName()+"_hexrays_decompiled.ast");
				} catch (IOException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			   	// 1842485_1486492_a9108_hexrays_decompiled.dep
				String featureTextHexraysDecompiledCodeDEP = null;
				try {
					featureTextHexraysDecompiledCodeDEP = Util.readFile(authorFileName.getParentFile()
							+ File.separator + authorFileName.getName()+"_hexrays_decompiled.dep");
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			   	// 1842485_1486492_a9108_hexrays_decompiled.txt
				try {
					String featureTextHexraysDecompiledCodeTXT = Util.readFile(authorFileName.getParentFile()
							+ File.separator + authorFileName.getName()+"_hexrays_decompiled.txt");
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			    	
				
			    //get count of each wordUnigram in C source file	 
			    float[] wordUniCountCPP = FeatureExtractorDecompiledCode.getWordUnigramsDecompiledCodeTF(featureTextHexraysDecompiledCodeCPP, wordUnigramsCPP);
			    for (int j=0; j<wordUniCountCPP.length; j++)
				{Util.writeFile(wordUniCountCPP[j] +",", output_filename, true);}	
				
			    //AST node bigrams
				float[] bigramCount = null;
				try {
					bigramCount = BigramExtractor.getASTNodeBigramsTF(featureTextHexraysDecompiledCodeDEP, ASTNodeBigrams );
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int j=0; j<ASTNodeBigrams.length; j++)
				{Util.writeFile(bigramCount[j] +",", output_filename, true);}	    
				    
				
			    //get count of each ASTtype not-DepAST type present	 
			    float[] typeCount = FeatureCalculators.DepASTTypeTF(featureTextHexraysDecompiledCodeDEP, ASTtypes );
			    for (int j=0; j<ASTtypes.length; j++)
				{Util.writeFile(typeCount[j] +",", output_filename, true);}	
			    
				//get tfidf of each AST Type present	 
			    float[] DepastTypeTFIDF = null;
				try {
					DepastTypeTFIDF = FeatureCalculators.DepASTTypeTFIDF(featureTextHexraysDecompiledCodeDEP, test_dir, ASTtypes);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<ASTtypes.length; j++)
				{Util.writeFile(DepastTypeTFIDF[j]+",", output_filename, true);}	
				
			    //get AST node avg depth
		    	float[] depFeature = null;
				try {
					depFeature = DepthASTNode.getAvgDepthASTNode(featureTextHexraysDecompiledCodeDEP,ASTtypes);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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