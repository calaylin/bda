import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;


public class MixedDatasetCreator_forbinaries 
{

		public static void copyAuthorsWithExactFileNumber(String test_cpp_dir,String destFolder, int fileCount, String filetype){
		File destFolderParent = new File(destFolder) ;
	  	if(!destFolderParent.exists())
    	{
	  		destFolderParent.mkdirs();
		}
		
	   File file = new File(test_cpp_dir);
	   
	   String[] directories = file.list(new FilenameFilter() 
	   {
	     @Override
	     public boolean accept(File current, String name) 
	     {
	       return new File(current, name).isDirectory();
	     }
	   });
	   System.out.println(Arrays.toString(directories));
	   
	   
	   for(int j=0; j< directories.length; j++)

	    {
		   String author_cpp_dir = test_cpp_dir + directories[j] +"/";
		   List test_file_paths = null;

		   if(filetype.equals("cpp")){
		    test_file_paths = Util.listCPPFiles(author_cpp_dir);}
		   
		   if(filetype.equals("c")){
			  test_file_paths = Util.listCFiles(author_cpp_dir);}
		
		for(int i=0; i< test_file_paths.size(); i++)
		   {   
		   String[] authors = destFolderParent.list(new FilenameFilter() 
		   {
		     @Override
		     public boolean accept(File current, String name) 
		     {
		       return new File(current, name).isDirectory();
		     }
		   });
		   System.out.println(authors.length);
			 	
		   // Use this if you want to have a specific number of authors in the folder		 	
			   if(test_file_paths.size() == fileCount && authors.length < 10000000)
			   {
				   System.out.println(author_cpp_dir);

				   String filePath = test_file_paths.get(i).toString();
				   //one empty file in each folder, skip that
				   System.out.println(filePath);  
				   
				   File srcFolder = new File(author_cpp_dir); 
			      	File destFolder1 = new File(destFolderParent +"/"+ directories[j].toString()) ;
			    	if(!destFolder1.exists())
			    	{
						///System.out.println(file.getAbsolutePath());
			    		destFolder1.mkdirs();
					}
			    	//make sure source exists
			    	if(!srcFolder.exists())
			    	{
			           System.out.println("Directory does not exist.");
			           //just exit
			           System.exit(0);
			        }else
			        {
			 
			           try{			      
			        	Util.copyFolder(srcFolder,destFolder1);
			           }catch(IOException e)
			           {
			        	e.printStackTrace();
			        	//error, just exit
			                System.exit(0);
			           }
			        }
			   }   
		   }	   
	    }
	}

		public static void SplitDatasetInto2Easy(String testFolder){
		    

/*			
			String cppFileName=null;
		        List test_cpp_paths = Util.listCPPFiles(testFolder); //use this for preprocessing       
		 
		     File cpp_file=null;
		        for(int i=0; i< test_cpp_paths.size(); i++){
		        	cpp_file = new File(test_cpp_paths.get(i).toString());
			        
*/		        
        	File author = new File(testFolder);
		    String[] directories = author.list(new FilenameFilter() 
				   {
				     @Override
				     public boolean accept(File current, String name) 
				     {
				       return new File(current, name).isDirectory();
				     }
				   });  
		    
		        for (int i =0; i< directories.length; i++)
				   {
					   //authorname is directoryname - 1 because Andrew put an extra 0 at the end of the authorname
					   String authorName = directories[i].toString().substring(0, directories[i].toString().length()-1); 
					   String authorDir = testFolder + directories[i] + "/";
					   List test_cpp_paths = Util.listCPPFiles(authorDir); //use this for preprocessing 
					   File cpp_file=null;
				        for(int j=(test_cpp_paths.size()/2); j< test_cpp_paths.size(); j++){
				        	cpp_file = new File(test_cpp_paths.get(j).toString());
				        	System.out.println(cpp_file.getName());
				        	File txt = new File (cpp_file.getAbsolutePath().toString().substring(0, cpp_file.getAbsolutePath().toString().length()-3)+"txt");
				        	File dep = new File (cpp_file.getAbsolutePath().toString().substring(0, cpp_file.getAbsolutePath().toString().length()-3)+"dep");
				        	File ast = new File (cpp_file.getAbsolutePath().toString().substring(0, cpp_file.getAbsolutePath().toString().length()-3)+"ast");
				        	txt.delete();
				        	dep.delete();
				        	ast.delete();
				        	cpp_file.delete();
				        	}
				   }

		}
		
		public static int AvgLineOfCodePerFile(String folder) throws IOException{
/*			
		  	File author = new File(folder);
		    String[] directories = author.list(new FilenameFilter() 
				   {
				     @Override
				     public boolean accept(File current, String name) 
				     {
				       return new File(current, name).isDirectory();
				     }
				   });
		    int authorCount=directories.length;*/
			
			   List test_cpp_paths = Util.listCPPFiles(folder); //use this for preprocessing 
			   int numberFiles=test_cpp_paths.size();
			   int totalLines=0;
			   int avgLines=0;
			   for(int j=0; j< (test_cpp_paths.size()); j++){
		        	
				   FileReader fr=new FileReader(test_cpp_paths.get(j).toString());
				   BufferedReader br=new BufferedReader(fr); 
				   int i=0;
				   boolean isEOF=false;
				   do{
				   String t=br.readLine();
				   if(t!=null){
				   isEOF=true;
				   t=t.replaceAll("\\n|\\t|\\s", "");
				   if((!t.equals("")) && (!t.startsWith("//"))) {
				   i = i + 1;
				   }
				   }
				   else {
				   isEOF=false;
				   }
				   }while(isEOF);
				   br.close();
				   fr.close();
				   totalLines=totalLines+i;
			   }  
			   
			   avgLines=totalLines/numberFiles;
			   
			   
			   
			return avgLines; 
			
		}
					   			     	
		public static void mix2Datasets(String firstFolder, String secondFolder, String destFolder, 
				int fromFirst,String firstType, int fromSecond, String secondType, int auxFiles){
			
			File destFolderParent = new File(destFolder) ;
		  	if(!destFolderParent.exists())
	    	{
		  		destFolderParent.mkdirs();
			}
			
		   File file = new File(firstFolder);
		   
		   String[] directories = file.list(new FilenameFilter() 
		   {
		     @Override
		     public boolean accept(File current, String name) 
		     {
		       return new File(current, name).isDirectory();
		     }
		   });
		   System.out.println(Arrays.toString(directories));
		   
		   
		   for(int j=0; j< directories.length; j++)

		    {
			   String author_cpp_dir = firstFolder + directories[j] +"/";
			   List test_file_paths = null;

			   if(firstType.equals("cpp")){
			    test_file_paths = Util.listCPPFiles(author_cpp_dir);}
			   
			   if(firstType.equals("c")){
				  test_file_paths = Util.listCFiles(author_cpp_dir);}
			
			for(int i=0; i< test_file_paths.size(); i++)
			   {   
			   String[] authors = destFolderParent.list(new FilenameFilter() 
			   {
			     @Override
			     public boolean accept(File current, String name) 
			     {
			       return new File(current, name).isDirectory();
			     }
			   });
			   System.out.println(authors.length);
				 	

					   System.out.println(author_cpp_dir);

					   String filePath = test_file_paths.get(i).toString();
					   //one empty file in each folder, skip that
					   System.out.println(filePath);  
					   
					   File srcFolder = new File(author_cpp_dir); 
				      	File destFolder1 = new File(destFolderParent +"/"+ directories[j].toString()) ;
				    	if(!destFolder1.exists())
				    	{
							///System.out.println(file.getAbsolutePath());
				    		destFolder1.mkdirs();
						}
				    	//make sure source exists
				    	if(!srcFolder.exists())
				    	{
				           System.out.println("Directory does not exist.");
				           //just exit
				           System.exit(0);
			   }else
		        {
		 
		           try{			      
		        	   List allFiles =  Util.listAllFiles(author_cpp_dir);
		        	   for(int k = 0; k< fromFirst * (auxFiles+1); k++){
						File source=new File(allFiles.get(k).toString());
						
						File target=new File(destFolderParent +"/"+ directories[j].toString()+
								"/"+source.getName());
						CopyOption[] options = new CopyOption[]{
							      StandardCopyOption.REPLACE_EXISTING}; 
						Files.copy(source.toPath(), target.toPath(), options);

		        	   }
		           }catch(IOException e)
		           {
		        	e.printStackTrace();
		        	//error, just exit
		                System.exit(0);
		           }
		        }
		   }   
	   }	
			
		   File destFolderParent1 = new File(destFolder) ;
		  	if(!destFolderParent1.exists())
	    	{
		  		destFolderParent1.mkdirs();
			}
			
		   File file1 = new File(secondFolder);
		   
		   String[] directories2 = file1.list(new FilenameFilter() 
		   {
		     @Override
		     public boolean accept(File current, String name) 
		     {
		       return new File(current, name).isDirectory();
		     }
		   });
		   System.out.println(Arrays.toString(directories2));
		   
		   
		   for(int j=0; j< directories2.length; j++)

		    {
			   String author_cpp_dir = secondFolder + directories2[j] +"/";
			   List test_file_paths = null;

			   if(secondType.equals("cpp")){
			    test_file_paths = Util.listCPPFiles(author_cpp_dir);}
			   
			   if(secondType.equals("c")){
				  test_file_paths = Util.listCFiles(author_cpp_dir);}
			
			for(int i=0; i< test_file_paths.size(); i++)
			   {   			   

			   String[] authors = destFolderParent1.list(new FilenameFilter() 
			   {
			     @Override
			     public boolean accept(File current, String name) 
			     {
			       return new File(current, name).isDirectory();
			     }
			   });
			   System.out.println(authors.length);
				 	

					   System.out.println(author_cpp_dir);

					   String filePath = test_file_paths.get(i).toString();
					   //one empty file in each folder, skip that
					   System.out.println(filePath);  
					   
					   File srcFolder = new File(author_cpp_dir); 
				      	File destFolder1 = new File(destFolderParent1 +"/"+ directories2[j].toString()) ;
				    	if(!destFolder1.exists())
				    	{
							///System.out.println(file.getAbsolutePath());
				    		destFolder1.mkdirs();
						}
				    	//make sure source exists
				    	if(!srcFolder.exists())
				    	{
				           System.out.println("Directory does not exist.");
				           //just exit
				           System.exit(0);
			   }else
		        {
		 
		           try{			      
		        	   List allFiles =  Util.listAllFiles(author_cpp_dir);
		        	   for(int k = (fromSecond* (auxFiles+1)); k< (fromFirst+fromSecond) * (auxFiles+1); k++){
						File source=new File(allFiles.get(k).toString());
						
						File target=new File(destFolderParent1 +"/"+ directories2[j].toString()+
								"/"+source.getName());
						CopyOption[] options = new CopyOption[]{
							      StandardCopyOption.REPLACE_EXISTING}; 
						Files.copy(source.toPath(), target.toPath(), options);
						Files.copy(source.toPath(), target.toPath(),options);

		        	   }
		           }catch(IOException e)
		           {
		        	e.printStackTrace();
		        	//error, just exit
		                System.exit(0);
		           }
		        }
		   }   
	   }	
			
			
		}
			
				   
		
		public static void main(String[] args) throws Exception, IOException, InterruptedException 
		{
		String destFolder="/Users/Aylin/Desktop/Princeton/BAA/"
				+ "datasets/c++/14FilesPerAuthor_2014_decompiledC_and_original3/";	
		String destFolder2="/Users/Aylin/Desktop/Princeton/BAA/"
				+ "datasets/c++/14FilesPerAuthor_2014_decompiledC_and_original4/";	
		String firstFolder = "/Users/Aylin/Desktop/Princeton/BAA/"
				+ "datasets/c++/14FilesPerAuthor_2014_decompiledC_and_original2/";	
		String secondFolder = "/Users/Aylin/Desktop/Princeton/BAA/"
				+ "datasets/c++/14FilesPerAuthor_2014/";	
		int fileCount = 14;
		
	    mix2Datasets( firstFolder,  secondFolder,  destFolder, 
				 7, "c",  7,  "cpp",  3);
	
		copyAuthorsWithExactFileNumber(  destFolder,destFolder2, 7, "c");


		}
}
