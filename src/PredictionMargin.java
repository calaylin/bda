import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;


public class PredictionMargin {
	public static void main(String[] args) throws Exception 
	{
		String predictionFile="/Users/Aylin/Desktop/gitpredictions";
		BufferedReader reader = new BufferedReader(new FileReader(predictionFile));
    	BufferedWriter writer  = new BufferedWriter(new FileWriter(predictionFile+"err.arff"));
    	String [] arr;
    	String line="";
    	int counter=0;
	    writer.write(	"@relation MarginCurve"+"\n"+
   	    		"@attribute Instance_number numeric"+"\n"+
   	    		"@attribute Margin numeric"+"\n"+
   	    		"@attribute Current numeric"+"\n"+
   	    		"@attribute Cumulative numeric"+"\n"+
   	    		"@data"+"\n");
   	    	while((line = reader.readLine())!= null){
   	    		line=line.replaceAll("\\*", "");
   	    		arr= line.split(",");
   	    		System.out.println("line "+arr[0]);
   	    	//	writer.write(arr[0]);

   	    		System.out.println("3 "+arr[3]);
   	    		System.out.println("inst "+arr[3]);
   	 

   	    		System.out.println("Error?;"+arr[3]);
   	    		double[] array = new double[arr.length-4];

   	    		for(int i=4;i< arr.length;i++){
   	    			array[i-4]=Double.parseDouble(arr[i]);
   	    		}
   	    		Arrays.sort(array);

   	    		
   	    		for (int i = array.length - 1; i >= 0; i--){
   	    	//	    System.out.print(array[i] + " ");
   	    	//	System.out.println();
   	    	//	System.out.println(array[array.length - 1]);
   	    			}
   	    		
   
   	    
   	    		writer.write(counter +" ," +(array[array.length - 1]-array[array.length - 2])+
   	    				",1,"+counter+ ", "+arr[3]+"\n"
   	    				);
   	    		counter++;
/*   	    		@relation MarginCurve

   	    		@attribute Instance_number numeric
   	    		@attribute Margin numeric
   	    		@attribute Current numeric
   	    		@attribute Cumulative numeric

   	    		@data
   	    		0,-1,0,0*/
/*
   	 		if(arr[3].contains("+")){
   	    		writer.write(arr[2] +";" +"ERROR; "+arr[3] + ";"+
   	    				(array[array.length - 1]-array[array.length - 2]) +"\n");}
   	    		if(!(arr[3].contains("+"))){
   	    		writer.write(arr[2] +";" +"NA; "+arr[3] + ";"+
   	    				(array[array.length - 1]-array[array.length - 2]) +"\n");}
   	    		*/
   	    	}
   	    	reader.close();
   	    	writer.close();
		
	}
}
