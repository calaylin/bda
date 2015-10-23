import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.classifiers.*;
import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.RandomForest;
import weka.core.Attribute;
import weka.core.AttributeStats;
import weka.core.Instances;
import weka.core.Range;
import weka.core.Utils;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.instance.RemoveRange;
import weka.filters.unsupervised.instance.RemoveWithValues;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AuthorClassificationBasic {


	public static void main(String[] args) throws Exception 
	{
		double accuracy=0;
		int endRelax = 10;
		int numberFiles=9;
		int numFeatures=0; //0 is the default logM+1
		int seedNumber;
		double total =0;
		double average =0;

		String fileName  ="/mnt/data_bsd/repos_results.txt";
		
		
		String arffFile ="/mnt/data_bsd/repos.arff";
		
			  Util.writeFile(numberFiles+"FilesPerAuthor: \n",fileName, true);	
			  for(int relaxPar = 1; relaxPar<=endRelax; relaxPar++){
				  total=0;				  
				  average=0;

				  for(seedNumber=1; seedNumber<2; seedNumber++){
					  int foldNumber=numberFiles;


 
		RandomForest cls = new RandomForest();
		Instances data = new Instances(new FileReader(arffFile));
		data.setClassIndex(data.numAttributes() - 1);

		//remove the instanceID
	 //   data.deleteAttributeAt(0);
		System.out.println("hi1");
		AttributeStats stats = data.attributeStats(data.classIndex());
		int[] attStats = stats.nominalCounts;
		System.out.println(stats.toString());

		for(int i=0; i< attStats.length; i++){
			System.out.println(i + "no:" + attStats[i]);
			
		}
		//you need to use the remove with values filter, set the filter to the class attribute 
		//and then specify the indeces of classes to be removed (you can get the indeces from stats.

	 	 BufferedWriter writer = new BufferedWriter(new FileWriter("/mnt/data_bsd/arffs/repos_noSmallclasses.arff"));
		 writer.write(data.toString());
		 writer.flush();
		 writer.close();

		 
		//do not stratify if you are going to remove instances for training and testing
	     data.stratify(foldNumber);
	     //be careful about this for removing instanceID only
	 	 //filteredData.deleteAttributeAt(0);

	/* BufferedWriter writer = new BufferedWriter(new FileWriter("/mnt/data_bsd/repos_ready.arff"));
		 writer.write(data.toString());
		 writer.flush();
		 writer.close();*/
		
		//Start information gain that selects up to n features (-1 for unlimited)
		int n = -1; // number of features to select 
	    AttributeSelection attributeSelection = new  AttributeSelection(); 
	     Ranker ranker = new Ranker(); 
     	//use the following if not taking IG
		// ranker.setGenerateRanking(false);
	     ranker.setNumToSelect(n); 
	     ranker.setThreshold(0);
	     InfoGainAttributeEval infoGainAttributeEval = new InfoGainAttributeEval(); 

	     attributeSelection.setEvaluator(infoGainAttributeEval); 
	     attributeSelection.setSearch(ranker); 
	     attributeSelection.setInputFormat(data); 
	     data = Filter.useFilter(data, attributeSelection); 
/*	 	 BufferedWriter writer = new BufferedWriter(new FileWriter("/mnt/data_bsd/repos_ready.arff"));
		 writer.write(data.toString());
		 writer.flush();
		 writer.close();*/

		   
		 
	     System.out.println("before building classifier");
		 String[] options = weka.core.Utils.splitOptions("-I 300 -K "+numFeatures+" -S "+seedNumber);
			cls.setOptions(options);
		cls.buildClassifier(data);
		
		System.out.println("Number of instances: " + data.numInstances()+" and number of authors: " + data.numClasses());

		Evaluation eval=null;
		

		if(endRelax==1)
		 eval = new Evaluation(data);
		else
		 eval= new RelaxedEvaluation(data, relaxPar);
		
		
		
		
		eval.crossValidateModel(cls, data,foldNumber , new Random(seedNumber));
/*		System.out.println("Relaxed by, "+relaxPar+", seedNo,"+seedNumber+", files,"+numberFiles+", authors,"+filteredData.numClasses());
		Util.writeFile("Relaxed by, "+relaxPar+", seedNo,"+seedNumber+", files,"+numberFiles+", authors,"+filteredData.numClasses(),
				fileName, true);*/
		
		/*//generate curve
		 ThresholdCurve tc = new ThresholdCurve();
	     int classIndex = data.numAttributes() - 1;
	     Instances result = tc.getCurve(eval.predictions(), 1);	
		 System.out.println("Area under the curve is: "+ThresholdCurve.getROCArea(result));
		 Util.writeFile("Area under the curve for class "+classIndex+ " is:"+
		 ThresholdCurve.getROCArea(result), fileName, true);
*/
	     
	     

	
	     accuracy=eval.pctCorrect();
	     total =total+accuracy;
	     average = total/seedNumber;

		  System.out.println("accuracy is "+eval.pctCorrect());

		  System.out.println("\nThe accuracy with  is "+eval.pctCorrect()+", relaxed by, "+relaxPar+", \n"
		 );
/*Util.writeFile("\nThe accuracy with feature is "+eval.pctCorrect()+", relaxed by, "+relaxPar+", \n",
		 fileName, true);
			}	*/

				  System.out.println("total is "+total);
				  System.out.println("avg is "+average);
				  System.out.println("accuracy is "+accuracy);

/*		System.out.println("\nThe average accuracy with "+numberFiles+"files is "+average+"\n");	
	     Util.writeFile("\nThe average accuracy with "+numberFiles+"files is "+average+", relaxed by, "+relaxPar+", \n",
	    		 fileName, true);	*/

	     }}	
	}
}