import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FeatureExtractorAllFeaturesConcurrent implements Runnable {

	private String test_dir; 
	private String output_filename;
	private int start;
	private int end;

		    public FeatureExtractorAllFeaturesConcurrent(String test_dir, 
			String output_filename,int start, int end){
				

		    	this.test_dir =test_dir;
		    	this.output_filename=output_filename;
		        this.start = start;
		        this.end = end;
		    }

		    public static void main(String[] args){
		    	String test_dir ="/home/ubuntu/Desktop/usenix16/datasets/L3_150authors/";	       		
				String output_filename = "/home/ubuntu/Desktop/usenix16/"
						+ "arffs/L3_150authorsConcurrent/L3_150authors_allfeaturesNoAVGDep_concurrent";

				List test_binary_paths = Util.listBinaryFiles(test_dir);
				int totalFiles = test_binary_paths.size();
				int threads = 30;
				int extra = totalFiles % threads;
				int noFiles= totalFiles/threads;
		        Thread looper31 = null;

				
				
		        Thread looper1 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"1.arff" ,(noFiles*0),(noFiles*1)-1));
		        Thread looper2 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"2.arff",(noFiles*1),(noFiles*2)-1));
		        Thread looper3 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"3.arff" ,(noFiles*2),(noFiles*3)-1));
		        Thread looper4 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"4.arff",(noFiles*3),(noFiles*4)-1));		        
		        Thread looper5 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"5.arff" ,(noFiles*4),(noFiles*5)-1));
		        Thread looper6 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"6.arff",(noFiles*5),(noFiles*6)-1));
		        Thread looper7 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"7.arff" ,(noFiles*6),(noFiles*7)-1));
		        Thread looper8 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"8.arff",(noFiles*7),(noFiles*8)-1));		    
		        Thread looper9 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"9.arff" ,(noFiles*8),(noFiles*9)-1));
		        Thread looper10 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"10.arff",(noFiles*9),(noFiles*10)-1));		        
		        Thread looper11 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"11.arff" ,(noFiles*10),(noFiles*11)-1));
		        Thread looper12 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"12.arff",(noFiles*11),(noFiles*12)-1));		        
		        Thread looper13 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"13.arff" ,(noFiles*12),(noFiles*13)-1));
		        Thread looper14 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"14.arff",(noFiles*13),(noFiles*14)-1));
		        Thread looper15 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"15.arff" ,(noFiles*14),(noFiles*15)-1));
		        Thread looper16 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"16.arff" ,(noFiles*15),(noFiles*16)-1));
		        Thread looper17 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"17.arff" ,(noFiles*16),(noFiles*17)-1));
		        Thread looper18 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"18.arff" ,(noFiles*17),(noFiles*18)-1));
		        Thread looper19 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"19.arff" ,(noFiles*18),(noFiles*19)-1));
		        Thread looper20 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"20.arff" ,(noFiles*19),(noFiles*20)-1));
		        Thread looper21 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"21.arff" ,(noFiles*20),(noFiles*21)-1));
		        Thread looper22 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"22.arff",(noFiles*21),(noFiles*22)-1));		        
		        Thread looper23 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"23.arff" ,(noFiles*22),(noFiles*23)-1));
		        Thread looper24 = new Thread (new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"24.arff",(noFiles*23),(noFiles*24)-1));
		        Thread looper25 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"25.arff" ,(noFiles*24),(noFiles*25)-1));
		        Thread looper26 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"26.arff" ,(noFiles*25),(noFiles*26)-1));
		        Thread looper27 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"27.arff" ,(noFiles*26),(noFiles*27)-1));
		        Thread looper28 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"28.arff" ,(noFiles*27),(noFiles*28)-1));
		        Thread looper29 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"29.arff" ,(noFiles*28),(noFiles*29)-1));
		        Thread looper30 = new Thread(new 
		        		FeatureExtractorAllFeaturesConcurrent(test_dir,output_filename+"30.arff" ,(noFiles*29),(noFiles*30)-1));
    
		        
		        
				if (extra > 0){
					   looper31 = new Thread(new 
				        		FeatureExtractorAllFeaturesConcurrent(test_dir,
				        				output_filename+"31.arff" ,(noFiles*30),(totalFiles-1)));	
						looper31.start();
				}
		        
		        
		        looper1.start();
		        looper2.start();
		        looper3.start();
		        looper4.start();
		        looper5.start();
		        looper6.start();
		        looper7.start();
		        looper8.start();
		        looper9.start();
		        looper10.start();
		        looper11.start();
		        looper12.start();
		        looper13.start();
		        looper14.start();
		        looper15.start();
		        looper16.start();
		        looper17.start();
		        looper18.start();
		        looper19.start();
		        looper20.start();
		        looper21.start();
		        looper22.start();
		        looper23.start();
		        looper24.start();
		        looper25.start();
		        looper26.start();
		        looper27.start();
		        looper28.start();
		        looper29.start();
		        looper30.start();
		    }
		    @Override
		    public void run() {
		      		   

		List test_binary_paths = Util.listBinaryFiles(test_dir);

		String text = "";
		//Writing the test arff
		Util.writeFile("@relation "+test_dir +"BinaryDeanonymizationAllFeatures"+"\n"+"\n",
		    			output_filename, true);
		Util.writeFile("@attribute instanceID_original {", output_filename, true);

		   	for(int j=0; j < test_binary_paths.size();j++)
			{
				File sourceFile = new File(test_binary_paths.get(j).toString());
				String fileName = sourceFile.getName() +"_"+ sourceFile.getParentFile().getParentFile().getName();
				Util.writeFile(fileName+",", output_filename, true);
				if ((j+1)==test_binary_paths.size()){
				Util.writeFile("}"+"\n", output_filename, true);
				}
			}

		   	
		   	//IG Features:
		   	
			String [] cfgSnowmanUnigrams ={ "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> & hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline goto address hexadecimal nodeNewline  ",
		   	 "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = <0:0> nodeNewline <0:0> = [<0:0>] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [<0:0>] nodeNewline goto address <0:0> nodeNewline  ",
		 "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> | <0:0>) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = [<0:0>] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [<0:0>] nodeNewline goto address <0:0> nodeNewline  ",
		    "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = zero_extend ~<0:0> nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline if ~<0:0> goto address hexadecimal else goto basic block hexadecimal nodeNewline  ",
		   	  "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= <0:0>) nodeNewline if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline  ",
		   	  "basicBlockhexadecimal   Address: hexadecimal nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = ([(<0:0> + hexadecimal)] + hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline goto basic block hexadecimal nodeNewline  ",
		   	};
		   	String [] 	ASTNodeBigramsTF ={ "\" Argument",
		    "\""+"U\0025"+"d\" Argument",
		    "\"input.txt\" Argument",
		    "\"output.txt\" Argument",
		    "\"r\" Argument",
		    "\"w\" Argument",
		    ""+"U\0025"+"d\" Argument",
		    "& T",
		    "& _CTOR_LIST__",
		    "* void",
		    "++ ExpressionStatement",
		    "-- IfStatement",
		    ".in\" Argument",
		    ".out\" Argument",
		    "0 break",
		    "137438953488L L",
		    "47 RelationalExpression",
		    "57 AndExpression",
		    ":: basic_ifstream",
		    ":: basic_ofstream",
		    "Argument \"",
		    "Argument \""+"U\0025"+"d\"",
		    "Argument \""+"U\0025"+"d",
		    "Argument \"input.txt\"",
		    "Argument \"output.txt\"",
		    "Argument \"r\"",
		    "Argument \"w\"",
		    "Argument stdin",
		    "Argument stdout",
		    "Callee ForInit",
		    "Callee basic_ifstream",
		    "Callee basic_ofstream",
		    "Callee f",
		    "Callee freopen",
		    "Callee getc",
		    "Callee getchar",
		    "Callee scanf",
		    "Callee solve",
		    "CompoundStatement DoStatement",
		    "EqualityExpression Condition",
		    "EqualityExpression _CTOR_LIST__",
		    "ExpressionStatement _CTOR_LIST__",
		    "IncDecOp IfStatement",
		    "T Callee",
		    "UnaryOp DoStatement",
		    "_CTOR_LIST__ AssignmentExpr",
		    "_CTOR_LIST__ IfStatement",
		    "_CTOR_LIST__ UnaryOp",
		    "_CTOR_LIST__ _CTOR_LIST__",
		    "_CTOR_LIST__ v2",
		    "_CTOR_LIST__ v3",
		    "basic_ifstream <",
		    "basic_ifstream ArgumentList",
		    "basic_ofstream <",
		    "basic_ofstream ArgumentList",
		    "e f",
		    "f Argument",
		    "f ArgumentList",
		    "freopen ArgumentList",
		    "getchar ExpressionStatement",
		    "i T",
		    "i t",
		    "in CallExpression",
		    "in Callee",
		    "in ExpressionStatement",
		    "open ArgumentList",
		    "out Callee",
		    "scanf ArgumentList",
		    "stdin CallExpression",
		    "stdin Callee",
		    "stdin ExpressionStatement",
		    "stdout CallExpression",
		    "stdout Callee",
		    "stdout ExpressionStatement",
		    "stdout std",
		    "v2 void",
		    "v3 void",
		    "void ExpressionStatement",
		    "void IdentifierDeclStatement",
		    "| 137438953488L"};
		   	
		   	
		   	
		   	String [] ASTNodeTypeAvgDep ={
		   	"\""+"U\0025"+"d\"",
		   	"\".\"",
		   	"\"input.txt\"",
		   "\"output.txt\"",
		    "\"r\"",
		    "\"w\"",
		    ""+"U\0025"+"",
		    ".in\"",
		    ".out\"",
		    "137438953488L",
		    "CT",
		   	"IncDecOp",
		   	"_CTOR_LIST__",
		   	"basic_ifstream",
		   	"basic_ofstream",
		   	"can",
		   	"din",
		   	"dout",
		   	"freopen",
		   	"getc",
		   	"getchar",
		   	"inp",
		   	"input",
		   	"open",
		   	"outp",
		   	"output",
		   	"sc",
		   	"scanf",
		   	"small",
		   	"sol",
		   	"solve",
		   	"stdin",
		   	"stdout",
		   	"temp",
		   	"tp",
		   	"tt",
		   	"tx",
		   	"~basic_ifstream",
		   	"~basic_ofstream"};
		   	
		   	String []  ASTNodeTypesTF={
		  "!=",
		  "\""+"U\0025"+"d\"",
		  "\"Case #\"",
		  "\"input.txt\"",
		  "\"output.txt\"",
		  "\"r\"",
		  "\"w\"",
		  "--",
		  "0xFFFF",
		  "137438953488L",
		  "47",
		  "57",
		  "<<",
		  "IncDecOp",
		  "InclusiveOrExpression",
		  "T",
		  "_CTOR_LIST__",
		  "__cdecl",
		  "__cxa_atexit",
		  "__static_initialization_and_destruction_0",
		  "_dso_handle",
		  "basic_ifstream",
		  "basic_ofstream",
		  "const char *",
		  "freopen",
		  "getchar",
		  "istream",
		  "ostream",
		  "printf",
		  "scanf",
		  "solve",
		  "std :: __ioinit",
		  "std :: char_traits",
		  "std :: ios_base :: Init *",
		  "std :: ios_base :: Init :: Init",
		  "std :: ios_base :: Init :: ~Init",
		  "stdin",
		  "stdout",
		  "void",
		  "while",
		  "|",
		  "~basic_ifstream",
		  "~basic_ofstream"};
		 	
		 	
		   	String [] ASTNodeTypesTFIDF={
		   "\""+"U\0025"+"d\"",
		   "\"Case #\"",
		   "\"input.txt\"",
		   "\"output.txt\"",
		   "\"r\"",
		   "\"w\"",
		   "0xFFFF",
		   "137438953488L",
		   "47",
		   "57",
		   "<<",
		   "IncDecOp",
		   "InclusiveOrExpression",
		   "_CTOR_LIST__",
		   "__cxa_atexit",
		   "__static_initialization_and_destruction_0",
		   "_dso_handle",
		   "basic_ifstream",
		   "basic_ofstream",
		   "freopen",
		   "getchar",
		   "istream",
		   "ostream",
		   "printf",
		   "scanf",
		   "solve",
		   "std :: __ioinit",
		   "std :: char_traits",
		   "std :: ios_base :: Init *",
		   "std :: ios_base :: Init :: Init",
		   "std :: ios_base :: Init :: ~Init",
		   "stdin",
		   "stdout",
		   "while",
		   "|",
		   "~basic_ifstream",
		   "~basic_ofstream"};
		   	String [] 	BjoernDisassemblyInstructionBigrams={" a.out",
		 " in",
		 " input.txt",
		 " output.txt",
		 "# @",
		 "-number number,hexadecimal,esp,+,=[number]",
		 ".out @",
		 "; apostrophesymbol/apostrophesymbol",
		 "; obj.__",
		 "; obj.__dso_handle",
		 "; reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv_number",
		 "; reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv_number",
		 "; section.LOADnumber",
		 "; sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv",
		 "; sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv",
		 "; sym.imp._ZNStnumberios_basenumberInitDnumberEv",
		 "; sym.imp._ZStnumberendlIcStnumberchar_traitsIcEERStnumberbasic_ostreamIT_Tnumber_ESnumber_",
		 "Case #",
		 "Case #"+"U\0025"+"d:",
		 "LEA obj.T",
		 "LEA obj._ZStLnumber__ioinit",
		 "LEA obj._ZStnumbercout__GLIBCXX_number.number",
		 "LEA obj.__",
		 "LEA obj.__dso_handle",
		 "LEA obj.s",
		 "LEA obj.st",
		 "LEA obj.stdin__GLIBC_number.number",
		 "LEA obj.stdout__GLIBC_number.number",
		 "LEA section.LOADnumber",
		 "LEA str.Case___d:",
		 "LEA str.a.out",
		 "LEA str.input.txt",
		 "LEA str.output.txt",
		 "LEA sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv",
		 "LEA sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv",
		 "LEA sym.imp._ZNStnumberios_basenumberInitDnumberEv",
		 "LEA sym.imp._ZStnumberendlIcStnumberchar_traitsIcEERStnumberbasic_ostreamIT_Tnumber_ESnumber_",
		 "U....... .D$.",
		 "U....... .D$..D$...$",
		 "[ebp +",
		 "[ebp-local_number_number] numberfbenumberfnumber",
		 "[ebp-local_number_number], hexadecimal",
		 "[hexadecimal:number]=-number number,hexadecimal,ebp,+,[number],==,$z,zf,=,$bnumber,cf,=,$p,pf,=,$s,sf,=",
		 "[hexadecimal:number]=-number number,hexadecimal,esp,+,=[number]",
		 "[hexadecimal:number]=hexadecimal number,esp,=[number]",
		 "[hexadecimal:number]=hexadecimal number,hexadecimal,esp,+,=[number]",
		 "[hexadecimal] anumber",
		 "a.out @",
		 "al numberdf",
		 "apostrophesymbol/apostrophesymbol number,hexadecimal,ebp,-,[number],==,$z,zf,=,$bnumber,cf,=,$p,pf,=,$s,sf,=",
		 "apostrophesymbolnumberapostrophesymbol number,hexadecimal,ebp,-,[number],==,$z,zf,=,$bnumber,cf,=,$p,pf,=,$s,sf,=",
		 "call sym._ZStorStnumber_Ios_OpenmodeS_",
		 "call sym._Znumber__static_initialization_and_destruction_numberii",
		 "call sym._Znumbersolvev",
		 "call sym.imp._ZNSirsERi",
		 "call sym.imp._ZNSolsEPFRSoS_E",
		 "call sym.imp._ZNSolsEi",
		 "call sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
		 "call sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv",
		 "call sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
		 "call sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEv",
		 "call sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv",
		 "call sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEnumberopenEPKcStnumber_Ios_Openmode",
		 "call sym.imp._ZNStnumberios_basenumberInitCnumberEv",
		 "call sym.imp._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc",
		 "call sym.imp.__cxa_atexit",
		 "call sym.imp.freopen",
		 "call sym.imp.getc",
		 "call sym.imp.getchar",
		 "call sym.imp.printf",
		 "call sym.imp.scanf",
		 "cnumberffffnumber ;",
		 "hexadecimal cnumberffffnumber",
		 "hexadecimal number,hexadecimal,ebp,+,[number],==,$z,zf,=,$bnumber,cf,=,$p,pf,=,$s,sf,=",
		 "hexadecimal numberdf",
		 "hexadecimal numberdfnumberf",
		 "hexadecimal numberdnumbercffffnumber",
		 "input.txt @",
		 "n @",
		 "number.in @",
		 "number.out @",
		 "number] numberfbenumber",
		 "numberdfnumberf ;",
		 "numberdnumbercffffnumber ;",
		 "numberfbenumberfnumber hexadecimal,ebp,-,[number],eax,=",
		 "obj.T ;",
		 "obj._ZStLnumber__ioinit ;",
		 "obj._ZStnumbercout__GLIBCXX_number.number ;",
		 "obj.__dso_handle ;",
		 "obj.__dso_handle number,hexadecimal,esp,+,=[number]",
		 "obj.stdin__GLIBC_number.number ;",
		 "obj.stdout__GLIBC_number.number ;",
		 "output.txt @",
		 "reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv_number hexadecimal,[],eip,=",
		 "reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv_number hexadecimal,[],eip,=",
		 "section.LOADnumber ;",
		 "section.LOADnumber hexadecimal,[number],eax,=",
		 "section.LOADnumber number,ebx,=",
		 "small.in @",
		 "small.out @",
		 "str.Case__ ;",
		 "str.a.out ;",
		 "str.input.txt ;",
		 "str.output.txt ;",
		 "sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv ;",
		 "sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv number,esp,=[number]",
		 "sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv ;",
		 "sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv number,esp,=[number]",
		 "sym.imp._ZNStnumberios_basenumberInitDnumberEv ;",
		 "sym.imp._ZNStnumberios_basenumberInitDnumberEv number,esp,=[number]",
		 "sym.imp._ZStnumberendlIcStnumberchar_traitsIcEERStnumberbasic_ostreamIT_Tnumber_ESnumber_ ;",
		 "sym.imp._ZStnumberendlIcStnumberchar_traitsIcEERStnumberbasic_ostreamIT_Tnumber_ESnumber_ number,hexadecimal,esp,+,=[number]",
		 "t @"};
		   	String [] BjoernDisassemblyInstructionTrigrams ={" Case #",
		   " Case #"+"U\0025"+"d:",
		   " U....... .D$.",
		   " U....... .D$..D$...$",
		   " a.out @",
		   " input.txt @",
		   " output.txt @",
		   "# @ hexadecimal",
		   ".out @ hexadecimal",
		   ";  a.out",
		   ";  in",
		   ";  input.txt",
		   ";  output.txt",
		   "; [hexadecimal:number]=-number number,hexadecimal,ebp,+,[number],==,$z,zf,=,$bnumber,cf,=,$p,pf,=,$s,sf,=",
		   "; [hexadecimal:number]=-number number,hexadecimal,esp,+,=[number]",
		   "; [hexadecimal:number]=hexadecimal number,esp,=[number]",
		   "; [hexadecimal:number]=hexadecimal number,hexadecimal,esp,+,=[number]",
		   "; apostrophesymbol/apostrophesymbol number,hexadecimal,ebp,-,[number],==,$z,zf,=,$bnumber,cf,=,$p,pf,=,$s,sf,=",
		   "; apostrophesymbolnumberapostrophesymbol number,hexadecimal,ebp,-,[number],==,$z,zf,=,$bnumber,cf,=,$p,pf,=,$s,sf,=",
		   "; obj.__dso_handle number,hexadecimal,esp,+,=[number]",
		   "; reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv_number hexadecimal,[],eip,=",
		   "; reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv_number hexadecimal,[],eip,=",
		   "; section.LOADnumber hexadecimal,[number],eax,=",
		   "; section.LOADnumber number,ebx,=",
		   "; sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv number,esp,=[number]",
		   "; sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv number,esp,=[number]",
		   "; sym.imp._ZNStnumberios_basenumberInitDnumberEv number,esp,=[number]",
		   "; sym.imp._ZStnumberendlIcStnumberchar_traitsIcEERStnumberbasic_ostreamIT_Tnumber_ESnumber_ number,hexadecimal,esp,+,=[number]",
		   "Case # @",
		   "LEA obj.T ;",
		   "LEA obj._ZStLnumber__ioinit ;",
		   "LEA obj._ZStnumbercout__GLIBCXX_number.number ;",
		   "LEA obj.__dso_handle ;",
		   "LEA obj.stdin__GLIBC_number.number ;",
		   "LEA obj.stdout__GLIBC_number.number ;",
		   "LEA section.LOADnumber ;",
		   "LEA str.Case__ ;",
		   "LEA str.a.out ;",
		   "LEA str.input.txt ;",
		   "LEA str.output.txt ;",
		   "LEA sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv ;",
		   "LEA sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv ;",
		   "LEA sym.imp._ZNStnumberios_basenumberInitDnumberEv ;",
		   "LEA sym.imp._ZStnumberendlIcStnumberchar_traitsIcEERStnumberbasic_ostreamIT_Tnumber_ESnumber_ ;",
		   "[ebp + hexadecimal]",
		   "[ebp + hexadecimal],",
		   "[ebp + number]",
		   "[ebp + number],",
		   "[ebp-local_number_number] numberfbenumberfnumber hexadecimal,ebp,-,[number],eax,=",
		   "[ebp-local_number_number], hexadecimal numberdfnumber",
		   "[ebp-local_number_number], hexadecimal numberdfnumberf",
		   "[hexadecimal:number]=-number LEA section.LOADnumber",
		   "[hexadecimal:number]=hexadecimal LEA obj._ZStnumbercout__GLIBCXX_number.number",
		   "[hexadecimal:number]=hexadecimal LEA obj.s",
		   "[hexadecimal:number]=hexadecimal LEA obj.st",
		   "[hexadecimal:number]=hexadecimal LEA obj.stdin__GLIBC_number.number",
		   "[hexadecimal:number]=hexadecimal LEA obj.stdout__GLIBC_number.number",
		   "[hexadecimal:number]=hexadecimal LEA str.Case___d:",
		   "[hexadecimal:number]=hexadecimal LEA str.a.out",
		   "[hexadecimal:number]=hexadecimal LEA str.input.txt",
		   "[hexadecimal:number]=hexadecimal LEA str.output.txt",
		   "[hexadecimal:number]=hexadecimal LEA sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv",
		   "[hexadecimal:number]=hexadecimal LEA sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv",
		   "[hexadecimal:number]=hexadecimal LEA sym.imp._ZNStnumberios_basenumberInitDnumberEv",
		   "[hexadecimal:number]=hexadecimal LEA sym.imp._ZStnumberendlIcStnumberchar_traitsIcEERStnumberbasic_ostreamIT_Tnumber_ESnumber_",
		   "[hexadecimal:number]=number ; apostrophesymbol/apostrophesymbol",
		   "[hexadecimal:number]=number LEA obj.__",
		   "[hexadecimal:number]=number LEA obj.__dso_handle",
		   "a.out @ hexadecimal",
		   "byte [ebp-local_number_number] numberfbenumberfnumber",
		   "byte [ebp-local_number_number], hexadecimal",
		   "cnumberffffnumber ; [hexadecimal:number]=-number",
		   "dword [ebp +",
		   "dword [hexadecimal] anumber",
		   "eax, byte [ebp-local_number_number]",
		   "eax, dword [hexadecimal]",
		   "hexadecimal cnumberffffnumber ;",
		   "hexadecimal numberdfnumber ;",
		   "hexadecimal numberdfnumberf ;",
		   "hexadecimal numberdnumbercffffnumber ;",
		   "hexadecimal], hexadecimal numberdnumbercffffnumber",
		   "input.txt @ hexadecimal",
		   "n @ hexadecimal",
		   "number numberdnumber ;",
		   "number.in @ hexadecimal",
		   "number.out @ hexadecimal",
		   "number], hexadecimal cnumberffffnumber",
		   "numberdfnumberf ; [hexadecimal:number]=number",
		   "numberdnumbercffffnumber ; [hexadecimal:number]=-number",
		   "numberf ; [hexadecimal:number]=number",
		   "obj.__dso_handle ; obj.__dso_handle",
		   "obj.stdin__GLIBC_number.number ; ",
		   "output.txt @ hexadecimal",
		   "section.LOADnumber ; section.LOADnumber",
		   "small.in @ hexadecimal",
		   "small.out @ hexadecimal",
		   "str.Case__ ; ",
		   "str.a.out ; ",
		   "str.input.txt ; ",
		   "str.output.txt ; ",
		   "sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv ; sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv",
		   "sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv ; sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv",
		   "sym.imp._ZNStnumberios_basenumberInitDnumberEv ; sym.imp._ZNStnumberios_basenumberInitDnumberEv",
		   "sym.imp._ZStnumberendlIcStnumberchar_traitsIcEERStnumberbasic_ostreamIT_Tnumber_ESnumber_ ; sym.imp._ZStnumberendlIcStnumberchar_traitsIcEERStnumberbasic_ostreamIT_Tnumber_ESnumber_",
		   "t @ hexadecimal"};
		   	String [] BjoernDisassemblyInstructionUnigrams={ "#",
		   	 "#"+"U\0025"+"d:",
		   	 ""+"U\0025"+"d",
		   	 ""+"U\0025"+"d:",
		   	 ".out",
		   	 "X",
		   	 "a.out",
		   	 "apostrophesymbol/apostrophesymbol",
		   	 "cnumberffffnumber",
		   	 "hexadecimal,[number],eax,=",
		   	 "input.txt",
		   	 "n",
		   	 "number.in",
		   	 "number.out",
		   	 "numberba",
		   	 "numberdnumbercf",
		   	 "numberdnumbercff",
		   	 "numberdnumbercffffnumber",
		   	 "numberfbenumberfnumber",
		   	 "numberffffnumber",
		   	 "obj.T",
		   	 "obj._ZLnumberM",
		   	 "obj._ZLnumberN",
		   	 "obj._ZLnumberep",
		   	 "obj._ZLnumbereps",
		   	 "obj._ZLnumbermaxn",
		   	 "obj._ZLnumberpi",
		   	 "obj._ZStLnumber__ioinit",
		   	 "obj._ZStnumbercin__GLIBCXX_number.number",
		   	 "obj._ZStnumbercout__GLIBCXX_number.number",
		   	 "obj.__",
		   	 "obj.__dso_handle",
		   	 "obj.s",
		   	 "obj.st",
		   	 "obj.stdin__GLIBC_number.number",
		   	 "obj.stdout__GLIBC_number.number",
		   	 "output.txt",
		   	 "reloc._ZNSirsERi_number",
		   	 "reloc._ZNSolsEPFRSoS_E_number",
		   	 "reloc._ZNSolsEi_number",
		   	 "reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number",
		   	 "reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv_number",
		   	 "reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number",
		   	 "reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEv_number",
		   	 "reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv_number",
		   	 "reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEnumberopenEPKcStnumber_Ios_Openmode_number",
		   	 "reloc._ZNStnumberios_basenumberInitCnumberEv_number",
		   	 "reloc._ZNStnumberios_basenumberInitDnumberEv_number",
		   	 "reloc._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc_number",
		   	 "reloc._ZStnumberendlIcStnumberchar_traitsIcEERStnumberbasic_ostreamIT_Tnumber_ESnumber__number",
		   	 "reloc.__cxa_atexit_number",
		   	 "reloc.freopen_number",
		   	 "reloc.getchar_number",
		   	 "reloc.printf_number",
		   	 "reloc.scanf_number",
		   	 "section.LOADnumber",
		   	 "small.in",
		   	 "small.out",
		   	 "solve",
		   	 "str.Case___d:",
		   	 "str.a.out",
		   	 "str.input.txt",
		   	 "str.output.txt",
		   	 "sym._ZStorStnumber_Ios_OpenmodeS_",
		   	 "sym._Znumber__static_initialization_and_destruction_numberii",
		   	 "sym._Znumbersolvev",
		   	 "sym.imp._ZNSirsERi",
		   	 "sym.imp._ZNSolsEPFRSoS_E",
		   	 "sym.imp._ZNSolsEi",
		   	 "sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
		   	 "sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv",
		   	 "sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
		   	 "sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEv",
		   	 "sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv",
		   	 "sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEnumberopenEPKcStnumber_Ios_Openmode",
		   	 "sym.imp._ZNStnumberios_basenumberInitCnumberEv",
		   	 "sym.imp._ZNStnumberios_basenumberInitDnumberEv",
		   	 "sym.imp._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc",
		   	 "sym.imp._ZStnumberendlIcStnumberchar_traitsIcEERStnumberbasic_ostreamIT_Tnumber_ESnumber_",
		   	 "sym.imp.__cxa_atexit",
		   	 "sym.imp.freopen",
		   	 "sym.imp.getc",
		   	 "sym.imp.getchar",
		   	 "sym.imp.printf",
		   	 "sym.imp.scanf",
		   	 "t"};
		   	String [] NDISASMDisassemblyInstructionBigrams ={"[dword hexadecimal]",
		   	"[dword hexadecimal],ah",
		   	"[dword hexadecimal],al",
		   	"[dword hexadecimal],bl",
		   	"[dword hexadecimal],bp",
		   	"[dword hexadecimal],byte",
		   	"[dword hexadecimal],cl",
		   	"[dword hexadecimal],dh",
		   	"[dword hexadecimal],dl",
		   	"[dword hexadecimal],eax",
		   	"[dword hexadecimal],es",
		   	"[dword hexadecimal],esp",
		   	"[dword hexadecimal],hexadecimal",
		   	"add [dword",
		   	"add [ecx],dh",
		   	"add [fs:ebx+hexadecimal],dh",
		   	"add [hexadecimal],al",
		   	"add [hexadecimal],bl",
		   	"add [hexadecimal],cl",
		   	"add [hexadecimal],dl",
		   	"add [hexadecimal],eax",
		   	"add [hexadecimal],esp",
		   	"add al,[dword",
		   	"add al,[hexadecimal]",
		   	"add cl,[dword",
		   	"add cl,[hexadecimal]",
		   	"al,[dword hexadecimal]",
		   	"anumber jnc",
		   	"anumber js",
		   	"arpl [cs:eax+hexadecimal],si",
		   	"arpl [dword",
		   	"arpl [eax+hexadecimal],si",
		   	"arpl [ebx+hexadecimal],dx",
		   	"arpl [ecx+ebp*number+hexadecimal],si",
		   	"arpl [ecx+hexadecimal],bp",
		   	"arpl [edi+ebp*number+hexadecimal],bp",
		   	"arpl [edi+ebx*number+hexadecimal],dx",
		   	"arpl [edi+hexadecimal],bx",
		   	"arpl [hexadecimal],bp",
		   	"bound ebx,[edi+hexadecimal]",
		   	"byte [dword",
		   	"byte [hexadecimal]",
		   	"byte [hexadecimal],hexadecimal",
		   	"call dword",
		   	"call far",
		   	"call hexadecimal",
		   	"call near",
		   	"cl,[dword hexadecimal]",
		   	"cmp [esi],dh",
		   	"cs jz",
		   	"cs outsd",
		   	"dword [dword",
		   	"dword [eax-hexadecimal]",
		   	"dword [ebp+hexadecimal],hexadecimal",
		   	"dword [ecx+eax]",
		   	"dword [hexadecimal]",
		   	"dword far",
		   	"dword hexadecimal:hexadecimal",
		   	"dword near",
		   	"eax,[dword hexadecimal]",
		   	"eax,[dword hexadecimal],byte",
		   	"eax,[eax+hexadecimal],dword hexadecimal",
		   	"eax,byte [ebp-hexadecimal]",
		   	"ebp,[cs:esi+hexadecimal],dword hexadecimal",
		   	"ebp,[dword hexadecimal]",
		   	"ebp,[ebx+hexadecimal],dword hexadecimal",
		   	"ebp,[edi+hexadecimal],dword hexadecimal",
		   	"ebp,[fs:esi+hexadecimal],dword hexadecimal",
		   	"ecx,[dword hexadecimal]",
		   	"ecx,[ecx],dword hexadecimal",
		   	"esi,[ebx+eax*number+hexadecimal],dword hexadecimal",
		   	"esi,[ebx+esi*number+hexadecimal],dword hexadecimal",
		   	"esi,[edx+hexadecimal],dword hexadecimal",
		   	"esi,[esp+eax*number+hexadecimal],dword hexadecimal",
		   	"fs popad",
		   	"gs anumber",
		   	"gs jna",
		   	"gs outsd",
		   	"gs popad",
		   	"gs xor",
		   	"imul eax,[dword",
		   	"imul eax,[eax+hexadecimal],dword",
		   	"imul ebp,[cs:esi+hexadecimal],dword",
		   	"imul ebp,[ebx+hexadecimal],dword",
		   	"imul ebp,[edi+hexadecimal],dword",
		   	"imul ebp,[fs:esi+hexadecimal],dword",
		   	"imul ecx,[ecx],dword",
		   	"imul esi,[ebx+eax*number+hexadecimal],dword",
		   	"imul esi,[ebx+esi*number+hexadecimal],dword",
		   	"imul esi,[edx+hexadecimal],dword",
		   	"imul esi,[esp+eax*number+hexadecimal],dword",
		   	"inc ax",
		   	"jl dword",
		   	"jmp dword",
		   	"jmp far",
		   	"jmp hexadecimal",
		   	"jmp near",
		   	"jng dword",
		   	"jng near",
		   	"jnz dword",
		   	"lea eax,[ebx+hexadecimal]",
		   	"lea eax,[ebx-hexadecimal]",
		   	"lea edi,[ebx+hexadecimal]",
		   	"lea edi,[ebx-hexadecimal]",
		   	"mov ecx,[dword",
		   	"mov ecx,[hexadecimal]",
		   	"mov edx,[ebx+hexadecimal]",
		   	"mov edx,[ebx-hexadecimal]",
		   	"near [dword",
		   	"near [ebx+esi*number+hexadecimal]",
		   	"near [ebx+esi*number-hexadecimal]",
		   	"near [hexadecimal]",
		   	"near hexadecimal",
		   	"nop word",
		   	"onumber add",
		   	"onumber jnc",
		   	"onumber nop",
		   	"or [dword",
		   	"or [ecx+hexadecimal],ch",
		   	"or [esi+hexadecimal],ecx",
		   	"or ebp,[esi]",
		   	"or ebp,[hexadecimal]",
		   	"test [eax],al",
		   	"wait add",
		   	"word [cs:eax+eax+hexadecimal]",
		   	"word [dword",
		   	"word [hexadecimal]",
		   	"word hexadecimal:hexadecimal",
		   	"xchg ax,ax",
		   	"xor [dword",
		   	"xor [ebx+hexadecimal],esp",
		   	"xor [ecx+hexadecimal],ch",
		   	"xor [esi+hexadecimal],ecx",
		   	"xor ch,[esi]",
		   	"xor ebp,[dword",
		   	"xor ebp,[esi]",
		   	"xor ebp,[hexadecimal]",
		   	"xor esp,[edx+hexadecimal]"};
		   	String [] NDISASMDisassemblyInstructionTrigrams ={"add [dword hexadecimal],ah",
		   	"add [dword hexadecimal],al",
		   	"add [dword hexadecimal],bl",
		   	"add [dword hexadecimal],cl",
		   	"add [dword hexadecimal],dh",
		   	"add [dword hexadecimal],dl",
		   	"add [dword hexadecimal],eax",
		   	"add [dword hexadecimal],esp",
		   	"add al,[dword hexadecimal]",
		   	"add cl,[dword hexadecimal]",
		   	"anumber jnc hexadecimal",
		   	"anumber js hexadecimal",
		   	"arpl [dword hexadecimal],bp",
		   	"byte [dword hexadecimal]",
		   	"byte [dword hexadecimal],hexadecimal",
		   	"call dword far",
		   	"call dword hexadecimal",
		   	"call dword hexadecimal:hexadecimal",
		   	"call dword near",
		   	"call far [eax+eax]",
		   	"call far [esi]",
		   	"call near [eax*number+hexadecimal]",
		   	"call near [ebx+esi*number+hexadecimal]",
		   	"call near [ebx]",
		   	"call near [ecx]",
		   	"call near [edx]",
		   	"cmp byte [dword",
		   	"cmp byte [hexadecimal],hexadecimal",
		   	"cmp dword [ebp+hexadecimal],hexadecimal",
		   	"cs jz hexadecimal",
		   	"dec dword [ecx+eax]",
		   	"dec dword [ecx]",
		   	"dword [dword hexadecimal]",
		   	"dword far [eax+eax]",
		   	"dword far [eax+hexadecimal]",
		   	"dword far [eax]",
		   	"dword far [edi+hexadecimal]",
		   	"dword far [edi-hexadecimal]",
		   	"dword far [edx]",
		   	"dword far [esi+hexadecimal]",
		   	"dword far [esi]",
		   	"dword near [dword",
		   	"dword near [eax*number+hexadecimal]",
		   	"dword near [eax+hexadecimal]",
		   	"dword near [eax]",
		   	"dword near [ebx+esi*number-hexadecimal]",
		   	"dword near [ebx]",
		   	"dword near [ecx]",
		   	"dword near [edx]",
		   	"gs anumber jnc",
		   	"gs jna hexadecimal",
		   	"gs xor al,hexadecimal",
		   	"imul eax,[dword hexadecimal],byte",
		   	"imul eax,[eax+hexadecimal],dword hexadecimal",
		   	"imul ebp,[cs:esi+hexadecimal],dword hexadecimal",
		   	"imul ebp,[ebx+hexadecimal],dword hexadecimal",
		   	"imul ebp,[edi+hexadecimal],dword hexadecimal",
		   	"imul ebp,[fs:esi+hexadecimal],dword hexadecimal",
		   	"imul ecx,[ecx],dword hexadecimal",
		   	"imul esi,[ebx+eax*number+hexadecimal],dword hexadecimal",
		   	"imul esi,[ebx+esi*number+hexadecimal],dword hexadecimal",
		   	"imul esi,[edx+hexadecimal],dword hexadecimal",
		   	"imul esi,[esp+eax*number+hexadecimal],dword hexadecimal",
		   	"inc dword [dword",
		   	"inc dword [ecx+eax]",
		   	"inc dword [edi]",
		   	"inc dword [esi]",
		   	"jl dword hexadecimal",
		   	"jmp dword far",
		   	"jmp dword hexadecimal",
		   	"jmp dword hexadecimal:hexadecimal",
		   	"jmp dword near",
		   	"jmp far [edi+hexadecimal]",
		   	"jmp far [esi+hexadecimal]",
		   	"jmp near [hexadecimal]",
		   	"jng dword hexadecimal",
		   	"jng near hexadecimal",
		   	"jnz dword hexadecimal",
		   	"mov byte [dword",
		   	"mov byte [hexadecimal],hexadecimal",
		   	"mov ecx,[dword hexadecimal]",
		   	"movsx eax,byte [ebp-hexadecimal]",
		   	"near [dword hexadecimal]",
		   	"nop word [cs:eax+eax+hexadecimal]",
		   	"onumber jnc hexadecimal",
		   	"push dword [dword",
		   	"push dword [hexadecimal]",
		   	"word [dword hexadecimal]",
		   	"xor [dword hexadecimal],esi",
		   	"xor ebp,[dword hexadecimal]"};
		   	String [] NDISASMDisassemblyInstructionUnigrams={ "[cs:eax+eax+hexadecimal]",
		   	 "[cs:eax+hexadecimal],si",
		   	 "[dword",
		   	 "[eax+hexadecimal],si",
		   	 "[ebx+esi*number+hexadecimal]",
		   	 "[ebx+esi*number-hexadecimal]",
		   	 "[ebx+hexadecimal],dx",
		   	 "[ebx+hexadecimal],es",
		   	 "[ebx+hexadecimal],esp",
		   	 "[ebx-hexadecimal]",
		   	 "[ecx+ebp*number+hexadecimal],si",
		   	 "[ecx+hexadecimal],bp",
		   	 "[edi+ebp*number+hexadecimal],bp",
		   	 "[edi+ebx*number+hexadecimal],dx",
		   	 "[edi+hexadecimal],bx",
		   	 "[esp+eax*number+hexadecimal]",
		   	 "[fs:ebx+hexadecimal],dh",
		   	 "[hexadecimal]",
		   	 "[hexadecimal],al",
		   	 "[hexadecimal],bl",
		   	 "[hexadecimal],bp",
		   	 "[hexadecimal],cl",
		   	 "[hexadecimal],dl",
		   	 "[hexadecimal],es",
		   	 "[hexadecimal],esp",
		   	 "[hexadecimal],hexadecimal",
		   	 "al,[dword",
		   	 "ax,ax",
		   	 "ch,[esi]",
		   	 "cl,[dword",
		   	 "cl,[hexadecimal]",
		   	 "eax,[dword",
		   	 "eax,[eax+hexadecimal],dword",
		   	 "eax,[ebx+hexadecimal]",
		   	 "eax,[ebx-hexadecimal]",
		   	 "ebp,[cs:esi+hexadecimal],dword",
		   	 "ebp,[dword",
		   	 "ebp,[ebx+hexadecimal],dword",
		   	 "ebp,[edi+hexadecimal]",
		   	 "ebp,[edi+hexadecimal],dword",
		   	 "ebp,[esi]",
		   	 "ebp,[fs:esi+hexadecimal],dword",
		   	 "ebp,[hexadecimal]",
		   	 "ecx,[dword",
		   	 "ecx,[ecx]",
		   	 "ecx,[ecx],dword",
		   	 "ecx,[hexadecimal]",
		   	 "edi,[ebx+hexadecimal]",
		   	 "edi,[ebx-hexadecimal]",
		   	 "edx,[ebx+hexadecimal]",
		   	 "edx,[ebx-hexadecimal]",
		   	 "esi,[ebx+eax*number+hexadecimal],dword",
		   	 "esi,[ebx+esi*number+hexadecimal],dword",
		   	 "esi,[edx+hexadecimal]",
		   	 "esi,[edx+hexadecimal],dword",
		   	 "esi,[esp+eax*number+hexadecimal],dword",
		   	 "esp,[edx+hexadecimal]",
		   	 "hexadecimal],dx",
		   	 "hexadecimal],esp",
		   	 "onumber",
		   	 "popad",
		   	 "popfd",
		   	 "pushad",
		   	 "pushfd",};
		   	String [] NDISASMDisassemblyLineBigrams ={ "add [dword hexadecimal],al add [eax],al",
		    "add [dword hexadecimal],al add [ecx],al",
		    "add [dword hexadecimal],al cmp cl,[ebx]",
		    "add [dword hexadecimal],bl add ebx,edi",
		    "add [dword hexadecimal],cl add [eax],al",
		    "add [dword hexadecimal],cl fadd qword [eax]",
		    "add [dword hexadecimal],dl add [eax],al",
		    "add [dword hexadecimal],eax or [esi],al",
		    "add [dword hexadecimal],esp push cs",
		    "add [eax+hexadecimal],al add al,hexadecimal",
		    "add [eax+hexadecimal],dh imul ebp,[esi+hexadecimal],dword hexadecimal",
		    "add [eax],al add [dword hexadecimal],al",
		    "add [eax],al add [dword hexadecimal],cl",
		    "add [eax],al add [dword hexadecimal],dl",
		    "add [eax],al add [dword hexadecimal],eax",
		    "add [eax],al add [hexadecimal],al",
		    "add [eax],al add [hexadecimal],cl",
		    "add [eax],al add [hexadecimal],eax",
		    "add [eax],al call dword hexadecimal",
		    "add [eax],al jmp dword hexadecimal",
		    "add [eax],al jmp dword near [dword hexadecimal]",
		    "add [eax],al jmp hexadecimal",
		    "add [eax],al jmp near [hexadecimal]",
		    "add [eax],al popfd",
		    "add [eax],al push dword [dword hexadecimal]",
		    "add [eax],al push ebp",
		    "add [eax],al pushad",
		    "add [eax],al pushfd",
		    "add [ebx+hexadecimal],dh imul ebp,[fs:esi+hexadecimal],dword hexadecimal",
		    "add [ebx+hexadecimal],dh popa",
		    "add [ebx+hexadecimal],dh popad",
		    "add [ecx+hexadecimal],ah popad",
		    "add [ecx],edx add [dword hexadecimal],esp",
		    "add [ecx],edx add [hexadecimal],esp",
		    "add [edi+hexadecimal],bl anumber js hexadecimal",
		    "add [edi+hexadecimal],bl dec esp",
		    "add [edi+hexadecimal],bl js hexadecimal",
		    "add [edi+hexadecimal],dh outsd",
		    "add [edx],al add [dword hexadecimal],bl",
		    "add [edx],al add [hexadecimal],bl",
		    "add [edx],al add al,[dword hexadecimal]",
		    "add [edx],al add al,[hexadecimal]",
		    "add [edx],bh and [eax],al",
		    "add [esi+hexadecimal],ah gs outsd",
		    "add [esi+hexadecimal],ah popad",
		    "add [fs:ebx+hexadecimal],dh fs outsd",
		    "add [fs:edi+hexadecimal],bl dec esi",
		    "add [hexadecimal],al add [eax],al",
		    "add [hexadecimal],al add [ecx],al",
		    "add [hexadecimal],al cmp cl,[ebx]",
		    "add [hexadecimal],bl add ebx,edi",
		    "add [hexadecimal],cl fadd qword [eax]",
		    "add [hexadecimal],eax or [esi],al",
		    "add [hexadecimal],esp push cs",
		    "add [ss:eax],al add [dword hexadecimal],al",
		    "add [ss:eax],al add [hexadecimal],al",
		    "add [ss:edi+hexadecimal],bl dec esi",
		    "add al,[dword hexadecimal] add eax,[eax+hexadecimal]",
		    "add al,[eax] add eax,hexadecimal",
		    "add al,[eax] and eax,hexadecimal",
		    "add al,[eax] inc ebx",
		    "add al,[eax] jc hexadecimal",
		    "add al,[hexadecimal] add eax,[eax+hexadecimal]",
		    "add cl,[dword hexadecimal] add [eax],al",
		    "add cl,[dword hexadecimal] xchg al,[edi+eax*number]",
		    "add cl,[hexadecimal] add [eax],al",
		    "add cl,[hexadecimal] xchg al,[edi+eax*number]",
		    "add ebx,hexadecimal call dword hexadecimal",
		    "add ebx,hexadecimal call hexadecimal",
		    "add ebx,hexadecimal mov edx,[ebx+hexadecimal]",
		    "add ebx,hexadecimal mov edx,[ebx-hexadecimal]",
		    "and [ebx],ah add [edx],bh",
		    "and [ebx],ah and eax,hexadecimal",
		    "and [fs:ebx+hexadecimal],ah popad",
		    "anumber js hexadecimal pop edi",
		    "arpl [cs:eax+hexadecimal],si add [ebp+hexadecimal],ah",
		    "arpl [cs:eax+hexadecimal],si add [edi+hexadecimal],bl",
		    "arpl [dword hexadecimal],bp insb",
		    "arpl [eax+hexadecimal],bp jc hexadecimal",
		    "arpl [eax+hexadecimal],si add [edi+hexadecimal],bl",
		    "arpl [ebx+hexadecimal],dx xor [ebx],esi",
		    "arpl [ebx+hexadecimal],dx xor [ecx],esi",
		    "arpl [ecx+ebp*number+hexadecimal],si outsb",
		    "arpl [ecx+hexadecimal],bp add [edi+hexadecimal],bl",
		    "arpl [ecx+hexadecimal],bp inc eax",
		    "arpl [edi+ebx*number+hexadecimal],dx push ebx",
		    "arpl [edi+hexadecimal],bp jz hexadecimal",
		    "arpl [edi+hexadecimal],bx jnc hexadecimal",
		    "arpl [edi+hexadecimal],bx onumber jnc hexadecimal",
		    "arpl [edi+hexadecimal],bx outsb",
		    "arpl [hexadecimal],bp insb",
		    "bound ebx,[edi+hexadecimal] pop edi",
		    "call dword far [eax+eax] add [eax],al",
		    "call dword far [esi] add [eax],al",
		    "call dword hexadecimal add [eax],al",
		    "call dword hexadecimal add ebx,hexadecimal",
		    "call dword hexadecimal add esp,byte +hexadecimal",
		    "call dword hexadecimal call dword hexadecimal",
		    "call dword hexadecimal hlt",
		    "call dword hexadecimal inc dword [esp+hexadecimal]",
		    "call dword hexadecimal jmp dword hexadecimal",
		    "call dword hexadecimal jmp short hexadecimal",
		    "call dword hexadecimal lea edi,[ebx-hexadecimal]",
		    "call dword hexadecimal lea esp,[ebp-hexadecimal]",
		    "call dword hexadecimal leave",
		    "call dword hexadecimal mov [ebp-hexadecimal],eax",
		    "call dword hexadecimal mov [esp+hexadecimal],eax",
		    "call dword hexadecimal mov [esp+hexadecimal],ebx",
		    "call dword hexadecimal mov byte [dword hexadecimal],hexadecimal",
		    "call dword hexadecimal mov dword [ebp-hexadecimal],hexadecimal",
		    "call dword hexadecimal mov dword [esp+hexadecimal],hexadecimal",
		    "call dword hexadecimal mov eax,[ebp+hexadecimal]",
		    "call dword hexadecimal mov eax,[ebp-hexadecimal]",
		    "call dword hexadecimal mov eax,[esp+hexadecimal]",
		    "call dword hexadecimal mov eax,[hexadecimal]",
		    "call dword hexadecimal mov eax,ebx",
		    "call dword hexadecimal mov ebx,[ebp-hexadecimal]",
		    "call dword hexadecimal mov ebx,eax",
		    "call dword hexadecimal mov edx,[ebp+hexadecimal]",
		    "call dword hexadecimal pop eax",
		    "call dword hexadecimal pop ebx",
		    "call dword hexadecimal pop ecx",
		    "call dword hexadecimal sub esp,byte +hexadecimal",
		    "call dword near [eax*number+hexadecimal] mov eax,[hexadecimal]",
		    "call dword near [ebx+esi*number-hexadecimal] add esi,byte +hexadecimal",
		    "call dword near [ebx] add [eax],al",
		    "call dword near [ecx] add [eax],eax",
		    "call far [eax+eax] add [eax],al",
		    "call far [esi] add [eax],al",
		    "call hexadecimal add ebx,hexadecimal",
		    "call hexadecimal call hexadecimal",
		    "call hexadecimal hlt",
		    "call hexadecimal inc dword [esp+hexadecimal]",
		    "call hexadecimal jmp short hexadecimal",
		    "call hexadecimal lea eax,[esp+hexadecimal]",
		    "call hexadecimal lea edi,[ebx+hexadecimal]",
		    "call hexadecimal leave",
		    "call hexadecimal mov byte [hexadecimal],hexadecimal",
		    "call hexadecimal mov dword [esp+hexadecimal],hexadecimal",
		    "call hexadecimal mov eax,[hexadecimal]",
		    "call hexadecimal pop eax",
		    "call hexadecimal pop ebx",
		    "call hexadecimal pop ecx",
		    "call near [eax*number+hexadecimal] mov eax,[hexadecimal]",
		    "call near [ebx+esi*number+hexadecimal] add esi,byte +hexadecimal",
		    "call near [ebx] add [eax],al",
		    "call near [ebx] add [eax],eax",
		    "call near [ecx] add [eax],eax",
		    "call near [edx] add [eax],eax",
		    "cmp [edi+hexadecimal],bl imul ebp,[edi+hexadecimal],dword hexadecimal",
		    "cmp [esi],dh pop edi",
		    "cmp [esp+hexadecimal],eax jng dword hexadecimal",
		    "cmp [esp+hexadecimal],eax jng near hexadecimal",
		    "cmp byte [dword hexadecimal],hexadecimal jnz hexadecimal",
		    "cmp byte [ebp-hexadecimal],hexadecimal jg hexadecimal",
		    "cmp byte [ebp-hexadecimal],hexadecimal jng hexadecimal",
		    "cmp byte [hexadecimal],hexadecimal jnz hexadecimal",
		    "cs jz hexadecimal jz hexadecimal",
		    "cs outsd jnz hexadecimal",
		    "db hexadecimal call dword far [eax+eax]",
		    "db hexadecimal jmp dword far [edi+hexadecimal]",
		    "db hexadecimal jmp dword far [edi-hexadecimal]",
		    "db hexadecimal jmp dword near [eax+hexadecimal]",
		    "db hexadecimal jmp far [edi+hexadecimal]",
		    "db hexadecimal pop ds",
		    "dec dword [eax] add [eax],eax",
		    "dec dword [ecx+eax] add [eax],al",
		    "dec dword [ecx] add [eax],eax",
		    "dec dword [edi] add [eax],eax",
		    "dec dword [edx] add [eax],eax",
		    "dec ebx arpl [ebx+hexadecimal],dx",
		    "dec ecx arpl [ebx+hexadecimal],dx",
		    "dec ecx arpl [edi+ebx*number+hexadecimal],dx",
		    "dec ecx outsd",
		    "dec edi add [eax],eax",
		    "dec edi inc edx",
		    "dec edi jo hexadecimal",
		    "dec esp dec edi",
		    "dec esp pop edi",
		    "dec esp xor [esi+hexadecimal],ecx",
		    "dec esp xor al,hexadecimal",
		    "dec esp xor dh,[eax+hexadecimal]",
		    "dec esp xor esp,[ebp+hexadecimal]",
		    "fs insb dec ecx",
		    "fs jns hexadecimal popad",
		    "fs outsd jnz hexadecimal",
		    "fs pop edi gs jnc hexadecimal",
		    "fs popa jz hexadecimal",
		    "fs popad jz hexadecimal",
		    "gs anumber jnc hexadecimal bound esi,[gs:ebp+hexadecimal]",
		    "gs jna hexadecimal pop edi",
		    "gs jnc hexadecimal bound esi,[gs:ebp+hexadecimal]",
		    "gs outsb add [fs:ebx+hexadecimal],dh",
		    "gs outsb fs insb",
		    "gs outsd jo hexadecimal",
		    "gs popa jnz hexadecimal",
		    "gs popad jnz hexadecimal",
		    "gs push ebx pop edi",
		    "gs push esp popad",
		    "gs xor al,hexadecimal outsb",
		    "imul eax,[eax+hexadecimal],dword hexadecimal inc ebx",
		    "imul ebp,[cs:esi+hexadecimal],dword hexadecimal outsd",
		    "imul ebp,[edi+hexadecimal],dword hexadecimal gs xor al,hexadecimal",
		    "imul ebp,[edi+hexadecimal],dword hexadecimal pop edi",
		    "imul ebp,[esi+hexadecimal],dword hexadecimal dec esp",
		    "imul ebp,[fs:esi+hexadecimal],dword hexadecimal add [edi+hexadecimal],bl",
		    "imul ebp,[fs:esi+hexadecimal],dword hexadecimal inc edx",
		    "imul ebp,[fs:esi+hexadecimal],dword hexadecimal jz hexadecimal",
		    "imul ebp,[fs:esi+hexadecimal],dword hexadecimal popa",
		    "imul esi,[ebx+eax*number+hexadecimal],dword hexadecimal dec edx",
		    "imul esi,[ebx+eax*number+hexadecimal],dword hexadecimal inc edi",
		    "imul esi,[ebx+esi*number+hexadecimal],dword hexadecimal push ebx",
		    "imul esi,[ebx+esi*number+hexadecimal],dword hexadecimal xor [ebp+hexadecimal],eax",
		    "imul esi,[ecx+ebp*number+hexadecimal],dword hexadecimal jz hexadecimal",
		    "imul esi,[ecx+edi*number+hexadecimal],dword hexadecimal dec edx",
		    "imul esi,[edx+hexadecimal],dword hexadecimal inc eax",
		    "imul esi,[edx+hexadecimal],dword hexadecimal pop edi",
		    "imul esi,[esp+eax*number+hexadecimal],dword hexadecimal inc edi",
		    "imul esi,[gs:bp+di+hexadecimal],dword hexadecimal popad",
		    "inc ax inc eax",
		    "inc dword [ecx+eax] add [eax],al",
		    "inc dword [edi] add [eax],eax",
		    "inc dword [esi] add [eax],eax",
		    "inc ebp add [eax],eax",
		    "inc ebp inc eax",
		    "inc ebx pop eax",
		    "inc ebx popad",
		    "inc ecx dec esp",
		    "inc edx inc ecx",
		    "inc esi add [eax],eax",
		    "inc esi push edx",
		    "insb arpl [cs:eax+hexadecimal],si",
		    "insb cs outsd",
		    "insb dec ecx",
		    "insb imul ebp,[cs:esi+hexadecimal],dword hexadecimal",
		    "insb jnc hexadecimal",
		    "insb sub eax,hexadecimal",
		    "insd arpl [cs:eax+hexadecimal],si",
		    "insd dec ecx",
		    "insd popad",
		    "intnumber call dword far [esi]",
		    "intnumber call dword near [ebx]",
		    "intnumber call dword near [ecx]",
		    "intnumber call far [esi]",
		    "intnumber call near [eax]",
		    "intnumber call near [ebx]",
		    "intnumber call near [ecx]",
		    "intnumber call near [edx]",
		    "intnumber dec dword [eax]",
		    "intnumber dec dword [ecx+eax]",
		    "intnumber dec dword [ecx]",
		    "intnumber dec dword [edi]",
		    "intnumber dec dword [edx]",
		    "intnumber dec dword [hexadecimal]",
		    "intnumber inc dword [ecx+eax]",
		    "intnumber inc dword [edi]",
		    "intnumber inc dword [esi]",
		    "intnumber jmp dword far [esi+hexadecimal]",
		    "intnumber jmp far [esi+hexadecimal]",
		    "jc hexadecimal arpl [eax+hexadecimal],si",
		    "jc hexadecimal arpl [ecx+ebp*number+hexadecimal],si",
		    "jc hexadecimal call dword hexadecimal",
		    "jc hexadecimal call hexadecimal",
		    "jc hexadecimal fs popad",
		    "jc hexadecimal imul ebp,[esi+hexadecimal],dword hexadecimal",
		    "jc hexadecimal jz hexadecimal",
		    "jc hexadecimal popad",
		    "jl dword hexadecimal mov eax,hexadecimal",
		    "jl near hexadecimal mov eax,hexadecimal",
		    "jmp dword far [edi+hexadecimal] add [eax],al",
		    "jmp dword hexadecimal add [eax],al",
		    "jmp dword hexadecimal jmp dword hexadecimal",
		    "jmp dword hexadecimal jmp dword near [dword hexadecimal]",
		    "jmp dword hexadecimal mov dword [esp+hexadecimal],hexadecimal",
		    "jmp dword hexadecimal xchg ax,ax",
		    "jmp dword hexadecimal xor ebp,ebp",
		    "jmp dword near [dword hexadecimal] add [eax],al",
		    "jmp dword near [dword hexadecimal] push dword hexadecimal",
		    "jmp far [edi+hexadecimal] add [eax],al",
		    "jmp hexadecimal add [eax],al",
		    "jmp hexadecimal jmp hexadecimal",
		    "jmp hexadecimal jmp near [hexadecimal]",
		    "jmp hexadecimal onumber nop",
		    "jmp hexadecimal xor ebp,ebp",
		    "jmp near [hexadecimal] add [eax],al",
		    "jmp near [hexadecimal] push dword hexadecimal",
		    "jnc hexadecimal arpl [cs:eax+hexadecimal],si",
		    "jnc hexadecimal arpl [edi+hexadecimal],bx",
		    "jnc hexadecimal bound ebx,[edi+hexadecimal]",
		    "jnc hexadecimal dec edi",
		    "jnc hexadecimal fs outsd",
		    "jnc hexadecimal imul eax,[eax+hexadecimal],dword hexadecimal",
		    "jnc hexadecimal imul eax,[eax],dword hexadecimal",
		    "jnc hexadecimal onumber nop",
		    "jnc hexadecimal popad",
		    "jnc hexadecimal push eax",
		    "jnc hexadecimal push ebx",
		    "jnc hexadecimal xchg ax,ax",
		    "jng dword hexadecimal mov eax,hexadecimal",
		    "jng hexadecimal cmp byte [ebp-hexadecimal],hexadecimal",
		    "jng hexadecimal mov eax,hexadecimal",
		    "jng near hexadecimal mov eax,hexadecimal",
		    "jns hexadecimal arpl [cs:eax+hexadecimal],si",
		    "jns hexadecimal popad",
		    "jnz dword hexadecimal mov eax,hexadecimal",
		    "jnz hexadecimal add [dword hexadecimal],ah",
		    "jnz hexadecimal add [ebx+hexadecimal],al",
		    "jnz hexadecimal add [ecx],dh",
		    "jnz hexadecimal add [edx],dh",
		    "jnz hexadecimal add [esi+hexadecimal],ah",
		    "jnz hexadecimal add [hexadecimal],ah",
		    "jnz hexadecimal cs jz hexadecimal",
		    "jnz hexadecimal gs popad",
		    "jnz hexadecimal inc eax",
		    "jnz hexadecimal jo hexadecimal",
		    "jnz near hexadecimal mov eax,hexadecimal",
		    "jo hexadecimal outsb",
		    "jo hexadecimal xor [esi],ch",
		    "js hexadecimal add [edi+hexadecimal],dh",
		    "js hexadecimal jz hexadecimal",
		    "jz hexadecimal and eax,hexadecimal",
		    "jz hexadecimal arpl [ecx+hexadecimal],bp",
		    "jz hexadecimal arpl [edi+hexadecimal],bp",
		    "jz hexadecimal arpl [edi+hexadecimal],bx",
		    "jz hexadecimal call dword hexadecimal",
		    "jz hexadecimal call hexadecimal",
		    "jz hexadecimal cmp [edi+hexadecimal],bl",
		    "jz hexadecimal fs popad",
		    "jz hexadecimal gs outsb",
		    "jz hexadecimal imul ebp,[edi+hexadecimal],dword hexadecimal",
		    "jz hexadecimal inc ebx",
		    "jz hexadecimal js hexadecimal",
		    "jz hexadecimal outsd",
		    "jz hexadecimal popa",
		    "jz hexadecimal popad",
		    "jz hexadecimal xor [ebx+hexadecimal],esp",
		    "jz hexadecimal xor al,hexadecimal",
		    "jz hexadecimal xor esp,[edx+hexadecimal]",
		    "lea eax,[ebx+hexadecimal] sub edi,eax",
		    "lea eax,[ebx-hexadecimal] sub edi,eax",
		    "lea ebx,[eax+hexadecimal] mov dword [esp+hexadecimal],hexadecimal",
		    "lea edi,[ebx+hexadecimal] lea eax,[ebx+hexadecimal]",
		    "lea edi,[ebx-hexadecimal] lea eax,[ebx-hexadecimal]",
		    "lea edi,[edi+hexadecimal] cmp byte [dword hexadecimal],hexadecimal",
		    "lea edi,[edi+hexadecimal] cmp byte [hexadecimal],hexadecimal",
		    "lea edx,[eax-hexadecimal] mov [esp+hexadecimal],edx",
		    "leave add [eax+hexadecimal],al",
		    "leave jmp dword hexadecimal",
		    "leave jmp hexadecimal",
		    "mov [ebp-hexadecimal],al cmp byte [ebp-hexadecimal],hexadecimal",
		    "mov [esp+hexadecimal],eax mov dword [esp+hexadecimal],hexadecimal",
		    "mov [esp+hexadecimal],edx test eax,eax",
		    "mov [esp],eax call dword hexadecimal",
		    "mov [esp],eax call dword near [ebx+esi*number-hexadecimal]",
		    "mov [esp],eax call hexadecimal",
		    "mov [esp],eax call near [ebx+esi*number+hexadecimal]",
		    "mov [esp],edx call dword hexadecimal",
		    "mov [hexadecimal],eax call dword near [eax*number+hexadecimal]",
		    "mov [hexadecimal],eax call near [eax*number+hexadecimal]",
		    "mov byte [dword hexadecimal],hexadecimal pop eax",
		    "mov byte [hexadecimal],hexadecimal pop eax",
		    "mov dword [esp+hexadecimal],hexadecimal jmp dword hexadecimal",
		    "mov dword [esp+hexadecimal],hexadecimal jmp hexadecimal",
		    "mov dword [esp+hexadecimal],hexadecimal mov [esp],eax",
		    "mov dword [esp],hexadecimal call dword hexadecimal",
		    "mov dword [esp],hexadecimal call hexadecimal",
		    "mov eax,[ebp+hexadecimal] or eax,edx",
		    "mov eax,[esp+hexadecimal] lea edx,[eax-hexadecimal]",
		    "mov eax,[hexadecimal] mov [esp+hexadecimal],eax",
		    "mov ebp,esp mov edx,[ebp+hexadecimal]",
		    "mov ecx,[dword hexadecimal] test ecx,ecx",
		    "mov ecx,[hexadecimal] test ecx,ecx",
		    "mov edx,[ebx+hexadecimal] test edx,edx",
		    "mov edx,[ebx-hexadecimal] test edx,edx",
		    "nop inc eax",
		    "nop mov eax,hexadecimal",
		    "nop nop",
		    "nop onumber nop",
		    "nop word [cs:eax+eax+hexadecimal] push ebp",
		    "nop xchg ax,ax",
		    "onumber jnc hexadecimal jc hexadecimal",
		    "onumber nop inc eax",
		    "onumber nop mov eax,hexadecimal",
		    "onumber nop mov ecx,[hexadecimal]",
		    "onumber nop nop",
		    "onumber nop onumber nop",
		    "onumber nop push ebp",
		    "or [ebp+hexadecimal],al pop eax",
		    "or [edi+hexadecimal],ah popfd",
		    "or [edx-hexadecimal],al add cl,[dword hexadecimal]",
		    "or [edx-hexadecimal],al add cl,[hexadecimal]",
		    "or al,hexadecimal outsb",
		    "or al,hexadecimal popa",
		    "or al,hexadecimal popad",
		    "or eax,[eax] add [dword hexadecimal],al",
		    "or eax,[eax] add [hexadecimal],al",
		    "or eax,edx pop ebp",
		    "or eax,hexadecimal inc eax",
		    "outsb add [ebx+hexadecimal],dh",
		    "outsb add [fs:ebx+hexadecimal],dh",
		    "outsb add [fs:edi+hexadecimal],bl",
		    "outsb arpl [cs:eax+hexadecimal],si",
		    "outsb dec ebx",
		    "outsb fs insb",
		    "outsb gs anumber jnc hexadecimal",
		    "outsb gs jnc hexadecimal",
		    "outsb imul esi,[ebx+eax*number+hexadecimal],dword hexadecimal",
		    "outsb imul esi,[ecx+ebp*number+hexadecimal],dword hexadecimal",
		    "outsb imul esi,[esp+eax*number+hexadecimal],dword hexadecimal",
		    "outsb inc ax",
		    "outsb inc eax",
		    "outsb insd",
		    "outsb popad",
		    "outsd add [gs:edi+hexadecimal],bl",
		    "outsd gs inc eax",
		    "outsd gs push ebx",
		    "outsd insb",
		    "outsd jnc hexadecimal",
		    "outsd jnz hexadecimal",
		    "outsd jo hexadecimal",
		    "outsd push ebx",
		    "pop ds test [eax],al",
		    "pop eax lds ecx,[esp+eax]",
		    "pop eax pop eax",
		    "pop eax pop edi",
		    "pop edi fs popad",
		    "pop edi gs jnc hexadecimal",
		    "pop edi inc eax",
		    "pop edi popad",
		    "pop edi xor [ecx+hexadecimal],ch",
		    "pop edi xor ch,[esi]",
		    "pop edi xor eax,hexadecimal",
		    "pop edi xor ebp,[esi]",
		    "pop edx xor al,hexadecimal",
		    "popa bound eax,[eax]",
		    "popa bound ebp,[ebp+hexadecimal]",
		    "popa bound esp,[edx+hexadecimal]",
		    "popa imul ebp,[esi+hexadecimal],dword hexadecimal",
		    "popa imul esi,[ebx+esi*number+hexadecimal],dword hexadecimal",
		    "popa insb",
		    "popa insd",
		    "popa jc hexadecimal",
		    "popa jnc hexadecimal",
		    "popa jnz hexadecimal",
		    "popa jz hexadecimal",
		    "popa outsb",
		    "popa pop edi",
		    "popad bound eax,[eax]",
		    "popad bound ebp,[ebp+hexadecimal]",
		    "popad bound esp,[edx+hexadecimal]",
		    "popad dec ecx",
		    "popad imul ebp,[esi+hexadecimal],dword hexadecimal",
		    "popad imul esi,[ebx+esi*number+hexadecimal],dword hexadecimal",
		    "popad insb",
		    "popad insd",
		    "popad jc hexadecimal",
		    "popad jna hexadecimal",
		    "popad jnc hexadecimal",
		    "popad jnz hexadecimal",
		    "popad jz hexadecimal",
		    "popad outsb",
		    "popad pop edi",
		    "popf add [eax],al",
		    "popf jna hexadecimal",
		    "popfd add [eax],al",
		    "popfd jna hexadecimal",
		    "push dword [dword hexadecimal] jmp dword near [dword hexadecimal]",
		    "push dword [hexadecimal] jmp near [hexadecimal]",
		    "push dword hexadecimal call dword hexadecimal",
		    "push dword hexadecimal call hexadecimal",
		    "push dword hexadecimal jmp dword hexadecimal",
		    "push dword hexadecimal jmp hexadecimal",
		    "push eax inc esi",
		    "push ebx call dword hexadecimal",
		    "push ebx call hexadecimal",
		    "push ebx imul esi,[edx+hexadecimal],dword hexadecimal",
		    "push ebx outsd",
		    "push ebx popad",
		    "push ebx xor eax,hexadecimal",
		    "pushad add [eax],al",
		    "ret db hexadecimal",
		    "ret nop word [cs:eax+eax+hexadecimal]",
		    "ret onumber nop",
		    "ret xchg ax,ax",
		    "ss pop edi inc eax",
		    "sub eax,hexadecimal arpl [dword hexadecimal],bp",
		    "sub eax,hexadecimal arpl [hexadecimal],bp",
		    "sub eax,hexadecimal insb",
		    "sub eax,hexadecimal insd",
		    "sub esp,byte +hexadecimal call dword hexadecimal",
		    "sub esp,byte +hexadecimal call hexadecimal",
		    "sub esp,byte +hexadecimal lea eax,[esp+hexadecimal]",
		    "sub esp,byte +hexadecimal mov dword [esp+hexadecimal],hexadecimal",
		    "sub esp,byte +hexadecimal mov eax,[hexadecimal]",
		    "test [eax],al add [eax],al",
		    "test al,al jnz dword hexadecimal",
		    "xchg ax,ax inc eax",
		    "xchg ax,ax mov eax,hexadecimal",
		    "xchg ax,ax mov ecx,[dword hexadecimal]",
		    "xchg ax,ax nop",
		    "xchg ax,ax push ebp",
		    "xchg ax,ax xchg ax,ax",
		    "xor [eax],al pop edi",
		    "xor [ebx+hexadecimal],esp popa",
		    "xor [ebx+hexadecimal],esp popad",
		    "xor [ecx+hexadecimal],ch add [edi+hexadecimal],bl",
		    "xor [ecx],esi arpl [eax+hexadecimal],bp",
		    "xor [esi+hexadecimal],ecx pop edi",
		    "xor [esi],ch imul ebp,[esi+hexadecimal],dword hexadecimal",
		    "xor [esi],ebp arpl [eax+hexadecimal],si",
		    "xor al,hexadecimal cmp [esi],dh",
		    "xor al,hexadecimal inc edi",
		    "xor al,hexadecimal outsb",
		    "xor al,hexadecimal popa",
		    "xor al,hexadecimal popad",
		    "xor al,hexadecimal xor ebp,[dword hexadecimal]",
		    "xor al,hexadecimal xor ebp,[hexadecimal]",
		    "xor ch,[esi] xor [eax],al",
		    "xor ch,[esi] xor [esi],ebp",
		    "xor dh,[eax+hexadecimal] add [edi+hexadecimal],bl",
		    "xor eax,hexadecimal add [edi+hexadecimal],bl",
		    "xor eax,hexadecimal gs jna hexadecimal",
		    "xor eax,hexadecimal inc eax",
		    "xor ebp,[dword hexadecimal] outsb",
		    "xor ebp,[esi] xor al,hexadecimal",
		    "xor ebp,[hexadecimal] outsb",
		    "xor ebx,[edi+hexadecimal] outsd",
		    "xor esp,[ebp+hexadecimal] jnc hexadecimal",
		    "xor esp,[edx+hexadecimal] jnc hexadecimal"};
		   	String [] cfgSnowmanBigrams ={ "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = <0:0> nodeNewline <0:0> = [<0:0>] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [<0:0>] nodeNewline goto address <0:0> nodeNewline   basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline goto address hexadecimal nodeNewline  ",
		   	 "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> | <0:0>) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = [<0:0>] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [<0:0>] nodeNewline goto address <0:0> nodeNewline   basicBlockhexadecimal   Address: hexadecimal nodeNewline goto address [hexadecimal] nodeNewline  ",
		   	 "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= <0:0>) nodeNewline if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline   basicBlockhexadecimal   Address: hexadecimal nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = ([(<0:0> + hexadecimal)] + hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline goto basic block hexadecimal nodeNewline  ",
		   	 "basicBlockhexadecimal   Address: hexadecimal nodeNewline goto address [hexadecimal] nodeNewline   basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> | <0:0>) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = [<0:0>] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [<0:0>] nodeNewline goto address <0:0> nodeNewline  ",
		   	 "basicBlockhexadecimal   Address: hexadecimal nodeNewline goto address [hexadecimal] nodeNewline   basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = zero_extend ~<0:0> nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline if ~<0:0> goto address hexadecimal else goto basic block hexadecimal nodeNewline  ",
		   	 "basicBlockhexadecimal   Address: hexadecimal nodeNewline goto address [hexadecimal] nodeNewline   basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= <0:0>) nodeNewline if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline  "};
		   	String [] cfgSnowmanLineBigrams ={ "<0:0> = (<0:0> + hexadecimal) <0:0> = [hexadecimal]",
		   	 "<0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= <0:0>) if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal",
		   	 "<0:0> = [(<0:0> + hexadecimal)] <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< <0:0>)",
		   	 "<0:0> = [hexadecimal] [(<0:0> + hexadecimal)] = <0:0>",
		   	 "<0:0> = intrinsic(0) <0:0> = [hexadecimal]"};
		   	String [] cfgSnowmanNodeLastLine ={ "<0:0> = [hexadecimal]",
		   	 "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> & hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline goto address hexadecimal nodeNewline  ",
		   	 "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = <0:0> nodeNewline <0:0> = [<0:0>] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [<0:0>] nodeNewline goto address <0:0> nodeNewline  ",
		   	 "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> | <0:0>) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = [<0:0>] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [<0:0>] nodeNewline goto address <0:0> nodeNewline  ",
		   	 "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = zero_extend ~<0:0> nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline if ~<0:0> goto address hexadecimal else goto basic block hexadecimal nodeNewline  ",
		   	 "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= <0:0>) nodeNewline if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline  ",
		   	 "basicBlockhexadecimal   Address: hexadecimal nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = ([(<0:0> + hexadecimal)] + hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline goto basic block hexadecimal nodeNewline  ",
		   	};
		   	String [] cppKeyword ={ "and",
		    "extern",
		    "static",
		    "this"};
		   	String [] disassemblyBjoernLineBigrams ={"call sym._ZStorStnumber_Ios_OpenmodeS_ call sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
		   	"call sym._Znumbersolvev call sym.deregister_tm_clones",
		   	"call sym.deregister_tm_clones call sym.imp._ZNStnumberios_basenumberInitCnumberEv",
		   	"call sym.imp._ZNSirsERi call sym.imp._ZNSirsERi",
		   	"call sym.imp._ZNSolsEi call sym.imp._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc",
		   	"call sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv call sym.imp._Unwind_Resume",
		   	"call sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv call sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv",
		   	"call sym.imp._ZNStnumberios_basenumberInitCnumberEv call sym.imp.__cxa_atexit",
		   	"call sym.imp._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc call sym._Znumbersolvev",
		   	"call sym.imp._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc call sym.imp._ZNSolsEi",
		   	"call sym.imp.__cxa_atexit call sym._ZStorStnumber_Ios_OpenmodeS_",
		   	"call sym.imp.__libc_start_main call sym.imp._ZNSirsERi",
		   	"call sym.imp.__libc_start_main call sym.imp.freopen",
		   	"call sym.imp.__libc_start_main call sym.imp.scanf",
		   	"call sym.imp.freopen call sym.imp._ZNSirsERi",
		   	"call sym.imp.freopen call sym.imp.freopen",
		   	"call sym.imp.freopen call sym.imp.scanf",
		   	"call sym.imp.getchar call sym.imp.getchar",
		   	"call sym.imp.scanf call sym.imp.scanf",
		   	"childNum repr code comment esil str.Case__",
		   	"childNum repr code comment esil str.input.txt",
		   	"loc._end obj.stdout__GLIBC_number.number",
		   	"loc.data_start obj._ZStnumbercin__GLIBCXX_number.number",
		   	"loc.imp._ITM_deregisterTMCloneTable sym.imp._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc",
		   	"loc.imp._ITM_deregisterTMCloneTable sym.imp.scanf",
		   	"loc.imp._ITM_registerTMCloneTable sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv",
		   	"loc.imp._ITM_registerTMCloneTable sym.imp.freopen",
		   	"loc.imp._ITM_registerTMCloneTable sym.imp.printf",
		   	"number lea edx, [eax - number] numberdnumberff hexadecimal,eax,-,edx,= number mov dword [esp + hexadecimal], edx number edx,hexadecimal,esp,+,=[number]",
		   	"number mov dword [esp + hexadecimal], edx number edx,hexadecimal,esp,+,=[number] number test eax, eax numbercnumber number,eax,eax,&,==,$z,zf,=,$p,pf,=,$s,sf,=,number,cf,=,number,of,=",
		   	"number mov dword [esp + hexadecimal], number cnumbercnumber number,hexadecimal,esp,+,=[number] number jmp hexadecimal ebnumberd hexadecimal,eip,=",
		   	"number mov dword [esp + number], hexadecimal cnumber ; [hexadecimal:number]=hexadecimal number,hexadecimal,esp,+,=[number] number mov dword [esp], hexadecimal cnumber ; [hexadecimal:number]=hexadecimal number,esp,=[number]",
		   	"number mov dword [esp + number], hexadecimal cnumberffffnumber ; [hexadecimal:number]=-number number,hexadecimal,esp,+,=[number] number mov dword [esp], number cnumber number,esp,=[number]",
		   	"number mov eax, dword [ebp+arg_number] numberbnumberc ; [hexadecimal:number]=number hexadecimal,ebp,+,[number],eax,= number or eax, edx numberdnumber edx,eax,|=,number,of,=,number,cf,=,$s,sf,=,$z,zf,=,$p,pf,=",
		   	"number mov ebp, esp numberenumber esp,ebp,= number mov edx, dword [ebp+arg_number] numberbnumber ; [hexadecimal:number]=number hexadecimal,ebp,+,[number],edx,=",
		   	"number mov edx, dword [ebp+arg_number] numberbnumber ; [hexadecimal:number]=number hexadecimal,ebp,+,[number],edx,= number mov eax, dword [ebp+arg_number] numberbnumberc ; [hexadecimal:number]=number hexadecimal,ebp,+,[number],eax,=",
		   	"number mov edx, dword [esp + hexadecimal] numberbnumberc ; [hexadecimal:number]=number hexadecimal,esp,+,[number],edx,= number mov dword [esp + number], edx number edx,hexadecimal,esp,+,=[number]",
		   	"number or eax, edx numberdnumber edx,eax,|=,number,of,=,number,cf,=,$s,sf,=,$z,zf,=,$p,pf,= number pop ebp numberd esp,[number],ebp,=,number,esp,+=",
		   	"number sub esp, hexadecimal numberecnumber number,esp,-=,$o,of,=,$s,sf,=,$z,zf,=,$p,pf,=,$b,cf,= number mov dword [esp + number], hexadecimal cnumberffffnumber ; [hexadecimal:number]=-number number,hexadecimal,esp,+,=[number]",
		   	"obj._ZStLnumber__ioinit sym._Znumber__static_initialization_and_destruction_numberii",
		   	"reloc._ZNSirsERi_number reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number",
		   	"reloc._ZNSolsEPFRSoS_E_number reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number",
		   	"reloc._ZNSolsEi_number reloc.__cxa_atexit_number",
		   	"reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number reloc._ZNSolsEPFRSoS_E_number",
		   	"reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv_number reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv_number",
		   	"reloc._ZNStnumberios_basenumberInitDnumberEv_number reloc._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc_number",
		   	"reloc._ZNStnumberios_basenumberInitDnumberEv_number reloc.scanf_number",
		   	"reloc._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc_number reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv_number",
		   	"reloc.__cxa_atexit_number reloc.getchar_number",
		   	"reloc.__gmon_start___number reloc.__cxa_atexit_number",
		   	"reloc.__gmon_start___number reloc.__gmon_start___number",
		   	"reloc.__libc_start_main_number reloc.scanf_number",
		   	"reloc.freopen_number reloc.printf_number",
		   	"reloc.scanf_number reloc.freopen_number",
		   	"reloc.scanf_number reloc.printf_number",
		   	"str.input.txt str.output.txt",
		   	"str.output.txt str.Case__",
		   	"sym._Znumber__static_initialization_and_destruction_numberii sym.imp._ZNStnumberios_basenumberInitCnumberEv",
		   	"sym.__do_global_ctors_aux obj._GLOBAL_OFFSET_TABLE_",
		   	"sym.__do_global_ctors_aux obj._ZStLnumber__ioinit",
		   	"sym.imp._ZNSirsERi sym.imp._ZNSolsEPFRSoS_E",
		   	"sym.imp._ZNSirsERi sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
		   	"sym.imp._ZNSolsEPFRSoS_E sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
		   	"sym.imp._ZNSolsEi sym.imp.__cxa_atexit",
		   	"sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode sym.imp._ZNSolsEPFRSoS_E",
		   	"sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv",
		   	"sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode sym.imp._ZStnumberendlIcStnumberchar_traitsIcEERStnumberbasic_ostreamIT_Tnumber_ESnumber_",
		   	"sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv sym.imp._ZNSirsERi",
		   	"sym.imp._ZNStnumberios_basenumberInitCnumberEv sym.imp.__cxa_atexit",
		   	"sym.imp._ZNStnumberios_basenumberInitDnumberEv loc.imp._ITM_deregisterTMCloneTable",
		   	"sym.imp._ZNStnumberios_basenumberInitDnumberEv sym.imp._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc",
		   	"sym.imp._ZNStnumberios_basenumberInitDnumberEv sym.imp.scanf",
		   	"sym.imp._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc loc.imp._ITM_registerTMCloneTable",
		   	"sym.imp._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc sym.imp._ZNSirsERi",
		   	"sym.imp._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv",
		   	"sym.imp.__cxa_atexit sym.imp.getchar",
		   	"sym.imp.__libc_start_main loc.imp._ITM_deregisterTMCloneTable",
		   	"sym.imp.freopen sym.imp.printf",
		   	"sym.imp.scanf loc.imp._ITM_registerTMCloneTable",
		   	"sym.imp.scanf sym.imp.freopen",
		   	"sym.imp.scanf sym.imp.printf",
		   	 "call sym._ZStorStnumber_Ios_OpenmodeS_"};
		   	String []  	disassemblyBjoernLineUnigrams ={"call sym._Znumber__static_initialization_and_destruction_numberii",
		  "call sym._Znumbersolvev",
		  "call sym.imp._ZNSirsERi",
		  "call sym.imp._ZNSolsEPFRSoS_E",
		  "call sym.imp._ZNSolsEi",
		  "call sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
		  "call sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv",
		  "call sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
		  "call sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEv",
		  "call sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv",
		  "call sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEnumberopenEPKcStnumber_Ios_Openmode",
		  "call sym.imp._ZNStnumberios_basenumberInitCnumberEv",
		  "call sym.imp._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc",
		  "call sym.imp.__cxa_atexit",
		  "call sym.imp.freopen",
		  "call sym.imp.getc",
		  "call sym.imp.getchar",
		  "call sym.imp.printf",
		  "call sym.imp.scanf",
		  "number cmp byte [ebp-local_number_number], hexadecimal numberdfnumber ; [hexadecimal:number]=number ; apostrophesymbolnumberapostrophesymbol number,hexadecimal,ebp,-,[number],==,$z,zf,=,$bnumber,cf,=,$p,pf,=,$s,sf,=",
		  "number cmp byte [ebp-local_number_number], hexadecimal numberdfnumberf ; [hexadecimal:number]=number ; apostrophesymbol/apostrophesymbol number,hexadecimal,ebp,-,[number],==,$z,zf,=,$bnumber,cf,=,$p,pf,=,$s,sf,=",
		  "number cmp dword [ebp + hexadecimal], hexadecimal numberdnumbercffffnumber ; [hexadecimal:number]=-number number,hexadecimal,ebp,+,[number],==,$z,zf,=,$bnumber,cf,=,$p,pf,=,$s,sf,=",
		  "number mov dword [esp + number], hexadecimal cnumberffffnumber ; [hexadecimal:number]=-number number,hexadecimal,esp,+,=[number]",
		  "number mov eax, dword [esp + hexadecimal] numberbnumberc ; [hexadecimal:number]=number hexadecimal,esp,+,[number],eax,=",
		  "number mov edx, dword [esp + hexadecimal] numberbnumberc ; [hexadecimal:number]=number hexadecimal,esp,+,[number],edx,=",
		  "number movsx eax, byte [ebp-local_number_number] numberfbenumberfnumber hexadecimal,ebp,-,[number],eax,=",
		  "obj.T",
		  "obj._ZLnumberM",
		  "obj._ZLnumberN",
		  "obj._ZLnumberep",
		  "obj._ZLnumbereps",
		  "obj._ZLnumbermaxn",
		  "obj._ZLnumberpi",
		  "obj._ZStLnumber__ioinit",
		  "obj._ZStnumbercin__GLIBCXX_number.number",
		  "obj._ZStnumbercout__GLIBCXX_number.number",
		  "obj.__",
		  "obj.__dso_handle",
		  "obj.s",
		  "obj.st",
		  "obj.stdin__GLIBC_number.number",
		  "obj.stdout__GLIBC_number.number",
		  "reloc._ZNSirsERi_number",
		  "reloc._ZNSolsEPFRSoS_E_number",
		  "reloc._ZNSolsEi_number",
		  "reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number",
		  "reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv_number",
		  "reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number",
		  "reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEv_number",
		  "reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv_number",
		  "reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEnumberopenEPKcStnumber_Ios_Openmode_number",
		  "reloc._ZNStnumberios_basenumberInitCnumberEv_number",
		  "reloc._ZNStnumberios_basenumberInitDnumberEv_number",
		  "reloc._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc_number",
		  "reloc._ZStnumberendlIcStnumberchar_traitsIcEERStnumberbasic_ostreamIT_Tnumber_ESnumber__number",
		  "reloc.__cxa_atexit_number",
		  "reloc.freopen_number",
		  "reloc.getchar_number",
		  "reloc.printf_number",
		  "reloc.scanf_number",
		  "section.LOADnumber",
		  "str.Case___d:",
		  "str.a.out",
		  "str.input.txt",
		  "str.output.txt",
		  "sym._ZStorStnumber_Ios_OpenmodeS_",
		  "sym._Znumber__static_initialization_and_destruction_numberii",
		  "sym._Znumbersolvev",
		  "sym.imp._ZNSirsERi",
		  "sym.imp._ZNSolsEPFRSoS_E",
		  "sym.imp._ZNSolsEi",
		  "sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
		  "sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv",
		  "sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
		  "sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEv",
		  "sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv",
		  "sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEnumberopenEPKcStnumber_Ios_Openmode",
		  "sym.imp._ZNStnumberios_basenumberInitCnumberEv",
		  "sym.imp._ZNStnumberios_basenumberInitDnumberEv",
		  "sym.imp._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc",
		  "sym.imp._ZStnumberendlIcStnumberchar_traitsIcEERStnumberbasic_ostreamIT_Tnumber_ESnumber_",
		  "sym.imp.__cxa_atexit",
		  "sym.imp.freopen",
		  "sym.imp.getc",
		  "sym.imp.getchar",
		  "sym.imp.printf",
		  "sym.imp.scanf"};
		  
		   	String []  	wordUnigramsCPP ={ "\""+"U\0025"+"d",
		   "\""+"U\0025"+"d\",",
		   "\",",
		   "\":",
		   "\"input.txt\",",
		   "\"output.txt\",",
		   "\"r",
		   "\"r\",",
		   "\"w\",",
		   "#\");",
		   "#"+"U\0025"+"d:",
		   ""+"U\0025"+"",
		   ""+"U\0025"+"d",
		   ""+"U\0025"+"d\",",
		   "&T);",
		   "&_CTOR_LIST__;",
		   "&_dso_handle);",
		   "&std::__ioinit,",
		   "&std::cout,",
		   "&t)",
		   "&t);",
		   "(*)())number",
		   "(*)(void))*vnumber;",
		   "(*)(void))_CTOR_LIST__;",
		   "(**vnumber)();",
		   "(*vnumber)(void);",
		   "(F",
		   "(FILE",
		   "(__cdecl",
		   "(__intnumber",
		   "(numberLL",
		   "*)&s",
		   "*)&std::__ioinit);",
		   "*)&std::basic_ifstream<char,std::char_traits<char>>::~basic_ifstream,",
		   "*)&std::basic_ofstream<char,std::char_traits<char>>::~basic_ofstream,",
		   "*)())*vnumber;",
		   "*)std::ios_base::Init::~Init,",
		   "*__hidden",
		   "*filename,",
		   "*format,",
		   "*freopen(const",
		   "*modes,",
		   "*stdin;",
		   "*stdout;",
		   "*stream);",
		   "*this)",
		   "*this);",
		   "*vnumber)",
		   "*vnumber)();",
		   "...);",
		   "::i",
		   "FILE",
		   "HIDWORD(anumber)",
		   "HIDWORD(anumber);",
		   "L);",
		   "T;",
		   "_;",
		   "_CTOR_LIST__",
		   "_CTOR_LIST__;",
		   "__cxa_atexit(",
		   "__cxa_atexit((const",
		   "__cxa_atexit(const",
		   "__static_initialization_and_destruction_number(int",
		   "__static_initialization_and_destruction_number(number,",
		   "_dso_handle;",
		   "cout;",
		   "dd",
		   "des,",
		   "e;",
		   "extern",
		   "file",
		   "freopen(",
		   "freopen(\"input.txt\",",
		   "freopen(\"output.txt\",",
		   "getchar();",
		   "getchar(void);",
		   "init,",
		   "it;",
		   "m)",
		   "m);",
		   "mod",
		   "n"+"U\0022"+",",
		   "numberLL)",
		   "numberLL);",
		   "numberxFFFF",
		   "numberxFFFF);",
		   "of",
		   "off_number",
		   "out;",
		   "output",
		   "printf(\"",
		   "printf(\\",
		   "printf(\"Case",
		   "printf(const",
		   "s)",
		   "s);",
		   "sc",
		   "scanf(\"",
		   "scanf(\""+"U\0025"+"d",
		   "scanf(\""+"U\0025"+"d"+"U\0022"+",",
		   "scanf(const",
		   "solve()",
		   "solve();",
		   "solve(void)",
		   "solve(void);",
		   "std::__ioinit;",
		   "std::basic_ifstream<char,std::char_traits<char>>::basic_ifstream(_DWORD,",
		   "std::basic_ifstream<char,std::char_traits<char>>::~basic_ifstream;",
		   "std::basic_ofstream<char,std::char_traits<char>>::basic_ofstream(_DWORD,",
		   "std::basic_ofstream<char,std::char_traits<char>>::~basic_ofstream;",
		   "std::cout;",
		   "std::ios_base",
		   "std::ios_base::Init::Init((std::ios_base::Init",
		   "std::ios_base::Init::Init(std::ios_base::Init",
		   "std::ios_base::Init::~Init(std::ios_base::Init",
		   "std::istream::operator>>(",
		   "std::istream::operator>>(_DWORD,",
		   "std::operator<<<std::char_traits<char>>(",
		   "std::operator<<<std::char_traits<char>>(&std::cout,",
		   "std::operator<<<std::char_traits<char>>(_DWORD,",
		   "std::operator<<<std::char_traits<char>>(vnumber,",
		   "std::operator|(__intnumber",
		   "std::operator|(numberLL);",
		   "std::ostream::operator<<(",
		   "std::ostream::operator<<(_DWORD,",
		   "std::ostream::operator<<(vnumber,",
		   "stdin);",
		   "stdin;",
		   "stdout);",
		   "stdout;",
		   "stream",
		   "stream);",
		   "temp",
		   "this);",
		   "tp",
		   "tt",
		   "vnumber++;",
		   "vnumber--",
		   "vnumber--;",
		   "xa"};

		   	
		 
		   	
		   	
		
		  
			for (int i=0; i<	BjoernDisassemblyInstructionUnigrams.length; i++){  
				//	bjoernDisassemblyUnigrams[i] = bjoernDisassemblyUnigrams[i].replace("'", "apostrophesymbol");
				//  System.out.println("@attribute 'bjoernDisassemblyUnigrams"+i+ " "+bjoernDisassemblyUnigrams[i]);
			   	Util.writeFile("@attribute 'BjoernDisassemblyInstructionUnigrams "+i+"=["+BjoernDisassemblyInstructionUnigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+ "\n", output_filename, true);
		       }
		
		   	for (int i=0; i<		   	BjoernDisassemblyInstructionBigrams.length; i++){ 
		//   	System.out.println("@attribute 'BjoernDisassemblyInstructionBigrams"+i+ " "+bjoernDisassemblyBigrams[i]);
	    		Util.writeFile("@attribute 'BjoernDisassemblyInstructionBigrams "+i+"=["+BjoernDisassemblyInstructionBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+ "\n", output_filename, true);
		   	}
		   	
		
		
		   	for (int i=0; i<BjoernDisassemblyInstructionTrigrams.length; i++){  
		   	//	System.out.println("@attribute 'BjoernDisassemblyInstructionTrigrams"+i+ " "+bjoernDisassemblyTrigrams[i]);
	    		Util.writeFile("@attribute 'BjoernDisassemblyInstructionTrigrams "+i+"=["+BjoernDisassemblyInstructionTrigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+ "\n", output_filename, true);
		   	}
		   	
		
		    	for (int i=0; i<		   	disassemblyBjoernLineUnigrams.length; i++)	   	
		    {
		    		Util.writeFile("@attribute 'disassemblyBjoernLineUnigrams "+i+"=["+		   	disassemblyBjoernLineUnigrams
[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
        		//	System.out.println("@attribute 'disassemblyLineUnigrams "+i+"=["+disassemblyLineUnigrams[i]+"]");
		       }		
		    	
		
		    	for (int i=0; i<disassemblyBjoernLineBigrams.length; i++)	   	
		    	{  	
		    	Util.writeFile("@attribute 'disassemblyBjoernLineBigrams "+i+"=["+disassemblyBjoernLineBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
		    	//	System.out.println("@attribute 'disassemblyLineBigrams "+i+"=["+disassemblyLineBigrams[i]+"]");
		    	}	
		
		    	 
		    	for (int i=0; i<cfgSnowmanUnigrams.length; i++)	   	
		       {  	
		            Util.writeFile("@attribute 'cfgSnowmanUnigrams "+i+"=["+cfgSnowmanUnigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);}			
		    	
		   
			    	for (int i=0; i<cfgSnowmanNodeLastLine.length; i++)	   	
			       {  	
			            Util.writeFile("@attribute 'cfgSnowmanNodeLastLine "+i+"=["+cfgSnowmanNodeLastLine[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);}			
			    	
		    
		     	for (int i=0; i<cfgSnowmanBigrams.length; i++)	   	
			       {  
		     				String temp= cfgSnowmanBigrams[i].replace("'", "apostrophesymbol");
			            	Util.writeFile("@attribute 'cfgSnowmanBigrams "+i+"=["+temp.replace("\n", " ")+"]' numeric"+"\n", output_filename, true);}
	
		   
		     	for (int i=0; i<cfgSnowmanLineBigrams.length; i++)	   	
			       {  		
		     				String temp= cfgSnowmanLineBigrams[i].replace("'", "apostrophesymbol");
			            	Util.writeFile("@attribute 'cfgSnowmanLineBigrams "+i+"=["+temp.replace("\n", " ")+"]' numeric"+"\n", output_filename, true);}		    			    	
				// SNOWMAN CFG FEATURES END	- Related files: (1842485_1486492_a9108_SnowmanDecompiled.dot)
		    	
		
			    for (int i=0; i<NDISASMDisassemblyInstructionUnigrams.length; i++)	   	
			       {  		
			    	Util.writeFile("@attribute 'NDISASMDisassemblyInstructionUnigrams "+i+"=["+NDISASMDisassemblyInstructionUnigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
			    	}
		
			    for (int i=0; i<NDISASMDisassemblyInstructionBigrams.length; i++)	   	
			       {  		
		           	Util.writeFile("@attribute 'NDISASMDisassemblyInstructionBigrams "+i+"=["+NDISASMDisassemblyInstructionBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
			       }

		  
				for (int i=0; i<NDISASMDisassemblyInstructionTrigrams.length; i++)	   	
			       {  	
	       	 	Util.writeFile("@attribute 'NDISASMDisassemblyInstructionTrigrams "+i+"=["+NDISASMDisassemblyInstructionTrigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);	
				}
				    
			
				for (int i=0; i<NDISASMDisassemblyLineBigrams.length; i++)	   	
			    {  		
					Util.writeFile("@attribute 'NDISASMDisassemblyLineBigrams "+i+"=["+NDISASMDisassemblyLineBigrams[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);	
				}
		     
		
			  for (int i=0; i<wordUnigramsCPP.length; i++)	   	
		     {  	
		     Util.writeFile("@attribute 'wordUnigramsCPP "+i+"=["+wordUnigramsCPP[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
		     }	
 
	
			  for (int i=0; i<ASTNodeBigramsTF.length; i++)		
		   	  {  	
			    	Util.writeFile("@attribute 'ASTNodeBigramsTF "+i+"=["+ASTNodeBigramsTF[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
			  }
			   
		
			    for (int i=0; i<ASTNodeTypesTF.length; i++)	   	
			  {  	
			    	Util.writeFile("@attribute 'ASTNodeTypesTF "+i+"=["+ASTNodeTypesTF[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
			  }
			  
			    for (int i=0; i<ASTNodeTypesTFIDF.length; i++)	
			  {	   
			    	Util.writeFile("@attribute 'ASTNodeTypesTFIDF "+i+"=["+ASTNodeTypesTFIDF[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
			  }
			  
			    for (int i=0; i<ASTNodeTypeAvgDep.length; i++)	
				  {	   
				    	Util.writeFile("@attribute 'ASTNodeTypeAvgDep "+i+"=["+ASTNodeTypeAvgDep[i].replace("'", "apostrophesymbol")+"]' numeric"+"\n", output_filename, true);
				  }
			    
			    
			    String [] cppKeywords = {"auto", 	"break", 	"case", 	"char", 	"const", 	
				  "continue", 	"default", 	"do", 	"double", 	"else", 	"enum", 	
				  "extern", 	"float", 	"for", 	"goto", 	"if", 	"inline", 	
				  "int", 	"long", 	"register", 	"restrict", 	"return", 	"short", 	
				  "signed", 	"sizeof", 	"static", 	"struct", 	"switch", 	"typedef", 	
				  "union", 	"unsigned", 	"void", 	"volatile", 	"while", 	"_Alignas", 	
				  "_Alignof", 	"_Atomic", 	"_Bool", 	"_Complex", 	"_Generic", 	"_Imaginary",
				  "_Noreturn", 	"_Static_assert", 	"_Thread_local","alignas",	"alignof",	"and",	"and_eq",	"asm",	
				  "bitand",	"bitor",	"bool",	"catch",	"char",	"char16_t",	"char32_t",
				  "class",	"compl",	"const",	"constexpr",	"const_cast",	"decltype",	
				  "delete",	"dynamic_cast",	"explicit",	"export",	
				  "FALSE",		"friend",		
				  "mutable",	"namespace",	"new",	"noexcept",	"not",	"not_eq",	"nullptr",	"operator",	"or",
				  "or_eq"	,"private"	,"protected"	,"public"	,	"reinterpret_cast",	
				  "static_assert",	"static_cast",	
				  	"template",	"this"	,"thread_local",	"throw",	"TRUE",	"try",		"typeid",
				  "typename",		"using",	"virtual",		"wchar_t",
				  "xor",	"xor_eq", "override", "final"}; 
			    for (int i=0; i<cppKeywords.length; i++)	
			  {	Util.writeFile("@attribute 'cppKeyword "+i+"=["+cppKeywords[i]+"]' numeric"+"\n", output_filename, true);}


		    	

	
		     	
		    File authorFileName = null;
			//Writing the classes (authorname)
			Util.writeFile("@attribute 'authorName_original' {",output_filename, true);
			
			
			//THIS IS WHERE THE TEST PARAMETERS BECOME EFFECTIVE			
			    for(int i=0; i< test_binary_paths.size(); i++){

				authorFileName= new File(test_binary_paths.get(i).toString());
				String authorName= authorFileName.getParentFile().getName() +
						"_"+authorFileName.getParentFile().getParentFile().getName() ;
				text = text.concat(authorName + ",");  
				String[] words = text.split( ",");
				Set<String> uniqueWords = new HashSet<String>();
				   for (String word : words) {
				       uniqueWords.add(word);
				   }
				words = uniqueWords.toArray(new String[0]);
				int authorCount = words.length;
				if (i+1==test_binary_paths.size()){
				   for (int j=0; j< authorCount; j++){
					   {System.out.println(words[j]);
						if(j+1 == authorCount){
							Util.writeFile(words[j]+"}"+"\n\n",output_filename, true);
							}
						else{
						Util.writeFile(words[j]+","+"",output_filename, true);
							}
						}
				   }
				}		   
			}
			
			Util.writeFile("@data"+"\n", output_filename, true);	
			//Finished defining the attributes
			//starting to write the feature vectors
			
			
			//EXTRACT LABELED FEATURES FROM CORRESPONDING FEATURE DATA SOURCES
//	         test_dir output_filename start end		
			for(int i=start; i<=end; i++){

		//   	for(int i=0; i< test_binary_paths.size(); i++){
				authorFileName = new File(test_binary_paths.get(i).toString());
				String authorName= authorFileName.getParentFile().getName() +
						"_"+authorFileName.getParentFile().getParentFile().getName();
				System.out.println("Binary filename: "+test_binary_paths.get(i));
				System.out.println("Author: "+authorName);
				String fileNameID = authorFileName.getName() +
						"_"+authorFileName.getParentFile().getParentFile().getName();
				Util.writeFile(fileNameID+",", output_filename, true);
				String featureTextBjoernDisassembly = null;
				try {
					featureTextBjoernDisassembly = Util.readFile(authorFileName.getParentFile()
					+ File.separator + authorFileName.getName()+"_bjoernDisassembly"+ File.separator + "nodes.csv");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			     // BJOERN FEATURES START
				 // Related files:
			     // 1645485_1480492_a9108_bjoernDisassembly/nodes.csv
				 // 1645485_1480492_a9108_bjoernDisassembly/1645485_1480492_a9108CFG/*.graphml

	   
			    
			    //get count of each instruction unigram in disassemblyBjoern 
			    float[] wordUniCount = FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionUnigramsTF(featureTextBjoernDisassembly, BjoernDisassemblyInstructionUnigrams);
			    for (int j=0; j<wordUniCount.length; j++)
				{Util.writeFile(wordUniCount[j] +",", output_filename, true);}	
			    
			    //get count of each instruction bigram in disassemblyBjoern	 
			    float[] wordBigramCount = null;
				try {
					wordBigramCount = FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionBigramsTF(featureTextBjoernDisassembly, BjoernDisassemblyInstructionBigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<wordBigramCount.length; j++)
				{Util.writeFile(wordBigramCount[j] +",", output_filename, true);}

			    //get count of each instruction trigram in disassemblyBjoern	 
			    float[] wordTrigramCount = null;
				try {
					wordTrigramCount = FeatureExtractor2016Bjoern.getBjoernDisassemblyInstructionTrigramsTF(featureTextBjoernDisassembly, BjoernDisassemblyInstructionTrigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<wordTrigramCount.length; j++)
				{Util.writeFile(wordTrigramCount[j] +",", output_filename, true);}

			    //get count of each line unigram in disassemblyBjoern	 
			    float[] lineUnigramCount = FeatureExtractor2016Bjoern.getBjoernLineUnigramsTF(featureTextBjoernDisassembly, disassemblyBjoernLineUnigrams);
			    for (int j=0; j<lineUnigramCount.length; j++)
				{Util.writeFile(lineUnigramCount[j] +",", output_filename, true);}
			    
			    //get count of each line bigram in disassemblyBjoern	 
			    float[] lineBigramCount = null;
				try {
					lineBigramCount = FeatureExtractor2016Bjoern.getBjoernLineBigramsTF(featureTextBjoernDisassembly, disassemblyBjoernLineBigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<lineBigramCount.length; j++)
				{Util.writeFile(lineBigramCount[j] +",", output_filename, true);}
			    //BJOERN FEATURES END
				 // Related files:
			     // 1645485_1480492_a9108_bjoernDisassembly/nodes.csv
				 // 1645485_1480492_a9108_bjoernDisassembly/1645485_1480492_a9108CFG/*.graphml

			    
			   	// SNOWMAN CFG FEATURES START - Related files: (1842485_1486492_a9108_SnowmanDecompiled.dot)
				String featureTextSnowmanCFG = null;
				try {
					featureTextSnowmanCFG = Util.readFile(authorFileName.getParentFile()
							+ File.separator + authorFileName.getName()+"_SnowmanDecompiled.dot");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		     	
			    //get count of each wordUnigram in Snowman CFG 
				
			    float[] wordUniCount1 = FeatureExtractorSnowmanCFG.getCFGUnigramTF(featureTextSnowmanCFG, cfgSnowmanUnigrams);
			    for (int j=0; j<wordUniCount1.length; j++)
				{Util.writeFile(wordUniCount1[j] +",", output_filename, true);}	
			    
			    //tfidf is the slowest feature so far
/*			    
 * 				String [] cfgSnowmanUnigramsTFIDF= cfgSnowmanUnigrams;
 * 				float[] uniTFIDF = FeatureExtractorSnowmanCFG.getCFGUnigramsTFIDF(featureTextSnowmanCFG, test_dir, cfgSnowmanUnigrams);
			    for (int j=0; j<uniTFIDF.length; j++)
				{Util.writeFile(uniTFIDF[j] +",", output_filename, true);}	*/
			    
			    //get count of each line unigram in Snowman CFG	 
			    float[] cfgNodeLastLineCount = FeatureExtractorSnowmanCFG.getCFGNodeLineTF(featureTextSnowmanCFG, cfgSnowmanNodeLastLine);
			    for (int j=0; j<cfgNodeLastLineCount.length; j++)
				{Util.writeFile(cfgNodeLastLineCount[j] +",", output_filename, true);}	


			    
			    //get count of each bigram in Snowman CFG	 
			    float[] wordBigramCount1 = null;
				try {
					wordBigramCount1 = FeatureExtractorSnowmanCFG.getCFGBigramsTF(featureTextSnowmanCFG, cfgSnowmanBigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<wordBigramCount1.length; j++)
				{Util.writeFile(wordBigramCount1[j] +",", output_filename, true);}
			    
			    //get count of each line bigram in Snowman CFG 	 
			    float[] lineBigramSnowmanCount = null;
				try {
					lineBigramSnowmanCount = FeatureExtractorSnowmanCFG.getCFGNodeLineBigramTF(featureTextSnowmanCFG, cfgSnowmanLineBigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<lineBigramSnowmanCount.length; j++)
				{Util.writeFile(lineBigramSnowmanCount[j] +",", output_filename, true);}			   	
			   // SNOWMAN CFG FEATURES END	- Related files: (1842485_1486492_a9108_SnowmanDecompiled.dot)

				 // NDISASM FEATURES START - DISASSEMBLY - Related files: (1842485_1486492_a9108.dis)
				String featureTextNDISASMDisassembly = null;
				try {
					featureTextNDISASMDisassembly = Util.readFile(authorFileName.getParentFile()
					+ File.separator + authorFileName.getName()+".dis");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				 //get count of each NDISASMDisassemblyInstructionUnigram in NDISASM disassembly 
			    float[] instructionUnigramNDISASMCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionUnigramsTF(featureTextNDISASMDisassembly, NDISASMDisassemblyInstructionUnigrams);
			    for (int j=0; j<instructionUnigramNDISASMCount.length; j++)
				{Util.writeFile(instructionUnigramNDISASMCount[j] +",", output_filename, true);}	
			    
				 //get count of each NDISASMDisassemblyInstructionBigram in NDISASM disassembly 
			    float[] instructionBigramNDISASMCount = null;
				try {
					instructionBigramNDISASMCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionBigramsTF(featureTextNDISASMDisassembly, NDISASMDisassemblyInstructionBigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<instructionBigramNDISASMCount.length; j++)
				{Util.writeFile(instructionBigramNDISASMCount[j] +",", output_filename, true);}
			   	
				 //get count of each NDISASMDisassemblyInstructionTrigram in NDISASM disassembly 
			    float[] instructionTrigramNDISASMCount = null;
				try {
					instructionTrigramNDISASMCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionTrigramsTF(featureTextNDISASMDisassembly, NDISASMDisassemblyInstructionTrigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<instructionTrigramNDISASMCount.length; j++)
				{Util.writeFile(instructionTrigramNDISASMCount[j] +",", output_filename, true);}
			   	
				 //get count of each NDISASMDisassemblyLineBigrams in NDISASM disassembly 
			    float[] lineBigramNDISASMCount = null;
				try {
					lineBigramNDISASMCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyLineBigramsTF(featureTextNDISASMDisassembly, NDISASMDisassemblyLineBigrams);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<lineBigramNDISASMCount.length; j++)
				{Util.writeFile(lineBigramNDISASMCount[j] +",", output_filename, true);}	
			    // NDISASM FEATURES END - DISASSEMBLY - Related files: (1842485_1486492_a9108.dis)
			    	

		    	// Related files:
		      	// DECOMPILED CODE AKA SCAA FEATURES START (FROM HEXRAYS)
		    	// 1842485_1486492_a9108_hexrays_decompiled.cpp
				String featureTextHexraysDecompiledCodeCPP = null;
				try {
					featureTextHexraysDecompiledCodeCPP = Util.readFile(authorFileName.getParentFile()
					+ File.separator + authorFileName.getName()+"_hexrays_decompiled.cpp");
				} catch (IOException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				}
			    // 1842485_1486492_a9108_hexrays_decompiled.ast
				try {
					String featureTextHexraysDecompiledCodeAST = Util.readFile(authorFileName.getParentFile()
							+ File.separator + authorFileName.getName()+"_hexrays_decompiled.ast");
				} catch (IOException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			   	// 1842485_1486492_a9108_hexrays_decompiled.dep
				String featureTextHexraysDecompiledCodeDEP = null;
				try {
					featureTextHexraysDecompiledCodeDEP = Util.readFile(authorFileName.getParentFile()
							+ File.separator + authorFileName.getName()+"_hexrays_decompiled.dep");
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			   	// 1842485_1486492_a9108_hexrays_decompiled.txt
				try {
					String featureTextHexraysDecompiledCodeTXT = Util.readFile(authorFileName.getParentFile()
							+ File.separator + authorFileName.getName()+"_hexrays_decompiled.txt");
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			    	
				
			    //get count of each wordUnigram in C source file	 
			    float[] wordUniCountCPP = FeatureExtractorDecompiledCode.getWordUnigramsDecompiledCodeTF(featureTextHexraysDecompiledCodeCPP, wordUnigramsCPP);
			    for (int j=0; j<wordUniCountCPP.length; j++)
				{Util.writeFile(wordUniCountCPP[j] +",", output_filename, true);}	
				
			    //AST node bigrams
				float[] bigramCount = null;
				try {
					bigramCount = BigramExtractor.getASTNodeBigramsTF(featureTextHexraysDecompiledCodeDEP, ASTNodeBigramsTF );
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int j=0; j<ASTNodeBigramsTF.length; j++)
				{Util.writeFile(bigramCount[j] +",", output_filename, true);}	    
				    
				
			    //get count of each ASTtype not-DepAST type present	 
			    float[] typeCount = FeatureCalculators.DepASTTypeTF(featureTextHexraysDecompiledCodeDEP, ASTNodeTypesTF );
			    for (int j=0; j<ASTNodeTypesTF.length; j++)
				{Util.writeFile(typeCount[j] +",", output_filename, true);}	
			    
				//get tfidf of each AST Type present	 
			    float[] DepastTypeTFIDF = null;
				try {
					DepastTypeTFIDF = FeatureCalculators.DepASTTypeTFIDF(featureTextHexraysDecompiledCodeDEP, test_dir, ASTNodeTypeAvgDep);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    for (int j=0; j<ASTNodeTypeAvgDep.length; j++)
				{Util.writeFile(DepastTypeTFIDF[j]+",", output_filename, true);}	
				
			  /*  //get AST node avg depth
		    	float[] depFeature = null;
				try {
					depFeature = DepthASTNode.getAvgDepthASTNode(featureTextHexraysDecompiledCodeDEP,ASTtypes);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	for(int k=0;k<depFeature.length;k++)
				{Util.writeFile(depFeature[k] +",", output_filename, true);}	*/
			    
		    	float [] cppKeywordsTF =FeatureCalculators.getCandCPPKeywordsTF(featureTextHexraysDecompiledCodeCPP);
		    	for(int k=0;k<cppKeywordsTF.length;k++)
				{Util.writeFile(cppKeywordsTF[k] +",", output_filename, true);}		
			   	// Related files:
				// DECOMPILED CODE AKA SCAA FEATURES END (FROM HEXRAYS)
		       	// 1842485_1486492_a9108_hexrays_decompiled.cpp
			    // 1842485_1486492_a9108_hexrays_decompiled.ast
			    // 1842485_1486492_a9108_hexrays_decompiled.dep
			    // 1842485_1486492_a9108_hexrays_decompiled.txt
			    			    			   
				Util.writeFile(authorName+"\n", output_filename, true);
		   	} 	

	}	
		    
}