import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;



public class DownloadGitRepos {

	
	//https://github.com/arachsys/containers/archive/master.zip
	//username/reponame/archive/master.zip
	public static void getDownloadURL(String gitUser, String repoName) throws IOException   {
		

	   try{         // get URL content
	          String url_open= "https://github.com/"
				+ gitUser
				+ File.separator
				+ repoName
				+ "/archive/master.zip";
	    		
	          URL website = new URL(url_open);
	          ReadableByteChannel rbc = Channels.newChannel(website.openStream());
	          String contestantFolder = "/Users/Aylin/Desktop/githubRepos/"+gitUser+File.separator;
	          File aFile = new File(contestantFolder);			
	          if(aFile.exists() == false)
	 	    		aFile.mkdir();
	          String fileName = contestantFolder+ gitUser + "_"+ repoName+".zip";
	          FileOutputStream fos = new FileOutputStream(fileName);
	          File bFile = new File(fileName);			
	          if(bFile.exists() == false)
	 	    		bFile.createNewFile();
	          fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);    
	          UnZip(fileName);
	         // unzip(fileName,contestantFolder);

	   }
	   catch (FileNotFoundException e) {
		   System.out.println("No File");		   
		   }
	   catch (IOException e) {
		   System.out.println("IOException");		   
		   }
	   

	}

	
	
	
	public static void UnZip(String fileName) throws IOException
		{       
		     InputStream is;
		     ZipInputStream zis;
		
		         String filename;
		         is = new FileInputStream(fileName);
		         zis = new ZipInputStream(new BufferedInputStream(is));          
		         ZipEntry ze;
		         byte[] buffer = new byte[1024];
		         int count;

		         while ((ze = zis.getNextEntry()) != null) 
		         {
		             // zapis do souboru
		             filename = ze.getName();

		             // Need to create directories if not exists, or
		             // it will generate an Exception...
		             if (ze.isDirectory()) {
		                File fmd = new File(new File((new File(fileName)).getParent()).getPath()+File.separator + filename);
		                fmd.mkdirs();
		                continue;
		             }

		             FileOutputStream fout = new FileOutputStream(new File((new File(fileName)).getParent()).getPath()+File.separator + filename);

		             // cteni zipu a zapis
		             while ((count = zis.read(buffer)) != -1) 
		             {
		                 fout.write(buffer, 0, count);             
		             }

		             fout.close();               
		             zis.closeEntry();
		             new File(fileName).delete();
		         }
		         }

	
	
	public static void main(String[] args) throws IOException{

		//https://github.com/arachsys/containers/archive/master.zip
		//username/reponame/archive/master.zip

		String repoDir ="/Users/Aylin/Desktop/Princeton/BAA/datasets/dataset-20151012/repos/";
		File file = new File(repoDir);
		String[] directories = file.list(new FilenameFilter() {
		  @Override
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
//		System.out.println(directories[0]);
		
		for (int i=0; i< directories.length; i++)
		{
			String authorDir= repoDir + directories[i] + File.separator;
			File author = new File(authorDir);
			String[] repos = author.list(new FilenameFilter() {
			  @Override
			  public boolean accept(File current, String name) {
			    return new File(current, name).isDirectory();
			  }
			});
			for (int j=0; j< repos.length;j++){		
				System.out.println("repo:"+repos[j]);
				getDownloadURL(directories[i].toString(), repos[j].toString());
			}
		}
		
//		        getDownloadURL(2994486,5658282861527040L,"Aquaaarius");

}		      	
}
