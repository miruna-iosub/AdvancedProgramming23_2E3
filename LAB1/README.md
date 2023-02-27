Homework 

- First I read from the keyboard an integer (n) using Java Scanner, and checked if it is a positive number

- Then I initialised the running time of the application in milliseconds (long startTime = System.nanoTime();)

- I created the latinSquare matrix containing symbols from 1 to n using the formula: (i + j) % n + 1;

- Using if condition I checked if the number is bigger than 30.000, if so, I just displayed the running time

- If the number is less than 30.000, I showed on the screen the matrix resulted from creating latinSquare and the concatenation of all the symbols from each line and column at the same time

![333906613_958900425270006_8934054409688520895_n](https://user-images.githubusercontent.com/100404656/221547460-71575648-513f-4745-8aa1-66eeae95246c.png)

Bonus

- First I created the matrix for the cycle, meaning the diagonal always has the value 0 and every other cell has value 1, afterwards printing it

- Then I initialised another matrix with the same values as A (a copy of it)

- Using multiply method I found it easier to find the values of the result of A^i where i: 0 <= i <= n, representing the power of A

![329689448_737788291046072_2735087625359201417_n](https://user-images.githubusercontent.com/100404656/221576511-b2adb7a1-ac12-4f0d-a52e-04be60fe8187.png)
