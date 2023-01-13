/*
 *   Author: Chinthana Sembakutti
 *   Date: October 22, 2022
 *   ID: 1177250
 *   Assignment 2
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

// stack contents
struct Stack
{
    int top;
    unsigned capacity;
    float *array;
};

// function to create a stack
struct Stack *createStack(unsigned capacity)
{
    struct Stack *newStack = (struct Stack *)malloc(sizeof(struct Stack));
    newStack->capacity = capacity;
    newStack->top = -1;
    newStack->array = (float *)malloc(newStack->capacity * sizeof(float));
    return newStack;
}

// if stack is full, returns 1 or 0
int isFull(struct Stack *stack)
{
    return stack->top == stack->capacity - 1;
}

// if stack is empty, returns 1 or 0
int isEmpty(struct Stack *stack)
{
    return stack->top == -1;
}

// pushes element into top of stack
int push(struct Stack *stack, float n)
{
    // if stack is full, error will be printed
    if (isFull(stack))
    {
        printf("Error: Stack is full\n");
        return -1;
    }
    // adding element to top of stack
    stack->array[++stack->top] = n;
    return 0;
}

// pops the top element from stack
float pop(struct Stack *stack)
{
    // if empty, error will be printed
    if (isEmpty(stack))
    {
        printf("Error: Stack is empty.\n");
        return -1;
    }
    // returns the element at the top of stack
    return stack->array[stack->top--];
}

int main(int argc, char *argv[])
{
    // if the program is run with no command line inputs, error will be printed
    if (argc < 2)
    {
        printf("Error, enter an input in the command line.\n");
        return 1;
    }
    // calculating size of stack based on user input
    int capacity = strlen(argv[1]);
    // allocating memory for inputStr
    char *inputStr = (char *)malloc(capacity);
    // copying command line data to inputStr
    strcpy(inputStr, argv[1]);

    // creating stack with size based on user input
    struct Stack *stack = createStack(capacity);

    // calculations occur in this loop. Works by reading the command line inputs, and
    // adding all integers (0-9) to the stack until an operation is read. Once an operation
    // is read, the previous 2 integers will be popped and the operation will be performed
    // on them. Then the result of the operation is pushed back into the stack, and the
    // process will continue until no more operations are present. Once there are no
    // more operations present, there will only be 1 element in the stack and this
    // will be the answer and returned.
    for (int i = 0; i < capacity; i++)
    {
        int ch = inputStr[i];
        if (ch == 0)
        {
            return 0;
        }
        if (ch >= '0' && ch <= '9')
        {
            if (push(stack, (float)(ch - '0')) < 0)
            {
                return 1;
            }
        }
        else if (ch == '*')
        {
            if (push(stack, pop(stack) * pop(stack)) < 0)
            {
                return 1;
            }
        }
        else if (ch == '+')
        {
            if (push(stack, pop(stack) + pop(stack)) < 0)
            {
                return 1;
            }
        }
        else if (ch == '-')
        {
            float value = pop(stack);
            if (push(stack, pop(stack) - value) < 0)
            {
                return 1;
            }
        }
        else if (ch == '/')
        {
            float value = pop(stack);
            if (value == 0.0)
            {
                printf("Division by 0\n");
                return 1;
            }
            if (push(stack, pop(stack) / value) < 0)
            {
                return 1;
            }
        }
        else
        {
            printf("Invalid input\n");
            return 1;
        }
    }

    // prints answer, then frees the memory the stack and string were taking up
    printf("Answer: %.02f\n", pop(stack));
    free(inputStr);
    free(stack);
}