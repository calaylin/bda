import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ArffLoader;


public class MergeArffsWithSameFeatures {
    public static void main(String[] args) throws Exception, IOException, InterruptedException {

    	File arffFile1 = new File("arffFile1");
    	File arffFile2 = new File("arffFile2");

		Instances data1 = new Instances(new FileReader(arffFile1));
		Instances data2 = new Instances(new FileReader(arffFile1));

    	Instances mergedData = Instances.mergeInstances( data1 ,data2);  

    	String finalArff=arffFile1.getPath()+arffFile1.getName()+"final"+ ".arff";
		BufferedWriter writer = new BufferedWriter(new FileWriter(finalArff));
		writer.write(mergedData.toString());
		writer.flush();
		writer.close();
	
    	
    	
}
}