import weka.attributeSelection.BestFirst;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.PrincipalComponents;
import weka.attributeSelection.Ranker;
import weka.classifiers.*;
import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.meta.AttributeSelectedClassifier;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.RandomForest;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.Range;
import weka.core.Utils;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.StringToNominal;
import weka.filters.unsupervised.instance.RemoveRange;
import weka.filters.unsupervised.instance.RemoveWithValues;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class FeatureMappingSourceDecompiled {


	public static void main(String[] args) throws Exception 
	{
		
		String arffFile ="/Users/Aylin/Desktop/Princeton/BAA/arffs/merged/"

				+"C_34Authors14files_decompiledPlusOriginal_IGsmerged_ready.arff";		

		String newFileName ="/Users/Aylin/Desktop/Princeton/BAA/featureAnalysis/"

            + "C_34Authors14files_decompiledPlusOriginal_IGsmerged_ready.txt";

		
            
            
	//	RandomForest cls = new RandomForest();
		Instances data = new Instances(new FileReader(arffFile));
		//remove feature
	//	data.deleteAttributeAt(0);
	//	data.setClassIndex(data.numAttributes() - 1);
		
		
		//convert string attributes to nominal
/*	    StringToNominal stToNom = new StringToNominal();
	    String[] options={"-R","last-1"};
	   stToNom.setOptions(options);
	    stToNom.setInputFormat(data);
	     data = Filter.useFilter(data, stToNom); 
	    */
		//Start information gain that selects up to n features that have nonzero infogain
		double [][]corr = new double[data.numAttributes()][data.numAttributes()] ;
		double [] input1= new double[data.numInstances()];
		double [] input2 =new double[data.numInstances()];
		
		for(int i =0; i< data.numAttributes(); i++){
			for(int j =0; j< data.numAttributes(); j++){

				for(int k=0;k< data.numInstances(); k++){
				input1[k]= data.instance(k).value(i);
				input2[k]= data.instance(k).value(j);
				}
				
		corr[i][j]=weka.core.Utils.correlation(
				input1, input2, input2.length);
		
	//	System.out.println("for attribute " +i+ " and " + j +" the correlation is:"+corr[i][j]);
		if(corr[i][j]> 0.1){
			//	System.out.println("for attribute " +i+":"+ data.attribute(i)+" and " + j+":" +data.attribute(j)+" the correlation is:"+corr[i][j]);
				Util.writeFile("for attribute " +i+":"+ data.attribute(i)+
						" and " + j+":" +data.attribute(j)+" the correlation is:"+corr[i][j] +"\n", 
						newFileName, true);

			}
		
			}
				System.out.println("for attribute " +i);
}
		

				
		//		    for (double[] row : corr) {
		//		        System.out.println(Arrays.toString(row)); 
		//	Util.writeFile(Arrays.toString(row), newFileName, true);}
		
		
/*	    AttributeSelection attributeSelection = new  AttributeSelection(); 
	    PrincipalComponents eval=new PrincipalComponents();
	     int[] rang = null;
         Ranker search = new Ranker();
      //   search2.setNumToSelect(2);
         search.setGenerateRanking(true);
         attributeSelection.setEvaluator(eval); 
	     attributeSelection.setSearch(search); 
	     attributeSelection.setInputFormat(data); 
	     Instances newData = Filter.useFilter(data, attributeSelection);
         rang = search.search(eval	, newData);
          rang.toString();*/


	



	     
/*		//write to new arff file
		 BufferedWriter writerIG = new BufferedWriter(new FileWriter(newFileName));
		 writerIG.write(newData.toString());
		 writerIG.flush();
		 writerIG.close();*/
	    

	}
	
}