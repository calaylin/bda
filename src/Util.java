import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

/**
 * Util has necessary functions for file processing.
 * @author Aylin Caliskan-Islam (ac993@drexel.edu)
 */

public class Util {
	

	public static void writeFile(List<String> allLines,String fileName, boolean append)
	{
		File aFile = new File(fileName);
		FileWriter aFileWriter;
		try {
		 	    if(aFile.exists() == false)
		 	    		aFile.createNewFile();
				
				aFileWriter = new FileWriter(aFile, append); // Open in Append mode
				////aFileWriter.
				
				for(String aLine:allLines)
				{
					aFileWriter.write(aLine);
					//aFileWriter.w
				//	aFileWriter.write("\n");
					//System.out.println("write in sensor");
					
				}
				aFileWriter.close();
			 	   
			//	System.out.println("Writing done");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	   
	}
	
	public static void writeFile(String allLines,String fileName, boolean append)
	{
		File aFile = new File(fileName);
		FileWriter aFileWriter;
		try {
		 	    if(aFile.exists() == false)
		 	    		aFile.createNewFile();
				
				aFileWriter = new FileWriter(aFile, append); // Open in Append mode
				
				//for(String aLine:allLines)
				{
					aFileWriter.write(allLines);
				//	aFileWriter.write("\n");
					//System.out.println("write in sensor");
					
				}
				aFileWriter.close();
			 	   
				//System.out.println("Writing done");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	   
	}

	public static List<String> readFile(File file, boolean readAll) throws IOException
    {
    	List<String> allWords = new ArrayList<String>();
    		
        FileReader aFileReader;
		
		BufferedReader reader = null;
	    
		//File file = new File(txtFile);
 	    if(file.exists() == true)
			try {
				
				
				aFileReader = new FileReader(file); 
				reader = new BufferedReader(aFileReader);
				
				String dataLine = reader.readLine();
				
				while(dataLine!=null)
				{
					if(readAll)
						allWords.add(dataLine);
					else{
						if(!allWords.contains(dataLine))
						{
							
							allWords.add(dataLine);
						}
					}
					
					dataLine = reader.readLine();
					System.out.println(dataLine);
				}
				
				
				aFileReader.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
 	    	reader.close();
			return allWords;
    	
    }
    public static String readFile(String fileName) throws IOException {
    	
    	
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
    
    public static String readNDISASMFile(String fileName) throws IOException {
    	
    	//just looks at instructions
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            String[] arr;
            while (line != null) {
   				arr = line.split("\\s+",3);
   				if(arr.length>2){
   	   		//	System.out.println(arr[2]);
                sb.append(arr[2]);
                sb.append("\n");}
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
    
    
    
	public static void writeUTF8( String allLines, String filename,boolean append){
		 
		File file = new File(filename);
		
		try {
			if(!file.exists()){
				///System.out.println(file.getAbsolutePath());
				file.createNewFile();
			}
			
			 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF8"));
			 
			 if(append)
				 out.append(allLines);
			 else
				 out.write(allLines);
		     out.close();
		 //    System.out.println("writing done");
		 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
		 
	}
	
	public static List<String> readFileUTF8(File file, boolean readAll)
    {
    	List<String> allWords = new ArrayList<String>();
    		
		BufferedReader reader = null;
	    
 	    if(file.exists() == true)
			try {
				
				
				//aFileReader = new FileReader(file); 
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
				
				String dataLine = reader.readLine();
				
				while(dataLine!=null)
				{
					if(readAll)
						allWords.add(dataLine);
					else{
						if(!allWords.contains(dataLine))
						{
							
							allWords.add(dataLine);
						}
					}
					
					dataLine = reader.readLine();
					//System.out.println(allFunctionWords.size());
				}
				
				reader.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
			return allWords;
    	
    }

	public static String read(File file, boolean readAll)
    {
		BufferedReader reader = null;
	    String output = "";
		//File file = new File(txtFile);
 	    if(file.exists() == true)
			try {
				
				
				//aFileReader = new FileReader(file); 
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
				
				String dataLine = reader.readLine();
				
				while(dataLine!=null)
					output+= dataLine+"\n";
					
				dataLine = reader.readLine();
				
				reader.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
			return output;
    	
    }
    public static List <File> listTextFiles(String dirPath)
    {

        File topDir = new File(dirPath);

        List<File> directories = new ArrayList<>();
        directories.add(topDir);

        List<File> textFiles = new ArrayList<>();

        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*.txt");
        filterWildcards.add("*.doc");

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
    
    public static List <File> listAllFiles(String dirPath)
    {

        File topDir = new File(dirPath);

        List<File> directories = new ArrayList<>();
        directories.add(topDir);

        List<File> textFiles = new ArrayList<>();

        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*.*");

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
    
    public static List <File> listAllFilesFolders(String dirPath)
    {

        File topDir = new File(dirPath);

        List<File> directories = new ArrayList<>();
        directories.add(topDir);

        List<File> textFiles = new ArrayList<>();

        List<String> filterWildcards = new ArrayList<>();

        FileFilter typeFilter = new WildcardFileFilter(filterWildcards);

        while (directories.isEmpty() == false)
        {
            List<File> subDirectories = new ArrayList<File>();

            for(File f : directories)
            {
                subDirectories.addAll(Arrays.asList(f.listFiles((FileFilter)DirectoryFileFilter.INSTANCE)));
                textFiles.addAll(Arrays.asList(f.listFiles()));
            }

            directories.clear();
            directories.addAll(subDirectories);


        }
        Collections.sort(textFiles);
        return textFiles;

}
    public static List <File> listDotFiles(String dirPath)
    {

        File topDir = new File(dirPath);

        List<File> directories = new ArrayList<>();
        directories.add(topDir);

        List<File> textFiles = new ArrayList<>();

        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*.dot");


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
      
    public static List <File> listCPPFiles(String dirPath)
    {

        File topDir = new File(dirPath);

        List<File> directories = new ArrayList<>();
        directories.add(topDir);

        List<File> textFiles = new ArrayList<>();

        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*.cpp");
        filterWildcards.add("*.c++");
        filterWildcards.add("*.cc");


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
    
    public static List <File> listCFiles(String dirPath)
    {

        File topDir = new File(dirPath);

        List<File> directories = new ArrayList<>();
        directories.add(topDir);

        List<File> textFiles = new ArrayList<>();

        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*.c");


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
    
    public static List <File> listBinaryFiles(String dirPath){
    	
    	Collection files = FileUtils.listFiles(
    			new File(dirPath), 
    			  new RegexFileFilter("^(.*?)"), 
    			  DirectoryFileFilter.DIRECTORY
    			);
    	List list = new ArrayList(files);
    	Collections.sort(list);
    	for (int i=0; i< list.size(); i++){
    	
    		String ext = FilenameUtils.getExtension(list.get(i).toString());
    		if (!ext.isEmpty()){
    			list.remove(i);
    			i--;}
    	}

    	return list;
    	
    }
    public static List <File> listPythonFiles(String dirPath)
    {

        File topDir = new File(dirPath);

        List<File> directories = new ArrayList<>();
        directories.add(topDir);

        List<File> textFiles = new ArrayList<>();

        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*.py");


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

    public static List <File> listASTFiles(String dirPath)
    {

        File topDir = new File(dirPath);

        List<File> directories = new ArrayList<>();
        directories.add(topDir);

        List<File> textFiles = new ArrayList<>();

        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*.ast");

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
    
    public static List <File> listSnowmanDecompiled(String dirPath)
    {

        File topDir = new File(dirPath);

        List<File> directories = new ArrayList<>();
        directories.add(topDir);

        List<File> textFiles = new ArrayList<>();

        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*SnowmanDecompiled.cpp");

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
    
    public static List <File> listDepFiles(String dirPath)
    {

        File topDir = new File(dirPath);

        List<File> directories = new ArrayList<>();
        directories.add(topDir);

        List<File> textFiles = new ArrayList<>();

        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*.dep");

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
    public static List <File> listObjFiles(String dirPath)
    {

        File topDir = new File(dirPath);

        List<File> directories = new ArrayList<>();
        directories.add(topDir);

        List<File> textFiles = new ArrayList<>();

        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*.o");

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
    
    public static void copyFolder(File src, File dest)
        	throws IOException{
     
        	if(src.isDirectory()){
     
        		//if directory not exists, create it
        		if(!dest.exists()){
        		   dest.mkdir();
        		   System.out.println("Directory copied from " 
                                  + src + "  to " + dest);
        		}
     
        		//list all the directory contents
        		String files[] = src.list();
     
        		for (String file : files) {
        		   //construct the src and dest file structure
        		   File srcFile = new File(src, file);
        		   File destFile = new File(dest, file);
        		   //recursive copy
        		   copyFolder(srcFile,destFile);
        		}
     
        	}else{
        		//if file, then copy it
        		//Use bytes stream to support all file types
        		InputStream in = new FileInputStream(src);
        	        OutputStream out = new FileOutputStream(dest); 
     
        	        byte[] buffer = new byte[1024];
     
        	        int length;
        	        //copy the file content in bytes 
        	        while ((length = in.read(buffer)) > 0){
        	    	   out.write(buffer, 0, length);
        	        }
     
        	        in.close();
        	        out.close();
        	        System.out.println("File copied from " + src + " to " + dest);
        	}
        }
    


    	public static void AlphabeticallySortLinesOfTextInFile(String inputFile, String outputFile) throws IOException{


    		FileReader fileReader = new FileReader(inputFile);
    		BufferedReader bufferedReader = new BufferedReader(fileReader);
    		String inputLine;
    		List<String> lineList = new ArrayList<String>();
    		while ((inputLine = bufferedReader.readLine()) != null) {
    			lineList.add(inputLine);
    		}
    		fileReader.close();

    		Collections.sort(lineList);

    		FileWriter fileWriter = new FileWriter(outputFile);
    		PrintWriter out = new PrintWriter(fileWriter);
    		for (String outputLine : lineList) {
    			out.println(outputLine);
    		}
    		out.flush();
    		out.close();
    		fileWriter.close();

    	}
    	
    	// public static String readFile(String path, Charset encoding) 
    	public static String readFile2(String path)  throws IOException 
    			{
    		try {
    			File fin = new File(path);
    			FileInputStream fis = new FileInputStream(fin);
    			BufferedReader in = new BufferedReader(new
    			InputStreamReader(fis));
    			char[] chrArr = new char[(int)fin.length()];
    			while(in.ready()==false) {}
    			in.read(chrArr);
    			in.close();
    			return new String(chrArr);
    			}
    			catch (FileNotFoundException e) { return ""; }
    			catch (IOException e) { return ""; }
    			}

		public static List <File> listDisFiles(String dirPath)
		    {
		
		        File topDir = new File(dirPath);
		
		        List<File> directories = new ArrayList<>();
		        directories.add(topDir);
		
		        List<File> textFiles = new ArrayList<>();
		
		        List<String> filterWildcards = new ArrayList<>();
		        filterWildcards.add("*.dis");
		
		
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

		public static List <File> listCFGFiles(String dirPath)
		    {
		
		        File topDir = new File(dirPath);
		
		        List<File> directories = new ArrayList<>();
		        directories.add(topDir);
		
		        List<File> textFiles = new ArrayList<>();
		
		        List<String> filterWildcards = new ArrayList<>();
		        filterWildcards.add("*.cfg");
		
		
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


