import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;


public class DepthASTNode {
	
    public static void main(String[] args) throws Exception, IOException, InterruptedException {
    	String dataDir ="/Users/Aylin/Desktop/Drexel/2014/ARLInternship/"
    			+ "SCAA_Datasets/AnalysisCode/for/";
    	String fileName =dataDir+"simpleforlabels.dep";
        String[] DepASTTypes = FeatureCalculators.uniqueDepASTTypes(dataDir);
    	String featureText = Util.readFile( fileName);
    	float [] depFeature =getAvgDepthASTNode(featureText,DepASTTypes);
    	for(int i=0;i<depFeature.length;i++)
    		System.out.println(DepASTTypes[i]+","+depFeature[i]);
    	
    }
	
    
	public static float[] getAvgDepthASTNode(String featureText, String[] ASTTypes) throws IOException
	{
		int [] lines = getASTDepLines(featureText);
		float [] occurrences=new float[ASTTypes.length];
		float [] totalDepth=new float[ASTTypes.length];
		float [] avgDepth=new float[ASTTypes.length];

		String textAST=null;
		for (int i=0; i<lines.length; i++)
		{
			textAST = readLineNumber(featureText, lines[i]);
			for (int j=0; j< ASTTypes.length; j++)
			{
			  	 String str = ASTTypes[j].toString();
		         WholeWordIndexFinder finder = new WholeWordIndexFinder(textAST);
		         List<IndexWrapper> occurrencesHere = finder.findIndexesForKeyword(str);
			  	 occurrences[j] = occurrences[j] + occurrencesHere.size();
			  	 

			  	 for(int k=0; k<occurrencesHere.size(); k++)
			  	 {
			  	   int rightParanthesis =0;//(
			  	   int leftParanthesis =0;//)

			  	   for (Character c: textAST.substring(0,occurrencesHere.get(k).getStart()).toCharArray()) {
			  	       if (c.equals('(')) {
			  	    	 rightParanthesis++;
			  	       }
			  	     if (c.equals(')')) {
			  	    	 leftParanthesis++;
			  	       }
			  	   }
			  	 totalDepth[j]= totalDepth[j]+rightParanthesis-leftParanthesis;		  	   
			  	 }
			  	 
			  	 if(occurrences[j]==0)
//			  		avgDepth[j]=-1;
			  		avgDepth[j]=0;

			  	 else if (totalDepth[j]==0)
			  		 avgDepth[j]=0;
			  	 else
			  	 avgDepth[j]= totalDepth[j]/occurrences[j];		  	 
			}		
		}
		return avgDepth;
	}

   
	
	
	public static int getMaxDepthASTLeaf(String featureText, String[] ASTTypes) throws IOException
	{
		int [] lines = getASTDepLines(featureText);
		int [] occurrences=new int[ASTTypes.length];
		int [] maxDepth=new int[ASTTypes.length];

		String textAST=null;
		for (int i=0; i<lines.length; i++)
		{
			textAST = readLineNumber(featureText, lines[i]);
			for (int j=0; j< ASTTypes.length; j++)
			{
			  	 String str = ASTTypes[j].toString();
		         WholeWordIndexFinder finder = new WholeWordIndexFinder(textAST);
		         List<IndexWrapper> occurrencesHere = finder.findIndexesForKeyword(str);
			  	 occurrences[j] = occurrences[j] + occurrencesHere.size();
			  	 

			  	 for(int k=0; k<occurrencesHere.size(); k++)
			  	 {
			  	   int rightParanthesis =0;//(
			  	   int leftParanthesis =0;//)

			  	   for (Character c: textAST.substring(0,occurrencesHere.get(k).getStart()).toCharArray()) {
			  	       if (c.equals('(')) {
			  	    	 rightParanthesis++;
			  	       }
			  	     if (c.equals(')')) {
			  	    	 leftParanthesis++;
			  	       }
			  	   }

				if((rightParanthesis-leftParanthesis) > maxDepth[j])
					maxDepth[j]= rightParanthesis-leftParanthesis;
				}
			  	 
			  	 if(occurrences[j]==0)
			  		maxDepth[j]=0;		  	 
			}		
		}
	        List maxDepthall = Arrays.asList(ArrayUtils.toObject(maxDepth));
	        return (int) Collections.max(maxDepthall);
	   
	}
 
    //line number starts from 0
	public static int[] getASTDepLines(String featureText)
	{		
		HashSet<String> functionIDs = new HashSet<String>();
		HashSet<String> functionIDs2 = new HashSet<String>();

        //take the function id in the beginning of the line.    
		String[] lines = featureText.split("\n");
		for(int i=0; i< lines.length; i++)
		{
	        String firstWord = lines[i].substring(0, featureText.indexOf('\t'));
	        if(!functionIDs.contains(firstWord))
	        functionIDs.add(firstWord);
		}
		int [] ASTDepLines=new int[functionIDs.size()];
		for(int i=0; i< lines.length; i++)
		{
	        String firstWord = lines[i].substring(0, featureText.indexOf('\t'));
	        if(i==0)
	        {
		    functionIDs2.add(firstWord);
	        }
	        else
	        {
	        	if(!functionIDs2.contains(firstWord))
	        	{
	        		int lineNumber = i-1;
	        		ASTDepLines[functionIDs2.size()-1] = lineNumber;
	        	}
	        	if(i==lines.length-1)
	        	{
	        		int lineNumber = i;
	        		ASTDepLines[functionIDs2.size()-1] = lineNumber;
	        	}
		    functionIDs2.add(firstWord);
	        }
		}       	
	       return ASTDepLines;        
	}
    
	
	//starts from 0
    public static String readLineNumber (String featureText, int lineNumber) throws IOException
    {
    	List<String> lines = IOUtils.readLines(new StringReader(featureText));  	
    	return lines.get(lineNumber);
    }
    
	public static float[] InfoGainsgetAvgDepthASTNode(String featureText, String[] ASTtypesAvgDepth) throws IOException
	{
			
		int [] lines = getASTDepLines(featureText);
		float [] occurrences=new float[ASTtypesAvgDepth.length];
		float [] totalDepth=new float[ASTtypesAvgDepth.length];
		float [] avgDepth=new float[ASTtypesAvgDepth.length];

		String textAST=null;
		for (int i=0; i<lines.length; i++)
		{
			textAST = readLineNumber(featureText, lines[i]);
			for (int j=0; j< ASTtypesAvgDepth.length; j++)
			{
			  	 String str = ASTtypesAvgDepth[j].toString();
		         WholeWordIndexFinder finder = new WholeWordIndexFinder(textAST);
		         List<IndexWrapper> occurrencesHere = finder.findIndexesForKeyword(str);
			  	 occurrences[j] = occurrences[j] + occurrencesHere.size();
			  	 

			  	 for(int k=0; k<occurrencesHere.size(); k++)
			  	 {
			  	   int rightParanthesis =0;//(
			  	   int leftParanthesis =0;//)

			  	   for (Character c: textAST.substring(0,occurrencesHere.get(k).getStart()).toCharArray()) {
			  	       if (c.equals('(')) {
			  	    	 rightParanthesis++;
			  	       }
			  	     if (c.equals(')')) {
			  	    	 leftParanthesis++;
			  	       }
			  	   }
			  	 totalDepth[j]= totalDepth[j]+rightParanthesis-leftParanthesis;		  	   
			  	 }
			  	 
			  	 if(occurrences[j]==0)
//			  		avgDepth[j]=-1;
			  		avgDepth[j]=0;

			  	 else if (totalDepth[j]==0)
			  		 avgDepth[j]=0;
			  	 else
			  	 avgDepth[j]= totalDepth[j]/occurrences[j];		  	 
			}		
		}
		return avgDepth;
	}

	
}