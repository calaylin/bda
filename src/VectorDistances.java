


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
		Instances instances2 = new Instances(new FileReader(arffFile2));
		
		EuclideanDistance distance = new EuclideanDistance();
		//for public data
		distance.setInstances(instances1);
		String instanceID="";
		Instance first;
		Instance second;
		for(int i=0; i< instances1.numInstances(); i++){
	 		 instanceID = instances1.instance(i).stringValue(0).substring(28, (instances1.instance(i).stringValue(0).toString()).length()-4);
	 		System.out.println(instances1.instance(i).stringValue(0).substring(28, instances1.instance(i).stringValue(0).length()));

		System.out.println(instances1.instance(i).stringValue(0).substring(28, (instances1.instance(i).stringValue(0).toString()).length()-4));
		for(int j=0; j<instances2.numInstances();j++){
			if(instances2.instance(j).stringValue(0).contains(instanceID)){
				 first = instances1.instance(i);
				 second = instances2.instance(j);
				//this is Euclidean distance, check the others (cosine) as well
				double d = distance.distance(first, second);
				System.out.println(instanceID + " cos distance: "+Double.toString(d));
				Util.writeFile(instanceID + " cos distance: "+Double.toString(d) +"\n",
				"/Users/Aylin/Desktop/Princeton/BAA/results/syntacticFeatureDistances"
				+ "fromOriginalDecompiledL2.txt",true);
			}
		}
		
	}
}}
