Initial documentation for de-anonymizing programmers from executable binaries.

For details see the paper: https://www.princeton.edu/~aylinc/papers/caliskan_when.pdf 

Please cite: (bibtex entry)
@inproceedings{caliskan2018coding,
  title={When coding style survives compilation: De-anonymizing programmers from executable binaries},
  author={Caliskan, Aylin and Yamaguchi, Fabian and Dauber, Edwin and Harang, Richard and Rieck, Konrad and Greenstadt, Rachel and Narayanan, Arvind},
  booktitle={Network and Distributed System Security Symposium (NDSS) 2018},
  year={2018},
  organization={Internet Society}
}

Requirements:
1.	Bjoern https://github.com/octopus-platform/bjoern 
2.	IDA pro and hexrays https://www.hex-rays.com 
3.	Llvm* for obfuscation - ObfuscateBinaries.java https://github.com/obfuscator-llvm/obfuscator/wiki 
∗	optional


Take binaries or if you have source code compile them (CompileCode.java).
1.	Preprocess the binary: 
      1.	Disassemble, 
              1.	BinaryDisassemble.java		
              2.	bjoernDisassemble.java
      2.	Decompile to obtain decompiled source code, 
              1.	DecompileBinaries.java
      3.	Generate abstract syntax trees, and 
              1.	bjoernBatchProcess.java		
      4.	Generate control flow graphs. 	
              1.	bjoernGenerateGraphmlCFG.java

2.	Extract features from four data sources 
        (This produces about 700,000 features for 100 programmers each with 9 files.)  
      1.	assembly code, 
      2.	decompiled source code, 
      3.	abstract syntax trees, and 
      4.	control flow graphs. 
      ♣	FeatureExtractorAllFeatures.java - remove the feature types that you do not want in your feature set.

3.	Apply information gain criterion to use to highly effective features. 
      1.	Extract features high in information gain.
              1.	AuthorClassificationBasic.java 
