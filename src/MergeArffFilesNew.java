import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import weka.core.Instances;

/**
 * Appends two arff files where each feature vector contains the same ID.
 * This can be used to combine features at different times.
 * The two files can contain the same features.
 * It does a right join based on the first file. The resulting file would only have features 
 * in the first file that also existed in the second file.
 *
 *
 * @author Aylin Caliskan-Islam (aylinc@princeton.edu)
 */
public class MergeArffFilesNew {

	//Find the intersecting userIDs and merge all the features and instances to a new file
	//file2's instances and features are appended to file1
    public static void main(String[] args) throws Exception{
    	 

           

            String file2 ="/Users/Aylin/Desktop/Princeton/BAA/arffs/100authors/"

            		+"originalVSLO_100Originalprogrammers_9filesALLcls_IG.arff";
            
            
            
            String file1 ="/Users/Aylin/Desktop/Princeton/BAA/arffs/100authors/"

            + "originalVSLO_100L0programmers_9filesALLcls_IG.arff";


            String outputArffName ="/Users/Aylin/Desktop/Princeton/BAA/arffs/100authors/"

            + "originalVSLO_MERGEDFEATURES100programmers_9filesALLcls_IG.arff";

           

		
		
        Util.writeFile("@relation " + file1+file2+"\n" +"\n" , outputArffName, true);

        // Read all the instances in the files 
		Instances instances = new Instances(new FileReader(file1));
		Instances instances2 = new Instances(new FileReader(file2));
		
		//write file1's features
		for (int att=0; att < instances.numAttributes(); att++)
		{	//	System.out.println("instance no:"+att+"    "+instances.attribute(att).name());
				String type="";
				String attValues="";
				String name=instances.attribute(att).name();
				name.replace("$", "dollarsign");
			    	String arr[] = name.split("\n", 10);
		   	 		if(arr.length>1){
		   	 			name="";
		   	 			int splits = arr.length;
		   	 					for(int i =0; i<splits; i++){
		   	 					name = name + arr[i]	;
		   	 					}
			
		   	 		}
								
				if(instances.attribute(att).isNumeric()){
					type="numeric";
				}
				if(instances.attribute(att).isNominal()){
					type="nominal";
					Enumeration vals = instances.attribute(att).enumerateValues();
					while(vals.hasMoreElements()){
					attValues = attValues + vals.nextElement().toString();
					attValues = attValues + ", ";}
				}
			
				if(instances.attribute(att).isString()){
					type="string";
				}
	
				
				if(type.equals("nominal"))
				{
					Util.writeFile("@attribute " +"'"+name+"decompiled' "
					+ "{"+attValues+"}" +"\n", outputArffName, true);
				}
				
				else
				{
					Util.writeFile("@attribute " +"'"+name+"decompiled' "
					+ type +"\n", outputArffName, true);
				}

		}
		
		
		
		
		
		
		
		//write file2's features
		for (int att2=0; att2 < instances2.numAttributes(); att2++)
		{		
			//System.out.println("instance no:"+att2+"    "+instances2.attribute(att2).name());
		String type="";
		String attValues="";
		
		String name =instances2.attribute(att2).name();
		//TODO
		//name.replace("$", "dollarsign");
    	String arr[] = name.split("\n", 10);
   	 		if(arr.length>1){
   	 			name="";
   	 			int splits = arr.length;
   	 					for(int i =0; i<splits; i++){
   	 					name = name + arr[i]	;
   	 					}
	
   	 		}
   	 		
   	 		
		if(instances2.attribute(att2).isNumeric()){
			type="numeric";
		}
		

		
		if(instances2.attribute(att2).isNominal()){
			type="nominal";
			Enumeration vals = instances2.attribute(att2).enumerateValues();
			while(vals.hasMoreElements()){
				attValues = attValues + vals.nextElement().toString();
			attValues = attValues + ", ";}
		}
	
		if(instances2.attribute(att2).isString()){
			type="string";
		}

		
		if(type.equals("nominal"))
		{
			
			Util.writeFile("@attribute " +"'"+ name +"original' " 
			+ "{"+attValues+"}" +"\n", outputArffName, true);
		}
		
		else{
			Util.writeFile("@attribute " +"'"+ name +"original' "  
			+ type +"\n", outputArffName, true);
		}

}


		Util.writeFile( "@data" +"\n", outputArffName, true);

		
		
		for (int i=0;i< instances.numInstances();i++){
			for(int j=0; j< instances2.numInstances();j++){
				//one of the instanceID's ends with .c and the other with .cpp, so make sure this is correct
	//			if(instances2.instance(j).stringValue(0).contains(instances.instance(i).stringValue(0)))
				if(instances.instance(i).stringValue(0).
						contains(instances2.instance(j).stringValue(0).substring(0,instances2.instance(j).stringValue(0).length()-4)))
					{
		        System.out.println(i+" \n"); 

		        //merge the two feature vectors
				Util.writeFile(instances.instance(i)
						+ ", "+ instances2.instance(j)+ "\n", outputArffName, true );
				
				//Only write file1's features
				//Util.writeFile(instances.instance(i)+ "\n", outputArffName, true );
				
					}
			
		}
		}
    } 
	
}
