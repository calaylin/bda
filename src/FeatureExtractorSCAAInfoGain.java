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

public class FeatureExtractorSCAAInfoGain {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		//list the cppKeywords that appear in infogain
		  String [] cppKeywords = {"extern",
				  "static",
				  "struct",
				  "and",
				  "this","case",
				  "class",
				  "compl",
				  "const",
				  "inline",
				  "namespace",
				  "operator",
				  "auto",
				  "signed",
				  "static",
				  "template",
				  "typedef",
				  "typename",
				  "unsigned",
				  "using"
				 };
		  
	
    	String test_dir = "/mnt/data_bsd/optimizationsSCAA/"
    			;
    	

    	String output_filename = "/mnt/data_bsd/"
    			+ "arffs/optimizationsSCAA.arff" ;

    	
       	List test_file_paths = Util.listTextFiles(test_dir);

	String text = "";
  	//Writing the test arff
  	//first specify relation
	Util.writeFile("@relation IG "+"\n"+"\n", output_filename, true);
	Util.writeFile("@attribute instanceID {", output_filename, true);
	
   	List test_cpp_paths = Util.listCPPFiles(test_dir);
   	for(int j=0; j < test_cpp_paths.size();j++ )
	{
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

//	Util.writeFile("@attribute 'functionIDCount' numeric"+"\n", output_filename, true);
//	Util.writeFile("@attribute 'CFGNodeCount' numeric"+"\n", output_filename, true);
//	Util.writeFile("@attribute 'ASTFunctionIDCount' numeric"+"\n", output_filename, true);
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
			"ull",	"tem",	"mm",	"mo",	"link",	"line",	"<list>",	"na",	"nc",	
			"ne",	"nf",	"ni",	"nk",	"nl",	"cases",	"list",	"li",	"operator",	"freopen",	
			"cout<<",	"int)",	"int;",	"ii",	"in);",	"<cctype>",	"#include<stack>",	"ty",	"tx",	
			"tt",	"\"output.txt\",",	"ts",	"<<\"Case",	"tp",	"tf",	"td",	"tc",	"sy",	"sz",
			"sm",	"sq",	"sc",	"t=",	"(T--",	"t0",	"small",	"inline",	"s:",	"FILE",	"\\%",	
			"pt",	"pp",	"pr",	"ps",	"typename",	"(a);",	"(b);",	"yn",	"(n);",	"typedef",	"(it,",
			"(x).end()",	"(x))",	"char*",	"\"r\",",	"i++)",	"\",",	"<<endl;",	"template<class",	
			"rep(i,",	"#\"",	"\\%d\",",	"\\\":",	"FORE",	"FOR(",	"main(",	"<fstream>",	"fout",	"for(",	"printf(\"",	"&T);",	"freopen(\"output.txt\",\"w\",stdout)",	"(\"output.txt\",",	"name",	"<cstdlib>",	"n;i++)",	"(\\\"\\%d",	"i=0;",	"((a)",	"((x)",	"&t);",	"pair<int,int>",	"in(int",	"tc++)",	"#include<map>",	"template<",	"in>>T;",	"v",	"in>>t;",	"#include<stdio.h>",	"<bitset>",	"main()",	"\\%d",	"--){",	"(x).begin(),",	"REP(",	"comment(linker,",	"REP(i,",	"(\"",	"sync_with_stdio(false);",	"with",	"output",	"cout<<\"Case",	"class",	"...)",	"REP(i,n)",	"DEBUG",	"std;",	"sync",	"include",	"make",	"freopen(\"input.txt\",\"r\",stdin)",	"cin>>",	"stdout);",	"math",	"endl;",	"temp",	"test",	"++i)",	"++t)",	"queue",	"time",	"<string",	"++){",	"<cassert>",	"(v).begin(",	"solve()",	"<ctime>",	"type",	"foreach",	"100000000",	"uint",	"forn(i,",	"ull;",	"((int)",	"<math.h>",	"freopen(\"output.txt\",",	"freopen(\"input.txt\",",	"stdin);",	"*a",	"){",	"tests",	"test)",	"<stdio.h>",	"size_t",	",sizeof",	"<vector",	"(v).end(",	"scanf",	")(",	"const",	"t++)",	"<class",	"read",	"rep(",	"(\"input.txt\",",	"0.000000001",	"print",	"ifstream",	"<utility>",	"<deque>",	"(-",	"<climits>",	"sign",	"#include<cmath>",	"(i=0;",	"open",	"out;",	"out,",	"out)",	"outp",	"ostr",	"acos(-1.0)",	"#include<cstring>",	"#include<queue>",	"pair",	"(T",	"<queue>",	"pena",	"fopen",	"for(i",	"base:",	"forn(",	"fout,",	"<stdlib.h>",	"template<typename",	"argv",	"vector<T>",	"\",\"",	"pii;",	"argv",	"(int)",	"\"<<",	"1.0)",	"s++)",	"1<<\":",	"(){",	"while(",	"((a",	"((x",	"&t)",	"for(i=",	"printf",	"solve();",	"#if",	"#include<string>",	"pair<int",	"namespace",	"fprintf",	"(false)",	"\"r\",stdin);",	"static",	"while(t",	"while(T",	"cin>>T;",	"#else",	"cout<<\"",	"<vector>",	"--)",	"(i,",	"\n\",",	"(n)",	"<iostream>",	"(c)",	"(b)",	"(a)",	"#define",	"<cmath>",	"template",	"fstream",	"E",	"acos(-1.0);",	"++c",	"stdout",	"14",	"++)",	"<complex>",	"stdin)",	"(t,",	"(t-",	"printf(",	"(v)",	"(x,",	"(x)",	"function",	"vector",	"<cstring>",	"0;i",	"(v).end()",	"\"input.txt\",",	"<iomanip>",	"1;i",	"out);",	"out<<",	"(void)",	"utility",	"input.",	"...",	"64",	"freopen(\"output.txt\",\"w\",stdout);",	"(t--)",	
			"for(int",	"printf(\"Case",	"(T--)",	"scanf",	"<string>",	"out.txt",	
			"<string.h>",	"cout",	"string>",	"string.",	"#include<cstdio>",	"::",	"scanf(\"",	"comp",	",&t);",	
			"main(int",	"each(",	"cerr",	"(\"Case",	"ofstream",	"<set>",	"\"w\",",	">>",	"<n",	
			"bits",	"H",	"base",	";}",	"case",	">>t;",	"tt++)",	"1",	"0",	"#ifdef",	"<<",
			"#endif",	";j",	"make_pair",	"cases)",	"in.txt",	"64;",	";i",	"endl",	"pair<int,",	
			"J",	"file",	"fine",	"limit",	"solve",	"=1;",	"(c).end()",	"=0;",	"FOR(i,",	"=1;i",
			"i++){",	"dout",	";i++",	"unsigned",	"<<\"",	"each",	"ostream",	"<<\":",	"FI",	"U",	
			"#include<iostream>",	"solve(",	"<stack>",	"\"\n\";",	"<bits/stdc++.h>",	"#include<algorithm>",	"signed",	"T",	"#pragma",	
			"fprintf(",	"in();",	"pair<",	"end();",	"define",	"deque",	"=t;",	"int64;",	
			"for(i=0;",	"#include",	"<sstream>",	"FOR",	"#include<cstdlib>",	"<numeric>",	"CH",
			"freopen(\"input.txt\",\"r\",stdin);",	"stringstream",	"stack",	"stdin",	"ILE",	"INF",	
			"c++)",	"\"w\",stdout);",	"LL",	"<functional>",	"int64",	"input",	"argc",	"argv",	"auto",
			"MA",	"while(T--)",	"BUG",	"MP",	"<cstdio>",	"out<<\"Case",	"ND",	"P",	"#include<set>",
			"<map>",	"<typename",	"argc,",	"main(){",	";i++)",	"PI",	"EPS",	"PB",	"I;",	"R",	
			"In",	"REP",	"",	"VI",	"LL;",	"while(t--)",	"MOD",	"\",++",	"#include<vector>",	"Y",	"ST",
			"SZ",	"T);",	"T;",	"T--",	"T>",	"#\"<<",	"TC",	"SE",	"T&",	"T)",	"Z",	"T,",	"*argv",
			"VI;",	"a,b",	"__",	"bit",	"_t",	"cas",	"can",	"c++",	"all",	"",	"att",	"\n\"",	"gc",	"fi",	
			"fr",	"its",	"fp",	"i=",	"ios",	"it,",	"i<",	"i,",	"i<=",	"i=0",	"i=1",	"de",	"ifs",
			"if(",	"ii;",	"inc",	"di",	"inp",	"inf",	"in)",	"in,",	"lose",	"etc",	"eps",	"equ",	"emp",
			"i++",	"ep",	"fst",	"fre",	"fil",	"fin",	"ca",	"com",	"cin",	"bi",	"dif",	"t+1",	"t);",	
			"dc",	"t--",	"t<<",	"t<=",	"t=1",	"cs",	"ser",	"cm",	"sol",	"sqr",	"cl",	"ci",	"sta",	
			"std",	"td;",	"cc",	"pii",	"put",	"que",	"#",	"num",	"ai",	"ofs",	"ost",	"out",	
			"ap",	"am",	"ld;",	"los",	"n);",	"ll;",	"lim",	"np",	"map",	"n;i",	"stream",	"(__typeof",	
			"op",	"i=0;i",	"pb",	"pl",	"pi",	"using",	"ll",	"lv",	"vi;",	"x))",	"vec"		

	};
	

//	String[] ASTbigramsTF={"CompoundStatement IdentifierDeclStatement",	"ShiftExpression AdditiveExpression",
//			"Argument s",	"n Callee",	"int ca",	"AssignmentExpr ca",	"IncDecOp ca",	"p i",	"Argument For",
//			"e Callee",	"RelationalExpression IncDecOp",	"Argument f",	"f Argument",	"1 C",	"e i",	
//			"Argument st",	"st Argument",	"ShiftExpression in",	"in t",	"t in",	"0 0",	"t cas",	"0 int",
//			"T R",	"T ExpressionStatement",	"cin T",	"T For",	"t cases",	"T ShiftExpression",
//			"T cin",	"m f",	"RelationalExpression ca",	"se AssignmentExpr",	"AssignmentExpr te",
//			"RelationalExpression te",	"IncDecOp te",	"t FOR",	"v Parameter",	"RelationalExpression t",
//			"t T",	"Callee solv",	"AssignmentExpr t",	"t t",	"Callee print",	"st Parameter",	"p CallExpression",
//			"Expression c",	"T c",	"t ForInit",	"fstream fin",	"in ExpressionStatement",
//			"ShiftExpression fin",	"n fin",	"in CallExpression",	"it AssignmentExpr",
//			"cas AssignmentExpr",	"AssignmentExpr cas",	"IncDecOp cas",	"RelationalExpression I",	
//			"r Condition",	"Expression Callee",	"it IdentifierDeclStatement",	"Callee i",	
//			"ShiftExpression fout",	"fout ShiftExpression",	"AssignmentExpr case",	"n c",	"T Expression",
//			"ShiftExpression A",	"stdout ExpressionStatement",	"Callee f",	"f ArgumentList",
//			"Argument WhileStatement",	"IncDecOp T",	"T CompoundStatement",	"T WhileStatement",	"t S",
//			"n Argument",	"Argument UnaryExpression",	"t 0",	"Callee fopen",	"fopen ArgumentList",
//			"o Argument",	"Parameter char",	"RelationalExpression cas",	"IdentifierDeclStatement IdentifierDecl",
//			"ForStatement ForInit",	"nt IdentifierDecl",	"nt ShiftExpression",	"st 1",	"t UnaryExpression",
//			"ForInit IdentifierDeclStatement",	"Argument R",	"UnaryExpression C",	"0 i",	"r int",
//			"IdentifierDecl Condition",	"T U",	"T S",	"p T",	"RelationalExpression test",	"IncDecOp test",
//			"int test",	"test AssignmentExpr",	"AssignmentExpr test",	"test 1",	"Argument test",
//			"IdentifierDecl if",	"Callee sc",	"r const",	"in T",	"T in",	"s cin",	"it IdentifierDecl",
//			"RelationalExpression tc",	"IncDecOp tc",	"int tc",	"tc AssignmentExpr",	"AssignmentExpr tc",
//			"tc 1",	"ShiftExpression c",	"ShiftExpression ReturnStatement",	"Expression IncDecOp",	"in Callee",	
//			"out Callee",	"t Parameter",	"Argument i",	"t tt",	"in C",	"n UnaryExpression",	"e 1",	"t s",	
//			"Condition UnaryExpression",	"UnaryExpression CompoundStatement",	"UnaryOp C",	
//			"RelationalExpression UnaryExpression",	"IncDecOp i",	"Expression t",	"n IncDecOp",	"l Condition",	"int cas",	"i T",	"T UnaryExpression",	"i CompoundStatement",	"t std",	"1 i",	"Argument te",	"int te",	"s int",	"s Callee",	"c int",	"IncDecOp c",	"t F",	"Argument A",	"CallExpression Callee",	"Argument W",	"p c",	"Callee fr",	"Callee scan",	"int ParameterList",	"se i",	"ParameterList Parameter",	"Parameter int",	"Argument IncDecOp",	"e ReturnStatement",	"e CallExpression",	"e int",	"Argument F",	"IdentifierDecl ofstream",	"out IdentifierDeclStatement",	"Callee ForInit",	"Callee ios",	"sync_with_stdio ArgumentList",	"false CallExpression",	"false Callee",	"Callee s",	"IdentifierDecl ifstream",	"e p",	"out IdentifierDecl",	"in c",	"c in",	"test A",	"int P",	"ExpressionStatement CallExpression",	"out ShiftExpression",	"AssignmentExpr C",	"e s",	"1 IdentifierDeclStatement",	"1 Condition",	"se int",	"Callee sol",	"ShiftExpression i",	"Argument FOR",	"int cases",	"ReturnStatement 0",	"0 IdentifierDeclStatement",	"r i",	"AdditiveExpression t",	"int ar",	"en Argument",	"c i",	"T E",	"T i",	"Argument Ret",	"solve ReturnStatement",	"Callee printf",	"t test",	"T C",	"printf ArgumentList",	"ArgumentList Argument",	"Argument Argument",	"ShiftExpression ci",	"int T",	"T IdentifierDecl",	"s IncDecOp",	"s RelationalExpression",
//			"Callee scanf",	"scanf ArgumentList",	"Argument ForStatement",	"ForInit AssignmentExpr",	"T IncDecOp",
//			"T int",	"Argument UnaryOp",	"UnaryOp CallExpression",	"T Callee",	"T ForStatement",	
//			"T RelationalExpression",	"AssignmentExpr Condition",	"RelationalExpression tt",	"IncDecOp tt",
//			"1 IdentifierDecl",	"out ExpressionStatement",	"open ArgumentList",	"out CallExpression",	
//			"Argument ReturnStatement",	"ExpressionStatement ShiftExpression",	"solve ExpressionStatement",	"int t",	"t IdentifierDecl",	"int tt",	"AssignmentExpr tt",	"IncDecOp t",	"t int",	"i int",	"Argument t",	"t CallExpression",	"t Callee",	"ShiftExpression cout",	"cout ShiftExpression",	"ShiftExpression cin",	"int c",	"cin t",	"i t",	"n fi",	"p t",	"t UnaryOp",	"t ShiftExpression",	"t cin",	"t RelationalExpression",	"RelationalExpression c",	"Expression UnaryExpression",	"ShiftExpression fo",	"Argument std",	"Callee freopen",	"freopen ArgumentList",	"tt AssignmentExpr",	"t 1",	"0 Condition",	"Argument stdin",	"stdin CallExpression",	"stdin Callee",	"stdin ExpressionStatement",	"Argument stdout",	"int argc",	"argc Parameter",	"stdout CallExpression",	"argv Parameter",	"argc int",	"argv char",	"stdout Callee",	"stdout IdentifierDeclStatement",	"n CallExpression",	"n cin",	"i i",	"t Argument",	"c Parameter",	"Callee solve",	"t Condition",	"Condition IncDecOp",	"1 int",	"ShiftExpression t"		
//	};
	
	String[] ASTbigramsTF ={"Callee f",	"e f",	"open ArgumentList",	"Callee freopen",	
			"freopen ArgumentList",	"Callee scanf",	"scanf ArgumentList",	"stdout Callee",	
			"stdout CallExpression",	"Argument stdout",	"out Callee",	"f Argument",	
			"f ArgumentList",	"stdout ExpressionStatement",	"Callee solve",	
			"stdin ExpressionStatement",	"Argument stdin",	"stdin Callee",	
			"in ExpressionStatement",	"stdin CallExpression",	"in CallExpression",	
			"in Callee",	"UnaryOp DoStatement",	"UnaryOp D",	"_CTOR_LIST__ IfStatement",	
			"oid ExpressionStatement",	"_CTOR_LIST__ UnaryOp",	"EqualityExpression _CTOR_LIST__",	
			"_CTOR_LIST__ v3",	"EqualityExpression Condition",	"_CTOR_LIST__ _CTOR_LIST__",	
			"_CTOR_LIST__ v2",	"_CTOR_LIST__ AssignmentExpr",	"ExpressionStatement _CTOR_LIST__",
			"void ExpressionStatement",	"void IdentifierDeclStatement",	"v2 void",	"v3 void",	
			"CompoundStatement DoStatement",	"v2 Condition",	"IncDecOp IfStatement",	"stdout std",
			"out std",	"Callee ForInit",	"i T",	"Callee getc",	"Callee getchar",	
			"getchar ExpressionStatement",	"char ExpressionStatement"
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
    			"basic_ifstream","t",	"freopen",	"in",	"tt",	"tc",	"test",	"open",	"ForStatement",	"UnaryExpression",	
    			"IncDecOp",	"scanf",	"close",	"argc",	"argv",	"fin",	"stdin",	"ofstream",	"ForInit",	"cin",	
    			"solve",	"FOR",	"fopen",	"ifstream",	"fprintf",	"cas",	"printf",	"ShiftExpression",	"REP",	
    			"fout",	"forn",	"cout",	"endl",	"size_t",	"out",	"cases",	"T",	"cerr",	"stdout"
    			
    			};
        String[] ASTtypesTFIDF = {"solve",
        		"InclusiveOrExpression",
        		"137438953488L",
        		"_CTOR_LIST__",
        		"basic_ofstream",
        		"getchar",
        		"IncDecOp",
        		"scanf",
        		"basic_ifstream","freopen",	"open",	"UnaryExpression",	"close",	"argc",	"argv",	"fin",
        		"stdin",	"solve",	"FOR",	"fopen",	"ifstream",	"fprintf",	"REP",	"fout",	"forn",	
        		"size_t",	"cerr",	"stdout"};
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
        		"in","w",	"t",	"r",	"freopen",	"small",	"in",	"tt",	"tc",	"input",	
        		"test",	"open",	"ForStatement",	"UnaryExpression",	"inline",	"IncDecOp",	"scanf",	"close",	"argc",	"argv",	"const",	"fin",	"stdin",	"ofstream",	"ForInit",	"cin",	"solve",	"txt",	"sync_with_stdio",	"FOR",	"fopen",	"ifstream",	"std",	"cas",	"printf",	"ShiftExpression",	"REP",	"fout",	"forn",
        		"Case",	"cout",	"size_t",	"out",	"cases",	"output",	"T",	"cerr",	"stdout",	"d"
        		
        };
        
        
	       String[] disassemblyUnigramsBjoern ={    };
		       
		   	
		   String[] disassemblyBigramsBjoern ={   };
		        
		    	
		   String[] disassemblyUnigramsNDISASM ={};
			       
		   String[] disassemblyBigramsNDISASM ={};

	       String[] cfgUnigrams ={};
	    	
	       String[] cfgNodeLastLine ={
	    		};
    	
	    	//get the bigrams in the CFG and write the bigram features
	    	String[] cfgBigrams ={
	    	};
	 
	    	//get the bigrams in the CFG and write the bigram features
	    	String[] cfgLineBigrams ={
	    	};
	
	    	  	//16 tfidf attributes
	    	String[] cfgUnigramsTFIDF={
	    	};
        
        for (int i=0; i<wordUnigramsTF.length; i++)	
        	
        {  	wordUnigramsTF[i] = wordUnigramsTF[i].replace("'", "apostrophesymbol");
          	Util.writeFile("@attribute 'wordUnigramsTF "+i+"=["+wordUnigramsTF[i]+"]' numeric"+"\n", output_filename, true);}
              
    for (int i=0; i<ASTtypesTF.length; i++)	
    	
  {  	ASTtypesTF[i] = ASTtypesTF[i].replace("'", "apostrophesymbol");
    	Util.writeFile("@attribute 'ASTNodeTypesTF "+i+"=["+ASTtypesTF[i]+"]' numeric"+"\n", output_filename, true);}
    
    
	for (int i=0; i<ASTbigramsTF.length; i++)	   	
    {  //	cfgBigrams[i] = cfgBigrams[i].replace("'", "apostrophesymbol");
				String temp= ASTbigramsTF[i];
         	Util.writeFile("@attribute 'ASTbigramsTFigrams "+i+"=["+temp.replace("\n", " ")+"]' numeric"+"\n", output_filename, true);}

	
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

		System.out.println(test_file_paths.get(i));
		System.out.println(authorName);

		File fileCPPID = new File(test_cpp_paths.get(i).toString());
		String fileNameID = authorName + "_"+fileCPPID.getName();
		Util.writeFile(fileNameID+",", output_filename, true);
//		Util.writeFile(FeatureCalculators.functionIDCount(featureText)+",", output_filename, true);
		String ASTText = Util.readFile(test_file_paths.get(i).toString().substring(0,testIDlength-3)+"ast");
		String DepASTText = Util.readFile(test_file_paths.get(i).toString().substring(0,testIDlength-3)+"dep");
		String sourceCode = Util.readFile(test_file_paths.get(i).toString().substring(0,testIDlength-3)+"cpp");
		String disText = "";
		String cfgText = "";

		String bjoernText = "";
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
	    float[] wordUniCount = FeatureExtractor2015Bjoern.getBjoernUnigramTF(bjoernText, disassemblyUnigramsBjoern);
	    for (int j=0; j<wordUniCount.length; j++)
		{Util.writeFile(wordUniCount[j] +",", output_filename, true);}	
	    
	    //get count of each bigram in bjoern disassembly	 
	    float[] wordBigramCount = FeatureExtractor2015Bjoern.getBjoernBigramsTF(bjoernText, disassemblyBigramsBjoern);
	    for (int j=0; j<wordBigramCount.length; j++)
		{Util.writeFile(wordBigramCount[j] +",", output_filename, true);}


		//FeatureExtractorDisassembly for ndisasm
		 //get count of each wordUnigram in disassembly 
	    float[] wordNDUniCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionUnigramsTF(disText, disassemblyUnigramsNDISASM);
	    for (int j=0; j<wordNDUniCount.length; j++)
		{Util.writeFile(wordNDUniCount[j] +",", output_filename, true);}	
	    
	    //get count of each bigram in in disassembly	 
	    float[] wordNDBigramCount = FeatureExtractorDisassemblyNDISASM.getNDISASMDisassemblyInstructionBigramsTF(disText, disassemblyBigramsNDISASM);
	    for (int j=0; j<wordNDBigramCount.length; j++)
		{Util.writeFile(wordNDBigramCount[j] +",", output_filename, true);}    
		
		
	    //get count of each wordUnigram in cfg 
	    float[] wordUniCount1 = FeatureExtractorSnowmanCFG.getCFGUnigramTF(cfgText, cfgUnigrams);
	    for (int j=0; j<wordUniCount1.length; j++)
		{Util.writeFile(wordUniCount1[j] +",", output_filename, true);}	
	    
	    
	    float[] cfgNodeLastLineCount = FeatureExtractorSnowmanCFG.getCFGNodeLineTF(cfgText, cfgNodeLastLine);
	    for (int j=0; j<cfgNodeLastLineCount.length; j++)
		{Util.writeFile(cfgNodeLastLineCount[j] +",", output_filename, true);}	
	    

	    //get count of each bigram in in disassembly	 
	    float[] wordBigramCount1 = FeatureExtractorSnowmanCFG.getCFGBigramsTF(cfgText, cfgBigrams);
	    for (int j=0; j<wordBigramCount1.length; j++)
		{Util.writeFile(wordBigramCount1[j] +",", output_filename, true);}
	    
	    //get count of each bigram in in disassembly	 
	    float[] lineBigramCount = FeatureExtractorSnowmanCFG.getCFGNodeLineBigramTF(cfgText, cfgLineBigrams);
	    for (int j=0; j<lineBigramCount.length; j++)
		{Util.writeFile(lineBigramCount[j] +",", output_filename, true);}

		float[] uniTFIDF = FeatureExtractorSnowmanCFG.getCFGUnigramsTFIDF(cfgText, test_dir, cfgUnigramsTFIDF);
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











