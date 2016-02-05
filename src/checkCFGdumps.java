import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;


public class checkCFGdumps {
		
	    public static void main(String[] args) throws Exception, IOException, InterruptedException {

		String folderToProcess = "/Users/Aylin/Desktop/optimizations/L2_150authors/";
		List binary_paths = Util.listBinaryFiles(folderToProcess);
		
		
		for(int i=0;i< binary_paths.size();i++){
			
			File binaryFileName = new File(binary_paths.get(i).toString());
			binary_paths.get(i);
/*			File cfgDumps = new File (binary_paths.get(i)
			+"_bjoernDisassembly"+ 
					File.separator + binaryFileName.getName()+"CFG"+File.separator);
			
			if(!(cfgDumps.exists())){
				System.out.println(binary_paths.get(i).toString());
				FileUtils.deleteDirectory(binaryFileName.getParentFile());

			}*/
			
			File snowmanFiles = new File (binary_paths.get(i)
			+"_SnowmanDecompiled.dot");
			
			if(!(snowmanFiles.exists())){
				System.out.println(binary_paths.get(i).toString());
				FileUtils.deleteDirectory(binaryFileName.getParentFile());

			}
			
		}
	
		
}
}