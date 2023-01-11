/*
*   Author: Chinthana Sembakutti
*   ID: 1177250
*   Date: November 21, 2022
*   Assignement 4
*/


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//structure of each node
typedef struct HeapNode
{
    int keySum;
    int keys[3];
    int data[7];
} Node;

int arr[20][10];
Node *nodeArray[21];
int indexGlobal = 1;


//function to create a node given a row of the file
Node *createNode(int *array)
{
    Node *node = (Node *)malloc(sizeof(Node));
    node->keySum = 0;
    //calculating the key, adding 3 array elements that make up key to another array
    for (int i = 0; i < 3; i++)
    {
        node->keys[i] = array[i];
        node->keySum += array[i];
    }

    //adding remaining array elements to data array
    for (int i = 3, j = 0; i < 10; i++, j++)
    {
        node->data[j] = array[i];
    }
    return node;
}

//reads from file and stores in 2d array
int readFromFile()
{
    FILE *fp = fopen("f.dat", "r");
    if (fp == NULL)
    {
        printf("Error opening file!\n");
        return -1;
    }
    printf("Input from file:\n");
    for (int i = 0; i < 20; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            fscanf(fp, "%d ", &arr[i][j]);
            printf("%02d ", arr[i][j]);
        }
        printf("\n");
    }
    printf("\n\n");
    return 1;
}

//function to print contents of a node
void printNode(Node *node, int index)
{
    printf("(%02d): ", index);
    printf("Key = %03d: ", node->keySum);
    for (int i = 0; i < 3; i++)
    {
        printf("%02d ", node->keys[i]);
    }
    for (int i = 0; i < 7; i++)
    {
        printf("%02d ", node->data[i]);
    }
    printf("\n");
}

//function that swaps the pointers for 2 nodes to each other
void swap(Node** a, Node** b)
{
    Node* temp = *b;
    *b = *a;
    *a = temp;
}

//downheap sorting function
void heapify(int size, int idx)
{
    if (size <= 2) {
        printf("Error: Invalid input\n");
    }
    else
    {
        //setting smallest index to given index. If a child's key is found that 
        //is smaller than the parents, a swap will occur, and the function will run recursively 
        //with the new smallest index value until the smallest of the parent/right child/left child
        //is the new parent
        int smallest = idx;
        int l = 2*idx;
        int r = 2*idx + 1;      
        if (l < size && nodeArray[l]->keySum < nodeArray[smallest]->keySum) {
            smallest = l;
        }
        if (r < size && nodeArray[r]->keySum < nodeArray[smallest]->keySum) {
            smallest = r;             
        }
        if (smallest != idx)
        {
            swap(&nodeArray[idx], &nodeArray[smallest]);
            heapify(size, smallest);
        }
    }
}


//inserts node into the heap array
void insertToArray(Node *node, int index)
{
    //only for the first node in the array
    if (index == 0)
    {
        nodeArray[indexGlobal++] = node;
        return;
    }
    //runs the downheap sorting algorithm on each parent node
    nodeArray[indexGlobal++] = node;
    for(int i=indexGlobal/2; i >= 1; i--) {
        heapify(indexGlobal, i); 
    }
}


//function which creates a node based on each row of the input file, then inserts the node
//into an array of nodes
void addToArray()
{
    printf("Before Parental Node Downheap Algorithm:\n");
    for (int i = 0; i < 20; i++)
    {
        Node *node = createNode(arr[i]);
        printNode(node, i);
        insertToArray(node, i);
    }
    printf("\n");
}

int main(int argc, char *args[])
{
    readFromFile();
    addToArray();
    printf("After Parental Node Downheap Algorithm:\n");
     for (int i = 1; i < 21; i++)
    {
        printNode(nodeArray[i], i);
    }
    return 0;
}