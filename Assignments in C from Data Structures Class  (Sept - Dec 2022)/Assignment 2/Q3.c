#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define DATA_FILE_NAME "cars.txt"
#define TOTAL_INCOME "total_income"
#define AVAILABLE_LIST_NAME "available"
#define RENTED_LIST_NAME "rented"
#define REPAIR_LIST_NAME "repair"

/*******************************
 * The format of the datafile
 * total_income:<income>
 * available:<plate>,<lileage>,<return-date>
 * rented:<plate>,<lileage>,<return-date>
 * repair:<plate>,<lileage>,<return-date>
*/

struct Car
{
    char plate[32];
    int mileage;
    int returnDate;
    struct Car *next;
};

struct Car *available_head = NULL;
struct Car *rented_head = NULL;
struct Car *atWkshop_head = NULL;

float total_income = 0.0; 

enum Codes
{
    INVALID = 0,
    ADD_NEW_AVAILABLE = 1,
    ADD_RETURN_AVAILABLE = 2,
    ADD_RETURN_REPAIR = 3,
    TRANSFER_REPAIR_TO_AVAILABLE = 4,
    RENT_FIRST_AVAILABLE = 5,
    PRINT_LIST = 6,
    QUIT = 7
};

void freeMemory(struct Car *ptr)
{
    while (ptr != NULL)
    {
        struct Car *tmp = ptr;
        ptr = ptr->next;
        free(tmp);
    }
}

void print_details(struct Car *car) {
    printf("\tPlate Number: %s\n", car->plate);
    printf("\tMileage: %d\n", car->mileage);
    printf("\tReturn Date: %06d\n\n", car->returnDate);
}

void insertToAvailable(struct Car *car) {
    if (available_head == NULL)
    {
        // First insertion
        available_head = car;
        return;
    }
    struct Car *temp = available_head;
    if (car->mileage < temp->mileage)
    {
        car->next = temp;
        available_head = car;
    }
    else
    {
        int inserted = 0;
        while (temp->next != NULL)
        {
            if (car->mileage > temp->next->mileage) {
                temp = temp->next;
                continue;
            } else {
                car->next = temp->next;
                temp->next = car;
                inserted = 1;
                break;
            }
        }
        if (!inserted) {
            temp->next = car;
        }
    }
}

int getCarPlateNumber(char* plate_number) {
    printf("Enter plate number: ");

    char line[1024];
    while (fgets(line, sizeof(line), stdin) != NULL) {
        if (strlen(line) < 2) {
            // Just a blank line. Not an error
            continue;
        }
        break;
    }
    char* token = &line[0];
    char *plate_str = strtok_r(token, "\n", &token);
    strcpy(plate_number, plate_str);
    return 0;
}

int getCarMileage() {
    int mileage;
    printf("Enter mileage: ");
    if (scanf("%d", &mileage) != 1)
    {
        printf("Invalid Input\n");
        return -1;
    }
    return mileage;
}

void addNewAvailable()
{
    char plateNum[32];
    if (getCarPlateNumber(plateNum) < 0) {
        // Invalid input
        return;
    }
    int mileage = getCarMileage();
    if (mileage < 0) {
        // Invalid input
        return;
    }
    struct Car *car = (struct Car *)malloc(sizeof(struct Car));
    memset(car, 0, sizeof(struct Car));
    car->mileage = mileage;
    strcpy(car->plate, plateNum);
    insertToAvailable(car);
    printf("A new car is added to available list:\n");
    print_details(car);
}

struct Car* retrieveFromRepairList(char* plateNum) {
    // If rented list is empty, nothing can be returned
    if (atWkshop_head == NULL) {
        return NULL;
    }
    struct Car* car = NULL;
    struct Car* temp = atWkshop_head;
    // Is it the first one in the list?
    if (strcmp(plateNum, temp->plate) == 0) {
        car = atWkshop_head;
        atWkshop_head = atWkshop_head->next;
        car->next = NULL;
        return car;
    }

    // Traverse and find from the list
    while (temp->next != NULL)
    {
        if (strcmp(plateNum, temp->next->plate) == 0) {
            car = temp->next;
            temp->next = temp->next->next;
            car->next = NULL;
            break;
        } else {
            temp = temp->next;
        }
    }
    return car;
}

struct Car* retrieveFromRentedListWithMileage(char* plateNum, int mileage) {
    // If rented list is empty, nothing can be returned
    if (rented_head == NULL) {
        return NULL;
    }
    struct Car* car = NULL;
    struct Car* temp = rented_head;
    // Is it the first one in the list?
    if ((strcmp(plateNum, temp->plate) == 0) &&
        (mileage == temp->mileage)) {
        car = rented_head;
        rented_head = rented_head->next;
        car->next = NULL;
        return car;
    }

    // Traverse and find from the list
    while (temp->next != NULL)
    {
        if ((strcmp(plateNum, temp->next->plate) == 0) &&
            (mileage == temp->next->mileage)) {
            car = temp->next;
            temp->next = temp->next->next;
            car->next = NULL;
            break;
        } else {
            temp = temp->next;
        }
    }
    return car;
}

struct Car* retrieveFromRentedList(char* plateNum) {
    // If rented list is empty, nothing can be returned
    if (rented_head == NULL) {
        return NULL;
    }
    struct Car* car = NULL;
    struct Car* temp = rented_head;
    // Is it the first one in the list?
    if (strcmp(plateNum, temp->plate) == 0) {
        car = rented_head;
        rented_head = rented_head->next;
        car->next = NULL;
        return car;
    }

    // Traverse and find from the list
    while (temp->next != NULL)
    {
        if (strcmp(plateNum, temp->next->plate) == 0) {
            car = temp->next;
            temp->next = temp->next->next;
            car->next = NULL;
            break;
        } else {
            temp = temp->next;
        }
    }
    return car;
}

float calculateIncome(int mileage) {
    float income = 80.0f;
    if (mileage > 200) {
        float excess_mileage = (float)(mileage - 200);
        income += excess_mileage*0.15;
    }
    return income;
}

void addReturnToAvailable()
{
    char plateNum[32];
    if (getCarPlateNumber(plateNum) < 0) {
        // Invalid input
        return;
    }
    // Retrieve the car from rented list
    struct Car* car = retrieveFromRentedList(plateNum);
    if (car == NULL) {
        printf("\nError: plate '%s' is not found in the rented list\n\n", plateNum);
        return;
    }
    int mileage = getCarMileage();
    if (mileage < 0) {
        // Invalid input
        return;
    }    
    // Find the charge
    if (mileage < car->mileage) {
        printf("Error: Lesser mileage is given than when rented!");
        return;
    }
    int mileage_used = mileage - car->mileage;
    float income = calculateIncome(mileage_used);
    total_income += income;
    // Set the next mileage
    car->mileage = mileage;
    // Add it to available list
    printf("Income for this rental is: %.2f\n", income);
    printf("Tranferring the car from rental list to available list:\n");
    print_details(car);
    insertToAvailable(car);
}

void insertToRepair(struct Car* car) {
    // First car to be repaired?
    if (atWkshop_head == NULL) {
        atWkshop_head = car;
        return;
    }
    struct Car* temp = atWkshop_head;
    // If repair list available, add it to the end
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->next = car;
}

void addReturnToRepair()
{
    char plateNum[32];
    if (getCarPlateNumber(plateNum) != 0) {
        // Invalid input
        return;
    }
    int mileage = getCarMileage();
    if (mileage < 0) {
        // Invalid input
        return;
    }
    // Retrieve the car from rented list
    struct Car* car = retrieveFromRentedListWithMileage(plateNum, mileage);
    if (car == NULL) {
        printf("\nError: plate '%s' with mileage %d is not found in the rented list\n\n", plateNum, mileage);
        return;
    }

    // The mileage is not actually requied. Added for as per assignment.
    // Add the car to the repair list
    insertToRepair(car);
    printf("Transferring the car from rented list to repair list:\n");
    print_details(car);
}

void transferFromRepairToAvailable()
{
    char plateNum[32];
    if (getCarPlateNumber(plateNum) != 0) {
        // Invalid input
        return;
    }
    struct Car* car = retrieveFromRepairList(plateNum);
    if (car == NULL) {
        printf("Cannot find a car with plate '%s' from the repair list\n\n", plateNum);
        return;
    }
    insertToAvailable(car);
    printf("Transferring the car from repair list to available list:\n");
    print_details(car);

}

struct Car *getFirstAvailable() {
    struct Car *first_available = NULL;
    if (available_head != NULL) {
        first_available = available_head;
        available_head = available_head->next;
        first_available->next = NULL;
    };
    return first_available;
}

void addToRentalList(struct Car *car) {
    if (rented_head == NULL) {
        rented_head = car;
        return;
    }
    struct Car *temp = rented_head;

    if (car->returnDate < temp->returnDate) {
        car->next = temp;
        rented_head = car;
    } else {
        int inserted = 0;
        while (temp->next != NULL) {
            if (car->returnDate > temp->next->returnDate) {
                temp = temp->next;
                continue;
            } else {
                car->next = temp->next;
                temp->next = car;
                inserted = 1;
                break;
            }
        }
        if (!inserted) {
            temp->next = car;
        }
    }
}

void rentFirstAvailable()
{
    if (available_head == NULL) {
        printf("No cars available\n");
        return;
    }
    printf("Expected return date: ");
    int return_date;
    if (scanf("%d", &return_date) != 1)
    {
        printf("Invalid Input\n");
        return;
    }
    struct Car *first_available = getFirstAvailable();
    if (first_available != NULL) {
        first_available->returnDate = return_date;
        addToRentalList(first_available);
        printf("Transferring car from available list to rental list:\n");
        print_details(first_available);
    }
}

void printList(struct Car *list)
{
    while (list != NULL)
    {
        print_details(list);
        list = list->next;
    }
}

void printLists()
{
    if (available_head != NULL)
    {
        printf("Available Cars List:\n");
        printf("======================================\n");
        printList(available_head);
        printf("======================================\n\n");
    } else {
        printf("No available cars\n\n");
    }
    if (rented_head != NULL)
    {
        printf("Rented Cars List: \n");
        printf("======================================\n");
        printList(rented_head);
        printf("======================================\n\n");
    } else {
        printf("No rented cars\n\n");
    }
    if (atWkshop_head != NULL)
    {
        printf("Repair Shop List: \n");
        printf("======================================\n");
        printList(atWkshop_head);
        printf("======================================\n\n");
    } else {
        printf("No cars to be repaired\n\n");
    }
}

int insertToLists(char *list_type, char* plate, int mileage, int return_date) {
    struct Car *car = (struct Car *)malloc(sizeof(struct Car));
    car->mileage = mileage;
    strcpy(car->plate, plate);
    car->returnDate = return_date;
    car->next = NULL;
    if (strcmp(list_type, AVAILABLE_LIST_NAME) == 0) {
        insertToAvailable(car);
        return 0;
    }
    if (strcmp(list_type, RENTED_LIST_NAME) == 0) {
        addToRentalList(car);
        return 0;
    }
    if (strcmp(list_type, REPAIR_LIST_NAME) == 0) {
        insertToRepair(car);
        return 0;
    }
    return -1;
}


int readFromFile() {
    FILE *fp = fopen(DATA_FILE_NAME, "r");
    if (fp == NULL) {
        printf("File '%s' cannot be opened.\n", DATA_FILE_NAME);
        return -1;
    }
    char line[1024];
    int total_income_read_flag = 0;
    int success = 0;
    while(fgets(line, sizeof(line), fp) != NULL) {
        success = 0;
        char* token = &line[0];
        if (total_income_read_flag == 0) {
            char *total_income_token = strtok_r(token, ":", &token);
            if (total_income_token == NULL) {
                printf("Invalid input from file '%s'\n", line);
                break;
            }
            if (strcmp(total_income_token, TOTAL_INCOME) != 0) {
                printf("Invalid input from file '%s'\n", DATA_FILE_NAME);
                break;
            }
            char *total_income_str = strtok_r(token, "\n", &token);
            if (total_income_str == NULL) {
                printf("Invalid input from file '%s'\n", line);
                break;
            }
            total_income = atof(total_income_str);
            total_income_read_flag = 1;
            success = 1;
            continue;
        }

        int mileage;
        int return_date;
        if (strlen(line) < 2) {
            success = 1;
            continue;
        }
        char *list_type = strtok_r(token, ":", &token);
        if (list_type == NULL) {
            printf("Invalid input from file '%s'\n", line);
            break;
        }
        char *plate = strtok_r(token, ",", &token);
        if (plate == NULL) {
            printf("Invalid input from file '%s'\n", line);
            break;
        }
        char *mileage_str = strtok_r(token, ",", &token);
        if (mileage_str == NULL) {
            printf("Invalid input from file '%s'\n", line);
            break;
        }
        mileage = atoi(mileage_str);
        char *return_date_str = strtok_r(token, "\n", &token);
        if (return_date_str == NULL) {
            printf("Invalid input from file '%s'\n", line);
            break;
        }
        return_date = atoi(return_date_str);
        if (insertToLists(list_type, plate, mileage, return_date) < 0) {
            printf("Invalid input from file '%s'\n", line);
            break;
        }
        success = 1;
    }

    if (fp) {
        fclose(fp);
    }
    if (success) {
        return 0;
    }
    return -1;
}

void writeListToFile(struct Car* list, char* listname, FILE* fp) {
    if (list != NULL) {
        char buffer[1024];
        struct Car* temp = list;
        while (temp != NULL) {
            sprintf(buffer, "%s:%s,%d,%d\n", listname,
                                            temp->plate,
                                            temp->mileage,
                                            temp->returnDate);
            fputs(buffer, fp);
            temp = temp->next;
        }
    }
}

int writeToFile() {
    FILE *fp = fopen(DATA_FILE_NAME, "w");
    if (fp == NULL) {
        printf("File '%s' cannot be opened.\n", DATA_FILE_NAME);
        return -1;
    }
    char buffer[1024];
    sprintf(buffer, "%s:%.2f\n", TOTAL_INCOME, total_income);
    fputs(buffer, fp);
    writeListToFile(available_head, AVAILABLE_LIST_NAME, fp);
    writeListToFile(rented_head, RENTED_LIST_NAME, fp);
    writeListToFile(atWkshop_head, REPAIR_LIST_NAME, fp);
    fclose(fp);
    return 0;
}
void quitFunction()
{
    printf("Total income: %.2f\n", total_income);
    printf("Writing data to file '%s':\n", DATA_FILE_NAME);
    if (writeToFile() < 0) {
        printf("Writting to file '%s' failed\n", DATA_FILE_NAME);
        return;
    }
    freeMemory(available_head);
    freeMemory(rented_head);
    freeMemory(atWkshop_head);
}

void processInput(int transCode)
{
    printf("processing input %d\n\n", transCode);
    switch (transCode)
    {
    case ADD_NEW_AVAILABLE:
        addNewAvailable();
        break;
    case ADD_RETURN_AVAILABLE:
        addReturnToAvailable();
        break;
    case ADD_RETURN_REPAIR:
        addReturnToRepair();
        break;
    case TRANSFER_REPAIR_TO_AVAILABLE:
        transferFromRepairToAvailable();
        break;
    case RENT_FIRST_AVAILABLE:
        rentFirstAvailable();
        break;
    case PRINT_LIST:
        printLists();
        break;
    default:
        printf("Invalid Transaction Code: %d\n", transCode);
        break;
    }
}

int main(int argc, char *argv[])
{
    if (readFromFile() < 0) {
        return 1;
    }
    int transCode = 0;
    while (1)
    {
        printf("1. Add a new car to the available for rent list.\n");
        printf("2. Add a returned car to the available for rent list.\n");
        printf("3. Add a returned car to the repairs list.\n");
        printf("4. Transfer repaired car to available list.\n");
        printf("5. Rent first available.\n");
        printf("6. Print list.\n");
        printf("7. Quit.\n");
        scanf("%d", &transCode);
        if (transCode == QUIT)
        {
            quitFunction();
            return 0;
        }
        processInput(transCode);
    }
}