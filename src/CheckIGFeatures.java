

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


public class CheckIGFeatures {
	
    public static void main(String[] args) throws Exception, IOException, InterruptedException {

	String ig= "/Users/Aylin/Desktop/IG.txt/";
	   String[] arr;
	   String[] featureName;
	   BufferedReader br = new BufferedReader(new FileReader(ig));
	   String line;
	   int counter=0;
	   int lines=0;
	   
		while ((line = br.readLine()) != null)
		{					
			lines++;
			}
	   String[] features = new String[lines];

	    br = new BufferedReader(new FileReader(ig));

		while ((line = br.readLine()) != null)
		{					
			arr = line.split("=\\[",2);
			if ( arr.length>1){
				arr[0] = arr[0].replaceAll("\\d+", "number");
				featureName = arr[0].split("number ",3);
				featureName[2]= featureName[2].replace(" number", "");
				featureName[2]=featureName[2].trim();
			//	System.out.println("part1: "+featureName[2]);
				arr[1]= arr[1].substring(0,arr[1].length()-1);
				//System.out.println("part2: "+arr[1]);
				System.out.println(featureName[2] +" , " +arr[1]);
	//			Util.writeFile(featureName[2] +" , " +arr[1] + "\n", "/Users/Aylin/Desktop/IGclean.txt", true);
			//	features[counter]=featureName[2] +" , \"" +arr[1]+ "\",";
					features[counter]=featureName[2] ;

			counter++;
			}
			
			}

		Arrays.sort(features);
		for(int i=0;i<features.length;i++){
			Util.writeFile(features[i] + "\n", "/Users/Aylin/Desktop/IGtype.txt", true);

		}


	

    }
}
