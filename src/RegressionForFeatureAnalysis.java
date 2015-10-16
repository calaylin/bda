

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.trees.RandomForest;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.filters.unsupervised.attribute.Remove;

public class RegressionForFeatureAnalysis {
	public static void main(String[] args) throws Exception 
	{
	double accuracy=0;
	int endRelax = 10;
	int numberFiles=9;
	int numFeatures=0; //0 is the default logM+1
	int seedNumber;
	double total =0;
	double average =0;

	String fileName  ="/Users/Aylin/Desktop/Princeton/BAA/"
			+ "featureAnalysis/all_syntactic_L0_and_original_ready.txt";
	
	
	String arffFile ="/Users/Aylin/Desktop/Princeton/BAA/arffs/featureAnalysis/"
			+ "all_syntactic_L0_and_original_ready.arff";
	
		  Util.writeFile(numberFiles+"FilesPerAuthor: \n",fileName, true);	
		  for(int relaxPar = 1; relaxPar<=endRelax; relaxPar++){
			  total=0;				  
			  average=0;

			  for(seedNumber=1; seedNumber<2; seedNumber++){
				  int foldNumber=numberFiles;


				 	Instances       inst;
				    Instances       instNew;
				    Remove          remove;

	for (int i=1496; i <1624; i++){

    inst   = new Instances(new BufferedReader(new FileReader(arffFile)));
    remove = new Remove();
    remove.setAttributeIndices("1-1495, "+i);
    remove.setInvertSelection(true);
    remove.setInputFormat(inst);
    instNew = Filter.useFilter(inst, remove);
    instNew.setClassIndex(1495);
    System.out.print("When the class is: "+instNew.classAttribute());

	
    LinearRegression model = new LinearRegression();
    model.buildClassifier(instNew); 
//    System.out.println(" The model is"+ model);
    
    
	Evaluation eval=null;
	eval = new Evaluation(instNew);
	eval.crossValidateModel(model, instNew,foldNumber , new Random(seedNumber));

    System.out.println("The correlation coefficient is: "+eval.correlationCoefficient()
    		+" for feature " +instNew.classAttribute());

     }}	
}}

}