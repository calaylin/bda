import os
import sys

#
# Usage: python /directory/path/to/cjcompile.py [compiler flags]
#  python /Users/Aylin/git/calaylin/bda/src/cjcompile.py
# Compiles all C/C++ source files in the current working directory.
# Also recursively compiles all C/C++ source files in all subdirectories.
#check file format: 

flags = sys.argv
flags.pop(0)

#/usr/local/gcc-4.8.1-for-linux32/bin/i586-pc-linux-gcc -static for C linking;
#/usr/local/gcc-4.8.1-for-linux32/bin/i586-pc-linux-g++ -static for C++ linking.

#/usr/local/gcc-4.8.1-for-linux64/bin/i586-pc-linux-gcc -static for C linking;
#/usr/local/gcc-4.8.1-for-linux64/bin/i586-pc-linux-g++ -static for C++ linking.
# go through all files under the root directory
for (path, dirs, files) in os.walk('.'):
	for f in files:
		# check if file is a C or C++ file
		if f.endswith(('.c', '.cpp')):
			if f.endswith('.c'): # C file
			#	command = "gcc -m32 "
					#		command = "/usr/local/gcc-4.8.1-for-linux32/bin/i586-pc-linux-gcc -O1 "
				command = "/usr/local/gcc-4.8.1-for-linux32/bin/i586-pc-linux-gcc -S "


			else: # C++ file
			#	command = "g++ -m32 "
			#				command = "/usr/local/gcc-4.8.1-for-linux32/bin/i586-pc-linux-g++ -O1 "
				command = "/usr/local/gcc-4.8.1-for-linux32/bin/i586-pc-linux-g++ -S "

			# add full directory path of the source file
			command += path
			command += '/'
			command += f

			# add full directory path of the executable
			command += " -o "
			command += path
			command += '/'
			command += os.path.splitext(f)[0] # remove file extension


			# compile
			os.system(command)
			print command
