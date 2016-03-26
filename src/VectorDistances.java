


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import weka.core.EuclideanDistance;
import weka.core.Instance;
import weka.core.Instances;

public class VectorDistances {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		String file1  =	"file1.txt";
		String file2  =	"file2.txt";

		String arff1 = "file1.arff" ;
		String arff2 = "file2.arff" ;
		
		
		String arffFile ="/Users/Aylin/Desktop/Princeton/BAA/arffs/"

            + "all_syntactic_L0.arff";

		String arffFile1 ="/Users/Aylin/Desktop/Princeton/BAA/arffs/"

            + "all_syntactic_L1.arff";
		String arffFile2 ="/Users/Aylin/Desktop/Princeton/BAA/arffs/"

            + "all_syntactic_L2.arff";
		
		String arffFileorg ="/Users/Aylin/Desktop/Princeton/BAA/arffs/"

            + "all_syntactic_originalCode.arff";
		
		
		Util.writeFile("first distances: \n",file1, true);	
		Util.writeFile("second distances: \n",file2, true);	

		Instances instances1 = new Instances(new FileReader(arffFileorg));
		Instances instances2 = new Instances(new FileReader(arffFile));
		Instances instances3 = new Instances(new FileReader(arffFile1));
		Instances instances4 = new Instances(new FileReader(arffFile2));

		EuclideanDistance distance = new EuclideanDistance();
		//for public data
		distance.setInstances(instances3);
		String instanceID="";
		Instance first;
		Instance second;
		for(int i=0; i< instances3.numInstances(); i++){
	 		 instanceID = instances3.instance(i).stringValue(0).substring(53, 
	 				 (instances3.instance(i).stringValue(0).toString()).length()-4);
	 		 
	 		System.out.println(instances3.instance(i).stringValue(0).substring(53, 
	 				instances3.instance(i).stringValue(0).length()));
	 		
	 		Util.writeFile("\n " ,
	 				"/Users/Aylin/Desktop/Princeton/BAA/results/syntacticFeatureDistances"
	 						+ "fromL1toL2.txt",true);
	 		
		System.out.println(instances3.instance(i).stringValue(0).substring(53,
				(instances3.instance(i).stringValue(0).toString()).length()-4));

		
		
		
		for(int j=0; j<instances4.numInstances();j++){
			if(instances4.instance(j).stringValue(0).contains(instanceID)){
				 first = instances3.instance(i);
				 second = instances4.instance(j);
				//this is Euclidean distance, check the others (cosine) as well
				double d = distance.distance(first, second);
				System.out.println(instanceID + " cos distance: "+Double.toString(d));
				Util.writeFile(" "+ instanceID + " "+Double.toString(d) ,
				"/Users/Aylin/Desktop/Princeton/BAA/results/syntacticFeatureDistances"
				+ "fromL1toL2.txt",true);
				

		}
		
		
/*		for(int l=0; l<instances4.numInstances();l++){
			if(instances4.instance(l).stringValue(0).contains(instanceID)){
				 first = instances2.instance(i);
				 second = instances4.instance(l);
				//this is Euclidean distance, check the others (cosine) as well
				double d = distance.distance(first, second);
				System.out.println(instanceID + " cos distance: "+Double.toString(d));
				Util.writeFile(" "+instanceID + " "+Double.toString(d) ,
				"/Users/Aylin/Desktop/Princeton/BAA/results/syntacticFeatureDistances"
				+ "fromL0to1and2.txt",true);
			}*/
		}
		

		
		
	}
}}
