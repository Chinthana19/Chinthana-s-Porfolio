Name: Chinthana Sembakutti
ID: 1177250
Assignement 4

This program requires the use of a input text file named 'f.dat'. Ensure the file is in the same folder.
To run this program, use the makefile.

In the command line, enter:
        make

Then enter:
        Q1.exe

Sample program output:

C:\Users\chint\University\University Of Guelph\2nd Year\Cis2520\Assignment 4>make
gcc -c -o Q1.o Q1.c -Wall -std=c99 -pedantic
gcc -o Q1 Q1.o

C:\Users\chint\University\University Of Guelph\2nd Year\Cis2520\Assignment 4>Q1.exe
Input from file:
25 00 54 25 19 25 81 21 02 78
19 09 89 77 80 75 91 34 61 24
36 42 65 18 81 93 72 34 59 37
10 56 17 24 47 02 35 45 19 51
26 28 10 23 03 32 65 61 28 95
66 63 94 42 77 64 56 80 63 14
77 07 34 93 04 19 10 44 76 19
86 18 40 47 13 94 98 22 79 94
68 37 41 12 06 85 51 85 60 56
03 98 29 05 60 15 98 86 04 61
77 51 28 24 77 02 36 64 32 05
30 73 12 75 14 85 72 60 91 42
83 46 03 67 90 48 04 74 41 52
62 30 46 71 41 38 80 60 99 05
19 48 83 98 11 30 41 72 09 31
31 44 21 79 68 97 32 13 62 80
61 69 82 25 62 12 83 35 56 19
62 74 67 19 41 35 38 16 09 80
47 44 85 30 84 53 28 42 07 65
99 30 00 91 26 09 91 70 21 14


Before Parental Node Downheap Algorithm:
(00): Key = 079: 25 00 54 25 19 25 81 21 02 78
(01): Key = 117: 19 09 89 77 80 75 91 34 61 24
(02): Key = 143: 36 42 65 18 81 93 72 34 59 37
(03): Key = 083: 10 56 17 24 47 02 35 45 19 51
(04): Key = 064: 26 28 10 23 03 32 65 61 28 95
(05): Key = 223: 66 63 94 42 77 64 56 80 63 14
(06): Key = 118: 77 07 34 93 04 19 10 44 76 19
(07): Key = 144: 86 18 40 47 13 94 98 22 79 94
(08): Key = 146: 68 37 41 12 06 85 51 85 60 56
(09): Key = 130: 03 98 29 05 60 15 98 86 04 61
(10): Key = 156: 77 51 28 24 77 02 36 64 32 05
(11): Key = 115: 30 73 12 75 14 85 72 60 91 42
(12): Key = 132: 83 46 03 67 90 48 04 74 41 52
(13): Key = 138: 62 30 46 71 41 38 80 60 99 05
(14): Key = 150: 19 48 83 98 11 30 41 72 09 31
(15): Key = 096: 31 44 21 79 68 97 32 13 62 80
(16): Key = 212: 61 69 82 25 62 12 83 35 56 19
(17): Key = 203: 62 74 67 19 41 35 38 16 09 80
(18): Key = 176: 47 44 85 30 84 53 28 42 07 65
(19): Key = 129: 99 30 00 91 26 09 91 70 21 14

After Parental Node Downheap Algorithm:
(01): Key = 064: 26 28 10 23 03 32 65 61 28 95
(02): Key = 079: 25 00 54 25 19 25 81 21 02 78
(03): Key = 115: 30 73 12 75 14 85 72 60 91 42
(04): Key = 096: 31 44 21 79 68 97 32 13 62 80
(05): Key = 083: 10 56 17 24 47 02 35 45 19 51
(06): Key = 118: 77 07 34 93 04 19 10 44 76 19
(07): Key = 138: 62 30 46 71 41 38 80 60 99 05
(08): Key = 117: 19 09 89 77 80 75 91 34 61 24
(09): Key = 146: 68 37 41 12 06 85 51 85 60 56
(10): Key = 129: 99 30 00 91 26 09 91 70 21 14
(11): Key = 156: 77 51 28 24 77 02 36 64 32 05
(12): Key = 223: 66 63 94 42 77 64 56 80 63 14
(13): Key = 132: 83 46 03 67 90 48 04 74 41 52
(14): Key = 143: 36 42 65 18 81 93 72 34 59 37
(15): Key = 150: 19 48 83 98 11 30 41 72 09 31
(16): Key = 144: 86 18 40 47 13 94 98 22 79 94
(17): Key = 212: 61 69 82 25 62 12 83 35 56 19
(18): Key = 203: 62 74 67 19 41 35 38 16 09 80
(19): Key = 176: 47 44 85 30 84 53 28 42 07 65
(20): Key = 130: 03 98 29 05 60 15 98 86 04 61