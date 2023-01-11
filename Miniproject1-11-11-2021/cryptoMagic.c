/*
*   This program takes a file input from a user, then decrypts or encrypts the contents of it
*   Authors: Chinthana Sembakutti, Harman Singh
*   Date: November 11, 2021
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int Encrypter(char *filename);
int Encrypter(char *filename);

// Encryption function
int Encrypter(char *filename) {
    char fileChar;
    char array[1024]={0};
    int outChar[1024] = {0};

    //file opening and reading then putting it to an array
    FILE *fp;
    fp = fopen(filename, "r");
    if (fp == NULL) {
        printf("Error opening file! - %s\n", filename);
        return -1;
    }

    int counter = 0;
    while((fileChar=fgetc(fp))!=EOF) {
      array[counter] = fileChar;
      counter++;
    }
    fclose(fp);

    //encrypting
    for(int j=0; j < counter; j++) {
        if((array[j] == 9) || (array[j] == 10) || (array[j] == 13)) {
            outChar[j] = array[j];
        }
        else {
            outChar[j] = array[j] - 16;
            if(outChar[j] < 32) {
                outChar[j] = (outChar[j] - 32) + 144;
            }
        }   
    }

    //renaming file
    char newFilename[1024], *search;
    strcpy(newFilename, filename);
    search = strchr(newFilename, '.');
    if (search != NULL) {
        *search = '\0';
    }
    strcat(newFilename, ".crp");
    int renameStatus = rename(filename, newFilename);

    if (renameStatus == 0) {
        printf("Encryption successful. Encrypted file is: %s\n", newFilename);
    }
    else {
        printf("Renaming %s to %s failed.\n", filename, newFilename);
    }

    //printing message to file
    fp = fopen(newFilename, "w");
    if (fp == NULL) {
        printf("Error opening file - %s\n", newFilename);
        return -1;
    }
    for(int u=0; u < counter; u++) {
        if(outChar[u] == 9) {
            fprintf(fp,"TT");
        }
        else if((outChar[u] == 10) || (outChar[u] == 13)) {
            fprintf(fp, "\n");
        }
        else {
            fprintf(fp,"%X", outChar[u]);
        }
    }
    fclose(fp);
    
    return 0;
}

int decryption(char name[80])
{

    char result[255] = {0};
    int var1, var2;
    char num1;
    char num2;
    int fileEnd = 0;
    int counter = 0;
    char nameOutput[1024];
    strcpy(nameOutput, name);

    //changing the name for the output 
    nameOutput[strlen(name) - 1] = 't';
    nameOutput[strlen(name) - 2] = 'x';
    nameOutput[strlen(name) - 3] = 't';
    //Opening and emptying the output file
    FILE *fpo = fopen(nameOutput, "w");

    // Reading the current line
    FILE *fp = fopen(name, "r");
    char currentLine[1024];

    while (fgets(currentLine, 1024, fp))
    {

        // Getting the length of the current line
        int length = strlen(currentLine);

        for (int counter2 = 0; counter2 < length; counter2 = counter2 + 2)
        {
            num1 = currentLine[counter2];
            num2 = currentLine[counter2 + 1];

            if ((num1 == 'T') && (num2 == 'T'))
            {
                result[counter2 / 2] = 9;
            }
            else if (num1 == '\n' || num2 == '\n')
            {
                int x = 1;
            }
            else
            {
                // checking if the variable is a-f
                if (num1 == 'A')
                {
                    var1 = 10;
                }
                else if (num1 == 'B')
                {
                    var1 = 11;
                }
                else if (num1 == 'C')
                {
                    var1 = 12;
                }
                else if (num1 == 'D')
                {
                    var1 = 13;
                }
                else if (num1 == 'E')
                {
                    var1 = 14;
                }
                else if (num1 == 'F')
                {
                    var1 = 15;
                }
                else
                {
                    var1 = num1 - '0';
                }

                // checking if the variable is a-f
                if (num2 == 'A')
                {
                    var2 = 10;
                }
                else if (num2 == 'B')
                {
                    var2 = 11;
                }
                else if (num2 == 'C')
                {
                    var2 = 12;
                }
                else if (num2 == 'D')
                {
                    var2 = 13;
                }
                else if (num2 == 'E')
                {
                    var2 = 14;
                }
                else if (num2 == 'F')
                {
                    var2 = 15;
                }
                else
                {
                    var2 = num2 - '0';
                }

                // Converting hex to characters
                int asciiNum;
                asciiNum = var1 * 16 + var2 + 16;

                if (asciiNum > 127)
                {
                    asciiNum = (asciiNum - 144) + 32;
                }
                result[counter2 / 2] = asciiNum;
            }
        }

        //Opening output file
        fprintf(fpo, "%s\n", result);
        for(int i=0; i < strlen(currentLine); i++) {
            result[i] = '\0';
        }
    }
    fclose(fpo);
}

int main(int argc, char *argv[]) {

    //for when only 1 input is entered
    if(argc == 2) {
        if((strcmp(argv[1], "-decrypt")== 0) || (strcmp(argv[1], "-encrypt")==0)) {
            printf("Error, enter a [SPACE] then the filename.");
            return -1;
        }
        else {
        int operationEncrypt = Encrypter(argv[1]);
            if(operationEncrypt < 0) {
                printf("Encryption Failed.\n");
                return -1;
            }
        }
    }

    //for when 2 inputs are entered
    if(argc == 3) {
        if(strcmp(argv[1], "-encrypt") ==0 ) {
            int operationEncrypt = Encrypter(argv[2]);
            if(operationEncrypt < 0) {
                printf("Encryption Failed.\n");
                return -1;
            }
        }
        else if(strcmp(argv[1], "-decrypt") == 0) {
            int operationDecryption = decryption(argv[2]);
            if(operationDecryption < 0) {
                printf("Encryption Failed.\n");
                return -1;
            }
                }
        else {
            printf("Error, enter a valid operation. Enter '-encrypt' for Encryption and '-decrypt' for Decryption.\n");
            return -1;
        }
    }
    printf("Operation Successful.\n");
    return 0;
}