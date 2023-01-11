/* 
*   This program calculates distances between different users and stores the information in structures
*   Authors: Chinthana Sembakutti, Harman Singh
*   Date: December 4, 2021
*/

#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

typedef struct user_t {
    char name[256];
    float lat;
    float lon;
    float alt;
    unsigned long long time; 
} User; 

typedef struct user_info {
    User our_user;
    User *other_users[];
} UserInfo;

typedef struct user_distance {
    char name[256];
    float distance;
} UserDistance;

typedef struct user_distances {
    int num;
    UserDistance *distance[];
} UserDistances;


//Reads a line from file and saves it to the array
int getLine(FILE *fp, char *array) {
    char x = 0;
    int counter=0;
    while(counter == 0) {
        while((x=fgetc(fp))!= EOF) {
            if(x != '\n') {
                array[counter] = x;
                counter++;
            }
            else {
                break;
            }
        }
        if (x == EOF) {
            break;
        }
    }
    array[counter] = '\0';
    return counter;
}

//Reads file and saves to memory
void scan_user(User *ptr_user_t, FILE *fp) {
    //Each user is defined like below:
    //<name>
    //<latitude>
    //<longitude>
    //<altitude>
    //<time in nanoseconds>

    char array[1000] = {0};
    int counter = getLine(fp, array);
    strcpy(ptr_user_t->name, array);
    counter = getLine(fp, array);
    ptr_user_t->lat = atof(array);
    counter = getLine(fp, array);
    ptr_user_t->lon = atof(array);
    counter = getLine(fp, array);
    ptr_user_t->alt = atof(array);
    counter = getLine(fp, array);
    ptr_user_t->time = strtoull(array, NULL, 10);
}


//calculating the distance between our user and other users, and adding names to new structure
void findDistance(UserDistances *userDistances, UserInfo *user_info_ptr, int userNum, FILE *fpw) {
    float lat1 = user_info_ptr->our_user.lat;
    float long1 = user_info_ptr->our_user.lon;
    float alt1 = user_info_ptr->our_user.alt;
    userDistances->num = userNum;
    
    fprintf(fpw, "Distances Between our_user and each of the other_users:\n");

    for(int i=0; i < userNum; i++) {
        userDistances->distance[i] = malloc(sizeof(UserDistance));
        strcpy(userDistances->distance[i]->name, user_info_ptr->other_users[i]->name);
        float lat2 = user_info_ptr->other_users[i]->lat;
        float long2 = user_info_ptr->other_users[i]->lon;
        float alt2 = user_info_ptr->other_users[i]->alt;

        userDistances->distance[i]->distance = sqrt(pow(lat1 - lat2, 2) + pow(long1-long2, 2) + pow(alt1 - alt2, 2));

        fprintf(fpw, "Name:\t\t%s\n", userDistances->distance[i]->name);
        fprintf(fpw, "Distance:\t%.2f\n\n", userDistances->distance[i]->distance);
    }
}

//function that finds the closet user to our user
int findClosest(UserDistances *userDistances, FILE *fpw) {
    int closest_name = 0;
    float closest_distance = INT_MAX;

    for(int i=0; i < userDistances->num; i++) {
        if (userDistances->distance[i]->distance < closest_distance) {
            closest_distance = userDistances->distance[i]->distance;
            closest_name = i;
        }
    }

    fprintf(fpw, "The closest distance to our user is:\t%.2f.\n", userDistances->distance[closest_name]->distance);
    fprintf(fpw, "The name of this user is:\t\t%s\n", userDistances->distance[closest_name]->name);
}

//Reads first line of file to get number of users
int getNumUsers(FILE *fp) {
    int userNum;
    char firstLine[1000] = {0};
    int counter = getLine(fp, firstLine);
    userNum = atoi(firstLine);
    return userNum;
}

//Prints user information to the output file
void printUserInfo(User *user, FILE *fpw) {
    fprintf(fpw, "Name:\t\t%s\n", user->name);
    fprintf(fpw, "Latitude:\t%.2f\n", user->lat);
    fprintf(fpw, "Longitude:\t%.2f\n", user->lon);
    fprintf(fpw, "Altitude:\t%.2f\n", user->alt);
    fprintf(fpw, "Time:\t\t%llu\n\n", user->time);
}

//Calls the printing to file function for all the users
void printInfo(int userNum, UserInfo *user_info_ptr, FILE *fpw) {
    printUserInfo(&user_info_ptr->our_user, fpw);
    for(int i=0; i < userNum; i++) {
        printUserInfo(user_info_ptr->other_users[i], fpw);
    }
}

int main() {
    int usersNum;
    char filename[1000] = {0}, outputFilename[1000] = {0};
    char *search = ".txt";
    printf("Enter the filename or path: ");
    scanf("%s", &filename);
    printf("Enter the name of the output file, or file to be created: ");
    scanf("%s", &outputFilename);


    //If outputFilename doesn't have a (.txt) extension
    if(strstr(outputFilename, search) == NULL) {
        printf("Error, enter (.txt) extension to filename.");
        return -1;
    }

    //File opening
    FILE *fp;
    fp = fopen(filename, "r");
    if (fp == NULL) {
        printf("Error opening file! - %s\n", filename);
        return -1;
    }
    usersNum = getNumUsers(fp);
    UserInfo *userInfo = malloc(sizeof(User) + usersNum*(sizeof(User*)));
    UserDistances *userDistances = malloc(sizeof(UserDistance) + usersNum*(sizeof(UserDistance*)));

    //get first user (our_user information)
    scan_user(&userInfo->our_user, fp);

    //Allocating memory for the users, getting other_users information
    for(int i=0; i < usersNum; i++) {
        User* user = malloc(sizeof(User));
        userInfo->other_users[i] = user;
        scan_user(userInfo->other_users[i], fp);
    }

    fclose(fp);

    //opening output file
    FILE *fpw;
    fpw = fopen(outputFilename, "w");
    if(fpw == NULL) {
        printf("Error opening file! - %s\n", outputFilename);
        return -1;
    }

    //running functions
    printInfo(usersNum, userInfo, fpw);
    findDistance(userDistances, userInfo, usersNum, fpw);
    findClosest(userDistances, fpw);

    fclose(fpw);

    //Freeing the memory that was being used
    for(int i=0; i < usersNum; i++) {
        free(userInfo->other_users[i]);
        free(userDistances->distance[i]);
    }
    free(userInfo);
    free(userDistances);

    printf("Success!\n");

    return 0;
}