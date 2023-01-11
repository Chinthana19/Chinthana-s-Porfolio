/*
*   Author: Chinthana Sembakutti
*   ID: 1177250
*   Date: November 14, 2022
*   Assignement 3
*/


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//structure of each node
struct Node
{
    char operator;
    int is_var;
    char var_name[64];
    float value;
    struct Node *left;
    struct Node *right;
};

//input codes
enum Codes
{
    INVALID = 0,
    DISPLAY = 1,
    PREORDER = 2,
    INORDER = 3,
    POSTORDER = 4,
    UPDATE = 5,
    CALCULATE = 6,
    EXIT = 7
};

struct Stack
{
    int top;
    unsigned capacity;
    struct Node **array;
};

struct Stack *createStack(unsigned capacity)
{
    struct Stack *newStack = (struct Stack *)malloc(sizeof(struct Stack));
    newStack->capacity = capacity;
    newStack->top = -1;
    newStack->array = (struct Node**)malloc(newStack->capacity * sizeof(struct Node*));

    return newStack;
}

int isFull(struct Stack *stack)
{
    return stack->top == stack->capacity - 1;
}

int isEmpty(struct Stack *stack)
{
    return stack->top == -1;
}

int push(struct Stack *stack, void* p)
{
    if (isFull(stack))
    {
        printf("Error: buffer full\n");
        return -1;
    }
    stack->array[++stack->top] = p;
    return 0;
}

struct Node* pop(struct Stack *stack)
{
    if (isEmpty(stack))
    {
        printf("Error: attempt to pop from empty buffer\n");
        return NULL;
    }
    return stack->array[stack->top--];
}

int find_leaf(int index, const char* expression) {

    if (expression[index] == '(') {
        index++;
        index = find_leaf(index, expression);        
    }
    return index;
}

//creates operator node
struct Node *createOpNode(int operator, struct Node *left, struct Node *right)
{
    struct Node *node = (struct Node*)malloc(sizeof(struct Node));
    memset(node, 0, sizeof(struct Node));
    node->operator = operator;
    node->left = left;
    node->right = right;
    return node;
}

//creates node that holds a value
struct Node *createValueNode(char* token)
{
    struct Node *node = (struct Node*)malloc(sizeof(struct Node));
    memset(node, 0, sizeof(struct Node));
    //in case an input of 'x1' is detected instead of an integer
    if ((token[0] < '0') || (token[0] > '9')) {
        strcpy(node->var_name, token);
        node->is_var = 1;
    } else {
        node->value = atof(token);
    }
    return node;
}
//function to print the binary expression tree. Note, some errors may persist in this operation
void treeprint(struct Node *node, int level)
{
    if (node == NULL)
        return;
        //runs until entered level is met and draws accordingly
    for (int i = 0; i < level; i++) {
        printf(i == level - 1 ? "  |--" : "    "); //conditional expression
    }
    //adding the values at the end of each branch
    if (node->is_var) {
        printf("%s[%.02f]\n", node->var_name, node->value);    
    } else if (node->operator) {
        printf("'%c'\n", node->operator);
    } else {
        printf("%.2f\n", node->value);
    }
    //in case of more children nodes, program will run until NULL, then return
    treeprint(node->left, level + 1);
    treeprint(node->right, level + 1);
}

//function call to create value node, once input has been read and processed
void addValNode(char* var_name, struct Stack *stack)
{
    struct Node *node = createValueNode(var_name);
    //pushing to stack to allow calulations to be possible, and future retrieval when needed
    push(stack, node);
}

//function call to create node with operator value
void addOpNode(int op, struct Stack *stack)
{
    //previous stack elements must be right and left children of the operator
    struct Node *right = pop(stack);
    struct Node *left = pop(stack);
    struct Node *node = createOpNode(op, left, right);
    //pushing to stack to allow for calulation/future retrieval
    push(stack, node);
}

//function to process the command line input, and store in a stack
int process(struct Stack *stack, const char* exp)
{
    int len = strlen(exp);
    char token[32];
    int token_index = 0;
    int operator = 0;
    int start = 0;
    memset(token, 0, sizeof(token));
    for (int i=0; i< len; i++) {
        //running throught the command line input, and using switch cases to 
        //process the input, and calling functions to add to stack and then creates
        //required nodes
        switch (exp[i])
        {
        case ' ':
            if (!operator) {
                token[token_index] = '\0';
                addValNode(token, stack);
            } else {
                addOpNode(operator, stack);
            }
            memset(token, 0, sizeof(token));
            token_index = 0;
            operator = 0;
            break;
        case '+':
        case '-':
        case '/':
        case '*':
            operator = exp[i];
            break;
        //in case additional quotations are entered
        case '"':
            if (start) {
                break;
            }
            ++start;
            break;
        default:
            token[token_index++] = exp[i];
            break;
        }
    }
    if (!operator) {
        token[token_index] = '\0';
        addValNode(token, stack);
    } else {
        addOpNode(operator, stack);
    }
    return 0;
}

//free memory after exiting the program
void freeMemory(struct Node *root)
{
    if (root == NULL) {
        return;
    }
    freeMemory(root->left);
    freeMemory(root->right);
    free(root);
}

//gets variable name, and the value to change to from user (will be changed in updateNode function)
int getVarnameAndValue(char* var_name, float *value) {
    printf("Enter variable and value without spaces (var_name,new_value): ");

    char line[1024];
    while (fgets(line, sizeof(line), stdin) != NULL) {
        if (strlen(line) < 2) {
            // Just a blank line. Not an error
            continue;
        }
        break;
    }
    //using tokens and strtok function to split entered variable, and entered value
    char* token = &line[0];
    char *var_str = strtok_r(token, ",", &token);
    if (var_str == NULL) {
        printf("Bad input '%s'\n", line);
        return -1;
    }

    strcpy(var_name, var_str);
    char *value_str = strtok_r(token, "\n", &token);
    if (value_str == NULL) {
        printf("Bad input '%s'\n", line);
        return -1;
    }
    //casting to float
    *value = atof(value_str);
    return 0;
}

//updating node with user input
void updateNode(struct Node *root, char* var_name, float value)
{
    if (root == NULL) {
        return;
    }
    //continues to traverse until NULL
    updateNode(root->left, var_name, value);
    updateNode(root->right, var_name, value);
    if (root->is_var && strcmp(root->var_name, var_name) == 0) {
        root->value = value;
    }
}

//performs the required calculation based on input from calling function. Returns value
float calcValue(int operator, float left, float right)
{
    switch (operator)
    {
        case '+':
            return left+right;
        case '-':
            return left-right;
        case '*':
            return left*right;
        case '/':
            if (right == 0.0) {
                printf("Error: Divide by zero\n");
                return 0;
            }
            return left/right;
    }
    return 0;
}

//calulates expression recursivley. Will continue through until end of tree
float calculateExp(struct Node *root)
{
    if (root == NULL) {
        printf("NULL\n");
        return 0.0;
    }
    if (!root->operator) {
        return root->value;
    }
    float left_value = calculateExp(root->left);
    float right_value = calculateExp(root->right);
    return calcValue(root->operator, left_value, right_value);
}

//exits the program, also frees memory
void exitFunction(struct Node *root)
{
    freeMemory(root);
}

void display(struct Node *root)
{
    treeprint(root, 0);
}

//displays the entered expression in preorder form
void preorder(struct Node *root)
{
    if (root == NULL) {
        printf("NULL\n");
        return;
    }
    //retrieving value from each node and printing, then checking if more children exist
    //and running again if true. Prints from top of tree down, with leading operator (preordering)
    if (root->is_var) {
        printf("%s[%.2f] ", root->var_name, root->value);    
    } else if (root->operator) {
        printf("%c ", root->operator);
    } else {
        printf("%.2f ", root->value);
    }    
    if (root->left) {
        preorder(root->left);
    }
    if (root->right) {
        preorder(root->right);
    }
}

//retreives data from node (starting from top of tree) and going downwards. Also adds brackets in case of operator.
//traverses down tree until last node is reached, prints in var/value, operator, var/value (inorder)
void inorder(struct Node *root)
{
    if (root == NULL) {
        printf("NULL\n");
        return;
    }
    if (root->operator) {
        printf("(");
        inorder(root->left);
    }
    if (root->is_var) {
        printf("%s[%.2f] ", root->var_name, root->value);    
    } else if (root->operator) {
        printf("%c ", root->operator);
    } else {
        printf("%.2f", root->value);
    }
    if (root->operator) {
        inorder(root->right);
        printf(")");
    }
}
//retrieving value from each node and printing, then checking if more children exist
//and running again if true. Prints from top of tree down, with  operator after variables/value (postorder)
void postorder(struct Node *root)
{
    if (root == NULL) {
        printf("NULL\n");
        return;
    }
    if (root->left) {
        postorder(root->left);
    }
    if (root->right) {
        postorder(root->right);
    }
    if (root->is_var) {
        printf("%s[%.2f] ", root->var_name, root->value);    
    } else if (root->operator) {
        printf("%c ", root->operator);
    } else {
        printf("%.2f ", root->value);
    }
}

//function to update variable given user input.
void update(struct Node *root)
{
    // Read the variable and the value
    char var_name[32];
    float value;
    //getting user input
    if (getVarnameAndValue(var_name, &value) < 0) {
        printf("Invalid input\n");
        exit(1);
    }
    //calls updateNode function to update node
    printf("var = %s, value = %.2f\n", var_name, value);
    updateNode(root, var_name, value);
}

//prints calculated value (calculation done in another function)
void calculate(struct Node *root)
{
    float value = calculateExp(root);
    printf("Calculated = %.2f\n", value);
}

//recieves user input code, calls corresponding function
void processInput(struct Node *root, int code)
{
    printf("processing input %d\n\n", code);
    switch (code)
    {
    case DISPLAY:
        display(root);
        break;
    case PREORDER:
        preorder(root);
        printf("\n");
        break;
    case INORDER:
        inorder(root);
        printf("\n");
        break;
    case POSTORDER:
        postorder(root);
        printf("\n\n");
        break;
    case UPDATE:
        update(root);
        break;
    case CALCULATE:
        calculate(root);
        break;
    default:
        printf("Invalid Transaction Code: %d\n", code);
        break;
    }
}

int main(int argc, char *argv[])
{
    //in case command line arguments entered incorectly
    if (argc != 2) {
        printf("Usage: %s <expression>\n", argv[0]);
        return 1;
    }
    char *expression = argv[1];
    int capacity = strlen(expression);

    //creating stack with capacity of expression size
    struct Stack *stack = createStack(capacity);

    process(stack, expression);

    struct Node *root = pop(stack);
    if (root == NULL) {
        printf("Expression '%s' is wrong\n", expression);
        return 0;
    }

    int code;
    while (1)
    {
        printf("1. Display.\n");
        printf("2. Preorder.\n");
        printf("3. Inorder.\n");
        printf("4. Postorder.\n");
        printf("5. Update.\n");
        printf("6. Calculate.\n");
        printf("7. Exit.\n");
        scanf("%d", &code);
        if (code == EXIT)
        {
            exitFunction(root);
            return 0;
        }
        processInput(root, code);
    }

    treeprint(root, 0);
}

// (((x1+5.12)*(x2-7.68))/x3) --->  x1 5.12 + x2 7.68 - * x3 /
//must entered with no brackets and in postfix notation.
