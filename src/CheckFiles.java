

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

 String file = "/mnt/data_bsd/arffs/repos_incomplete.arff";
// deleteLastLineFromIncompleteArff(file);
//addBinaryToFolderByCodeName (String dirToAddBinaries, String dirToLookForBinaries) throws IOException{

	
	String dirToAddBinaries= "/Users/Aylin/Desktop/Princeton/BAA/datasets/c++/1046NotOptimized/";
	String dirToLookForBinaries="/Users/Aylin/Desktop/Princeton/BAA/datasets/c++/9Files_largescale_CPP_and_binary_NOToptimized/";
	
//	addBinaryToFolderByCodeName(dirToAddBinaries,dirToLookForBinaries);
	
/*	addBinaryToFolderByCodeName("/Users/Aylin/Desktop/Princeton/BAA/datasets/c++/optimizations/L1_150authors/"
,"/Users/Aylin/Desktop/Princeton/BAA/datasets/c++/9Files_largescale_onlyCPP_and_binary_Optimization1/");
*/	//this won't recognize binaries, so convert to c first
    //to add .c to decompiled filenames
	
//	addDotCPPToDecompiledFileName("/Users/Aylin/Desktop/Princeton/BAA/datasets/c++/optimizations/L1_150authors/");
//	rearrangeFolders("/Users/Aylin/Desktop/Princeton/BAA/datasets/c++/optimizations/L1_150authors/");

	
	//to clean files produced by joern
	String cleanFolder="/Users/Aylin/Desktop/Princeton/BAA/datasets/dataset-20151012_9files/repos/";
	String targetDirPath = "/Users/Aylin/Desktop/Princeton/BAA/datasets/dataset-20151012_9files/";
	//copyDataWithCertainSizeCPP(cleanFolder, 9,targetDirPath );
//	changeClassAttribute("/Users/Aylin/Desktop/Princeton/BAA/arffs/100authors/"+ "originalVSLO_100programmers_9filesALL.arff");

	
	//cleanNonCPPFromFolder(cleanFolder);
	checkFolderSizeAndDelete("/Users/Aylin/Desktop/Princeton/BAA/datasets/"
			+ "c++/optimizations/L0_150authors/",54);

	
	/*    List test_all_paths = Util.listAllFilesFolders("/mnt/data_bsd/200NoOptimization_binaries_bjoern_cfg"); //use this for preprocessing 
for(int i=0; i< test_all_paths.size(); i++){
	if(test_all_paths.get(i).toString().contains(".ast_SnowmanDecompiled.dot"))
	{File newd = new File(test_all_paths.get(i).toString());
	newd.delete();
	}
	if(test_all_paths.get(i).toString().contains(".dep_SnowmanDecompiled.dot"))
	{File newd = new File(test_all_paths.get(i).toString());
	newd.delete();
	}	if(test_all_paths.get(i).toString().contains(".txt_SnowmanDecompiled.dot"))
	{File newd = new File(test_all_paths.get(i).toString());
	newd.delete();
	}
}*/
	
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

	String fromFileName = ".cc";
	String toFileName = ".cpp";
	String foldername ="/Users/Aylin/Desktop/Princeton/BAA/"
			+ "datasets/c++/100authors_noOptimization/";
	//changeFileType( fromFileName,  toFileName,  foldername, false);
	//removeIncludeH(foldername);
	//cleanNonBinaryFromFolder(foldername);



    }
	
    public static void removeIncludeH(String folderName) throws IOException{
	List test_file_paths = Util.listAllFiles(folderName); //use this for preprocessing       
	for(int i=0; i< test_file_paths.size(); i++)
	{
		    	 File inputFile = new File(test_file_paths.get(i).toString());
		    	 if(!inputFile.isDirectory())
		    	 {
		         File tempFile = new File(test_file_paths.get(i).toString() + "TMP");
		         
		         BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		         String currentLine;

		         while((currentLine = reader.readLine()) != null) 
		         {
		             if(null!=currentLine && !currentLine.contains("#include")  )
		             {
		                 writer.write(currentLine + System.getProperty("line.separator"));
		             }
		         }
		         writer.close(); 
		         reader.close(); 
		         boolean successful = tempFile.renameTo(inputFile);
		         System.out.println(successful);
		         System.out.println(inputFile);
		    	 }
		    }
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
	public static void addDotCPPToDecompiledFileName(String testFolder_compiled) throws IOException
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
			  				File newFile = new File(test_file_paths.get(k).toString() + "_hexrays_decompiled.cpp");
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


public static void cleanNonBinaryFromFolder(String cleanFolder){
	List test_cpp_files = Util.listAllFilesFolders(cleanFolder);
	for(int i=0; i< test_cpp_files.size(); i++){
		String fileName = test_cpp_files.get(i).toString();
		File nonCppFile = new File(fileName);
		if(!nonCppFile.isDirectory()){
			String ext = FilenameUtils.getExtension(fileName);
    		if (!ext.isEmpty()){		

			nonCppFile.delete();    	
		}
		}
			
		}
		}

public static void cleanGivenNamedFiles (String dir, String fileContains){
	
	List test_all_files = Util.listAllFilesFolders(dir);
	for(int i=0; i< test_all_files.size(); i++){
		String fileName = test_all_files.get(i).toString();
		File nonCppFile = new File(fileName);
		if(!nonCppFile.isDirectory()){
//		if(!(FilenameUtils.getExtension(fileName).equals("cpp"))){
				if(nonCppFile.getName().contains(fileContains))
					{

			nonCppFile.delete();    	
		}}
		}
			
	
	
}
public static void cleanNonCPPandBinaryFromFolder(String cleanFolder){
	List test_cpp_files = Util.listAllFilesFolders(cleanFolder);
	for(int i=0; i< test_cpp_files.size(); i++){
		String fileName = test_cpp_files.get(i).toString();
		File nonCppFile = new File(fileName);
		if(!nonCppFile.isDirectory()){
//		if(!(FilenameUtils.getExtension(fileName).equals("cpp"))){
				if(!(FilenameUtils.getExtension(FilenameUtils.getName(fileName)).isEmpty()))
					{

			nonCppFile.delete();    	
		}}
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
				
				String binaryFileName = cppFileName.getName().substring(0, cppFileName.getName().length()-23);
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
	
	
	public static void copyDataWithCertainSizeCPP(String parentDir, int noFiles, String targetDirPath) throws IOException{
		
		File file = new File(parentDir);
		String[] names = file.list();

		for(String name : names)
		{
		    if (new File(parentDir + name).isDirectory())
		    {
		       List files = Util.listCPPFiles(parentDir+name+File.separator);
		       if (files.size() >= noFiles)
		       {
		    	   File dir = new File(targetDirPath+ name + File.separator);
		    	   dir.mkdir();
		    	   
		    	   for(int i=0; i < noFiles; i++){

		    	   File toCopy =new File(files.get(i).toString());
		    	
		   			System.out.println(targetDirPath+ name + File.separator+ toCopy.getName().toString());

		    	   toCopy.renameTo(new File(targetDirPath+ name + File.separator+ toCopy.getName()));
/*		    	   File toCopyAST =new File(files.get(i).toString().
		    			   substring(0, files.get(i).toString().length()-3)+"ast");
		    	   File toCopyDEP =new File(files.get(i).toString().
		    			   substring(0, files.get(i).toString().length()-3)+"dep");
		    	   File toCopyTXT =new File(files.get(i).toString().
		    			   substring(0, files.get(i).toString().length()-3)+"txt");

		    	   toCopyAST.renameTo(new File(targetDirPath+ name + File.separator+ toCopyAST.getName()));
		    	   toCopyDEP.renameTo(new File(targetDirPath+ name + File.separator+ toCopyDEP.getName()));
		    	   toCopyTXT.renameTo(new File(targetDirPath+ name + File.separator+ toCopyTXT.getName()));
*/
		    	   }
		       }
		       
		    }
		}
		
	}
	
	public static void changeClassAttribute(String arffFile) throws FileNotFoundException, IOException{
		
	
		BufferedReader br = new BufferedReader(new FileReader(arffFile));
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if (line.length()>70){
		    	if(line.substring(0, 70).contains("hexrays") && 
		    			(!(line.contains("@attribute")))){
		    		line=line + "_hexrays";
			    	Util.writeFile(line +"\n", arffFile + "classesRenamed", true );}
		    	else
			    	Util.writeFile(line +"\n", arffFile + "classesRenamed", true );
		    	}
		    	if (line.length()<=70){
		    	Util.writeFile(line +"\n", arffFile + "classesRenamed", true );}

		    	}
			br.close();
	}
	
	public static void deleteLastLineFromIncompleteArff(String arffFile) throws IOException{
		RandomAccessFile file = new RandomAccessFile(arffFile, "rw");
		long len = file.length()-1;
		byte by;
		do{
			len -= 1;
			file.seek(len);
			 by = file.readByte();
		}
		while(by!=10);
		file.setLength(len+1);
		file.close();
	}
}
