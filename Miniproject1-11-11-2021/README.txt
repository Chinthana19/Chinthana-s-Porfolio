This program uses command line inputs to perform tasks. To use this program,
call its name (cryptoMagic.exe) from the command prompt, and then enter the 
required operation ('-encrypt' or '-decrypt'), followed by the file name. Note
that if no operation is given, this program will default to encryption.

For example, to encrypt a file called (file.txt), enter in the command prompt:
	cryptoMagic.exe -encrypt file.txt
or
	cryptoMagic.exe file.txt

to decrypt a file called (file.crp), enter in the command prompt:
	cryptoMagic.exe -decrypt file.crp

This program can also be run in an IDE such as Visual Studio Code, also by 
using command line inputs.

This program outputs a file. If encryption is chosen, the output will be 
contained in the original file, but with a (.crp) extension. Note that if a
file of the same name with a (.crp) extension already exists, the contents
of that file will be overwritten. 

If decryption is chosen, the output will be in a new file with the same name, 
but with a (.txt) extension. The (.crp) file will remain.

The maxiumum number of characters in a file must be under 500.