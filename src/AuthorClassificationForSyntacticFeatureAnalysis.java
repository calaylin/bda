import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.classifiers.*;
import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.RandomForest;
import weka.core.Attribute;
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

import org.apache.commons.lang3.StringUtils;

public class AuthorClassificationForSyntacticFeatureAnalysis {


	public static void main(String[] args) throws Exception 
	{
		double accuracy=0;
		int endRelax = 1;
		int numberFiles=9;
		int numFeatures=0; //0 is the default logM+1
		int seedNumber;
		double total =0;
		double average =0;

		String fileName  ="/Users/Aylin/Desktop/Princeton/BAA/results/"
				+	"test.txt";
		
		
		String arffFile ="/Users/Aylin/Desktop/Princeton/BAA/arffs/"

            + "all_syntactic_L0.arff";

		String arffFile1 ="/Users/Aylin/Desktop/Princeton/BAA/arffs/"

            + "all_syntactic_L1.arff";
		String arffFile2 ="/Users/Aylin/Desktop/Princeton/BAA/arffs/"

            + "all_syntactic_L2.arff";
		String arffFileorg ="/Users/Aylin/Desktop/Princeton/BAA/arffs/"

            + "all_syntactic_originalCode.arff";
		
			  Util.writeFile(numberFiles+"FilesPerAuthor: \n",fileName, true);	
			  for(int relaxPar = 1; relaxPar<=endRelax; relaxPar++){
				  total=0;				  
				  average=0;

				  for(seedNumber=1; seedNumber<2; seedNumber++){
					  int foldNumber=numberFiles;


 
		RandomForest cls = new RandomForest();
		Instances data0 = new Instances(new FileReader("/Users/Aylin/Desktop/Princeton/BAA/arffs/"

            + "all_syntactic.arff"));
		Instances data = new Instances(new FileReader(arffFile));
		Instances data1 = new Instances(new FileReader(arffFileorg));
	
	 	data.setClassIndex(data.numAttributes() - 1);
	 	String instanceID="";
	 	String instances1 = "";


	 	for(int i=0; i< data.numInstances(); i++){
	 		 instanceID = data.instance(i).stringValue(0).substring(46, (data.instance(i).stringValue(0).toString()).length()-22);
	 	//	System.out.println(data.instance(i).stringValue(0).substring(46, data.instance(i).stringValue(0).length()));

		System.out.println(data.instance(i).stringValue(0).substring(46, (data.instance(i).stringValue(0).toString()).length()-22));
		for(int j=0; j<data1.numInstances();j++){
			if(data1.instance(j).stringValue(0).contains(instanceID)){
				instances1 = instances1 + (Integer.toString(j+1) + ",");
			}
			
		}
	 	}
	 	System.out.println(instances1);
	 	System.out.println(StringUtils.countMatches(instances1, ","));

		RemoveRange filter_1 = new RemoveRange();
		filter_1.setInputFormat(data1);
		filter_1.setInstancesIndices(instances1);
		filter_1.setInvertSelection(true);
		
		Instances inst = Filter.useFilter(data1, filter_1);
		 BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/Aylin/Desktop/Princeton/BAA/arffs/"
		 		+ "all_syntactic_Originalsubset.arff"));
		 writer.write(inst.toString());
		 writer.flush();
		 writer.close();
	 	
	 	
	 	
		//remove the instanceID
	   // data.deleteAttributeAt(0);
/*	 
		
	RemoveRange filter_org = new RemoveRange();
		filter_org.setInputFormat(data0);
		filter_org.setInstancesIndices("847-1269");
		filter_org.setInvertSelection(true);

		Instances inst_org = Filter.useFilter(data0, filter_org);
		System.out.println("Data size " + inst_org.numInstances());
		 BufferedWriter writer0 = new BufferedWriter(new FileWriter("/Users/Aylin/Desktop/Princeton/BAA/arffs/"
		 		+ "all_syntactic_originalCode.arff"));
		 writer0.write(inst_org.toString());
		 writer0.flush();
		 writer0.close();
		 


		 
			RemoveRange filter_l0 = new RemoveRange();
			filter_l0.setInputFormat(data);
			filter_l0.setInstancesIndices("604-846");
			filter_l0.setInvertSelection(true);

			Instances inst_l0 = Filter.useFilter(data, filter_l0);
			System.out.println("Data size " + inst_l0.numInstances());
			 BufferedWriter writer_l0 = new BufferedWriter(new FileWriter("/Users/Aylin/Desktop/Princeton/BAA/arffs/"
			 		+ "all_syntactic_L0.arff"));
			 writer_l0.write(inst_l0.toString());
			 writer_l0.flush();
			 writer_l0.close();
			
			 
			 
				RemoveRange filter_l1 = new RemoveRange();
				filter_l1.setInputFormat(data);
				filter_l1.setInstancesIndices("1-297");
				filter_l1.setInvertSelection(true);

				Instances inst_l1 = Filter.useFilter(data, filter_l1);
				System.out.println("Data size " + inst_l1.numInstances());
				 BufferedWriter writer_l1 = new BufferedWriter(new FileWriter("/Users/Aylin/Desktop/Princeton/BAA/arffs/"
				 		+ "all_syntactic_L1.arff"));
				 writer_l1.write(inst_l1.toString());
				 writer_l1.flush();
				 writer_l1.close();
				 
				 
					RemoveRange filter_l2 = new RemoveRange();
					filter_l2.setInputFormat(data);
					filter_l2.setInstancesIndices("298-603");
					filter_l2.setInvertSelection(true);

					Instances inst_l2 = Filter.useFilter(data, filter_l2);
					System.out.println("Data size " + inst_l2.numInstances());
					 BufferedWriter writer_l2 = new BufferedWriter(new FileWriter("/Users/Aylin/Desktop/Princeton/BAA/arffs/"
					 		+ "all_syntactic_L2.arff"));
					 writer_l2.write(inst_l2.toString());
					 writer_l2.flush();
					 writer_l2.close();
			 
		
	*/	
		
		
		

		//do not stratify if you are going to remove instances for training and testing
	     data.stratify(foldNumber);
	     //be careful about this for removing instanceID only

	 
		
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
		
		//generate curve
		 ThresholdCurve tc = new ThresholdCurve();
	     int classIndex = data.numAttributes() - 1;
	     Instances result = tc.getCurve(eval.predictions(), 1);	
		 System.out.println("Area under the curve is: "+ThresholdCurve.getROCArea(result));
		 Util.writeFile("Area under the curve for class "+classIndex+ " is:"+
		 ThresholdCurve.getROCArea(result), fileName, true);

	     
	     

	
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