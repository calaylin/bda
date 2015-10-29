import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

/**
 * FeatureExtractor writes extracted features to arff file to be used with WEKA
 * @author Aylin Caliskan-Islam (ac993@drexel.edu)
 */

public class FeatureExtractorInfoGain {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		//list the cppKeywords that appear in infogain
		  String [] cppKeywords = {"extern",
				  "static",
				  "struct",
				  "and",
				  "this",
				 };
		  
	
    	String test_dir = "/mnt/data_bsd/allOptimizations/"
    			+ "";
    	

    	String output_filename = "/mnt/data_bsd/arffs/allOptimizations.arff" ;

    	
       	List test_file_paths = Util.listTextFiles(test_dir);

	String text = "";
  	//Writing the test arff
  	//first specify relation
	Util.writeFile("@relation IG "+"\n"+"\n", output_filename, true);
	Util.writeFile("@attribute instanceID {", output_filename, true);
	
   	List test_cpp_paths = Util.listCPPFiles(test_dir);
   	for(int j=0; j < test_cpp_paths.size();j++ ){
   	   	
   	   	File fileCPP = new File(test_cpp_paths.get(j).toString());
   		String fileName2 = fileCPP.getName();
   		
   		String authorName= (fileCPP.getParentFile().getName())+"_"+
   				(new File (fileCPP.getParent())).getParentFile().getName();
   		String fileName = authorName + "_" +fileName2;
   		System.out.println(fileName);
   		System.out.println(authorName);
   		
   		Util.writeFile(fileName+",", output_filename, true);
   		if ((j+1)==test_cpp_paths.size())
   			Util.writeFile("}"+"\n", output_filename, true);
	}
   	
   	

   	

	Util.writeFile("@attribute 'getMaxDepthASTLeaf' numeric"+"\n", output_filename, true);

    
//List the info gain nodes
	String[] wordUnigramsTF={"L);",
			"output",
			"solve()",
			"freopen(\"input.txt\",",
			"(F",
			"*stream);",
			"&s",
			"getchar(void);",
			"(__cdecl",
			"*stdout;",
			"*)&std::basic_ifstream<char,std::char_traits<char>>::~basic_ifstream,",
			"it;",
			"numberxFFFF);",
			"m);",
			"input.txt,",
			"(numberLL",
			"std::operator|(__intnumber",
			"printf(\"Case",
			"*)&std::basic_ofstream<char,std::char_traits<char>>::~basic_ofstream,",
			"scanf(\"",
			"(__intnumber",
			"des",
			"__cxa_atexit((const",
			"*vnumber)();",
			"solve(void);",
			"scanf(\"%d\",",
			"std::__ioinit;",
			"s);",
			"n\",",
			"mod",
			"stream",
			"std::operator<<<std::char_traits<char>>(",
			"output.txt,",
			"FILE",
			"&std::__ioinit,",
			"std::ostream::operator<<(",
			"printf(\"",
			"std::operator<<<std::char_traits<char>>(vnumber,",
			"(*vnumber)(void);",
			"(**vnumber)();",
			"std::basic_ifstream<char,std::char_traits<char>>::basic_ifstream(_DWORD,",
			"stdout);",
			"HIDWORD(anumber);",
			"freopen(",
			"T;",
			"std::ios_base::Init::Init((std::ios_base::Init",
			"&std::cout,",
			"_;",
			"std::istream::operator>>(",
			"(*)(void))*vnumber;",
			"*modes,",
			"std::operator<<<std::char_traits<char>>(_DWORD,",
			"*stdin;",
			"vnumber--",
			"scanf(\"%d",
			"*)std::ios_base::Init::~Init,",
			"*vnumber)",
			"std::ios_base::Init::~Init(std::ios_base::Init",
			"_CTOR_LIST__",
			"dest",
			"des,",
			"std::operator|(numberLL);",
			"*)())*vnumber;",
			"file",
			"%d,",
			"&_CTOR_LIST__;",
			"printf(const",
			"std::ostream::operator<<(_DWORD,",
			"dd",
			"init,",
			"numberLL)",
			"mat,",
			"...);",
			"e;",
			"HIDWORD(anumber)",
			"std::basic_ifstream<char,std::char_traits<char>>::~basic_ifstream;",
			"*format,",
			"stdout;",
			"std::cout;",
			"std::ostream::operator<<(vnumber,",
			"temp",
			"off_number",
			"(FILE",
			"of",
			"extern",
			"stdin);",
			"cout;",
			"out;",
			"__cxa_atexit(const",
			"std::istream::operator>>(_DWORD,",
			"stdin;",
			"printf(",
			"scanf(const",
			"(*)(void))_CTOR_LIST__;",
			"__static_initialization_and_destruction_number(int",
			"*this)",
			"this);",
			"*filename,",
			"(*)())number",
			"m)",
			"__static_initialization_and_destruction_number(number,",
			"*freopen(const",
			"std::operator<<<std::char_traits<char>>(&std::cout,",
			"solve(void)",
			"%",
			"vnumber--;",
			"xa",
			"vnumber++;",
			"tt",
			"tp",
			"sc",
			"freopen(\"output.txt\",",
			"_dso_handle;",
			"*)&std::__ioinit);",
			"s)",
			"stream);",
			"getchar();",
			"std::basic_ofstream<char,std::char_traits<char>>::~basic_ofstream;",
			"solve();",
			"std::basic_ofstream<char,std::char_traits<char>>::basic_ofstream(_DWORD,",
			"numberxFFFF",
			"&_dso_handle);",
			"_CTOR_LIST__;",
			"%d",
			"__cxa_atexit(",
			"&t)",
			"*this);",
			"numberLL);",
			"*)s",
			",",
			":",
			"std::ios_base",
			"w,",
			"r,",
			"*__hidden",
			"%d",
			"#\");",
			"#%d:",
			"::i",
			"r",
			"*)&s",
			"std::ios_base::Init::Init(std::ios_base::Init",
			"%d\",",
			"&T);",
			"&t);",		
	};
	

	
    	String[] ASTtypesTF = {"small",
    			"in",
    			"solve",
    			"0xFFFF",
    			"InclusiveOrExpression",
    			"while",
    			"printf",
    			"__cxa_atexit",
    			"137438953488L",
    			"istream",
    			"_dso_handle",
    			"stdin",
    			"__cdecl",
    			"_CTOR_LIST__",
    			"basic_ofstream",
    			"getchar",
    			"T",
    			"stdout",
    			"57",
    			"47",
    			"__static_initialization_and_destruction_0",
    			"void",
    			"ostream",
    			"IncDecOp",
    			"scanf",
    			"freopen",
    			"basic_ifstream"
    			};
    	
    	String[] ASTbigramsTF={"CompoundStatement IdentifierDeclStatement",	"ShiftExpression AdditiveExpression",
    			"Argument s",	"n Callee",	"int ca",	"AssignmentExpr ca",	"IncDecOp ca",	"p i",	"Argument For",
    			"e Callee",	"RelationalExpression IncDecOp",	"Argument f",	"f Argument",	"1 C",	"e i",	
    			"Argument st",	"st Argument",	"ShiftExpression in",	"in t",	"t in",	"0 0",	"t cas",	"0 int",
    			"T R",	"T ExpressionStatement",	"cin T",	"T For",	"t cases",	"T ShiftExpression",
    			"T cin",	"m f",	"RelationalExpression ca",	"se AssignmentExpr",	"AssignmentExpr te",
    			"RelationalExpression te",	"IncDecOp te",	"t FOR",	"v Parameter",	"RelationalExpression t",
    			"t T",	"Callee solv",	"AssignmentExpr t",	"t t",	"Callee print",	"st Parameter",	"p CallExpression",
    			"Expression c",	"T c",	"t ForInit",	"fstream fin",	"in ExpressionStatement",
    			"ShiftExpression fin",	"n fin",	"in CallExpression",	"it AssignmentExpr",
    			"cas AssignmentExpr",	"AssignmentExpr cas",	"IncDecOp cas",	"RelationalExpression I",	
    			"r Condition",	"Expression Callee",	"it IdentifierDeclStatement",	"Callee i",	
    			"ShiftExpression fout",	"fout ShiftExpression",	"AssignmentExpr case",	"n c",	"T Expression",
    			"ShiftExpression A",	"stdout ExpressionStatement",	"Callee f",	"f ArgumentList",
    			"Argument WhileStatement",	"IncDecOp T",	"T CompoundStatement",	"T WhileStatement",	"t S",
    			"n Argument",	"Argument UnaryExpression",	"t 0",	"Callee fopen",	"fopen ArgumentList",
    			"o Argument",	"Parameter char",	"RelationalExpression cas",	"IdentifierDeclStatement IdentifierDecl",
    			"ForStatement ForInit",	"nt IdentifierDecl",	"nt ShiftExpression",	"st 1",	"t UnaryExpression",
    			"ForInit IdentifierDeclStatement",	"Argument R",	"UnaryExpression C",	"0 i",	"r int",
    			"IdentifierDecl Condition",	"T U",	"T S",	"p T",	"RelationalExpression test",	"IncDecOp test",
    			"int test",	"test AssignmentExpr",	"AssignmentExpr test",	"test 1",	"Argument test",
    			"IdentifierDecl if",	"Callee sc",	"r const",	"in T",	"T in",	"s cin",	"it IdentifierDecl",
    			"RelationalExpression tc",	"IncDecOp tc",	"int tc",	"tc AssignmentExpr",	"AssignmentExpr tc",
    			"tc 1",	"ShiftExpression c",	"ShiftExpression ReturnStatement",	"Expression IncDecOp",	"in Callee",	
    			"out Callee",	"t Parameter",	"Argument i",	"t tt",	"in C",	"n UnaryExpression",	"e 1",	"t s",	
    			"Condition UnaryExpression",	"UnaryExpression CompoundStatement",	"UnaryOp C",	
    			"RelationalExpression UnaryExpression",	"IncDecOp i",	"Expression t",	"n IncDecOp",	"l Condition",	"int cas",	"i T",	"T UnaryExpression",	"i CompoundStatement",	"t std",	"1 i",	"Argument te",	"int te",	"s int",	"s Callee",	"c int",	"IncDecOp c",	"t F",	"Argument A",	"CallExpression Callee",	"Argument W",	"p c",	"Callee fr",	"Callee scan",	"int ParameterList",	"se i",	"ParameterList Parameter",	"Parameter int",	"Argument IncDecOp",	"e ReturnStatement",	"e CallExpression",	"e int",	"Argument F",	"IdentifierDecl ofstream",	"out IdentifierDeclStatement",	"Callee ForInit",	"Callee ios",	"sync_with_stdio ArgumentList",	"false CallExpression",	"false Callee",	"Callee s",	"IdentifierDecl ifstream",	"e p",	"out IdentifierDecl",	"in c",	"c in",	"test A",	"int P",	"ExpressionStatement CallExpression",	"out ShiftExpression",	"AssignmentExpr C",	"e s",	"1 IdentifierDeclStatement",	"1 Condition",	"se int",	"Callee sol",	"ShiftExpression i",	"Argument FOR",	"int cases",	"ReturnStatement 0",	"0 IdentifierDeclStatement",	"r i",	"AdditiveExpression t",	"int ar",	"en Argument",	"c i",	"T E",	"T i",	"Argument Ret",	"solve ReturnStatement",	"Callee printf",	"t test",	"T C",	"printf ArgumentList",	"ArgumentList Argument",	"Argument Argument",	"ShiftExpression ci",	"int T",	"T IdentifierDecl",	"s IncDecOp",	"s RelationalExpression",
    			"Callee scanf",	"scanf ArgumentList",	"Argument ForStatement",	"ForInit AssignmentExpr",	"T IncDecOp",
    			"T int",	"Argument UnaryOp",	"UnaryOp CallExpression",	"T Callee",	"T ForStatement",	
    			"T RelationalExpression",	"AssignmentExpr Condition",	"RelationalExpression tt",	"IncDecOp tt",
    			"1 IdentifierDecl",	"out ExpressionStatement",	"open ArgumentList",	"out CallExpression",	
    			"Argument ReturnStatement",	"ExpressionStatement ShiftExpression",	"solve ExpressionStatement",	"int t",	"t IdentifierDecl",	"int tt",	"AssignmentExpr tt",	"IncDecOp t",	"t int",	"i int",	"Argument t",	"t CallExpression",	"t Callee",	"ShiftExpression cout",	"cout ShiftExpression",	"ShiftExpression cin",	"int c",	"cin t",	"i t",	"n fi",	"p t",	"t UnaryOp",	"t ShiftExpression",	"t cin",	"t RelationalExpression",	"RelationalExpression c",	"Expression UnaryExpression",	"ShiftExpression fo",	"Argument std",	"Callee freopen",	"freopen ArgumentList",	"tt AssignmentExpr",	"t 1",	"0 Condition",	"Argument stdin",	"stdin CallExpression",	"stdin Callee",	"stdin ExpressionStatement",	"Argument stdout",	"int argc",	"argc Parameter",	"stdout CallExpression",	"argv Parameter",	"argc int",	"argv char",	"stdout Callee",	"stdout IdentifierDeclStatement",	"n CallExpression",	"n cin",	"i i",	"t Argument",	"c Parameter",	"Callee solve",	"t Condition",	"Condition IncDecOp",	"1 int",	"ShiftExpression t"		
    	
    	
    	};
    	
        String[] ASTtypesTFIDF = {"solve",
        		"InclusiveOrExpression",
        		"137438953488L",
        		"_CTOR_LIST__",
        		"basic_ofstream",
        		"getchar",
        		"IncDecOp",
        		"scanf",
        		"basic_ifstream"};
        String[] ASTtypesAvgDep = {"solve",
        		"txt",
        		"printf",
        		"137438953488L",
        		"stdin",
        		"_CTOR_LIST__",
        		"basic_ofstream",
        		"getchar",
        		"T",
        		"stdout",
        		"47",
        		"out",
        		"output",
        		"d",
        		"w",
        		"r",
        		"input",
        		"IncDecOp",
        		"scanf",
        		"freopen",
        		"basic_ifstream",
        		"small",
        		"in",
        };
        
	       String[] disassemblyUnigramsBjoern ={"sym.imp.scanf",
	    		   "sym.imp._ZNSirsERi","sym.imp.freopen","sym.imp._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc",
	    		   "sym.imp.printf","sym.imp._ZNSolsEi","sym.imp._ZNSolsEPFRSoS_E",
	    	"sym.imp._ZNSolsEi","sym.imp._ZNSolsEPFRSoS_E","sym.imp._ZNStnumberios_basenumberInitCnumberEv",
	    	"reloc._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc_number",
	    	"[reloc._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc_number]",
	    	"reloc._ZNSolsEi_number",
	    	"[reloc._ZNSolsEi_number]",
	    	"[reloc._ZNSirsERi_number]",
	    	"reloc._ZNSirsERi_number",
	    	"reloc._ZNSolsEPFRSoS_E_number",
	    	"[reloc._ZNSolsEPFRSoS_E_number]",
	    	"sym._ZStorStnumber_Ios_OpenmodeS_",
	    	"sym.imp.__cxa_atexit",
	    	"reloc.freopen_number",
	    	"[reloc.freopen_number]",
	    	"sym._Znumber__static_initializ	ation_and_destruction_numberii",
	    	"ebp+numberxffff","reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv_number",
	    	"ebp+numberxff",
	    	"ebp+numberxf",
	    	"[numberxffff:number]=-number",
	    	"numberxfff",
	    	"numberxffff","[reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv_number]",
	    	"[numberxnumber:number]=numberxnumbercnumber",
	    	"[numberxnumber:number]=numberxnumberc",
	    	"sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
	    	"numberxff",
	    	"sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
	    	"sym._Znumbersolvev", "sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv",
	    	"sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv",
	    	"[reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number]",
	    	"reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number",
	      "reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv_number",
	      "[reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv_number]",
	      "[reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number]",
	      "reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number",
	      "[esp],numberxnumber",	"sym.imp.getc",
			"sym.imp.getchar", "str.Case__",
			"sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEv",
	       "sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEnumberopenEPKcStnumber_Ios_Openmode",
	       };
		       
		   	
		   String[] disassemblyBigramsBjoern ={"[Func sym.imp.freopen","[Func sym.imp.scanf",
				   "Func sym.imp._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc",
				   "Func sym.imp._ZNSirsERi","Func sym.imp.printf","Func sym.imp._ZNSolsEi",
				   "Func sym.imp._ZNSolsEPFRSoS_E","[call sym.imp._ZNStnumberios_basenumberInitCnumberEv",
				   "Func sym.imp._ZNSolsEPFRSoS_E","call sym.imp._ZNStnumberios_basenumberInitCnumberEv",
				   "Func sym.imp._ZNStnumberios_basenumberInitCnumberEv","[esp], numberxnumber",
				   "[; reloc._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc_number",
				   "[reloc._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc_number] ;",
				   "[dword [reloc._ZStlsIStnumberchar_traitsIcEERStnumberbasic_ostreamIcT_ESnumber_PKc_number]",
				   "[reloc._ZNSolsEi_number] ;","; reloc._ZNSolsEi_number","dword [reloc._ZNSolsEi_number]",
				   "dword [reloc._ZNSirsERi_number]", "Func sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv",
				   "; reloc._ZNSirsERi_number","[reloc._ZNSirsERi_number] ;",
				   "[reloc._ZNSolsEPFRSoS_E_number] ;","; reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv_number",
				   "dword [reloc._ZNSolsEPFRSoS_E_number]",
				   "; reloc._ZNSolsEPFRSoS_E_number","dword [reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv_number]",
				   "Func sym.imp.__cxa_atexit",   "call sym.imp.__cxa_atexit",   "dword [reloc.freopen_number]", "[reloc.freopen_number] ;",
				   "; reloc.freopen_number","Func sym._Znumber__static_initialization_and_destruction_numberii",
				   "int ebp+numberxffff", "numberxffff ;","numberxffff cmp",
				   "int ebp+numberxff",  "numberxc], numberxffff",
				   "; [numberxffff:number]=-number","[reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv_number] ;",
				   "; [numberxnumber:number]=numberxnumbercnumber",
				   "; [numberxnumber:number]=numberxnumberc","call sym.imp.scanf",
				   "[ebp +","number], numberxnumber", "Func sym._ZStorStnumber_Ios_OpenmodeS_",
				   "numberxc], number", "[esp], number", "edx or",
				   "Func sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
				   "Func sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
		   "call sym.imp._ZNSirsERi","[reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number] ;",
		   "Func sym._Znumbersolvev","; reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number",
		   "Func sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEDnumberEv",
		   "dword [reloc._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number]",
		   "dword [reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv_number]",
		   "[reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv_number] ;",
		   "; reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEEDnumberEv_number",
		   "[reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number] ;",
		"; reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number",
		"dword [reloc._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode_number]",
		"LEA str.Case__","; str.Case__","Func sym.imp.getchar",
		"call sym._ZStorStnumber_Ios_OpenmodeS_","Func sym.imp.getc",
		"call sym.imp._ZNStnumberbasic_ifstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
		  "call sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEPKcStnumber_Ios_Openmode",
		  "Func sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEECnumberEv",
		  "Func sym.imp._ZNStnumberbasic_ofstreamIcStnumberchar_traitsIcEEnumberopenEPKcStnumber_Ios_Openmode"
		   };
		        
		    	
		   String[] disassemblyUnigramsNDISASM ={"out","std","int","fs","fst","sub","cx","ah"};
			       
		   String[] disassemblyBigramsNDISASM ={"arpl [cs:eax",	"ebp [fs:esi",	"gs outsd",	"inc ax",	
				   "gs xor",	"[ebx eax*2",	"add [fs:ebx",	"ebp [edi",	"esi [esp",	"[esp eax*2",
				   "ch [esi]",	"ch [esi",	"[fs:esi",	"xor ch",	"cmp [esi]",	"eax*2",	
				   "cmp [esi",	"o16 add",	"jng near",	"ebp [cs:esi",	"or ch",	"[esi] ebp",	
				   "fs outsd",	"[cs:esi",	"fs out",	"[cs:eax",	"esi [edx",	"si [edx",	"esp [edx",	
				   "[ebx esi*2",	"[esi] dh",	"[ecx] dword",	"bound ebx",	"ecx [ecx]",	
				   "pop eax",	"gs jna",	"inc edx",	"esi] dh",	"or [esi]",	"o16 jnc",	"imul ecx",
				   "mul ecx",	"[ecx ebp*2",	"cs jz",	"[esi esi*2",	"cs outsd",	"cmp byte"};

	       String[] cfgUnigrams ={"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= <0:0>) nodeNewline if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    		   "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= <0:0>) nodeNewline if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    		   "basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = zero_extend ~<0:0> nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline if ~<0:0> goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    		   "CFGUnigrams 57=[basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = <0:0> nodeNewline <0:0> = [<0:0>] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [<0:0>] nodeNewline goto address <0:0> nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> | <0:0>) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = [<0:0>] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [<0:0>] nodeNewline goto address <0:0> nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> & hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline goto address hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = ([(<0:0> + hexadecimal)] + hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline goto basic block hexadecimal nodeNewline"	    	
	       };
	    	
	       String[] cfgNodeLastLine ={"<0:0> = [hexadecimal]"
	    		};
    	
	    	//get the bigrams in the CFG and write the bigram features
	    	String[] cfgBigrams ={"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = <0:0> nodeNewline <0:0> = [<0:0>] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [<0:0>] nodeNewline goto address <0:0> nodeNewline   basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline goto address hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline goto address [hexadecimal] nodeNewline   basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= <0:0>) nodeNewline if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline goto address [hexadecimal] nodeNewline   basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> | <0:0>) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = [<0:0>] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [<0:0>] nodeNewline goto address <0:0> nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> | <0:0>) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = [<0:0>] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [<0:0>] nodeNewline goto address <0:0> nodeNewline   basicBlockhexadecimal   Address: hexadecimal nodeNewline goto address [hexadecimal] nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline goto address [hexadecimal] nodeNewline   basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = zero_extend ~<0:0> nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline if ~<0:0> goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= <0:0>) nodeNewline if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline   basicBlockhexadecimal   Address: hexadecimal nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = ([(<0:0> + hexadecimal)] + hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline goto basic block hexadecimal nodeNewline",
	   
	    	};
	 
	    	//get the bigrams in the CFG and write the bigram features
	    	String[] cfgLineBigrams ={"<0:0> = [hexadecimal] [(<0:0> + hexadecimal)] = <0:0>",
	    			"<0:0> = [hexadecimal] [(<0:0> + hexadecimal)] = <0:0>",
	    			"<0:0> = [(<0:0> + hexadecimal)] <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< <0:0>)",
	    			"<0:0> = intrinsic(0) <0:0> = [hexadecimal]",
	    			"<0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= <0:0>) if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal",
	    			"<0:0> = (<0:0> + hexadecimal) <0:0> = [hexadecimal]","","",
	    	"[(<0:0> + hexadecimal)] = hexadecimal [<0:0>] = <0:0>",
	    	"<0:0> = intrinsic(0) <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< hexadecimal)",
	    	"<0:0> = [(<0:0> + hexadecimal)] <0:0> = (<0:0> | <0:0>)",
	    	
	    	};
	
	    	  	//16 tfidf attributes
	    	String[] cfgUnigramsTFIDF={"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= <0:0>) nodeNewline if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = zero_extend ~<0:0> nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline if ~<0:0> goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> & hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline goto address hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = ~(<0:0> == hexadecimal) nodeNewline <0:0> = -<0:0> nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline goto address hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline goto basic block hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= hexadecimal) nodeNewline if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = (<0:0> (unsigned)< [(<0:0> + hexadecimal)]) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == [(<0:0> + hexadecimal)]) nodeNewline <0:0> = (<0:0> (signed)< [(<0:0> + hexadecimal)]) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> (signed)< [(<0:0> + hexadecimal)]) nodeNewline <0:0> = (<0:0> (signed)<= [(<0:0> + hexadecimal)]) nodeNewline <0:0> = (<0:0> (unsigned)<= [(<0:0> + hexadecimal)]) nodeNewline if ~choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline goto basic block hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= hexadecimal) nodeNewline <0:0> = zero_extend <0:0> nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= hexadecimal) nodeNewline if <0:0> goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> << hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> + <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = (<0:0> + <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = <0:0> nodeNewline <0:0> = sign_extend [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline goto basic block hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [hexadecimal] nodeNewline <0:0> = [hexadecimal] nodeNewline <0:0> = (<0:0> (unsigned)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == <0:0>) nodeNewline <0:0> = (<0:0> (signed)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> (signed)< <0:0>) nodeNewline <0:0> = (<0:0> (signed)<= <0:0>) nodeNewline <0:0> = (<0:0> (unsigned)<= <0:0>) nodeNewline if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = ~([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = -[(<0:0> + hexadecimal)] nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline goto basic block hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> >> hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> (signed)% <0:0>) nodeNewline <0:0> = (<0:0> (signed)/ <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = <0:0> nodeNewline [((<0:0> + (<0:0> * hexadecimal)) + hexadecimal)] = <0:0> nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> * <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> >> hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> >> hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> (signed)< <0:0>) nodeNewline <0:0> = (<0:0> (signed)<= <0:0>) nodeNewline <0:0> = (<0:0> (unsigned)< <0:0>) nodeNewline <0:0> = (<0:0> (unsigned)<= <0:0>) nodeNewline <0:0> = (<0:0> - <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = <0:0> nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline goto basic block hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline [((<0:0> + (<0:0> * hexadecimal)) + hexadecimal)] = hexadecimal nodeNewline goto basic block hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = [((<0:0> + (<0:0> * hexadecimal)) + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline goto basic block hexadecimal nodeNewline",
	    			"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= hexadecimal) nodeNewline if ~<0:0> goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = [((<0:0> + (<0:0> * hexadecimal)) + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline goto basic block hexadecimal nodeNewline",		
	    	
	    	
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= <0:0>) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= <0:0>) nodeNewline if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = ~(<0:0> == hexadecimal) nodeNewline <0:0> = -<0:0> nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline goto address hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = zero_extend ~<0:0> nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline if ~<0:0> goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> & hexadecimal) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline goto address hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = hexadecimal nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = ([(<0:0> + hexadecimal)] + hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline goto basic block hexadecimal nodeNewline",	    	
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= hexadecimal) nodeNewline if ~<0:0> goto address hexadecimal else goto basic block hexadecimal nodeNewline",	    	
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= hexadecimal) nodeNewline <0:0> = zero_extend <0:0> nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= hexadecimal) nodeNewline if <0:0> goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> << hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> + <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = (<0:0> + <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = <0:0> nodeNewline <0:0> = sign_extend [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline goto basic block hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= hexadecimal) nodeNewline if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline goto basic block hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline goto basic block hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = (<0:0> (unsigned)< [(<0:0> + hexadecimal)]) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == [(<0:0> + hexadecimal)]) nodeNewline <0:0> = (<0:0> (signed)< [(<0:0> + hexadecimal)]) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> (signed)< [(<0:0> + hexadecimal)]) nodeNewline <0:0> = (<0:0> (signed)<= [(<0:0> + hexadecimal)]) nodeNewline <0:0> = (<0:0> (unsigned)<= [(<0:0> + hexadecimal)]) nodeNewline if ~choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> | <0:0>) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline <0:0> = [<0:0>] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = [<0:0>] nodeNewline goto address <0:0> nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [hexadecimal] nodeNewline <0:0> = [hexadecimal] nodeNewline <0:0> = (<0:0> (unsigned)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == <0:0>) nodeNewline <0:0> = (<0:0> (signed)< <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> (signed)< <0:0>) nodeNewline <0:0> = (<0:0> (signed)<= <0:0>) nodeNewline <0:0> = (<0:0> (unsigned)<= <0:0>) nodeNewline if choice(<0:0> over (<0:0> | ~(<0:0> == <0:0>))) goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline goto address hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = <0:0> nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = (<0:0> (signed)<= hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)< hexadecimal) nodeNewline <0:0> = (<0:0> (unsigned)<= hexadecimal) nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)< hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (signed)<= hexadecimal) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] (unsigned)<= hexadecimal) nodeNewline if ~<0:0> goto address hexadecimal else goto basic block hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> >> hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> (signed)% <0:0>) nodeNewline <0:0> = (<0:0> (signed)/ <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = <0:0> nodeNewline [((<0:0> + (<0:0> * hexadecimal)) + hexadecimal)] = <0:0> nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = hexadecimal nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> * <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> >> hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = <0:0> nodeNewline <0:0> = (<0:0> >> hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> (signed)< <0:0>) nodeNewline <0:0> = (<0:0> (signed)<= <0:0>) nodeNewline <0:0> = (<0:0> (unsigned)< <0:0>) nodeNewline <0:0> = (<0:0> (unsigned)<= <0:0>) nodeNewline <0:0> = (<0:0> - <0:0>) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = (<0:0> == hexadecimal) nodeNewline <0:0> = (<0:0> (signed)< hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = <0:0> nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline goto basic block hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline [<0:0>] = hexadecimal nodeNewline <0:0> = (<0:0> - hexadecimal) nodeNewline [<0:0>] = hexadecimal nodeNewline call hexadecimal nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline <0:0> = ~([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = -[(<0:0> + hexadecimal)] nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = ([(<0:0> + hexadecimal)] == hexadecimal) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline <0:0> = intrinsic(0) nodeNewline kill(<0:0>) nodeNewline goto basic block hexadecimal nodeNewline",
	    	"basicBlockhexadecimal   Address: hexadecimal nodeNewline <0:0> = [(<0:0> + hexadecimal)] nodeNewline <0:0> = (<0:0> + hexadecimal) nodeNewline [(<0:0> + hexadecimal)] = <0:0> nodeNewline [((<0:0> + (<0:0> * hexadecimal)) + hexadecimal)] = hexadecimal nodeNewline goto basic block hexadecimal nodeNewline",

	    	
	    	
	    	};
        
        for (int i=0; i<wordUnigramsTF.length; i++)	
        	
        {  	wordUnigramsTF[i] = wordUnigramsTF[i].replace("'", "apostrophesymbol");
          	Util.writeFile("@attribute 'wordUnigramsTF "+i+"=["+wordUnigramsTF[i]+"]' numeric"+"\n", output_filename, true);}
              
    for (int i=0; i<ASTtypesTF.length; i++)	
    	
  {  	ASTtypesTF[i] = ASTtypesTF[i].replace("'", "apostrophesymbol");
    	Util.writeFile("@attribute 'ASTNodeTypesTF "+i+"=["+ASTtypesTF[i]+"]' numeric"+"\n", output_filename, true);}
  
    for (int i=0; i<ASTbigramsTF.length; i++)	
    	
  {  	ASTbigramsTF[i] = ASTbigramsTF[i].replace("'", "apostrophesymbol");
    	Util.writeFile("@attribute 'ASTbigramsTF "+i+"=["+ASTbigramsTF[i]+"]' numeric"+"\n", output_filename, true);}
    
    
    
    for (int i=0; i<ASTtypesTFIDF.length; i++)	
  {	    ASTtypesTFIDF[i] = ASTtypesTFIDF[i].replace("'", "apostrophesymbol");
    	Util.writeFile("@attribute 'ASTNodeTypesTFIDF "+i+"=["+ASTtypesTFIDF[i]+"]' numeric"+"\n", output_filename, true);}
    
    for (int i=0; i<ASTtypesAvgDep.length; i++)	
  {	    ASTtypesAvgDep[i] = ASTtypesAvgDep[i].replace("'", "apostrophesymbol");
    	Util.writeFile("@attribute 'ASTNodeTypeAvgDep "+i+"=["+ASTtypesAvgDep[i]+"]' numeric"+"\n", output_filename, true);}
    for (int i=0; i<cppKeywords.length; i++)	
  {	Util.writeFile("@attribute 'cppKeyword "+i+"=["+cppKeywords[i]+"]' numeric"+"\n", output_filename, true);}

	    	for (int i=0; i<disassemblyUnigramsBjoern.length; i++)	   	
	       {  	disassemblyUnigramsBjoern[i] = disassemblyUnigramsBjoern[i].replace("'", "apostrophesymbol");
	            	Util.writeFile("@attribute 'disassemblyUnigramsBjoern "+i+"=["+disassemblyUnigramsBjoern[i]+"]' numeric"+"\n", output_filename, true);}
		   
	   	
	     	for (int i=0; i<disassemblyBigramsBjoern.length; i++)	   	
		       {  	disassemblyBigramsBjoern[i] = disassemblyBigramsBjoern[i].replace("'", "apostrophesymbol");
		            	Util.writeFile("@attribute 'disassemblyBigramsBjoern "+i+"=["+disassemblyBigramsBjoern[i]+"]' numeric"+"\n", output_filename, true);}
	     	
	    	for (int i=0; i<disassemblyUnigramsNDISASM.length; i++)	   	
		       {  	disassemblyUnigramsNDISASM[i] = disassemblyUnigramsNDISASM[i].replace("'", "apostrophesymbol");
		            	Util.writeFile("@attribute 'disassemblyUnigramsNDISASM "+i+"=["+disassemblyUnigramsNDISASM[i]+"]' numeric"+"\n", output_filename, true);}
			   
		   	
		    for (int i=0; i<disassemblyBigramsNDISASM.length; i++)	   	
			       {  	disassemblyBigramsNDISASM[i] = disassemblyBigramsNDISASM[i].replace("'", "apostrophesymbol");
			            	Util.writeFile("@attribute 'disassemblyBigramsNDISASM "+i+"=["+disassemblyBigramsNDISASM[i]+"]' numeric"+"\n", output_filename, true);}

		    	for (int i=0; i<cfgUnigrams.length; i++)	   	
		       {  	//cfgUnigrams[i] = cfgUnigrams[i].replace("'", "apostrophesymbol");
		            	Util.writeFile("@attribute 'CFGUnigrams "+i+"=["+cfgUnigrams[i]+"]' numeric"+"\n", output_filename, true);}
			   

		    	
	     	for (int i=0; i<cfgBigrams.length; i++)	   	
		       {  //	cfgBigrams[i] = cfgBigrams[i].replace("'", "apostrophesymbol");
	     				String temp= cfgBigrams[i];
		            	Util.writeFile("@attribute 'CFGBigrams "+i+"=["+temp.replace("\n", " ")+"]' numeric"+"\n", output_filename, true);}

	    	for (int i=0; i<cfgNodeLastLine.length; i++)	   	
	       {  	//cfgUnigrams[i] = cfgUnigrams[i].replace("'", "apostrophesymbol");
	            	Util.writeFile("@attribute 'cfgNodeLastLine "+i+"=["+cfgNodeLastLine[i]+"]' numeric"+"\n", output_filename, true);}

	     	for (int i=0; i<cfgLineBigrams.length; i++)	   	
		       {  //	cfgBigrams[i] = cfgBigrams[i].replace("'", "apostrophesymbol");
	     				String temp= cfgLineBigrams[i];
		            	Util.writeFile("@attribute 'cfgLineBigrams "+i+"=["+temp.replace("\n", " ")+"]' numeric"+"\n", output_filename, true);}

	    	for (int i=0; i<cfgUnigramsTFIDF.length; i++)	   	
		       {  	//cfgUnigrams[i] = cfgUnigrams[i].replace("'", "apostrophesymbol");
		            	Util.writeFile("@attribute 'cfgUnigramsTFIDF "+i+"=["+cfgUnigramsTFIDF[i]+"]' numeric"+"\n", output_filename, true);}
			   

	     	
	     	
    
    
    
    File authorFileName = null;
	//Writing the classes (authorname)
	Util.writeFile("@attribute 'authorName' {",output_filename, true);
	for(int i=0; i< test_file_paths.size(); i++){
		int testIDlength = test_file_paths.get(i).toString().length();   
		authorFileName= new File(test_file_paths.get(i).toString());
		String authorName= (authorFileName.getParentFile().getName())+"_"+
				(new File (authorFileName.getParent())).getParentFile().getName();

		text = text.concat(authorName + ",");  
		String[] words = text.split( ",");
		  Set<String> uniqueWords = new HashSet<String>();

		   for (String word : words) {
		       uniqueWords.add(word);
		   }
		   words = uniqueWords.toArray(new String[0]);
		   int authorCount = words.length;
		   if (i+1==test_file_paths.size()){
		   for (int j=0; j< authorCount; j++){
			   {System.out.println(words[j]);
				if(j+1 == authorCount)
				{
			   Util.writeFile(words[j]+"}"+"\n\n",output_filename, true);
				}
				else
				{
				Util.writeFile(words[j]+","+"",output_filename, true);

					}
				}
			   }

		   }
		   
		 }
	
   	
	Util.writeFile("@data"+"\n", output_filename, true);	
	//Finished defining the attributes
	
	
	//EXTRACT LABELED FEATURES
   	for(int i=0; i< test_file_paths.size(); i++){
		String featureText = Util.readFile(test_file_paths.get(i).toString());
		int testIDlength = test_file_paths.get(i).toString().length(); 
		authorFileName= new File(test_file_paths.get(i).toString());
		String authorName= (authorFileName.getParentFile().getName())+"_"+
				(new File (authorFileName.getParent())).getParentFile().getName();
		System.out.println(authorFileName);
		System.out.println(authorName);

		File fileCPPID = new File(test_cpp_paths.get(i).toString());
		String fileNameID =authorName + "_"+fileCPPID.getName();
		Util.writeFile(fileNameID+",", output_filename, true);
//		Util.writeFile(FeatureCalculators.functionIDCount(featureText)+",", output_filename, true);
		String ASTText = Util.readFile(test_file_paths.get(i).toString().substring(0,testIDlength-3)+"ast");
		String DepASTText = Util.readFile(test_file_paths.get(i).toString().substring(0,testIDlength-3)+"dep");
		String sourceCode = Util.readFile(test_file_paths.get(i).toString().substring(0,testIDlength-3)+"cpp");
		String disText = Util.readFile(test_file_paths.get(i).toString().substring(0,testIDlength-23)+".dis");
		String cfgText = Util.readFile(test_file_paths.get(i).toString().substring(0,testIDlength-22)+"SnowmanDecompiled.dot");

		String bjoernText = Util.readFile(authorFileName.getParentFile()
				+ File.separator + "output_"+fileCPPID.getName().substring(0, (fileCPPID.getName().length()-23))+
				File.separator + "nodes.csv");
//		Util.writeFile(FeatureCalculators.CFGNodeCount(ASTText)+",", output_filename, true);
//		Util.writeFile(FeatureCalculators.ASTFunctionIDCount(ASTText)+",", output_filename, true);
		Util.writeFile(DepthASTNode.getMaxDepthASTLeaf(DepASTText, ASTtypesTF)+",", output_filename, true);
		
	    float[] unigramCount = FeatureCalculators.WordUnigramTF(sourceCode, wordUnigramsTF);
	    for (int j=0; j<wordUnigramsTF.length; j++)
		{Util.writeFile(unigramCount[j] +",", output_filename, true);}
	    
	    //get count of each ASTtype not-DepAST type present	 
	    float[] typeCount = FeatureCalculators.DepASTTypeTF(DepASTText, ASTtypesTF );
	    for (int j=0; j<ASTtypesTF.length; j++)
		{Util.writeFile(typeCount[j] +",", output_filename, true);}	
	    
	    float[] bigramCount = BigramExtractor.getASTNodeBigramsTF(DepASTText, ASTbigramsTF );
	    for (int j=0; j<ASTbigramsTF.length; j++)
		{Util.writeFile(bigramCount[j] +",", output_filename, true);}
	 
	    
		//get tfidf of each AST Type present	 
	    float[] DepastTypeTFIDF = FeatureCalculators.DepASTTypeTFIDF(DepASTText, test_dir, ASTtypesTFIDF);
	    for (int j=0; j<ASTtypesTFIDF.length; j++)
		{Util.writeFile(DepastTypeTFIDF[j]+",", output_filename, true);}	
		
    	float [] depFeature =DepthASTNode.getAvgDepthASTNode(DepASTText,ASTtypesAvgDep);
    	for(int k=0;k<depFeature.length;k++)
		{Util.writeFile(depFeature[k] +",", output_filename, true);}	
	    
    	float [] cppKeywordsTF =FeatureCalculators.getInfoGainCPPKeywordsTF(sourceCode, cppKeywords);
    	for(int k=0;k<cppKeywordsTF.length;k++)
		{Util.writeFile(cppKeywordsTF[k] +",", output_filename, true);}	
   
   
		    
	    //get count of each wordUnigram in bjoern disassembly 
	    float[] wordUniCount = FeatureExtractorBjoern.getBjoernUnigramTF(bjoernText, disassemblyUnigramsBjoern);
	    for (int j=0; j<wordUniCount.length; j++)
		{Util.writeFile(wordUniCount[j] +",", output_filename, true);}	
	    
	    //get count of each bigram in bjoern disassembly	 
	    float[] wordBigramCount = FeatureExtractorBjoern.getBjoernBigramsTF(bjoernText, disassemblyBigramsBjoern);
	    for (int j=0; j<wordBigramCount.length; j++)
		{Util.writeFile(wordBigramCount[j] +",", output_filename, true);}


		//FeatureExtractorDisassembly for ndisasm
		 //get count of each wordUnigram in disassembly 
	    float[] wordNDUniCount = FeatureExtractorDisassembly.getDisUnigramTF(disText, disassemblyUnigramsNDISASM);
	    for (int j=0; j<wordNDUniCount.length; j++)
		{Util.writeFile(wordNDUniCount[j] +",", output_filename, true);}	
	    
	    //get count of each bigram in in disassembly	 
	    float[] wordNDBigramCount = FeatureExtractorDisassembly.getDisBigramsTF(disText, disassemblyBigramsNDISASM);
	    for (int j=0; j<wordNDBigramCount.length; j++)
		{Util.writeFile(wordNDBigramCount[j] +",", output_filename, true);}    
		
		
	    //get count of each wordUnigram in cfg 
	    float[] wordUniCount1 = FeatureExtractorCFGDisassembly.getCFGUnigramTF(cfgText, cfgUnigrams);
	    for (int j=0; j<wordUniCount1.length; j++)
		{Util.writeFile(wordUniCount1[j] +",", output_filename, true);}	
	    
	    
	    float[] cfgNodeLastLineCount = FeatureExtractorCFGDisassembly.getCFGNodeLineTF(cfgText, cfgNodeLastLine);
	    for (int j=0; j<cfgNodeLastLineCount.length; j++)
		{Util.writeFile(cfgNodeLastLineCount[j] +",", output_filename, true);}	
	    

	    //get count of each bigram in in disassembly	 
	    float[] wordBigramCount1 = FeatureExtractorCFGDisassembly.getCFGBigramsTF(cfgText, cfgBigrams);
	    for (int j=0; j<wordBigramCount1.length; j++)
		{Util.writeFile(wordBigramCount1[j] +",", output_filename, true);}
	    
	    //get count of each bigram in in disassembly	 
	    float[] lineBigramCount = FeatureExtractorCFGDisassembly.getCFGNodeLineBigramTF(cfgText, cfgLineBigrams);
	    for (int j=0; j<lineBigramCount.length; j++)
		{Util.writeFile(lineBigramCount[j] +",", output_filename, true);}

		float[] uniTFIDF = FeatureExtractorCFGDisassembly.getCFGUnigramsTFIDF(cfgText, test_dir, cfgUnigramsTFIDF);
	    for (int j=0; j<uniTFIDF.length; j++)
		{Util.writeFile(uniTFIDF[j] +",", output_filename, true);}	
	    
    	
    	
		Util.writeFile(authorName+"\n", output_filename, true);

   	
   			
       	}
   	}
   
	  
   	
	  public static String[]  uniqueDirectoryWords (String directoryFilePath){

		    String text = "FunctionName: operator"+ "";
		            
		            

		    Matcher m = Pattern.compile("(?m)^.*$").matcher(text);

		   
		    while (m.find()) {
		        System.out.println("line = " + m.group());
		        if(m.group().startsWith("Features (list):"));
		        
		    }
		  


	        while (m.find()) {
	            System.out.println("line = " + m.group());}
		  
		  String[] words = text.split( "\\s+");
		  Set<String> uniqueWords = new HashSet<String>();

		   for (String word : words) {
		       uniqueWords.add(word);
		   }
		   words = uniqueWords.toArray(new String[0]);
		   return words;
		 }
		   
	  
}











