


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
		
		Util.writeFile("first distances: \n",file1, true);	
		Util.writeFile("second distances: \n",file2, true);	

		Instances instances1 = new Instances(new FileReader(arff1));
		instances1.setClassIndex(instances1.numAttributes() - 1);

		Instances instances2 = new Instances(new FileReader(arff2));
		instances2.setClassIndex(instances2.numAttributes() - 1);
		
		EuclideanDistance distance = new EuclideanDistance();
		//for public data
		distance.setInstances(instances1);
		
		for (int i=0; i < instances1.numInstances(); i++){
			for (int j=0; j < instances1.numInstances(); j++){

		Instance first = instances1.instance(i);
		Instance second = instances1.instance(j);
		//this is Euclidean distance, check the others (cosine) as well
		double d = distance.distance(first, second);
		
		
		//for public
		System.out.println("From: "+
		instances1.classAttribute().value((int) instances1.instance(i).classValue())
		+ " to: "+ instances1.classAttribute().value((int) instances1.instance(j).classValue())
		+ " "+ d
				);
		
		Util.writeFile("From: "+
				instances1.classAttribute().value((int) instances1.instance(i).classValue())
				+ " to: "+ instances1.classAttribute().value((int) instances1.instance(j).classValue())
				+ " "+ d + "\n",file1, true);	
		

		}
		}
		
	}
}
