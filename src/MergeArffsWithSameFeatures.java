import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.ArffSaver;


public class MergeArffsWithSameFeatures {
    public static void main(String[] args) throws Exception, IOException, InterruptedException {

		String output_filename = "/home/ubuntu/Desktop/usenix16/arffs/"
				+ "L0_150authorsConcurrent/L0_150authors_allfeatures_concurrent";
		
		String finalArff = output_filename+"Final2"+".arff";

    	File arffFile1 = new File(output_filename  +"1.arff");


		Instances data1 = new Instances(new FileReader(arffFile1));

/*    	Instances mergedData = Instances.mergeInstances( data1 ,data2);  
    	ArffSaver saver = new ArffSaver();
    	saver.setInstances(mergedData);
    	saver.setFile(new File(finalArff));
    	saver.setDestination(new File(finalArff));
    	saver.writeBatch();*/

    	//the following does not scale
		BufferedWriter writer = new BufferedWriter(new FileWriter(finalArff));
		writer.write(data1.toString());
		writer.flush();
		writer.close();
	
		File arffFile2;
		Instances data2;
		
    	Util.writeFile("\n", finalArff, true);

		for(int i=2; i<=21;i++){
        arffFile2 = new File(output_filename  +i+".arff");
	    data2 = new Instances(new FileReader(arffFile2));
	    for(int j=0; j<data2.numInstances(); j++){
	    	Util.writeFile(data2.instance(j).toString()+"\n", finalArff, true);
	    }
		}


    	
    	
}
}