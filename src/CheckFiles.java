

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import weka.core.Instances;


public class CheckFiles {
	
    public static void main(String[] args) throws Exception, IOException, InterruptedException {

    String testFolder="/Users/Aylin/Desktop/Princeton/BAA/datasets/c++/14FilesPerAuthor_2014_linux32/";



	String testFolder_compiled ="/Users/Aylin/Desktop/Princeton/BAA/datasets/"
        			+ "c++/9Files_largescale_CPP_and_binary_NOToptimized_hexrays/";
	
//addBinaryToFolderByCodeName (String dirToAddBinaries, String dirToLookForBinaries) throws IOException{
	String dirToAddBinaries ="/Users/Aylin/Desktop/Princeton/"
			+ "BAA/datasets/c++/100authors_hexraysDecompiled_noOptimization/";
	
	String dirToLookForBinaries ="/Users/Aylin/Desktop/Princeton/"
			+ "BAA/datasets/c++/9Files_largescale_CPP_and_binary_NOToptimized/";
	
	//addBinaryToFolderByCodeName(dirToAddBinaries,dirToLookForBinaries);
	//this won't recognize binaries, so convert to c first
    //to add .c to decompiled filenames
//	addDotCToDecompiledFileName(testFolder_compiled);

	//rearrangeFolders(testFolder_compiled);

	
	//to clean files produced by joern
	String cleanFolder="/Users/Aylin/Desktop/Princeton/BAA/datasets/"
			+ "c++/featureTransformations/9files_50authors_snowmanDecompiledOptimizationLevel1/";
	
	String arffFile1 = "/Users/Aylin/Desktop/Princeton/BAA/arffs/"
			+ "C_62Authors14files_decompiledfrom2C++.arff/";
	
	//cleanNonCPPFromFolder(cleanFolder);
	checkFolderSizeAndDelete("/Users/Aylin/Desktop/Princeton/BAA/datasets/c++/"
			+ "featureTransformations/featureAnalysisOriginalCode/"
			,36);
	//to change a particular feature (authorname)
//	fixArffFeature(arffFile1);
	
/*	   String depFileName=null;
       List test_cpp_paths = Util.listCPPFiles(testFolder); //use this for preprocessing
       List test_all_paths = Util.listAllFilesFolders(testFolder); //use this for preprocessing 
       List test_c_paths = Util.listCFiles(testFolder_compiled); //use this for preprocessing
       System.out.println(test_cpp_paths.size());
       System.out.println(test_all_paths.size());
       System.out.println(test_c_paths.size());
 */

	String fromFileName = "";
	String toFileName = ".c";
	String foldername ="/Users/Aylin/Desktop/Princeton/BAA/datasets/"
			+ "c++/9Files_largescale_onlydecompiled/";
	//changeFileType( fromFileName,  toFileName,  foldername, false);


    }
	
	
	public static void rearrangeFolders(String testFolder_compiled) throws IOException
	{
   //add .c to each filename
		//if the file is a binary, it won't recognize it as a file
	List test_file_paths = Util.listAllFilesFolders(testFolder_compiled); //use this for preprocessing 
	
    for(int k=0; k< test_file_paths.size(); k++){
			System.out.println(test_file_paths.get(k).toString() + " "+k);


    	
				File testFiles = new File(test_file_paths.get(k).toString());
				File[] children = testFiles.listFiles();
					if(children==null)
					{
/*					 if(test_file_paths.get(k).toString().
							 substring(0,test_file_paths.get(k).toString().length()-2).contains(".c")){*/
						 File firstParent = new File(testFiles.getParent());
						 File toMove = new File(firstParent.getParent());
						 System.out.println("to move path: "+toMove.getPath());
						System.out.println("moved to1: "+toMove.getPath() + "/" + testFiles.getName() );

						testFiles.renameTo(new File(toMove.getPath() + "/" + testFiles.getName() ));
						 System.out.println("moved to2: "+ testFiles.getPath());
					//	 testFiles.delete();
						 firstParent.delete();	
					}

			}
					
    }	
	
	public static void changeFileType(String fromFileName, String toFileName, String foldername, boolean noteChange){
		
		List test_file_paths = Util.listAllFilesFolders(foldername); //use this for preprocessing 
		for(int i =0; i<test_file_paths.size(); i++)
		{
			File test = new File(test_file_paths.get(i).toString());
			if(test.getName().contains(fromFileName) && (!test.isDirectory())){
				if(noteChange == true){
					test.renameTo(new File(test.getParentFile().getPath()+"/"+
							test.getName().substring(0, test.getName().length() - fromFileName.length())+
							"_FILETYPECHANGED_"			+				toFileName));
				}
				else{
			test.renameTo(new File(test.getParentFile().getPath()+"/"+
			test.getName().substring(0, test.getName().length() - fromFileName.length())+
			toFileName));}}
			
		}

		
		
		
	}
	public static void addDotCToDecompiledFileName(String testFolder_compiled) throws IOException
	{
   //add .c to each filename
	List test_file_paths = Util.listAllFilesFolders(testFolder_compiled); //use this for preprocessing 
	
    for(int k=0; k< test_file_paths.size(); k++){
			System.out.println(test_file_paths.get(k).toString() + " "+k);


    	
				File testFiles = new File(test_file_paths.get(k).toString());
				File[] children = testFiles.listFiles();
					if(children==null)
					{
					 if(!test_file_paths.get(k).toString().contains(".DS_Store")){
			  				File newFile = new File(test_file_paths.get(k).toString() + ".c");
			  				System.out.println(newFile.getPath());
						testFiles.renameTo(newFile);
  				System.out.println("newCfile");

				if(!newFile.exists()) {
					
					newFile.createNewFile();
					}


  				testFiles.delete();

					
					
					}

			}
					}
    }
	
	
    
public static void cleanNonCodeFromFolder(String cleanFolder){
	List test_c_files = Util.listCFiles(cleanFolder);
	for(int i=0; i< test_c_files.size(); i++){
       	
		File c_file = new File(test_c_files.get(i).toString());
	
       	//check if there are correct number of dep files for each author
       	 List test_dep_paths = Util.listDepFiles(c_file.getParent());

       	int fileNo=14;
    	//check if there are correct number of dep files for each author
    	 if(test_dep_paths.size()<fileNo){
   // 	System.out.println(test_dep_paths.size()+" dep files "+c_file.getParent());
    	
    	File cfiletoDelete = new File(c_file.getPath().toString());
    	cfiletoDelete.delete();    	
    	File filetoDelete = new File(c_file.getParentFile().getPath().toString());
    	System.out.println(filetoDelete);
    	File file2toDelete = new File(filetoDelete.getParent().toString());
    	System.out.println(file2toDelete);

    	
    	filetoDelete.delete();
    	file2toDelete.delete();
    	File file3toDelete = new File(file2toDelete.getParent().toString());
    	System.out.println(file3toDelete);

    
        }}}


public static void cleanNonCPPFromFolder(String cleanFolder){
	List test_cpp_files = Util.listAllFilesFolders(cleanFolder);
	for(int i=0; i< test_cpp_files.size(); i++){
		String fileName = test_cpp_files.get(i).toString();
		File nonCppFile = new File(fileName);
		if(!nonCppFile.isDirectory()){
//		if(!(FilenameUtils.getExtension(fileName).equals("cpp"))){
			if(!(fileName.contains("SnowmanDecompiled.cpp"))){

			nonCppFile.delete();    	
		}
		}
			
		}
		}
   

    	
    	 
	public static void addBinaryToFolderByCodeName (String dirToAddBinaries, String dirToLookForBinaries) throws IOException{
		
		List cFiles = Util.listCFiles(dirToAddBinaries);
		List cppFiles = Util.listCPPFiles(dirToAddBinaries);
		
		if (cFiles.size() > cppFiles.size()){
			
			for (int i=0; i< cFiles.size(); i++){
				File cFileName = new File(cFiles.get(i).toString());
				
				String binaryFileName = cFileName.getName().substring(0, cFileName.getName().length()-2);
				String binaryAuthor = new File(cFileName.getParent()).getName().toString();
				//copy
				System.out.println(dirToLookForBinaries + File.separator+ 
						  binaryAuthor + File.separator + binaryFileName);
				System.out.println(dirToAddBinaries+ File.separator+ 
						  binaryAuthor + File.separator + binaryFileName);
				  Files.copy(new File(dirToLookForBinaries + File.separator+ 
						  binaryAuthor + File.separator + binaryFileName).toPath(),
					        new File(dirToAddBinaries+ File.separator+ 
									  binaryAuthor + File.separator + binaryFileName).toPath(),
					        StandardCopyOption.REPLACE_EXISTING);				
			}
		}
		
		if (cFiles.size() < cppFiles.size()){
			
			for (int i=0; i< cppFiles.size(); i++){
				File cppFileName = new File(cppFiles.get(i).toString());
				
				String binaryFileName = cppFileName.getName().substring(0, cppFileName.getName().length()-4);
				String binaryAuthor = new File(cppFileName.getParent()).getName().toString();
				//copy
				  Files.copy(new File(dirToLookForBinaries + File.separator+ 
						  binaryAuthor + File.separator + binaryFileName).toPath(),
					        new File(dirToAddBinaries+ File.separator+ 
									  binaryAuthor + File.separator + binaryFileName).toPath(),
					        StandardCopyOption.REPLACE_EXISTING);				
			}
		}

		
	}
	public static void fixArffFeature (String arffFile) throws IOException{
		
    	String featureText = Util.readFile( arffFile);
    	//start 79756
    	//end
	   Instances data = new Instances(new FileReader(arffFile));
	 	data.setClassIndex(data.numAttributes() - 1);
    	for(int i= 79757; i <80156; i++){
    //	System.out.println(DepthASTNode.readLineNumber(featureText, 80154));
    		System.out.println(i);
			//get from weka, much faster
		String instID = data.instance(i-79757).attribute(0).toString();
				
		//		MergeArffFiles.getInstanceID(arffFile, i);

		String instVector = data.instance(i-79757).toString();
	//	String instVector = MergeArffFiles.getInstance(arffFile, i);

		
		String authorName = instID;
		
		//authorName = authorName.replace(replacement, authorName);
		authorName = authorName.substring(25,authorName.length()-2);

		//System.out.print(instVector);

		System.out.println(authorName);

		  String newVector = instVector +","+ authorName +"\n";
		//	System.out.println(newVector);
			Util.writeFile(newVector, "/Users/Aylin/Desktop/Princeton/BAA/arffs/"
					+ "C_62Authors14files_decompiledNEW.arff/", true);}

/*		  try {
		        // input the file content to the String "input"
		        BufferedReader file = new BufferedReader(new FileReader(arffFile));
		        String line;String input = "";
		        int lineNo=0;
		        while ((line = file.readLine()) != null) input += line + '\n';
		        
		        file.close();

		        System.out.println(input); // check that it's inputted right

		        // this if structure determines whether or not to replace "0" or "1"
		            CharSequence target = instID;
					CharSequence replacement = instID + instID;
					input = input.replace(target, replacement); 
		    

		        // write the new String with the replaced line OVER the same file
		        FileOutputStream fileOut = new FileOutputStream(arffFile +"auth");
		        fileOut.write(input.getBytes());
		        fileOut.close();
		        lineNo
		        
		  
	   } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }*/

	
	
	
	
}
	
	public static void checkFolderSizeAndDelete(String parentDir, int noFiles) throws IOException{
		
		File file = new File(parentDir);
		String[] names = file.list();

		for(String name : names)
		{
		    if (new File(parentDir + name).isDirectory())
		    {
		       File author = new File(parentDir+name);
		       String[] files = author.list();
		       if (files.length < noFiles)
		       {
		    	   FileUtils.deleteDirectory(new File(parentDir+name));
		       }
		       
		    }
		}
		
	}
}
