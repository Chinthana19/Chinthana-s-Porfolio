CFLAGS=-Wall -std=c99 -pedantic

all: Q1.exe

Q1.exe: Q1.o 
	gcc -o Q1 Q1.o

%.o: %.c
	gcc -c -o $@ $< $(CFLAGS)