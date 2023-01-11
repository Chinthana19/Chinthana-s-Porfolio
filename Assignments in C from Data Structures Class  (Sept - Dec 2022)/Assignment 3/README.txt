Name: Chinthana Sembakutti
ID: 1177250
Assignement 3

This program was completed using original rubric , however some minor errors may exist so marking with
the updated rubric is okay aswell.

This program takes an input from the command line. Input MUST be in postfix notation, and contain 
no brackets. Each Variable, Value or Operator must be seperated by a space.

Example: if (((x1+5.12)*(x2-7.68))/x3) was to be entered, format as such:
    x1 5.12 + x2 7.68 - * x3 /

    When entering into command line, ensure single quotes are used. Example:
    'x1 5.12 + x2 7.68 - * x3 /'

    Sample command line input:

        ./Q1.exe 'x1 5.12 + x2 7.68 - * x3 /'


Sample program output:
                            <from command line> ./Q1.exe 'x1 5.12 + x2 7.68 - * x3 /'


1. Display.
2. Preorder.
3. Inorder.
4. Postorder.
5. Update.
6. Calculate.
7. Exit.
1
processing input 1

'/'
  |--'*'
      |--'+'
          |--x1[0.00]
          |--5.12
      |--'-'
          |--x2[0.00]
          |--7.68
  |--x3[0.00]
1. Display.
2. Preorder.
3. Inorder.
4. Postorder.
5. Update.
6. Calculate.
7. Exit.
2
processing input 2

/ * + x1[0.00] 5.12 - x2[0.00] 7.68 x3[0.00]
1. Display.
2. Preorder.
3. Inorder.
4. Postorder.
5. Update.
6. Calculate.
7. Exit.
3
processing input 3

(((x1[0.00] + 5.12)* (x2[0.00] - 7.68))/ x3[0.00] )
1. Display.
2. Preorder.
3. Inorder.
4. Postorder.
5. Update.
6. Calculate.
7. Exit.
4
processing input 4

x1[0.00] 5.12 + x2[0.00] 7.68 - * x3[0.00] /

1. Display.
2. Preorder.
3. Inorder.
4. Postorder.
5. Update.
6. Calculate.
7. Exit.
7